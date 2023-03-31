class Node {
    int data; // hodnota v uzly

    String stringData;
    Node left; // čast uzla pre menšie hodnoty
    Node right; // prava čast uzla pre vačsie hodnoty
    int height;

    int balanceFactor;

    public Node(int data,String stringData) {
        this.data = data;
        this.stringData = stringData;
        left = null;
        right = null;
    }

}