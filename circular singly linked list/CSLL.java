public class CSLL {
  private Node head;
  private int size = 0;

  public CSLL(Node head) {
    this.head = head;
    head.setNext(head);
    size++;
  }
  public CSLL() {
    this.head = null;
  }
  // for the first head in list, do not use this, use insertAt()
  private void setHead(Node head) {
    this.head = head;
  }
  public Node getHead() {
    return this.head;
  }
  public String toString() {
    String s = "";
    Node temp = head;
    for (int i = 0; i < size; i++) {
      s += temp.getData() + "-->";
      temp = temp.getNext();
    }
    // add this clause to show last item pointing back to head
    if (size != 0) {
      s += head.getData();
    } else {
      s += "null";
    }
    return s;
  }
  public int getSize() {
    return size;
  }
  public void insertAt(int data, int index) {
    Node newNode = new Node(data);
    if (index >= 0 && index <= size) {
      //by default, if size is 0 then first insert will be the root
      if (size == 0) {
        this.setHead(newNode);
        head.setNext(head);
        size++;
      //if size is not zero, study index by the case
      } else {
        if (index == 0) {
          Node current = head;
          newNode.setNext(head);
          for (int i = 0; i < size - 1; i++) {
            current = current.getNext();
          }
          current.setNext(newNode);
          this.setHead(newNode);
          size++;
        } else {
          Node current = head;
          for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
          }
          newNode.setNext(current.getNext());
          current.setNext(newNode);
          size++;
        }
      }
    } else {
      System.out.println("Incorrect index input");
    }
  }
  public void deleteAt(int index) {
    if (index >= 0 && index < size) {
      Node current = head;
      if (index == 0) {
        Node temp = head;
        this.setHead(temp.getNext());
        for (int i = 0; i < size - 1; i++) {
          current = current.getNext();
        }
        current.setNext(head);
        temp = null;
      } else {
        for (int i = 0; i < index - 1; i++) {
          current = current.getNext();
        }
        Node temp = current.getNext();
        current.setNext(temp.getNext());
        temp = null;
      }
      size--;
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
}
