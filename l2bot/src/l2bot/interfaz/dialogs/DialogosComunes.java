/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot.interfaz.dialogs;

import l2bot.Main;

/**
 *
 * @author carl
 */
public class DialogosComunes {

    public static int PreguntarNumero(String Pregunta, int minimo, int maximo, int predeterminado){
        DialogoNumero DN = new DialogoNumero(Main.g,true,Pregunta,minimo,maximo,predeterminado,1);
        if(DN.cancel){
            return minimo-1;
        }else{
            return DN.getValue();
        }

    }
    
    public static int PreguntarNumero(String Pregunta, int minimo, int predeterminado){
    DialogoNumero DN = new DialogoNumero(Main.g,true,Pregunta,minimo,-1,predeterminado,1);
    if(DN.cancel){
        return minimo-1;
    }else{
        return DN.getValue();
    }

    }
   public static int PreguntarNumero(String Pregunta, int minimo){
    DialogoNumero DN = new DialogoNumero(Main.g,true,Pregunta,minimo,-1,0,1);
    if(DN.cancel){
        return minimo-1;
    }else{
        return DN.getValue();
    }

    }  
      public static int PreguntarNumero(String Pregunta){
    DialogoNumero DN = new DialogoNumero(Main.g,true,Pregunta,0,-1,0,1);
    if(DN.cancel){
        return -1;
    }else{
        return DN.getValue();
    }

    } 
      
    public static void mostrarTexto(String text){
        new MostrarTexto(Main.g,text).setVisible(true);
    }  
    
    public static Propiedades propiedades(String eso){
        Propiedades p = new Propiedades(Main.g);
        p.addRow(eso);
        return p;
    }
}
