/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.container.panel._PanelTransparent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialYearMonthPicker extends _PanelTransparent implements MaterialYearMonthPickerDefinition {

    public abstract MaterialMonthPicker getMonthPicker();

    public abstract MaterialYearPicker getYearPicker();
}