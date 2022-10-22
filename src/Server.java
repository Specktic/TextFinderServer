import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        FileProcessor fp = new FileProcessor();

        fp.processTXT("The Road Not Taken.txt");
    }
}
