public class Main {
  public static void main(String[] args) {
    SplayTree st = new SplayTree(1);
    st.splayInsert(4);
    st.splayInsert(5);
    st.splayInsert(0);
    st.splayInsert(3);
    System.out.println(st.getRoot().getRight().getLeft().getData());
  }
}
