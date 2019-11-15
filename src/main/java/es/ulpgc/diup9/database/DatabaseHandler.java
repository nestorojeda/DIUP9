/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diup9.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nestorojeda
 */


public final class DatabaseHandler {
    
    private Connection connection;
    private String user;
    private boolean connected = false;
    
    public DatabaseHandler(String user){
        this.user = user;
    }
    
    
    public boolean login(String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try{
            connection = DriverManager.getConnection("jdbc:mysql://mozart.dis.ulpgc.es/DIU_BD?useSSL=true", this.user, password);
            connected = true;
            return connected;
        }catch(SQLException e){
            return false;
        }
    }

    public Connection getConnection() {
        if (connected) return connection;
        else return null;
    }

    public String getUser() {
        return user;
    }
    
    public List<String> getTableList() throws SQLException {
        List<String> res = new ArrayList<>();
        DatabaseMetaData md = connection.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = md.getTables(null, null, "%", types);
        while (rs.next()) {
            res.add(rs.getString("TABLE_NAME"));
        }
        return res;
    }

    public String getAll() throws SQLException {
        StringBuilder res = new StringBuilder();
        DatabaseMetaData md = connection.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = md.getTables(null, null, "%", types);
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            res.append("Tabla: ").append(tableName).append("\n");
            ResultSet rs2 = md.getColumns(null, null, tableName, null);
            while (rs2.next()) {
                String nombreCampo = rs2.getString("COLUMN_NAME");
                res.append("   Campo: ").append(nombreCampo).append("\n");
            }
        }
        return res.toString();
    }


    public String getTableInfo(String table) throws SQLException {
        StringBuilder res = new StringBuilder();
        DatabaseMetaData md = connection.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = md.getTables(null, null, "%", types);
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            if(tableName.equals(table)){
                res.append("Tabla: ").append(tableName).append("\n");
                ResultSet rs2 = md.getColumns(null, null, tableName, null);
                while (rs2.next()) {
                    String nombreCampo = rs2.getString("COLUMN_NAME");
                    res.append("   Campo: ").append(nombreCampo).append("\n");
                }
            }
        }
        if(res.toString().isEmpty()) return "La tabla " + "\"" + table + "\"" +" no existe";
        return res.toString();
    }

    

    public void testConnect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        DatabaseMetaData md = connection.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = md.getTables(null, null, "%", types);
        while (rs.next()) {
            String nombreTabla = rs.getString("TABLE_NAME");
            System.out.println("Tabla: " + nombreTabla);
            ResultSet rs2 = md.getColumns(null, null, nombreTabla, null);
            while (rs2.next()) {
                String nombreCampo = rs2.getString("COLUMN_NAME");
                System.out.println("   Campo: " + nombreCampo);
            }
        }
    }
    
    
    public void closeConnection() throws SQLException{
        connection.close();
        connected = false;
    }

    public List<String> getFieldsList(String table) throws SQLException {
        List <String> list = new ArrayList<String>();
       
        
        DatabaseMetaData md = connection.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = md.getTables(null, null, "%", types);
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            if(tableName.equals(table)){
                ResultSet rs2 = md.getColumns(null, null, tableName, null);
                while (rs2.next()) {
                    String field = rs2.getString("COLUMN_NAME");
                    list.add(field);
                }
            }
        }
        
        return list;
    }
    
}
