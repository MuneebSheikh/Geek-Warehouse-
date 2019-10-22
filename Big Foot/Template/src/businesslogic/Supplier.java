/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.util.ArrayList;
import java.util.List;
import DataAcess.DataAcess;
/**
 *
 * @author sajja
 */
public class Supplier {

    // ******************** ATTRIBUTES **************************
    private String _companyName;
    private int _phone;
    private String _email;
    private String _address;
    private String _TRN;
//    private List<Product> prods = new ArrayList<Product>();
    private ChequeDetails chequeDetails;
    private DataAcess dataAcess;
    
    //******************** CONSTRUCTORS *****************************

    public Supplier() {dataAcess = new DataAcess();}
     
    public Supplier(String _companyName, int _phone, String _email, String _address, String _TRN) {
        this._companyName = _companyName;
        this._phone = _phone;
        this._email = _email;
        this._address = _address;
        this._TRN = _TRN;
        dataAcess = new DataAcess();
    }
//    public Supplier(String _companyName, int _phone, String _email, String _address, String _TRN, ArrayList<Product> prods ) {
//        this._companyName = _companyName;
//        this._phone = _phone;
//        this._email = _email;
//        this._address = _address;
//        this._TRN = _TRN;
//        this.prods = prods;
//        dataAcess = new DataAcess();
//    }
    
    
    // ********************* METHODS **************************
    public void addReciept(ArrayList<Product> prods, String ammount, String deliveryDate, String VAT)
    {
        //Make Boolean Function
//        dataAcess.addSuplierReciept(prods, ammount, deliveryDate, VAT, this._TRN);
        // store it in data base 
    }
        
    //************* GETTER AND SETTER ***************************

    public String getCompanyName() {
        return _companyName;
    }

    public void setCompanyName(String _companyName) {
        this._companyName = _companyName;
    }
    
    public int getPhone() {
        return _phone;
    }

    public void setPhone(int _phone) {
        this._phone = _phone;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public String getTRN() {
        return _TRN;
    }

    public void setTRN(String _TRN) {
        this._TRN = _TRN;
    }

    public ChequeDetails getChequeDetails() {
        return chequeDetails;
    }

    public void setChequeDetails(ChequeDetails chequeDetails) {
        this.chequeDetails = chequeDetails;
    }
    
}
