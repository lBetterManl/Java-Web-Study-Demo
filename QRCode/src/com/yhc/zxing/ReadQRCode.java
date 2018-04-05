package com.yhc.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年11月1日 下午10:10:23
 */
public class ReadQRCode {

	public static void main(String[] args) {

		MultiFormatReader formatReader = new MultiFormatReader();
		File file = new File("D:/code/img.png");
		if(!file.exists()){
			return;
		}
		try {
			BufferedImage image = ImageIO.read(file);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			
			Result result = formatReader.decode(binaryBitmap,hints);
			
			System.out.println("解析结果："+result.toString());
			System.out.println("二维码的格式："+result.getBarcodeFormat());
			System.out.println("二维码中文本内容："+result.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
