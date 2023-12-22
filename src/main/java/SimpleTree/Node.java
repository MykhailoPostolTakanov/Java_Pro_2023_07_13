package SimpleTree;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Node {
    private int value;
    private Node nodeLeft;
    private Node nodeRight;

    public Node(int value) {
        this.value = value;
        this.nodeLeft = null;
        this.nodeRight = null;
    }
}
