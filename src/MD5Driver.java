import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Driver {
    public static String generateMD5Hash(String urlContent)throws NoSuchAlgorithmException{
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(urlContent.getBytes(), 0, urlContent.length());
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }
    public static void writeMD5HashToFile(String MD5Hash, String filePath){
        File file = new File(filePath);
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(MD5Hash+"\n");
            fileWriter.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
