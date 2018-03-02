package Graph;

/**
 * Created by apple on 2018/2/27.
 */
public class DiGraphDFS {
    private boolean[] marked;
    public DiGraphDFS(DiGraph g,int s){
        marked=new boolean[g.V()];
        if(!marked[s]) dfs(g,s);
    }
    public DiGraphDFS(DiGraph g,Iterable<Integer> source){
        marked=new boolean[g.V()];
        for(int s:source){
            if(!marked[s]){
                dfs(g,s);
            }
        }
    }
    private void dfs(DiGraph g,int s){
        marked[s]=true;
        for(int w:g.adj(s)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }
    public boolean marked(int v){
        return marked[v];
    }
}
