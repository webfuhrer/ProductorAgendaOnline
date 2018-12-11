/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteproductor;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class PintarXML {
    public static String pintar(ArrayList<Contacto> lista_contactos)
    {
        String xml="<?xml version='1.0'?>";
        xml+="<agenda>";
        for (Contacto contacto : lista_contactos) {
            xml+="<contacto><nombre>"+contacto.getNombre()+"</nombre><email>"+contacto.getEmail()+"</email></contacto>";
        }
        xml+="</agenda>";
        return xml;
    }
}
