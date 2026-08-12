// package Serching_and_sorting;
public class LinkedListImplentationInStack {
    public static class Node { // user defined data type
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static class LLStack { // user defined data structure
        private Node head = null;
        private int size = 0;

        void push(int x) {
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
            size++;
        }

        int pop() {
            if (head == null) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int x = head.val;
            head = head.next;
            size--;
            return x;
        }

        int peek() {
            if (head == null) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return head.val;
        }

        // recursive display (bottom to top)
        private void displayRecur(Node h) {
            if (h == null) return;
            displayRecur(h.next);
            System.out.print(h.val + " ");
        }

        void display() { // prints from bottom to top
            displayRecur(head);
            System.out.println();
        }

        // iterative display (top to bottom)
        void displayRev() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        LLStack st = new LLStack();

        st.push(4);
        st.push(5);
        st.push(7);
        st.push(8);
        st.push(9);

        System.out.print("Bottom→Top: ");
        st.display();  // 4 5 7 8 9
        System.out.print("Top→Bottom: ");
        st.displayRev(); // 9 8 7 5 4
        System.out.println("Size = " + st.size());

        st.pop();   // removes 9
        st.displayRev(); // 8 7 5 4

        st.push(7);
        st.push(47);
        st.displayRev(); // 47 7 8 7 5 4

        System.out.println("Top = " + st.peek()); // 47
    }
}
