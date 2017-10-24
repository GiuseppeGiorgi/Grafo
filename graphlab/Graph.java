package graphlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;



public class Graph {
	private Map<String, Vertex> graph; // mappa un vertice 



	 /** costruisce il grafo */
	   public Graph(ArrayList<Edge> edges) {//riceve un array listi di archi
	      graph = new HashMap<>(edges.size());//capacita iniziale dell'hashmap uguale alla grandezza dell'arraylist
	 
	      //cerchiamo tutti i vertici 
	      for (Edge e : edges) {
	    	  //controlla che il nodo non esiste nel hashmap, se non esiste lo inserisce
	    	  
	         if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));//inserisce nella Map il nome e il vertice
	         //if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
	      }
	 
	      //fa un secondo giro per inserire tutti i nodi vicini al nodo controllato
	      for (Edge e : edges) {
	    	  /*
	    	   * faccio un secondo giro sui nodi, ogni nodo letto lo cerco nella Map, e nell'oggetto vertex contenuto nella Map
	    	   * gli aggiungo i nodi vicini e la distanza
	    	   * */
	         graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
	         //graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist);
	      }
	   }
	 
	   /** esecuzione dell'algoritmo di Dijkstra */ 
	   public void dijkstra(String startName) {//nome del nodo di partenza
	      if (!graph.containsKey(startName)) {//controlla che il nodo esiste nella Map
	         System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
	         return;
	      }
	      final Vertex source = graph.get(startName);
	      /*
	       * uso navigableSet che mi permette di navigare tra gli elementi
	       * */
	      NavigableSet<Vertex> q = new TreeSet<>();
	 
	      // set-up vertices
	      for (Vertex v : graph.values()) {//cicla su tutta la map e prende il valore di ogni elemento

	         v.previous = v == source ? source : null;
	         v.dist = v == source ? 0 : Float.MAX_VALUE;
	         q.add(v);// inserisce elemento nella navigableSet
	      }

	      dijkstra(q);
	   }
	 
	   /** implementazione di dijkstra usando un heap binario */
	   private void dijkstra(NavigableSet<Vertex> q) {//riceve il favigableSet lo metto final perche non deve cambiare

		   Vertex u, v;
	      while (!q.isEmpty()) {//cicla su tutto il Set

			  u = q.pollFirst(); // ordina gli elementi per distanza e ritora il primo elemento(distanza piu breve)

			  if (u.dist == Integer.MAX_VALUE) break;

			  //controlla la distanza per ogni nodo vicino
			  for (Map.Entry<Vertex, Float> a : u.neighbours.entrySet()) {
				  v = a.getKey(); //il nodo vicino per questa iterazione

				  final Float alternateDist = u.dist + a.getValue();//somma la distanza

				  if (alternateDist < v.dist) { // shorter path to neighbour found

					  q.remove(v);

					  v.dist = alternateDist;
					  v.previous = u;
					  q.add(v);

				  }
			  }
	      }
	   }
	 
	   /** Stampa un vertice */
	   public void printPath(String endName) {
	      if (!graph.containsKey(endName)) {
	         System.err.printf("Il grafo non contine il vertice \"%s\"\n", endName);
	         return;
	      }
	 
	      graph.get(endName).printPath();
	      System.out.println();
	   }
	   
	}
