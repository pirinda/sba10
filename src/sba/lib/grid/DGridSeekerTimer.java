/*
 * To change this template, choose Tools | Templates
 * and open the template in the moSeeker.
 */

package sba.lib.grid;

import sba.lib.DLibUtils;

/**
 *
 * @author Sergio Flores
 */
public class DGridSeekerTimer extends Thread {

    public static final long TIMEOUT = 1000 * 5;

    private DGridSeeker moSeeker;
    private volatile long mlTimer;
    private volatile boolean mbActive;

    public DGridSeekerTimer(DGridSeeker seeker) {
        moSeeker = seeker;
        mlTimer = 0;
        mbActive = false;
    }

    public void resetTimer() {
        mlTimer = 0;
    }

    public void startThread() {
        resetTimer();
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
                sleep(1000 * 1);

                mlTimer += 1000;
                
                if (mlTimer >= TIMEOUT) {
                    stopThread();
                    moSeeker.closeSeeker();
                }
            }
            catch (Exception e) {
                DLibUtils.printException(this, e);
            }
        }
    }
}
