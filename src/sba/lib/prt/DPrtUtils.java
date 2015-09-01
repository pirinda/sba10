/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib.prt;

import sba.lib.DLibUtils;

/**
 *
 * @author Sergio Flores
 */
public abstract class DPrtUtils {

    public static java.lang.String formatText(java.lang.String text, int length, int align, int truncMode) {
        java.lang.String s = "";

        if (text.length() <= length) {
            switch (align) {
                case DPrtConsts.ALIGN_LEFT:
                    s = text + DLibUtils.textRepeat(" ", length - text.length());
                    break;
                case DPrtConsts.ALIGN_RIGHT:
                    s = DLibUtils.textRepeat(" ", length - text.length()) + text;
                    break;
                case DPrtConsts.ALIGN_CENTER:
                    s = DLibUtils.textRepeat(" ", ((length - text.length()) / 2)) + text + DLibUtils.textRepeat(" ", ((length - text.length()) / 2) + ((length - text.length()) % 2 == 0 ? 0 : 1));
                    break;
                default:
            }
        }
        else {
            if (truncMode == DPrtConsts.TRUNC_HIDE) {
                s = DLibUtils.textRepeat("*", length);
            }
            else if (truncMode == DPrtConsts.TRUNC_TRUNC) {
                switch (align) {
                    case DPrtConsts.ALIGN_LEFT:
                        s = text.substring(0, length);
                        break;
                    case DPrtConsts.ALIGN_RIGHT:
                        s = text.substring(text.length() - length);
                        break;
                    case DPrtConsts.ALIGN_CENTER:
                        s = text.substring((text.length() - length) / 2, ((text.length() - length) / 2) + length);
                        break;
                    default:
                }
            }
        }

        return s;
    }
}
