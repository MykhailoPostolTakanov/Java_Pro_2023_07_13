package SimpleTree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SimpleTreeTest {
    private static final Node rootNode = new Node(5);
    private static SimpleTree tree;

    @BeforeAll
    static void init() {
        tree = new SimpleTree(rootNode);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(4);
        tree.add(2);
    }

    @Test
    void add() {
        tree.add(3);
        tree.add(9);
        assertThat(tree.containsNode(3), equalTo(true));
        assertThat(tree.containsNode(9), equalTo(true));
    }

    @Test
    void containsNode() {
        assertThat(tree.containsNode(2), equalTo(true));
        assertThat(tree.containsNode(8), equalTo(false));
    }

    @Test
    void iterateAll() {
        assertThat(tree.iterateAll(rootNode), equalTo(List.of(1, 2, 4, 5, 6, 7)));
    }
}