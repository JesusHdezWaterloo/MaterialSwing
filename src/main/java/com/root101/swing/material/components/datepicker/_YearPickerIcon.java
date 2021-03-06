/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.datepicker;

import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.components.button.MaterialButtonIcon;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.util.PersonalizationMaterial;
import com.root101.swing.derivable_icons.DerivableIcon;
import com.root101.swing.material.components.textfield._MaterialTextFieldIcon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.material.standards.MaterialIcons;
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
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _YearPickerIcon extends MaterialYearPickerIcon {

    public static _YearPickerIcon from() {
        return MaterialSwingInjector.getImplementation(_YearPickerIcon.class);
    }

    private Color originalIconColor = MaterialColors.BLACK;

    public _YearPickerIcon() {
        initComponents();
        this.setIcon(MaterialIcons.DATE_RANGE);

        getYearPicker().addFocusListener(new FocusListener() {
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
        yearPicker = _YearPicker.from();

        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        buttonIcon.setPaintRipple(false);

        this.setBorder(null);
        this.setLayout(new BorderLayout());
        this.add(yearPicker, BorderLayout.CENTER);
    }

    private _YearPicker yearPicker;
    private MaterialButtonIcon buttonIcon;

    @Override
    public _YearPicker getYearPicker() {
        return yearPicker;
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

        int h = (int) this.yearPicker.getPreferredSize().getHeight();
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
        yearPicker.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
    }

    @Override
    public String getLabel() {
        return yearPicker.getLabel();
    }

    @Override
    public void setLabel(String label) {
        yearPicker.setLabel(label);
    }

    @Override
    public String getHint() {
        return yearPicker.getHint();
    }

    @Override
    public void setHint(String hint) {
        yearPicker.setHint(hint);
    }

    @Override
    public Color getAccentFloatingLabel() {
        return yearPicker.getAccentFloatingLabel();
    }

    @Override
    public void setAccentFloatingLabel(Color accentColor) {
        yearPicker.setAccentFloatingLabel(accentColor);
    }

    @Override
    public void paintLabel(Graphics g) {
        yearPicker.paintLabel(g);
    }

    @Override
    public void paintHint(Graphics g) {
        yearPicker.paintHint(g);
    }

    @Override
    public void paintLine(Graphics g) {
        yearPicker.paintLine(g);
    }

    @Override
    public int getYLine(Graphics g2) {
        return yearPicker.getYLine(g2);
    }

    @Override
    public void wrong() {
        yearPicker.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        yearPicker.wrong(wrongText);
    }

    @Override
    public Color getWrongColor() {
        return yearPicker.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        yearPicker.setWrongColor(wrongColor);
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        yearPicker.paintWrong(g2, y);
    }

    @Override
    public void clearWrong() {
        yearPicker.clearWrong();
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (yearPicker != null) {
            yearPicker.setForeground(fg);
        }
    }

    @Override
    public Year getMinYear() {
        return yearPicker.getMinYear();
    }

    @Override
    public void setMinYear(Year minYear) {
        yearPicker.setMinYear(minYear);
    }

    @Override
    public Year getMaxYear() {
        return yearPicker.getMaxYear();
    }

    @Override
    public void setMaxYear(Year maxYear) {
        yearPicker.setMaxYear(maxYear);
    }

    @Override
    public Year getObject() {
        return yearPicker.getObject();
    }

    @Override
    public void setObject(Year object) {
        yearPicker.setObject(object);
    }

}
