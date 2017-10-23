/**
   A single linked data dequeue that implements DequeInterface.
   @author Minwoo Soh
*/
public final class SingleLinkedDeque<T> implements DequeInterface<T>
{
  private Node front;
  private Node last;
  private int numberOfEntries;

  /** Creates an empty SingleLinkedDeque object with no nodes. */
  public SingleLinkedDeque()
  {
    front = null;
    last = null;
  } // end default constructor

  /** Adds a new entry to the front of this dequeue.
      @param newEntry  An object to be added. */
  public void addToFront(T newEntry)
  {
    if(front == null) // If there are no nodes in the queue.
    {
      Node newNode = new Node(newEntry);
      front = newNode;
      last = newNode;
      numberOfEntries++;
    }
    else // If there is a node already in queue.
    {
      Node newNode = new Node(newEntry);
      front.prev = newNode;
      front = newNode;
      numberOfEntries++;
    } // end if
  } // end addToFront

  /** Adds a new entry to the back of this dequeue.
      @param newEntry  An object to be added. */
  public void addToBack(T newEntry)
  {
    if(last == null) // If there are no nodes in the queue.
    {
      Node newNode = new Node(newEntry);
      front = newNode;
      last = newNode;
      numberOfEntries++;
    }
    else // If there is a node already in queue.
    {
      Node newNode = new Node(newEntry);
      newNode.prev = last;
      last = newNode;
      numberOfEntries++;
    } // end if
  } // end addToBack

  /** Removes and returns the front entry of this dequeue.
      @return  The object at the front of the dequeue.
      @throws  EmptyQueueException if the dequeue is empty before the operation. */
  public T removeFront()
  {
    T item = null;

    try
    {
      if(isEmpty())
      {
        throw new EmptyQueueException();
      }
      else
      {
        if(front == last) // If there is only one node in the queue.
        {
          item = front.data;
          front = null;
          last = null;
          numberOfEntries--;
        }
        else // If there are more than one nodes in the queue.
        {
          item = front.data;
          front.data = null; // Delete data for security.
          Node current = last;
          while(current.prev != front) // Go through nodes until it reaches 2nd node.
          {
            current = current.prev;
          } // end while
          current.prev = null;
          front = current;
          numberOfEntries--;
        } // end if
      } // end if
    } // end try
    catch(EmptyQueueException e)
    {
      System.out.println("Exception thrown: " + e);
    } // end catch

    return item;
  } // end removeFront

  /** Removes and returns the back entry of this dequeue.
      @return  The object at the back of the dequeue.
      @throws  EmptyQueueException if the dequeue is empty before the operation. */
  public T removeBack()
  {
    T item = null;
    try
    {
      if(isEmpty())
      {
        throw new EmptyQueueException();
      }
      else
      {
        if(front == last) // If there is only one node in the queue.
        {
          item = last.data;
          front = null;
          last = null;
          numberOfEntries--;
        }
        else // If there are more than one nodes in the queue.
        {
          item = last.data;
          last.data = null; // Delete data for security.
          Node current = last;
          last = last.prev;
          current.prev = null;
          numberOfEntries--;
        } // end if
      } // end if
    } // end try
    catch(EmptyQueueException e)
    {
      System.out.println("Exception thrown: " + e);
    } // end catch

    return item;
  } // end removeback

  /** Retrieves the front entry of this dequeue.
      @return  The object at the front of the dequeue.
      @throws  EmptyQueueException if the dequeue is empty before the operation. */
  public T getFront()
  {
    T item = null;

    try
    {
      if(isEmpty())
      {
        throw new EmptyQueueException();
      }
      else
      {
        item = front.data;
      } // end if
    } // end try
    catch(EmptyQueueException e)
    {
      System.out.println("Exception thrown: " + e);
    } // end catch

    return item;
  } // end getFront

  /** Retrieves the back entry of this dequeue.
      @return  The object at the back of the dequeue.
      @throws  EmptyQueueException if the dequeue is empty before the operation. */
  public T getBack()
  {
    T item = null;

    try
    {
      if(isEmpty())
      {
        throw new EmptyQueueException();
      } // end if
      else
      {
        item = last.data;
      } // end if
    } // end try
    catch(EmptyQueueException e)
    {
      System.out.println("Exception thrown: " + e);
    } // end catch

    return item;
  } // end getBack

  /*  Detects whether this dequeue is empty.
      @return  True if the queue is empty, or false otherwise. */
  public boolean isEmpty()
  {
    return (front == null && last == null);
  } // end isEmpty

  /*  Removes all entries from this dequeue. */
  public void clear()
  {
    front = null;
    last = null;
    numberOfEntries = 0;
  } // end clear

  /** Returns all entries in an organized string.
      @return String of all entries. */
  public String toString()
  {
    String result = "[";

    // Create an array that stores all entries in order.
    @SuppressWarnings("unchecked")
    T[] temp = (T[])new Object[numberOfEntries];
    Node currentNode = last;
    for(int i = numberOfEntries - 1; i >= 0; i--)
    {
      temp[i] = currentNode.data;
      currentNode = currentNode.prev;
    } // end for

    // Puts array of entries in a string.
    for(int i = 0; i < numberOfEntries; i++)
    {
      result += temp[i] + " "; // Concat next list element.
    } // end for

    result += "]";
    return result;
  } // end toString

  /** Private inner class Node */
  private class Node
  {
    private T data;
    private Node prev; // Link to previous node.
    /** Creates a node that points to null.
        @param dataPortion  The data that will be stored in the node. */
    private Node(T dataPortion)
    {
      this(dataPortion, null);
    } // end constructor

    /** Creates a node that points to another node.
        @param dataPortion  The data that will be stored in the node.
        @param prevNode  The previous node that will be referenced. */
    private Node(T dataPortion, Node prevNode)
    {
      data = dataPortion;
      prev = prevNode;
    } // end constructor
  } // end of Node
} // end of SingleLinkDeque
