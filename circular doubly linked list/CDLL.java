public class CDLL {
  private Node head;
  private int size = 0;
  
  public CDLL(Node head) {
    this.head = head;
    head.setPrev(head);
    head.setNext(head);
    size++;
  }
  public CDLL() {
    this.head = null;
  }
  private void setHead(Node head) {
    this.head = head;
  }
  public Node getHead() {
    return head;
  }
  public String toString() {
    String s = "Next pointer: ";
    String t = "Prev pointer: ";
    Node temp1 = head;
    Node temp2 = null;
    if (head != null) {
      temp2 = head.getPrev();
    }
    for (int i = 0; i < size; i++) {
      s += temp1.getData() + "-->";
      temp1 = temp1.getNext();
      t += temp2.getData() + "-->";
      temp2 = temp2.getPrev();
    }
    if (size != 0) {
      s += temp1.getData();
      t += temp2.getData();
    } else {
      s += null;
      t += null;
    }
    return s + "\n" + t;
  }
  public int getSize() {
    return size;
  }
  public void insertAt(int data, int index) {
    Node newNode = new Node(data);
    if (index >= 0 && index <= size) {
      // use for inserting first element as head
      if (size == 0) {
        this.setHead(newNode);
        head.setPrev(head);
        head.setNext(head);
        size++;
      } else {
        if (index == 0) {
          newNode.setNext(head);
          newNode.setPrev(head.getPrev());
          head.getPrev().setNext(newNode);
          head.setPrev(newNode);
          this.setHead(newNode);
          size++;
        } else if (index != size) {
          Node current = head;
          for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
          }
          newNode.setNext(current.getNext());
          current.getNext().setPrev(newNode);
          newNode.setPrev(current);
          current.setNext(newNode);
          size++;
        } else {
          newNode.setNext(head);
          newNode.setPrev(head.getPrev());
          head.getPrev().setNext(newNode);
          head.setPrev(newNode);
          size++;
        }
      }
    } else {
      System.out.println("Incorrect index input");
    }
  }
  public void deleteAt(int index) {
    if (index >= 0 && index < size) {
      if (index == 0) {
        Node temp = head.getNext();
        temp.setPrev(head.getPrev());
        head.getPrev().setNext(temp);
        this.setHead(temp);
        size--;
      } else if (index == size - 1) {
        Node temp = head.getPrev();
        temp.getPrev().setNext(head);
        head.setPrev(temp.getPrev());
        size--;
      } else {
        Node current = head;
        for (int i = 0; i < index; i++) {
          current = current.getNext();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
      }
    } else {
      System.out.println("Incorrect index input/Empty linked list");
    }
  }
  public void insertionTimeFor(int numOfItems) {
    long startTimer;
    long endTimer;
    startTimer = System.nanoTime();
    //Note to professor: modify here to further randomize insertion pattern
    for (int i = 0; i < numOfItems; i++) {
      this.insertAt(i, 0);
    }
    endTimer = System.nanoTime();
    System.out.println("Total time for inserting " + numOfItems + " items is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
  }
  public void deletionTimeFor(int numOfItems) {
    long startTimer;
    long endTimer;
    //Note to professor: modify here to further randomize insertion pattern
    for(int i = 0; i < numOfItems; i++) {
      this.insertAt(i, i);
    }
    startTimer = System.nanoTime();
    //Note to professor: modify here to further randomize deletion pattern
    for (int i = numOfItems - 1; i >= 0; i--) {
      this.deleteAt(i);
    }
    endTimer = System.nanoTime();
    System.out.println("Total time for deleting " + numOfItems + " items is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
  } 
  public void insertAtWithTimer(int data, int index) {
    long startTimer;
    long endTimer;
    startTimer = System.nanoTime();
    this.insertAt(data, index);
    endTimer = System.nanoTime();
    System.out.println("Total insertion time is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
  }
  public void deleteAtWithTimer(int index) {
    long startTimer;
    long endTimer;
    startTimer = System.nanoTime();
    this.deleteAt(index);
    endTimer = System.nanoTime();
    System.out.println("Total deletion time is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
  }
}
