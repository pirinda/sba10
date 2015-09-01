/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.gui.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sba.lib.gui.DGuiClient;

/**
 *
 * @author Sergio Flores
 */
public abstract class DUtilUtils {

    public static int[] processLogin(final DGuiClient client, final Statement statement, final String userName, final String userPassword) throws SQLException, Exception {
        return processLogin(client, statement, userName, userPassword, true);
    }
    
    public static int[] processLogin(final DGuiClient client, final Statement statement, final String userName, final String userPassword, final boolean applyDisabled) throws SQLException, Exception {
        int[] key = null;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT id_usr, pswd, " + (!applyDisabled ? "" : "b_dis, ") + "b_del, " +
                "PASSWORD('" + userPassword + "') AS f_pswd " +
                "FROM " + client.getTableUser() + " " +
                "WHERE name = '" + userName + "' ";
        resultSet = statement.executeQuery(sql);

        if (!resultSet.next()) {
            throw new Exception("La cuenta del usuario '" + userName + "' no existe.");
        }
        else {
            if (resultSet.getBoolean("b_del")) {
                throw new Exception("La cuenta del usuario '" + userName + "' está eliminada.");
            }
            else if (applyDisabled && resultSet.getBoolean("b_dis")) {
                throw new Exception("La cuenta del usuario '" + userName + "' está inhabilitada.");
            }
            else if (resultSet.getString("pswd").compareTo(resultSet.getString("f_pswd")) != 0) {
                throw new Exception("La contraseña de la cuenta del usuario '" + userName + "' es inválida.");
            }
            else {
                key = new int[] { resultSet.getInt("id_usr") };
            }
        }

        return key;
    }

    public static boolean processNewPassword(final DGuiClient client, final String passwordOld, final String passwordNew) throws SQLException, Exception {
        boolean passwordSet = false;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT pswd, PASSWORD('" + passwordOld + "') AS f_pswd " +
                "FROM " + client.getTableUser() + " " +
                "WHERE id_usr = " + client.getSession().getUser().getPkUserId() + " ";
        resultSet = client.getSession().getStatement().executeQuery(sql);

        if (!resultSet.next()) {
            throw new Exception("La cuenta del usuario '" + client.getSession().getUser().getName() + "' no existe.");
        }
        else {
            if (resultSet.getString("pswd").compareTo(resultSet.getString("f_pswd")) != 0) {
                throw new Exception("La contraseña de la cuenta del usuario '" + client.getSession().getUser().getName() + "' es inválida.");
            }
            else {
                sql = "UPDATE " + client.getTableUser() + " SET pswd = PASSWORD('" + passwordNew + "') " +
                        "WHERE id_usr = " + client.getSession().getUser().getPkUserId() + " ";
                client.getSession().getStatement().execute(sql);
                passwordSet = true;
            }
        }

        return passwordSet;
    }
}
