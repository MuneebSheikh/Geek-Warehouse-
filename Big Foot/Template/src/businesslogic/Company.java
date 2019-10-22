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
public class Company {

    private String _companyName;
    private String _bankName;
    private String _branchName;
    private String _accountTitle;
    private String _accountNumber;
    private String _IBAN;

    public Company() {
        this._bankName = "RAK Bank";
        this._branchName = "King Faisal Street Branch";
        this._accountTitle = "BIGFOOT KONCEPTS LLC";
        this._accountNumber = "0242697546001";
        this._IBAN = "AE130400000242697546001";
    }

    public String getCompanyName() {
        return _companyName;
    }

    public String getBankName() {
        return _bankName;
    }

    public String getBranchName() {
        return _branchName;
    }

    public String getAccountTitle() {
        return _accountTitle;
    }

    public String getAccountNumber() {
        return _accountNumber;
    }

    public String getIBAN() {
        return _IBAN;
    }
    
}
