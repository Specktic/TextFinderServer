import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        AVLTree avlTree = new AVLTree();
        avlTree.insert("a");
        avlTree.insert("b");
        avlTree.insert("c");
        avlTree.insert("d");
        avlTree.insert("e");
        avlTree.insert("f");
        avlTree.insert("g");
        avlTree.insert("h");

        System.out.println(avlTree.getRoot().getWord());
    }
}
