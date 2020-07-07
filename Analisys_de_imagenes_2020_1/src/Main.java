
import analisisenfrecuencias.Gestor;
import analisisenfrecuencias.NumeroComplejo;
import analisisenfrecuencias.filtros.FiltroIdealPasaBajas;
import analisisenfrecuencias.filtros.FiltroPasaAltas;
import analisisenfrecuencias.filtros.Filtrobutter;
import analisisespacial.Convolucion;
import open.AbrirImagen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import analisisespacial.FiltrosEspaciales;
import analisisespacial.Histogramas;
import analisisespacial.Suavizado;
import gui.JFrameSegmentacion;
import gui.JframeImagen;
import java.awt.Dimension;
import lectura.ImageManager;

public class Main {
//Desenfoque, repujado
    public static void main(String[] args) {
     
//        Image imagen = AbrirImagen.openImage();
//        JframeImagen frame = new JframeImagen(imagen);
//        Histogramas ho = new Histogramas(imagen);
//        ho.Graph();
   
Image imagenO = ImageManager.openImage();
      JframeImagen frame1 = new JframeImagen(imagenO);
      Gestor gestor = new Gestor(ImageManager.toBufferedImage(imagenO));
      BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);
      JframeImagen frame2 = new JframeImagen(ImageManager.toImage(iFre));
      
//       creamos el filtro
        FiltroPasaAltas fipb = new FiltroPasaAltas(32,new Dimension(256, 256));
        fipb.crearFiltro();
        NumeroComplejo [][] filtro = fipb.getFiltroEspacial();
         JframeImagen frameFil = new JframeImagen(fipb.getImagen());
     gestor.aplicarFiltro(filtro);
      BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
      JframeImagen frame = new JframeImagen(ImageManager.toImage(imagenEspacial));
      
      // esta es la parte del analisis en frecuencias
//      // creamos el filtro
//        FiltroIdealPasaBajas fipb = new FiltroIdealPasaBajas(64,new Dimension(256, 256));
//        fipb.crearFiltro();
//        NumeroComplejo [][] filtro = fipb.getFiltroEspacial();
//         JframeImagen frameFil = new JframeImagen(fipb.getImagen());
//     gestor.aplicarFiltro(filtro);
//      
//      
//      BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
//       JframeImagen frame = new JframeImagen(ImageManager.toImage(imagenEspacial));
//       //creamos el filtro 2
//       
//             Filtrobutter fibu = new Filtrobutter(64,15,new Dimension(256, 256));
//        fibu.crearFiltro();
//        NumeroComplejo [][] filtro2 = fibu.getFiltroEspacial();
//         JframeImagen framebu = new JframeImagen(fibu.getImagen());
//     gestor.aplicarFiltro(filtro);
//      
//      
//      BufferedImage imagenEspacial1 = gestor.obtenerImagenEspacial();
//       JframeImagen frame3 = new JframeImagen(ImageManager.toImage(imagenEspacial1));
//       


//esta es la parte del analisis espacial y convoluciones

//        Image ruidoS = Suavizado.agregarRuidoSustractivo(imagen, 1);
//        JframeImagen frame2 = new JframeImagen(ruidoS);
//        Histogramas hrs = new Histogramas(ruidoS);
//        hrs.Graph();
////
////        int[][] mascara = new int[][]{{1,1,1},{1,1,1},{1,1,1}};
//        Image imagenSuavizada = Suavizado.suavizar(ruidoS, mascara);
//        JframeImagen frame3 = new JframeImagen(imagenSuavizada);
//        Histogramas his = new Histogramas(imagenSuavizada);
//        his.Graph();         
        
////        Image convolucionado = Convolucion.aplicarConvolucion(imagen, mascara, 4, 1); 
////        JframeImagen frame4= new JframeImagen(convolucionado);     
////        Histogramas hicon = new Histogramas(convolucionado);
////        hicon.Graph();
//        
//        Image imagen = AbrirImagen.openImage();
//   JframeImagen fi = new JframeImagen(imagen);
//     Histogramas h = new  Histogramas(imagen);
//        h.Graph();
////        
//FiltrosEspaciales.ecualizarImagen(imagen);
//
// Image ruidos = Suavizado.agregarRuidoSustractivo(imagen, 1);
//       JframeImagen fic = new JframeImagen(ruidos);
//        Histogramas h1 = new  Histogramas(ruidos);
//        h1.Graph();

 
 //int [][]mascara =new int[][]{{1,1,1},{1,0,1},{1,1,1}};
   
        
        
//         Image grises = FiltrosEspaciales.generarImagenGrises(imagen);
//         BufferedImage big = AbrirImagen.toBufferedImage(grises); 
//         Histogramas hg =new Histogramas(grises);
//         hg.Graph();
//         int u= FiltrosEspaciales.metodoIterativo(hg.gethGrises());
//         JframeImagen bin = new JframeImagen(FiltrosEspaciales.imagen_separada(grises, u));
//         
         
//   Image iseparada = FiltrosEspaciales.imagen_separada(imagen, 90);
//   JframeImagen fic1 = new JframeImagen(iseparada);
     
//        
//       Image contraste = FiltrosEspaciales.expansionLineal(h, imagen);
//        JframeImagen fic = new JframeImagen(contraste);
//        Histogramas h1 = new  Histogramas(contraste);
//        h1.Graph();
//        
//      Image loga=FiltrosEspaciales.expancionLogaritmica(imagen);
//    JframeImagen f2 =new JframeImagen(loga);
//        Histogramas h2 = new  Histogramas(loga);
//        h2.Graph();
//        
//        Image exp =FiltrosEspaciales.expancionExponencial(imagen, 0.4);
//        JframeImagen f3= new JframeImagen(exp);
//           Histogramas h3 = new  Histogramas(exp);
//        h3.Graph();
//          Image chicharo =FiltrosEspaciales.expancionchicharo(imagen, 0.85);
//        JframeImagen f4= new JframeImagen(chicharo);
//           Histogramas h4 = new  Histogramas(chicharo);
//        h4.Graph();
        // Image imagenExp = FiltrosEspaciales.expansionLineal(min, max, imagen);
        // Histogramas h2 = new  Histogramas(imagenExp);
        // h2.Graph(); 
       
       
       
        System.out.println();

    }
}