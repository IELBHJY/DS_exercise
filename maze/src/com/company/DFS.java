package com.company;

import java.util.LinkedList;

/**
 * Created by apple on 2018/3/1.
 */
public class DFS {
    private static int x;
    private static int y;
    private Node end;
    public DFS(int x,int y) {
        this.x=x;
        this.y=y;
        end=new Node(x,y);
    }
    int[][] map=new int[12][14];
    int[][] move={{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] mark=new boolean[12][14];
    LinkedList<Integer> path=new LinkedList<>();
    public void dfs(Node node){
        //System.out.println(node.x+" "+node.y);
        if(node.x==end.x&&node.y==end.y){
            for(int i = path.size() - 1; i >= 0; i -= 2){
                int nextX = path.get(i);
                int nextY = path.get(i - 1);
                System.out.print("[" + nextX + "," + nextY + "]");
                if(i != 1)
                    System.out.print("->");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<4;i++){
            int nextX=node.x+move[i][0];
            int nextY=node.y+move[i][1];
            Node temp=new Node(nextX,nextY);
            if(!check(temp)) continue;
            if(map[temp.x][temp.y]==0&&!mark[temp.x][temp.y]){
                path.push(temp.x);
                path.push(temp.y);
                mark[temp.x][temp.y]=true;
                dfs(temp);
                mark[temp.x][temp.y]=false;
                path.poll();
                path.poll();
            }
        }
    }
    public void initial(int[][] maze){
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                map[i][j]=maze[i][j];
                mark[i][j]=false;
            }
        }
    }


    private  boolean check(Node node){
        return node.x>=0&&node.x<12&&node.y>=0&&node.y<14;
    }
}
