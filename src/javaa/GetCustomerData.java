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

public class GetCustomerData extends HttpServlet {

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

            String customer_id = (String)request.getParameter("Customer_ID");
            ResultSet rs = DBConnect.searchCustomer(customer_id);

            CustomerBean customer = new CustomerBean();
            while (rs.next())
            {
                customer.setId(rs.getInt("Customer_Id"));
                customer.setPassword(rs.getString("Pass_Word"));
                customer.setUsername(rs.getString("User_name"));
                customer.setEmail(rs.getString("Email"));
            }


            PersonBean person = new PersonBean();
            rs = DBConnect.searchPerson(customer_id);

            if(customer.getId() != 0 ) {
                while (rs.next() && customer.getId() != 0) {
                    person.setAddress(rs.getString("Address"));
                    person.setCity(rs.getString("City"));
                    person.setCountry(rs.getString("Country"));
                    person.setDob(rs.getString("Dob"));
                    person.setFirstname(rs.getString("First_name"));
                    person.setLastname(rs.getString("Last_name"));
                    person.setZipcode(rs.getString("Zip_Code"));
                    person.setPerson_id(rs.getInt("Person_ID"));
                }

                HttpSession sess = request.getSession(false);
                sess.setAttribute("p", person);
                sess.setAttribute("c", customer);
                sess.setAttribute("bool",false);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/BossSearchCustomer.jsp");
                dispatcher.forward(request, response);
            }
            else{
                HttpSession sess = request.getSession(false);
                sess.setAttribute("bool", true);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/getCustomer.jsp");
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