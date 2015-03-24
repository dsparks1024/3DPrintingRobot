/*
 * Image Line Detection Program
 * Written By: Dominick Sparks
 * Written On: 3-16-2015
 */
package pkg3dprintingrobot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
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
        System.out.println("Test Image Processing Program:");
        
        String fileName = "/Users/Dom/Desktop/image.jpg";        
        int[][] imageArray;
        boolean[][] boolArray;
        
        BufferedImage image = null;
        
        try{
            image = ImageIO.read(new File(fileName));
        }catch(Exception e){
            System.out.println("ERROR: Could not open file");
            System.exit(1);
        }
        
        imageArray = toRGB(image);
        boolArray = convertToBoolArray(imageArray);
        ArrayList<LinePoint> points = new ArrayList<>();
        
        // Add black points into an object that will contain detailed
        // information about that specific point
        for(int row=image.getHeight()-1;row>-1;row--){
            for(int col=0;col<image.getWidth();col++){
                if(boolArray[row][col]){
                    LinePoint point = new LinePoint(row,col);
                    points.add(point);
                }
            }
        }
        
        // Loop through the list of points that are on the black line
        for(int i=0;i<points.size();i++){
            LinePoint point = points.get(i);
            System.out.println(points.get(i).x + ","+ points.get(i).y);
        }
       
    }
    
    /* Returns the array of RGB data for the image. The origin is at the 
    ** bottom left of the image. 
    **
    ** !!!!! RETURNS THE ARRAY PARSED FROM THE BOTTOM LEFT OF IMAGE !!!!
    */
    /*
    private static int[][] toRGB(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] result = new int[height][width];

        for(int row=height-1;row>-1;row--){
            for(int col=0;col<width;col++){
                result[row][col] = image.getRGB(col, row);
                System.out.print(result[row][col]+" ");
            }
                System.out.println();
        }
      return result;
   }
   */
    private static int[][] toRGB(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] result = new int[height][width];

        for(int row=0;row<height;row++){
            for(int col=0;col<width;col++){
                result[row][col] = image.getRGB(col, row);
               // System.out.print(result[row][col]+" ");
            }
                //System.out.println();
        }
      return result;
   }
    
    private static boolean[][] convertToBoolArray(int[][] rgbArray){
        int col = rgbArray[0].length;
        int row = rgbArray.length;
        boolean[][] result = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int rgb = rgbArray[i][j];
                int red   = (rgb & 0x00FF0000)  >>> 16;
                int green = (rgb & 0x0000FF00)  >>> 8;
                int blue  = (rgb & 0x000000FF)  >>> 0;
                if(red == 0 && green == 0 && blue == 0){
                    //System.out.println("(" + i + "," + j+")");
                    result[i][j] = true;
                }else{
                    result[i][j] = false;
                }
                
                if(result[i][j])
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println();
         }  
        return result;
    }
}
