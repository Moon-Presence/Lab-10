import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Log {
    public static void console(String msg)
    {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date today =Calendar.getInstance().getTime();
        String date = df.format(today);
        System.out.format("    "+date+" "+msg+"\n");
    }
}
