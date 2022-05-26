/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.dao;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alumno
 */
public class Producto implements Serializable
{
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private String url;
    private Integer PrecioPub;
    private Integer costo;
    private Marca marca;
    private Provedor provedor;

    public Marca getMarca() {
        return marca;
    }

    public Producto(Marca marca, Provedor provedor) {
        this.marca = marca;
        this.provedor = provedor;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Provedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }

   public Producto() 
    {       
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPrecioPub() {
        return PrecioPub;
    }

    public void setPrecioPub(Integer PrecioPub) {
        this.PrecioPub = PrecioPub;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    
    
}