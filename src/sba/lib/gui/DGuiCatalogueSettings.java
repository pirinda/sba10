/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import sba.lib.DLibConsts;

/**
 *
 * @author Sergio Flores
 */
public final class DGuiCatalogueSettings {

    private String msCatalogueName;
    private int mnPrimaryKeyLength;
    private int mnForeignKeyLength;
    private boolean mbComplementApplying;
    private int mnComplementDataType;
    private boolean mbCodeApplying;
    private boolean mbDateApplying;
    private boolean mbValueApplying;
    private boolean mbSelectionItemApplying;
    private String msSql;

    public DGuiCatalogueSettings(String catalogueName, int pkLength) {
        this(catalogueName, pkLength, 0, DLibConsts.UNDEFINED);
    }

    public DGuiCatalogueSettings(String catalogueName, int pkLength, int fkLength) {
        this(catalogueName, pkLength, fkLength, DLibConsts.UNDEFINED);
    }

    /**
     * @param catalogueName Catalogue name.
     * @param pkLength Primary key length.
     * @param fkLength Foreign key length.
     * @param complementDataType Complement data type (Constants defined in DLibConsts.DATA_TYPE_...).
     */
    public DGuiCatalogueSettings(String catalogueName, int pkLength, int fkLength, int complementDataType) {
        msCatalogueName = catalogueName;
        mnPrimaryKeyLength = pkLength;
        mnForeignKeyLength = fkLength;
        mbComplementApplying = complementDataType != DLibConsts.UNDEFINED;
        mnComplementDataType = complementDataType;
        mbCodeApplying = false;
        mbDateApplying = false;
        mbValueApplying = false;
        mbSelectionItemApplying = true;
        msSql = "";
    }

    public void setCatalogueName(String name) { msCatalogueName = name; }
    public void setPrimaryKeyLength(int length) { mnPrimaryKeyLength = length; }
    public void setForeignKeyLength(int length) { mnForeignKeyLength = length; }
    public void setComplementApplying(boolean applying) { mbComplementApplying = applying; }
    public void setComplementDataType(int type) { mnComplementDataType = type; }
    public void setCodeApplying(boolean applying) { mbCodeApplying = applying; }
    public void setDateApplying(boolean applying) { mbDateApplying = applying; }
    public void setValueApplying(boolean applying) { mbValueApplying = applying; }
    public void setSelectionItemApplying(boolean b) { mbSelectionItemApplying = b; }
    public void setSql(String sql) { msSql = sql; }

    public String getCatalogueName() { return msCatalogueName; }
    public int getPrimaryKeyLength() { return mnPrimaryKeyLength; }
    public int getForeignKeyLength() { return mnForeignKeyLength; }
    public boolean isComplementApplying() { return mbComplementApplying; }
    public int getComplementDataType() { return mnComplementDataType; }
    public boolean isCodeApplying() { return mbCodeApplying; }
    public boolean isDateApplying() { return mbDateApplying; }
    public boolean isValueApplying() { return mbValueApplying; }
    public boolean isSelectionItemApplying() { return mbSelectionItemApplying; }
    public String getSql() { return msSql; }
}
