import java.io.*;
import java.net.*;

public class SSocket {

    /** Class constructor */
    public SSocket() {}

    /** Attribute 1, a socket */
    private Socket cs = null;

    /** Attribute 2, a server socket */
    private ServerSocket ss = null;

    /** Attribute 3, a FileProcessor object */
    private final FileProcessor fp = new FileProcessor();

    /** Attribute 4, a LibraryEditor object */
    private final LibraryEditor le = new LibraryEditor();

    /** Returns the client socket */
    public Socket getCs() {return cs;}

    /** Modifies the client socket */
    public void setCs(Socket cs) {this.cs = cs;}

    /** Returns the server socket */
    public ServerSocket getSs() {return ss;}

    /** Modifies the server socket */
    public void setSs(ServerSocket ss) {this.ss = ss;}

    /** Perpetually runs the server through a while loop */
    public void run() throws IOException {

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        ss = new ServerSocket(6174);
        System.out.println("waiting...");

        cs = ss.accept();
        System.out.println("connected to: " + cs.getInetAddress());

        inputStreamReader = new InputStreamReader(cs.getInputStream());
        outputStreamWriter = new OutputStreamWriter(cs.getOutputStream());

        bufferedReader = new BufferedReader(inputStreamReader);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        fp.process();

        while (true) {

            try {

                while (true) {

                    String word = bufferedReader.readLine();

                    if (cs.isClosed()) {
                        shutDown();
                        break;
                    }

                    if (fp.getBST().contain(word)) {

                        bufferedWriter.write(fp.getBST().getNodeLocation());
                        bufferedWriter.newLine();
                        bufferedWriter.flush();

                    } else {

                        bufferedWriter.write("No results, try searching for something else");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();

                    }
                }
                break;
            }
            catch (Exception e) {
                break;
            }
        }
    }

    /** Closes both server and client */
    public void shutDown() throws IOException {
        /* closes the client socket */
        getCs().close();

        /* closes the server socket */
        getSs().close();
    }
}
