/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anirudha.persistence;

import com.anirudha.beans.MoneyBean;
import com.anirudha.beans.RecordBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author a_kulka
 */
public class CurrencyDAOimpl implements CurrencyDAO {

    String url = "jdbc:derby://localhost:1527/CurrencyDB";
    String user = "student";
    String password = "concordia";

    @Override
    public RecordBean findByCurrencyCode(MoneyBean mb) {
        RecordBean rb = new RecordBean();; // initial value of Class variable is NULL
        //String sql="Select CURRENCYCODE, SELLPERCAD, BUYPERCAD from money where CURRENCYCODE='"+mb.getCurrency()+"'"; This statement is not used in order to avoid sql injection
        String sql = "Select SELLPERCAD, BUYPERCAD FROM MONEY WHERE CURRENCYCODE=?";
        // "?" is a place holder . we are using this in order to prevent sql injection
        try ( // only things that goes in to this is declaration of objects. We can't define/call any method ovger here
                Connection connection = DriverManager.getConnection(url, user, password);
                /* it prepares a sql statement and returns the stament to orcale server with one missing statement*/
                PreparedStatement ps = connection.prepareStatement(sql); ) {

            ps.setString(1, mb.getCurrency()); // 

            try (  // ResultSet is a datastructure of type Class and it is declared in package mentioned at top.
                    ResultSet rs = ps.executeQuery();) {
                if (rs.next()){
                   
                    rb.setCurrencyCode(mb.getCurrency());
                    rb.setBuyPerCAD(rs.getDouble("BUYPERCAD"));
                    rb.setSellPerCAD(rs.getDouble("SELLPERCAD"));
                }
            }

        } catch (SQLException sqlex) {

            sqlex.printStackTrace();
            System.exit(1);
        }
        
        
        return rb;

       
    }


/*public static void main (String[] args){

CurrencyDAO currencyDAO = new CurrencyDAOimpl();

MoneyBean mb = new MoneyBean();

mb.setCurrency("JPY");
mb.setAmount(100.0);

    RecordBean rb = currencyDAO.findByCurrencyCode(mb);
    System.out.println(rb.toString());

    mb.setValue((mb.getAmount() * rb.getSellPerCAD()));
    System.out.println(mb.toString());
    
    
}*/


}


