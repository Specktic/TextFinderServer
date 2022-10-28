import java.util.LinkedList;

public class BinarySearchTree {

    /** constructor */
    public BinarySearchTree(){
        this.root = null;
    }

    /** attribute 1, a binary node */
    private BinaryNode root;

    /** attribute 2, an int */
    private int comparisons = 0;

    /** attribute 3, a String */
    private String nodeWord;

    /** attribute 3, a String */
    private String nodeLocation;

    /** Return the stored word */
    public String getNodeWord() {
        return nodeWord;
    }

    /** Return the stored location */
    public String getNodeLocation() {
        return nodeLocation;
    }

    /** Returns number of comparisons made */
    public int getComparisons() {
        return comparisons;
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
    private boolean contain (String word, BinaryNode node) {
        if (node == null){
            return false;
        } else {
            int compare = word.compareTo(node.getWord());

            if (compare < 0){
                return contain(word, node.getLeft());
            } else if (compare > 0) {
                return contain(word, node.getRight());
            } else {
                nodeWord = word;
                nodeLocation = node.getOccurrence().toString();
                return true;
            }
        }
    }



    /** public method for calling treeMin() method */
    public BinaryNode treeMin () {
        if (this.empty()) {
            return null;
        } else {
            return this.treeMin(this.root);
        }
    }

    /** method for finding node with the minimum element */
    private BinaryNode treeMin (BinaryNode node) {
        if (this.empty()) {
            return null;
        } else {
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
        } return node;
    }

    /** public method for calling treeMax() method */
    public BinaryNode treeMax () {
        if (this.empty()) {
            return null;
        } else {
            return this.treeMax(this.root);
        }
    }

    /** method for finding node with the maximum element */
    private BinaryNode treeMax (BinaryNode node) {
        if (node != null) {
            while (node.getRight() != null){
                node = node.getRight();
            }
        } return node;
    }

    /** public method for calling insert() method */
    public void insert (String word, String location) {
        this.root = this.insert(word, location, this.root);
    }

    /** method for inserting a node with a given element */
    private BinaryNode insert (String word, String location, BinaryNode node) {
        if ( node == null){
            return new BinaryNode(word, location,null, null);
        }

        int compare = word.compareTo(node.getWord());

        if (compare < 0){
            node.setLeft(this.insert(word, location, node.getLeft()));
        } else if (compare > 0){
            node.setRight(this.insert(word, location, node.getRight()));
        } else {
            node.occurrence.add(location);
        }
        return node;
    }

    /** public method for calling delete() method */
    public void delete (String word) {
        this.root = this.delete(word, this.root);
    }

    /** method for deleting a node with a given element */
    private BinaryNode delete (String word, BinaryNode node) {

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

    /** binary node for binary search tree */
    private static class BinaryNode {

        /** constructor 1 */
        public BinaryNode (String word, String occurrence){
            this(word, occurrence, null, null);
        }

        /** constructor 2 */
        public BinaryNode (String word, String location, BinaryNode left, BinaryNode right){

            this.word = word;

            if (this.occurrence == null) {
                this.occurrence = new LinkedList();
                occurrence.add(location);
            } else {
                this.occurrence.add(location);
            }

            this.left = left;
            this.right = right;
        }

        /** attribute 1, a string */
        private String word;

        /** attribute 2, a Linked List */
        private LinkedList occurrence;

        /** attribute 3, a binary node */
        private BinaryNode left;

        /** attribute 4, a binary node */
        private BinaryNode right;

        /** getter and setter for word attribute */
        public String getWord () {
            return word;
        }
        public void setWord (String word) {
            this.word = word;
        }

        /** getter and setter methods for occurrence attribute */
        public LinkedList getOccurrence () {
            return occurrence;
        }
        public void setOccurrence (LinkedList occurrence) {
            this.occurrence = occurrence;
        }

        /** getter and setter methods for left node attribute */
        public BinaryNode getLeft() {
            return this.left;
        }
        public void setLeft(BinaryNode node) {
            this.left = node;
        }

        /** getter and setter methods for right node attribute */
        public BinaryNode getRight() {
            return this.right;
        }
        public void setRight(BinaryNode right) {
            this.right = right;
        }
    }
}
