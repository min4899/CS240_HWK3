public class Demo
{
  public static void main(String[] args)
  {
    System.out.println("TESTING DOUBLY LINKED DEQUE");
    DoublyLinkedDeque queue = new DoublyLinkedDeque();
    System.out.println("Created new queue DoublyLinkedDeque");

    System.out.println("Adding items in front");
    queue.addToFront('c');
    queue.addToFront('b');
    queue.addToFront('a');
    System.out.println("Added 3 items in front");
    System.out.println("Items in list: " + queue.toString());
    System.out.println("First item in the queue: " + queue.getFront());

    System.out.println("Adding 3 items in the back");
    queue.addToBack('x');
    queue.addToBack('y');
    queue.addToBack('z');
    System.out.println("Added 3 items in back");
    System.out.println("Items in list: " + queue.toString());
    System.out.println("Last item in the queue: " + queue.getBack());

    System.out.println("Removing first in queue: " + queue.removeFront());
    System.out.println("New first item in list is: " + queue.getFront());
    System.out.println("Removing first in queue: " + queue.removeFront());
    System.out.println("New first item in list is: " + queue.getFront());
    System.out.println("Items in list: " + queue.toString());

    System.out.println("Removing back in queue: " + queue.removeBack());
    System.out.println("New back item in list is: " + queue.getBack());
    System.out.println("Removing back in queue: " + queue.removeBack());
    System.out.println("New back item in list is: " + queue.getBack());
    System.out.println("Items in list: " + queue.toString());

    System.out.println("Clearing queue");
    queue.clear();
    queue.removeFront();

    queue.addToFront("hello");
    queue.addToFront("everyone");
    queue.addToFront("lol");
    queue.addToBack("added");
    queue.addToBack("to");
    queue.addToBack("back");
    System.out.println("Items in list: " + queue.toString());
  }
}
