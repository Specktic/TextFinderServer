import java.io.*;

/** data to be sent to server */
public class SocketData implements Serializable{
    /** constructor */
    public SocketData(String data){
        if (data != null){
            l = data.length();
            d = data;
        }
    }
    /** attribute 1, a string */
    private String d;

    /** attribute 2, an int */
    private int l;

    /**
     * method for reading data fluxes as strings
     */
    public String toString(){
        return d;
    }

    /** method for writing attributes as a DataOutputStream */
    public void writeObject(java.io.DataOutputStream out) throws IOException{
        out.writeInt (l+1);
        out.writeBytes (d);
        out.writeByte ('\0');
    }

    /** method for reading attributes as a DataOutputStream */
    public void readObject(java.io.DataInputStream in) throws IOException{
        l = in.readInt() - 1;
        byte [] aux = null;

        aux = new byte[l];            // byte array size
        in.read(aux, 0, l);       // Reads bytes
        d = new String (aux);         // turns into a string
        in.read(aux,0,1);     // reads \0
    }
}
