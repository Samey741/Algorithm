class Node {
    int key;
    String data;
    Node left, right, parent;

    public Node(int key,String data) {
        this.key = key;
        this.data = data;
        left = right = parent = null;
    }
}