import java.io.*;
import java.net.*;

public class SSocket {

    /** Class constructor */
    public SSocket() {}

    /** Attribute 1, a socket */
    private Socket cs = null;

    /** Attribute 2, a server socket */
    private ServerSocket ss = null;

    /** Attribute 3, a FileProcessor class */
    private final FileProcessor fp = new FileProcessor();

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

        fp.process();

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        ss = new ServerSocket(6174);
        System.out.println("waiting...");

        while (true) {

            try {

                cs = ss.accept();
                System.out.println("connected to: " + cs.getInetAddress());

                inputStreamReader = new InputStreamReader(cs.getInputStream());
                outputStreamWriter = new OutputStreamWriter(cs.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

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


    /** Reads incoming data from the client */
    public String receive() throws IOException {
        /* waits for client to read data */
        cs.setSoLinger(true, 10);

        /* data flux for receiving data from client */
        DataInputStream bufferIn = new DataInputStream (cs.getInputStream());

        /* object to be read is created and assigned data from the flux */
        SocketData auxIn = new SocketData("");
        auxIn.readObject (bufferIn);

        System.out.println ("received: " + auxIn);
        return auxIn.toString();
    }

    /** Sends data to the client */
    public void send(String location) throws IOException {
        try {

            /* waits for data to be collected before closing */
            cs.setSoLinger(true, 10);

            /* data flux for sending data to the client */
            DataOutputStream bufferOut = new DataOutputStream(cs.getOutputStream());

            /* data is written on the output flux */
            SocketData auxOut = new SocketData(location);
            auxOut.writeObject(bufferOut);

            /* prints data sent to console */
            System.out.println("sent: " + auxOut);

        } catch (IOException e) {
            e.printStackTrace();
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
