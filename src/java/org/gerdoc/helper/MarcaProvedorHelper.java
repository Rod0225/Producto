/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.helper;

import java.io.Serializable;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.gerdoc.dao.Marca;
import org.gerdoc.dao.Producto;
import org.gerdoc.dao.Provedor;
import org.gerdoc.service.MarcaProvedorService;


/**
 *
 * @author gerdoc
 */
public class MarcaProvedorHelper implements Serializable
{
    private List<Producto>list;
    private Producto marcaProvedor;
    private Producto producto;

    public MarcaProvedorHelper() 
    {
    }
    
    public boolean loadList( )
    {
        list = new MarcaProvedorService().getProductoList();
        return list != null && list.size() > 0;
    }
   
    public boolean addMarcaProvedor( HttpServletRequest request )
    {
        marcaProvedor = new Producto( new Marca( ) , new Provedor( ) );
        marcaProvedor.setNombre(request.getParameter( "nombre" ));
        if( marcaProvedor.getNombre()== null || marcaProvedor.getNombre().length()==0 )
        {
            return false;
        }
        marcaProvedor.setDescripcion(request.getParameter( "descripcion" ));
        if( marcaProvedor.getDescripcion()== null || marcaProvedor.getDescripcion().length()==0 )
        {
            return false;
        }
        marcaProvedor.setUrl(request.getParameter( "url" ));
        if( marcaProvedor.getUrl()== null || marcaProvedor.getUrl().length()==0 )
        {
            return false;
        }
        marcaProvedor.setPrecioPub(getInteger(request.getParameter( "preciopub" )));
        if( marcaProvedor.getPrecioPub()== null || marcaProvedor.getPrecioPub()==0 )
        {
            return false;
        }
        marcaProvedor.setCosto(getInteger(request.getParameter( "costo" )));
        if( marcaProvedor.getCosto()== null || marcaProvedor.getCosto()==0 )
        {
            return false;
        }
        marcaProvedor.getMarca().setIdMarca(getInteger(request.getParameter( "marca" )) );
        if( marcaProvedor.getMarca().getIdMarca()== null || marcaProvedor.getMarca().getIdMarca()== 0 )
        {
            return false;
        }
        marcaProvedor.getProvedor().setIdProvedor(getInteger(request.getParameter( "provedor" )) );
        if( marcaProvedor.getProvedor().getIdProvedor() == null || marcaProvedor.getProvedor().getIdProvedor() == 0 )
        {
            return false;
        }
        return new MarcaProvedorService().addProducto(marcaProvedor);
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

    public List<Producto> getList()
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
     public boolean deleteProducto( HttpServletRequest request )
    {
        producto = new Producto( ); 
        producto.setIdProducto( getInteger( request.getParameter( "id" )) );
        if( producto.getIdProducto()== null )
        {
            return false;
        }
        return new MarcaProvedorService().deleteProducto( producto );
    }
    public boolean update( HttpServletRequest request )
    {
        producto = new Producto( new Marca( ) , new Provedor( ) ); 
        producto.setNombre(request.getParameter( "nombre" ) );
        if( producto.getNombre() == null )
        {
            return false;
        }
        producto.setDescripcion(request.getParameter( "descripcion" ) );
        if( producto.getDescripcion()== null || producto.getDescripcion().length() == 0 )
        {
            return false;
        }
        producto.setUrl(request.getParameter( "url" ) );
        if( producto.getUrl()== null || producto.getUrl().length() == 0 )
        {
            return false;
        }
        producto.setPrecioPub(getInteger(request.getParameter( "preciopub" ) ) );
        if( producto.getPrecioPub()== null )
        {
            return false;
        }
        producto.setCosto(getInteger(request.getParameter( "costo" ) ) );
        if( producto.getCosto()== null )
        {
            return false;
        }
        producto.getMarca().setIdMarca(getInteger(request.getParameter( "marca" )) );
        if( producto.getMarca().getIdMarca()== null || producto.getMarca().getIdMarca()== 0 )
        {
            return false;
        }
        producto.getProvedor().setIdProvedor(getInteger(request.getParameter( "provedor" )) );
        if( producto.getProvedor().getIdProvedor() == null || producto.getProvedor().getIdProvedor() == 0 )
        {
            return false;
        }
        producto.setIdProducto(getInteger(request.getParameter("id") ));
        if( producto.getProvedor().getIdProvedor() == null || producto.getProvedor().getIdProvedor() == 0 )
        {
            return false;
        }
        return new MarcaProvedorService().updateProducto( producto );
    }
    public Producto getProductoById( HttpServletRequest request )
    {
        Producto producto = null;
        Integer id = null;
        id = getInteger( request.getParameter( "id" ) );
        if( id == null )
        {
            return null;
        }
        return new MarcaProvedorService().getProductoById(id);
    }

    public void setList(List<Producto> list) 
    {
        this.list = list;
    }

    public Producto getMarcaProvedor() 
    {
        return marcaProvedor;
    }

    public void setMarcaProvedor(Producto marcaProvedor) 
    {
        this.marcaProvedor = marcaProvedor;
    }
    
}
