/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;
import DataAcess.DataAcess;
import Validation.Frontend;
import java.util.Calendar;
import Validation.backend;
/**
 *
 * @author sajja
 */
public class Finance {
 
    DataAcess dataAcess;
    backend validation;
    
    private String _azherProfit, _rameezProfit, _investorProfit, _companyProfit;
    private String _profit;
//    String[] totals = new String[3]; // cost, grandtotal, balance
    double[] totals = new double[3]; // cost, grandtotal, balance
    
    
    
    public Finance() {
     this.dataAcess = new DataAcess();
     this.validation = new backend();
     this.totals = dataAcess.get_totalsFinance();
     setProfit();
     setAllOwnersProfit();
//        for (int i = 0; i < tot.length; i++) {
//            totals[i] = String.valueOf(Frontend.DecimalFormat(tot[i]));
//        }
    }

    public String getTotalCost(){
        return String.valueOf(totals[0]);
    }
    public String getTotalSales(){
        String totSales = String.valueOf(totals[1] - totals[2]);
        return totSales;
    }
    public String getAzherProfit() {
        return _azherProfit;
    }

    public void setAzherProfit(String _azherProfit) {
        this._azherProfit = _azherProfit;
    }

    public String getRameezProfit() {
        return _rameezProfit;
    }

    public void setRameezProfit(String _rameezProfit) {
        this._rameezProfit = _rameezProfit;
    }

    public String getCompanyProfit() {
        return _companyProfit;
    }

    public void setCompanyProfit(String _companyProfit) {
        this._companyProfit = _companyProfit;
    }

    public String getInvestorProfit() {
        return _investorProfit;
    }

    public void setInvestorProfit(String _investorProfit) {
        this._investorProfit = _investorProfit;
    }

    public String getProfit() {
        setProfit();
        return _profit;
    }
    
    private void setProfit(){
        double rem = this.totals[1] - this.totals[2];
        double profit = rem - this.totals[0];
        this._profit = String.valueOf(Frontend.DecimalFormat(profit));
    }
    
    public void setAllOwnersProfit(){
        double profit = Double.valueOf(_profit);
        double owner1 = (double) (profit * 0.3);
        double owner2 = (double) (profit * 0.3);
        double owner3 = (double) (profit * 0.2);
        double company = (double) (profit * 0.2);
        
        _azherProfit = String.valueOf(owner1);
        _rameezProfit = String.valueOf(owner2);
        _investorProfit = String.valueOf(owner3);
        _companyProfit = String.valueOf(company);        
    }
    
    private static String getNetProfit(String monthNo){
        String _monthNo = monthNo;
        if (monthNo.equalsIgnoreCase("current")) {
            Calendar cal = Calendar.getInstance();
            int currentMonth = cal.get(Calendar.MONTH) + 1;
            _monthNo = String.valueOf(currentMonth);
            
//            System.out.println("Current Month is : " + (cal.get(Calendar.MONTH) + 1));
        }
        else if(!monthNo.equalsIgnoreCase("current")){
//            return "invalid month";
        }
        
        return "";
// get all the net profit from database
    
    }

    private void getProfitShare(String monthNo){
        String _monthNo = monthNo;
        if (monthNo.equalsIgnoreCase("current")) {
            Calendar cal = Calendar.getInstance();
            int currentMonth = cal.get(Calendar.MONTH) + 1;
            _monthNo = String.valueOf(currentMonth);
            
//            System.out.println("Current Month is : " + (cal.get(Calendar.MONTH) + 1));
        }
        else if(!validation.isInteger(monthNo)){
                
//            return "invalid month";
                
        }
        
        
        
        String profit_str = getNetProfit(monthNo);
        float profit = Float.valueOf(profit_str);
        
        String petty_cash_str = getPettyCash();
        float petty_cash = Float.valueOf(petty_cash_str);
        
        
        float owner1 = (float) (profit * 0.3);
        float owner2 = (float) (profit * 0.3);
        float owner3 = (float) (profit * 0.2);
        float company = (float) (profit * 0.2) - petty_cash;
        
        float totalProfit = owner1 + owner2 + owner3 + company + petty_cash;
        float netProfit = owner1 + owner2 + owner3 + company;
        
        String[] profitShare = {"1"};
        
    }
    
    /// ISKI MAYBE ZARORAT NA PARE...... YE KAAM getProfitShare() SE HOJAEGA
//    public static void setProfitShare(float profit, float petty_cash){
//    
//        float owner1 = (float) (profit * 0.3);
//        float owner2 = (float) (profit * 0.3);
//        float owner3 = (float) (profit * 0.2);
//        float company = (float) (profit * 0.2) - petty_cash;
//        
//        float totalProfit = owner1 + owner2 + owner3 + company + petty_cash;
//        float netProfit = owner1 + owner2 + owner3 + company;
//        
//        
//        
//        // save the profit in databse
//        // 
//        //
//        //return bool
//        
//    }
    
    public static void getTodayExpenses(){}
    
    public static void getDebts(){}
    
    public static void getBadDepts(){}
    
    public static String getPettyCash(){
    
        // return total amount of petty cash
        //
        // return float
        return "";
    }
    
    public static void getTotalExpenses(){
            
        //get total amount of expences
        //return float
    
    }
    
    public static void addPettyCash(float ammount, String desc){
    
    // save ammout and desc in database
    
    }
    
    
}