import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class SSocket {

    /** Class constructor */
    public SSocket(){
        try{
            /* a server socket is created for a given port */
            setSs(new ServerSocket(6174));
            System.out.println("waiting...");

            /* a connection to the port is accepted */
            setCs(ss.accept());
            System.out.println("connected to: " + getCs().getInetAddress());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /** attribute 1, a socket */
    private Socket cs;

    /** attribute 2, a server socket */
    private ServerSocket ss;

    /** cs Socket getter and setter */
    public Socket getCs() {return cs;}
    public void setCs(Socket cs) {this.cs = cs;}

    /** ss Server Socket getter and setter */
    public ServerSocket getSs() {return ss;}
    public void setSs(ServerSocket ss) {this.ss = ss;}

    public String receive() throws IOException {
        /* waits for client to read data */
        getCs().setSoLinger(true, 10);

        /* data flux for receiving data from client */
        DataInputStream bufferIn = new DataInputStream (getCs().getInputStream());

        /* object to be read is created and assigned data from the flux */
        SocketData auxIn = new SocketData("");
        auxIn.readObject (bufferIn);

        System.out.println ("received: " + auxIn);
        return auxIn.toString();
    }

    public void send() throws IOException {
        /* data flux for sending data to the client */
        DataOutputStream bufferOut = new DataOutputStream (getCs().getOutputStream());

        /* object to be sent is created */
        SocketData auxOut = new SocketData("8913");
        auxOut.writeObject (bufferOut);
        System.out.println("sent: " + auxOut);
    }

    public void shutDown() throws IOException {
        /* closes the client socket */
        getCs().close();

        /* closes the server socket */
        getSs().close();
    }
}
