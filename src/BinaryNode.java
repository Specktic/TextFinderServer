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
}
