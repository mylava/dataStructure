package cn.mylava.tree;

/**
 * 二叉树的java实现
 *
 * 二叉树是一种非常重要的数据结构，它同时具有数组和链表各自的特点：它可以像数组一样快速查找，也可以像链表一样快速添加。但是他也有自己的缺点：删除操作复杂。
 *
 * 二叉树：每个结点最多有两个子树的有序树，一个节点的左子节点的值必须小于此节点，右子节点的值必须大于或者是等于此节点，所以又称二叉查找树、二叉排序树、二叉搜索树。
 * 完全二叉树：若设二叉树的高度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第h层有叶子结点，并且叶子结点都是从左到右依次排布，这就是完全二叉树。
 * 满二叉树：除了叶结点外每一个结点都有左右子叶且叶子结点都处在最底层的二叉树。
 *
 * 二叉树的特点
 * 1）树执行查找、删除、插入的时间复杂度都是O(logN)
 * 2）遍历二叉树的方法包括前序、中序、后序
 * 3）非平衡树指的是根的左右两边的子节点的数量不一致
 * 4）在非空二叉树中，第i层的结点总数不超过 , i>=1；
 * 5）深度为h的二叉树最多有个结点(h>=1)，最少有h个结点；
 * 6）对于任意一棵二叉树，如果其叶结点数为N0，而度数为2的结点总数为N2，则N0=N2+1；
 * @author lipengfei
 */
public class MyTree<T> {
    private Node<T> root;

    public MyTree() {
    }

    public MyTree(Node<T> root) {
        this.root = root;
    }

    //创建二叉树
   /* public void buildTree(T data) {

        try {
            scn = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        root = createTree(root,scn);
    }*/
}

//树的节点
class Node<T> {

    //左侧子节点，全部比value小
    private Node<T> left;
    //右侧子节点，全部比value大
    private Node<T> right;
    //当前节点值
    private T value;

    public Node() {
    }
    public Node(Node<T> left,Node<T> right,T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(T value) {
        this(null,null,value);
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

}