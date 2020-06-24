package com.jhw.swing.examples.model;

import com.jhw.swing.models.input.panels.ModelPanel;
import com.jhw.swing.notification.toast.TOAST;
import java.awt.Desktop;
import java.io.File;
import java.util.Random;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com) 5/4/2020
 */
public class CargoInputView extends ModelPanel<CargoModel> {

    public CargoInputView(CargoModel model) {
        super(model);
        initComponents();
        addListeners();
        update();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new com.jhw.swing.material.components.container.panels._MaterialPanel();
        labelCargo = new com.jhw.swing.material.components.labels._MaterialLabel();
        textFieldNombre = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textAreaDescripcion = new com.jhw.swing.material.components.textarea._MaterialTextArea();
        fileChooserPanel = new com.jhw.swing.material.components.filechooser._MaterialFileChooserPanel();
        cargoICBS1 = new com.jhw.swing.examples.model.CargoICBS();

        labelCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCargo.setText("Cargo");
        labelCargo.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N

        textFieldNombre.setHint("Nombre del cargo");
        textFieldNombre.setLabel("Cargo");

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textAreaDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargoICBS1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fileChooserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargoICBS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jhw.swing.examples.model.CargoICBS cargoICBS1;
    private com.jhw.swing.material.components.filechooser._MaterialFileChooserPanel fileChooserPanel;
    private com.jhw.swing.material.components.labels._MaterialLabel labelCargo;
    private com.jhw.swing.material.components.container.panels._MaterialPanel panelBackground;
    private com.jhw.swing.material.components.textarea._MaterialTextArea textAreaDescripcion;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        personalize();

        cargoICBS1.actualizarComboBox();
    }

    private void personalize() {
        if (model == null) {
            labelCargo.setText("Nuevo Cargo");
        } else {
            labelCargo.setText("Editar Cargo");

            textFieldNombre.setString(getOldModel().getNombreCargo());
            textAreaDescripcion.setText(getOldModel().getDescripcion());
        }
    }

    @Override
    public CargoModel getNewModel() {
        String nombre = textFieldNombre.getString();
        String desc = textAreaDescripcion.getText();
        CargoModel cargoICBS = cargoICBS1.getSelectedItem();

        CargoModel cargo;
        if (getOldModel() != null) {
            cargo = getOldModel();
            cargo.setNombreCargo(nombre);
            cargo.setDescripcion(desc);
        } else {
            cargo = new CargoModel(nombre, desc);
        }
        cargo.setIdCargo(new Random().nextInt(10000) + 100);
        cargo.setFiles(fileChooserPanel.getSelectedFiles());
        return cargo;
    }

    @Override
    public CargoModel onDeleteAction() {
        try {
            CargoModel cargo = getOldModel();
            if (cargo != null && cargo.getIdCargo() != null) {
                CargoModel.deleteCargo(cargo);
                return cargo;
            }
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return null;
    }

    @Override
    public CargoModel onCreateAction() {
        try {
            CargoModel cargo = getNewModel();
            if (getOldModel() == null) {
                CargoModel.addCargo(cargo);
                return cargo;
            } else {
                CargoModel.editCargo(cargo);
                return cargo;
            }
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return null;
    }

    @Override
    public CargoModel onPostCreateAction(CargoModel obj) {
        TOAST.makeText("POST CREATE OK");
        return super.onPostCreateAction(obj);
    }

    @Override
    public CargoModel onPostDeleteAction(CargoModel obj) {
        TOAST.makeText("POST DELETE OK");
        return super.onPostDeleteAction(obj);
    }

    @Override
    public boolean onCancelAction() {
        return true;
    }

    private void addListeners() {
        fileChooserPanel.addButtonOpenFolderAction(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonOpenFolderActionPerformed();
            }
        });
    }

    private void onButtonOpenFolderActionPerformed() {
        try {
            //hacer esto en metodo aparte general 
            File f = new File("");
            f.mkdir();
            Desktop.getDesktop().open(f);
        } catch (Exception ex) {
        }
    }
}
