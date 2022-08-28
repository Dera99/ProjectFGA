package com.app.cell;

import com.app.config.SystemProperties;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Color;

public class CellKadar extends TableCustomCell{

    public CellKadar() {
        initComponents();
        txt.setBackground(new Color(0,0,0,0));
        txt.setForeground(new Color(230,230,230));
        SystemProperties pro = new SystemProperties();
        pro.loadFromFile();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.app.swing.Combobox();

        txt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "99%", "80%", "75%", "70%" }));
        txt.setSelectedIndex(-1);
        txt.setLabeText("Kadar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {
        txt.setSelectedItem(o.toString());
        
    }

    @Override
    public Object getData() {
        return txt.getSelectedItem();
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellKadar cell = new CellKadar();
        cell.setData(o);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Combobox txt;
    // End of variables declaration//GEN-END:variables
}
