package com.app.component;

import com.app.swing.PanelBackground;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class HeaderComponent extends javax.swing.JPanel {

    public HeaderComponent() {
        initComponents();
        setOpaque(false);
    }

//    public void initEvent(JFrame fram, PanelBackground panel) {
//        winButton1.initEvent(fram, panel);
//    }
    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (fram.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(me)) {
                    x = me.getX();
                    y = me.getY();
                }
            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                if (fram.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(me)) {
                    fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
