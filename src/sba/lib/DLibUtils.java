/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.Vector;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio Flores
 */
public abstract class DLibUtils {

    public static final DecimalFormat DecimalFormatInteger = new DecimalFormat("#,##0");
    public static final DecimalFormat DecimalFormatIntegerRaw = new DecimalFormat("#0");
    public static final DecimalFormat DecimalFormatCalendarDay = new DecimalFormat("00");
    public static final DecimalFormat DecimalFormatCalendarMonth = new DecimalFormat("00");
    public static final DecimalFormat DecimalFormatCalendarYear = new DecimalFormat("0000");
    public static final DecimalFormat DecimalFormatValue0D = new DecimalFormat("#,##0");
    public static final DecimalFormat DecimalFormatValue2D = new DecimalFormat("#,##0.00");
    public static final DecimalFormat DecimalFormatValue4D = new DecimalFormat("#,##0.0000");
    public static final DecimalFormat DecimalFormatValue8D = new DecimalFormat("#,##0.00000000");
    public static final DecimalFormat DecimalFormatPercentage0D = new DecimalFormat("#,##0%");
    public static final DecimalFormat DecimalFormatPercentage2D = new DecimalFormat("#,##0.00%");
    public static final DecimalFormat DecimalFormatPercentage4D = new DecimalFormat("#,##0.0000%");
    public static final DecimalFormat DecimalFormatPercentage8D = new DecimalFormat("#,##0.00000000%");
    public static final DecimalFormat DecimalNumberFormat = new DecimalFormat(DLibUtils.textRepeat("0", DLibConsts.LEN_NUM));
    public static final DecimalFormat DecimalReferenceFormat = new DecimalFormat(DLibUtils.textRepeat("0", DLibConsts.LEN_REF_NUM));
    public static final DecimalFormat RoundingDecimalFormat = new DecimalFormat();
    public static final SimpleDateFormat DateFormatDate = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat DateFormatDateShort = new SimpleDateFormat("dd/MM/yy");
    public static final SimpleDateFormat DateFormatDateLong = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
    public static final SimpleDateFormat DateFormatDateYearMonth = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat DateFormatDateYear = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat DateFormatDatetime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static final SimpleDateFormat DateFormatDatetimeTimeZone = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss Z");
    public static final SimpleDateFormat DateFormatTime = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat DbmsDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DbmsDateFormatDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DbmsDateFormatTime = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat CsvFormatDate = new SimpleDateFormat("yyyy/MM/dd");
    public static final SimpleDateFormat CsvFormatDatetime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static final SimpleDateFormat CsvFormatTime = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat FileDateFormatDatetime = new SimpleDateFormat("yyyyMMdd HHmmss");
    public static final SimpleDateFormat IsoFormatDatetime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    public static final HashMap<Character, String> XmlEntityNamesMap = new HashMap<>();
    public static final HashMap<Character, String> HtmlEntityNamesMap = new HashMap<>();
    public static final char[] RandomKeyChars = new char[] { 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '9' }; // 62 choices, but 63 characters actually: the last one must be repeated

    private static final double MAX_VALUE = 999999999.99; // 999,999,999.99

    static {
        RoundingDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);

        XmlEntityNamesMap.put('"', "&quot;");
        XmlEntityNamesMap.put('&', "&amp;");
        XmlEntityNamesMap.put('\'', "&apos;");
        XmlEntityNamesMap.put('<', "&lt;");
        XmlEntityNamesMap.put('>', "&gt;");

        HtmlEntityNamesMap.put('"', "&quot;");
        HtmlEntityNamesMap.put('&', "&amp;");
        HtmlEntityNamesMap.put('<', "&lt;");
        HtmlEntityNamesMap.put('>', "&gt;");
        HtmlEntityNamesMap.put('¡', "&iexcl;");
        HtmlEntityNamesMap.put('¢', "&cent;");
        HtmlEntityNamesMap.put('£', "&pound;");
        HtmlEntityNamesMap.put('¤', "&curren;");
        HtmlEntityNamesMap.put('¥', "&yen;");
        HtmlEntityNamesMap.put('¦', "&brvbar;");
        HtmlEntityNamesMap.put('§', "&sect;");
        HtmlEntityNamesMap.put('¨', "&uml;");
        HtmlEntityNamesMap.put('©', "&copy;");
        HtmlEntityNamesMap.put('ª', "&ordf;");
        HtmlEntityNamesMap.put('«', "&laquo;");
        HtmlEntityNamesMap.put('¬', "&not;");
        HtmlEntityNamesMap.put('®', "&reg;");
        HtmlEntityNamesMap.put('¯', "&macr;");
        HtmlEntityNamesMap.put('°', "&deg;");
        HtmlEntityNamesMap.put('±', "&plusmn;");
        HtmlEntityNamesMap.put('²', "&sup2;");
        HtmlEntityNamesMap.put('³', "&sup3;");
        HtmlEntityNamesMap.put('´', "&acute;");
        HtmlEntityNamesMap.put('µ', "&micro;");
        HtmlEntityNamesMap.put('¶', "&para;");
        HtmlEntityNamesMap.put('·', "&middot;");
        HtmlEntityNamesMap.put('¸', "&cedil;");
        HtmlEntityNamesMap.put('¹', "&sup1;");
        HtmlEntityNamesMap.put('º', "&ordm;");
        HtmlEntityNamesMap.put('»', "&raquo;");
        HtmlEntityNamesMap.put('¼', "&frac14;");
        HtmlEntityNamesMap.put('½', "&frac12;");
        HtmlEntityNamesMap.put('¾', "&frac34;");
        HtmlEntityNamesMap.put('¿', "&iquest;");
        HtmlEntityNamesMap.put('À', "&Agrave;");
        HtmlEntityNamesMap.put('Á', "&Aacute;");
        HtmlEntityNamesMap.put('Â', "&Acirc;");
        HtmlEntityNamesMap.put('Ã', "&Atilde;");
        HtmlEntityNamesMap.put('Ä', "&Auml;");
        HtmlEntityNamesMap.put('Å', "&Aring;");
        HtmlEntityNamesMap.put('Æ', "&AElig;");
        HtmlEntityNamesMap.put('Ç', "&Ccedil;");
        HtmlEntityNamesMap.put('È', "&Egrave;");
        HtmlEntityNamesMap.put('É', "&Eacute;");
        HtmlEntityNamesMap.put('Ê', "&Ecirc;");
        HtmlEntityNamesMap.put('Ë', "&Euml;");
        HtmlEntityNamesMap.put('Ì', "&Igrave;");
        HtmlEntityNamesMap.put('Í', "&Iacute;");
        HtmlEntityNamesMap.put('Î', "&Icirc;");
        HtmlEntityNamesMap.put('Ï', "&Iuml;");
        HtmlEntityNamesMap.put('Ð', "&ETH;");
        HtmlEntityNamesMap.put('Ñ', "&Ntilde;");
        HtmlEntityNamesMap.put('Ò', "&Ograve;");
        HtmlEntityNamesMap.put('Ó', "&Oacute;");
        HtmlEntityNamesMap.put('Ô', "&Ocirc;");
        HtmlEntityNamesMap.put('Õ', "&Otilde;");
        HtmlEntityNamesMap.put('Ö', "&Ouml;");
        HtmlEntityNamesMap.put('×', "&times;");
        HtmlEntityNamesMap.put('Ø', "&Oslash;");
        HtmlEntityNamesMap.put('Ù', "&Ugrave;");
        HtmlEntityNamesMap.put('Ú', "&Uacute;");
        HtmlEntityNamesMap.put('Û', "&Ucirc;");
        HtmlEntityNamesMap.put('Ü', "&Uuml;");
        HtmlEntityNamesMap.put('Ý', "&Yacute;");
        HtmlEntityNamesMap.put('Þ', "&THORN;");
        HtmlEntityNamesMap.put('ß', "&szlig;");
        HtmlEntityNamesMap.put('à', "&agrave;");
        HtmlEntityNamesMap.put('á', "&aacute;");
        HtmlEntityNamesMap.put('â', "&acirc;");
        HtmlEntityNamesMap.put('ã', "&atilde;");
        HtmlEntityNamesMap.put('ä', "&auml;");
        HtmlEntityNamesMap.put('å', "&aring;");
        HtmlEntityNamesMap.put('æ', "&aelig;");
        HtmlEntityNamesMap.put('ç', "&ccedil;");
        HtmlEntityNamesMap.put('è', "&egrave;");
        HtmlEntityNamesMap.put('é', "&eacute;");
        HtmlEntityNamesMap.put('ê', "&ecirc;");
        HtmlEntityNamesMap.put('ë', "&euml;");
        HtmlEntityNamesMap.put('ì', "&igrave;");
        HtmlEntityNamesMap.put('í', "&iacute;");
        HtmlEntityNamesMap.put('î', "&icirc;");
        HtmlEntityNamesMap.put('ï', "&iuml;");
        HtmlEntityNamesMap.put('ð', "&eth;");
        HtmlEntityNamesMap.put('ñ', "&ntilde;");
        HtmlEntityNamesMap.put('ò', "&ograve;");
        HtmlEntityNamesMap.put('ó', "&oacute;");
        HtmlEntityNamesMap.put('ô', "&ocirc;");
        HtmlEntityNamesMap.put('õ', "&otilde;");
        HtmlEntityNamesMap.put('ö', "&ouml;");
        HtmlEntityNamesMap.put('÷', "&divide;");
        HtmlEntityNamesMap.put('ø', "&oslash;");
        HtmlEntityNamesMap.put('ù', "&ugrave;");
        HtmlEntityNamesMap.put('ú', "&uacute;");
        HtmlEntityNamesMap.put('û', "&ucirc;");
        HtmlEntityNamesMap.put('ü', "&uuml;");
        HtmlEntityNamesMap.put('ý', "&yacute;");
        HtmlEntityNamesMap.put('þ', "&thorn;");
        HtmlEntityNamesMap.put('ÿ', "&yuml;");
        HtmlEntityNamesMap.put('€', "&euro;");
    }

    // Time Zones:

    public static void restoreDateFormats(final TimeZone zone) {
        DateFormatDate.setTimeZone(zone);
        DateFormatDateShort.setTimeZone(zone);
        DateFormatDatetime.setTimeZone(zone);
        DateFormatDatetimeTimeZone.setTimeZone(zone);
        DateFormatTime.setTimeZone(zone);
        DbmsDateFormatDate.setTimeZone(zone);
        DbmsDateFormatDatetime.setTimeZone(zone);
        DbmsDateFormatTime.setTimeZone(zone);
        CsvFormatDate.setTimeZone(zone);
        CsvFormatDatetime.setTimeZone(zone);
        CsvFormatTime.setTimeZone(zone);
        FileDateFormatDatetime.setTimeZone(zone);
    }

    public static TimeZone createTimeZone(TimeZone zoneDefault, TimeZone zoneNew) {
        TimeZone zone = null;

        if (zoneDefault.getRawOffset() == zoneNew.getRawOffset()) {
            zone = zoneDefault;
        }
        else {
            zone = zoneNew;
            zone.setRawOffset(zoneNew.getRawOffset() + zoneDefault.getDSTSavings());
        }

        return zone;
    }

    // Numbers in Spanish:

    private static final String MONEY_SPA_ZERO = "CERO";
    private static final String MONEY_SPA_HUNDRED = "CIEN";
    private static final String MONEY_SPA_THOUSAND_SNG = "MIL";
    private static final String MONEY_SPA_THOUSAND_PLR = "MIL";
    private static final String MONEY_SPA_MILLION_SNG = "MILLÓN";
    private static final String MONEY_SPA_MILLION_PLR = "MILLONES";

    private static final String[] masSpaUnits00 = {
    "UN", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE" };

    private static final String[] masSpaUnits10 = {
    "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISÉIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE" };

    private static final String[] masSpaUnits20 = {
    "VEINTIÚN", "VEINTIDÓS", "VEINTITRÉS", "VEINTICUATRO", "VEINTICINCO", "VEINTISÉIS", "VEINTISIETE", "VEINTIOCHO", "VEINTINUEVE" };

    private static final String[] masSpaTens = {
    "DIEZ", "VEINTE", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA" };

    private static final String[] masSpaHundreds = {
    "CIENTO", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS", "SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS" };

    // Numbers in English:

    private static final String MONEY_ENG_ZERO = "ZERO";
    private static final String MONEY_ENG_HUNDRED = "HUNDRED";
    private static final String MONEY_ENG_THOUSAND = "THOUSAND";
    private static final String MONEY_ENG_MILLION = "MILLION";

    private static final String[] masEngUnits00 = {
    "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };

    private static final String[] masEngUnits10 = {
    "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTTEEN", "NINETEEN" };

    private static final String[] masEngTens = {
    "TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY" };

    public static DecimalFormat getDecimalFormat() {
        return DecimalFormatValue8D;
    }

    public static DecimalFormat getDecimalFormatAmount() {
        return DecimalFormatValue2D;
    }

    public static DecimalFormat getDecimalFormatAmountUnitary() {
        return DecimalFormatValue8D;
    }

    public static DecimalFormat getDecimalFormatExchangeRate() {
        return DecimalFormatValue4D;
    }

    public static DecimalFormat getDecimalFormatQuantity() {
        return DecimalFormatValue4D;
    }

    public static DecimalFormat getDecimalFormatPercentage() {
        return DecimalFormatPercentage8D;
    }

    public static DecimalFormat getDecimalFormatPercentageTax() {
        return DecimalFormatPercentage4D;
    }

    public static DecimalFormat getDecimalFormatPercentageDiscount() {
        return DecimalFormatPercentage4D;
    }

    public static boolean compareKeys(final int[] a, final int[] b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null && b != null || a != null && b == null) {
            return false;
        }
        else if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean compareKeys(final Object a, final Object b) {
        Object[] aoKeyA = null;
        Object[] aoKeyB = null;

        if (a == null && b == null) {
            return true;
        }
        if (a == null && b != null || a != null && b == null) {
            return false;
        }
        if (a.getClass() == int[].class && b.getClass() == int[].class) {
            return compareKeys((int[]) a, (int[]) b);
        }
        else if (a.getClass() == Object[].class && b.getClass() == Object[].class ) {
            aoKeyA = (Object[]) a;
            aoKeyB = (Object[]) b;

            if (aoKeyA.length == aoKeyB.length) {
                for (int i = 0; i < aoKeyA.length; i++) {
                    if (aoKeyA[i] instanceof Number && aoKeyB[i] instanceof Number) {
                        if (((Number) aoKeyA[i]).doubleValue() != ((Number) aoKeyB[i]).doubleValue()) {
                            return false;
                        }
                    }
                    else if (aoKeyA[i] instanceof String && aoKeyB[i] instanceof String) {
                        if (((String) aoKeyA[i]).compareTo((String) aoKeyB[i]) != 0) {
                            return false;
                        }
                    }
                    else if (aoKeyA[i] instanceof java.util.Date && aoKeyB[i] instanceof java.util.Date) {
                        if (((java.util.Date) aoKeyA[i]).compareTo((java.util.Date) aoKeyB[i]) != 0) {
                            return false;
                        }
                    }
                    else if (aoKeyA[i] != aoKeyB[i]) {
                        return false;
                    }
                }
                return true;
            }
        }

        return false;
    }

    public static boolean belongsTo(final String value, final String[] array) {
        for (String current : array) {
            if (current.equals(value)) {
                return true;
            }
        }
        
        return false;
    }

    public static boolean belongsTo(final int val, final int[] valArray) {
        boolean belongs = false;

        for (int curVal : valArray) {
            if (val == curVal) {
                belongs = true;
                break;
            }
        }

        return belongs;
    }

    public static boolean belongsTo(final int[] key, final int[][] keyArray) {
        boolean belongs = false;

        for (int[] curKey : keyArray) {
            if (compareKeys(key, curKey)) {
                belongs = true;
                break;
            }
        }

        return belongs;
    }
    
    public static int[] cloneKey(final int[] key) {
        int[] clonedKey = null;
        
        if (key != null) {
            clonedKey = new int[key.length];

            for (int i = 0; i < key.length; i++) {
                clonedKey[i] = key[i];
            }
        }
        
        return clonedKey;
    }

    public static Object[] cloneKey(final Object[] key) {
        Object[] clonedKey = null;
        
        if (key != null) {
            clonedKey = new Object[key.length];
            
            for (int i = 0; i < key.length; i++) {
                clonedKey[i] = key[i];
            }
        }
        
        return clonedKey;
    }

    public static int parseInt(final String text) {
        int value = 0;

        try {
            value = Integer.parseInt(text.trim().replaceAll(",", "").replaceAll("%", ""));
        }
        catch (NumberFormatException e) { }

        return value;
    }

    public static long parseLong(final String text) {
        long value = 0;

        try {
            value = Long.parseLong(text.trim().replaceAll(",", "").replaceAll("%", ""));
        }
        catch (NumberFormatException e) { }

        return value;
    }

    public static float parseFloat(final String text) {
        float value = 0;

        try {
            value = Float.parseFloat(text.trim().replaceAll(",", "").replaceAll("%", ""));
        }
        catch (NumberFormatException e) { }

        return value;
    }

    public static double parseDouble(final String text) {
        double value = 0;

        try {
            value = Double.parseDouble(text.trim().replaceAll(",", "").replaceAll("%", ""));
        }
        catch (NumberFormatException e) { }

        return value;
    }

    public static double round(final double value, final int decimals) {
        //return Math.round(value * Math.pow(10, decimals)) / Math.pow(10, decimals);   this method has inconsistencies, e.g. 0.04615 rounded to 4 decimals results in 0.0461 instead of 0.0462!

        RoundingDecimalFormat.setMaximumFractionDigits(decimals);
        return parseDouble(RoundingDecimalFormat.format(value));
    }

    public static double roundAmount(final double value) {
        return round(value, getDecimalFormatAmount().getMaximumFractionDigits());
    }

    public static boolean compareAmount(final double a, final double b) {
        return roundAmount(Math.abs(a - b)) < 0.01;
    }

    public static String textKey(final int[] key)  {
        String textKey = "";

        for (int id : key) {
            textKey += (textKey.length() == 0 ? "" : "-") + id;
        }

        return textKey;
    }

    public static String textRepeat(final String text, final int times) {
        String repeatedText = "";

        for (int i = 0; i < times; i++) {
            repeatedText += text;
        }

        return repeatedText;
    }

    public static String textTrim(final String text) {
        String trimmedText = text.trim();

        while(trimmedText.indexOf("  ") != -1) {
            trimmedText = trimmedText.replaceAll("  ", " ");
        }

        return trimmedText;
    }
    
    public static String[] textsTrim(final String[] texts) {
        String[] trimmedTexts = new String[texts.length];
        
        for (int i = 0; i < texts.length; i++) {
            trimmedTexts[i] = textTrim(texts[i]);
        }
        
        return trimmedTexts;
    }

    public static String textLeft(final String text, final int count) {
        return text.length() <= count ? text : text.substring(0, count);
    }

    public static String textRight(final String text, final int count) {
        return text.length() <= count ? text : text.substring(text.length() - count, text.length());
    }

    public static String textToAscii(final String text) {
        String ascii = textTrim(text);

        ascii = ascii.replaceAll("á", "a");
        ascii = ascii.replaceAll("é", "e");
        ascii = ascii.replaceAll("í", "i");
        ascii = ascii.replaceAll("ó", "o");
        ascii = ascii.replaceAll("ú", "u");
        ascii = ascii.replaceAll("Á", "A");
        ascii = ascii.replaceAll("É", "E");
        ascii = ascii.replaceAll("Í", "I");
        ascii = ascii.replaceAll("Ó", "O");
        ascii = ascii.replaceAll("Ú", "U");
        ascii = ascii.replaceAll("ä", "a");
        ascii = ascii.replaceAll("ë", "e");
        ascii = ascii.replaceAll("ï", "i");
        ascii = ascii.replaceAll("ö", "o");
        ascii = ascii.replaceAll("ü", "u");
        ascii = ascii.replaceAll("Ä", "A");
        ascii = ascii.replaceAll("Ë", "E");
        ascii = ascii.replaceAll("Ï", "I");
        ascii = ascii.replaceAll("Ö", "O");
        ascii = ascii.replaceAll("Ü", "U");
        ascii = ascii.replaceAll("à", "a");
        ascii = ascii.replaceAll("è", "e");
        ascii = ascii.replaceAll("ì", "i");
        ascii = ascii.replaceAll("ò", "o");
        ascii = ascii.replaceAll("ù", "u");
        ascii = ascii.replaceAll("À", "A");
        ascii = ascii.replaceAll("È", "E");
        ascii = ascii.replaceAll("Ì", "I");
        ascii = ascii.replaceAll("Ò", "O");
        ascii = ascii.replaceAll("Ù", "U");
        ascii = ascii.replaceAll("â", "a");
        ascii = ascii.replaceAll("ê", "e");
        ascii = ascii.replaceAll("î", "i");
        ascii = ascii.replaceAll("ô", "o");
        ascii = ascii.replaceAll("û", "u");
        ascii = ascii.replaceAll("Â", "A");
        ascii = ascii.replaceAll("Ê", "E");
        ascii = ascii.replaceAll("Î", "I");
        ascii = ascii.replaceAll("Ô", "O");
        ascii = ascii.replaceAll("Û", "U");
        ascii = ascii.replaceAll("ý", "y");
        ascii = ascii.replaceAll("Ý", "Y");
        ascii = ascii.replaceAll("ñ", "n");
        ascii = ascii.replaceAll("Ñ", "N");

        return ascii;
    }

    public static String textToXml(final String text) {
        String entity = "";
        String textAux = textTrim(text);
        String xml = "";

        for (Character c : textAux.toCharArray()) {
            entity = XmlEntityNamesMap.get(c);
            xml += entity == null ? c : entity;
        }

        return xml;
    }

    public static String textToHtml(final String text) {
        String entity = "";
        String textAux = textTrim(text);
        String html = "";

        for (Character c : textAux.toCharArray()) {
            entity = HtmlEntityNamesMap.get(c);
            html += entity == null ? c : entity;
        }

        return html;
    }

    public static String textToSql(final String text) {
        String sql = textTrim(text);

        sql = sql.replaceAll("'", "''");

        return sql;
    }

    public static String textProperCase(final String text) {
        boolean spaceFound = true;
        char[] charArray = textTrim(text).toLowerCase().toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (spaceFound) {
                charArray[i] = ("" + charArray[i]).toUpperCase().toCharArray()[0];
                spaceFound = false;
            }
            else if (charArray[i] == ' ') {
                spaceFound = true;
            }
        }

        return new String(charArray);
    }

    public static String[] textExplode(final String text, final String separator) {
        int pos = 0;
        int index = 0;
        Vector<String> strings = new Vector<String>();

        do {
            index = separator.length() == 0 ? -1 : text.indexOf(separator, pos);

            if (index == -1) {
                strings.add(text.substring(pos));
            }
            else {
                strings.add(text.substring(pos, index));
                pos = index + 1;
            }
        } while (index != -1);

        return strings.toArray(new String[strings.size()]);
    }

    public static int[] textExplodeAsIntArray(final String text, final String separator) {
        String[] textArray = textExplode(text, separator);
        int[] intArray = new int[textArray.length];

        for (int i = 0; i < textArray.length; i++) {
            intArray[i] = parseInt(textArray[i]);
        }

        return intArray;
    }

    public static String textImplode(final String[] texts, final String separator) {
        String text = "";

        for (String string : texts) {
            text += (text.isEmpty() ? "" : separator) + string;
        }

        return text;
    }

    public static String validateSafePath(final String path) throws Exception {
        String text = new String("\\/:*?\"<>|");
        char[] chars = text.toCharArray();
        
        for (char c : chars) {
            if (path.contains("" + c)) {
                throw new Exception("No se permiten los caracteres: " + text);
            }
        }

        return path;
    }
    
    /**
     * Generates random key of requested length made up with characters A-Z, a-z, 0-9, and '+' and '-'.
     * @param length Requested length.
     * @return Random key.
     */
    public static String generateRandomKey(final int length) {
        String key = "";
        
        for (int i = 0; i < length; i++) {
            key += RandomKeyChars[(int) (Math.random() / (1d / (RandomKeyChars.length - 1)))];
        }
        
        return key;
    }

    public static ImageIcon convertBlobToImageIcon(final Blob blob) throws SQLException, IOException {
        int i = 0;
        int bytesRead = 0;
        int bytesReadTotal = 0;
        byte[] buffer = new byte[1024];
        byte[] bufferImageIcon = new byte[1024 * 1024];
        InputStream is = blob.getBinaryStream();

        while ((bytesRead = is.read(buffer)) != -1) {
            for (i = 0; i < bytesRead; i++) {
                bufferImageIcon[bytesReadTotal + i] = buffer[i];
            }
            bytesReadTotal += bytesRead;
        }

        return new ImageIcon(bufferImageIcon);
    }

    public static byte[] convertBlobToBytes(final Blob blob) throws SQLException, IOException {
        InputStream is = blob.getBinaryStream();
        DataInputStream dis = new DataInputStream(is);
        byte[] bytes = new byte[dis.available()];

        dis.readFully(bytes);
        dis.close();

        return bytes;
    }

    public static void printException(final String object, final Exception exception) {
        System.err.println("[" + object + "] " + exception);
    }

    public static void printException(final Object object, final Exception exception) {
        System.err.println("[" + object.getClass().getName() + "] " + exception);
    }

    public static void printSqlQuery(final String object, final String sql) {
        System.err.println("Current SQL query in [" + object + "]:");
        System.err.println("[" + sql + "]");
    }

    public static void printSqlQuery(final Object object, final String sql) {
        System.err.println("Current SQL query in [" + object.getClass().getName() + "]:");
        System.err.println("[" + sql + "]");
    }

    public static void showException(final String object, final Exception exception) {
        DLibUtils.printException(object, exception);
        JOptionPane.showMessageDialog(null, (exception.getMessage() == null ? exception : exception.getMessage()) +
                "\n\n[" + exception.getClass().getName() + " en " + object + "]", "Exception", JOptionPane.WARNING_MESSAGE);
    }

    public static void showException(final Object object, final Exception exception) {
        DLibUtils.printException(object, exception);
        JOptionPane.showMessageDialog(null, (exception.getMessage() == null ? exception : exception.getMessage()) +
                "\n\n[" + exception.getClass().getName() + " en " + object.getClass().getName() + "]", "Exception", JOptionPane.WARNING_MESSAGE);
    }

    /** Translates a value to its text representation. */
    private static String translateValueToTexHundreds(final int value, final String languageIso639) {
        int integer;
        int remaining;
        String sText = "";
        String sBlank = "";

        if (languageIso639.compareTo(DLibConsts.LAN_ISO639_ES) == 0) {
            if (value == 100) {
                sText = MONEY_SPA_HUNDRED;
            }
            else {
                remaining = value;

                // Hundreds:

                integer = value / 100;
                if (integer > 0) {
                    sText += masSpaHundreds[integer - 1];
                    remaining -= integer * 100;
                    sBlank = " ";
                }

                // Tenths:

                if (remaining >= 11 && remaining <= 19) {
                    sText += sBlank + masSpaUnits10[remaining - 10 - 1];
                }
                else if (remaining >= 21 && remaining <= 29) {
                    sText += sBlank + masSpaUnits20[remaining - 20 - 1];
                }
                else {
                    integer = remaining / 10;
                    if (integer > 0) {
                        sText += sBlank + masSpaTens[integer - 1];
                        remaining -= integer * 10;
                        sBlank = " Y ";
                    }

                    integer = remaining;
                    if (integer > 0) {
                        sText += sBlank + masSpaUnits00[integer - 1];
                    }
                }
            }
        }
        else if (languageIso639.compareTo(DLibConsts.LAN_ISO639_EN) == 0) {
            remaining = value;

            // Hundreds:

            integer = value / 100;
            if (integer > 0) {
                sText += masEngUnits00[integer - 1] + " " + MONEY_ENG_HUNDRED;
                remaining -= integer * 100;
                sBlank = " ";
            }

            // Tenths:

            if (remaining >= 11 && remaining <= 19) {
                sText += sBlank + masEngUnits10[remaining - 10 - 1];
            }
            else {
                integer = remaining / 10;
                if (integer > 0) {
                    sText += sBlank + masEngTens[integer - 1];
                    remaining -= integer * 10;
                    sBlank = "-";
                }

                integer = remaining;
                if (integer > 0) {
                    sText += sBlank + masEngUnits00[integer - 1];
                }
            }
        }

        return sText;
    }

    /** Translates a value to its text representation. */
    public static String translateValueToText(final double value, final int decs, final String languageIso639,
            final String curSingular, final String curPlural, final String curPrefix, final String curSuffix) {

        int integer = 0;
        double remaining = 0;
        String sDecs = "";
        String sText = "";
        String sBlank = "";
        DecimalFormat formatDecs = new DecimalFormat("." + DLibUtils.textRepeat("0", decs));

        if (value > MAX_VALUE) {
            sText = "(ERROR: value greater than" + MAX_VALUE + ")";
        }
        else {
            if (languageIso639.compareTo(DLibConsts.LAN_ISO639_ES) == 0) {
                remaining = value;
                sText = "(";

                // Millions:

                integer = (int) (remaining / 1000000.0);
                if (integer > 0) {
                    sText += translateValueToTexHundreds(integer, languageIso639) + " " + (integer == 1 ? MONEY_SPA_MILLION_SNG : MONEY_SPA_MILLION_PLR);
                    remaining -= integer * 1000000.0;
                    sBlank = " ";
                }

                // Thousands:

                integer = (int) (remaining / 1000.0);
                if (integer > 0) {
                    sText += sBlank + translateValueToTexHundreds(integer, languageIso639) + " " + (integer == 1 ? MONEY_SPA_THOUSAND_SNG : MONEY_SPA_THOUSAND_PLR);
                    remaining -= integer * 1000.0;
                    sBlank = " ";
                }

                // Units:

                integer = (int) (remaining);
                if (integer > 0) {
                    sText += sBlank + translateValueToTexHundreds(integer, languageIso639);
                }

                // Currency:

                if ((int) value == 0) {
                    sText += MONEY_SPA_ZERO + " " + curPlural;
                }
                else if ((int) value == 1) {
                    sText += " " + curSingular;
                }
                else {
                    sText += " " + curPlural;
                }

                sDecs = formatDecs.format(value);
                sText += " " + sDecs.substring(sDecs.lastIndexOf(".") + 1) + "/1" + DLibUtils.textRepeat("0", decs) + " " + curSuffix + ")";
            }
            else if (languageIso639.compareTo(DLibConsts.LAN_ISO639_EN) == 0) {
                remaining = value;
                sText = "(";

                // Millions:

                integer = (int) (remaining / 1000000.0);
                if (integer > 0) {
                    sText += translateValueToTexHundreds(integer, languageIso639) + " " + MONEY_ENG_MILLION;
                    remaining -= integer * 1000000.0;
                    sBlank = " ";
                }

                // Thousands:

                integer = (int) (remaining / 1000.0);
                if (integer > 0) {
                    sText += sBlank + translateValueToTexHundreds(integer, languageIso639) + " " + MONEY_ENG_THOUSAND;
                    remaining -= integer * 1000.0;
                    sBlank = " ";
                }

                // Units:

                integer = (int) (remaining);
                if (integer > 0) {
                    sText += sBlank + translateValueToTexHundreds(integer, languageIso639);
                }

                // Currency:

                if ((int) value == 0) {
                    sText += MONEY_ENG_ZERO + " " + curPlural;
                }
                else if ((int) value == 1) {
                    sText += " " + curSingular;
                }
                else {
                    sText += " " + curPlural;
                }

                sDecs = formatDecs.format(value);
                sText += " " + sDecs.substring(sDecs.lastIndexOf(".") + 1) + "/1" + DLibUtils.textRepeat("0", decs) + " " + curSuffix + ")";
            }
            else {
                sText = "(ERROR: Not supported language.)";
            }
        }

        return sText;
    }

    /** Translates units to its text representation. */
    public static String translateUnitsToText(final double units, final int decs, final String languageIso639,
            final String unitSingular, final String unitPlural) {

        int integer = 0;
        double remaining = 0;
        double remainingDecs = 0;
        String sDecs = "";
        String sText = "";
        String sBlank = "";
        DecimalFormat formatDecs = new DecimalFormat("." + DLibUtils.textRepeat("0", decs));

        if (units > MAX_VALUE) {
            sText = "(ERROR: value grater than " + MAX_VALUE + ")";
        }
        else {
            if (languageIso639.compareTo(DLibConsts.LAN_ISO639_EN) == 0) {
                 // 1. Integer units.

                remaining = units;
                sText = "(";

                // Millions:

                integer = (int) (remaining / 1000000.0);
                if (integer > 0) {
                    sText += translateValueToTexHundreds(integer, languageIso639) + " " + (integer == 1 ? MONEY_SPA_MILLION_SNG : MONEY_SPA_MILLION_PLR);
                    remaining -= integer * 1000000.0;
                    sBlank = " ";
                }

                // Thousands:

                integer = (int) (remaining / 1000.0);
                if (integer > 0) {
                    sText += sBlank + translateValueToTexHundreds(integer, languageIso639) + " " + (integer == 1 ? MONEY_SPA_THOUSAND_SNG : MONEY_SPA_THOUSAND_PLR);
                    remaining -= integer * 1000.0;
                    sBlank = " ";
                }

                // Units:

                integer = (int) (remaining);
                if (integer > 0) {
                    sText += sBlank + translateValueToTexHundreds(integer, languageIso639);
                }

                // 2. Decimal units.

                if ((int) units == 0 && units != 0d) {
                    sText += MONEY_SPA_ZERO;
                }

                sDecs = formatDecs.format(units);
                sDecs = sDecs.substring(sDecs.lastIndexOf(".") + 1);
                remaining = parseDouble(sDecs);
                remainingDecs = remaining;

                while ((int) remainingDecs >= 10 && (int) remainingDecs % 10 == 0) {
                    remainingDecs /= 10;
                }

                if (remaining > 0) {
                    sText += " PUNTO ";

                    for (int i = 0; i < sDecs.length() - ("" + ((int) remaining)).length(); i++) {
                        sText += MONEY_SPA_ZERO + " ";
                    }

                    remaining = remainingDecs;

                    // Millions:

                    integer = (int) (remaining / 1000000.0);
                    if (integer > 0) {
                        sText += translateValueToTexHundreds(integer, languageIso639) + " " + (integer == 1 ? MONEY_SPA_MILLION_SNG : MONEY_SPA_MILLION_PLR);
                        remaining -= integer * 1000000.0;
                        sBlank = " ";
                    }

                    // Thousands:

                    integer = (int) (remaining / 1000.0);
                    if (integer > 0) {
                        sText += sBlank + translateValueToTexHundreds(integer, languageIso639) + " " + (integer == 1 ? MONEY_SPA_THOUSAND_SNG : MONEY_SPA_THOUSAND_PLR);
                        remaining -= integer * 1000.0;
                        sBlank = " ";
                    }

                    // Units:

                    integer = (int) (remaining);
                    if (integer > 0) {
                        sText += sBlank + translateValueToTexHundreds(integer, languageIso639);
                    }
                }

                // Final text:

                if (units == 0d) {
                    sText += MONEY_SPA_ZERO + " " + unitPlural;
                }
                else if (units == 1d) {
                    sText += " " + unitSingular;
                }
                else {
                    sText += " " + unitPlural;
                }

                sText += ")";
            }
            else if (languageIso639.compareTo(DLibConsts.LAN_ISO639_ES) == 0) {
                // 1. Integer units.

                remaining = units;
                sText = "(";

                // Millions:

                integer = (int) (remaining / 1000000.0);
                if (integer > 0) {
                    sText += translateValueToTexHundreds(integer, languageIso639) + " " + MONEY_ENG_MILLION;
                    remaining -= integer * 1000000.0;
                    sBlank = " ";
                }

                // Thousands:

                integer = (int) (remaining / 1000.0);
                if (integer > 0) {
                    sText += sBlank + translateValueToTexHundreds(integer, languageIso639) + " " + MONEY_ENG_THOUSAND;
                    remaining -= integer * 1000.0;
                    sBlank = " ";
                }

                // Units:

                integer = (int) (remaining);
                if (integer > 0) {
                    sText += sBlank + translateValueToTexHundreds(integer, languageIso639);
                }

                // 2. Decimal units.

                if ((int) units == 0 && units != 0d) {
                    sText += MONEY_ENG_ZERO;
                }

                sDecs = formatDecs.format(units);
                sDecs = sDecs.substring(sDecs.lastIndexOf(".") + 1);
                remaining = parseDouble(sDecs);
                remainingDecs = remaining;

                while ((int) remainingDecs >= 10 && (int) remainingDecs % 10 == 0) {
                    remainingDecs /= 10;
                }

                if (remaining > 0) {
                    sText += " DOT ";

                    for (int i = 0; i < sDecs.length() - ("" + ((int) remaining)).length(); i++) {
                        sText += MONEY_ENG_ZERO + " ";
                    }

                    remaining = remainingDecs;

                    // Millions:

                    integer = (int) (remaining / 1000000.0);
                    if (integer > 0) {
                        sText += translateValueToTexHundreds(integer, languageIso639) + " " + MONEY_ENG_MILLION;
                        remaining -= integer * 1000000.0;
                        sBlank = " ";
                    }

                    // Thousands:

                    integer = (int) (remaining / 1000.0);
                    if (integer > 0) {
                        sText += sBlank + translateValueToTexHundreds(integer, languageIso639) + " " + MONEY_ENG_THOUSAND;
                        remaining -= integer * 1000.0;
                        sBlank = " ";
                    }

                    // Units:

                    integer = (int) (remaining);
                    if (integer > 0) {
                        sText += sBlank + translateValueToTexHundreds(integer, languageIso639);
                    }
                }

                // Final text:

                if (units == 0d) {
                    sText += MONEY_ENG_ZERO + " " + unitPlural;
                }
                else if (units == 1d) {
                    sText += " " + unitSingular;
                }
                else {
                    sText += " " + unitPlural;
                }

                sText += ")";
            }
            else {
                sText = "(ERROR: Not supported language.)";
            }
        }

        return sText;
    }

    public static void launch(final String command) {
        try {
            Runtime.getRuntime().exec(command);
        }
        catch (IOException e) {
            showException(DLibUtils.class.getName(), e);
        }
        catch (Exception e) {
            showException(DLibUtils.class.getName(), e);
        }
    }

    public static void launchCalculator() {
        launch("calc.exe");
    }

    public static void launchFile(final String filePath) {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler \"" + filePath + "\"");
        }
        catch (IOException e) {
            showException(DLibUtils.class.getName(), e);
        }
        catch (Exception e) {
            showException(DLibUtils.class.getName(), e);
        }
    }

    public static void invoke(Object target, Method method, Object[] args) throws IllegalAccessException, Exception {
        if (args == null) {
            method.invoke(target);
        }
        else {
            switch (args.length) {
                case 0:
                    method.invoke(target);
                    break;
                case 1:
                    method.invoke(target, args[0]);
                    break;
                case 2:
                    method.invoke(target, args[0], args[1]);
                    break;
                case 3:
                    method.invoke(target, args[0], args[1], args[2]);
                    break;
                case 4:
                    method.invoke(target, args[0], args[1], args[2], args[3]);
                    break;
                case 5:
                    method.invoke(target, args[0], args[1], args[2], args[3], args[4]);
                    break;
                case 6:
                    method.invoke(target, args[0], args[1], args[2], args[3], args[4], args[5]);
                    break;
                default:
                    throw new Exception(DLibConsts.ERR_MSG_ARGS_MANY);
            }
        }
    }
    
    /**
     * Zip a text in byte array format.
     * 
     * @param text text to zip.
     * @return text in byte array format.
     * @throws Exception 
     */
    public static byte[] zip(String text) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(text.length());
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        
        gzip.write(text.getBytes());
        gzip.close();
        
        byte[] textZip = bos.toByteArray();
        bos.close();
        
        return textZip;
    }
    
    /**
     * Unzip a byte array in a string
     * 
     * @param array byte array to unzip.
     * @return text as string.
     * @throws Exception 
     */
    public static String unzip(byte[] array) throws Exception {
        String line = "";
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        GZIPInputStream gzip = new GZIPInputStream(bis);
        BufferedReader br = new BufferedReader(new InputStreamReader(gzip, "UTF-8"));
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        br.close();
        gzip.close();
        bis.close();
        
        return sb.toString();
    }
}
