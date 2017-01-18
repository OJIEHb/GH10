import java.io.File;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final String PATH_TO_FILE = "/home/andrey/links.txt";
    private static final String PATH_TO_RESULTFILE = "/home/andrey/MD5.txt";

    public static void main(String [] args) throws Exception{
        ArrayList<URL> links = LinksReader.readFromFile(new File(PATH_TO_FILE));
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (URL link : links) {
            executorService.execute(() -> grabContentFromURL(link));
        }
        executorService.shutdown();
    }

    static void grabContentFromURL(URL url){
        try {
            String content = ContentScraper.getContent(url);
            String MD5Hash = MD5Driver.generateMD5Hash(content);
            MD5Driver.writeMD5HashToFile((url + " ,MD5: " + MD5Hash),PATH_TO_RESULTFILE);
            System.out.println("Thread: "+Thread.currentThread().getName() + " URL: " + url + " MD5Hash: " + MD5Hash);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
}
