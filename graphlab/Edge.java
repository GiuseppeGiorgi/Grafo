package graphlab;

//arco che collega 2 nodi
public class Edge {
    public final String v1, v2;//nodi
    public final Float dist;//distanza tra i nodi
    public Edge(String v1, String v2, Float dist) {
       this.v1 = v1;
       this.v2 = v2;
       this.dist = dist;
    }
 }