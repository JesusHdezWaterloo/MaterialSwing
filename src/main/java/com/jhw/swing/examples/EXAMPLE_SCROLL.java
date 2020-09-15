/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

//import com.jhw.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.filechooser.MaterialFileChoosersFactory;
import com.jhw.swing.material.components.labels.MaterialLabel;
import com.jhw.swing.material.components.labels.MaterialLabelDoble;
import com.jhw.swing.material.components.labels.MaterialLabelDobleMoney;
import com.jhw.swing.material.components.labels.MaterialLabelMoney;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
import com.jhw.swing.material.components.passwordfield.MaterialPasswordField;
import com.jhw.swing.material.components.passwordfield.MaterialPasswordFieldFactory;
import com.jhw.swing.material.components.progress._MaterialProgressSpinner;
import com.jhw.swing.material.components.scrollpane.MaterialScrollFactory;
import com.jhw.swing.material.components.scrollpane.MaterialScrollPane;
import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.math.BigDecimal;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_SCROLL extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_SCROLL() {
        initComponents();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(MaterialColors.WHITE);
        jPanel1.setBackground(Color.white);

        JTextArea text = new JTextArea("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        MaterialScrollPane scroll = new _MaterialScrollPaneCore() {
            @Override
            public JComponent getFocusableComponent() {
                return text;
            }
        };//MaterialScrollFactory.buildPane();
        scroll.setViewportView(text);
        scroll.setBorderTitle("buajajajaja");

        jPanel1.add(scroll);

        jPanel1.add(new Checkbox("focus"), BorderLayout.SOUTH);
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        this.setContentPane(jPanel1);

        pack();

        this.setSize(new Dimension(500, 500));
        //this.setExtendedState(MAXIMIZED_BOTH);

        this.setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (Exception e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EXAMPLE_SCROLL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
