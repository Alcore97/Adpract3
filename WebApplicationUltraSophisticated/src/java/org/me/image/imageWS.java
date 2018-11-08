/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.image;

import packImages.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author 
 */
@WebService(serviceName = "imageWS")
@XmlSeeAlso(Image.class)
public class imageWS {

    /**
     * This is a sample web service operation
     * @param titulo
     * @param author
     * @param paraulaclau
     * @param fecha
     * @return 
     */          
    //registrar imatge
    @WebMethod(operationName = "RegisterImage")
    public String RegisterImage (@WebParam(name = "titulo") String titulo, @WebParam(name = "author") String author, @WebParam(name = "paraulaclau") String paraulaclau,
                               @WebParam(name = "fecha") String fecha) {
        Connection connection = null;
        String r;
        try {
            
          connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adri\\Documents\\LABAD.db");
                 
        PreparedStatement statement = connection.prepareStatement("insert into imatges values(?,?,?,?,?)");
        int id = 10;
        statement.setInt(1,id);
        statement.setString(2,titulo);
        statement.setString(3,paraulaclau);
        statement.setString(4,author);
        statement.setString(5,fecha);
        
        statement.executeUpdate();
        r = "bien";
        }
    catch(SQLException e)
        {
          System.err.println("SQL EXCEPTION: " + e.getMessage());
          return "mal";
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
            System.out.println("closed connection");
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }
        return r;
        
    }
    
        //modificar imatge

    /**
     *
     * @param idImag
     * @param titulo
     * @param author
     * @param paraulaclau
     * @param fecha
     * @return
     */
    @WebMethod(operationName = "ModifyImage")
    public int ModifyImage (@WebParam(name = "idImag") int idImag, @WebParam(name = "titulo") String titulo, @WebParam(name = "author") String author, 
            @WebParam(name = "paraulaclau") String paraulaclau, @WebParam(name = "fecha") String fecha) {
        Connection connection = null;
        int r = 0;
        try {
            Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adri\\Documents\\LABAD.db");
        PreparedStatement statement = connection.prepareStatement("update imatges set titol_imatge = ?, paraula_clau = ?,"
                                                                + "autor = ?, data_creacio = ? where id_imatge = ?");
        
        
        statement.setString(1,titulo);
        statement.setString(2,paraulaclau);
        statement.setString(3,author);
        statement.setString(4,fecha);
        statement.setInt(5,idImag);
        
        r = statement.executeUpdate();
        }
        
        catch(SQLException | ClassNotFoundException e )
        {
          System.err.println("SQL EXCEPTION: " + e.getMessage());
          return 0;
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
            System.out.println("closed connection");
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }
        return r;
    }
    
    /**
     * This is a sample web service operation
     * @return
     */
     //llistar imatges
    @WebMethod(operationName = "ListImages")
    public List<Image> listImages() {
        Connection connection = null;
        List<Image> llista = new ArrayList<Image>();
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adri\\Documents\\LABAD.db");
            PreparedStatement statement = connection.prepareStatement("select * from imatges");
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                Image i1 = new Image();
                i1.SetIdImag(rs.getInt("id_imatge"));
                i1.SetTitulo(rs.getString("titol_imatge"));
                i1.SetParaulaClau(rs.getString("paraula_clau"));
                i1.SetAutor(rs.getString("autor"));
                i1.SetFecha(rs.getString("data_creacio"));
                
                llista.add(i1);
                
            }

        }
       catch(SQLException | ClassNotFoundException e )
        {
          System.err.println("SQL EXCEPTION: " + e.getMessage());
          return null;
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
            System.out.println("closed connection");
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }
        return llista; 
    }
    
    //buscar per id
    @WebMethod(operationName = "SearchbyId")
    public Image SearchbyId(@WebParam(name = "id_imatge")int id_imatge) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
           connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adri\\Documents\\LABAD.db");
            PreparedStatement statement = connection.prepareStatement("select * from imatges where id_imatge = ?");
            statement.setInt(1,id_imatge);
            ResultSet rs = statement.executeQuery();
                Image i1 = new Image();
                i1.SetIdImag(rs.getInt("id_imatge"));
                i1.SetTitulo(rs.getString("titol_imatge"));
                i1.SetParaulaClau(rs.getString("paraula_clau"));
                i1.SetAutor(rs.getString("autor"));
                i1.SetFecha(rs.getString("data_creacio"));
        
                return i1;      
        }
        catch(SQLException | ClassNotFoundException e )
        {
          System.err.println("SQL EXCEPTION: " + e.getMessage());
          return null;
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
            System.out.println("closed connection");
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        } 
    }
    
    
    //buscar per titol
    @WebMethod(operationName = "SearchByTitle")
        public List<Image> SearchbyTitle(@WebParam(name = "titol")String titol) {
            Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            List<Image> llista = new ArrayList<>();
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adri\\Documents\\LABAD.db");
            PreparedStatement statement = connection.prepareStatement("select * from imatges where titol_imatge = ?");
            statement.setString(1,titol);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                 Image i1 = new Image();
                i1.SetIdImag(rs.getInt("id_imatge"));
                i1.SetTitulo(rs.getString("titol_imatge"));
                i1.SetParaulaClau(rs.getString("paraula_clau"));
                i1.SetAutor(rs.getString("autor"));
                i1.SetFecha(rs.getString("data_creacio"));
                llista.add(i1);
            }

        if(connection != null) connection.close();
        
        return llista;      
        }
       catch(SQLException | ClassNotFoundException e )
        {
          System.err.println("SQL EXCEPTION: " + e.getMessage());
          return null;
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
            System.out.println("closed connection");
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }
    }
    
    
    //buscar per paraula clau
    @WebMethod(operationName = "SearchbyKeywords")
        public List<Image> SearchbyKeywords(@WebParam(name = "paraulaclau")String paraulaclau) {
            Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            List<Image> llista = new ArrayList<>();
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adri\\Documents\\LABAD.db");
            PreparedStatement statement = connection.prepareStatement("select * from imatges where paraula_clau = ?");
            statement.setString(1,paraulaclau);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Image i1 = new Image();
                i1.SetIdImag(rs.getInt("id_imatge"));
                i1.SetTitulo(rs.getString("titol_imatge"));
                i1.SetParaulaClau(rs.getString("paraula_clau"));
                i1.SetAutor(rs.getString("autor"));
                i1.SetFecha(rs.getString("data_creacio"));
                llista.add(i1);
            }

        if(connection != null) connection.close();
        
        return llista;      
        }
        catch(SQLException | ClassNotFoundException e )
        {
          System.err.println("SQL EXCEPTION: " + e.getMessage());
          return null;
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
            System.out.println("closed connection");
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }
    }
    
    //buscar per autor
    @WebMethod(operationName = "SearchbyAuthor")
    public List<Image> SearchbyAuthor(@WebParam(name = "autor")String autor) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            List<Image> llista = new ArrayList<>();
           connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adri\\Documents\\LABAD.db");
            PreparedStatement statement = connection.prepareStatement("select * from imatges where autor = ?");
            statement.setString(1,autor);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Image i1 = new Image();
                i1.SetIdImag(rs.getInt("id_imatge"));
                i1.SetTitulo(rs.getString("titol_imatge"));
                i1.SetParaulaClau(rs.getString("paraula_clau"));
                i1.SetAutor(rs.getString("autor"));
                i1.SetFecha(rs.getString("data_creacio"));
                llista.add(i1);
            }
        if(connection != null) connection.close();
        
        return llista;      
        }
        catch(SQLException | ClassNotFoundException e )
        {
          System.err.println("SQL EXCEPTION: " + e.getMessage());
          return null;
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
            System.out.println("closed connection");
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        } 
    }
    
    
    //buscar per data
    @WebMethod(operationName = "SearchbyCreaDate")
    public List<Image> SearchbyCreaDate(@WebParam(name = "datacreacio")String datacreacio) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            List<Image> llista = new ArrayList<>();
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adri\\Documents\\LABAD.db");
            PreparedStatement statement = connection.prepareStatement("select * from imatges where data_creacio = ?");
            statement.setString(1,datacreacio);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Image i1 = new Image();
                i1.SetIdImag(rs.getInt("id_imatge"));
                i1.SetTitulo(rs.getString("titol_imatge"));
                i1.SetParaulaClau(rs.getString("paraula_clau"));
                i1.SetAutor(rs.getString("autor"));
                i1.SetFecha(rs.getString("data_creacio"));
                llista.add(i1);
            }

        if(connection != null) connection.close();
        
        return llista;      
        }
        catch(SQLException | ClassNotFoundException e )
        {
          System.err.println("SQL EXCEPTION: " + e.getMessage());
          return null;
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
            System.out.println("closed connection");
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        } 
    }
    
      @WebMethod(operationName = "SearchbyTitleandKeyword")
    public List<Image> SearchbyTitleandKeyword(@WebParam(name = "titulo")String titulo, @WebParam(name = "paraulaclau")String paraulaclau) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            List<Image> llista = new ArrayList<>();
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adri\\Documents\\LABAD.db");
            PreparedStatement statement = connection.prepareStatement("select * from imatges where titol_imatge = ? and paraula_clau = ?");
            statement.setString(1,titulo);
            statement.setString(2,paraulaclau);
            ResultSet rs = statement.executeQuery();
               while(rs.next()) {
                Image i1 = new Image();
                i1.SetIdImag(rs.getInt("id_imatge"));
                i1.SetTitulo(rs.getString("titol_imatge"));
                i1.SetParaulaClau(rs.getString("paraula_clau"));
                i1.SetAutor(rs.getString("autor"));
                i1.SetFecha(rs.getString("data_creacio"));
                llista.add(i1);
            }

        if(connection != null) connection.close();
        
        return llista;      
        }
        catch(SQLException | ClassNotFoundException e )
        {
          System.err.println("SQL EXCEPTION: " + e.getMessage());
          return null;
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
            System.out.println("closed connection");
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        } 
    }
    
    
    
    
}
