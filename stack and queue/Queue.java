public class Queue {
  LinkedList list;

  public Queue() {
    list = new LinkedList();
  }

  public String toString() {
    String s = "Queue: (First): ";
    Node temp = list.getRoot();

    while (temp != null) {
      s += temp.getData() + " // ";
      temp = temp.getNext();
    }

    return s + " (Last)";
  }
  public int enqueue(int data) {
    list.insertAtEnd(data);
    return data;
  }
  public Integer peak() {
    if (list.getRoot() == null)
      return null;

    return new Integer(list.getRoot().getData());
  }
  public boolean dequeue() {
    if (list.getRoot() == null)
      return false;

    list.deleteAtFront();
    return true;
  }
}
