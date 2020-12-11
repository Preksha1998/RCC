import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream("test.txt");
            fout = new FileOutputStream("testout.txt");

            int c;
            while ((c = fin.read()) != -1) {
                fout.write(c);
            }
        } finally {
            if (fin != null)
                fin.close();
            if (fout != null)
                fout.close();
        }
    }
}