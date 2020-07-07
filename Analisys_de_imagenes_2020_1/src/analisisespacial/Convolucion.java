package analisisespacial;

import static analisisespacial.FiltrosEspaciales.validarLimites;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Random;
import java.awt.Color;
import open.AbrirImagen;

public class Convolucion {

    public static Image aplicarConvolucion(Image io,int[][] mascara, int div, int offset){

        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        BufferedImage bnuevo = new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_INT_RGB);
        // recorres el buffer
        for(int x=0; x < bi.getWidth();x++){
            for(int y=0; y < bi.getHeight();y++){
            int rgb = calcularNuevoTono(x,y,bi,mascara, div, offset);
            bnuevo.setRGB(x, y, rgb);
            }
        }
        return AbrirImagen.toImage(bnuevo);
    }
      
    public static int validarValor(int valor){
      if(valor<0) return 0;
      if(valor>255) return 255;
      return valor;
    }

    private static int calcularNuevoTono(int x, int y, BufferedImage bi, int[][] mascara, int div, int offset) {
        
        // recorrer la mascara
        // int r = x -1;
        //int c = y -1;
        int auxR = 0, auxG = 0, auxB = 0;
        Color color = null;
        int k = 0;
        for(int i = 0 , r = x -1; i<mascara.length;i++, r++){
            for(int j = 0, c = y -1; j < mascara[0].length;j++, c++){
                // todo: quitar el if
                //if(mascara[i][j]!=0){
                    try {
                        int rgb = bi.getRGB(r, c);
                        
                        color = new Color(rgb);
                        // acomodar la multiplicación
                        auxR+= color.getRed()*mascara[i][j];
                        auxG+= color.getGreen()*mascara[i][j];
                        auxB+= color.getBlue()*mascara[i][j];
                        
                    } catch (Exception e) {
                        // nada de nada 
                    } //}
            }
        }
        // quitar k
        // quitar el if
        
        auxR/=div;
        auxG/=div;
        auxB/=div;
        color = new Color(validarLimites(auxR+offset),validarLimites(auxG+offset),validarLimites(auxB+offset));
       // color = new Color(auxR+offset,auxG+offset,auxB+offset);
        return color.getRGB();
    }

}
