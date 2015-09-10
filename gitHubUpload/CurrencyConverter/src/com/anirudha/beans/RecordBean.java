/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anirudha.beans;

/**
 *
 * @author a_kulka
 */
public class RecordBean {

    private String currencyCode; // if it is object default value in NULL.
    private double sellPerCAD;
    private double buyPerCAD;

    public RecordBean(String currencyCode, double sellPerCAD, double buyPerCAD) {
        this.currencyCode = currencyCode;
        this.sellPerCAD = sellPerCAD;
        this.buyPerCAD = buyPerCAD;
    }

    public RecordBean() {
        this("", 0.0, 0.0);
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getSellPerCAD() {
        return sellPerCAD;
    }

    public void setSellPerCAD(double sellPerCAD) {
        this.sellPerCAD = sellPerCAD;
    }

    public double getBuyPerCAD() {
        return buyPerCAD;
    }

    public void setBuyPerCAD(double buyPerCAD) {
        this.buyPerCAD = buyPerCAD;
    }

    @Override
    public String toString() {
        return "RecordBean{" + "currencyCode=" + currencyCode + ", sellPerCAD=" + sellPerCAD + ", buyPerCAD=" + buyPerCAD + '}';
    }

}
