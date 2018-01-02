package javaa;
import java.sql.Date;
import java.util.*;
import javaa.Beans.CustomerBean;
import javaa.Beans.EmployeeBean;
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
 * @author MATT
 */
public class AddEmployee extends HttpServlet {

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
            String dob = (String)request.getParameter("DOB");


            String un = (String)request.getParameter("username");
            int employeeid = miniLibrary.generateID("employee");
            String pw = (String)request.getParameter("password");

            String datejoined = (String)request.getParameter("datejoined");
            String role = (String)request.getParameter("role");
            String supervisorID = (String)request.getParameter("suprevisorid");
            String salary = (String)request.getParameter("salary");


            DBConnect.addEmployee(lastName,firstName,address,city,zipcode,country,dob,un,employeeid,pw,datejoined,role,supervisorID,salary);


            EmployeeBean employee = new EmployeeBean();

            employee.setId(employeeid);
            employee.setUsername(un);
            employee.setDatejoined(Date.valueOf(datejoined));
            employee.setRole(role);
            employee.setSupervisor_id(supervisorID);
            employee.setSalary(Integer.parseInt(salary));

            String url = "/EmployeeHome.jsp";

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