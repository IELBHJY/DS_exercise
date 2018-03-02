package Graph;

/**
 * Created by apple on 2018/2/27.
 */
public class TransitiveClosure {

    private DiGraphDFS[] all;
    TransitiveClosure(DiGraph g){
        all=new DiGraphDFS[g.V()];
        for(int v=0;v<g.V();v++){
            all[v]=new DiGraphDFS(g,v);
        }
    }
    public boolean reachable(int v,int w){
        return all[v].marked(w);
    }
}
