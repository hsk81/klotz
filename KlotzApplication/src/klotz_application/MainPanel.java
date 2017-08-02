package klotz_application;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author hsk81
 */
public class MainPanel extends javax.swing.JPanel {

    private Integer center_x = null;
    private final Integer center_dx = 48;
    private Integer center_y = null;
    private final Integer center_dy = 48;

    private Integer moving_x = null;
    private final Integer moving_dx = 48;
    private Integer moving_y = null;
    private final Integer moving_dy = 48;

    public MainPanel() {
        initComponents();
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

    @Override
    public void paintComponent(Graphics g) {

        this.calculateCenterBlock();
        this.calculateMovingBlock();

        this.renderGameField(g);
        this.renderCenterBlock(g);
        this.renderMovingBlock(g);
    }

    private void calculateCenterBlock() {
        if (this.center_x == null) {
            this.center_x = this.getWidth()/2;
        }
        if (this.center_y == null) {
            this.center_y = this.getHeight() - this.center_dy/2 - 1;
        }
    }

    private void calculateMovingBlock() {
        if (this.moving_x == null) {
            this.moving_x = this.getWidth() - this.moving_dx/2 - 1;
        }
        if (this.moving_y == null) {
            this.moving_y = this.getHeight() - this.moving_dy/2 - 1;
        }
        if (this.moving_x + this.moving_dx > 0) {
            this.moving_x = (this.moving_x - 1) % this.getWidth();
        } else {
            this.moving_x = this.getWidth();
        }
    }
    
    private void renderGameField(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    private void renderCenterBlock(Graphics g) {
        if (this.center_y - this.moving_y == 0
         && this.moving_x > this.center_x
         && this.moving_x < this.center_x + this.center_dx)
        {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.yellow);
        }
        g.fillRect(
                this.center_x - this.center_dx / 2,
                this.center_y - this.center_dy / 2,
                this.center_dx,
                this.center_dy);
    }

    private void renderMovingBlock(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(
                this.moving_x - this.moving_dx / 2,
                this.moving_y - this.moving_dy / 2,
                this.moving_dx,
                this.moving_dy);
    }

    public void toggleCenterBlock() {
        if (this.center_y == this.center_dy/2 + 1) {
            this.center_y = this.getHeight() - this.center_dy/2 - 1;
        } else {
            this.center_y = this.center_dy/2 + 1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
