import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        //SSocket ss = new SSocket();
        LibraryEditor libraryEditor = new LibraryEditor();
        libraryEditor.add(new File("Texts" + "\\" + "The Road Not Taken.docx"));
    }
}
