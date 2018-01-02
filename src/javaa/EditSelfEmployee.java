package javaa;

import javaa.Beans.CustomerBean;
import javaa.DBWorks.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.*;
import javaa.DBWorks.DBConnection;
import javaa.Beans.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditSelfEmployee extends HttpServlet {

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

            String employee_id = (String)request.getParameter("employeeid");
            ResultSet rs = DBConnect.searchCustomer(employee_id);

            HttpSession sess = request.getSession(false);
            EmployeeBean eb = (EmployeeBean)sess.getAttribute("employee");


            String employeeid = request.getParameter("employeeid");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String dob = request.getParameter("dob");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String zipcode = request.getParameter("zipcode");
            String country = request.getParameter("country");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String datejoined = request.getParameter("datejoined");
            String role = request.getParameter("role");
            String suprevisorid = request.getParameter("suprevisorid");
            String salary = ""+(eb.getSalary());

            DBConnect.editEmployee(firstname,lastname,dob,address,city,zipcode,country,Integer.parseInt(employeeid),username,password, suprevisorid);

            EmployeeBean employee = new EmployeeBean();
            employee.setUsername(username);
            employee.setPassword(password);
            employee.setId(Integer.parseInt(employeeid));
            employee.setDatejoined(java.sql.Date.valueOf(datejoined));
            employee.setRole(role);
            employee.setSupervisor_id(suprevisorid);
            employee.setSalary(Integer.parseInt(salary));

            PersonBean person = new PersonBean();
            person.setPerson_id(Integer.parseInt(employeeid));
            person.setZipcode(zipcode);
            person.setLastname(lastname);
            person.setFirstname(firstname);
            person.setDob(dob);
            person.setCountry(country);
            person.setCity(city);
            person.setAddress(address);

            sess = request.getSession(false);
            sess.setAttribute("employee",employee);
            sess.setAttribute("person",person);

            String url = "/EmployeeHome.jsp";

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);


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