import java.io.*;
import java.net.*;

public class SSocket {

    /** Class constructor */
    public SSocket() {}

    /** Attribute 1, a socket */
    private Socket cs = null;

    /** Attribute 2, a server socket */
    private ServerSocket ss = null;

    /** Attribute 3, a FileProcessor object */
    private final FileProcessor fp = new FileProcessor();

    /** Attribute 4, a LibraryEditor object */
    private final LibraryEditor le = new LibraryEditor();

    /** Attribute 5, a boolean value */
    private boolean libraryInitialized = false;

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

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        ss = new ServerSocket(6174);
        System.out.println("waiting...");

        fp.process();

            while (true) {

                cs = ss.accept();
                System.out.println("connected to: " + cs.getInetAddress());

                try {

                    inputStreamReader = new InputStreamReader(cs.getInputStream());
                    outputStreamWriter = new OutputStreamWriter(cs.getOutputStream());

                    bufferedReader = new BufferedReader(inputStreamReader);
                    bufferedWriter = new BufferedWriter(outputStreamWriter);

                    while (true) {

                        String input = bufferedReader.readLine();

                        if (input.equals("@LOAD@")) {

                            fp.process();

                            bufferedWriter.write("Library Initialized");
                            bufferedWriter.newLine();
                            bufferedWriter.flush();

                        }

                        else if (input.contains(".docx")) {

                            System.out.println("docx is " + input);

                            le.setFilePath(input);
                            le.add();

                            bufferedWriter.write("Added");
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                        }

                        else if (input.contains(".pdf")) {

                            System.out.println("pdf is " + input);

                            le.setFilePath(input);
                            le.add();

                            bufferedWriter.write("Added");
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                        }

                        else if (input.contains(".txt")) {

                            System.out.println("txt is " + input);

                            le.setFilePath(input);
                            le.add();

                            bufferedWriter.write("Added");
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                        }

                        else {

                            if (fp.getBST().contain(input)) {

                                bufferedWriter.write(fp.getBST().getNodeLocation());

                            } else {

                                bufferedWriter.write("No results, try searching for something else");

                            }

                            bufferedWriter.newLine();
                            bufferedWriter.flush();

                        }

                        if (cs.isClosed()) {
                            shutDown();
                            break;
                        }
                    }
                } catch (Exception e) {
                    break;
                }
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
