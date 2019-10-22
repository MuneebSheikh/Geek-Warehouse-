/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

/**
 *
 * @author sajja
 */
public class Pickup {

    // ****************** ATTRIBUTES *************************
    private String _billno;
    private String _companyName;
    private String _email;
    private String _phone;
    private String _locationOfPickup;
    private String _typeOfPackage;
    private String _locationOfDrop;
    private String _invoiceNo;
    private String _amount;
    private String _date;

    
    //****************** CONSTRUCTORS ****************************
    public Pickup(){
    }
    public Pickup(String _billno, String _invoiceNo, String _companyName, String _email, String _phone, 
            String _locationOfPickup, String _typeOfPackage, String _locationOfDrop,  String _amount, String _date) {
        this._billno = _billno;
        this._companyName = _companyName;
        this._email = _email;
        this._phone = _phone;
        this._locationOfPickup = _locationOfPickup;
        this._typeOfPackage = _typeOfPackage;
        this._locationOfDrop = _locationOfDrop;
        this._invoiceNo = _invoiceNo;
        this._amount = _amount;
        this._date = _date;
    }
   
    
    //************* GETTER AND SETTER ***************************
    
    public String getBillno() {
        return _billno;
    }

    public void setBillno(String _billno) {
        this._billno = _billno;
    }

    public String getInvoiceNo() {
        return _invoiceNo;
    }

    public void setInvoiceNo(String _invoiceNo) {
        this._invoiceNo = _invoiceNo;
    }

    public String getAmount() {
        return _amount;
    }

    public void setAmount(String _amount) {
        this._amount = _amount;
    }

    public String getDate() {
        return _date;
    }

    
    public void setDate(String _date) {
        this._date = _date;
    }

    public String getCompanyName() {
        return _companyName;
    }

    public void setCompanyName(String _companyName) {
        this._companyName = _companyName;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String _phone) {
        this._phone = _phone;
    }

    public String getLocationOfPickup() {
        return _locationOfPickup;
    }

    public void setLocationOfPickup(String _locationOfPickup) {
        this._locationOfPickup = _locationOfPickup;
    }

    public String getTypeOfPackage() {
        return _typeOfPackage;
    }

    public void setTypeOfPackage(String _typeOfPackage) {
        this._typeOfPackage = _typeOfPackage;
    }

    public String getLocationOfDrop() {
        return _locationOfDrop;
    }

    public void setLocationOfDrop(String _locationOfDrop) {
        this._locationOfDrop = _locationOfDrop;
    }
    
    
}
