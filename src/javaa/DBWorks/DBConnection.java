package javaa.DBWorks;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import javaa.miniLibrary;
import sun.lwawt.macosx.CImage;

import java.sql.*;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DBConnection {

    private Connection conn;

    public DBConnection() {

        conn = null;
    }

    public boolean valid(HttpServletRequest request) throws ClassNotFoundException, SQLException {

        if (connectDB() == false) {
            return false;
        }
        //if (request.getParameter("name").isEmpty()) {
        //return false;
        //}
        return true;
    }

    public boolean connectDB() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/amazon";
        String username = "root";
        String password = "DanChina123";
        boolean result = true;

        Properties info = new Properties( );
        info.put( "user", username );
        info.put( "password", password );

        try {
            //conn = (Connection) DriverManager.getConnection(url, username, password);
            conn = DriverManager.getConnection(url, info);
            result = true;
        } catch (SQLException ex) {

            result = false;
        }
        return result;
    }

    public ResultSet queryAllCustomers() throws SQLException {

        Statement stmt = null;
        stmt = conn.createStatement();

        String sql = "SELECT * FROM Customer";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public ResultSet queryAllItems() throws SQLException {

        Statement stmt = null;
        stmt = conn.createStatement();

        String sql = "SELECT * FROM Item";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }


    public boolean addCustomer(String fn,String ln, String dob, String address, String city, String zipcode, String Country, int pid,
                               String un, String pw, String email) throws SQLException {
        try {

            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO PERSON (First_name,Last_name,Dob,Address,City,Zip_Code,Country,Person_ID)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?,?)");

            stmt.setString(1,fn);
            stmt.setString(2,ln);
            stmt.setString(3,dob);
            stmt.setString(4,address);
            stmt.setString(5,city);
            stmt.setString(6,zipcode);
            stmt.setString(7,Country);
            stmt.setInt(8,pid);

            stmt.executeUpdate();

            stmt = conn.prepareStatement("INSERT INTO CUSTOMER (Customer_ID,Email,User_name,Pass_word) " +
                    " VALUES(?, ? , ?, ?)");

            stmt.setInt(1,pid);
            stmt.setString(2,email);
            stmt.setString(3,un);
            stmt.setString(4,pw);

            stmt.executeUpdate();

            return true;

        }catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean addPayment(String cardholdername, String cardnumber, String cardexpdate, int paymentid){

        try {


            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO PAYMENTS (Card_Exp_Date,Card_Holder_Name,Card_Number,Payment_ID)" +
                    " VALUES(?,?,?,?)");

            stmt.setDate(1,Date.valueOf(cardexpdate));
            stmt.setString(2,cardholdername);
            stmt.setString(3,cardnumber);
            stmt.setInt(4,paymentid);
            stmt.executeUpdate();

            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
    public boolean addItem(String articleId, String seller, String nameItem, String category, String description, String price, String quantity) throws SQLException {
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO ITEM (Article_ID, Seller,Name_Of_Item, Category, Description, Price, Quantity)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?)");



            stmt.setInt(1, Integer.parseInt(articleId));
            stmt.setString(2, seller);
            stmt.setString(3, nameItem);
            stmt.setString(4, category);
            stmt.setString(5, description);
            stmt.setFloat(6, Float.parseFloat(price));
            stmt.setInt(7, Integer.parseInt(quantity));

            stmt.executeUpdate();


            return true;




        }catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean addEmployee(String ln, String fn, String address, String city, String zipcode, String country, String dob, String un,
                               int employeeID, String pw, String datejoined, String role, String supervisorid, String salary){
        try {


            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO PERSON (First_name,Last_name,Dob,Address,City,Zip_Code,Country,Person_ID)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?,?)");

            stmt.setString(1,fn);
            stmt.setString(2,ln);
            stmt.setString(3,dob);
            stmt.setString(4,address);
            stmt.setString(5,city);
            stmt.setString(6,zipcode);
            stmt.setString(7,country);
            stmt.setInt(8,(employeeID));
            stmt.executeUpdate();




            stmt = conn.prepareStatement("INSERT INTO EMPLOYEE(Employee_User_Name,Employee_Pass_Word,Employee_ID,Date_Joined,Role, Suprevisor_ID,Salary)" +
                    " VALUES (?, ?,?,?,?,?,?)");

            stmt.setString(1,un);
            stmt.setString(2,pw);
            stmt.setInt(3,(employeeID));
            stmt.setDate(4, Date.valueOf(datejoined));
            stmt.setString(5,role);
            stmt.setString(6,supervisorid);
            stmt.setInt(7,Integer.parseInt(salary));
            stmt.executeUpdate();



            return true;


        }catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean deleteItem(String articleId) throws SQLException {
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("DELETE FROM Item " +
                    "WHERE Article_Id=" + Integer.parseInt(articleId));
            stmt.executeUpdate();
            return true;

        }catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteEmployee(String employee_id) throws SQLException{
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE Employee_ID = " + employee_id);
            stmt.executeUpdate();

            stmt = conn.prepareStatement("DELETE FROM PERSON WHERE Person_ID = "+ employee_id);
            stmt.executeUpdate();


            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ResultSet searchCustomer(String Customer_ID) throws SQLException{
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE Customer_ID = " + Customer_ID);
            return(stmt.executeQuery());

        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet searchEmployee(String Employee_Id) throws SQLException{
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE Employee_ID = " + Employee_Id);
            return(stmt.executeQuery());

        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public ResultSet searchPerson(String Person_ID) throws SQLException{
        try{
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM PERSON WHERE Person_ID = " + Person_ID);
            return(stmt.executeQuery());
        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ResultSet searchItem(String Item_ID) throws SQLException{
        try{
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM ITEM WHERE Article_ID = " + Item_ID);
            return(stmt.executeQuery());
        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean editItem(String articleid, String seller, String nameofitem, String category, String desc, String price, String quantity){
        try{
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement("UPDATE ITEM SET "+
                    "Article_ID = ?, Seller = ?, Name_Of_Item = ?, Category = ?, Description = ?, Price = ?, Quantity = ? WHERE Article_ID = " + articleid);

            stmt.setString(1,articleid);
            stmt.setString(2,seller);
            stmt.setString(3,nameofitem);
            stmt.setString(4,category);
            stmt.setString(5,desc);
            stmt.setFloat(6,Float.parseFloat(price));
            stmt.setInt(7,Integer.parseInt(quantity));
            stmt.executeUpdate();


            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean bossEditEmployee(String un,String pw, int id, int salary, Date date, String role, String superid,
                                String zip, String ln,String fn, String dob, String country, String city, String address){
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("UPDATE EMPLOYEE SET Employee_User_Name = ?, Employee_Pass_Word = ?,Employee_ID = ?," +
                    "Date_Joined = ?,Role = ?, Suprevisor_ID = ?, Salary = ? WHERE Employee_ID = " + id);

            stmt.setString(1,un);
            stmt.setString(2,pw);
            stmt.setInt(3,id);
            stmt.setDate(4,date);
            stmt.setString(5,role);
            stmt.setString(6,superid);
            stmt.setInt(7,salary);
            stmt.executeUpdate();

            stmt = conn.prepareStatement("UPDATE PERSON SET First_name = ?, Last_name = ?, Dob = ?, Address = ?, City = ?, Zip_Code = ?" +
                    ", Country = ?, Person_ID = ? WHERE Person_ID = "+ id);

            stmt.setString(1,fn);
            stmt.setString(2,ln);
            stmt.setString(3,dob);
            stmt.setString(4,address);
            stmt.setString(5, city);
            stmt.setString(6,zip);
            stmt.setString(7,country);
            stmt.setInt(8,id);
            stmt.executeUpdate();

            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean editCustomer(String fn,String ln, String dob, String address, String city, String zipcode, String Country, int id,
                                String un, String pw, String email){
        try{
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement("UPDATE CUSTOMER SET Email = ?, User_name = ?, Pass_word = ? WHERE Customer_ID = ?");

            stmt.setString(1,email);
            stmt.setString(2,un);
            stmt.setString(3,pw);
            stmt.setInt(4, id);
            stmt.executeUpdate();

            stmt = conn.prepareStatement("UPDATE PERSON SET "+
                        "First_name = ?, Last_name = ?, Dob = ?, Address = ?, City = ?, Zip_Code = ?, Country = ? WHERE Person_ID = ?");

            stmt.setString(1,fn);
            stmt.setString(2,ln);
            stmt.setString(3,dob);
            stmt.setString(4,address);
            stmt.setString(5,city);
            stmt.setString(6,zipcode);
            stmt.setString(7,Country);
            stmt.setInt(8, id);
            stmt.executeUpdate();

            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public void editEmployee(String fn,String ln, String dob, String address, String city, String zipcode, String Country, int id,
                                String un, String pw, String suprevisorid){
        try{
            PreparedStatement stmt = null;

            //stmt = conn.prepareStatement("UPDATE CUSTOMER Set " +
            //" Email = ?, User_name = ?, Pass_word = ? ");

            stmt = conn.prepareStatement("UPDATE EMPLOYEE SET Employee_User_Name = ?, Employee_Pass_Word = ?, Employee_ID = ?, Suprevisor_ID = ?" +
                    " WHERE Employee_ID = ?");

            stmt.setString(1,un);
            stmt.setString(2,pw);
            stmt.setInt(3, id);
            stmt.setString(4, suprevisorid);
            stmt.setInt(5, id);
            stmt.executeUpdate();

            stmt = conn.prepareStatement("UPDATE PERSON SET "+
                    "First_name = ?, Last_name = ?, Dob = ?, Address = ?, City = ?, Zip_Code = ?, Country = ? WHERE Person_ID = ?");

            stmt.setString(1,fn);
            stmt.setString(2,ln);
            stmt.setString(3,dob);
            stmt.setString(4,address);
            stmt.setString(5,city);
            stmt.setString(6,zipcode);
            stmt.setString(7,Country);
            stmt.setInt(8, id);
            stmt.executeUpdate();

        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public String[] Login(String user, String pass) throws SQLException {

        try {

            String[] array = new String[2];
            Statement stmt = null;
            stmt = conn.createStatement();

            String sql = "SELECT Customer_ID, User_name, Pass_Word" + " FROM CUSTOMER";
            ResultSet result = stmt.executeQuery(sql);
            String returnMe = "";
            while (result.next()) {
                String username = result.getString("User_name");
                String password = result.getString("Pass_word");

                if (username.equals(user)) {
                    if (password.equals(pass)) {
                        array[0] = result.getInt("Customer_ID") + "";
                        array[1] = "customer";
                        return array;
                    }
                }
            }


            sql = "SELECT Employee_ID, Employee_User_name, Employee_Pass_Word" + " FROM EMPLOYEE";
            result = stmt.executeQuery(sql);
            while (result.next()) {
                String username = result.getString("Employee_User_name");
                String password = result.getString("Employee_Pass_Word");

                if (username.equals(user)) {
                    if (password.equals(pass)) {
                        array[0] = result.getInt("Employee_ID") + "";
                        array[1] = "employee";
                        return array;
                    }
                }
            }
            array[0] = "error";
            array[1] = "error";
            return array;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            String[] array = new String[2];
            array[0] = "error";
            array[1] = "error";
            return array;
        }
    }



    public boolean addShipment(int id, String typeofshipment,String misc ,String shippingaddress, int shippingfee, int shipmentid)
    {
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO SHIPMENT (Person_ID, Type_Of_Shipment,Misc, Shipping_Address, Shipping_Fee, Shipment_ID)"
                    + " VALUES(?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, id);
            stmt.setString(2, typeofshipment);
            stmt.setString(3, misc);
            stmt.setString(4, shippingaddress);
            stmt.setInt(5, shippingfee);
            stmt.setInt(6, shipmentid);
            stmt.executeUpdate();

            return true;


        }catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean BuyItem(int id,int quantity){
        try{
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("UPDATE ITEM SET "+
                    "Quantity = ? WHERE Article_ID = " + id);
            if(quantity-1 > 0) {
                stmt.setInt(1, quantity - 1);
                stmt.executeUpdate();
                return true;
            }
            else{
                return false;
            }

        }
        catch(SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    // close the connection to the DB
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


