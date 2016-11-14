/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean.implementation;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.daw.bean.publicinterface.GenericBean;
import net.daw.dao.implementation.FacturaDao;
import net.daw.dao.implementation.ProductoDao;
import net.daw.dao.implementation.UsuarioDao;

public class CompraBean implements GenericBean {

    @Expose
    private Integer id;
    @Expose
    private Integer cantidad;
    @Expose
    private Integer id_usuario;
    @Expose(deserialize = false)
    private UsuarioBean obj_usuario = null;
    @Expose
    private Integer id_factura;
    @Expose(deserialize = false)
    private FacturaBean obj_factura = null;
    @Expose
    private Integer id_producto;
    @Expose(deserialize = false)
    private ProductoBean obj_producto = null;

    public CompraBean() {
        this.id = 0;
    }

    public CompraBean(Integer id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the id_usuario
     */
    public Integer getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_factura
     */
    public Integer getId_factura() {
        return id_factura;
    }

    /**
     * @param id_factura the id_factura to set
     */
    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }

    /**
     * @return the id_producto
     */
    public Integer getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }
    
    /**
     * @return the obj_usuario
     */
    public UsuarioBean getObj_usuario() {
        return obj_usuario;
    }

    /**
     * @param obj_usuario the obj_usuario to set
     */
    public void setObj_usuario(UsuarioBean obj_usuario) {
        this.obj_usuario = obj_usuario;
    }

    /**
     * @return the obj_factura
     */
    public FacturaBean getObj_factura() {
        return obj_factura;
    }

    /**
     * @param obj_factura the obj_factura to set
     */
    public void setObj_factura(FacturaBean obj_factura) {
        this.obj_factura = obj_factura;
    }

    /**
     * @return the obj_producto
     */
    public ProductoBean getObj_producto() {
        return obj_producto;
    }

    /**
     * @param obj_producto the obj_producto to set
     */
    public void setObj_producto(ProductoBean obj_producto) {
        this.obj_producto = obj_producto;
    } 

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "cantidad,";
        strColumns += "id_usuario,";
        strColumns += "id_factura,";
        strColumns += "id_producto";      
        
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += getId() + ",";
        strColumns += getCantidad() + ",";
        strColumns += getId_usuario() + ",";
        strColumns += getId_factura() + ",";
        strColumns += getId_producto();

        return strColumns;
    }

    @Override
    public String toPairs() {
        String strPairs = "";
        strPairs += "id=" + getId() + ",";
        strPairs += "cantidad=" + getCantidad() + ",";
        strPairs += "id_usuario=" + getId_usuario() + ",";
        strPairs += "id_factura=" + getId_factura() + ",";
        strPairs += "id_producto=" + getId_producto();

        return strPairs;
    }

    @Override
    public CompraBean fill(ResultSet oResultSet, Connection pooledConnection, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setCantidad(oResultSet.getInt("cantidad"));
        this.setId_usuario(oResultSet.getInt("id_usuario"));
        this.setId_factura(oResultSet.getInt("id_factura"));
        this.setId_producto(oResultSet.getInt("id_producto"));
        
        if (expand > 0) {
            UsuarioBean oEstadoBean = new UsuarioBean();
            UsuarioDao oEstadoDao = new UsuarioDao(pooledConnection);
            oEstadoBean.setId(oResultSet.getInt("id_usuario"));
            oEstadoBean = oEstadoDao.get(oEstadoBean, expand - 1);
            this.setObj_usuario(oEstadoBean);
        } else {
            this.setId_usuario(oResultSet.getInt("id_usuario"));
        }
        if (expand > 0) {
            FacturaBean oTipousuarioBean = new FacturaBean();
            FacturaDao oTipousuarioDao = new FacturaDao(pooledConnection);
            oTipousuarioBean.setId(oResultSet.getInt("id_factura"));
            oTipousuarioBean = oTipousuarioDao.get(oTipousuarioBean, expand - 1);
            this.setObj_factura(oTipousuarioBean);
        } else {
            this.setId_factura(oResultSet.getInt("id_factura"));
        }
        if (expand > 0) {
            ProductoBean oTipousuarioBean = new ProductoBean();
            ProductoDao oTipousuarioDao = new ProductoDao(pooledConnection);
            oTipousuarioBean.setId(oResultSet.getInt("id_producto"));
            oTipousuarioBean = oTipousuarioDao.get(oTipousuarioBean, expand - 1);
            this.setObj_producto(oTipousuarioBean);
        } else {
            this.setId_producto(oResultSet.getInt("id_producto"));
        }
        
        return this;

    }  

}

