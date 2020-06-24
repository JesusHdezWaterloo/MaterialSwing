package com.jhw.swing.examples.material;

import com.jhw.swing.material.components.container.panels._MaterialPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.jhw.swing.ui.MaterialLookAndFeel;
import com.jhw.swing.material.standars.MaterialColors;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class MATERIAL_COLORS_EXAMPLE extends javax.swing.JFrame {

    public static final Field[] fields = MaterialColors.class.getDeclaredFields();

    public static Color getRandomColor() {
        Color c = null;
        for (int i = 0; i < 1000; i++) {
            try {
                c = (Color) fields[new Random().nextInt(fields.length)].get(null);
                return c;
            } catch (Exception e) {
            }
        }
        return MaterialColors.WHITE;
    }

    public MATERIAL_COLORS_EXAMPLE() {
        initComponents();

        this._PanelGradient1.setLayout(new GridLayout(0, 14));

        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())
                    && Color.class.isAssignableFrom(field.getType())) {
                try {
                    Color c = (Color) field.get(null);
                    String name = field.getName();

                    _MaterialPanel mp = new _MaterialPanel();
                    mp.setElevation(0);
                    mp.setBackground(c);
                    mp.setToolTipText(name);
                    this._PanelGradient1.add(mp);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        System.out.println("done");
        this.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _PanelGradient1 = new com.jhw.swing.material.components.container.panels._PanelGradient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _PanelGradient1.setPrimaryColor(new java.awt.Color(255, 255, 255));
        _PanelGradient1.setSecundaryColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout _PanelGradient1Layout = new javax.swing.GroupLayout(_PanelGradient1);
        _PanelGradient1.setLayout(_PanelGradient1Layout);
        _PanelGradient1Layout.setHorizontalGroup(
            _PanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
        );
        _PanelGradient1Layout.setVerticalGroup(
            _PanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_PanelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_PanelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new MaterialLookAndFeel());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MATERIAL_COLORS_EXAMPLE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jhw.swing.material.components.container.panels._PanelGradient _PanelGradient1;
    // End of variables declaration//GEN-END:variables

}
