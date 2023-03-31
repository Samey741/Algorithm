import java.util.Random;

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    public Node balanceTree(Node unbalancedNode, Node parentRoot) {
        if (unbalancedNode.balanceFactor == -2) { // ak je BF -2 teda na pravo je viac
            if (unbalancedNode.right != null) { // tak pojdem doprava
                if (unbalancedNode.right.balanceFactor == 1) { // kukam ake poradie BF a volam rotaciu
                    if (parentRoot != null) {
                        if (unbalancedNode.data >= parentRoot.data) {
                            parentRoot.right = rlDoubleRotation(unbalancedNode); // zistim kam ho napojim a rotujem
                        } else {
                            parentRoot.left = rlDoubleRotation(unbalancedNode);
                        }
                    } else {
                        parentRoot = rlDoubleRotation(unbalancedNode);
                    }
                } else {
                    if (parentRoot != null) {
                        if (unbalancedNode.data >= parentRoot.data) {
                            parentRoot.right = rhRotation(unbalancedNode);
                        } else {
                            parentRoot.left = rhRotation(unbalancedNode);
                        }
                    } else {
                        parentRoot = rhRotation(unbalancedNode);
                    }
                }
            }
        } else if (unbalancedNode.balanceFactor == 2) {
            if (unbalancedNode.left != null) {
                if (unbalancedNode.left.balanceFactor == 1) {
                    if (parentRoot != null) {
                        if (unbalancedNode.data >= parentRoot.data) {
                            parentRoot.right = lhRotation(unbalancedNode);
                        } else {
                            parentRoot.left = lhRotation(unbalancedNode);
                        }
                    } else {
                        parentRoot = lhRotation(unbalancedNode);
                    }
                } else {
                    if (parentRoot != null) {
                        if (unbalancedNode.data >= parentRoot.data) {
                            parentRoot.right = lrDoubleRotation(unbalancedNode);
                        } else {
                            parentRoot.left = lrDoubleRotation(unbalancedNode);
                        }
                    } else {
                        parentRoot = lrDoubleRotation(unbalancedNode);
                    }
                }
            }
        }
            // mam si zisti či je moj parent root null ( hl root) ak hej tak vybalancovany iba brat a nenastavuj napajanie pre parenta
            if( parentRoot != null) return parentRoot;
            return unbalancedNode;
        }




    public Node rhRotation(Node currRoot){
        Node temp = currRoot.right;
        currRoot.right = temp.left; // dobre pre obj na lavo od stredneho
        temp.left = currRoot;
        return temp;
    }
    public Node lhRotation(Node currRoot){
        Node temp = currRoot.left;  // do pomocneho Nodu si dam laveho potomka
        currRoot.left = temp.right; // laveho potomka vynulujem
        temp.right = currRoot; // napravo dam poslany prvok lebo je vačsi
        return temp;
    }

    public Node rlDoubleRotation(Node currRoot){
        currRoot.right = lhRotation(currRoot.right);
        Node temp = currRoot.right;
        currRoot.right = temp.left;
        temp.left = currRoot;
        return temp;
    }

    public Node lrDoubleRotation(Node currRoot){
        currRoot.left = rhRotation(currRoot.left);
        Node temp = currRoot.left;
        currRoot.left = temp.right;
        temp.right = currRoot;
        return temp;
    }

    public Node insertRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data,createDataString(10)); // pridavam Node a vratim sa do funkcie čo ma volala predtým
        }

        if (data < current.data) {
            current.left = insertRecursive(current.left, data); // rekurzívne až po koniec idem aby som pridal node
            current.height = calculateHeight(current); // prepocitam si vysky
            current.balanceFactor = calculateBalanceFactor(current); // prepocitam balancefactor
            if(current.balanceFactor >= 2 ||current.balanceFactor <= -2){ // kontrola BF pre volanie rotacii
                current = balanceTree(current,null);
                //znovu prepocitanie vysky a BF pre current a jeho deti
                current.left.height = calculateHeight(current.left);
                current.left.balanceFactor = calculateBalanceFactor(current.left);

                current.right.height =  calculateHeight(current.right);
                current.right.balanceFactor =  calculateBalanceFactor(current.right);

                current.height = calculateHeight(current);
                current.balanceFactor = calculateBalanceFactor(current);
            }
        }
        else if (data > current.data) {
            current.right = insertRecursive(current.right, data);
            //current.height = current.calculateHeight(current);
            current.height = calculateHeight(current);
            current.balanceFactor = calculateBalanceFactor(current);

            if(current.balanceFactor >= 2 ||current.balanceFactor <= -2) {
                current = balanceTree(current,null);

                current.left.height = calculateHeight(current.left);
                current.left.balanceFactor = calculateBalanceFactor(current.left);

                current.right.height =  calculateHeight(current.right);
                current.right.balanceFactor =  calculateBalanceFactor(current.right);

                current.height = calculateHeight(current);
                current.balanceFactor = calculateBalanceFactor(current);
            }
        }


        return current;
    }

    public int calculateBalanceFactor(Node node){
        if(node.left != null && node.right != null)node.balanceFactor = (node.left.height - node.right.height);
        else if (node.left == null) node.balanceFactor = -node.height;
        else node.balanceFactor = node.height;
        return node.balanceFactor;
    }
    public int calculateHeight(Node node) {
        if (node.left != null && node.right != null) { // ak mam 2 deti tak ich rodiel ale musim sucet lebo budu opacne hodnoty
            return Math.max(node.right.height, node.left.height)+1;
        }
        else if(node.left == null && node.right == null) return  0;
            // Inak zistime hĺbky jeho synov a vrátime ich maximum zvačsene o 1
        else {
            if(node.left != null ) return (node.left.height + 1);
            else {
                return (node.right.height + 1);
            }
        }

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

    public Node searchRec(Node root, int key) {
        if (root == null || root.data == key) {
            return root;
        }

        else if (key < root.data) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }


    Node deleteNode(Node root, int key) {
        // Ak sme narazili na prázdny uzol, nič sa nemusí vymazávať
        if (root == null) {
            return root;
        }

        // Ak sa hľadaná hodnota nachádza v ľavom podstrome, rekurzívne ju vymažeme z tohto podstromu
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }
        // Ak sa hľadaná hodnota nachádza v pravom podstrome, rekurzívne ju vymažeme z tohto podstromu
        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }
        // Ak sme narazili na uzol s hľadanou hodnotou
        else  {
            // Prípad 1: Uzol nemá žiadneho potomka - môžeme ho jednoducho odstrániť
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Prípad 2: Uzol má iba jedného potomka - môžeme ho nahradiť jeho jediným potomkom
            else if (root.left == null) {
                root = root.right;
            }
            else if (root.right == null) {
                root = root.left;
            }
            // Prípad 3: Uzol má dvoch potomkov - musíme ho nahradiť hodnotou jeho najmenšieho pravého potomka a potom vymazať tento najmenší pravý potomok
            else {
                // Nájdeme najmenšieho pravého potomka
                Node minRight = findMin(root.right);
                // Nahradíme hodnotu uzla hodnotou najmenšieho pravého potomka
                root.data = minRight.data;
                // Vymažeme najmenší pravý potomok
                root.right = deleteNode(root.right, minRight.data);
            }
        }

        // Vrátime nový koreň stromu po vymazaní uzla
        return root;
        // Funkcia na vymazanie uzla so zadanou hodnotou z binárneho stromu
        // root - koreň stromu, key - hodnota uzla, ktorý sa má vymazať
        // Return: nový koreň stromu po vymazaní uzla
    }

    /**
     * Funkcia na nájdenie uzla s najmenším kľúčom v strome
     *
     * @param node koreň podstromu, v ktorom sa má nájsť uzol s najmenším kľúčom
     * @return uzol s najmenším kľúčom v strome
     */
    public Node findMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
}