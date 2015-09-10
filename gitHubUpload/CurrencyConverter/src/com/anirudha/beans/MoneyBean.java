package com.anirudha.beans;

/**
 *
 * @author a_kulka
 */
public class MoneyBean {

    private String currency;
    private double amount;
    private double value;

    public MoneyBean(String currency, double amount, double value) {
        this.currency = currency;
        this.amount = amount;
        this.value = value;
    }

    public MoneyBean() {
        this("", 0.0, 0.0);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MoneyBean{" + "currency=" + currency + ", amount=" + amount + ", value=" + value + '}';
    }

}
