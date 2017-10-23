/**
   A doubly linked data dequeue that implements DequeInterface.
   @author Minwoo Soh
*/
public final class DoublyLinkedDeque<T> implements DequeInterface<T>
{
  private Node front;
  private Node last;
  private int numberOfEntries;

  /** Creates an empty SingleLinkedDeque object with no nodes. */
  public DoublyLinkedDeque()
  {
    front = null;
    last = null;
  } // end default constructor

  /** Adds a new entry to the front of this dequeue.
      @param newEntry  An object to be added. */
  public void addToFront(T newEntry)
  {
    if(front == null)
    {
      Node newNode = new Node(newEntry);
      last = newNode;
      front = newNode;
      numberOfEntries++;
    }
    else
    {
      Node newNode = new Node(newEntry);
      newNode.next = front;
      front.prev = newNode;
      front = newNode;
      numberOfEntries++;
    } // end if
  } // end addToFront

  /** Adds a new entry to the back of this dequeue.
      @param newEntry  An object to be added. */
  public void addToBack(T newEntry)
  {
    if(last == null)
    {
      Node newNode = new Node(newEntry);
      last = newNode;
      front = newNode;
      numberOfEntries++;
    }
    else
    {
      Node newNode = new Node(newEntry);
      newNode.prev = last;
      last.next = newNode;
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
          front.next.prev = null;
          front = front.next;
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
          last.prev.next = null;
          last = last.prev;
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
      } // end if
      else
      {
        item = front.data;
      }
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
      }
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
    private Node prev; // Link to prev node.
    private Node next; // Link to next node.
    /** Creates a node that points to null.
        @param dataPortion  The data that will be stored in the node. */
    private Node(T dataPortion)
    {
      this(dataPortion, null, null);
    } // end constructor

    /** Creates a node that points to another node.
        @param dataPortion  The data that will be stored in the node.
        @param prevNode  The prev node that will be referenced. */
    private Node(T dataPortion, Node prevNode, Node nextNode)
    {
      data = dataPortion;
      prev = prevNode;
      next = nextNode;
    } // end constructor
  } // end of Node
} // end of DoublyLinkDeque
