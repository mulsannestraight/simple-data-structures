public class Node {
  private int data;
  private Node next;
  private Node prev;
  
  public Node(int data, Node next, Node prev) {
    this.data = data;
    this.next = next;
    this.prev = null;
  }
  public Node(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
  public Node getNext() {
    return this.next;
  }
  public void setNext(Node next) {
    this.next = next;
  }
  public Node getPrev() {
    return this.prev;
  }
  public void setPrev() {
    this.prev = prev;
  }
  public int getData() {
    return this.data;
  }
}
