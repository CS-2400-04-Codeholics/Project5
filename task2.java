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
{ st[++top] = j; }

public int pop() // take item off stack
{ return st[top--]; }

public int peek() // peek at top of stack
{ return st[top]; }

public boolean isEmpty() // true if nothing on stack
{ return (top == -1); }

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

class Graph
{


public Graph() // constructor
{
vertexList = new Vertex[MAX_VERTS];
// adjacency matrix
adjMat = new int[MAX_VERTS][MAX_VERTS];
nVerts = 0;
for(int y=0; y<MAX_VERTS; y++) // set adjacency
for(int x=0; x<MAX_VERTS; x++) // matrix to 0
adjMat[x][y] = 0;
theStack = new StackX();
} // end constructor
// 
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

while( !theStack.isEmpty() ) // until stack empty
{
// get an unvisited vertex adjacent to stack top
int v = getAdjUnvisitedVertex( theStack.peek() );
if(v == -1) // if there is no such vertex
theStack.pop();
else // if it exists
    {
vertexList[v].wasVisited = true; // marks it
displayVertex(v); // displays it
theStack.push(v); // pushes it
    }
} // end while

// stack is empty done
for(int j=0; j<nVerts; j++) // reset flags
vertexList[j].wasVisited = false;
} // end dfs

// returns an unvisited vertex adj to v
public int getAdjUnvisitedVertex(int v)
{
for(int j=0; j<nVerts; j++)
if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
return j;
return -1;
} // end getAdjUnvisitedVertex()

} // end class Graph

class DFSApp
{
public static void main(String[] args)
{

} // end main()
} // end class DFSApp

