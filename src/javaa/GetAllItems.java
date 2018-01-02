package javaa;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


/**
 *
 * @author MATT
 */
public class GetAllItems extends HttpServlet {

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
            out.println("<title>Servlet QueryAllCustomers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QueryAllCustomers at " + request.getSession().getAttribute("userName") + request.getSession().getAttribute("password")+ "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            DBConnection DBConnect = new DBConnection();
            if (DBConnect.connectDB() == false) {
                processRequest(request, response);
            }
            ResultSet rs = null;

            rs = DBConnect.queryAllItems();

            ArrayList<ItemBean> resultList = new ArrayList();
            while (rs.next()) {
                ItemBean item = new ItemBean();

                item.setArticleid(rs.getInt("Article_ID"));
                item.setSeller(rs.getString("Seller"));
                item.setItemname(rs.getString("Name_Of_Item"));
                item.setCategory(rs.getString("Category"));
                item.setDesciption(rs.getString("Description"));
                item.setPrice(rs.getFloat("Price"));
                item.setQuantity(rs.getInt("Quantity"));

                resultList.add(item);
            }

            HttpSession sess = request.getSession(false);
            sess.setAttribute("i",resultList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewAllItems.jsp");
            dispatcher.forward(request, response);
            DBConnect.close();



        } catch (SQLException ex) {
//            Logger.getLogger(SearchResult.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SearchResult.class.getName()).log(Level.SEVERE, null, ex);
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
        //try {
//            DBConnection DBConnect = new DBConnection();
//            if (DBConnect.connectDB() == false) {
//                processRequest(request, response);
//            }
//            ResultSet rs = null;
//
//            rs = DBConnect.queryAllItems();
//
//            ArrayList resultList = new ArrayList();
//            while (rs.next()) {
//                ItemBean item = new ItemBean();
//                item.setArticleid(rs.getString("Article_ID"));
//                item.setSeller(rs.getString("Seller"));
//                item.setItemname(rs.getString("Name_Of_Item"));
//                item.setCategory(rs.getString("Category"));
//                item.setDesciption(rs.getString("Description"));
//                item.setPrice(rs.getFloat("Price"));
//                item.setQuantity(rs.getInt("Quantity"));
//            }
//
//            HttpSession sess = request.getSession();
//            sess.setAttribute("items",resultList);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/TestAllItems.jsp");
//            dispatcher.forward(request, response);
//            DBConnect.close();
//
//            String url = "EmployeeHomePage.jsp";
//
//            RequestDispatcher dispatcher
//                    = request.getRequestDispatcher(url);
//
//            dispatcher.forward(request, response);
//            //processRequest(request, response);

//        } catch (SQLException ex) {
////            Logger.getLogger(SearchResult.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
////            Logger.getLogger(SearchResult.class.getName()).log(Level.SEVERE, null, ex);
//        }

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