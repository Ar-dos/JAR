
package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Program {
  public static void main(String[] args) {
    if (args.length == 2) {
      if (args[0].length() == 1 && args[1].length() == 1) {
        String dot = args[0];
        String ndot = args[1];
        BufferedImage img = null;
        Logic l = new Logic();
        try {
          img = ImageIO.read(new File("target/resources/image.bmp"));
        } catch (IOException e) {
          System.out.println("No file!");
        }

        Boolean[][] res = l.getMatrix(img);

        for (int i = 0; i < res.length; i++) {
          for (int j = 0; j < res[i].length; j++) {
            if (res[j][i])
              System.out.printf("%s", dot);
            else
              System.out.printf("%s", ndot);
          }
          System.out.printf("\n");
        }
      }
    }
  }
}