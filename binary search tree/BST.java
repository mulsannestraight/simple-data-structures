public class BST {
  Node root;

  public BST() {
    root = null;
  }
  public BST(Node root) {
    this.root = root;
  }
  public BST(int rootData) {
    this.root = new Node(rootData);
  }
  public Node getRoot() {
    return root;
  }
  public void setRoot(Node root) {
    this.root = root;
  }
  public void inOrder() {
    inOrder(root);
  }
  private void inOrder(Node node) {
    if (node == null) {
      return;
    }
    inOrder(node.getLeft());
    System.out.print(node.getData() + " ");
    inOrder(node.getRight());
  }
  public void insert(int data) {
    Node newNode = new Node(data);
    if (root == null) {
      root = newNode;
    } else {
      Node temp = root;
      Node parent = null;

      while(temp != null) {
        parent = temp;
        if (newNode.getData() < temp.getData()) {
          temp = temp.getLeft();
        } else {
          temp = temp.getRight();
        }
      }

      if (newNode.getData() < parent.getData()) {
        parent.setLeft(newNode);
      } else {
        parent.setRight(newNode);
      }
    }
  }
  public Node insertRecursive(int data) {
    return insertRecursive(this.root, data);
  }
  private Node insertRecursive(Node root, int data) {
    if (root == null) {
      root = new Node(data);
      return root;
    }

    if (data > root.getData()) {
      root.setRight(insertRecursive(root.getRight(), data));
    } else {
      root.setLeft(insertRecursive(root.getLeft(), data));
    }
    return root;
  }

  public String toString() {
    String s = "";
    while (root != null) {
      s += root.getData();
      root = root.getRight();
    }
    return s;
  }

  public Integer remove(int data) {
    if (root == null) {
      return null;
    }

    Node temp = root;
    Node parent = null;

    while(temp != null && temp.getData() != data) {
      parent = temp;
      if (data >= temp.getData()) {
        temp = temp.getRight();
      } else {
        temp = temp.getLeft();
      }
    }

    if (temp == null) {
      return null;
    }

    Integer rc0 = removeCaseZero(temp, parent);
    if (rc0 == null) {
      Integer rc1 = removeCaseOne(temp, parent);
      if (rc1 == null) {
        Node parentX = temp;
        Node x = temp.getLeft();

        while(x.getRight() != null) {
          parentX = x;
          x = x.getRight();
        }

        int t = temp.getData();
        temp.setData(x.getData());
        x.setData(t);

        Integer r0 = removeCaseZero(x, parentX);
        if (r0 == null) {
          return removeCaseOne(x, parentX);
        } else {
          return r0;
        }
      } else {
        return rc1;
      }
    } else {
      return rc0;
    }
  }
  public Integer removeCaseZero(Node temp, Node parent) {
    if (temp.getRight() == null && temp.getLeft() == null) {
      if (parent.getLeft() == temp) {
        parent.setLeft(null);
      } else {
        parent.setRight(null);
      }

      return new Integer(temp.getData());
    }
    return null;
  }
  public Integer removeCaseOne(Node temp, Node parent) {
    if (temp.getLeft() == null && temp.getRight() != null ||
        temp.getRight() == null && temp.getLeft() != null) {
      Node child = (temp.getLeft() != null) ? temp.getLeft() : temp.getRight();

      if (parent.getLeft() == temp) {
        parent.setLeft(child);
      } else {
        parent.setRight(child);
      }

      if (temp.getLeft() != null) {
        temp.setLeft(null);
      } else {
        temp.setRight(null);
      }

      return new Integer(temp.getData());
    }

    return null;
  }
  public void removeRecursive(int data) {
    root = removeRecursive(root, data);
  }
  public Node removeRecursive(Node node, int data) {
    if (node == null) {
      return node;
    }

    if (node.getData() > data) {
      node.setLeft(removeRecursive(node.getLeft(), data));
    } else if (node.getData() < data) {
      node.setRight(removeRecursive(node.getRight(), data));
    } else {
      if (node.getLeft() == null) {
        return node.getRight();
      } else if (node.getRight() == null) {
        return node.getLeft();
      }

      Node minNode = node.getRight();
      int minValue = minNode.getData();
      while (minNode.getLeft() != null) {
        minValue = minNode.getLeft().getData();
        minNode = minNode.getLeft();
      }

      node.setData(minValue);
      node.setRight(removeRecursive(node.getRight(), node.getData()));
    }
    return node;
  }

  // METHODS with timer start here
  // methods with timer will contain the words "withTimer" on
  // top of the regular method names
  public void insertWithTimer(int data) {
    long startTimer, endTimer;
    startTimer = System.nanoTime();
    insert(data);
    endTimer = System.nanoTime();
    System.out.println("Total iterative insertion time is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
  }
  public Node insertRecursiveWithTimer(int data) {
    long startTimer, endTimer;
    startTimer = System.nanoTime();
    Node nd = insertRecursive(data);
    endTimer = System.nanoTime();
    System.out.println("Total recursive insertion time is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
    return nd;
  }
  public Integer removeWithTimer(int data) {
    long startTimer, endTimer;
    startTimer = System.nanoTime();
    Integer rm = remove(data);
    endTimer = System.nanoTime();
    System.out.println("Total iterative removing time is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
    return rm;
  }
  public void removeRecursiveWithTimer(int data) {
    long startTimer, endTimer;
    startTimer = System.nanoTime();
    removeRecursive(data);
    endTimer = System.nanoTime();
    System.out.println("Total recursive removing time is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
  }

  // timing methods for 100, 1000, 10000, ... items
  // these methods have the word "TimerFor" on top of regular method names
  public void insertTimerFor(int numOfItems) {
    long startTimer, endTimer;
    startTimer = System.nanoTime();

    // modify insertion pattern here
    for (int i = 0; i < numOfItems; i++) {
      this.insert(i % 100);
    }
    endTimer = System.nanoTime();
    System.out.println("Total iterative insertion time for " + numOfItems +
    " items is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
  }
  public void insertRecursiveTimerFor(int numOfItems) {
    long startTimer, endTimer;
    startTimer = System.nanoTime();

    // modify insertion pattern here
    for (int i = 0; i < numOfItems; i++) {
      this.insertRecursive(i % 100);
    }
    endTimer = System.nanoTime();
    System.out.println("Total recursive insertion time for " + numOfItems +
    " items is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
  }
  public void removeTimerFor(int numOfItems) {
    long startTimer, endTimer;
    startTimer = System.nanoTime();

    // modify insertion pattern here
    for (int i = 0; i < numOfItems; i++) {
      this.remove(i % 100);
    }
    endTimer = System.nanoTime();
    System.out.println("Total iterative removing time for " + numOfItems +
    " items is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
  }
  public void removeRecursiveTimerFor(int numOfItems) {
    long startTimer, endTimer;
    startTimer = System.nanoTime();
    for (int i = 0; i < numOfItems; i++) {
      this.removeRecursive(i % 100);
    }
    endTimer = System.nanoTime();
    System.out.println("Total recursive removing time for " + numOfItems +
    " items is: "
    + (endTimer - startTimer)/1000000000.0 + " seconds.");
  }
}
