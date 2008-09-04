/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package l2bot;

import java.util.ResourceBundle;
import java.util.Locale;

/**
 *
 * @author carl
 */
public class Idioma { //id name bodypart cristalizable armottype pero material pdef mdef mpbonus precio cristalcount sellable tradeable destruible dropeable
    public static String aceptar;
    public static String cancelar;
    public static String cerrar;
    public static String nuevo;
    public static String borrar;
    public static String editar;
    public static String aceptar_puedes_seleccionar_varias_cuentas;
    public static String cargar;
    public static String mostrar;
    public static String nombre;
    public static String host_ip_o_dominio;
    public static String puerto;
    public static String gameservers_separar_con_comas;
    public static String estado;
    public static String players_max;
    public static String mostrar_info;
    public static String usar;
    public static String tirar;
    public static String destruir;
    public static String cristalizar;
    
    
    public static void init(){
            ResourceBundle gf = ResourceBundle.getBundle("lang/main");
            aceptar = gf.getString("ACEPTAR");
            cancelar = gf.getString("CANCELAR");
            cerrar = gf.getString("CERRAR");
            nuevo = gf.getString("NUEVO");
            borrar = gf.getString("BORRAR");
            editar = gf.getString("EDITAR");
            aceptar_puedes_seleccionar_varias_cuentas = gf.getString("ACEPTAR_PUEDES_SELECCIONAR_VARIAS_CUENTAS");
            cargar = gf.getString("CARGAR");
            mostrar = gf.getString("MOSTRAR");
            nombre = gf.getString("NOMBRE");
            host_ip_o_dominio = gf.getString("HOST_IP_O_DOMINIO");
            puerto = gf.getString("PUERTO");
            gameservers_separar_con_comas = gf.getString("GAMESERVERS_SEPARAR_CON_COMAS");
            estado = gf.getString("ESTADO");
            players_max = gf.getString("PLAYERS_MAX");
            mostrar_info = gf.getString("MOSTRAR_INFO");
            usar = gf.getString("USAR");
            tirar = gf.getString("TIRAR");
            destruir = gf.getString("DESTRUIR");
            cristalizar = gf.getString("CRISTALIZAR");
    }
    
}
