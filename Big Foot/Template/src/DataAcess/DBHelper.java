/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcess;

import businesslogic.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sajja
 * 
 */
public class DBHelper{

    
   final private String DATABASE_NAME = "";
   private Connection conn;
   private Statement stmt;
   public DBHelper(){
//        conn = connectDb();
//        try {
//            if (conn != null) {
//                stmt = conn.createStatement();
//                System.out.println("stmt created ");
//            }
//        } catch (Exception e) {
//            System.err.print("db Exception: "+e);
//        }
    }
    
    public void connect() {
//        conn = null;
        
        try {
            // db parameters
            if (conn != null){
                conn.close();
            }
            String url = "jdbc:sqlite:bigfoot.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (conn != null) {
                    stmt = conn.createStatement();
                }
            } catch (SQLException ex) {
                System.out.println("finnaly: "+ex);
            }
        }
    }

   
   
    private static Connection connectDb(){
//        try {
////            thin:@localhost:1521:orcl
//            Class.forName("oracle.jdbc.OracleDriver");
//            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:expdb.dbf:1521:orcl", "geek", "geek");
//            System.out.println("Connection Successfull");
//            if (conn == null) {
//                System.out.println("conn is null");
//            }
//            return conn;
//        
//        } catch (Exception e) {
//            System.err.println("conn Exception: " + e);
//        }
//        
        return null;
    }
    public String[] getSumColBill(String tableName,String idCol ,String valCol ,String ...colNames){
//        LinkedList<Bill> bills = new LinkedList<>();
        connect();
//        String[] tot = new String[colNames.length];
        ResultSet rs = getSumCol(tableName, idCol, valCol, colNames);
        try {
            while (rs.next()) {
                
            }
        } catch (Exception e) {
            System.err.println("DBHelper->Exception: " + e);
        }
        return null;
    }
     public ResultSet getSumAllCol(String tableName ,String ...colNames){
        try{
            connect();
            System.out.println("Number of Colomns: " + colNames.length);
            System.out.println("Selecting Data...");
            String cols = "", query = "";
            System.out.println(colNames.length);
            
//... if No of columns is 0 return all columns

            //using for each loop to display colNames

            for(String colName : colNames){
                System.out.println("col Name: " + colName);
                // here concate all the colnames in one string variable for query
                cols = cols.concat("sum("+colName + "),");
            }
            // remove the last ,(comma) from the string
            cols = cols.substring(0, cols.length()-1);

//            query = "SELECT "+ colNames[0] +" FROM "+ tableName + " where "+ colNames[0] +" = (select max("+ colNames[0] +") from "+tableName+")";
            if ("\0".equals(colNames[0])) {
                query = "SELECT * FROM " + tableName ;
                 // SELECT * FROM TABLE
                
            }
            else{
                query = "SELECT " + cols + " FROM "+ tableName ;
                // SELECT + 'cols' + FROM TABLE
                
            }
            
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            return rs;
            // run querries here
            // return all the required data in resultSet
        }
        catch(Exception e){
            System.err.println("DbHelper->Exception:" + e);
        }
        return null;
        
    }
    public ResultSet getSumCol(String tableName,String idCol ,String valCol ,String ...colNames){
        try{
            connect();
            System.out.println("Number of Colomns: " + colNames.length);
            System.out.println("Selecting Data...");
            String cols = "", query = "";
            System.out.println(colNames.length);
            
//... if No of columns is 0 return all columns

            //using for each loop to display colNames

            for(String colName : colNames){
                System.out.println("col Name: " + colName);
                // here concate all the colnames in one string variable for query
                cols = cols.concat("sum("+colName + "),");
            }
            // remove the last ,(comma) from the string
            cols = cols.substring(0, cols.length()-1);

//            query = "SELECT "+ colNames[0] +" FROM "+ tableName + " where "+ colNames[0] +" = (select max("+ colNames[0] +") from "+tableName+")";
            if ("\0".equals(colNames[0])) {
                query = "SELECT * FROM " + tableName +" WHERE " +idCol + " = " + valCol;
                 // SELECT * FROM TABLE
                
            }
            else{
                query = "SELECT " + cols + " FROM "+ tableName +" WHERE " +idCol + " = " + valCol;
                // SELECT + 'cols' + FROM TABLE
                
            }
            
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            return rs;
            // run querries here
            // return all the required data in resultSet
        }
        catch(Exception e){
            System.err.println("DbHelper->Exception: " + e);
        }
        return null;
        
    }
    public ResultSet getColumnData(String tableName, String ...colNames){
        try{
            connect();
            System.out.println("Number of Colomns: " + colNames.length);
            System.out.println("Selecting Data...");
            String cols = "", query = "";
            System.out.println(colNames.length);

            for(String colName : colNames){
                System.out.println("col Name: " + colName);
                // here concate all the colnames in one string variable for query
                cols = cols.concat(colName + ",");
            }
            // remove the last ,(comma) from the string
            cols = cols.substring(0, cols.length()-1);
//            query = "SELECT "+ colNames[0] +" FROM "+ tableName + " where "+ colNames[0] +" = (select max("+ colNames[0] +") from "+tableName+")";
            if ("\0".equals(colNames[0])) {
                query = "SELECT rowid,* FROM " + tableName;
            }
            else{
                query = "SELECT " + cols + " FROM "+ tableName;
            }
            
            System.out.println(query);
            if(stmt == null){
                System.err.println("rss is null");
            }
            if(conn == null){
                System.err.println("asdas is null");
            }
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            return rs;
        }
        catch(Exception e){
            System.err.println("DbHelper->Exception: lalsa" + e);
        }
        return null;
        
    }
    public ResultSet getAllData(String tableName, String ...colNames){
        try{
            connect();
            System.out.println("Number of Colomns: " + colNames.length);
            System.out.println("Selecting Data...");
            String cols = "", query = "";
            System.out.println(colNames.length);
            for(String colName : colNames){
                System.out.println("col Name: " + colName);
                cols = cols.concat(colName + ",");
            }
            cols = cols.substring(0, cols.length()-1);

            if ("\0".equals(colNames[0])) {
                query = "SELECT rowid, * FROM " + tableName;
            }
            else{
                query = "SELECT " + cols + " FROM "+ tableName;
            }
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            return rs;
            
        }
        catch(Exception e){
            System.err.println("DbHelper->Exception: " + e);
        }
        return null;
    }
    
    public void insertData(String tableName, String ...values){
        try {
            connect();
            System.out.println("Number of Colomns: " + values.length);
            System.out.println("Inserting Data...");

            String cols_values = "(";
            for(String value : values){
                System.out.println("value: " + value);
                // here concate all the colnames in one string variable for query
                cols_values = cols_values.concat("'"+value +"'"+ ",");
            }
            // remove the last ,(comma) from the string
            cols_values = cols_values.substring(0, cols_values.length()-1);
            cols_values = cols_values.concat(")");

            String query = "INSERT INTO " +tableName+" VALUES "+cols_values;
            System.out.println(query);
            int st = stmt.executeUpdate(query);

            // if query is executed.
            if (st>0) {
                System.out.println("Data Successfully inserted");
                //return true
            }
            else{
                System.out.println("Data Failed to insert");
            //return false
            }
        } catch (Exception e) {
            System.err.println("DbHelper->Exception: "+e);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
//                    Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                        System.err.println("DBHelper->Exception: " +ex);
                }
            }
        }
    }
    
    
    public void updateData(String tableName,String idCol,String idVal, String ...values){
        try {
            connect();
            int count = values.length;
            System.out.println(String.valueOf(count));
            LinkedList<String> cols = new LinkedList<>();
            LinkedList<String> vals = new LinkedList<>();
            String query = "UPDATE " + tableName + " SET ";
            int i = 0;
            for (String value: values) {
                if (i%2 == 0) {
                    cols.add(value);
                }
                else{
                    vals.add(value);
                }
                System.out.println(value);
                i++;
            }
            for (int j = 0; j < cols.size(); j++) {
                 query = query.concat(cols.get(j) + " = '" + vals.get(j) + "',");
            }
            query = query.substring(0, query.length()-1);
            String whereClause = " WHERE "+ idCol + " = '" + idVal+ "'";
            query = query.concat(whereClause);
            System.out.println(query);
            int st = stmt.executeUpdate(query);
            // if query is executed.
            if (st>0) {
                System.out.println("Data Successfully Updated");
                //return true
            }
            else{
                System.out.println("Data Failed to update");
            //return false
            }
            
        } catch (Exception e) {
            System.out.println("DbHelper->Exception: "+e);
        }
    }
    
    public boolean deleteData(String tableName, String idCol, String val){
        try {
            connect();
            String query = "DELETE FROM " + tableName + " WHERE " + idCol + " = '" + val +"'";
            System.out.println(query);
            int i = stmt.executeUpdate(query);
            // if query is executed.
            if (i>0) {
                System.out.println("Data Successfully Deleted");
                return true;
            }
            else{
                System.out.println("Data Failed to Delete");
            return false;
            }
        } catch (Exception e) {
            System.err.println("DbHelper->Exception: "+e);
            return false;
        }
        
    }

    public ResultSet getColLastValue(String tableName, String ...colNames) {
        try {
            connect();
            System.out.println("Number of Colomns: " + colNames.length);
            System.out.println("Selecting Data...");
            String cols = "";
            
            //... if No of columns is 0 return all columns

            //using for each loop to display colNames

            String query = "";
            if (colNames.length == 0) {
                 // SELECT * FROM TABLE
                query = "SELECT TOP 1 * FROM "+ tableName + " ORDER BY ID DESC";
                System.out.println(query);
               // ResultSet rs = stmt.executeQuery(query);
            }
            else if (colNames.length == 1){
                
                query = "SELECT "+ colNames[0] +" FROM "+ tableName + " where "+ colNames[0] +" = (select max("+ colNames[0] +") from "+tableName+")";
                System.out.println(query);
                 ResultSet rs = stmt.executeQuery(query);
            }
            else{
                for(String colName : colNames){
                    System.out.println("col Name: " + colName);
                    // here concate all the colnames in one string variable for query
                    cols = cols.concat(colName + ",");
                }
                // remove the last ,(comma) from the string
                cols = cols.substring(0, cols.length()-1);

                query = "SELECT "+ cols  +" FROM "+ tableName + " where "+ cols +" = (select max( "+ cols +" ) from "+tableName ;
                
                // SELECT + 'cols' + FROM TABLE
            }
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.err.println("DbHelper->Exception: " + e);
        }
        return null;
    }
   
    public ResultSet getAllValues(String tableName, String colName){
        try {
            connect();
        ResultSet rs = stmt.executeQuery("Select " +colName+ " From " + tableName);
        if(rs.first()){
            return rs;
        }
            
        } catch (Exception e) {
            System.err.println("DbHelper->Exception: "+e);
        }
        return null;
    }
    
    public int getlastID(String tableName){
        try {
            connect();
            String query = "SELECT rowid FROM " + tableName + 
                    " WHERE rowid = (SELECT MAX(rowid) FROM "+tableName+")";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                int id = Integer.valueOf(rs.getString("rowid"));
                System.out.println("DbHELER: invNO: " + id);
                return id;                    
            }
            else{
                System.out.println("DbHELPER: invNO: null"  );
                return 0;
            }
        } catch (SQLException | NumberFormatException e) {
            System.err.println("DbHelper->Exception: " + e);
        }
        return -1;
    }
    
    public LinkedList<Product> getProds (String invoiceNo){    
    LinkedList<Product> prods = new LinkedList<>();
//    ResultSet rs = db.getAllData("PRODUCT","\0");
    try {
        connect();
        ResultSet rs = stmt.executeQuery("SELECT rowid,* FROM PRODUCT WHERE P_INVOICENO = '"+invoiceNo+"'");
        while(rs.next())
        {
//            paymentMethod = rs.getNString("BN_PAYMENTMETHOD");
            Product p = new Product(rs.getString("P_NAME"), rs.getString("P_COST"), rs.getString("P_QUANTITY")
                    , rs.getString("P_DESC"));
            prods.add(p);
        }
        return prods;
    } catch (Exception e) {
        System.err.println("DbHelper->Exception: "+e);
    }
    return null;
}
    
    public ResultSet getAllData(String tableName, String idCol, String idVal){
        try {
            connect();
            String query = "SELECT * FROM "+ tableName + " WHERE " + idCol + " = '" + idVal+"'";
            ResultSet rs = stmt.executeQuery(query);
            
            return rs;
            
        } catch (Exception e) {
            System.err.println("DbHelper->Exception: "+e);
        }
        return null;
    }
}
