package com.app.cell;

import com.app.model.ModelData;
import com.app.services.ServiceData;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class CellAction extends TableCustomCell {

    public CellAction() {
        initComponents();
        cmdEdit.setBackground(new Color(0,0,0,0));
        cmdDelete.setBackground(new Color(0,0,0,0));
    }
    
    private void addEvent(TableCustom table, TableRowData data, int row) {
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (data.isEditing()) {
                    table.cancelEditRowAt(row);
                    cmdEdit.setIcon(new ImageIcon(getClass().getResource("/com/app/icon/edit.png")));
                } else {
                    table.editRowAt(row);
                    cmdEdit.setIcon(new ImageIcon(getClass().getResource("/com/app/icon/cancel.png")));
                }
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int dataID = ((ModelData) data).getId();
                if (dataID != 0) {
                    try {
                        new ServiceData().deleteData(dataID);
                        table.deleteRowAt(getRow(), true);
                    } catch (SQLException e) {
                        System.err.println(e);
                    }
                } else {
                    table.deleteRowAt(getRow(), true);
                }
            }
        });
    }

    private void checkIcon(TableRowData data) {
        if (data.isEditing()) {
            cmdEdit.setIcon(new ImageIcon(getClass().getResource("/com/app/icon/cancel.png")));
        } else {
            cmdEdit.setIcon(new ImageIcon(getClass().getResource("/com/app/icon/edit.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdEdit = new com.app.swing.Button();
        cmdDelete = new com.app.swing.Button();

        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/icon/edit.png"))); // NOI18N
        cmdEdit.setMaximumSize(new java.awt.Dimension(28, 28));
        cmdEdit.setMinimumSize(new java.awt.Dimension(28, 28));
        cmdEdit.setPreferredSize(new java.awt.Dimension(28, 28));

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/icon/delete.png"))); // NOI18N
        cmdDelete.setMaximumSize(new java.awt.Dimension(28, 28));
        cmdDelete.setMinimumSize(new java.awt.Dimension(28, 28));
        cmdDelete.setPreferredSize(new java.awt.Dimension(28, 28));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {

    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellAction cell = new CellAction();
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }

    @Override
    public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {
        return null;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int column) {
        CellAction cell = new CellAction();
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button cmdDelete;
    private com.app.swing.Button cmdEdit;
    // End of variables declaration//GEN-END:variables
}
