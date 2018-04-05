package com.yhc.qrcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年11月1日 下午11:10:03
 */
public class MyQRCodeImage implements QRCodeImage {

	private BufferedImage bufferedImage;
	
	public MyQRCodeImage() {
		
	}

	public MyQRCodeImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}



	@Override
	public int getHeight() {
		return bufferedImage.getHeight();
	}

	@Override
	public int getPixel(int arg0, int arg1) {
		
		return bufferedImage.getRGB(arg0, arg1);
	}

	@Override
	public int getWidth() {
		
		return bufferedImage.getWidth();
	}

}
