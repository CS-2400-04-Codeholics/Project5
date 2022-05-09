public class Driver 
{
    public static void main(String[] args)
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
        getBreadthFirstTraversal(0, graph);
        System.out.println();

    }

    /**
     * Task 1: Write a program that uses an algorithm that performs a breadth-first traversal.
     * @param origin
     * @param graph
     */
    public static void getBreadthFirstTraversal(int origin, Graph<String> graph)
    {
        Bag<Integer> TraversalOrder = new Bag<>();
        TraversalOrder.add(origin);
        System.out.print(graph.getLabel(origin));

        int[] queue = new int[10];
        int queCount = 0;
        boolean count = false;
        int[] neighbors = graph.neighbors(origin);
        for(int i = 0; i < neighbors.length; i++)
        {
            queue[i] = neighbors[i];
            queCount++;
            TraversalOrder.add(neighbors[i]);
            System.out.print(graph.getLabel(neighbors[i]));
        }
        while(queCount != 0)
        {
            neighbors = graph.neighbors(queue[0]);
            for(int i = 0; i < neighbors.length; i++)
            {
                if(!TraversalOrder.contains(neighbors[i]))
                {
                    queue[queCount] = neighbors[i];
                    queCount++;
                    count = true;
                    TraversalOrder.add(neighbors[i]);
                    System.out.print(graph.getLabel(neighbors[i]));               
                }
            }
            for(int i = 0; i < queue.length - 1; i++)
                queue[i] = queue[i + 1];
            if(count == true)
                queCount--;
        }
    }

}
