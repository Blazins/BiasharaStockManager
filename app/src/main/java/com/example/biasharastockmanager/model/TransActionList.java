package com.example.biasharastockmanager.model;

import com.google.firebase.Timestamp;

import java.util.Date;

public class TransActionList {
     private String product;
     private String stockquantity;
     private String price;
     private String userId;
     private String userName;
     private Date dateSold;
     private Date dateBought;

    public TransActionList() {

    }

    public String getProduct() {
        return product;
    }

    public Date getDateBought() {
        return dateBought;
    }

    public void setDateBought(Date dateBought) {
        this.dateBought = dateBought;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStockquantity() {
        return stockquantity;
    }

    public void setStockquantity(String stockquantity) {
        this.stockquantity = stockquantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateSold() {
        return dateSold;
    }

    public void setDateSold(Date dateSold) {
        this.dateSold = dateSold;
    }
}
