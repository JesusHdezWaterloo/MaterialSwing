package com.jhw.swing.examples.components.containers;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.jhw.swing.ui.MaterialLookAndFeel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PANEL_EXAMPLE extends javax.swing.JFrame {

    public PANEL_EXAMPLE() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//
    private void initComponents() {

        _MaterialPanel1 = new com.jhw.swing.material.components.container.panel._MaterialPanel();
        _PanelAvatarChooser1 = new com.jhw.swing.material.components.container.panel._PanelAvatarChooser();
        _PanelGradient1 = new com.jhw.swing.material.components.container.panel._PanelGradient();
        _PanelGradient2 = new com.jhw.swing.material.components.container.panel._PanelGradient();
        _PanelCurves1 = new com.jhw.swing.material.components.container.panel._PanelCurves();
        _PanelGradientTranslucid1 = new com.jhw.swing.material.components.container.panel._PanelGradientTranslucid();
        _PanelTransparent1 = new com.jhw.swing.material.components.container.panel._PanelTransparent();
        _MaterialLabel1 = new com.jhw.swing.material.components.labels._MaterialLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout _MaterialPanel1Layout = new javax.swing.GroupLayout(_MaterialPanel1);
        _MaterialPanel1.setLayout(_MaterialPanel1Layout);
        _MaterialPanel1Layout.setHorizontalGroup(
            _MaterialPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        _MaterialPanel1Layout.setVerticalGroup(
            _MaterialPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout _PanelAvatarChooser1Layout = new javax.swing.GroupLayout(_PanelAvatarChooser1);
        _PanelAvatarChooser1.setLayout(_PanelAvatarChooser1Layout);
        _PanelAvatarChooser1Layout.setHorizontalGroup(
            _PanelAvatarChooser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        _PanelAvatarChooser1Layout.setVerticalGroup(
            _PanelAvatarChooser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout _PanelGradient1Layout = new javax.swing.GroupLayout(_PanelGradient1);
        _PanelGradient1.setLayout(_PanelGradient1Layout);
        _PanelGradient1Layout.setHorizontalGroup(
            _PanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        _PanelGradient1Layout.setVerticalGroup(
            _PanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout _PanelGradient2Layout = new javax.swing.GroupLayout(_PanelGradient2);
        _PanelGradient2.setLayout(_PanelGradient2Layout);
        _PanelGradient2Layout.setHorizontalGroup(
            _PanelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_PanelGradient2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(_PanelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        _PanelGradient2Layout.setVerticalGroup(
            _PanelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_PanelGradient2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_PanelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout _PanelGradientTranslucid1Layout = new javax.swing.GroupLayout(_PanelGradientTranslucid1);
        _PanelGradientTranslucid1.setLayout(_PanelGradientTranslucid1Layout);
        _PanelGradientTranslucid1Layout.setHorizontalGroup(
            _PanelGradientTranslucid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
        );
        _PanelGradientTranslucid1Layout.setVerticalGroup(
            _PanelGradientTranslucid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        _MaterialLabel1.setText("transparent here");

        javax.swing.GroupLayout _PanelTransparent1Layout = new javax.swing.GroupLayout(_PanelTransparent1);
        _PanelTransparent1.setLayout(_PanelTransparent1Layout);
        _PanelTransparent1Layout.setHorizontalGroup(
            _PanelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_PanelTransparent1Layout.createSequentialGroup()
                .addComponent(_MaterialLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        _PanelTransparent1Layout.setVerticalGroup(
            _PanelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_PanelTransparent1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(_MaterialLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(_MaterialPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_PanelAvatarChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(_PanelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(_PanelGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_PanelGradientTranslucid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(_PanelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_MaterialPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_PanelAvatarChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(_PanelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(_PanelGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_PanelGradientTranslucid1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(_PanelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
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
                new PANEL_EXAMPLE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//:variables
    private com.jhw.swing.material.components.labels._MaterialLabel _MaterialLabel1;
    private com.jhw.swing.material.components.container.panel._MaterialPanel _MaterialPanel1;
    private com.jhw.swing.material.components.container.panel._PanelAvatarChooser _PanelAvatarChooser1;
    private com.jhw.swing.material.components.container.panel._PanelCurves _PanelCurves1;
    private com.jhw.swing.material.components.container.panel._PanelGradient _PanelGradient1;
    private com.jhw.swing.material.components.container.panel._PanelGradient _PanelGradient2;
    private com.jhw.swing.material.components.container.panel._PanelGradientTranslucid _PanelGradientTranslucid1;
    private com.jhw.swing.material.components.container.panel._PanelTransparent _PanelTransparent1;
    // End of variables declaration//GEN-END:variables

}
