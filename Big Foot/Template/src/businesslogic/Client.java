/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic;

import java.util.*;

/**
 *
 * @author sajja
 */
public class Client {
    // ************************ ATTRIBUTES ********************************
    private String _companyName;
    private String _phone;
    private String _address;
    private String _email;
    private String _TRN;
    private String _VAT;
    private float _debt;
    private float _badDept;
    
    //******************** CONSTRUCTORS *****************************
    
    public Client(){}

    public Client(String _companyName, String _phone, String _address, String _email, String _TRN, String _VAT) {
        this._companyName = _companyName;
        this._phone = _phone;
        this._address = _address;
        this._email = _email;
        this._TRN = _TRN;
        this._VAT = _VAT;
    }
    
//    public Client(String name, String phone, String address, String TRN) {
//        this._companyName = name;
//        this._phone = phone;
//        this._address = address;
//        this._TRN = TRN;
//    }
//    public Client(String name, int phone, String address, String TRN, ArrayList<Product> prods) {
//        this._companyName = name;
//        this._phone = phone;
//        this._address = address;
//        this._TRN = TRN;
//        this.prods = prods;
//    }
    
    // **************** METHODS *************************
    
//    public void addReciept(ArrayList<Product> prods)
//    {
//        this.prods = prods;
//        // store it in data base 
//    }
    public void addReciept()
    {
        // store it in data base 
    }    
    
    public void getAllRecieptNos(){}
    
    public void getReciept(int recieptNo){}
    
    
    
    
    //************* GETTER AND SETTER ***************************
    
    public String getCompanyName() {
        return _companyName;
    }

    public void setCompanyName(String _companyName) {
        this._companyName = _companyName;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String _phone) {
        this._phone = _phone;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getTRN() {
        return _TRN;
    }

    public void setTRN(String _TRN) {
        this._TRN = _TRN;
    }

    public String getVAT() {
        return _VAT;
    }

    public void setVAT(String _VAT) {
        this._VAT = _VAT;
    }

    public float getDebt() {
        return _debt;
    }

    public void setDebt(float _debt) {
        this._debt = _debt;
    }

    public float getBadDept() {
        return _badDept;
    }

    public void setBadDept(float _badDept) {
        this._badDept = _badDept;
    }

//    public ChequeDetails getChequeDetails() {
//        return chequeDetails;
//    }
//
//    public void setChequeDetails(ChequeDetails chequeDetails) {
//        this.chequeDetails = chequeDetails;
//    }
}
