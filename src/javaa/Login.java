package javaa;

import javaa.Beans.CustomerBean;
import javaa.Beans.EmployeeBean;
import javaa.Beans.ItemBean;
import javaa.Beans.PersonBean;
import javaa.DBWorks.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.logging.*;
import javax.servlet.http.HttpSession;

import static java.util.logging.Logger.*;

/**
 *
 * @author Reagan
 */
public class Login extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */


            DBConnection DBConnect = new DBConnection();
            DBConnect.connectDB();

            String u = request.getParameter("uname");
            String p = request.getParameter("psw");

            String []result = DBConnect.Login(u, p);

            // check if its a employee or customer


            //String url = "/Home.jsp";



            if(result[1].equals("customer")){

                ResultSet rs = DBConnect.searchCustomer(result[0]);

                CustomerBean customer = new CustomerBean();
                while(rs.next()) {
                    customer.setId(rs.getInt("Customer_Id"));
                    customer.setPassword(rs.getString("Pass_Word"));
                    customer.setUsername(rs.getString("User_name"));
                    customer.setEmail(rs.getString("Email"));
                }

                rs = DBConnect.searchPerson(result[0]);
                PersonBean person = new PersonBean();
                while(rs.next()){
                    person.setAddress(rs.getString("Address"));
                    person.setCity(rs.getString("City"));
                    person.setCountry(rs.getString("Country"));
                    person.setDob(rs.getString("Dob"));
                    person.setFirstname(rs.getString("First_name"));
                    person.setLastname(rs.getString("Last_name"));
                    person.setZipcode(rs.getString("Zip_Code"));
                    person.setPerson_id(Integer.parseInt(result[0]));
                }

                HttpSession sess = request.getSession();
                ArrayList<ItemBean> sc = new ArrayList<ItemBean>();
                sess.setAttribute("shoppingcart",sc);
                sess.setAttribute("person",person);
                sess.setAttribute("customer",customer);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/Home.jsp");
                dispatcher.forward(request, response);
            }
            else if(result[1].equals("employee")){
                ResultSet rs = DBConnect.searchEmployee(result[0]);

                EmployeeBean employee = new EmployeeBean();
                while(rs.next()) {
                    employee.setId(rs.getInt("Employee_ID"));
                    employee.setUsername(rs.getString("Employee_User_Name"));
                    employee.setPassword(rs.getString("Employee_Pass_Word"));
                    employee.setDatejoined(rs.getDate("Date_Joined"));
                    employee.setRole(rs.getString("Role"));
                    employee.setSupervisor_id(rs.getString("Suprevisor_ID"));
                    employee.setSalary(rs.getInt("Salary"));
                }


                rs = DBConnect.searchPerson(result[0]);
                PersonBean person = new PersonBean();
                while(rs.next()){
                    person.setAddress(rs.getString("Address"));
                    person.setCity(rs.getString("City"));
                    person.setCountry(rs.getString("Country"));
                    person.setDob(rs.getString("Dob"));
                    person.setFirstname(rs.getString("First_name"));
                    person.setLastname(rs.getString("Last_name"));
                    person.setZipcode(rs.getString("Zip_Code"));
                    person.setPerson_id(Integer.parseInt(result[0]));
                }

                HttpSession sess = request.getSession();
                sess.setAttribute("person",person);
                sess.setAttribute("employee",employee);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/EmployeeHome.jsp");
                dispatcher.forward(request, response);



            }
            else {


                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/LoginPage.jsp");
                dispatcher.forward(request, response);
            }


        }
//Customer_ID, User_name, Pass_Word

        //Article_ID, Seller,Name_Of_Item, Category, Description, Price, Quantity
        catch (ClassNotFoundException ex) {
            getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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
    }
}