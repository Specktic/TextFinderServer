import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FileProcessor {

    /** Class constructor */
    public FileProcessor(){
        this.bst = new BinarySearchTree();
        this.library = new File("TextsLibrary");
    }

    /** Attribute 1, a binary search tree */
    private BinarySearchTree bst;

    /** Attribute 2, a binary file */
    private File library;

    /** Attribute 3, a string array */
    private String[] contents;

    /** Attribute 4, a PdfReader object */

    private PdfReader pdfReader;

    /** Parses every document from the library directory and loads their individual words into a tree */
    public void process() {

        contents = library.list();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int i = 0;

        if (contents != null) {
            while (i < contents.length) {

                File file = new File("TextsLibrary" + "\\" + contents[i]);

                try {

                    Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));

                    if (contents[i].contains(".txt")) {
                        System.out.println("reading: " + contents[i]);

                        while (sc.hasNext()) {
                            String word = sc.next();
                            binarySearchTree.insert(word, contents[i]);
                        }

                        i++;

                    } else if (contents[i].contains(".pdf")) {
                        System.out.println("reading: " + contents[i]);

                        PdfReader pdfReader = new PdfReader();
                        pdfReader.setFilePath(file.getPath());
                        String text = pdfReader.pdfToString();

                        for (String word: text.split(" ")) {
                            binarySearchTree.insert(word, contents[i]);
                        }

                        i++;

                    } else if (contents[i].contains(".docx")){
                        System.out.println("reading: " + contents[i]);

                        DocxReader docxReader = new DocxReader();
                        docxReader.setFilePath(file.getPath());
                        String text = docxReader.docxToString();

                        for (String word: text.split(" ")) {
                            binarySearchTree.insert(word, contents[i]);
                        }

                        i++;

                    } else {
                        i++;

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            setBST(binarySearchTree);
        }
    }

    /** Returns the binary search tree of the bst attribute */
    public BinarySearchTree getBST() {
        return bst;
    }

    /** Modifies the binary search tree of the bst attribute*/
    public void setBST (BinarySearchTree binarySearchTree) {
        this.bst = binarySearchTree;
    }

}
