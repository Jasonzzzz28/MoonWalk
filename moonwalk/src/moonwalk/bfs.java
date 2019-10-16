package moonwalk;
import java.util.*;

public class bfs {
	public int dist[];
	public int temp;
	public int res;
	private PriorityQueue<Node> pq; 
	private int V; // Number of vertices 
	List<Node> adj[];
	
	public bfs(int V) {
		 this.V = V; 
		 dist = new int[V];
	     
	}
	
	  public int BFS(int s, List<Node> adj[]) 
	    { 
	        // Mark all the vertices as not visited(By default 
	        // set as false) 
	        ArrayList<String> visited = new ArrayList<String>(); 
	  
	        // Create a queue for BFS 
	        LinkedList<Node> queue = new LinkedList<Node>(); 
	  
	        for (int i = 0; i < V; i++) 
	            dist[i] = Integer.MAX_VALUE; 
	        // Mark the current node as visited and enqueue it 
	        visited.add(Integer.toString(s));  
	        dist[s] = 0;
	        int pre = s;
	        temp = 0; 
	        Iterator<Node> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                Node n = i.next(); 
                queue.push(n); 
                //dist[n.node] = n.cost;
                //visited.add(Integer.toString(n.node));
                
            }
	      
            
       /*     if ((temp^n.cost) < temp)
                queue.push(n); 
                 
                else {
                	if ((temp^n.cost) < temp)
                		queue.push(e);*/

	        while (queue.size() != 0) 
	        { 
	        	Node x = queue.pop(); 
	            temp = pre == s? x.cost:temp^(x.cost);
	            dist[x.node] = temp;
	            //System.out.println(x.node);
	            
	            Iterator<Node> j = adj[x.node].listIterator(); 
	            int count = 0;
	            while (j.hasNext()) {
	            	Node n = j.next();
	            	if (!visited.contains(Integer.toString(n.node))) {
	            		queue.push(n);
	            		visited.add(Integer.toString(n.node));
	            		count++;
	            	}
	            	else if((temp^n.cost) < dist[n.node]) {
	            		visited.remove(Integer.toString(n.node));
	            		queue.push(n);
	            		count++;
	            	}
	            	
	            }
	            if (count == 0) {
	            	pre = s;
	            }
	            else {
	            	pre = x.node;
	            }
	           
	             
	 
	            
	        } 
          
          return dist[V-1];
	    } 
}
