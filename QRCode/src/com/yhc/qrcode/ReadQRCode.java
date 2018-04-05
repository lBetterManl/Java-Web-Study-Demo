package com.yhc.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年11月1日 下午11:05:26
 */
public class ReadQRCode {

	public static void main(String[] args) throws Exception {
		
		File file = new File("D:/code/qrcode.png");
		
		BufferedImage bufferedImage = ImageIO.read(file);
		
		QRCodeDecoder codeDecoder = new QRCodeDecoder();
		
		String result = new String(codeDecoder.decode(new MyQRCodeImage(bufferedImage)),"utf-8");
		
		System.out.println("解析结果为："+result);

	}

}
