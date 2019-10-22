package businesslogic;

/**
 *
 * @author sajja
 */
public class Bill {

    private String _billNo;
    private String _invoiceNo;
    private String _companyName;
    private String _yourName;
    private String _date;
    private String _balance;
    private String _ammount;
    private String _paymentMethod;
    private ChequeDetails chequeDetails;
    private BankDetails bankDetails;
    private int _paymentFlag = -1;
    
    public Bill(){
        
    }
    public Bill(String _billNo, String _invoiceNo, String _companyName, String _yourName, String _date, String _balance, String _ammount, String _paymentMethod) {
        this._billNo = _billNo;
        this._invoiceNo = _invoiceNo;
        this._companyName = _companyName;
        this._yourName = _yourName;
        this._date = _date;
        this._balance = _balance;
        this._ammount = _ammount;
        this._paymentMethod = _paymentMethod;
        
    }

    public Bill(String _billNo, String _invoiceNo, String _companyName, String _yourName, String _date, String _balance, String _ammount, String _paymentMethod, ChequeDetails chequeDetails) {
        this._billNo = _billNo;
        this._invoiceNo = _invoiceNo;
        this._companyName = _companyName;
        this._yourName = _yourName;
        this._date = _date;
        this._balance = _balance;
        this._ammount = _ammount;
        this._paymentMethod = _paymentMethod;
        this.chequeDetails = chequeDetails;
        this._paymentFlag = 0; 
    }

    public Bill(String _billNo, String _invoiceNo, String _companyName, String _yourName, String _date, String _balance, String _ammount, String _paymentMethod, BankDetails bankDetails) {
        this._billNo = _billNo;
        this._invoiceNo = _invoiceNo;
        this._companyName = _companyName;
        this._yourName = _yourName;
        this._date = _date;
        this._balance = _balance;
        this._ammount = _ammount;
        this._paymentMethod = _paymentMethod;
        this.bankDetails = bankDetails;
        this._paymentFlag = 1;
    }

    public Bill(String nString, String nString0, String nString1, String nString2, String nString3, String nString4, String nString5, ChequeDetails c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getBillNo() {
        return _billNo;
    }

    public void setBillNo(String _billNo) {
        this._billNo = _billNo;
    }

    public String getInvoiceNo() {
        return _invoiceNo;
    }

    public void setInvoiceNo(String _invoiceNo) {
        this._invoiceNo = _invoiceNo;
    }

    public String getCompanyName() {
        return _companyName;
    }

    public void setCompanyName(String _personName) {
        this._companyName = _personName;
    }

    public String getYourName() {
        return _yourName;
    }

    public void setYourName(String _yourName) {
        this._yourName = _yourName;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String _date) {
        this._date = _date;
    }

    public String getBalance() {
        return _balance;
    }

    public void setBalance(String _balance) {
        this._balance = _balance;
    }

    public String getAmmount() {
        return _ammount;
    }

    public void setAmmount(String _ammount) {
        this._ammount = _ammount;
    }

    public String getPaymentMethod() {
        return _paymentMethod;
    }

    public void setPaymentMethod(String _paymentMethod) {
        this._paymentMethod = _paymentMethod;
        if(this._paymentMethod == "Cash" || this._paymentMethod == "cash"){
            this._paymentFlag = -1;
        }
        else if(this._paymentMethod == "Cheque" || this._paymentMethod == "cheque"){
            this._paymentFlag = 0;
        }
        else{
            this._paymentFlag = 1;
        }
    }

    public ChequeDetails getChequeDetails() {
        return chequeDetails;
    }

    public void setChequeDetails(ChequeDetails chequeDetails) {
        this.chequeDetails = chequeDetails;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }
    

    
    
}
