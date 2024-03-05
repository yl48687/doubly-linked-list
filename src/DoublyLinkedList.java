/**
 * Creates a {@code DoublyLinkedList} using the parameter {@code T} and fully extends the class
 * {@code Comparable}.
 */
public class DoublyLinkedList<T extends Comparable<T>> {
    private NodeType<T> head;

    /**
     * Initializes the list.
     */
    public DoublyLinkedList() {
        head = null;
    } // DoublyLinkedList

    /**
     * Inserts an {@code item} from the list. When the {@code item} is inserted, the list continues
     * to maintain sorted order.
     *
     * @param item The item being deleted.
     */
    public void insertItem(T item) {
        NodeType<T> newNode = new NodeType<>();
        newNode.info = item;
        if (head == null) {
            head = newNode;
        } else if (item.compareTo(head.info) < 0) {
            newNode.next = head;
            head.back = newNode;
            head = newNode;
        } else {
            NodeType<T> current = head;
            while (current.next != null && item.compareTo(current.next.info) > 0) {
                current = current.next;
            } // while
            newNode.next = current.next;
            if (current.next != null) {
                current.next.back = newNode;
            } // if
            newNode.back = current;
            current.next = newNode;
        } // if
    } // insertItem

    /**
     * Deletes an {@code item} from the list. If the {@code item} does not exist in the list, the
     * program will print an error message.
     *
     * @param item The item being deleted.
     */
    public void deleteItem(T item) {
        if (head == null) {
            return;
        } // if
        if (item.compareTo(head.info) == 0) {
            head = head.next;
            if (head != null) {
                head.back = null;
            } // if
            return;
        } // if
        NodeType<T> current = head;
        while (current != null && item.compareTo(current.info) != 0) {
            current = current.next;
        } // while
        if (current == null) {
            return;
        } // if
        if (current.back != null) {
            current.back.next = current.next;
        } // if
        if (current.next != null) {
            current.next.back = current.back;
        } // if
    } // deleteItem

    /**
     * Finds the length of the list.
     *
     * @return length The length of the list.
     */
    public int length() {
        int length = 0;
        NodeType<T> current = head;
        while (current != null) {
            length++;
            current = current.next;
        } // while
        return length;
    } // length

    /**
     * Prints the items in the list to standard output.
     */
    public void print() {
        NodeType<T> current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        } // while
        System.out.println();
    } // print

    /**
     * Prints the items in the list in its reverse order to standard output.
     */
    public void printReverse() {
        NodeType<T> current = head;
        if (current == null) {
            return;
        } // while
        while (current.next != null) {
            current = current.next;
        } // while
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.back;
        } // while
        System.out.println();
    } // printReverse

    /**
     * Takes an input from the user for the lower and upper bound (both inclusive) for a range of
     * values that will be deleted from the list.
     *
     * @param lower The lowerbound of the range for subsection
     * @param upper The upperbound of the range for subsection
     */
    public void deleteSubsection(T lower, T upper) {
        if (head == null) {
            return;
        } // if
        NodeType<T> current = head;
        boolean isDeleted = false;
        while (current != null) {
            if (current.info.compareTo(lower) >= 0 && current.info.compareTo(upper) <= 0) {
                if (current.back != null) {
                    current.back.next = current.next;
                } else {
                    head = current.next;
                } // if
                if (current.next != null) {
                    current.next.back = current.back;
                } // if
                isDeleted = true;
            } // if
            current = current.next;
        } // while
    } // deleteSubsection

    /**
     * Reverses the list without creating a new list.
     */
    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        } // if
        NodeType<T> current = head;
        NodeType<T> temp = null;
        while (current != null) {
            NodeType<T> nextNode = current.next;
            current.next = temp;
            current.back = nextNode;
            temp = current;
            current = nextNode;
        } // while
        head = temp;
    } // reverseList

    /**
     * Swaps every other node in the list.
     */
    public void swapAlternate() {
        if (head == null || head.next == null) {
            return;
        } // if
        NodeType<T> current = head;
        NodeType<T> previous = null;
        NodeType<T> next;
        while (current != null && current.next != null) {
            next = current.next;
            current.next = next.next;
            next.next = current;
            if (previous != null) {
                previous.next = next;
            } else {
                head = next;
            } // if
            previous = current;
            current = current.next;
        } // while
    } // swapAlternate

    /**
     * Checks if the list contains the {@code item}.
     *
     * @param item The item being checked for.
     * @return {@code false} if the list does not contain the {@code item} else {@code true}.
     */
    public boolean contains(T item) {
        NodeType<T> current = head;
        while (current != null) {
            if (item.compareTo(current.info) == 0) {
                return true;
            } // if
            current = current.next;
        } // while
        return false;
    } // contains
} // DoublyLinkedList
