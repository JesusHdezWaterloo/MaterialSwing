/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.labels;

import com.jhw.swing.material.standards.MaterialFontRoboto;
import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialLabelDoubleMoney extends MaterialLabelDobleMoney {

    public static _MaterialLabelDoubleMoney from() {
        return new _MaterialLabelDoubleMoney();
    }

    protected _MaterialLabelDoubleMoney() {
        setLabelRigth(labelMoney);
        labelMoney.setFont(MaterialFontRoboto.BOLD.deriveFont(22f));
    }

    private final MaterialLabelMoney labelMoney = new _MaterialLabelMoney();

    @Override
    public void setMoney(BigDecimal value, Object coin) {
        labelMoney.setMoney(value, coin.toString());
    }

    @Override
    public void setText(String text) {
        setLeftText(text);
    }
}
