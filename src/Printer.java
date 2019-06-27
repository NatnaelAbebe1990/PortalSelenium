import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Printer {

    public void print(String content) {

        try {
            Writer writer = new FileWriter("File/report");
            writer.write(content);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
