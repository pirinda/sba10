/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

/**
 *
 * @author Sergio Flores
 */
public final class DGridPaneSettings {

    private int mnPrimaryKeyLength;
    private int mnTypeKeyLength;
    private boolean mbDateApplying;
    private boolean mbUpdatableApplying;
    private boolean mbDisableableApplying;
    private boolean mbDeletableApplying;
    private boolean mbDisabledApplying;
    private boolean mbDeletedApplying;
    private boolean mbSystemApplying;
    private boolean mbUserApplying;
    private boolean mbUserInsertApplying;
    private boolean mbUserUpdateApplying;

    public DGridPaneSettings(int primaryKeyLength) {
        this(primaryKeyLength, 0);
    }

    public DGridPaneSettings(int primaryKeyLength, int typeKeyLength) {
        mnPrimaryKeyLength = primaryKeyLength;
        mnTypeKeyLength = typeKeyLength;
        mbDateApplying = false;
        mbUpdatableApplying = false;
        mbDisableableApplying = false;
        mbDeletableApplying = false;
        mbDisabledApplying = false;
        mbDeletedApplying = false;
        mbSystemApplying = false;
        mbUserApplying = false;
        mbUserInsertApplying = false;
        mbUserUpdateApplying = false;
    }

    public void setPrimaryKeyLength(int n) { mnPrimaryKeyLength = n; }
    public void setTypeKeyLength(int n) { mnTypeKeyLength = n; }
    public void setDateApplying(boolean b) { mbDateApplying = b; }
    public void setUpdatableApplying(boolean b) { mbUpdatableApplying = b; }
    public void setDisableableApplying(boolean b) { mbDisableableApplying = b; }
    public void setDeletableApplying(boolean b) { mbDeletableApplying = b; }
    public void setDisabledApplying(boolean b) { mbDisabledApplying = b; }
    public void setDeletedApplying(boolean b) { mbDeletedApplying = b; }
    public void setSystemApplying(boolean b) { mbSystemApplying = b; }
    public void setUserApplying(boolean b) { mbUserApplying = b; }
    public void setUserInsertApplying(boolean b) { mbUserInsertApplying = b; }
    public void setUserUpdateApplying(boolean b) { mbUserUpdateApplying = b; }

    public int getPrimaryKeyLength() { return mnPrimaryKeyLength; }
    public int getTypeKeyLength() { return mnTypeKeyLength; }
    public boolean isDateApplying() { return mbDateApplying; }
    public boolean isUpdatableApplying() { return mbUpdatableApplying; }
    public boolean isDisableableApplying() { return mbDisableableApplying; }
    public boolean isDeletableApplying() { return mbDeletableApplying; }
    public boolean isDisabledApplying() { return mbDisabledApplying; }
    public boolean isDeletedApplying() { return mbDeletedApplying; }
    public boolean isSystemApplying() { return mbSystemApplying; }
    public boolean isUserApplying() { return mbUserApplying; }
    public boolean isUserInsertApplying() { return mbUserInsertApplying; }
    public boolean isUserUpdateApplying() { return mbUserUpdateApplying; }
}
