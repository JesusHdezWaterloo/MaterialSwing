package com.jhw.swing.examples.bundles.loading;

import com.jhw.swing.bundles.loading.LoadingProcess;
import com.jhw.swing.bundles.loading.LoadingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.jhw.swing.ui.MaterialLookAndFeel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LOADING_EXAMPLE extends javax.swing.JFrame {

    public LOADING_EXAMPLE() {
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

        _MaterialButton1 = new com.jhw.swing.material.components.button._MaterialButton();
        _MaterialLabel1 = new com.jhw.swing.material.components.labels._MaterialLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _MaterialButton1.setText("Do some action");
        _MaterialButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _MaterialButton1ActionPerformed(evt);
            }
        });

        _MaterialLabel1.setText("While the loading is active, you can interact with this windows");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(_MaterialLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(_MaterialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(148, Short.MAX_VALUE)
                                .addComponent(_MaterialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(_MaterialLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>                        

    private void _MaterialButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__MaterialButton1ActionPerformed

        new LoadingWorker<String>(new LoadingProcess<String>() {
            @Override
            public String process() throws Exception {
                Thread.sleep(5 * 1000);
                return "Hello World";
            }

            @Override
            public void completed(String result) throws Exception {
                System.out.println(result);
            }

            @Override
            public void errorInProcess(Exception result) {
                System.out.println("An error ucurred during the excecution. ");
                System.out.println("Printing StackTrace: ");
                result.printStackTrace();
            }
        });

    }//GEN-LAST:event__MaterialButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new MaterialLookAndFeel());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOADING_EXAMPLE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//:variables
    private com.jhw.swing.material.components.button._MaterialButton _MaterialButton1;
    private com.jhw.swing.material.components.labels._MaterialLabel _MaterialLabel1;
    // End of variables declaration                   

}
