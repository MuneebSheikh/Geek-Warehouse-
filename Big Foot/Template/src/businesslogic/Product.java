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
public class Product {
    private String _prodName;
    private String _cost;
    private String _quantity;
    private String _desc;
    private String _invoiceNo; // maybe not neccesary
    public Product(){

    }
    public Product(String _prodName, String _cost, String _quantity, String _desc) {
        this._prodName = _prodName;
        this._cost = _cost;
        this._quantity = _quantity;
        this._desc = _desc;
    }

    public String getInvoiceNo() {
        return _invoiceNo;
    }

    public void setInvoiceNo(String _invoiceNo) {
        this._invoiceNo = _invoiceNo;
    }
    
    public String getProdName() {
        return _prodName;
    }

    public void setProdName(String _prodName) {
        this._prodName = _prodName;
    }

    public String getCost() {
        return _cost;
    }

    public void setCost(String _cost) {
        this._cost = _cost;
    }

    public String getQuantity() {
        return _quantity;
    }

    public void setQuantity(String _quantity) {
        this._quantity = _quantity;
    }

    public String getDesc() {
        return _desc;
    }

    public void setDesc(String _desc) {
        this._desc = _desc;
    }
    
    
    
    
}
