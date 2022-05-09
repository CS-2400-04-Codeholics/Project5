import java.util.Arrays;

public class Bag<T>
{
    private T[] bag;
    private static final int defaultCapacity = 100;
    private static final int maxCapacity = 500;
    private int entryNumbers;
    private boolean integrityCheck = false;
    
    /**
     * This creates a bag with default size capapcity.
     */
    public Bag()
    {
        this(defaultCapacity);
    }

    /**
     * This creates a bag with user input size capacity.
     * @param capacity
     */
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

    /**
     * This throws an exception if input is invalid.
     */
    private void checkIntegrity()
    {
        if(integrityCheck == false)
        {
            throw new SecurityException("Invalid Input");
        }
    }

    /**
     * This doubles the capacity of the bag array.
     */
    private void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    /**
     * This throws an exception if the user input capacity is greater than max capacity.
     * @param capacity
     */
    private void checkCapacity(int capacity)
    {
        if(capacity > maxCapacity)
        {
            throw new IllegalStateException("Bag capacity is larger than the max capacity.");
        }
    }

    /**
     * This locates the location of a given entry within the bag array.
     * @param anEntry
     * @return
     */
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

    /**
     * Removes and returns a given entry in the bag array.
     * @param givenIndex
     * @return
     */
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

    /**
     * This checks if the bag array is full.
     * @return
     */
    public boolean isFull()
    {
        return entryNumbers == bag.length;
    }

    /**
     * This checks if the bag array is empty.
     * @return
     */
    public boolean isEmpty()
    {
        return entryNumbers == 0;
    }

    /**
     * This gets the size of the bag array.
     * @return
     */
    public int getSize()
    {
        return entryNumbers;
    }

    /**
     * This returns the bag array.
     * @return
     */
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

    /**
     * This counts the times a given entry appears in the bag array.
     * @param anEntry
     * @return
     */
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

    /**
     * This adds indexs to the bag array.
     * @param newEntry
     * @return
     */
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

    /**
     * This removes one repeated entry in the bag array.
     * @param anEntry
     * @return
     */
    public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    /**
     * This removes a entry from in the bag array.
     * @return
     */
    public T remove()
    {
        checkIntegrity();
        T result = removeEntry(entryNumbers - 1);
        return result;
    }

    /**
     * This clears the entire bag array.
     */
    public void clear()
    {
        while(!isEmpty())
        {
            remove();
        }
    }

    /**
     * This checks if the bag array contains a given entry.
     * @param anEntry
     * @return
     */
    public boolean contains(T anEntry)
    {
        checkIntegrity();
        return getIndexOf(anEntry) >= 0;
    }
}