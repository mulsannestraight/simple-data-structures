public class LinkedList {
  Node root;
  Node tail;

  public LinkedList() {
    this.root = null;
    // newly added
    this.tail = null;
  }
  public LinkedList(int data) {
    this.root = new Node(data);
    this.tail = new Node(data);
  }
  private void setRoot(Node root) {
    this.root = root;
  }
  public Node getRoot() {
    return this.root;
  }
  private void setTail(Node tail) {
    this.tail = tail;
  }
  public Node getTail() {
    return this.tail;
  }

  public void printList() {
    printList(root);
  }

  // recursive call for printing nodes in linked list
  private void printList(Node node) {
    if (node == null) {
      System.out.println(node);
      return;
    }
    System.out.print(node.getData() + " --> ");
    printList(node.getNext());
  }
  public void insert(int data) {
    this.insert(root, data);
  }

  // recursive method for insert at end
  private void insert(Node node, int data) {
    if (node == null) {
      this.setRoot(new Node(data));
      return;
    }
    if (node.getNext() == null) {
      node.setNext(new Node(data));
      return;
    }
    insert(node.getNext(), data);
  }

  // no need recursive call because it's always an O(1) operation
  public void insertAtFront(int data) {
    Node newNode = new Node(data);

    if (root == null) {
      root = newNode;
      tail = newNode;
      return;
    }

    newNode.setNext(root);
    this.setRoot(newNode);
  }

  // no need recursive call because it's always an O(1) operation
  public void deleteAtFront() {
    if (root == null)
      return;

    Node temp = root.getNext();
    root.setNext(null);
    this.setRoot(temp);
    if (temp == null)
      tail = null;
  }

  // no need recursive call because it's always an O(1) operation
  public void insertAtEnd(int data) {
    Node newNode = new Node(data);

    if (tail == null) {
      tail = newNode;
      root = newNode;
      return;
    }

    tail.setNext(newNode);
    this.setTail(newNode);
  }
}
