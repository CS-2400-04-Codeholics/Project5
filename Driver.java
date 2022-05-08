public class Driver 
{
    public static void main(String args[])
    {
        int length = 9;
        Graph<String> graph = new Graph<>(length);

        graph.setLabel(0, "A");
        graph.setLabel(1, "B");
        graph.setLabel(2, "C");
        graph.setLabel(3, "D");
        graph.setLabel(4, "E");
        graph.setLabel(5, "F");
        graph.setLabel(6, "G");
        graph.setLabel(7, "H");
        graph.setLabel(8, "I");

        graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(2, 1);
		graph.addEdge(3, 6);
		graph.addEdge(4, 5);
		graph.addEdge(4, 7);
		graph.addEdge(5, 2);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		graph.addEdge(8, 5);

        System.out.print("Breadth-First Traversal: ");

        System.out.println();

        System.out.print("Depth-First Traversal: ");

        System.out.println();


    }

    
}
