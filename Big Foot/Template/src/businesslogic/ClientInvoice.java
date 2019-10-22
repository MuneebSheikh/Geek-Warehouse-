package businesslogic;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import Validation.Frontend;
import java.util.Objects;
/**
 *
 * @author sajja
 */
public class ClientInvoice {

    private String  _invoiceNo;
    private String _date;
    private String _VAT;
//    private String _personName;
    private String _companyName;
    private String _companyTRN;
    private String _TRN;
    private String _address;
    private String _termsAndConditions;
    private String _pickupService;
    private String _labourService;
    private String _DnNumber;
    private String _PoNumber;
    private LinkedList<Product> prods = new LinkedList<Product>();

    private String _status;
    private String _balance;
    private String _costAmount;
    private String _costDetails;
    private String _netTotal;
    private String _grandTotal;
    private String _charges;

    private String _profit = "0";
    private String _owner1 = "0";
    private String _owner2 = "0";
    private String _owner3 = "0";
    private String _owner4 = "0";
    
    public ClientInvoice (){
        
    }
    public ClientInvoice(String _invoiceNo, String _date, String _VAT, String _companyName, 
            String _TRN, String _address, String _termsAndConditions, String _pickupService, String _labourService, 
            String _status, String _balance, String _costAmount, String _costDetails, String _netTotal, 
            String _grandTotal, String _charges) {
        this._invoiceNo = _invoiceNo;
        this._date = _date;
        this._VAT = _VAT;
//        this._personName = _personName;
        this._companyName = _companyName;
        this._TRN = _TRN;
        this._address = _address;
        this._termsAndConditions = _termsAndConditions;
        this._pickupService = _pickupService;
        this._labourService = _labourService;
        this._status = _status;
        this._balance = _balance;
        this._costAmount = _costAmount;
        this._costDetails = _costDetails;
        this._netTotal = _netTotal;
        this._grandTotal = _grandTotal;
        this._charges = _charges;
//         if (Double.valueOf(this._balance) > Double.valueOf(this._grandTotal)) {
//            this._balance = this._grandTotal;
//        }
    }
   
    public ClientInvoice(String _invoiceNo, String _VAT, String _date,String _netTotal, String _companyName, 
            String _TRN, String _address, String _costDetails, String _pickupService,String _costAmount,String _charges, String _labourService, 
            String _status,String _grandTotal, String _balance, String _termsAndConditions,
              String _DnNumber, String _PoNumber, String _companyTRN) {
        this._invoiceNo = _invoiceNo;
        this._date = _date;
        this._VAT = _VAT;
//        this._personName = _personName;
        this._companyName = _companyName;
        this._TRN = _TRN;
        this._address = _address;
        this._termsAndConditions = _termsAndConditions;
        this._pickupService = _pickupService;
        this._labourService = _labourService;
        this._status = _status;
        this._balance = _balance;
        this._costAmount = _costAmount;
        this._costDetails = _costDetails;
        this._netTotal = _netTotal;
        this._grandTotal = _grandTotal;
        this._charges = _charges;
        this._DnNumber = _DnNumber;
        this._PoNumber = _PoNumber;
        this._companyTRN = _companyTRN;
//        if (Double.valueOf(this._balance) > Double.valueOf(this._grandTotal)) {
//            this._balance = this._grandTotal;
//        }
    }
    //
    // **** SETTER ****
    //

    public void setCompanyTRN(String _companyTRN) {
        this._companyTRN = _companyTRN;
    }
    
    public void setDnNumber(String _DnNumber) {
        this._DnNumber = _DnNumber;
    }

    public void setPoNumber(String _PrNumber) {
        this._PoNumber = _PrNumber;
    }

    public void setProfit(String _profit) {
        this._profit = _profit;
    }

    public void setOwners(String _owner1, String _owner2, String _owner3, String _owner4){
        this._owner1 = _owner1;
        this._owner2 = _owner2;
        this._owner3 = _owner3;
        this._owner4 = _owner4;
    }
    
    public void setProfit(){
        try{
            float bal =  Float.valueOf(getBalance());
            float cost = Float.valueOf(getCostAmount());
            float grandTotal = Float.valueOf(getGrandTotal());
            float amount = grandTotal - bal;
            float profit = amount - cost;
            if (profit < 0) {
                profit = 0;
            }
            this._profit = String.valueOf(Frontend.DecimalFormat(profit));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void setOwnersProfit(){
        double profit = Double.valueOf(getProfit());
        double owner1 = (profit * 0.3);
        double owner2 =  (profit * 0.3);
        double owner3 = (profit * 0.2);
        double company =  (profit * 0.2);
         _owner1 = String.valueOf(Frontend.DecimalFormat(owner1));
        _owner2 =  String.valueOf(Frontend.DecimalFormat(owner2));
        _owner3 = String.valueOf(Frontend.DecimalFormat(owner3));
        _owner4 =  String.valueOf(Frontend.DecimalFormat(company));
        
    }
        
    public void setInvoiceNo(String _invoiceNo) {
        this._invoiceNo = _invoiceNo;
    }

    public void setDate(String _date) {
        this._date = _date;
    }

    public void setVAT(String _VAT) {
        this._VAT = _VAT;
    }

//    public void setPersonName(String _personName) {
//        this._personName = _personName;
//    }

    public void setCompanyName(String _companyName) {
        this._companyName = _companyName;
    }

    public void setTRN(String _TRN) {
        this._TRN = _TRN;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public void setTermsAndConditions(String _termsAndConditions) {
        this._termsAndConditions = _termsAndConditions;
    }

    public void setPickupService(String _pickupService) {
        this._pickupService = _pickupService;
    }

    public void setLabourService(String _labourService) {
        this._labourService = _labourService;
    }

    public void setProds(LinkedList<Product> prods) {
        this.prods = prods;
    }
    
    public void setStatus(){
        if (Objects.equals(Double.valueOf(_balance), Double.valueOf(_grandTotal))) {
            this._status = "unpaid";
        }
        else if(Double.valueOf(_balance) <= 0){
            this._status = "paid";
        }
        else{
            this._status = "partially paid";
        }
    }
    public void setStatus(String _status) {
        this._status = _status;
    }

    public void setBalance(String _balance) {
        this._balance = _balance;
        if (Double.valueOf(this._balance) > Double.valueOf(getGrandTotal())) {
            this._balance = getGrandTotal();
        }
        setStatus();
    }

    public void setCostAmount(String _costAmount) {
        this._costAmount = _costAmount;
    }

    public void setCostDetails(String _costDetails) {
        this._costDetails = _costDetails;
    }

    public void setNetTotal(String _netTotal) {
        this._netTotal = _netTotal;
    }

    public void setGrandTotal(String _grandTotal) {
        this._grandTotal = _grandTotal;
    }

    public void setCharges(String _charges) {
        this._charges = _charges;
    }
    
    //
    // **** GETTER ****
    //
    
    public String getOwner1(){    
        return _owner1;
    }

    public String getOwner2() {
        return _owner2;
    }

    public String getOwner3() {
        return _owner3;
    }
    
    public String getOwner4() {
        return _owner4;
    }    

    public String getCompanyTRN() {
        return _companyTRN;
    }

    public String getDnNumber() {
        return _DnNumber;
    }

    public String getPoNumber() {
        return _PoNumber;
    }

    public String getProfit() {
        return _profit;
    }
    public String getInvoiceNo() {
        return _invoiceNo;
    }

    public String getDate() {
        return _date;
    }

    public String getVAT() {
        return _VAT;
    }

//    public String getPersonName() {
//        return _personName;
//    }

    public String getCompanyName() {
        return _companyName;
    }

    public String getTRN() {
        return _TRN;
    }

    public String getAddress() {
        return _address;
    }

    public String getTermsAndConditions() {
        return _termsAndConditions;
    }

    public String getPickupService() {
        return _pickupService;
    }

    public String getLabourService() {
        return _labourService;
    }

    public LinkedList<Product> getProds() {
        return prods;
    }

    public String getStatus() {
        return _status;
    }

    public String getBalance() {
        return Frontend.DecimalFormat(Double.valueOf(_balance));
    }

    public String getCostAmount() {
        return Frontend.DecimalFormat(Double.valueOf(_costAmount));
    }

    public String getCostDetails() {
        return _costDetails;
    }

    public String getNetTotal() {
        return _netTotal;
    }

    public String getGrandTotal() {
        return _grandTotal;
    }

    public String getCharges() {
        return _charges;
    }





    
}
