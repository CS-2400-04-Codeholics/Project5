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

    }

    } // end class Vertex

class Graph
{


public Graph() // constructor
{

} // end constructor

public void addVertex(char lab)
{

}

public void addEdge(int start, int end)
{

}

public void displayVertex(int v)
{
System.out.print(vertexList[v].label);
}

public void dfs() // depth-first search
{ 
} // end dfs

public int getAdjUnvisitedVertex(int v)
{

} // end getAdjUnvisitedVertex()

} // end class Graph

class DFSApp
{
public static void main(String[] args)
{

} // end main()
} // end class DFSApp

