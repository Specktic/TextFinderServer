import java.io.IOException;
import java.util.Arrays;

public class Server {
    /** Runs the server from the main method */
    public static void main(String[] args) throws IOException {
        SSocket ss = new SSocket();
        ss.run();
    }
}
