/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.p3;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
/*  w w  w.  jav  a  2s .  c  om*/
import javax.imageio.ImageIO;

/**
 *
 * @author alumno
 */
public class test {
    
  public static void main(String[] args) throws Exception {
    BufferedImage image = null;

    URL url = new URL("https://www.google.com/maps/place/UPNA/@42.7972669,-1.6343405,17z/data=!3m1!4b1!4m5!3m4!1s0xd5093b30d546e2d:0xd9a9e86617c6be7b!8m2!3d42.797263!4d-1.6321518 = jpg");
    image = ImageIO.read(url);

    ImageIO.write(image, "jpg", new File("C:\\out.jpg"));

    System.out.println("Done");
  }
}
