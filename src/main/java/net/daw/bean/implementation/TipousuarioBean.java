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
import net.daw.helper.statics.EncodingUtilHelper;

public class TipousuarioBean implements GenericBean {

    @Expose
    private Integer id;
    @Expose
    private String acceso = "";

    public TipousuarioBean() {
        this.id = 0;
    }

    public TipousuarioBean(Integer id) {
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

    public String getAcceso() {
        return acceso;
    }

    /**
     * @param acceso the nombre to set
     */
    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "acceso";
        
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += getId() + ",";
        strColumns += EncodingUtilHelper.quotate(getAcceso()) + ",";
        
        return strColumns;
    }

    @Override
    public String toPairs() {
        String strPairs = "";
        strPairs += "id=" + getId() + ",";
        strPairs += "acceso=" + EncodingUtilHelper.quotate(getAcceso()) + ",";
        
        return strPairs;
    }

    @Override
    public TipousuarioBean fill(ResultSet oResultSet, Connection pooledConnection, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setAcceso(oResultSet.getString("acceso"));

        return this;

    }

}