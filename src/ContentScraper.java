import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.net.URL;

public class ContentScraper {
    public static String getContent(URL link){
        StringBuilder builder= new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));
            String line;
            while ((line = reader.readLine()) != null){
                builder.append(line+"\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return builder.toString();
    }
}
