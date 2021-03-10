public class Main {
  public static void main(String[] args) {
    BST bst = new BST(-80);
    
    //insert for 100, 1000, 10000, 100000 items
    bst.insertTimerFor(100);
    bst.insertTimerFor(1000);
    bst.insertRecursiveTimerFor(10000);
    bst.insertRecursiveTimerFor(100000);
    
    //remove for 100, 1000, 10000, 100000 items
    bst.removeTimerFor(100);
    bst.removeTimerFor(1000);
    bst.removeRecursiveTimerFor(10000);
    bst.removeRecursiveTimerFor(100000);
    
    //insertion for iterative and recursive scenario
    bst.insertWithTimer(14);
    bst.insertRecursiveWithTimer(68);
    
    //remove for iterative and recursive scenario
    bst.removeWithTimer(64);
    bst.removeRecursiveWithTimer(14);
    
    bst.inOrder();
  }
}
