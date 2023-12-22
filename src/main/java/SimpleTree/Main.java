package SimpleTree;

public class Main {
    public static void main(String[] args) {
        var rootNode = new Node(5);
        var tree = new SimpleTree(rootNode);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(4);
        tree.add(2);
        System.out.println(tree);
        System.out.println(tree.iterateAll(rootNode));
    }
}
