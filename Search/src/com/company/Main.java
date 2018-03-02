package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinarySearchTree<Integer,String> BST=new BinarySearchTree<>();
        BST.put(5,"亚索");
        BST.put(8,"影流之主");
        BST.put(3,"菲兹");
        BST.put(1,"探险家");
        BST.put(6,"武器大师");
        BST.put(2,"蛮族之王");
        BST.put(4,"凤女");
        BST.put(7,"莫甘娜");
        BST.put(9,"乐芙兰");
        BinarySearchTree.Node root=BST.root;
        //InOrder(root);
        System.out.println(BST.select(0));
    }

    private static void InOrder(BinarySearchTree.Node root){
        if(root==null) return;
        InOrder(root.left);
        System.out.println(root.key);
        InOrder(root.right);
    }
}
