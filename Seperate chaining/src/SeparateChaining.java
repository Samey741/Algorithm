import java.util.Random;

public class SeparateChaining {

        static public int size;
        static public int counter = 0;

        static public int createHash(int key) {
            return Math.abs(key % size);
        }

        static int createDataInt() {
            Random random = new Random();
            return random.nextInt(9999);
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

        public Node[] insert( Node[] hashTable,String value,int key ) {
                size = hashTable.length;
                Node singleNode = new Node(key,value,createDataInt());
                int index = createHash(key);
                if ( hashTable[index] == null){
                    hashTable[index] = singleNode;
                }
                else {
                    Node emptyNode = hashTable[index];
                    while (emptyNode.next != null)
                    {
                        emptyNode = emptyNode.next;
                        counter++;
                    }
                    emptyNode.next = singleNode;
                }

                if (counter >= (0.4 * size)){
                    System.out.printf("IDEM ROBIT RESIZE \n");
                    int oldArrSize = size; // nastavenie starej velkosti
                    Node[] newHashTable = new Node[2*size]; // vytvorneie noveho pola 2* tak velkeho
                    size = newHashTable.length;

                    for (int j = 0; j < oldArrSize; j++) { // prechadzanie stareho pola kvoli prehodeniu podla noveho hashu
                        if(hashTable[j] != null) {
                            int newIndex = createHash(hashTable[j].key); // zistenie noveho hashu pre 1. prvok

                            if (newHashTable[newIndex] == null) { // vlozenie hned ako 1. node
                                newHashTable[newIndex] = new Node(hashTable[j].key,hashTable[j].value,hashTable[j].id);
                            }
                            else { // vlozenie pre pripad ze novy 1. node už je obsadeny
                                Node emptyNode = newHashTable[newIndex];
                                while (emptyNode.next != null) {
                                    emptyNode = emptyNode.next;
                                }
                                emptyNode.next = new Node(hashTable[j].key,hashTable[j].value,hashTable[j].id);
                            }

                            if(hashTable[j].next != null){
                                Node emptyNode = hashTable[j]; // nastavenie sa na index pola kvoli prechadzaniu link listu
                                while (emptyNode.next != null) // prechazdam stratu tabluku jej objekty na indexe do konca
                                {
                                    emptyNode = emptyNode.next; // posuvam sa cez linked list
                                    int newIndexNestedObject = createHash(emptyNode.key);
                                    if ( newHashTable[newIndexNestedObject] == null){
                                        newHashTable[newIndexNestedObject] = new Node(emptyNode.key,emptyNode.value,hashTable[j].id);
                                    }
                                    else {
                                        Node findEmptyNode = newHashTable[newIndexNestedObject];
                                        while (findEmptyNode.next != null) {
                                            findEmptyNode = findEmptyNode.next;
                                        }
                                        findEmptyNode.next = new Node(emptyNode.key,emptyNode.value,hashTable[j].id);
                                    }
                                }
                            }
                        }
                    }
                    //System.arraycopy(hashTable, 0, newHashTable, 0, size);
                    hashTable = newHashTable;

                }

           return hashTable;
        }




        static public Node searchData(Node[] hashTable, int key){
            size = hashTable.length;
            int index = createHash(key);
            if(hashTable[index] != null) {
                if(hashTable[index].key == key){
                    return hashTable[index];
                }
                else if(hashTable[index].next != null){
                    Node emptyNode = hashTable[index];
                    while (emptyNode.next != null)
                    {
                        emptyNode = emptyNode.next;
                        if(emptyNode.key == key){
                            emptyNode.next = null; // zmazem prevzatie aj ostatých v liste a poslem iba 1 objekt
                            return emptyNode;
                        }
                    }
                }
            }

            return null;
        }


        public static Node[] deleteData(Node[] hashTable, int key){
            size = hashTable.length;
            int index = createHash(key);
            if(hashTable[index] != null) {
                if(hashTable[index].key == key){
                    hashTable[index] = hashTable[index].next; // naslo ho hned na 1 pozicii tak bud hodi refecenciu na null alebo na dalsi obj
                    return hashTable;
                }
                else if(hashTable[index].next != null){
                    Node prevNode = hashTable[index];
                    Node currNode = hashTable[index].next;
                    while (currNode != null)
                    {
                        if(currNode.key == key){
                            prevNode.next = currNode.next; // preskocim resp stratim referenciu na objekt kt som hladal
                            return hashTable;
                        }
                        prevNode = currNode;
                        currNode = currNode.next;

                    }
                }
            }
            return null;
        }
    }



