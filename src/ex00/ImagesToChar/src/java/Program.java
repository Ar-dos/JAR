
package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Program {
  public static void main(String[] args) {
    if (args.length == 3) {
      if (args[1].length() == 1 && args[2].length() == 1) {
        String dot = args[1];
        String ndot = args[2];
        BufferedImage img = null;
        Logic l = new Logic();
        try {
          img = ImageIO.read(new File(args[0]));
        } catch (IOException e) {
          System.out.println("Wrong file!");
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