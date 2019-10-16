package moonwalk;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import moonwalk.graphwithADJlist.Graph;

import java.io.*;

public class Driver {
	public static void main(String[] args)throws Exception { 
	  File file = new File("C:\\Users\\jason\\Desktop\\moonwalk-test2.in.txt"); 
	  
	  BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
	  String st; 
	  String pattern = "(\\d+) (\\d+)";
	  
	  Pattern r = Pattern.compile(pattern);
	  
	  st = br.readLine(); 
	  Matcher m = r.matcher(st);
	  m.find();
	  Graph g = new Graph(Integer.parseInt(m.group(1)));        
	  
	  String pattern1 = "(\\d+) (\\d+) (\\d+)";
	  Pattern k = Pattern.compile(pattern1);
	  while ((st = br.readLine()) != null) {
		  
		  Matcher x = k.matcher(st);  
		  x.find();
		  graphwithADJlist.addEdge(g,Integer.parseInt(x.group(1))-1,Integer.parseInt(x.group(2))-1,Integer.parseInt(x.group(3)));
		  
	  }
	  System.out.println("done");
	  for( int i=0; i<g.V; i++) {
		  for (Node x: g.adjListArray[i]) {
	      System.out.println("from "+i+ " to" +x.node+ " is "+ x.cost);
		  }
	  }
	 bfs dpq = new bfs(g.V); 
	 System.out.println(dpq.BFS(0, g.adjListArray));
	  
    } 
}
