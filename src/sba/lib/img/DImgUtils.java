/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib.img;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sergio Flores
 */
public abstract class DImgUtils {
    
    public static BufferedImage createQrCodeBufferedImageCfdi33(final String text, final int width, final int height) throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                 int grayValue = (bitMatrix.get(x, y) ? 1 : 0) & 0xff;
                 bufferedImage.setRGB(x, y, (grayValue == 0 ? 0xFFFFFF : 0));
            }
        }

        return bufferedImage;
    }
}
