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
package com.root101.swing.examples;

//import com.root101.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.root101.swing.bundles.loading.LoadingProcess;
import com.root101.swing.bundles.loading.LoadingWorker;
import com.root101.swing.material.components.container.MaterialContainersFactory;
import com.root101.swing.material.components.container.panel.MaterialPanelBorder;
import com.root101.swing.material.components.splashScreen.SplashScreen;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class EXAMPLE_SPLASH extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_SPLASH() {
        initComponents();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(MaterialColors.WHITE);
        jPanel1.add(new JButton(new AbstractAction("Start") {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        }));
    }

    private void start() {
        new LoadingWorker<Void>(new SplashScreen() {
            @Override
            public JPanel mainSplash() {
                MaterialPanelBorder back = MaterialContainersFactory.buildPanelGradient();
                back.setIcon(MaterialIcons.CARD_GIFTCARD.deriveIcon(500));
                return back;
            }
        }, new LoadingProcess<Void>() {
            @Override
            public Void process() throws Exception {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println("Dormido " + i + " segundos");
                }
                return null;
            }

            @Override
            public void completed(Void result) throws Exception {
                System.out.println("Iniciando el sistema....");
            }

            @Override
            public void errorInProcess(Exception result) {

                System.exit(-1);
            }
        });
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        this.setContentPane(jPanel1);

        pack();

        this.setSize(new Dimension(500, 500));
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
                new EXAMPLE_SPLASH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
