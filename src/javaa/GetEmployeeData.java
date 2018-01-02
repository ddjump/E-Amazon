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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetEmployeeData extends HttpServlet {

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

            HttpSession sess = request.getSession(false);
            EmployeeBean eb = (EmployeeBean) sess.getAttribute("employee");

            if(eb.getRole().equals("manager")) {

                String employee_id = request.getParameter("employeeid");
                ResultSet rs = DBConnect.searchEmployee(employee_id);
                EmployeeBean employee = new EmployeeBean();

                while (rs.next()) {
                    employee.setUsername(rs.getString("Employee_User_Name"));
                    employee.setPassword(rs.getString("Employee_Pass_Word"));
                    employee.setId(rs.getInt("Employee_ID"));
                    employee.setDatejoined(Date.valueOf(rs.getString("Date_Joined")));
                    employee.setRole(rs.getString("Role"));
                    employee.setSupervisor_id(rs.getString("Suprevisor_ID"));
                    employee.setSalary(rs.getInt("Salary"));
                }


                PersonBean person = new PersonBean();
                rs = DBConnect.searchPerson(employee_id);

                while (rs.next()) {
                    person.setAddress(rs.getString("Address"));
                    person.setCity(rs.getString("City"));
                    person.setCountry(rs.getString("Country"));
                    person.setDob(rs.getString("Dob"));
                    person.setFirstname(rs.getString("First_name"));
                    person.setLastname(rs.getString("Last_name"));
                    person.setZipcode(rs.getString("Zip_Code"));
                    person.setPerson_id(rs.getInt("Person_ID"));
                }


                sess = request.getSession(false);
                sess.setAttribute("p", person);
                sess.setAttribute("e", employee);
                sess.setAttribute("bool", false);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/BossSearchEmployee.jsp");
                dispatcher.forward(request, response);

            }
            else {
                     sess = request.getSession(false);
                    sess.setAttribute("bool", true);
                    RequestDispatcher dispatcher
                            = request.getRequestDispatcher("/getEmployee.jsp");
                    dispatcher.forward(request, response);



            }
            // ELSE DISPLAY AN PERMISSION ERROR





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