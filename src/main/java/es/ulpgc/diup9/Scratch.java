/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diup9;

import java.sql.Connection;
import java.sql.SQLException;
import es.ulpgc.diup9.database.DatabaseHandler;

/**
 *
 * @author nestorojeda
 */
public class Scratch {
     public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DatabaseHandler dh1 = new DatabaseHandler("estudiante-DIU");
        DatabaseHandler dh2 = new DatabaseHandler("Usuario que no existe");
        
        if(dh1.login("DIU-aed56-noi")){
            System.out.println("Log: Loggin process succesful");
        }else{
            System.out.println("Log: Loggin process failed");
        }
        
        if(dh2.login("DIU-aeasd56-noi")){
            System.out.println("Log: Loggin process succesful");
        }else{
            System.out.println("Log: Loggin process failed");
        }
         
        System.out.println("Prueba getAll() ");
        System.out.println(dh1.getAll());
        



        System.out.println("Prueba getTableInfo() de una tabla que existe ");
        System.out.println(dh1.getTableInfo("vehiculo"));

        System.out.println("Prueba getTableInfo() de una tabla que no existe ");
        System.out.println(dh1.getTableInfo("caca de vaca"));

        System.out.println("Prueba getTableList");
        System.out.println(dh1.getTableList().toString());
        System.out.println("Prueba getFieldList");
        System.out.println(dh1.getFieldsList("vehiculo").toString());
        System.out.println("Prueba getFieldList");
        System.out.println(dh1.getFieldsList("producto").toString());

    }
    
}
