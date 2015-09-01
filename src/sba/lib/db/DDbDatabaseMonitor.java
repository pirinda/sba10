/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.db;

import sba.lib.DLibUtils;

/**
 *
 * @author Sergio Flores
 */
public final class DDbDatabaseMonitor extends Thread {

    public static final long DELAY_15_MIN = 1000 * 60 * 15;
    public static final long DELAY_30_MIN = 1000 * 60 * 30;
    public static final long DELAY_60_MIN = 1000 * 60 * 60;

    private DDbDatabase moDatabase;
    private long mlMonitorDelay;
    private volatile boolean mbActive;

    public DDbDatabaseMonitor(DDbDatabase database) {
        this(database, DELAY_15_MIN);
    }

    public DDbDatabaseMonitor(DDbDatabase database, long delay) {
        moDatabase = database;
        mlMonitorDelay = delay;
        mbActive = false;
    }

    public void startThread() {
        mbActive = true;
        setDaemon(true);
        super.start();
    }

    public void stopThread() {
        mbActive = false;
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void run() {
        while (mbActive) {
            try {
                sleep(mlMonitorDelay);

                if (moDatabase.monitorConnection() != DDbConsts.CONNECTION_OK) {
                    throw new Exception(DDbConsts.ERR_MSG_DB_CLOSED);
                }
            }
            catch (InterruptedException e) {
                DLibUtils.printException(this, e);
            }
            catch (Exception e) {
                DLibUtils.printException(this, e);
            }
        }

        moDatabase.disconnect();
    }
}
