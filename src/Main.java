import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main
{
    static private final String ACCESS_TOKEN = "sl.AwoHpJJTL5ZVP29MRHK5fW3r2JuKp-1SbP9hunK5xG2co3xEgmi9yKPSzbqaRn3algWY6OwIEfN3Dcv8l_U8GUR6naEvlH2CJfQuyt0H0hn4-sSYC1rBdybjisK8MLG_zqNRi4Q";

    public static void main(String[] args) throws IOException, DbxException, AWTException, InterruptedException
    {

        // Create Dropbox client
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        for (; ; )
        {
            Robot robot = null;
            robot = new Robot();
            BufferedImage buffImage = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            System.out.println(buffImage.getWidth() + "x" + buffImage.getHeight());

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(buffImage, "png", os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());

            MyThread mt = new MyThread(client, is);
            mt.start();
            Thread.sleep(5000);
        }

    }
}
