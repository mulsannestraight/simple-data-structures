public class SplayTree {
  Node root;

  public SplayTree() {
    root = null;
  }
  public SplayTree(int data) {
    this.root = new Node(data);
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
  public void rightRotate(Node x) {
    if (x == root) {
      Node child = x.getLeft();
      Node rightOfChild = child.getRight();
      x.setLeft(rightOfChild);
      child.setRight(x);
      this.setRoot(child);
    } else {
      Node parent = null;
      Node temp = root;

      while (temp != x) {
        parent = temp;
        if (x.getData() >= temp.getData()) {
          temp = temp.getRight();
        } else {
          temp = temp.getLeft();
        }
      }

      Node child = x.getLeft();
      Node rightOfChild = child.getRight();
      x.setLeft(rightOfChild);
      child.setRight(x);

      if (parent.getRight() == temp) {
        parent.setRight(child);
      } else {
        parent.setLeft(child);
      }
    }
  }
  public void leftRotate(Node x) {
    if (x == root) {
      Node child = x.getRight();
      Node leftOfChild = child.getLeft();
      x.setRight(leftOfChild);
      child.setLeft(x);
      this.setRoot(child);
    } else {
      Node parent = null;
      Node temp = root;

      while(temp != x) {
        parent = temp;
        if (x.getData() >= temp.getData()) {
          temp = temp.getRight();
        } else {
          temp = temp.getLeft();
        }
      }

      Node child = x.getRight();
      Node leftOfChild = child.getLeft();
      x.setRight(leftOfChild);
      child.setLeft(x);

      if (parent.getRight() == temp) {
        parent.setRight(child);
      } else {
        parent.setLeft(child);
      }
    }
  }
  public void splayInsert(int data) {
    Node newNode = new Node(data);

    if (root == null) {
      this.setRoot(newNode);
    } else {
      Node grandParent = null;
      Node parent = null;
      Node temp = root;

      while(temp != null) {
        grandParent = parent;
        parent = temp;

        if (data >= temp.getData()) {
          temp = temp.getRight();
        } else {
          temp = temp.getLeft();
        }
      }

      if (data >= parent.getData()) {
        parent.setRight(newNode);
      } else {
        parent.setLeft(newNode);
      }

      while(newNode != root) {
        newNode = splay(newNode, parent, grandParent);
        grandParent = null;
        parent = null;
        temp = root;

        while(temp != newNode) {
          grandParent = parent;
          parent = temp;
          if (newNode.getData() >= temp.getData()) {
            temp = temp.getRight();
          } else {
            temp = temp.getLeft();
          }
        }
      }
    }
  }
  public Node splay(Node splayNode, Node parent, Node grandParent) {
    if (grandParent == null) {
      if (parent.getLeft() == splayNode) {
        this.rightRotate(parent);
      } else {
        this.leftRotate(parent);
      }
      return splayNode;
    } else if (grandParent.getLeft() == parent && parent.getLeft() ==
        splayNode) {
      this.rightRotate(grandParent);
      this.rightRotate(parent);
      return splayNode;
    } else if (grandParent.getRight() == parent && parent.getRight() ==
        splayNode) {
      this.leftRotate(grandParent);
      this.leftRotate(parent);
      return splayNode;
    } else if (grandParent.getLeft() == parent && parent.getRight() ==
        splayNode) {
      this.leftRotate(parent);
      this.rightRotate(grandParent);
      return splayNode;
    } else if (grandParent.getRight() == parent && parent.getLeft() ==
        splayNode) {
      this.rightRotate(parent);
      this.leftRotate(grandParent);
      return splayNode;
    } else {
      System.out.println("THIS WILL NEVER RUN");
      return splayNode;
    }
  }
}
