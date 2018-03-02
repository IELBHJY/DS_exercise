package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] maze = {
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1}
         };
         DFS dfs=new DFS(11,10);
         dfs.initial(maze);
         Node start=new Node(0,1);
         dfs.dfs(start);
         /*Set<Node> sets=new HashSet<>();
         for(int i=0;i<12;i++){
             for(int j=0;j<14;j++){
                 if(maze[i][j]==1){
                     sets.add(new Node(i,j));
                 }
             }
         }
         ASTART astart=new ASTART(12,14,sets);
         astart.move(0,1,11,4);
         astart.showPath();*/
    }
}
