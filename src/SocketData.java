import java.io.*;

public class SocketData implements Serializable{
    /** Class constructor */
    public SocketData(String data){
        if (data != null){
            this.len = data.length();
            this.data = data;
        }
    }
    /** Attribute 1, a string */
    private String data;

    /** Attribute 2, an int */
    private int len;

    /** Reads an incoming data flux as a string */
    public String toString(){
        return data;
    }

    /** Writes the d attribute to the output data flux */
    public void writeObject(java.io.DataOutputStream out) throws IOException{
        out.writeInt (len + 1);
        out.writeBytes(data);
        out.writeByte ('\0');
    }

    /** Reads the byte array from the data input stream */
    public void readObject(java.io.DataInputStream in) throws IOException{
        len = in.readInt() - 1;
        byte [] aux = null;

        aux = new byte[len];          // byte array size
        in.read(aux, 0, len);     // Reads bytes
        data = new String (aux);      // turns into a string
        in.read(aux,0,1);     // reads \0
    }
}
