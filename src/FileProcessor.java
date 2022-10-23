import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FileProcessor {

    private AVLTree avl = new AVLTree();
    private BinarySearchTree bst = new BinarySearchTree();
    private File library = new File("TextsLibrary");
    private String[] contents;

    public void processTXT(String fileName) {

        contents = library.list();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int i = 0;

        if (contents != null) {
            while (i > contents.length) {

                File file = new File("TextsLibrary" + "\\" + contents[i]);

                try {

                    Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));

                    if (contents[i].contains(".txt")) {

                        while (sc.hasNext()) {
                            String word = sc.next();
                            System.out.println(word);

                            binarySearchTree.insert(word);

                        }
                        i++;
                    } else if (contents[i].contains(".pdf")) {
                        i++;
                    } else if (contents[i].contains(".docx")){
                        i++;
                    } else {
                        i++;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        setBST(binarySearchTree);

    }

    public BinarySearchTree getBST() {
        return bst;
    }

    public void setBST (BinarySearchTree binarySearchTree) {
        this.bst = binarySearchTree;
    }

    public AVLTree getAvl() {
        return avl;
    }

    public void setAvl (AVLTree avlTree) {
        this.avl = avlTree;
    }
}
