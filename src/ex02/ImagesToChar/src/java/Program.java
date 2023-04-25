package edu.school21.printer.app;

import com.beust.jcommander.*;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import com.diogonunes.jcdp.color.api.Ansi.Attribute;
import com.diogonunes.jcdp.color.api.Ansi.BColor;
import com.diogonunes.jcdp.color.api.Ansi.FColor;
import edu.school21.printer.logic.Logic;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import javax.imageio.ImageIO;

@Parameters(separators = "=")
class Settings {
  @Parameter(names = {"--white", "-w"}, required = true)
  public String white = "GREEN";
  @Parameter(names = {"--black", "-b"}, required = true)
  public String black = "RED";
}

public class Program {
  public static void main(String[] args) {
    if (args.length == 2) {
      Settings settings = new Settings();

      try {
        new JCommander(settings, args);
      } catch (Exception e) {
        System.out.println("Wrong input!");
        System.exit(-1);
      }

      BufferedImage img = null;
      Logic l = new Logic();
      try {
        img = ImageIO.read(new File("target/resources/image.bmp"));
      } catch (IOException e) {
        System.out.println("No file!");
        System.exit(-1);
      }

      BColor w = null;
      BColor b = null;
      try {
        w = Ansi.BColor.valueOf(settings.white);
        b = Ansi.BColor.valueOf(settings.black);
      } catch (Exception e) {
        System.out.println("Wrong color!");
        System.exit(-1);
      }

      ColoredPrinter cp = new ColoredPrinter.Builder(1, false)
                              .foreground(FColor.WHITE)
                              .background(BColor.BLACK)
                              .build();

      Boolean[][] res = l.getMatrix(img);

      for (int i = 0; i < res.length; i++) {
        for (int j = 0; j < res[i].length; j++) {
          if (res[j][i])
            cp.print(" ", Attribute.BOLD, FColor.YELLOW, b);
          else
            cp.print(" ", Attribute.BOLD, FColor.YELLOW, w);
        }
        cp.clear();
        System.out.printf("\n");
      }
    }
  }
}