package Graph;

/**
 * Created by apple on 2018/2/27.
 */
public class Topological {
    //给定优先级的任务序列，求出调度计划，判断是否成环，如果成环，无解。否则用逆后序得到结果。
    private Iterable<Integer> order;
    public Topological(DiGraph g){
        DiGraphCycle cycleFinder=new DiGraphCycle(g);
        if(!cycleFinder.hasCycle()){
            DepthFirstOrder dfs=new DepthFirstOrder(g);
            order=dfs.reversepost();
        }
        else{
            System.out.println("This problem no solution");
        }
    }
    public Iterable<Integer> getOrder(){
        return order;
    }
    public boolean isEmpty(){
        return order==null;
    }
}
