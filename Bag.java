import java.util.Arrays;

public class Bag<T>
{
    private T[] bag;
    private static final int defaultCapacity = 100;
    private static final int maxCapacity = 500;
    private int entryNumbers;
    private boolean integrityCheck = false;
    
    public Bag()
    {
        this(defaultCapacity);
    }

    public Bag(int capacity)
    {
        if(capacity <= maxCapacity)
        {
            T[] tempBag = (T[])new Object[capacity];
            bag = tempBag;
            entryNumbers = 0;
            integrityCheck = true;
        }
        else
        {
            throw new IllegalStateException("Bag exceeds max capacity.");
        }
    }
    
}