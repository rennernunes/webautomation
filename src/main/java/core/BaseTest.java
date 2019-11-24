package core;

import io.cucumber.java.After;

import javax.imageio.ImageIO;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static core.DriverFactory.killDriver;
import static core.LocalProperties.FECHAR_BROWSER;


public class BaseTest {

  @After
  public void quit() throws IOException, AWTException {
    String data = new SimpleDateFormat("dd-MM-YY_HHmmss").format(Calendar.getInstance().getTime());
    Robot robot = new Robot();
    BufferedImage ss =
        robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

    File outputFile = new File(
        "target" + File.separator + "screenshot" + File.separator + "screenshot " + data + ".png");
    File parentDir = outputFile.getParentFile();
    if (parentDir != null && !parentDir.exists()) {
      if (!parentDir.mkdirs()) {
        throw new IOException("error creating directories");
      }
    }

    ImageIO.write(ss, "PNG", outputFile);

    if (FECHAR_BROWSER) {
      killDriver();
    }

  }
}
