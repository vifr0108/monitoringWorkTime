import com.dropbox.core.v2.DbxClientV2;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread
{
    private final DbxClientV2 client;
    private final InputStream is;

    public MyThread(DbxClientV2 client, InputStream is)
    {
        this.client = client;
        this.is = is;
    }

    @Override
    public void run()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date now = new Date();
        System.out.println(formatter.format(now));

        try
        {
            client.files().uploadBuilder("/" + now.toString() + ".png").uploadAndFinish(is);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
