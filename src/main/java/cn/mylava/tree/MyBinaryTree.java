package cn.mylava.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树的java实现
 * <p>
 * 二叉树是一种非常重要的数据结构，它同时具有数组和链表各自的特点：它可以像数组一样快速查找，也可以像链表一样快速添加。但是他也有自己的缺点：删除操作复杂。
 * <p>
 * 二叉树：每个结点最多有两个子树的有序树，一个节点的左子节点的值必须小于此节点，右子节点的值必须大于或者是等于此节点，所以又称二叉查找树、二叉排序树、二叉搜索树。
 * 完全二叉树：若设二叉树的高度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第h层有叶子结点，并且叶子结点都是从左到右依次排布，这就是完全二叉树。
 * 满二叉树：除了叶结点外每一个结点都有左右子叶且叶子结点都处在最底层的二叉树。
 * <p>
 * 二叉树的特点
 * 1）树执行查找、删除、插入的时间复杂度都是O(logN)
 * 2）遍历二叉树的方法包括前序、中序、后序
 * 3）非平衡树指的是根的左右两边的子节点的数量不一致
 * 4）在非空二叉树中，第i层的结点总数不超过 , i>=1；
 * 5）深度为h的二叉树最多有个结点(h>=1)，最少有h个结点；
 * 6）对于任意一棵二叉树，如果其叶结点数为N0，而度数为2的结点总数为N2，则N0=N2+1；
 *
 * @author lipengfei
 */
public class MyBinaryTree<T extends Comparable> {
    private Node<T> root;

    public MyBinaryTree() {
    }

    public MyBinaryTree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     * 插入数据
     *
     * @param data
     */
    public void insert(T data) {
        Node<T> newNode = new Node();
        newNode.setValue(data);
        if (root == null) {
            this.root = newNode;
        } else {
            //从root开始，将root节点作为当前节点
            Node<T> current = this.root;
            Node<T> parent;
            while (true) {
                parent = current;
                if (data.compareTo(current.getValue()) < 0) {
                    //小于当前节点，继续和当前节点的左侧子节点对比
                    current = current.getLeft();
                    //如果当前节点为空，直接放置到左侧，反之，循环继续
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }

                } else {
                    //大于等于当前节点，继续和当前节点的右侧子节点对比
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 同时插入多条数据
     *
     * @param list
     */
    public void buildTree(List<T> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                insert(list.get(i));
            }
        }
    }

    /**
     * 前根序遍历-------迭代实现
     * <p>
     * 前序遍历：也叫先序遍历，先访问根节点
     * 先遍历根结点，然后遍历左子树，最后遍历右子树。--> root/left/right
     *
     * @param node
     */
    public List<T> iteratorPreOrder(Node<T> node) {
        List<T> result = new ArrayList<T>();
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> current = null;
        if (node == null) {
            return result;
        } else {
            stack.push(node);
            while (!stack.empty()) {
                current = stack.pop();
                result.add(current.getValue());
                if (current.getRight() != null) {
                    stack.push(current.getRight());
                }

                if (current.getLeft() != null) {
                    stack.push(current.getLeft());
                }
            }
        }
        return result;
    }

    /**
     * 前根序遍历-------递归实现
     *
     * @param node
     * @return
     */
    public List<T> recursePreOrder(Node<T> node) {
        List<T> result = new ArrayList<T>();
        innerPreOrder(node, result);
        return result;
    }

    private void innerPreOrder(Node<T> node, List<T> result) {
        if (node != null) {
            result.add(node.getValue());
            innerPreOrder(node.getLeft(), result);
            innerPreOrder(node.getRight(), result);
        }
    }

    /**
     * 中根序遍历-------递归实现
     * <p>
     * 中序遍历：顾名思义，中间访问根节点
     * 先遍历左子树，然后遍历根结点，最后遍历右子树。--> left/root/right
     * 中序遍历二叉树会使所有的节点按照升序被访问到。
     *
     * @param
     */
    public List<T> recurseInOrder(Node<T> node) {
        List<T> result = new ArrayList<T>();
        innerInOrder(node, result);
        return result;
    }

    private void innerInOrder(Node<T> node, List<T> result) {
        if (node != null) {
            innerInOrder(node.getLeft(), result);
            result.add(node.getValue());
            innerInOrder(node.getRight(), result);
        }
    }

    /**
     * 中根序遍历-------迭代实现
     *
     * @param node
     */
    public List<T> iteratorInOrde(Node<T> node) {
        List<T> result = new ArrayList<T>();
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> current = node;
        while (current != null || !stack.empty()) {
            //取出当前节点下所有的左侧节点放入stack中
            while (current != null) {
                stack.add(current);
                current = current.getLeft();
            }
            //从stack的top取出一个节点作为当前节点
            current = stack.peek();
            stack.pop();
            //取得当前节点的值
            result.add(current.getValue());
            //将右侧节点设为当前节点
            current = current.getRight();
        }
        return result;
    }

    /**
     * 后根序遍历-------迭代实现
     * <p>
     * 后序遍历：后访问根节点
     * 先遍历左子树，然后遍历右子树，最后遍历根结点。--> left/right/root
     *
     * @param node
     */
    public List<T> iteratorPostOrder(Node<T> node) {
        List<T> result = new ArrayList<T>();
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> current = node;
        Node<T> accessed = null; //accessed标记被访问过的右节点
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.peek();

            if (current.getRight() != null && current.getRight() != accessed) {
                current = current.getRight();
            } else {
                current = stack.pop();
                T value = current.getValue();
                result.add(value);
                accessed = current;
                current = null;
            }
        }

        return result;
    }

    /**
     * 后根序遍历-------递归实现
     *
     * @param node
     * @return
     */
    public List<T> recursePostOrder(Node<T> node) {
        List<T> result = new ArrayList<T>();
        innerPostOrder(node, result);
        return result;
    }

    private void innerPostOrder(Node<T> node, List<T> result) {
        if (node != null) {
            innerPostOrder(node.getLeft(), result);
            innerPostOrder(node.getRight(), result);
            result.add(node.getValue());
        }
    }

    /**
     * 按层遍历
     * @param node
     */
    public List<T> iteratorLevel(Node<T> node) {
        Queue<Node<T>> queue = new LinkedBlockingQueue<Node<T>>();
        List<T> result = new ArrayList<T>();
        queue.add(node);
        Node<T> current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            result.add(current.getValue());
            if (current.getLeft()!=null) {
                queue.add(current.getLeft());
            }
            if (current.getRight()!=null) {
                queue.add(current.getRight());
            }
        }

        return result;
    }

    /**
     * 求二叉树的最大深度
     * @param node
     * @return
     */
    public int maxDeepth(Node<T> node){
        if (node == null) {
            return 0;
        }
        int left = maxDeepth(node.getLeft());
        int right = maxDeepth(node.getRight());
        return Math.max(left,right)+1;
    }

    public int minDeepth(Node<T> node){
        if (node == null) {
            return 0;
        } else {
            return getMin(node);
        }
    }
    private int getMin(Node<T> node){
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.getLeft()==null && node.getRight()==null) {
            return 1;
        }
        return Math.min(getMin(node.getLeft()),getMin(node.getRight()))+1;
    }
}

