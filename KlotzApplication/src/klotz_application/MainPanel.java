package klotz_application;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author hsk81
 */
public class MainPanel extends javax.swing.JPanel {

    private Integer i = null;
    private final Integer di = 48;
    private Integer j = null;
    private final Integer dj = 48;

    private Integer x = null;
    private final Integer dx = 48;
    private Integer y = null;
    private final Integer dy = 48;

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {

        if (this.i == null) {
            this.i = this.getWidth()/2;
        }
        if (this.j == null) {
            this.j = this.getHeight() - this.dj/2 - 1;
        }

        if (this.x == null) {
            this.x = this.getWidth() - this.dx/2 - 1;
        }
        if (this.y == null) {
            this.y = this.getHeight() - this.dy/2 - 1;
        }

        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(this.j - this.y == 0 
                && this.x > this.i 
                && this.x < this.i + this.di ? Color.red : Color.yellow);
        g.fillRect(this.i-this.di/2, this.j-this.dj/2, this.di, this.dj);

        g.setColor(Color.cyan);
        g.fillRect(this.x-this.dx/2, this.y-this.dy/2, this.dx, this.dy);

        if (this.x + this.dx > 0) {
            this.x = (this.x - 1) % this.getWidth();
        } else {
            this.x = this.getWidth();
        }
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
        this.repaint();
    }//GEN-LAST:event_formMouseMoved

    public void jump() {
        if (this.j == this.dj/2 + 1) {
            this.j = this.getHeight() - this.dj/2 - 1;
        } else {
            this.j = this.dj/2 + 1;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
