/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;

/**
 *
 * @author cesar
 */
public class Raton extends MouseAdapter{
    private Point pocision;
    public Raton(){
        pocision = new Point();
actualizarPosicion();   
    }
    public void dibujar(final Graphics g){
        
        
        g.setColor(Color.BLACK);
        g.drawOval((int)obtenerPosicion().getX(),(int)obtenerPosicion().getY(), 10, 12);
    }
    
    private void actualizarPosicion(){
        final Point pocisionInicial = MouseInfo.getPointerInfo().getLocation();
          
        pocision.setLocation(pocisionInicial.getX(),pocisionInicial.getY());
    }
    
    public Point obtenerPosicion(){
        return pocision;
    }
}
