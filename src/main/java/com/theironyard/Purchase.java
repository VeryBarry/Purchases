package com.theironyard;

/**
 * Created by VeryBarry on 11/1/16.
 */
public class Purchase {
    int id;
    String date;
    String creditcard;
    String cvv;
    String item;

    public Purchase() {
    }

    public Purchase(String date, String creditcard, String cvv, String item) {
        this.date = date;
        this.creditcard = creditcard;
        this.cvv = cvv;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
