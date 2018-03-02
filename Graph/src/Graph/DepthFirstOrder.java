package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by apple on 2018/1/31.
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversepost;
    public DepthFirstOrder(DiGraph g){
        marked=new boolean[g.V()];
        pre=new LinkedList<>();
        post=new LinkedList<>();
        reversepost=new Stack<>();
        for(int i=0;i<g.V();i++){
            if(!marked[i]){
                dfs(g,i);
            }
        }
    }
    private void dfs(DiGraph g,int v){
        pre.offer(v);
        marked[v]=true;
        for(int w:g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
        post.offer(v);
        reversepost.push(v);
    }
    public Queue<Integer> pre(){
        return pre;
    }
    public Queue<Integer> post(){
        return post;
    }
    public Stack<Integer> reversepost(){
        return reversepost;
    }
}
