import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        AVLTree avlTree = new AVLTree();
        avlTree.insert("alley");
        avlTree.insert("bake");
        avlTree.insert("cake");
    }
}
