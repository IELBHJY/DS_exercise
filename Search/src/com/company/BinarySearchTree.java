package com.company;

import java.util.Queue;

/**
 * Created by apple on 2018/1/24.
 */
public class BinarySearchTree<Key extends Comparable<Key>,Value> {
    public class Node{
        public Key key;//键
        public Value val;//值
        Node left,right;//左右子树
        int N;//结点个数
        public Node(Key key,Value val,int N){
            this.key=key;
            this.val=val;
            this.N=N;
        }
    }

    public Node root;
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x==null) return 0;
        return x.N;
    }


    public Value get(Key key){
        return get(key,root);
    }
    private Value get(Key key,Node x){
         if(x==null) return null;
         int cmp=key.compareTo(x.key);
         if(cmp>0){
             return get(key,x.right);
         }else if(cmp<0){
             return get(key,x.left);
         } else{
             return x.val;
         }
    }

    public void put(Key key,Value val){
         root= put(key,val,root);
    }
    private Node put(Key key,Value val,Node x){
        if(x==null) return new Node(key,val,1);
        int cmp=key.compareTo(x.key);
        if(cmp>0){
            x.right= put(key,val,x.right);
        }else if(cmp<0){
            x.left= put(key,val,x.left);
        }else{
            x.val=val;
        }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left==null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right==null) return x;
        return max(x.right);
    }

    public Key select(int k){
        return select(root,k).key;
    }

    /**
     * 返回排名第k位的结点，从0开始
     * @param x  结点
     * @param k  排名
     * @return
     */
    private Node select(Node x,int k){
        if(x==null) return null;
        int t=size(x);
        if(k>t) return null;
        int l=size(x.left);
        if(l>k){
            return select(x.left,k);
        }else if(l<k){
            return select(x.right,k-l-1);
        }
        else{
            return x;
        }
    }

    public  Key floor(Key key){
        Node x=floor(root,key);
        if(x==null) return null;
        return x.key;
    }

    private Node floor(Node root,Key key){
        if(root==null) return null;
        int cmp=key.compareTo(root.key);
        if(cmp<0){
            return floor(root.left,key);
        }
        else if(cmp==0) return root;
        else{
            Node t=floor(root.right,key);
            if(t!=null) return t;
            return root;
        }
    }

    public int rank(Key key){
        return rank(key,root);
    }

    private int rank(Key key,Node x){
        if(x==null) return 0;
        int cmp=key.compareTo(x.key);
        if(cmp>0){
            return 1+size(x.left)+rank(key,x.right);
        }else if(cmp<0){
            return rank(key,x.left);
        }else{
            return size(x.left);
        }
    }

    public void deleteMin(){
        root=deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left==null) return x.right;
        x.left=deleteMin(x.left);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    public void delete(Key key){
        root=delete(root,key);
    }
    private Node delete(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp>0) x.right=delete(x.right,key);
        else if(cmp<0) x.left=delete(x.left,key);
        else{
            Node t=x;
            x=min(t.right);
            x.right=deleteMin(t.right);
            x.left=t.left;
        }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    public void searchKeys(Node root, Queue<Key> keys,Key lo,Key hi){
        if(root==null) return;
        int cmplo=lo.compareTo(root.key);
        int cmphi=hi.compareTo(root.key);
        if(cmplo<0) searchKeys(root.left,keys,lo,hi);
        if(cmphi>0) searchKeys(root.right,keys,lo,hi);
        if(cmplo>=0&&cmphi<=0) keys.offer(root.key);
    }
}
