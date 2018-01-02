package javaa;

import javaa.Beans.ItemBean;
import javaa.DBWorks.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.*;
import java.util.*;

/**
 *
 * @author Reagan
 */
public class AddToCart extends HttpServlet {

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

        try{

        HttpSession sess = request.getSession(false);

        ArrayList<ItemBean> sc = (ArrayList<ItemBean>)sess.getAttribute("shoppingcart");



        ItemBean item = new ItemBean();

        DBConnection DBConnect = new DBConnection();
        DBConnect.connectDB();

        ResultSet rs = DBConnect.searchItem(request.getParameter("item"));

        while(rs.next()){
            item.setQuantity(rs.getInt("Quantity"));
            System.out.println(item.getQuantity());
            item.setDesciption(rs.getString("Description"));
            item.setCategory(rs.getString("Category"));
            item.setItemname(rs.getString("Name_Of_Item"));
            item.setSeller(rs.getString("Seller"));
            item.setArticleid(rs.getInt("Article_ID"));
            item.setPrice(rs.getFloat("Price"));
        }

        sc.add(item);

        sess.setAttribute("shoppingcart",sc);

        float total_price = 0;
        for(int i = 0 ; i < sc.size(); i++)
        {
            total_price += sc.get(i).getPrice();
        }

        sess.setAttribute("totalprice",total_price);


            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/ViewAllItems.jsp");
            dispatcher.forward(request, response);

        }

        catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
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