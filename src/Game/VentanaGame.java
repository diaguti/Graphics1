package Game;

import javax.swing.JOptionPane;

public class VentanaGame extends javax.swing.JFrame {

    private int posX, posY;    
    private int mouseClicked = 0;
    private boolean puntaje = false;
            
    public VentanaGame() {
        initComponents();        
        lienzo1.inicio();
        lienzo1.run();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo1 = new Game.lienzo();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelPuntaje = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lienzo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lienzo1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout lienzo1Layout = new javax.swing.GroupLayout(lienzo1);
        lienzo1.setLayout(lienzo1Layout);
        lienzo1Layout.setHorizontalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        lienzo1Layout.setVerticalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        getContentPane().add(lienzo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 480, 480));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Encuentra todas las parejas en el menor número de intentos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Intentos:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabelPuntaje.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPuntaje.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabelPuntaje.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lienzo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzo1MousePressed
        posX = (evt.getX()/120);
        posY = (evt.getY()/120);        
        if(lienzo1.fijarSeleccion(posY, posX)){
            mouseClicked++;
        }
        lienzo1.run();        
        System.out.println(mouseClicked);
        jLabelPuntaje.setText(String.valueOf(mouseClicked));        
    }//GEN-LAST:event_lienzo1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelPuntaje;
    private Game.lienzo lienzo1;
    // End of variables declaration//GEN-END:variables
}
