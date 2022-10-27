import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        SSocket ss = new SSocket();
        ss.run();
    }
}
