/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import DataAcess.DataAcess;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
/**
 *
 * @author sajja
 */
public class Frontend {
    private final static String clientInv_PREFFIX = "BK_INV_";
    private final static String BILL_PREFFIX = "BK_BILL_";
    private final static String supplierInv_PREFFIX = "BK_SUP_INV_";
    private final static String DN_PREFFIX = "BK_DN_";
    private final static String PO_PREFFIX = "BK_PO_";
    private final static String PICKUP_PREFFIX = "BK_PB_";
    private final static String LABOUR_PREFFIX = "BK_LB_";
    private final static int SUFFIX_LENGTH = 4;
    private final static Locale LOCALE = new Locale("en_001", "AE");;
    private DataAcess da;
    public Frontend(){
        da = new DataAcess();
    }
    
    public static String currency_Format(String amount){
        double number = Double.valueOf(amount);
        NumberFormat format = NumberFormat.getCurrencyInstance(LOCALE);
        
        String currency = format.format(number);
//        System.out.println("Currency in UAE : " + currency);
        return currency;
    }
     public static String getCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy");  
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    
    public String getBillNo(){
        int id = da.getBillNo();
        System.out.println("FRONTEND: BillNO: " + id);
        int count = backend.intLength(id);
        String invNo = BILL_PREFFIX;
        if (id < 0) {    
            JOptionPane.showMessageDialog(null, "Problem getting Invoice Number");
        }
        else{
            for(int i = 0; i< (SUFFIX_LENGTH-count); i++ ){
                invNo = invNo.concat("0");
            }
            invNo =  invNo.concat(String.valueOf(id));
            return invNo;
        }
        return String.valueOf(id);
    }
    public String getLabourBillNo(){
        int id = da.getLabourBillNo();
        System.out.println("FRONTEND: PB BillNO: " + id);
        int count = backend.intLength(id);
        String invNo = LABOUR_PREFFIX;
        if (id < 0) {    
            JOptionPane.showMessageDialog(null, "Problem getting LabourBill Number");
        }
        else{
            for(int i = 0; i< (SUFFIX_LENGTH-count); i++ ){
                invNo = invNo.concat("0");
            }
            invNo =  invNo.concat(String.valueOf(id));
            return invNo;
        }
        return String.valueOf(id);
    }
    public String getPickupBillNo(){
        int id = da.getPickupBillNo();
        System.out.println("FRONTEND: PB BillNO: " + id);
        int count = backend.intLength(id);
        String invNo = PICKUP_PREFFIX;
        if (id < 0) {    
            JOptionPane.showMessageDialog(null, "Problem getting PickupBill Number");
        }
        else{
            for(int i = 0; i< (SUFFIX_LENGTH-count); i++ ){
                invNo = invNo.concat("0");
            }
            invNo =  invNo.concat(String.valueOf(id));
            return invNo;
        }
        return String.valueOf(id);
    }
    public String getClientInvoiceNo(){
        int id = da.getClientInvoiceNo();
        System.out.println("FRONTEND: invNO: " + id);
        int count = backend.intLength(id);
        String invNo = clientInv_PREFFIX;
        if (id < 0) {    
            JOptionPane.showMessageDialog(null, "Problem getting Invoice Number");
        }
        else{
            for(int i = 0; i< (SUFFIX_LENGTH-count); i++ ){
                invNo = invNo.concat("0");
            }
            invNo =  invNo.concat(String.valueOf(id));
            return invNo;
        }
        return String.valueOf(id);
    }
    public static String getSupplierInvoiceNo(){
//        int id = DataAcess.getSupplierInvoiceNo();
        int id = 1;
        int count = backend.intLength(id);
        String invNo = supplierInv_PREFFIX;
        for(int i = 0; i< (4-count); i++ ){
            invNo = invNo.concat("0");
        }
        invNo =  invNo.concat(String.valueOf(id));
        return invNo;
    }
    
    public static String DecimalFormat(double input){
        String deci = String.format("%.2f", input);
        return deci;
    }
    
    
    
    public static String getDnFormat(){
        return DN_PREFFIX;
    }
    public static String getPoFormat(){
        return PO_PREFFIX;
    }
    public static void onlyDoubleField(java.awt.event.KeyEvent evt){
        char c=evt.getKeyChar();
//        String str = "" ;
        if(Character.isLetter(c)&&!evt.isAltDown()){
            evt.consume();
//            str += evt.getKeyChar();
        }
//        ValidateDouble(str);
    }
    public static void onlyIntField(java.awt.event.KeyEvent evt){
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }
    public static String ValidateDouble(String str){
        try {
            Double.valueOf(str);
            return str;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return "0";
        }
    }
}
