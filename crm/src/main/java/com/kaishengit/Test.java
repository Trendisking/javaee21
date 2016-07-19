package com.kaishengit;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 20330 on 2016/7/8.
 */
public class Test {
    public static void main(String[] args) throws IOException, WriterException {
        BitMatrix bitMatrix=new MultiFormatWriter().encode("15234866218", BarcodeFormat.QR_CODE,400,400);
        MatrixToImageWriter.writeToStream(bitMatrix,"png",new FileOutputStream("D:/qr.png"));


    }
}
