/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.service.implementation;

import javax.servlet.http.HttpServletRequest;
import net.daw.bean.implementation.ReplyBean;
import net.daw.bean.implementation.UsuarioBean;
import net.daw.helper.statics.EncodingUtilHelper;
import net.daw.helper.statics.JsonMessage;
import net.daw.service.publicinterface.ViewServiceInterface;

/**
 *
 * @author rafa
 */
public class DebugService implements ViewServiceInterface {

    protected HttpServletRequest oRequest = null;

    public DebugService(HttpServletRequest request) {
        oRequest = request;
    }

    private Boolean checkpermission(String strMethodName) throws Exception {
        UsuarioBean oUserBean = (UsuarioBean) oRequest.getSession().getAttribute("userBean");
        if (oUserBean != null) {
            return true;
        } else {
            return false;
        }
    }

    public String getopenshiftenvironment() throws Exception {
        String data = "";
        if (this.checkpermission("getenvironment")) {
            data = "{"
                    + "\"OPENSHIFT_APP_DNS\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_APP_DNS"))
                    + ",\"OPENSHIFT_APP_NAME\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_APP_NAME"))
                    + ",\"OPENSHIFT_APP_UUID\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_APP_UUID"))
                    + ",\"OPENSHIFT_JBOSSEWS_IP\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_JBOSSEWS_IP"))
                    + ",\"OPENSHIFT_JBOSSEWS_PORT\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_JBOSSEWS_PORT"))
                    + ",\"OPENSHIFT_SECRET_TOKEN\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_SECRET_TOKEN"))
                    + ",\"OPENSHIFT_HOMEDIR\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_HOMEDIR"))
                    + ",\"OPENSHIFT_DATA_DIR\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_DATA_DIR"))
                    + ",\"OPENSHIFT_REPO_DIR\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_REPO_DIR"))
                    + ",\"OPENSHIFT_TMP_DIR\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_TMP_DIR"))
                    + ",\"OPENSHIFT_LOG_DIR\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_LOG_DIR"))
                    + ",\"LOGSHIFTER_JBOSSEWS_MAX_FILESIZE\":" + EncodingUtilHelper.quotate(System.getenv("LOGSHIFTER_JBOSSEWS_MAX_FILESIZE"))
                    + ",\"LOGSHIFTER_JBOSSEWS_MAX_FILES\":" + EncodingUtilHelper.quotate(System.getenv("LOGSHIFTER_JBOSSEWS_MAX_FILES"))
                    + ",\"OPENSHIFT_MYSQL_DB_HOST\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_MYSQL_DB_HOST"))
                    + ",\"OPENSHIFT_MYSQL_DB_PORT\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_MYSQL_DB_PORT"))
                    + ",\"OPENSHIFT_MYSQL_DB_USERNAME\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_MYSQL_DB_USERNAME"))
                    + ",\"OPENSHIFT_MYSQL_DB_PASSWORD\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"))
                    + ",\"OPENSHIFT_MYSQL_DB_SOCKET\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_MYSQL_DB_SOCKET"))
                    + ",\"OPENSHIFT_MYSQL_DB_URL\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_MYSQL_DB_URL"))
                    + ",\"OPENSHIFT_MAX_SESSIONS_PER_GEAR\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_MAX_SESSIONS_PER_GEAR"))
                    + ",\"OPENSHIFT_JBOSSEWS_LD_LIBRARY_PATH_ELEMENT\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_JBOSSEWS_LD_LIBRARY_PATH_ELEMENT"))
                    + ",\"JENKINS_USERNAME\":" + EncodingUtilHelper.quotate(System.getenv("JENKINS_USERNAME"))
                    + ",\"JENKINS_PASSWORD\":" + EncodingUtilHelper.quotate(System.getenv("JENKINS_PASSWORD"))
                    + ",\"JENKINS_URL\":" + EncodingUtilHelper.quotate(System.getenv("JENKINS_URL"))
                    + ",\"JAVA_OPTS_EXT\":" + EncodingUtilHelper.quotate(System.getenv("JAVA_OPTS_EXT"))
                    + ",\"OPENSHIFT_GEAR_DNS\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_GEAR_DNS"))
                    + ",\"OPENSHIFT_GEAR_NAME\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_GEAR_NAME"))
                    + ",\"OPENSHIFT_GEAR_UUID\":" + EncodingUtilHelper.quotate(System.getenv("OPENSHIFT_GEAR_UUID"))
                    + "}";
            data = JsonMessage.getJsonExpression(200, data);

            return data;

        } else {
            return JsonMessage.getJsonMsg(401, "Unauthorized");
        }

    }

    @Override
    public ReplyBean getall() throws Exception {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public ReplyBean getpage() throws Exception {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public ReplyBean getcount() throws Exception {
        throw new UnsupportedOperationException("Not supported.");
    }
}
