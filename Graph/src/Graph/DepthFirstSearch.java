package Graph;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by apple on 2018/1/29.
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    public DepthFirstSearch(Graph g,int s){
        this.s=s;
        marked=new boolean[g.V()];
        edgeTo=new int[g.V()];
        dfs(g,s);
    }
    private void dfs(Graph g,int v){
        marked[v]=true;
        Iterator iterator=g.adj(v);
        while (iterator.hasNext()){
            int w=(int)iterator.next();
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(g,w);
            }
        }
    }

    private void dfs1(Graph g,int s){
        Stack<Integer> stack=new Stack<>();
        marked[s]=true;
        stack.push(s);
        while(!stack.isEmpty()){
            int v=stack.pop();
            Iterator iterator=g.adj(v);
            while(iterator.hasNext()){
                int w=(int)iterator.next();
                if(!marked[w]){
                    edgeTo[w]=v;
                    marked[w]=true;
                    stack.push(w);
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterator<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path=new Stack<>();
        for(int x=v;x!=s;x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path.iterator();
    }
}
