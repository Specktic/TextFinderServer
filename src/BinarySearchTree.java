import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

    /** constructor */
    public BinarySearchTree(){
        this.root = null;
    }

    /** attribute 1, a binary node */
    private BinaryNode root;

    public boolean empty(){
        return this.root == null;
    }

    public boolean contain(String word, BinaryNode node){
        if (node == null){
            return false;
        } else {
            int compare = word.compareTo(node.getWord());

            if (compare < 0){
                return contain(word, node.getLeft());
            } else if (compare > 0) {
                return contain(word, node.getRight());
            } else {
                return true;
            }
        }
    }

    public void insert(String word) {
        List Occurrence = new LinkedList();
        Occurrence.add(1);
        this.root = this.insert(word, Occurrence, this.root);
    }
    public BinaryNode insert(String word, List occurrence, BinaryNode node){
        if ( node == null){
            List Occurrence = new LinkedList();
            Occurrence.add(1);
            return new BinaryNode(word, Occurrence ,null, null);
        }

        int compare = word.compareTo(node.getWord());

        if (compare < 0){
            List Occurrence = new LinkedList();
            Occurrence.add(1);
            node.setLeft(this.insert(word, Occurrence, node.getLeft()));
        } else if (compare > 0){
            List Occurrence = new LinkedList();
            Occurrence.add(1);
            node.setRight(this.insert(word, Occurrence, node.getRight()));
        } else {
            node.getOccurrence().add(1);
        }

        return node;
    }
}
