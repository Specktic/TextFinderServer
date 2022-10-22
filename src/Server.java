import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        SSocket ss = new SSocket();
        AVLTree avl = new AVLTree();
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert("river");
        bst.insert("nomination");
        bst.insert("dorm");
        bst.insert("nonsense");
        bst.insert("by");
        bst.insert("tycoon");

        avl.insert("river");
        avl.insert("nomination");
        avl.insert("dorm");
        avl.insert("nonsense");
        avl.insert("by");
        avl.insert("tycoon");

        String search = ss.receive();

        System.out.println(avl.contain(search));
        System.out.println(bst.contain(search));

        ss.shutDown();
    }
}
