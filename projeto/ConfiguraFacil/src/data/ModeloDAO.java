/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.*;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author diogo
 */

public class ModeloDAO implements Map<Integer,Modelo> {

    public Connection conn;

    public ModeloDAO () {
         Connect con = new Connect();
         this.conn = con.Connect();
    }

    public void CloseDAO() throws SQLException{
        Connect con = new Connect();
        con.close(this.conn);
    }
    
    @Override
    public void clear () {
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Componente");
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public boolean containsKey(Object key) throws NullPointerException {
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT name FROM Componente WHERE ID='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public boolean containsValue(Object value) {
        throw new NullPointerException("public boolean containsValue(Object value) not implemented!");
    }

    @Override
    public Set<Map.Entry<Integer,Modelo>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Modelo>> entrySet() not implemented!");
    }

    @Override
    public boolean equals(Object o) {
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }

    //É preciso eu rever o put e o get porque preciso de ver as strings dentro de cada componente 
    @Override
    public Modelo get(Object key) {
        try {
            Modelo al = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Componente WHERE ID='"+ key +"' and Tipo = 2";
            ResultSet rs = stm.executeQuery(sql);
            int ID, stock, tipo;
            double price;
            String name, incompativeis, extras, modelos;
            ArrayList<Integer> ID_incompativeis = new ArrayList<>();
            ArrayList<Integer> ID_extras = new ArrayList<>();
            ArrayList<Integer> ID_modelos = new ArrayList<>();
            
            Integer s;
            if (rs.next()){
                ID = Integer.valueOf(rs.getString(1));
                stock = Integer.valueOf(rs.getString(2));
                price = Double.valueOf(rs.getString(3));
                name = rs.getString(4);
                incompativeis = rs.getString(5);
                if (incompativeis != null){
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(incompativeis.split(",")));
                    list.forEach((current) -> {
                        ID_incompativeis.add(Integer.valueOf(current));
                    });
                }
                extras = rs.getString(6);
                if (extras != null){
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(extras.split(",")));
                    list.forEach((current) -> {
                        ID_extras.add(Integer.valueOf(current));
                    });
                }                
                modelos = rs.getString(7);
                if (modelos != null){
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(modelos.split(",")));
                    list.forEach((current) -> {
                        ID_modelos.add(Integer.valueOf(current));
                    });
                }
                tipo = Integer.valueOf(rs.getString(8));
                al = new Modelo(ID, name, price, ID_extras, ID_incompativeis); 
            }
            return al;
        } catch (SQLException e) {throw new NullPointerException(e.getMessage());}     
    }

    @Override
    public int hashCode() {
        return this.conn.hashCode();
    }

    @Override
    public boolean isEmpty() {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Name FROM Componente");
            return !rs.next();
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Set<Integer> keySet() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Modelo put(Integer key, Modelo value) {
        try {
            Modelo al = null;
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Componente WHERE ID='"+ key +"'");
            String modelos = "null";
            StringBuilder extras = new StringBuilder();
            StringBuilder incompativeis = new StringBuilder();
            if (value.getIncompatible() != null){
                for (Integer s : value.getIncompatible()){
                    incompativeis.append(Integer.toString(s));
                    incompativeis.append(",");
                }
            }
            if (value.getExtra() != null){
                for (Integer s : value.getExtra()){
                    extras.append(Integer.toString(s));
                    extras.append(",");
                }
            }   
            int tipo = 2;
            String nome = value.getName();
            int id = value.getCod();
            int stock = value.getStock();
            double price = value.getPrice();
            String sql = "INSERT INTO Componente VALUES (" + id + "," + stock + "," + price + ",'" + nome + "','" + incompativeis.toString() + "','" + extras.toString() + "','" + modelos + "'," + tipo +");";
            int i  = stm.executeUpdate(sql);
            return new Modelo(id,nome,price);
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}   
    }

    @Override
    public void putAll(Map<? extends Integer,? extends Modelo> t) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Modelo remove(Object key) {
        try {
            Modelo al = this.get(key);
            Statement stm = conn.createStatement();
            String sql = "DELETE '"+key+"' FROM Componente";
            int i  = stm.executeUpdate(sql);
            return al;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Name FROM Componente");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    @Override
    public Collection<Modelo> values() {
        try {
            Collection<Modelo> col = new HashSet<>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Componente WHERE Tipo = 2");
            for (;rs.next();) {                    
                int ID, stock, tipo;
                double price;
                String name, incompativeis, extras, modelos;
                ArrayList<Integer> ID_incompativeis = new ArrayList<>();
                ArrayList<Integer> ID_extras = new ArrayList<>();
                ArrayList<Integer> ID_modelos = new ArrayList<>();
            
                Modelo al;                                    
                ID = Integer.valueOf(rs.getString(1));
                stock = Integer.valueOf(rs.getString(2));
                price = Double.valueOf(rs.getString(3));
                name = rs.getString(4);
                incompativeis = rs.getString(5);
                if (incompativeis != null){
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(incompativeis.split(",")));
                    list.forEach((current) -> {
                        ID_incompativeis.add(Integer.valueOf(current));
                    });
                }
                extras = rs.getString(6);
                if (extras != null){
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(extras.split(",")));
                    list.forEach((current) -> {
                        ID_extras.add(Integer.valueOf(current));
                    });
                }                
                modelos = rs.getString(7);
                if (modelos != null){
                    ArrayList<String> list;
                    list = new ArrayList<>(Arrays.asList(modelos.split(",")));
                    list.forEach((current) -> {
                        ID_modelos.add(Integer.valueOf(current));
                    });
                }
                tipo = Integer.valueOf(rs.getString(8));
                al = new Modelo(ID, name, price, ID_extras, ID_incompativeis); 
                col.add(al);              
            }
            return col;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }    

}

    
