package com.company;

/**
 * Created by apple on 2018/3/1.
 */
public class Node {
        int x;
        int y;
        Node pre;
        int gCost;
        int hEstimate;
        int fTotal;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return "["+x+","+y+"]";
        }
}
