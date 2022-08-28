package com.app.cell;

import com.app.model.ModelData;
import com.app.services.ServiceData;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CellKodeBarang extends TableCustomCell{

    public CellKodeBarang() {
        initComponents();
        txt.setBackground(new Color(0,0,0,0));
        txt.setForeground(new Color(230,230,230));
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new javax.swing.JLabel();
        cmdSave = new com.app.swing.Button();

        txt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt.setForeground(new java.awt.Color(230, 230, 230));
        txt.setMinimumSize(new java.awt.Dimension(6, 44));
        txt.setPreferredSize(new java.awt.Dimension(6, 44));

        cmdSave.setBackground(new java.awt.Color(50, 200, 126));
        cmdSave.setForeground(new java.awt.Color(230, 230, 230));
        cmdSave.setText("Update");
        cmdSave.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdSave, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

  private void addEventSave(TableCustom table) {
        cmdSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                table.stopCellEditing();
                int row = getRow();
                String kdBarang = table.getValueAt(row, 0).toString();
                String nama = table.getValueAt(row, 1).toString();
                String model = table.getValueAt(row, 2).toString();
                String jenis = table.getValueAt(row, 3).toString();
                String kadar = table.getValueAt(row, 4).toString();
                int berat = Integer.valueOf(table.getValueAt(row, 5).toString());
                ModelData staff = (ModelData) table.getModelData(row);
                ModelData data = new ModelData(kdBarang, nama, model, jenis, kadar, berat);
                try {
                    if (staff.getId() == 0) {
                        //  Insert
                        new ServiceData().insertData(data);
                        table.updateModelData(row, data);
                    } else {
                        //  Update
                        new ServiceData().updateData(data);
                        table.updateModelData(row, data);
                    }
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        });
    }
    
    @Override
    public void setData(Object o) {
        txt.setText(o.toString());
        
    }

    @Override
    public Object getData() {
        return txt.getText().trim();
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellKodeBarang cell = new CellKodeBarang();
        cell.setData(o);
        cell.addEventSave(tc);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button cmdSave;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
