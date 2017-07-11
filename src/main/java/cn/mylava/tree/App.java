package cn.mylava.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipengfei
 */
public class App {
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<Integer>();
        List list = new ArrayList();
        list.add(4);
        list.add(7);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(6);
        list.add(8);
        tree.buildTree(list);

        List<Integer> orderInt;
        //递归中序遍历
        orderInt = tree.recurseInOrder(tree.getRoot());
        System.out.println("递归中序："+orderInt);
        //迭代中序遍历
        orderInt = tree.iteratorInOrde(tree.getRoot());
        System.out.println("迭代中序："+orderInt);

        //迭代前序遍历
        orderInt = tree.iteratorPreOrder(tree.getRoot());
        System.out.println("迭代前序："+orderInt);
        //递归前序遍历
        orderInt = tree.recursePreOrder(tree.getRoot());
        System.out.println("递归前序："+orderInt);

        //递归后序遍历
        orderInt = tree.recursePostOrder(tree.getRoot());
        System.out.println("递归后序："+orderInt);
        //迭代后序遍历
        orderInt = tree.iteratorPostOrder(tree.getRoot());
        System.out.println("遍历后序："+orderInt);

        //按层遍历
        orderInt = tree.iteratorLevel(tree.getRoot());
        System.out.println("按层遍历："+orderInt);

        //二叉树最大深度
        int height;
        height = tree.maxDeepth(tree.getRoot());
        System.out.println("最大深度："+ height);
    }




}
