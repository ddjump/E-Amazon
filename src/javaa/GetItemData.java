package javaa;

import javaa.DBWorks.DBConnection;
import javaa.Beans.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetItemData extends HttpServlet {

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

            /* TODO output your page here. You may use following sample code. */

            DBConnection DBConnect = new DBConnection();
            DBConnect.connectDB();

            String itemid = (String) request.getParameter("item");
            ResultSet rs = DBConnect.searchItem((itemid));
            ResultSet rs2 = DBConnect.searchItem((itemid));


            ItemBean item = new ItemBean();
            while(rs2.next()) {
                item.setArticleid(rs2.getInt("Article_ID"));
            }

            if(item.getArticleid() != 0){

            while (rs.next()) {
                item.setPrice(rs.getFloat("Price"));
                item.setSeller(rs.getString("Seller"));
                item.setItemname(rs.getString("Name_Of_Item"));
                item.setCategory(rs.getString("Category"));
                item.setDesciption(rs.getString("Description"));
                item.setQuantity(rs.getInt("Quantity"));
                item.setArticleid(rs.getInt("Article_ID"));
            }


            HttpSession sess = request.getSession(false);
            sess.setAttribute("eitem", item);
            sess.setAttribute("bool", false);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/DisplayItemData.jsp");
            dispatcher.forward(request, response);
        }
            else{
            HttpSession sess = request.getSession(false);
            sess.setAttribute("bool", true);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/EmployeeEditItem.jsp");
            dispatcher.forward(request, response);
        }

        } catch (ClassNotFoundException ex) {
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