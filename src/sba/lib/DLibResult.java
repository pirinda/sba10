/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib;

/**
 *
 * @author Sergio Flores
 */
public class DLibResult {

    protected int mnResult;
    protected String msMessage;

    public DLibResult() {
        this(DLibConsts.UNDEFINED, "");
    }

    public DLibResult(int result, String message) {
        mnResult = result;
        msMessage = message;
    }

    public void setResult(int n) { mnResult = n; }
    public void setMessage(String s) { msMessage = s; }

    public int getResult() { return mnResult; }
    public String getMessage() { return msMessage; }
}
