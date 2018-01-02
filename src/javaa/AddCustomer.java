package javaa;

import javaa.Beans.CustomerBean;
import javaa.DBWorks.*;
import sun.misc.Request;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.logging.*;

/**
 *
 * @author Reagan
 */
public class AddCustomer extends HttpServlet {

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

            String lastName = (String)request.getParameter("lastName");
            String firstName = (String)request.getParameter("firstName");
            String address = (String)request.getParameter("address");
            String city = (String)request.getParameter("city");
            String zipcode = (String)request.getParameter("zipcode");
            String country = (String)request.getParameter("country");
            String email = (String)request.getParameter("email");
            String dob = (String)request.getParameter("DOB");
            String un = (String)request.getParameter("username");
            int customerId = miniLibrary.generateID("customer");
            String pw = (String)request.getParameter("password");


            DBConnect.addCustomer(firstName,lastName,dob,address,city,zipcode,country,customerId,un,pw,email);


            CustomerBean customer = new CustomerBean();
            customer.setId(customerId);
            customer.setEmail(email);
            customer.setUsername(un);
            customer.setPassword(pw);

            ArrayList customerList = new ArrayList();
            customerList.add(customer);

            request.setAttribute("c", customer);

            String url = "/LoginPage.jsp";

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);


            DBConnect.close();


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        //PrintWriter out = response.getWriter();
        //out.println("<p>" + request.getParameter("lastName") + "<p>");
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