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
package com.root101.swing.bundles.jop;

import com.root101.swing.material.components.button.MaterialButton;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.components.button._MaterialButton;
import com.root101.swing.material.components.container.panel._MaterialPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ComponentEvent;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import com.root101.swing.util.interfaces.MaterialComponent;
import com.root101.swing.material.standards.MaterialColors;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _OptionPanel extends _MaterialPanel implements MaterialComponent {

    private JPanel internPanel;

    public _OptionPanel() {
        initComponents();
        personalize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//
    private void initComponents() {

        buttonPositive = MaterialButtonsFactory.buildButton();
        buttonNegative = MaterialButtonsFactory.buildButton();
        panelOption = new com.root101.swing.material.components.container.panel._PanelComponent();

        buttonPositive.setBackground(new java.awt.Color(51, 51, 255));
        buttonPositive.setText("Ok");
        buttonPositive.setToolTipText("");

        buttonNegative.setBackground(new java.awt.Color(51, 51, 255));
        buttonNegative.setText("Cancel");

        javax.swing.GroupLayout panelOptionLayout = new javax.swing.GroupLayout(panelOption);
        panelOption.setLayout(panelOptionLayout);
        panelOptionLayout.setHorizontalGroup(
                panelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 455, Short.MAX_VALUE)
        );
        panelOptionLayout.setVerticalGroup(
                panelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 230, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(55, Short.MAX_VALUE)
                                .addComponent(buttonPositive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addComponent(buttonNegative, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(55, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(panelOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonPositive, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                        .addComponent(buttonNegative, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                                .addGap(20, 20, 20))
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify//:variables
    private MaterialButton buttonNegative;
    private MaterialButton buttonPositive;
    private com.root101.swing.material.components.container.panel._PanelComponent panelOption;
    // End of variables declaration                   

    private void personalize() {
        this.setBackground(MaterialColors.WHITE);
        this.setBorderRadius(5);
        buttonPositive.setBackground(MaterialColors.BLUEA_700);
        buttonNegative.setBackground(MaterialColors.BLUEA_700);
        buttonNegative.setVisible(false);
    }

    public void dispose(ComponentEvent evt) {
        JComponent comp = (JComponent) evt.getSource(); //get the Java Component
        Window window = SwingUtilities.getWindowAncestor(comp); // returns the first Window ancestor of Component
        window.dispose();//realeases all of the native screen resources ued by this its subcomponents, and all of its owned children
    }

    public MaterialButton getButtonNegative() {
        return buttonNegative;
    }

    public void setButtonNegative(_MaterialButton buttonNegative) {
        this.buttonNegative = buttonNegative;
    }

    public MaterialButton getButtonPositive() {
        return buttonPositive;
    }

    public void setButtonPositive(_MaterialButton buttonPositive) {
        this.buttonPositive = buttonPositive;
    }

    public Component getInternalPanel() {
        return internPanel;
    }

    public void setInternalPanel(JPanel panel) {
        internPanel = panel;
        internPanel.setOpaque(false);
    }

    public void setButtonPositiveText(String text) {
        buttonPositive.setText(text);
    }

    public void setButtonNegativeText(String text) {
        buttonNegative.setText(text);
    }

    public void setButtonPositiveBackground(Color color) {
        buttonPositive.setBackground(color);
    }

    public void setButtonNegativeBackground(Color color) {
        buttonNegative.setBackground(color);
    }

    public void setButtonsBackground(Color color) {
        buttonPositive.setBackground(color);
        buttonNegative.setBackground(color);
    }

    public void setInternalPanelBackgroun(Color color) {
        internPanel.setBackground(color);
        setInternalPanel(internPanel);
    }

}
