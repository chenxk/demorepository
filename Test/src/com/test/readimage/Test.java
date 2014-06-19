package com.test.readimage;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.vietocr.ImageHelper;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadDLL("liblept168.dll");
		loadDLL("libtesseract302.dll");
		//File file = new File("dll/liblept168.dll");
		//System.out.println(System.getProperty("java.io.tmpdir"));
		
		File imageFile = new File("images/QQ截图20140514113059.png");
		Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
		
		//BufferedImage image = new BufferedImage
		
		// 这里对图片黑白处理,增强识别率.这里先通过截图,截取图片中需要识别的部分
		//BufferedImage textImage = ImageHelper.convertImageToGrayscale(ImageHelper.getSubImage(panel.image, startX, startY, endX, endY));
		// 图片锐化,自己使用中影响识别率的主要因素是针式打印机字迹不连贯,所以锐化反而降低识别率
		// textImage = ImageHelper.convertImageToBinary(textImage);
		// 图片放大5倍,增强识别率(很多图片本身无法识别,放大5倍时就可以轻易识,但是考滤到客户电脑配置低,针式打印机打印不连贯的问题,这里就放大5倍)
		//textImage = ImageHelper.getScaledInstance(textImage, endX * 5, endY * 5);
		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadDLL(String libFullName) {
        try {
            String nativeTempDir = System.getProperty("java.io.tmpdir");//java.io.tmpdir
            System.out.println(nativeTempDir);
            InputStream in = null;
            FileOutputStream writer = null;
            BufferedInputStream reader = null;
            File extractedLibFile = new File(nativeTempDir + File.separator + libFullName);
            if (!extractedLibFile.exists()) {
                try {
                	File file = new File("dll/" + libFullName);
                	in = new FileInputStream(file);
                    //in = Test.class.getResourceAsStream("/dll/" + libFullName);
                   // System.out.println(Test.class.getResource("dll/" + libFullName).toString());
                	
                    reader = new BufferedInputStream(in);
                    writer = new FileOutputStream(extractedLibFile);
                    byte[] buffer = new byte[1024];
                    while (reader.read(buffer) > 0) {
                        writer.write(buffer);
                        buffer = new byte[1024];
                    }
                    in.close();
                    writer.close();
                    System.load(extractedLibFile.toString());
                    //System.loadLibrary(extractedLibFile.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (in != null) {
                        in.close();
                    }
                    if (writer != null) {
                        writer.close();
                    }
                }
            } else {
                System.load(extractedLibFile.toString());
            }
        } catch (IOException e) {
        	e.printStackTrace();
            System.out.println("初始化 " + libFullName + " DLL错误");
        }
 }

}
