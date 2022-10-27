import java.io.*;
import java.net.*;

public class SSocket {

    /** Class constructor */
    public SSocket() {}

    /** attribute 1, a socket */
    private Socket cs;

    /** attribute 2, a server socket */
    private ServerSocket ss;

    /** Attribute 3, a FileProcessor class */
    private FileProcessor fp = new FileProcessor();

    /** cs Socket getter and setter */
    public Socket getCs() {return cs;}
    public void setCs(Socket cs) {this.cs = cs;}

    /** ss Server Socket getter and setter */
    public ServerSocket getSs() {return ss;}
    public void setSs(ServerSocket ss) {this.ss = ss;}

    /** Runs the server perpetually through a while loop */
    public void run(){
        fp.process();

        try {
            ss = new ServerSocket(6174);
            System.out.println("waiting...");

            while (true) {

                try {
                    cs = ss.accept();
                    System.out.println("connected to: " + cs.getInetAddress());

                    while (true) {

                        String word = receive();

                        if (fp.getBST().contain(word)) {
                            System.out.println("yeah");
                        }
                        else {
                            System.out.println("nah");
                        }

                        if (cs.isClosed()) {
                            shutDown();
                            break;
                        }
                    }
                    break;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Reads incoming data from the client */
    public String receive() throws IOException {
        /* waits for client to read data */
        getCs().setSoLinger(true, 10);

        /* data flux for receiving data from client */
        DataInputStream bufferIn = new DataInputStream (cs.getInputStream());

        /* object to be read is created and assigned data from the flux */
        SocketData auxIn = new SocketData("");
        auxIn.readObject (bufferIn);

        System.out.println ("received: " + auxIn);
        return auxIn.toString();
    }

    /** Sends data to the client */
    public void send() throws IOException {
        /* data flux for sending data to the client */
        DataOutputStream bufferOut = new DataOutputStream (getCs().getOutputStream());

        /* object to be sent is created */
        SocketData auxOut = new SocketData("8913");
        auxOut.writeObject (bufferOut);
        System.out.println("sent: " + auxOut);
    }

    /** Closes both server and client */
    public void shutDown() throws IOException {
        /* closes the client socket */
        getCs().close();

        /* closes the server socket */
        getSs().close();
    }
}
