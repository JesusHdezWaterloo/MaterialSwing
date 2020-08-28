package com.jhw.swing.material.components.table;

import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTable extends _PanelTransparent {

    public _MaterialTable() {
        initComponents();
        addListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//
    private void initComponents() {

        scrollPane = new com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore();
        table = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        scrollPane.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify//:variables
    private com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore scrollPane;
    private javax.swing.JTable table;
    // End of variables declaration                   

    public _MaterialScrollPaneCore getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(_MaterialScrollPaneCore scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getModel() {
        return (DefaultTableModel) table.getModel();
    }

    public void setModel(TableModel dataModel) {
        table.setModel(dataModel);
    }

    public TableColumn getColumn(Object identifier) {
        return table.getColumn(identifier);
    }

    public TableColumnModel getColumnModel() {
        return table.getColumnModel();
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public Object getValueAt(int row, int column) {
        return table.getValueAt(row, column);
    }

    public void clear() {
        getModel().setRowCount(0);
    }

    public void addRow(Object[] row) {
        getModel().addRow(row);
    }

    public void removeRow(int row) {
        getModel().removeRow(row);
    }

    public int getRowHeight() {
        return table.getRowHeight();
    }

    public int getRowCount() {
        return table.getRowCount();
    }

    private void addListeners() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleRowClick(e);
            }
        });
    }

    private void handleRowClick(MouseEvent e) {
        int clickedRow = table.rowAtPoint(e.getPoint());
        if (clickedRow >= 0 && clickedRow < table.getRowCount()) {
            table.setRowSelectionInterval(clickedRow, clickedRow);
        } else {
            table.clearSelection();
        }
    }
}
