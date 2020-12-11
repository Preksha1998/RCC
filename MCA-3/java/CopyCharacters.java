import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("test.txt");
            fw = new FileWriter("output_char.txt");

            int i;
            while ((i = fr.read()) != -1) {
                fw.write(i);
            }
        } finally {
            if (fr != null)
                fr.close();
            if (fw != null)
                fw.close();
        }
    }
}
