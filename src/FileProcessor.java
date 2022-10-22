import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FileProcessor {

    private AVLTree avl = new AVLTree();
    private BinarySearchTree bst = new BinarySearchTree();

    public void processTXT(String fileName) {
        try {

            File file = new File("TextsLibrary" + "\\" + fileName);
            Scanner sc = new Scanner( new BufferedReader( new FileReader(file)));
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            AVLTree avlTree = new AVLTree();

            while(sc.hasNext()){
                String word = sc.next();
                System.out.println(word);

                binarySearchTree.insert(word);
                avlTree.insert(word);
            }
            setBST(binarySearchTree);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
