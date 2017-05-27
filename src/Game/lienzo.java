package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class lienzo extends javax.swing.JPanel implements Runnable {

    //Variables
    //####################################################
    int campeones = 16;
    int camp = 4;
    int v1 = 1;
    int posClickAnterior = 100;
    boolean seDescubrio = false;
    boolean puntaje = false;
    int posClickAnteriorFalse = 100;
    int i1 = 0, cantidad = 16, rango = 16;
    int i2 = 0, cantidadImg = 8, rangoImg = 16;
    private final Image[] imgTablero = new Image[campeones];
    private final Image[] imgTapa1 = new Image[campeones];
    private final Image[] imgTapa2 = new Image[campeones];
    private final Image[] anterior = new Image[v1];
    private final int[] descubierta = new int[campeones];
    private final int[] posImagen = new int[cantidadImg];
    private final int[] posTablero = new int[cantidad];
    private final int[] coordenadasX = new int[campeones];
    private final int[] coordenadasY = new int[campeones];
    private final int[][] matrizPos = new int[camp][camp];
    private final Thread hilo;
    //####################################################

    public lienzo() {
        initComponents();
        iniciarValoresJuego();
        this.setBackground(Color.white);
        hilo = new Thread(this);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("pinte");
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        //===========1 FILA========================
        for (int z = 0; z < 16; z++) {
            g.drawImage(imgTablero[z], coordenadasX[z], coordenadasY[z], this);
            g.drawImage(imgTapa1[z], coordenadasX[z], coordenadasY[z], this);
            g.drawImage(imgTapa2[z], coordenadasX[z], coordenadasY[z], this);
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
            repaint();
        } catch (InterruptedException ex) {
            System.out.println("failRun:" + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void inicio() {
        hilo.start();
    }

    public boolean fijarSeleccion(int x, int y) {
        //#########################################################################
        //=========X FILA Y COLUMNA================================================        
        int posClick;
        posClick = matrizPos[x][y];
        //#########################################################################
        //=========REVISAR QUE LA CARTA ESTE SIN ENCONTRAR=========================        
        if (descubierta[posClick] != 1 && posClick != posClickAnterior) {
            //#########################################################################
            //Descubrir seleccion
            imgTapa1[posClick] = loadImage(null);
            imgTapa2[posClick] = loadImage(null);
            if (anterior[0].equals(imgTablero[posClick])) {
                descubierta[posClick] = 1;
                descubierta[posClickAnterior] = 1;
                seDescubrio = true;
            } else {
                if (seDescubrio) {

                } else {
                    if (posClickAnterior != 100) {
                        imgTapa1[posClickAnterior] = loadImage("assets/Blanco.png");
                        imgTapa2[posClickAnterior] = loadImage("assets/Tapa2.png");
                    }

                }
                seDescubrio = false;
            }
            anterior[0] = imgTablero[posClick];
            posClickAnterior = posClick;
            puntaje = true;
        } else {
            puntaje = false;
        }
        return puntaje;
    }

    public void iniciarValoresJuego() {
        //====================================================
        //Posicion Imagenes tablero        
        posTablero[i1] = (int) (Math.random() * rango);
        for (i1 = 1; i1 < cantidad; i1++) {
            posTablero[i1] = (int) (Math.random() * rango);
            for (int j = 0; j < i1; j++) {
                if (posTablero[i1] == posTablero[j]) {
                    i1--;
                }
            }
        }
        for (int k = 0; k < cantidad; k++) {
            System.out.print((k + 1) + ".- " + posTablero[k] + "\n");
        }

        //Imagenes selecionadas        
        posImagen[i2] = (int) (Math.random() * rangoImg);
        for (i2 = 1; i2 < cantidadImg; i2++) {
            posImagen[i2] = (int) (Math.random() * rangoImg);
            for (int j = 0; j < i2; j++) {
                if (posImagen[i2] == posImagen[j]) {
                    i2--;
                }
            }
        }
        //====================================================
        //Importar Imagenes       
        imgTablero[posTablero[0]] = loadImage("assets/" + posImagen[0] + ".png");
        imgTablero[posTablero[1]] = loadImage("assets/" + posImagen[0] + ".png");
        imgTablero[posTablero[2]] = loadImage("assets/" + posImagen[1] + ".png");
        imgTablero[posTablero[3]] = loadImage("assets/" + posImagen[1] + ".png");
        imgTablero[posTablero[4]] = loadImage("assets/" + posImagen[2] + ".png");
        imgTablero[posTablero[5]] = loadImage("assets/" + posImagen[2] + ".png");
        imgTablero[posTablero[6]] = loadImage("assets/" + posImagen[3] + ".png");
        imgTablero[posTablero[7]] = loadImage("assets/" + posImagen[3] + ".png");
        imgTablero[posTablero[8]] = loadImage("assets/" + posImagen[4] + ".png");
        imgTablero[posTablero[9]] = loadImage("assets/" + posImagen[4] + ".png");
        imgTablero[posTablero[10]] = loadImage("assets/" + posImagen[5] + ".png");
        imgTablero[posTablero[11]] = loadImage("assets/" + posImagen[5] + ".png");
        imgTablero[posTablero[12]] = loadImage("assets/" + posImagen[6] + ".png");
        imgTablero[posTablero[13]] = loadImage("assets/" + posImagen[6] + ".png");
        imgTablero[posTablero[14]] = loadImage("assets/" + posImagen[7] + ".png");
        imgTablero[posTablero[15]] = loadImage("assets/" + posImagen[7] + ".png");
        //====================================================
        //Importar Imagenes Tapas
        for (int z = 0; z < 16; z++) {
            imgTapa1[z] = loadImage("assets/Blanco.png");
            imgTapa2[z] = loadImage("assets/Tapa2.png");
        }
        //
        anterior[0] = loadImage(null);
        //Establecer Coordenadas X
        coordenadasX[0] = 0;
        coordenadasX[1] = 120;
        coordenadasX[2] = 240;
        coordenadasX[3] = 360;
        coordenadasX[4] = 0;
        coordenadasX[5] = 120;
        coordenadasX[6] = 240;
        coordenadasX[7] = 360;
        coordenadasX[8] = 0;
        coordenadasX[9] = 120;
        coordenadasX[10] = 240;
        coordenadasX[11] = 360;
        coordenadasX[12] = 0;
        coordenadasX[13] = 120;
        coordenadasX[14] = 240;
        coordenadasX[15] = 360;
        //Establecer Coordenadas Y
        coordenadasY[0] = 0;
        coordenadasY[1] = 0;
        coordenadasY[2] = 0;
        coordenadasY[3] = 0;
        coordenadasY[4] = 120;
        coordenadasY[5] = 120;
        coordenadasY[6] = 120;
        coordenadasY[7] = 120;
        coordenadasY[8] = 240;
        coordenadasY[9] = 240;
        coordenadasY[10] = 240;
        coordenadasY[11] = 240;
        coordenadasY[12] = 360;
        coordenadasY[13] = 360;
        coordenadasY[14] = 360;
        coordenadasY[15] = 360;
        //Establecer posiciones matriz tablero
        matrizPos[0][0] = 0;
        matrizPos[0][1] = 1;
        matrizPos[0][2] = 2;
        matrizPos[0][3] = 3;
        matrizPos[1][0] = 4;
        matrizPos[1][1] = 5;
        matrizPos[1][2] = 6;
        matrizPos[1][3] = 7;
        matrizPos[2][0] = 8;
        matrizPos[2][1] = 9;
        matrizPos[2][2] = 10;
        matrizPos[2][3] = 11;
        matrizPos[3][0] = 12;
        matrizPos[3][1] = 13;
        matrizPos[3][2] = 14;
        matrizPos[3][3] = 15;
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
