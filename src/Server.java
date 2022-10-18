import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        SSocket ss = new SSocket();
        ss.receive();
        ss.send();
        ss.shutDown();
    }
}
