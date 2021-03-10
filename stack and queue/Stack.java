public class Stack {
  LinkedList list;

  public Stack() {
    list = new LinkedList();
  }

  public String toString() {
    String s = "Stack: (Top): ";
    Node temp = list.getRoot();

    while (temp != null) {
      s += temp.getData() + " // ";
      temp = temp.getNext();
    }

    return s + " (Bottom)";
  }
  public int push(int data) {
    list.insertAtFront(data);
    return data;
  }
  public Integer peak() {
    if (list.getRoot() == null)
      return null;

    return new Integer(list.getRoot().getData());
  }
  public boolean pop() {
    if (list.getRoot() == null)
      return false;

    list.deleteAtFront();
    return true;
  }
}
