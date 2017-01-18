import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class LinksReader {
    public static ArrayList<URL> readFromFile(File file) throws IOException{
        ArrayList<URL> links= new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String link;
        while ((link = bufferedReader.readLine()) != null)
            links.add(new URL(link));
        return links;
    }
}
