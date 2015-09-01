/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.util.HashMap;
import sba.lib.DLibConsts;

/**
 *
 * @author Sergio Flores
 */
public class DGuiParams {

    protected int mnType;
    protected int mnSubtype;
    protected int[] manKey;
    protected boolean mbCopy;
    protected int[] manTypeKey;
    protected HashMap<Integer, Object> moReferencesMap;

    public DGuiParams() {
        this(DLibConsts.UNDEFINED, DLibConsts.UNDEFINED, null, false);
    }

    public DGuiParams(int type) {
        this(type, DLibConsts.UNDEFINED, null, false);
    }

    public DGuiParams(int type, boolean copy) {
        this(type, DLibConsts.UNDEFINED, null, copy);
    }

    public DGuiParams(int type, int subtype) {
        this(type, subtype, null, false);
    }

    public DGuiParams(int type, int subtype, boolean copy) {
        this(type, subtype, null, copy);
    }

    public DGuiParams(int type, int[] key) {
        this(type, DLibConsts.UNDEFINED, key, false);
    }

    public DGuiParams(int type, int subtype, int[] key) {
        this(type, subtype, key, false);
    }

    public DGuiParams(int[] key) {
        this(DLibConsts.UNDEFINED, DLibConsts.UNDEFINED, key, false);
    }

    public DGuiParams(int[] key, boolean copy) {
        this(DLibConsts.UNDEFINED, DLibConsts.UNDEFINED, key, copy);
    }

    public DGuiParams(int type, int subtype, int[] key, boolean copy) {
        mnType = type;
        mnSubtype = subtype;
        manKey = key;
        mbCopy = copy;
        manTypeKey = null;
        moReferencesMap = new HashMap<Integer, Object>();
    }

    public void setType(int n) { mnType = n; }
    public void setSubtype(int n) { mnSubtype = n; }
    public void setKey(int[] key) { manKey = key; }
    public void setCopy(boolean b) { mbCopy = b; }
    public void setTypeKey(int[] key) { manTypeKey = key; }

    public int getType() { return mnType; }
    public int getSubtype() { return mnSubtype; }
    public int[] getKey() { return manKey; }
    public boolean isCopy() { return mbCopy; }
    public int[] getTypeKey() { return manTypeKey; }

    public HashMap<Integer, Object> getParamsMap() { return moReferencesMap; }
}
