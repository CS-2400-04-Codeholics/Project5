public class StackX
{
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX() // constructor
    {
        st = new int[SIZE]; // make array
        top = -1;
    }

    public void push(int j) // put item on stack
    {
        st[++top] = j;
    }

    public int pop() // take item off stack
    {
        return st[top--];
    }

    public int peek() // peek at top of stack
    {
        return st[top];
    }

    public boolean isEmpty() // true if nothing on stack
    {
        return (top == -1);
    }

} // end class StackX

class Vertex
{
    public char label; // label (e.g. 'A')
    public boolean wasVisited;

    public Vertex(char lab) // constructor
    {
        label = lab;
        wasVisited = false;
    }

} // end class Vertex

class Graph2
{
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices
    private StackX theStack;

    public Graph2() // constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int y = 0; y < MAX_VERTS; y++) // set adjacency
        {
            for(int x = 0; x < MAX_VERTS; x++) // matrix to 0
            {
                adjMat[x][y] = 0;
            }
        }
        theStack = new StackX();
    } // end constructor

    public void addVertex(char lab)
    {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v)
    {
        System.out.print(vertexList[v].label);
    }

    public void dfs() // depth-first search
    { // begin at vertex 0
        vertexList[0].wasVisited = true; // mark it
        displayVertex(0); // display it
        theStack.push(0); // push it

        while(!theStack.isEmpty()) // until stack empty
        {
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(theStack.peek());

            if(v == -1) // if there is no such vertex
            {
                theStack.pop();
            }
            else // if it exists
            {
                vertexList[v].wasVisited = true; // marks it
                displayVertex(v); // displays it
                theStack.push(v); // pushes it
            }
        } // end while

        // stack is empty done
        for(int j = 0; j < nVerts; j++) // reset flags
        {
            vertexList[j].wasVisited = false;
        }
    } // end dfs

    // returns an unvisited vertex adj to v
    private int getAdjUnvisitedVertex(int v)
    {
        for(int j = 0; j < nVerts; j++)
        {
            if(adjMat[v][j] == 1 && !vertexList[j].wasVisited)
            {
                return j;
            }
        }
        return -1;
    } // end getAdjUnvisitedVertex()

} // end class Graph

class DFSApp
{
    public static void main(String[] args)
    {
        Graph2 theGraph = new Graph2();
        theGraph.addVertex('A'); // 0 (start for dfs)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('E'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('C'); // 4
        theGraph.addVertex('F'); // 5
        theGraph.addVertex('I'); // 6
        theGraph.addVertex('H'); // 7
        theGraph.addVertex('G'); // 8


        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(0, 4); // AE
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(1, 4); // BE
        theGraph.addEdge(2, 1); // CB
        theGraph.addEdge(3, 6); // DG
        theGraph.addEdge(4, 7); // EH
        theGraph.addEdge(4, 5); // EF
        theGraph.addEdge(5, 2); // FC
        theGraph.addEdge(5, 7); // FH
        theGraph.addEdge(6, 7); // GH
        theGraph.addEdge(7, 8); // HI
        theGraph.addEdge(8, 5); // IF

        System.out.print("Depth-First Traversal: ");
        theGraph.dfs(); // depth-first search
        System.out.print("\n");
    } // end main()
} // end class DFSApp
