public class AVLTree {
    /** static final attribute that defines imbalance tolerance */
    private static final int TOLERANCE = 1;

    /** method for getting height of a node */
    private int height (AVLNode t){
        return t == null ? -1 : t.getHeight();
    }

    /** method for balancing the tree*/
    private AVLNode balance (AVLNode t){
        if (t == null){
            return null;
        }
        if (height(t.getLeft()) - height(t.getRight()) > TOLERANCE){
            if (height(t.getLeft().getLeft()) >= height(t.getLeft().getRight()))
                t = rotateLeft(t);
            else
                t = doubleLeft(t);
        } else {
            if (height(t.getRight()) - height(t.getLeft()) > TOLERANCE){
                if (height(t.getRight().getRight()) >= height(t.getRight().getLeft()))
                    t = rotateRight(t);
                else
                    t = doubleRight(t);
            }
        }
        t.setHeight(Math.max(height(t.getLeft()), height(t.getRight())) + 1);
        return t;
    }

    /** method for performing a single left rotation */
    private AVLNode rotateLeft (AVLNode m){
        AVLNode m1 = m.getLeft();
        m.setLeft(m1.getRight());
        m1.setRight(m);
        m.setHeight(Math.max(height(m.getLeft()), height(m.getRight())) + 1);
        m1.setHeight(Math.max(height(m1.getLeft()), m.getHeight()) + 1);
        return m1;
    }

    /** method for performing a double left rotation */
    private AVLNode doubleLeft (AVLNode m){
        m.setLeft(rotateRight(m.getLeft()));
        return rotateLeft(m);
    }

    /** method for performing a single right rotation */
    private AVLNode rotateRight (AVLNode m){
        AVLNode m1 = m.getRight();
        m.setRight(m1.getLeft());
        m1.setLeft(m);
        m.setHeight(Math.max(height(m.getRight()), height(m.getLeft())) + 1);
        m1.setHeight(Math.max(height(m1.getRight()), m.getHeight()) + 1);
        return m1;
    }

    /** method for performing a double right rotation */
    private AVLNode doubleRight (AVLNode m){
        m.setRight(rotateLeft(m.getRight()));
        return rotateLeft(m);
    }
}

