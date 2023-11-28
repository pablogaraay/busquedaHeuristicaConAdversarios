package aplicacion;
 
import java.util.ArrayList;
import java.util.List;
import com.jwetherell.algorithms.graph.*;
import com.jwetherell.algorithms.data_structures.Graph;
import com.jwetherell.algorithms.data_structures.Graph.Edge;
import com.jwetherell.algorithms.data_structures.Graph.Vertex;

public class Main{
	
	public static void main(String[] args){
		AStar<Integer> aStar = new AStar<Integer>();
		UndirectedGraph grafoIndirecto = new UndirectedGraph();
		List<Graph.Edge<Integer>> ruta = aStar.aStar(grafoIndirecto.graph, grafoIndirecto.v1, grafoIndirecto.v7);
		System.out.println(ruta);
	}
	
	private static class UndirectedGraph{

        	final List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
       		final Graph.Vertex<Integer> v1 = new Graph.Vertex<Integer>(1);
        	final Graph.Vertex<Integer> v2 = new Graph.Vertex<Integer>(2);
        	final Graph.Vertex<Integer> v3 = new Graph.Vertex<Integer>(3);
        	final Graph.Vertex<Integer> v4 = new Graph.Vertex<Integer>(4);
        	final Graph.Vertex<Integer> v5 = new Graph.Vertex<Integer>(5);
        	final Graph.Vertex<Integer> v6 = new Graph.Vertex<Integer>(6);
        	final Graph.Vertex<Integer> v7 = new Graph.Vertex<Integer>(7);
        	final Graph.Vertex<Integer> v8 = new Graph.Vertex<Integer>(8);

        	{
            	verticies.add(v1);
            	verticies.add(v2);
            	verticies.add(v3);
            	verticies.add(v4);
            	verticies.add(v5);
            	verticies.add(v6);
            	verticies.add(v7);
            	verticies.add(v8);
        	}

        	final List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
        	final Graph.Edge<Integer> e1_2 = new Graph.Edge<Integer>(7, v1, v2);
        	final Graph.Edge<Integer> e1_3 = new Graph.Edge<Integer>(9, v1, v3);
        	final Graph.Edge<Integer> e1_6 = new Graph.Edge<Integer>(14, v1, v6);
        	final Graph.Edge<Integer> e2_3 = new Graph.Edge<Integer>(10, v2, v3);
        	final Graph.Edge<Integer> e2_4 = new Graph.Edge<Integer>(15, v2, v4);
        	final Graph.Edge<Integer> e3_4 = new Graph.Edge<Integer>(11, v3, v4);
        	final Graph.Edge<Integer> e3_6 = new Graph.Edge<Integer>(2, v3, v6);
        	final Graph.Edge<Integer> e6_5 = new Graph.Edge<Integer>(9, v6, v5);
        	final Graph.Edge<Integer> e6_8 = new Graph.Edge<Integer>(14, v6, v8);
        	final Graph.Edge<Integer> e4_5 = new Graph.Edge<Integer>(6, v4, v5);
        	final Graph.Edge<Integer> e4_7 = new Graph.Edge<Integer>(16, v4, v7);
        	final Graph.Edge<Integer> e1_8 = new Graph.Edge<Integer>(30, v1, v8);

        	{
            	edges.add(e1_2);
            	edges.add(e1_3);
            	edges.add(e1_6);
            	edges.add(e2_3);
            	edges.add(e2_4);
            	edges.add(e3_4);
            	edges.add(e3_6);
            	edges.add(e6_5);
            	edges.add(e6_8);
            	edges.add(e4_5);
            	edges.add(e4_7);
            	edges.add(e1_8);
        	}

        	final Graph<Integer> graph = new Graph<Integer>(Graph.TYPE.DIRECTED, verticies, edges);		
		}
}
