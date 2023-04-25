package edu.school21.printer.logic;

import java.awt.image.BufferedImage;

public class Logic {
  public Boolean[][] getMatrix(BufferedImage img) {

    Boolean[][] res = new Boolean[img.getWidth()][img.getHeight()];

    for (int i = 0; i < img.getHeight(); i++) {
      for (int j = 0; j < img.getWidth(); j++) {
        if (img.getRGB(j, i) == -1)
          res[j][i] = false;
        else
          res[j][i] = true;
      }
    }
    return res;
  }
}
