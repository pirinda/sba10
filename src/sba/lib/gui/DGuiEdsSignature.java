/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiEdsSignature {

    public int[] getKey();
    public String signText(final String textToSign, final int year);
    public String getCertificateNumber();
    public String getCertificateBase64();
    public int getCertificateId();
}
