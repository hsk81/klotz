package klotz_application;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author hsk81
 */
public class MainPanel extends javax.swing.JPanel {

    private Integer x = null;
    private Integer y = null;
    private final Integer dx = 32;
    private final Integer dy = 32;
    
    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        
        if (this.x == null) {
            this.x = this.getWidth()/2;
        }
        if (this.y == null) {
            this.y = this.getHeight()/2;
        }
        
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.cyan);
        g.fillRect(this.x-this.dx/2, this.y-this.dy/2, this.dx, this.dy);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        this.x = evt.getX();
        this.y = evt.getY();
        this.repaint();
    }//GEN-LAST:event_formMouseMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
