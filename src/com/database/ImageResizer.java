package com.database;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import java.util.concurrent.locks.Lock;

import javax.imageio.ImageIO;
 
/**
 * This program demonstrates how to resize an image.
 *
 * @author www.codejava.net
 *
 */
public class ImageResizer {
 
    /**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @throws IOException
     */
    public static String resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
             {
    	String val=null;
    	try{
        // reads input image
        File inputFile = new File(inputImagePath);
       System.out.println("path= "+ inputFile.getPath());
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
       /* Thread.sleep(100);*/
         val="ok";
        
		
    	}catch(Exception e){
    		 val="not";
    		e.printStackTrace();
    	}
    	
    	return val;
    }
 
    
    
    
    
    
    public static String resize2(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
             {
    	String val=null;
    	inputImagePath="imagBlurImg2.JPG";
    	outputImagePath="imagBlurImg2_big.JPG";
    	scaledWidth=1024;
    	scaledHeight=786;
    	try{
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
       /* Thread.sleep(100);*/
         val="ok";
        
		
    	}catch(Exception e){
    		 val="not";
    		e.printStackTrace();
    	}
    	
    	return val;
    }
    /**
     * Resizes an image by a percentage of original size (proportional).
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param percent a double number specifies percentage of the output image
     * over the input image.
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath, double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
    }
 
    /**
     * Test resizing images
     */
    public static void main(String[] args) {
        String inputImagePath = "C:\\Users\\VIIPL02\\Downloads\\download.jpg";
        String outputImagePath1 = "/download_big.jpg";
       /* String outputImagePath2 = "C:/Users/VIIPL02/Downloads/images/re size/2-2.jpg";
        String outputImagePath3 = "C:/Users/VIIPL02/Downloads/images/re size/3-3.jpg";*/
 
        try {
            // resize to a fixed width (not proportional)
            int scaledWidth = 1024;
            int scaledHeight = 1024;
            
            ImageResizer im=new ImageResizer();
            
            im.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);
 
            /*// resize smaller by 50%
            double percent = 0.5;
            im.resize(inputImagePath, outputImagePath2, percent);
 
            // resize bigger by 50%
            percent = 1.5;
            im.resize(inputImagePath, outputImagePath3, percent);*/
 
        } catch (Exception ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
    }
 
}