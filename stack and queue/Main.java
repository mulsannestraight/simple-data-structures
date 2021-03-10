public class Main {
  public static void main(String[] args) {
    // Stack
    Stack st = new Stack();
    st.push(90);
    st.push(38);
    st.push(10);
    st.push(42);
    st.push(91);
    st.push(93);
    System.out.println(st.toString());
    System.out.println("Peak: " + st.peak());
    st.pop();
    st.pop();
    System.out.println(st.toString());
    System.out.println("Peak: " + st.peak());

    // Queue
    Queue q = new Queue();
    q.enqueue(132);
    q.enqueue(39);
    q.enqueue(29);
    q.enqueue(21);
    System.out.println(q.toString());
    System.out.println("Peak: " + q.peak());
    q.dequeue();
    q.dequeue();
    System.out.println(q.toString());
    System.out.println("Peak: " + q.peak());
    q.dequeue();
    q.dequeue();
    System.out.println(q.toString());
    System.out.println("Peak: " + q.peak());
  }
}
