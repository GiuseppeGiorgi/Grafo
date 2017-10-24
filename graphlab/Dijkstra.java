package graphlab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;






public class Dijkstra {
	
		
	   private static ArrayList<Edge> GRAPH = new ArrayList<>();//contiene gli archi e il peso	
	   private static final String START = "torino";//citta di partenza
	   private static final String END = "catania";// citta di arrivo
	   
	   private static BufferedReader f = null;
	   private static String linea ;
	   
	   
	   
	   
	   
	   
	   
	   public static void main(String[] args) {
		   
		   
		   
		   try{
			   
			   FileReader input = new FileReader("src/italian_dist_graph .csv");
			   f = new BufferedReader(input);
			   
			   
			   while((linea = f.readLine()) != null){
					
					String field1 = linea.split(",")[0];
					String field2 = linea.split(",")[1];
					float field3 = Float.parseFloat(linea.split(",")[2]);
					
					GRAPH.add(new Edge(field1, field2, field3));
					GRAPH.add(new Edge(field2, field1, field3));
					
				}
			   
			   Graph g = new Graph(GRAPH);
			      g.dijkstra(START);
			      g.printPath(END);
			      //g.printAllPaths();
			   
		   }
		   catch (FileNotFoundException ex)
			{
				System.out.println("File Not found");
			}
			catch (IOException ex){
				System.out.println("IO Exception");
			}
			catch(Exception e){
				System.out.println("verificato un errore");
			}
			finally {
				try{
					f.close();
				}
				catch (IOException ex){
					System.out.println("Errore chiusura file");
				}
			}
		   
		    
		   
		   /*
		   GRAPH.add(new Edge("abadia a isola", "staggia", Float.parseFloat("3943.5861657554074")));
		   GRAPH.add(new Edge("staggia", "cippo", Float.parseFloat("3943.3861657554074")));
		   GRAPH.add(new Edge("staggia", "abadia a isola", Float.parseFloat("3943.5861657554074")));
		   GRAPH.add(new Edge("cippo", "staggia", Float.parseFloat("3943.5861657554074")));
		   GRAPH.add(new Edge("staggia", "alba", Float.parseFloat("3943.4861657554074")));
		   GRAPH.add(new Edge("cippo", "alba", Float.parseFloat("3943.4861657554074")));
		   Graph g = new Graph(GRAPH);
		      g.dijkstra(START);
		      g.printPath(END);
		      //g.printAllPaths();
		  
	     */
	   }
	}
