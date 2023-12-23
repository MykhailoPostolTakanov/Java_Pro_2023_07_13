package SimpleTree;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class SimpleTree {
    private Node root;

    public SimpleTree(Node root) {
        this.root = root;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public List<Integer> iterateAll(Node node) {
        var nodes = new LinkedList<Integer>();
        if (node != null) {
            nodes.addAll(iterateAll(node.getNodeLeft()));
            nodes.add(node.getValue());
            nodes.addAll(iterateAll(node.getNodeRight()));
        }
        return nodes;
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.getValue()) {
            current.setNodeLeft(addRecursive(current.getNodeLeft(), value));
        } else if (value > current.getValue()) {
            current.setNodeRight(addRecursive(current.getNodeRight(), value));
        } else {
            return current;
        }
        return current;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.getValue()) {
            return true;
        }
        if (value < current.getValue())
            return containsNodeRecursive(current.getNodeLeft(), value);
        else
            return containsNodeRecursive(current.getNodeRight(), value);
    }
}
