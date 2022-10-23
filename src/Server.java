import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        SSocket ss = new SSocket();

        FileProcessor fp = new FileProcessor();

        fp.processTXT("The Road Not Taken.txt");

        System.out.println(fp.getBST().empty());

        ss.shutDown();

    }
}
