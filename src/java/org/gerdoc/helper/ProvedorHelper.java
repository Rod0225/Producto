/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.helper;

import java.io.Serializable;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.gerdoc.dao.Provedor;
import org.gerdoc.service.ProvedorService;


/**
 *
 * @author gerdoc
 */
public class ProvedorHelper implements Serializable
{
    private List<Provedor>list;
    private Provedor provedor;

    public ProvedorHelper() 
    {
    }
    
    public boolean loadList( )
    {
        list = new ProvedorService().getProvedorList();
        return list != null && list.size() > 0;
    }
    
    public boolean addProvedor( HttpServletRequest request )
    {
        provedor = new Provedor( ); 
        //borraste algo aqui
        provedor.setProvedor(request.getParameter( "provedor" ) );
        if( provedor.getProvedor()== null  )
        {
            return false;
        }
        return new ProvedorService().addProvedor(provedor);
    }
    
    public Integer getInteger( String campo )
    {
        Integer val = 0;
        if( campo == null || campo.length() == 0 )
        {
            return null;
        }
        try
        {
            val = new Integer(campo);
            return val;
        }
        catch(NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Provedor> getList()
    {
        if( list == null || list.size( )== 0 )
        {
            if( !loadList( ) )
            {
                return null;
            }
        }
        return list;
    }

    public void setList(List<Provedor> list) 
    {
        this.list = list;
    }

    public Provedor getProvedor() 
    {
        return provedor;
    }

    public void setProvedor(Provedor provedor) 
    {
        this.provedor = provedor;
    }
    
}
