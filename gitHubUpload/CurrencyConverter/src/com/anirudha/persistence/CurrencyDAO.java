/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anirudha.persistence;

import com.anirudha.beans.MoneyBean;
import com.anirudha.beans.RecordBean;

/**
 *
 * @author a_kulka
 */
public interface CurrencyDAO {
    
    public RecordBean findByCurrencyCode(MoneyBean mb);
}
