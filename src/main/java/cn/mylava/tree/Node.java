package cn.mylava.tree;

/**
 * @author lipengfei
 */
public //树的节点
class Node<T> {

    //左侧子节点，全部比value小
    private Node<T> left;
    //右侧子节点，全部比value大
    private Node<T> right;
    //当前节点值
    private T value;

    public Node() {
    }

    public Node(Node<T> left, Node<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(T value) {
        this(null, null, value);
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("left=").append(left);
        sb.append(", right=").append(right);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}