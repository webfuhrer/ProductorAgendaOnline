/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteproductor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
class AccesoBD {
    static String usuario="root";
    static String password="";
    static String url="jdbc:mysql://localhost:3306/bd_agenda?serverTimezone=UTC";

    
    public static void insertarContacto(Contacto c) {
        Properties info=new Properties();
                info.setProperty("user", usuario);
                info.setProperty("password",password);
        try {
            Connection conexion=DriverManager.getConnection(url, info);
            Statement stmt=conexion.createStatement();
            String query="INSERT INTO agenda VALUES('"+c.getNombre()+"', '"+c.getEmail()+"')";
            
            stmt.executeUpdate(query);
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Contacto> listarContactos(String nombre_buscado) {
        try {
            //Si nombre buscado está vacío realmente hay que ñistar todos
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Contacto> lista_contactos=new ArrayList();
        Properties info=new Properties();
                info.setProperty("user", usuario);
                info.setProperty("password",password);
        try {
            Connection conexion=DriverManager.getConnection(url, info);
            Statement stmt=conexion.createStatement();
            String query ="SELECT * FROM agenda ";
            if(nombre_buscado.equals(""))
            {}
            else
            {
                query=query+" WHERE nombre LIKE '%"+nombre_buscado+"%'";
            }
            //System.out.println("CONSULTA:"+query);
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                String email=rs.getString("email");
                
                Contacto c=new Contacto(nombre, email);
                lista_contactos.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista_contactos;
    }

    public static ArrayList<Contacto> buscarPorNombre(String nombre_buscado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

