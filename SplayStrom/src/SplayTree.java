import java.util.Random;

public class SplayTree {
    public Node root;
    public Node justAddedNode;
    public SplayTree() {
        root = null;
    }

    static String createDataString(int length) {

        Random random = new Random();
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(AB.charAt(random.nextInt(AB.length())));
        }
        return stringBuilder.toString();
    }
    public void splay(Node addedNode) {
        // rozobraie pripadov pre rotacie
        while (addedNode.parent != null) { // idem od spodku hore az po root
            Node parent = addedNode.parent;
            Node grandParent = parent.parent; // nastavenie parentov pre rotacie
            if (grandParent == null) {
                //uzol nemá pra rodiča
                // Zig rotacia
                if (addedNode == parent.left) {
                    rotateRight(parent);
                } else {
                    rotateLeft(parent);
                }
            } else if (addedNode == parent.left && parent == grandParent.left) {
                // Zig-zig rotacia
                // rodic aj prarodic su z lavej vetvy
                rotateRight(grandParent);
                rotateRight(parent);
            } else if (addedNode == parent.right && parent == grandParent.right) {
                // Zig-zig rotacia
                // rodic aj prarodic su z pravej vetvy
                rotateLeft(grandParent);
                rotateLeft(parent);
            } else if (addedNode == parent.left) {
                // Zig-zag rotacia
                // z pravej a lavej vetvy pochadza prave pridany node
                rotateRight(parent);
                rotateLeft(grandParent);
            } else {
                // Zig-zag rotacia
                // inak z lavej a pravej vetvy pochadza prave pridany node
                rotateLeft(parent);
                rotateRight(grandParent);
            }
        }
        root = addedNode;
    }

    public void rotateLeft(Node node) {
        Node temp = node.right;  // Uložíme si referenciu na pravého potomka.
        node.right = temp.left;  // Syna "temp" (t.j. ľavého syna uzla "temp") priradíme ako nového pravého syna uzla "node".
        Node parentNode = node.parent;
        if (temp.left != null) {  // Ak existuje ľavý syn uzla "temp", nastavíme jeho rodiča ako uzol "node".
            temp.left.parent = node;
        }

        temp.parent = parentNode;  // Nastavíme potomkovi rodiča jeho rodiča pretoýže potomok sa bude posuvat o 1 hore nad rodiča

        if (parentNode == null) {  // Ak bol pôvodný uzol "node" koreňom stromu, nastavíme "temp" ako nový koreň.
            root = temp;
        }
        else {
            if (node == parentNode.left)  // Ak bol uzol "node" ľavým synom svojho rodiča, nastavíme "temp" ako nového ľavého syna rodiča.
                parentNode.left = temp;
            else {  // Inak uzol "node" musel byť pravým synom svojho rodiča, tak nastavíme "temp" ako nového pravého syna rodiča.
                parentNode.right = temp;
            }
        }
        temp.left = node;  // Nastavíme uzol "node" ako ľavého syna uzla "temp".
        node.parent = temp;  // Nastavíme uzol "temp" ako rodiča uzla "node".
    }

    private void rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        Node parentNode = node.parent;
        if (temp.right != null) {
            temp.right.parent = node;
        }
        temp.parent = parentNode;
        if (parentNode == null) {
            root = temp;
        }
        else{
            if (node == parentNode.left) parentNode.left = temp;
            else {
                parentNode.right = temp;
            }
        }
        temp.right = node;
        node.parent = temp;
    }

    public void insert(int key) {
        root = insertRecursive(root, key , null);
        splay(justAddedNode);
    }
    public Node insertRecursive(Node node,int key,Node tempParent){

        if (node == null) { // vlozenie 1. prvku
            String data = createDataString(10);
            Node temp = new Node(key,data);
            temp.parent = tempParent;
            justAddedNode = temp;
            return temp;
        }

        if (key < node.key) {
            tempParent = node;
            node.left = insertRecursive(node.left, key,tempParent);
        }
        else if (key > node.key) {
            tempParent = node;
            node.right = insertRecursive(node.right, key,tempParent);
        }
        return node;
    }

    public Node searchNode(int key) {
        Node tempRoot = root;

        while (tempRoot != null) {
            if (key < tempRoot.key ) {
                if(tempRoot.left != null){tempRoot = tempRoot.left;}
                else return null ;
            } else if (key > tempRoot.key ) {
                if (tempRoot.right != null){
                    tempRoot = tempRoot.right;
                }
                else return null ;
            } else {
                // Hľadaný prvok bol nájdený
                splay(tempRoot); // zavolam rotovanie pretože splay funguje na zaklade hladania
                return tempRoot;
            }
        }
        // Hľadaný prvok sa v strome nenachádza
        return null;
    }

    public void deleteNode(int key) {
        Node nodeToDelete = searchNode(key);
        if (nodeToDelete == null) {
            return;
        }

        if (nodeToDelete.left == null) {
            // Ak uzol nemá ľavého potomka, vráti sa jeho pravý potomok
            nodeToDelete.right.parent = null;
            root = nodeToDelete.right;
             // vratim potomka ako root
        }
        else if (nodeToDelete.right == null) {
            // Ak uzol nemá pravého potomka, vráti sa jeho ľavý potomok
            nodeToDelete.left.parent = null;
            root = nodeToDelete.left;
        }
        else{
            Node temp;
            // ma 2 potomkov
            temp = nodeToDelete.left;
            while (temp.right != null) { // idem hladat najmensi prvok ( na lavo ) z pravej vetvy
                temp = temp.right;
            }

            temp.right = nodeToDelete.right; // lavy pravy potomok (uzla čo sa ide mazat) posuniem vyššie
            nodeToDelete.right.parent = temp; // prenastavenie rodiča
            nodeToDelete.left.parent = null; // vymazanie už zlej referencie na rodiča
            root = nodeToDelete.left; // nastavenie roota
        }

        //System.out.printf("Skoncil som vymazanie\n");
    }


}
