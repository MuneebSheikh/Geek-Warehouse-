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
public class ChequeDetails {

    // ******************** ATTRIBUTES **************************
    
    private String _chequeNumber;
    private String _issuedTo;
    private String _date;
    private String _ammount;
    private String _details;
    private String _billNo;
    
    
    // *************** CONSTRUCTORS *******************************************
    public ChequeDetails() {}
    public ChequeDetails(String _chequeNumber, String _issuedTo, String _date, String _ammount, String _details) {
        this._chequeNumber = _chequeNumber;
        this._issuedTo = _issuedTo;
        this._date = _date;
        this._ammount = _ammount;
        this._details = _details;
    }
    
    //************* GETTER AND SETTER ***************************
    
    public String getBillNo() {    
        return _billNo;
    }

    public void setBillNo(String _billNo) {
        this._billNo = _billNo;
    }

    public String getChequeNumber() {
        return _chequeNumber;
    }

    public void setChequeNumber(String _chequeNumber) {
        this._chequeNumber = _chequeNumber;
    }

    public String getIssuedTo() {
        return _issuedTo;
    }

    public void setIssuedTo(String _issuedTo) {
        this._issuedTo = _issuedTo;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String _date) {
        this._date = _date;
    }

    public String getAmmount() {
        return _ammount;
    }

    public void setAmmount(String _ammount) {
        this._ammount = _ammount;
    }

    public String getDetails() {
        return _details;
    }

    public void setDetails(String _details) {
        this._details = _details;
    }    
}
