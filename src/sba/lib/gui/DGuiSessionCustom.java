/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiSessionCustom {

    public int[] getLocalCountryKey();
    public String getLocalCountry();
    public String getLocalCountryCode();
    public boolean isLocalCountry(final int[] key);

    public int[] getLocalCurrencyKey();
    public String getLocalCurrency();
    public String getLocalCurrencyCode();
    public boolean isLocalCurrency(final int[] key);

    public String getLocalLanguage();

    public String getCountry(final int[] key);
    public String getCountryCode(final int[] key);

    public String getCurrency(final int[] key);
    public String getCurrencyCode(final int[] key);

    public String getLanguage(final int[] key);

    public int getTerminal();
}
