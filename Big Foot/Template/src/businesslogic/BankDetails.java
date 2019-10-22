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
public class BankDetails {
    
    private String _bankName;
    private String _branch;
    private String _accountTitle;
    private String _accountNumber;
    private String _IBAN;
    private String _billNo;
    
    // *************** CONSTRUCTORS *******************************************

    public BankDetails(String _bankName, String _branch, String _accountTitle, String _accountNumber, String _IBAN) {
        this._bankName = _bankName;
        this._branch = _branch;
        this._accountTitle = _accountTitle;
        this._accountNumber = _accountNumber;
        this._IBAN = _IBAN;
    }

    //************* GETTER AND SETTER ***************************
    
    public String getBillNo() {    
        return _billNo;
    }

    public void setBillNo(String _billNo) {
        this._billNo = _billNo;
    }

    public String getBankName() {
        return _bankName;
    }

    public void setBankName(String _bankName) {
        this._bankName = _bankName;
    }

    public String getBranch() {
        return _branch;
    }

    public void setBranch(String _branch) {
        this._branch = _branch;
    }

    public String getAccountTitle() {
        return _accountTitle;
    }

    public void setAccountTitle(String _accountTitle) {
        this._accountTitle = _accountTitle;
    }

    public String getAccountNumber() {
        return _accountNumber;
    }

    public void setAccountNumber(String _accountNumber) {
        this._accountNumber = _accountNumber;
    }

    public String getIBAN() {
        return _IBAN;
    }

    public void setIBAN(String _IBAN) {
        this._IBAN = _IBAN;
    }
    
    
    
    
    
}
