import java.io.*;

/**
 * data to be sent to server
 */
public class SocketData implements Serializable{
    /**
     * constructor
     */
    public SocketData(String data){
        if (data != null){
            l = data.length();
            d = data;
        }
    }
    /**
     * attribute 1, a string
     */
    private String d;

    /**
     * attribute 2, an in
     */
    private int l;

    /**
     * method for writing attributes as a DataOutputStream
     */
    public void writeObject(java.io.DataOutputStream out) throws IOException{
        out.writeBytes(d);
        out.writeByte('\0');
    }

    /**
     * method for reading the attributes of a DataInputStream
     */
    public void readObject(java.io.DataInputStream in) throws IOException{
        l = in.readInt() - 1;
        byte[] aux;

        aux = new byte[l];
        in.read(aux, 0, l);
        d = new String (aux);
        in.read(aux,0,1);
    }
}