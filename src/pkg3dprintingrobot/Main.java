/*
 * Image Line Detection Program
 * Written By: Dominick Sparks
 * Written On: 3-16-2015
 */
package pkg3dprintingrobot;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Dominick Sparks
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Test Image Processing Program");
        
        String fileName = "/Users/Dom/Desktop/image.jpg";        
        int[][] imageArray;
        
        BufferedImage image = null;
        
        try{
            image = ImageIO.read(new File(fileName));
        }catch(Exception e){
            System.out.println("ERROR: Could not open file");
            System.exit(1);
        }
        
        imageArray = toRGB(image);
        
        System.out.println(imageArray[0][0]);
        
        int width = image.getWidth();
        int height = image.getHeight();
        
        for (int row = 0; row < height; row++) {
            
            
            for (int col = 0; col < width; col++) {
                int rgb = image.getRGB(row,col);
                int red   = (rgb & 0x00FF0000)  >>> 16;
                int green = (rgb & 0x0000FF00)  >>> 8;
                int blue  = (rgb & 0x000000FF)  >>> 0;
                if(red == 0 && green == 0 && blue == 0){
                    System.out.println("(" + row + "," + col+")");
                }
         }
      }
        
    }
    
    private static int[][] toRGB(BufferedImage image) {
      int width = image.getWidth();
      int height = image.getHeight();
      int[][] result = new int[height][width];

      for (int row = 0; row < height; row++) {
         for (int col = 0; col < width; col++) {
            result[row][col] = image.getRGB(row, col);
         }
      }
      return result;
   }
}
