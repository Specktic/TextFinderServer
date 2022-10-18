import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class SSocket {

    public SSocket(){
        try{
            /* a server socket is created for a given port */
            ServerSocket ss = new ServerSocket(6174);
            System.out.println("waiting...");

            /* a connection to the port is accepted */
            Socket cs = ss.accept();
            System.out.println("connected to: " + cs.getInetAddress());

            /* waits for client to read data */
            cs.setSoLinger(true, 10);

            /* data flux for receiving data from client */
            DataInputStream bufferIn = new DataInputStream (cs.getInputStream());

            /* object to be read is created and assigned data from the flux */
            SocketData auxIn = new SocketData("");
            auxIn.readObject (bufferIn);
            System.out.println ("received: " + auxIn);

            /* data flux for sending data to the client */
            DataOutputStream bufferOut = new DataOutputStream (cs.getOutputStream());

            /* object to be sent is created */
            SocketData auxOut = new SocketData(auxIn.toString());
            auxOut.writeObject (bufferOut);
            System.out.println("sent: " + auxOut);


            /* closes the client socket */
            cs.close();

            /* closes the server socket */
            ss.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
