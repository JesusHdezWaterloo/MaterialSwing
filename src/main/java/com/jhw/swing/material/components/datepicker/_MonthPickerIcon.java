/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.textfield.*;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButtonIcon;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.util.PersonalizationMaterial;
import com.jhw.swing.derivable_icons.DerivableIcon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.Year;
import javax.swing.Icon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MonthPickerIcon extends MaterialMonthPickerIcon {

    public static _MonthPickerIcon from() {
        return MaterialSwingInjector.getImplementation(_MonthPickerIcon.class);
    }

    private Color originalIconColor = MaterialColors.BLACK;

    public _MonthPickerIcon() {
        initComponents();
        this.setIcon(MaterialIcons.DATE_RANGE);

        getMonthPicker().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                buttonIcon.setForeground(getAccentFloatingLabel());
            }

            @Override
            public void focusLost(FocusEvent e) {
                buttonIcon.setForeground(originalIconColor);
            }
        });
    }

    private void initComponents() {
        monthPicker = _MonthPicker.from();

        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        buttonIcon.setPaintRipple(false);

        this.setBorder(null);
        this.setLayout(new BorderLayout());
        this.add(monthPicker, BorderLayout.CENTER);
    }

    private _MonthPicker monthPicker;
    private MaterialButtonIcon buttonIcon;

    @Override
    public MaterialMonthPicker getMonthPicker() {
        return monthPicker;
    }

    @Override
    public void setIcon(Icon icon) {
        if (icon == null) {
            this.remove(buttonIcon);
            return;
        }
        if (!PersonalizationHandler.getBoolean(PersonalizationMaterial.KEY_SHOW_ICON_INPUT)) {
            return;
        }

        int h = (int) this.monthPicker.getPreferredSize().getHeight();
        if (icon instanceof DerivableIcon) {
            buttonIcon.setIcon(((DerivableIcon) icon).deriveIcon(h * _MaterialTextFieldIcon.ICON_SIZE_REDUCTION));
            originalIconColor = ((DerivableIcon) icon).getColor();
        } else {
            buttonIcon.setIcon(icon);
        }
        int w = (int) (h * _MaterialTextFieldIcon.ICON_WIDTH_REDUCTION);
        buttonIcon.setPreferredSize(new Dimension(w, h));
        this.add(buttonIcon, BorderLayout.WEST);
    }

    @Override
    public Icon getIcon() {
        return buttonIcon.getIcon();
    }

    @Override
    public void setEnabled(boolean enabled) {
        monthPicker.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
    }

    @Override
    public String getLabel() {
        return monthPicker.getLabel();
    }

    @Override
    public void setLabel(String label) {
        monthPicker.setLabel(label);
    }

    @Override
    public String getHint() {
        return monthPicker.getHint();
    }

    @Override
    public void setHint(String hint) {
        monthPicker.setHint(hint);
    }

    @Override
    public Color getAccentFloatingLabel() {
        return monthPicker.getAccentFloatingLabel();
    }

    @Override
    public void setAccentFloatingLabel(Color accentColor) {
        monthPicker.setAccentFloatingLabel(accentColor);
    }

    @Override
    public void paintLabel(Graphics g) {
        monthPicker.paintLabel(g);
    }

    @Override
    public void paintHint(Graphics g) {
        monthPicker.paintHint(g);
    }

    @Override
    public void paintLine(Graphics g) {
        monthPicker.paintLine(g);
    }

    @Override
    public int getYLine(Graphics g2) {
        return monthPicker.getYLine(g2);
    }

    @Override
    public void wrong() {
        monthPicker.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        monthPicker.wrong(wrongText);
    }

    @Override
    public Color getWrongColor() {
        return monthPicker.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        monthPicker.setWrongColor(wrongColor);
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        monthPicker.paintWrong(g2, y);
    }

    @Override
    public void clearWrong() {
        monthPicker.clearWrong();
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (monthPicker != null) {
            monthPicker.setForeground(fg);
        }
    }

    @Override
    public _Month getObject() {
        return monthPicker.getObject();
    }

    @Override
    public void setObject(_Month object) {
        monthPicker.setObject(object);
    }

}