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
public class Labour {

    private String _billNo;
    private String _invNo;    
    private String _name;
    private String _email;
    private String _phone;
    private String _address;
    private String _cost;
    private String _duration;
    private String _descWork;
    private String _date;
    public Labour(){
        
    }
    
    public Labour(String _billNo, String _invNo, String _name, String _email, String _phone, String _address, 
            String _cost, String _duration, String _descWork, String _date) {
        this._billNo = _billNo;
        this._invNo = _invNo;
        this._name = _name;
        this._email = _email;
        this._phone = _phone;
        this._address = _address;
        this._cost = _cost;
        this._duration = _duration;
        this._descWork = _descWork;
        this._date = _date;
    }
    
    
    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String _date) {
        this._date = _date;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getBillNo() {
        return _billNo;
    }

    public void setBillNo(String _billNo) {
        this._billNo = _billNo;
    }

    public String getInvNo() {
        return _invNo;
    }

    public void setInvNo(String _invNo) {
        this._invNo = _invNo;
    }

    public String getDescWork() {
        return _descWork;
    }

    public void setDescWork(String _descWork) {
        this._descWork = _descWork;
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

    public String getCost() {
        return _cost;
    }

    public void setCost(String _cost) {
        this._cost = _cost;
    }

    public String getDuration() {
        return _duration;
    }

    public void setDuration(String _duration) {
        this._duration = _duration;
    }

}
