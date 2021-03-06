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
package com.root101.swing.material.components.table.editors_renders.money;

import java.awt.Component;
import java.util.HashMap;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Deprecated
public class MoneyCellEditor extends AbstractCellEditor implements TableCellEditor {

    private JComponent item;
    private final HashMap<Integer, MoneyTableComponent> map = new HashMap<>();

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
        if (!map.containsKey(row)) {
            map.put(row, (MoneyTableComponent) value);
        } else {
            if (value != null) {
                MoneyTableComponent obj = (MoneyTableComponent) map.get(row);
                if (obj != (MoneyTableComponent) value) {
                    map.put(row, (MoneyTableComponent) value);
                }
            }
        }
        JTextField textField = map.get(row).getEditorComponent();
        textField.setHorizontalAlignment(SwingConstants.TRAILING);
        return textField;
    }
}
