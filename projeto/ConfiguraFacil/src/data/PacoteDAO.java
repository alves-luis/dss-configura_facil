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

public class PacoteDAO implements Map<Integer,Pacote> {

    public Connection conn;

    public PacoteDAO () {
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
            stm.executeUpdate("DELETE FROM Pacote");
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public boolean containsKey(Object key) throws NullPointerException {
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT name FROM Pacote WHERE id='"+ key +"'";
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
    public Set<Map.Entry<Integer,Pacote>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Pacote>> entrySet() not implemented!");
    }

    @Override
    public boolean equals(Object o) {
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }

    @Override
    public Pacote get(Object key) {        
        try {
            Pacote al = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Pacote WHERE ID='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql); 
            
            int id = -1;
            String nome = "";
            String componente;
            double desconto = 0;
            ArrayList<Componente> ID_Componente = new ArrayList<>();
            if (rs.next()){
                id = Integer.valueOf(rs.getString(1));
                nome = rs.getString(2);
                desconto = Double.valueOf(rs.getString(3));
                componente = rs.getString(3);
                if (componente != null){
                    ArrayList<String> list = new ArrayList<String>(Arrays.asList(componente.split(",")));
                    for(String current : list){
                        ComponenteDAO con = new ComponenteDAO();                        
                        ID_Componente.add(con.get(Integer.valueOf(current)));
                    }   
                }
            }
                al = new Pacote(id, nome, desconto, ID_Componente); 
            return al;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}       
    }

    @Override
    public int hashCode() {
        return this.conn.hashCode();
    }

    @Override
    public boolean isEmpty() {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT name FROM Pacote");
            return !rs.next();
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Set<Integer> keySet() {
        throw new NullPointerException("Not implemented!");
    }

    public Pacote put(Integer key, Pacote value) {       
        try {
            Componente al = null;
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Componente WHERE ID='"+ Integer.toString(key) +"'");
            
            StringBuilder componentes = new StringBuilder();
            if (value.getComponentes() != null){
                for (Componente s : value.getComponentes()){
                    componentes.append(Integer.toString(s.getCod()));
                    componentes.append(",");
                }
            }
            String nome = value.getName();
            int id = value.getId();
            double desconto = value.getDesconto();           
            String sql = "INSERT INTO Pacote VALUES (" + id + ",'" + nome + "'," + desconto + ",'" + componentes.toString() +"');";
            int i  = stm.executeUpdate(sql);
            return new Pacote(id,nome,desconto, (ArrayList<Componente>) value.getComponentes());
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public void putAll(Map<? extends Integer,? extends Pacote> t) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Pacote remove(Object key) {
        try {
            Pacote al = this.get(key);
            Statement stm = conn.createStatement();
            String sql = "DELETE '"+key+"' FROM Pacote";
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
            ResultSet rs = stm.executeQuery("SELECT nome FROM Pacote");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Collection<Pacote> values() {
        try {            
            Collection<Pacote> col = new HashSet<>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Pacote");
            for (;rs.next();) {                    
                Pacote al;            
                int id = -1;
                String nome = "";               
                double desconto = 0;
                
                String componente;
                ArrayList<Componente> ID_Componente = new ArrayList<>();
                id = Integer.valueOf(rs.getString(1));
                nome = rs.getString(2);
                desconto = Double.valueOf(rs.getString(3));
                componente = rs.getString(4);
                if (componente != null){
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(componente.split(",")));
                    for(String current : list){
                        ComponenteDAO con = new ComponenteDAO();
                        ID_Componente.add(con.get(Integer.valueOf(current)));
                        con.CloseDAO();
                    }   
                }
                al = new Pacote(id, nome, desconto, ID_Componente);
                col.add(al);
            }
            return col;
        } catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}    
    }
}

    
