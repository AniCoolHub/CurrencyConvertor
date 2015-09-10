/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anirudha.currencyconverter;

import com.anirudha.beans.MoneyBean;
import com.anirudha.beans.RecordBean;
import com.anirudha.persistence.CurrencyDAO;
import com.anirudha.persistence.CurrencyDAOimpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 *
 * @author a_kulka
 */
public class FXMLDocumentController implements Initializable {
    /*any control we wish to play with we include here.*/

    //private Label label;
    @FXML
    private TextField fxCurrencyCode;

    @FXML
    private TextField fxAmount;

    @FXML
    private TextField fxValue;

    @FXML
    private Label ccRequired;

    @FXML
    private Label amountRequired;
    
    @FXML
    private Label valueRequired;

    private MoneyBean mb;
    private CurrencyDAO dao;

    public FXMLDocumentController() {
        super();
        mb = new MoneyBean();
        dao = new CurrencyDAOimpl();
    }
    /*private void handleButtonAction(ActionEvent event) {
     System.out.println("You clicked me!");
     //label.setText("Hello World!");
     }*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fxCurrencyCode.setTooltip(new Tooltip("Enter Currency Code"));
        fxAmount.setTooltip(new Tooltip("Enter Amount"));

        /*fxCurrencyCode.getText();
         fxAmount.getText();*/
    }

    @FXML
    private void handleBuyAction(ActionEvent event) {
        System.out.println("You clicked buy button");

        String currencyC = fxCurrencyCode.getText();

        ccRequired.setText("");
        amountRequired.setText("");
        valueRequired.setText("");

        if (currencyC.length() == 0) {
            // write code to tell user to enter at least one character in currrency code field.
            ccRequired.setText("*Required Field");
            fxValue.setText("");
            return;
        } else {

            mb.setCurrency(currencyC.toUpperCase());
            ccRequired.setText("");
        }

        String amountInString = fxAmount.getText();
        double amountInDouble = 0.0;
        if (amountInString.length() == 0) {
            amountRequired.setText("*Required Field");
            fxValue.setText("");
            return;
        } else {
            amountRequired.setText("");
            try {
                amountInDouble = Double.parseDouble(amountInString);
            } catch (NumberFormatException nfe) {
                amountRequired.setText("*Please enter a number!!!");
                fxValue.setText("");
                return;
            }
        }

        if (amountInDouble < 0.0) {
            amountRequired.setText("*Enter valid amount!!");
            fxValue.setText("");
            return;
        }

        mb.setAmount(amountInDouble);

        RecordBean rb;
        rb = dao.findByCurrencyCode(mb);

        //mulitple mb * rb & put result in mb
        // write the result in mb to control
        System.out.println(rb.toString());

        if (rb.getCurrencyCode().length() == 0) {
            mb.setValue(-1.0);
            valueRequired.setText("*Currency Code not found in database");
        } else {
            mb.setValue((mb.getAmount() * rb.getBuyPerCAD()));
        }

        System.out.println(mb.toString());

        String valueInDouble = Double.toString(mb.getValue());
        fxValue.setText(valueInDouble);
    }

    @FXML
    private void handleSellAction(ActionEvent event) {
        System.out.println("You clicked sell button");
        String currencyC = fxCurrencyCode.getText();

        ccRequired.setText("");
        amountRequired.setText("");
        valueRequired.setText("");
        
        if (currencyC.length() == 0) {
            // write code to tell user to enter at least one character in currrency code field.
            ccRequired.setText("*Required Field");
            fxValue.setText("");
            return;
        } else {

            mb.setCurrency(currencyC.toUpperCase());
            ccRequired.setText("");
        }

        String amountInString = fxAmount.getText();
        double amountInDouble = 0.0;
        if (amountInString.length() == 0) {
            amountRequired.setText("*Required Field");
            fxValue.setText("");
            return;
        } else {
            amountRequired.setText("");
            try {
                amountInDouble = Double.parseDouble(amountInString);
            } catch (NumberFormatException nfe) {
                amountRequired.setText("*Please enter a number!!!");
                fxValue.setText("");
                return;
            }
        }

        if (amountInDouble < 0.0) {
            amountRequired.setText("*Enter valid amount!!");
            fxValue.setText("");
            return;
        }

        mb.setAmount(amountInDouble);

        RecordBean rb;
        rb = dao.findByCurrencyCode(mb);

        //mulitple mb * rb & put result in mb
        // write the result in mb to control
        System.out.println(rb.toString());

        if (rb.getCurrencyCode().length() == 0) {
            mb.setValue(-1.0);
            valueRequired.setText("*Currency Code not found in database");
        } else {
            mb.setValue((mb.getAmount() * rb.getSellPerCAD()));
        }

        System.out.println(mb.toString());
        String valueInDouble = Double.toString(mb.getValue());
        fxValue.setText(valueInDouble);
  
    }

    @FXML
    private void handleExitAction(ActionEvent event) {
        System.out.println("You clicked exit button");
        System.exit(0);
    }

}