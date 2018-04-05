package com.yhc.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年11月1日 下午9:39:03
 */
public class CreateQRCode {

	public static void main(String[] args) {
		
		//生成出的二维码的基本属性
		int width = 300;
		int height = 300;
		String format = "png";
		String contents = "https://github.com/lBetterManl";
		
		//定义二维码的参数
		HashMap<EncodeHintType, Comparable> hints = new HashMap<EncodeHintType, Comparable>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		
		//生成二维码
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height);
			
			File filePath = new File("D:/code");
			if(!filePath.exists()){
				filePath.mkdir();
			}
			File fl = new File(filePath,"img.png");
			if(!fl.exists()){
				fl.mkdir();
			}
			Path file = fl.toPath();
			
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
