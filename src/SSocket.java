import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class SSocket {
    public static void main(String[] args){
        new SSocket();
    }

    public SSocket(){
        try{
            /* a server socket is created for a given port */
            ServerSocket ss = new ServerSocket(87312);
            System.out.println("waiting...");

            /* a connection to the port is accepted */
            Socket cs = ss.accept();
            System.out.println("connected to: " + cs.getInetAddress());

            /* waits for client to read data */
            cs.setSoLinger(true, 10);

            /* data flux for receiving data from client */
            DataInputStream bufferEntrada = new DataInputStream (cs.getInputStream());

            /* object to be read is created and filled with the input data flux */
            SocketData aux = new SocketData("");
            aux.readObject (bufferEntrada);
            System.out.println ("received" + aux.toString());

            /* closes the client socket */
            cs.close();

            /* closes the server socket */
            ss.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
