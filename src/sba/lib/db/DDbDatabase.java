/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import sba.lib.DLibUtils;

/**
 *
 * @author Sergio Flores
 */
public class DDbDatabase {
    
    protected int mnDbType;
    protected String msDbHost;
    protected String msDbPort;
    protected String msDbName;
    protected String msUserName;
    protected String msUserPassword;

    protected Connection moConnection;
    protected boolean mbConnectionActive;
    protected String[] masConnectionParams;

    /**
     * @param type Constants defined in sba.lib.util.SUtilConst.
     */
    public DDbDatabase(int type) {
        mnDbType = type;
        initDatabase();
    }

    private void initDatabase() {
        msDbHost = "";
        msDbPort = "";
        msDbName = "";
        msUserName = "";
        msUserPassword = "";

        moConnection = null;
        mbConnectionActive = false;

        switch (mnDbType) {
            case DDbConsts.DBMS_MYSQL:
                masConnectionParams = new String[] { "SET AUTOCOMMIT=1" };
                break;
            case DDbConsts.DBMS_SQL_SERVER_2000:
            case DDbConsts.DBMS_SQL_SERVER_2005:
                masConnectionParams = null;
                break;
            default:
                masConnectionParams = null;
        }
    }

    private int createConnection(final String host, final String port, final String name, final String user, final String password) {
        int result = DDbConsts.CONNECTION_ERROR;
        Statement statement = null;

        try {
            switch (mnDbType) {
                case DDbConsts.DBMS_MYSQL:
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    moConnection = DriverManager.getConnection("jdbc:mysql://" + host + (port.length() == 0 ? "" : ":" + port) + "/" + name + "?user=" + user + "&password=" + password);
                    statement = moConnection.createStatement();
                    break;

                case DDbConsts.DBMS_SQL_SERVER_2000:
                    Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
                    moConnection = DriverManager.getConnection("jdbc:microsoft:sqlserver://" + host + (port.length() == 0 ? "" : ":" + port) + ";databaseName=" + name + ";user=" + user + ";password=" + password);
                    statement = moConnection.createStatement();
                    break;

                case DDbConsts.DBMS_SQL_SERVER_2005:
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    moConnection = DriverManager.getConnection("jdbc:sqlserver://" + host + (port.length() == 0 ? "" : ":" + port) + ";databaseName=" + name + ";user=" + user + ";password=" + password);
                    statement = moConnection.createStatement();
                    break;

                default:
            }

            if (masConnectionParams != null) {
                for (String param : masConnectionParams) {
                    statement.execute(param);
                }
            }

            result = DDbConsts.CONNECTION_OK;
        }
        catch (ClassNotFoundException e) {
            DLibUtils.printException(this, e);
        }
        catch (InstantiationException e) {
            DLibUtils.printException(this, e);
        }
        catch (IllegalAccessException e) {
            DLibUtils.printException(this, e);
        }
        catch (SQLException e) {
            DLibUtils.printException(this, e);
        }
        catch (Exception e) {
            DLibUtils.printException(this, e);
        }

        return result;
    }

    public int getDbType() { return mnDbType; }
    public String getDbHost() { return msDbHost; }
    public String getDbPort() { return msDbPort; }
    public String getDbName() { return msDbName; }
    public String getUserName() { return msUserName; }
    public String getUserPassword() { return msUserPassword; }

    public Connection getConnection() { return moConnection; }
    public boolean isConnectionActive() { return mbConnectionActive; }
    public String[] getConnectionParams() { return masConnectionParams; }

    public int connect(final String host, final String port, final String name, final String user, final String password) {
        int result = createConnection(host, port, name, user, password);
        
        if (result != DDbConsts.CONNECTION_OK) {
            initDatabase();
        }
        else {
            msDbHost = host;
            msDbPort = port;
            msDbName = name;
            msUserName = user;
            msUserPassword = password;
            mbConnectionActive = true;
        }
        
        return result;
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                moConnection.close();
            }
            catch (SQLException e) {
                DLibUtils.printException(this, e);
            }
            catch (Exception e) {
                DLibUtils.printException(this, e);
            }
        }
    }

    public int reconnect() {
        int result = DDbConsts.CONNECTION_ERROR;

        if (mbConnectionActive) {
            result = createConnection(msDbHost, msDbPort, msDbName, msUserName, msUserPassword);
        }

        return result;
    }

    public boolean isConnected() {
        boolean connected = false;

        if (mbConnectionActive && moConnection != null) {
            try {
                moConnection.createStatement().execute("SELECT 0");
                connected = true;
            }
            catch (SQLException e) {
                DLibUtils.printException(this, e);
            }
            catch (Exception e) {
                DLibUtils.printException(this, e);
            }
        }

        return connected;
    }

    public int monitorConnection() {
        int result = DDbConsts.CONNECTION_ERROR;

        if (mbConnectionActive) {
            if (isConnected()) {
                result = DDbConsts.CONNECTION_OK;
            }
            else {
                result = createConnection(msDbHost, msDbPort, msDbName, msUserName, msUserPassword);
            }
        }

        return result;
    }

    @Override
    public void finalize() throws Throwable {
        disconnect();
    }
}
