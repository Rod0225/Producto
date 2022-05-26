/*
 * To change this license header, choose License Headers in Pprovedorject Pprovedorperties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.gerdoc.dao.Provedor;

/**
 *
 * @author gerdoc
 */
public class ProvedorService 
{
    
    public List<Provedor> getProvedorList( )
    {
        List<Provedor>provedorList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Provedor provedor = null;
        
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return null;
            }
            statement = connection.createStatement( );
            if( statement == null )
            {
                return null;
            }
            resultSet = statement.executeQuery( "SELECT * FROM TBLProvedor" );
            if( resultSet == null )
            {
                return null;
            }
            provedorList = new ArrayList<>();
            while( resultSet.next() )
            {
                provedor = new Provedor();
                provedor.setIdProvedor(resultSet.getInt(1) );
                provedor.setProvedor(resultSet.getString(2) );
                provedorList.add(provedor);
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return provedorList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addProvedor( Provedor provedor )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TBLProvedor(provedor) VALUES(?)";
        int provedorw = 0;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, provedor.getProvedor());
            provedorw = preparedStatement.executeUpdate();
            MySqlConnection.closeConnection(connection);
            return provedorw == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteProvedor( Provedor provedor )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM TBLProvedor WHERE IdProvedor = ?";
        int provedorw = 0;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, provedor.getIdProvedor());
            provedorw = preparedStatement.executeUpdate();
            MySqlConnection.closeConnection(connection);
            return provedorw == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Provedor getProvedorById( String provedor1 )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM TBLProvedor WHERE IdProvedor= ?";
        Provedor provedor = null;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return null;
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, provedor1 );
            resultSet = preparedStatement.executeQuery( );
            if( resultSet == null )
            {
                return null;
            }
            while( resultSet.next() )
            {
                provedor = new Provedor();
                provedor.setIdProvedor(resultSet.getInt(1) );
                provedor.setProvedor(resultSet.getString(2) );
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return provedor;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean updateProvedor( Provedor provedor )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update TBLProvedor SET provedor=? WHERE IdProvedor = ?";
        int provedorw = 0;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, provedor.getIdProvedor());
            preparedStatement.setString(2, provedor.getProvedor());
            
            provedorw = preparedStatement.executeUpdate();
            MySqlConnection.closeConnection(connection);
            return provedorw == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
}
