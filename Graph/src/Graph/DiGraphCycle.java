package Graph;

import java.util.Stack;

/**
 * Created by apple on 2018/1/30.
 */
public class DiGraphCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;
    DiGraphCycle(DiGraph g){
        marked=new boolean[g.V()];
        edgeTo=new int[g.V()];
        onStack=new boolean[g.V()];
        for(int i=0;i<g.V();i++){
            if(!marked[i]){
                dfs(g,i);
            }
        }
    }
    private void dfs(DiGraph g,int v){
        marked[v]=true;
        onStack[v]=true;
        for(int w:g.adj(v)){
            if(this.hasCycle()) return;
            else if(!marked[w]){edgeTo[w]=v;dfs(g,w);}
            else if(onStack[w]){
                cycle=new Stack<>();
                for(int x=v;x!=w;x=edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v]=false;
    }
    public boolean hasCycle(){
        return cycle!=null;
    }
    public Iterable<Integer> cycle(){
        return cycle;
    }
}
