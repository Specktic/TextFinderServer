import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

    /** constructor */
    public BinarySearchTree(){
        this.root = null;
    }

    /** attribute 1, a binary node */
    private BinaryNode root;

    private BinaryNode getRoot(){
        return this.root;
    }

    /** method for checking if tree is empty */
    public boolean empty(){
        return this.root == null;
    }

    /** public method for calling contain() method */
    public boolean contain(String word){
        return this.contain(word, this.root);
    }
    /** method for checking if tree contains a node with a given element */
    private boolean contain(String word, BinaryNode node){
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

    /** public method for calling treeMin() method */
    public BinaryNode treeMin() {
        if (this.empty()) {
            return null;
        } else {
            return this.treeMin(this.root);
        }
    }

    /** method for finding node with the minimum element */
    private BinaryNode treeMin(BinaryNode node) {
        if (this.empty()) {
            return null;
        } else {
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
        } return node;
    }

    /** public method for calling treeMax() method */
    public BinaryNode treeMax() {
        if (this.empty()) {
            return null;
        } else {
            return this.treeMax(this.root);
        }
    }

    /** method for finding node with the maximum element */
    private BinaryNode treeMax(BinaryNode node) {
        if (node != null) {
            while (node.getRight() != null){
                node = node.getRight();
            }
        } return node;
    }



    /** public method for calling insert() method */
    public void insert(String word) {
        List Occurrence = new LinkedList();
        Occurrence.add(1);
        this.root = this.insert(word, Occurrence, this.root);
    }

    /** method for inserting a node with a given element */
    private BinaryNode insert(String word, List occurrence, BinaryNode node) {
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

    public void delete(String word) {
        this.root = this.delete(word, this.root);
    }

    private BinaryNode delete(String word, BinaryNode node) {

        if (node == null){
            return node;}

        int compare = word.compareTo(node.getWord());

        if (compare < 0) {
            node.setLeft(delete(word, node.getLeft()));
        } else if (compare > 0) {
            node.setRight(delete(word, node.getRight()));
        } else if (node.getLeft() != null && node.getRight() != null) {
            node.setWord(treeMin(node.getRight()).getWord());
            node.setRight(delete(node.getWord(), node.getRight()));
        } else {
            node = node.getLeft() != null ? node.getLeft() : node.getRight();
        }
        return node;
    }
}
