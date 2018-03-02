package com.company;

import java.util.*;

/**
 * Created by apple on 2018/3/2.
 */
public class ASTART {
    private static final int MOVE_THEN=1;
    private static final int LENGTH=1;
    private static int totalRow;
    private static int totalCow;
    Map<String,Node> openMap=new HashMap<>();
    Map<String,Node> closedMap=new HashMap<>();
    Set<Node> barried;
    public Node startNode;
    public Node endNode;
    Node currentNode;
    int num;
    public ASTART(int col,int row,Set<Node> b) {
        totalCow=col;
        totalRow=row;
        this.barried=b;
    }

    public void move(int x1,int y1,int x2,int y2){
        num=0;
        startNode=new Node(x1,y1);
        endNode=new Node(x2,y2);
        closedMap.put(startNode.toString(),startNode);
        currentNode=startNode;
        toOpen(currentNode.x,currentNode.y);
        while(num<500000){
            currentNode=toClose();
            if(currentNode.x!=endNode.x||currentNode.y!=endNode.y){
                toOpen(currentNode.x,currentNode.y);
            }else{
                endNode=currentNode;
                break;
            }
            num++;
        }
        if(currentNode.equals(endNode)){
            System.out.println("find the path");
        }else{
            System.out.println("sorry,no path");
        }
    }

    private void toOpen(int x,int y){
        addOpenPoint(new Node(x-1,y),ASTART.MOVE_THEN);
        addOpenPoint(new Node(x+1,y),ASTART.MOVE_THEN);
        addOpenPoint(new Node(x,y-1),ASTART.MOVE_THEN);
        addOpenPoint(new Node(x,y+1),ASTART.MOVE_THEN);
    }

    private void addOpenPoint(Node node,int gCost){
        if(node.x<0||node.y<0) return;
        String key=node.toString();
        Node temp=new Node(node.x,node.y);
        if(!barried.contains(temp)){
           int hEstimate=getGuessLength(node.x,node.y,endNode.x,endNode.y);
           int totalCost=currentNode.gCost+gCost;
           int fTotal=totalCost+hEstimate;
           if(!closedMap.containsKey(key)){
               node.hEstimate=hEstimate;
               node.gCost=totalCost;
               node.fTotal=fTotal;
               Node oldPoint=openMap.get(key);
               if (oldPoint != null) {
                   if (oldPoint.gCost > totalCost) {
                       oldPoint.fTotal = fTotal;
                       oldPoint.pre = currentNode;
                       openMap.put(key, oldPoint);
                   }
               } else {
                   node.pre = currentNode;
                   openMap.put(key, node);
               }
           }
        }
    }

    private Node toClose() {
        List<Node> list = new ArrayList<>(openMap.values());
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.fTotal > o2.fTotal) {
                    return 1;
                } else if (o1.fTotal < o2.fTotal) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        if (list.size() > 0) {
            currentNode = list.get(0);
            closedMap.put(currentNode.toString(), currentNode);
            openMap.remove(currentNode.toString());
        }
        return currentNode;
    }

    public void showPath(){
        Stack<Node> stack=new Stack<>();
        Node temp=currentNode;
        while(temp.pre!=null){
            stack.push(temp);
            temp=temp.pre;
        }
        stack.push(temp);
        int size=stack.size();
        for(int i=0;i<size;i++){
            System.out.println(stack.pop().toString());
        }
    }

    private int getGuessLength(int x1, int y1, int x2, int y2) {
        //return ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 -y1))* AStar.LENGHT;
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2)) * ASTART.LENGTH;
        //return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)) * AStar.LENGHT;
        //return 0;
    }

}
