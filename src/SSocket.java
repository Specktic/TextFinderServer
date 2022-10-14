import java.net.*;

public class SSocket {
    public static void main(String[] args){
        new SSocket();
    }

    public SSocket(){
        try{
            ServerSocket ss = new ServerSocket(87312);

            System.out.println("waiting...");
            Socket cs = ss.accept();
            System.out.println("connected to: " + cs.getInetAddress());



        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
