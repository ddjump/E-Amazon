package javaa;

import javaa.DBWorks.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.*;

/**
 *
 * @author MATT
 */
public class DeleteItem extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCustomer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCustomer at " + request.getContextPath() + "</h1>");
            out.println("<h1>first name " + request.getParameter("lastName")+ "</h1>");
            out.println("</body>");
            out.println("</html>");

            DBConnection DBConnect = new DBConnection();
            DBConnect.connectDB();

            DBConnect.deleteItem(request.getParameter("itemId"));

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/EmployeeHome.jsp");
            dispatcher.forward(request, response);
            //Article_ID, Seller,Name_Of_Item, Category, Description, Price, Quantity

        } catch (ClassNotFoundException ex) {
            //  Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
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

//
//            System.out.println("IM HERE~~~~~~~~~~~");
//            DBConnect.addCustomer(lastName,firstName,email,billing_address,dob,userName);
        // DBConnect.addCustomer(zip, city, state, SSN, lastName, firstName, address, phoneNumber, email, creditCardNumber, date, accountType, userName, userPassword);


//
//            if(zip == null)
//                processRequest(request, response);


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