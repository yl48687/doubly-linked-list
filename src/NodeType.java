/**
 * Creates a node in a list and fully extends {@code Comparable}.
 */
public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> next;
    public NodeType<T> back;
} // NodeType
