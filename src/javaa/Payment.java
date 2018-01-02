package javaa;

import javaa.DBWorks.DBConnection;
import javaa.Beans.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.beancontext.BeanContextMembershipEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Payment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            DBConnection DBConnect = new DBConnection();
            DBConnect.connectDB();

            HttpSession sess = request.getSession(false);
            ArrayList<ItemBean> sc = (ArrayList)sess.getAttribute("shoppingcart");

//            float total_price = 0;
//            for(int i = 0 ; i < sc.size(); i++)
//            {
//                total_price += sc.get(i).getPrice();
//            }

            //Display Total Price in some field
            // When you call checkout in the customercart.jsp
            // calculate the total price using the code above and store it onto the session
            // then ask for Shipment table

            // after you press the 'buy' button you need to update tables to show that quantity of item is updated

            int count = 0;
            boolean check = true;
            for(int i = 0 ; i < sc.size();i++)
            {
                int itemid = sc.get(i).getArticleid();
                for(int j = 0 ; j < sc.size();j++)
                {
                    if(sc.get(j).getArticleid()== itemid)
                    {
                        count++;
                    }
                }
                if(sc.get(i).getQuantity() < count){
                    check = false;
                    break;
                }
                check = true;
                count = 0;

            }
            if(check == true){
                for(int i = 0 ; i < sc.size(); i++)
                {
                    DBConnect.BuyItem(sc.get(i).getArticleid(),sc.get(i).getQuantity());

                }


                String cardHolderName = request.getParameter("name");
                String cardNumber = request.getParameter("cardnumber");
                String cardExpDate = request.getParameter("cardexpdate");
                int paymentid = (miniLibrary.generateID("payment"));

                DBConnect.addPayment(cardHolderName,cardNumber,cardExpDate,paymentid);

                int shippingfee = 0;
                CustomerBean c = (CustomerBean)sess.getAttribute("customer");
                int id = c.getId();
                String typeofshipment = (String)request.getParameter("shippingtype");
                String misc = (String)request.getParameter("misc");
                String shippingaddress = (String)request.getParameter("shippingaddress");

                if (shippingaddress.contains("One") || shippingaddress.contains("one")){
                    shippingfee = 5;
                }else{
                    shippingfee = 3;
                }
                int shipmentid = miniLibrary.generateID("shipment");


                DBConnect.addShipment(id,typeofshipment,misc,shippingaddress,shippingfee,shipmentid);


                        RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/Home.jsp");
                dispatcher.forward(request, response);

            }
            else{

                //PAYMENT FAILED NOT ENOUGH ITEMS
            }





        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}