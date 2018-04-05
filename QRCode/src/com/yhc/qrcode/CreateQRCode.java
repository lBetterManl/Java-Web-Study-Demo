package com.yhc.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年11月1日 下午10:48:26
 */
public class CreateQRCode {

	public static void main(String[] args) throws Exception {

		Qrcode x = new Qrcode();
		x.setQrcodeErrorCorrect('M');// 纠错等级
		x.setQrcodeEncodeMode('B');// N代表数字，A代表a-Z，B代表其他字符
		x.setQrcodeVersion(7);// 版本
		String qrData = "https://github.com/lBetterManl";// 内容
		int width = 67 + 12 * (7 - 1);	//其中7是版本号
		int height = 67 + 12 * (7 - 1);

		BufferedImage bufferImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferImage.createGraphics();

		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);

		int pixoff = 2;//偏移量
		
		byte[] d = qrData.getBytes("gb2312");
		if (d.length > 0 && d.length < 120) {
			boolean[][] s = x.calQrcode(d);

			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j][i]) {
						gs.fillRect(j * 3+pixoff, i * 3+pixoff, 3, 3);
					}
				}
			}			
		}

		gs.dispose();
		bufferImage.flush();
		
		ImageIO.write(bufferImage, "png", new File("D:/code/qrcode.png"));
	}

}
