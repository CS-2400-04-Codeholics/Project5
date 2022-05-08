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
            @SuppressWarnings("unchecked")
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

    private void checkIntegrity()
    {
        if(integrityCheck == false)
        {
            throw new SecurityException("Invalid Input");
        }
    }

    private void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    private void checkCapacity(int capacity)
    {
        if(capacity > maxCapacity)
        {
            throw new IllegalStateException("Bag is larger than the max capacity.");
        }
    }

    private int getIndexOf(T anEntry)
    {
        int place = -1;
        boolean found = false;
        int index = 0;
        while(!found && (index < entryNumbers))
        {
            if(anEntry.equals(bag[index]))
            {
                found = true;
                place = index;
            }
            index++;
        }
        return place;
    }

    private T removeEntry(int givenIndex)
    {
        T result = null;
        if(!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex];
            bag[givenIndex] = bag[entryNumbers - 1];
            bag[entryNumbers] = null;
            entryNumbers++;
        }
        return result;
    }

    public boolean isFull()
    {
        return entryNumbers == bag.length;
    }

    public boolean isEmpty()
    {
        return entryNumbers == 0;
    }

    public int getSize()
    {
        return entryNumbers;
    }

    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[entryNumbers];
        for(int index = 0; index < entryNumbers; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }

    public int getFrequencyOf(T anEntry)
    {
        checkIntegrity();
        int count = 0;
        for(int index = 0; index < entryNumbers; index++)
        {
            if(anEntry.equals(bag[index]))
            {
                count++;
            }
        }
        return count;
    }

    public boolean add(T newEntry)
    {
        checkIntegrity();
        boolean result = true;
        if(isFull())
        {
            doubleCapacity();
        }
        else
        {
            bag[entryNumbers] = newEntry;
            entryNumbers++;
        }
        return result;
    }

    public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    public T remove()
    {
        checkIntegrity();
        T result = removeEntry(entryNumbers - 1);
        return result;
    }

    public void clear()
    {
        while(!isEmpty())
        {
            remove();
        }
    }

    public boolean conatins(T anEntry)
    {
        checkIntegrity();
        return getIndexOf(anEntry) >= 0;
    }
}