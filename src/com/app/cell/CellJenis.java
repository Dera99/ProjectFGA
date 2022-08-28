package com.app.cell;

import com.app.config.SystemProperties;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Color;

public class CellJenis extends TableCustomCell{

    public CellJenis() {
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

        txt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Emas Kuning", "Emas Putih" }));
        txt.setSelectedIndex(-1);
        txt.setLabeText("Jenis");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        CellJenis cell = new CellJenis();
        cell.setData(o);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Combobox txt;
    // End of variables declaration//GEN-END:variables
}
