import java.util.List;

/** binary node for binary search tree */
public class BinaryNode {

    /** constructor 1 */
    public BinaryNode(String word, List occurrence){
        this(word, occurrence, null, null);
    }

    /** constructor 2 */
    public BinaryNode(String word, List occurrence, BinaryNode left, BinaryNode right){
        this.word = word;
        this.occurrence = occurrence;
        this.left = left;
        this.right = right;
    }

    /** attribute 1, a string */
    private String word;

    /** attribute 2, a List */
    private List occurrence;

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
    public List getOccurrence () {
        return occurrence;
    }
    public void setOccurrence (List occurrence) {
        this.occurrence = occurrence;
    }

    /** getter and setter methods for left attribute */
    public BinaryNode getLeft() {
        return left;
    }
    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    /** getter and setter methods for left attribute */
    public BinaryNode getRight() {
        return right;
    }
    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
