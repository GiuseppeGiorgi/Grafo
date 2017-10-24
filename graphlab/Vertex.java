package graphlab;

import java.util.HashMap;
import java.util.Map;


/** un vertice del grafo, vengono mappati i vertici vicini */
public class Vertex implements Comparable<Vertex> {
   public final String name;
   public Float dist = Float.MAX_VALUE; // MAX_VALUE = infinito
   public Vertex previous = null;
   public final Map<Vertex, Float> neighbours = new HashMap<>();//mappa i vertici vicini

   public Vertex(String name) {
      this.name = name;
   }

   public void printPath() {
      if (this == this.previous) {
         System.out.printf("%s", this.name);
      } else if (this.previous == null) {
         System.out.printf("%s(unreached)", this.name);
      } else {
         this.previous.printPath();
         //System.out.printf(" -> %s(%d)", this.name, this.dist);
         System.out.printf(" -> %s(%f)", this.name, this.dist);
      }
   }

   public int compareTo(Vertex other) {
      return Float.compare(dist, other.dist);
   }
}

