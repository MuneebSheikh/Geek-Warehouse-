/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

/**
 *
 * @author afif
 */
public class Expences {
    
    private String _id;
    private String _detail;
    private String _amount;
    private String _client;
    private String _date;
    private String _name;
    private String _status;

    public Expences(String _detail, String _amount, String _client, String _date, String _name, String _status) {
        this._detail = _detail;
        this._amount = _amount;
        this._client = _client;
        this._date = _date;
        this._name = _name;
        this._status = _status;
    }

    public String getDetail() {
        return _detail;
    }

    public void setDetail(String _detail) {
        this._detail = _detail;
    }

    public String getAmount() {
        return _amount;
    }

    public void setAmount(String _amount) {
        this._amount = _amount;
    }

    public String getClient() {
        return _client;
    }

    public void setClient(String _client) {
        this._client = _client;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String _date) {
        this._date = _date;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String _status) {
        this._status = _status;
    }
    
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }


}
