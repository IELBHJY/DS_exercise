package Graph;

import java.util.Stack;

/**
 * Created by apple on 2018/2/1.
 */
public class KosarajuSCC {
    private int count;
    private int[] id;
    private boolean[] marked;
    public KosarajuSCC(DiGraph g){
        //count=g.V();
        id=new int[g.V()];
        marked=new boolean[g.V()];
        //反向图的逆后序顺序进行深度优先搜索。
        DepthFirstOrder order=new DepthFirstOrder(g.reverse());
        Stack<Integer> stack=order.reversepost();
        while(!stack.isEmpty()){
            int s=stack.pop();
            if(!marked[s]){
                dfs(g,s);
                count++;
            }
        }
    }
    private void dfs(DiGraph g,int s){
        marked[s]=true;
        id[s]=count;
        for(int w:g.adj(s)){
            if(!marked[w]) dfs(g,w);
        }
    }
    public boolean StronglyConnect(int v,int w){
        return id[v]==id[w];
    }
    public int id(int v){
        return id[v];
    }
    public int Count(){return this.count;}
}
