/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.dao;

import java.io.Serializable;

/**
 *
 * @author Alumno
 */
public class Provedor implements Serializable
{
    private Integer IdProvedor;
    private String provedor;

    public Provedor() 
    {
    }

    public Integer getIdProvedor() {
        return IdProvedor;
    }

    public void setIdProvedor(Integer IdProvedor) {
        this.IdProvedor = IdProvedor;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

   

}
