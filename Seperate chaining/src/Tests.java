public class Tests {


    public static void main(String[] args){
        int counter = 0;
        Node[] hashTable = new Node[1009]  ;
        Node[] hashTable2 = new Node[1009]  ;
        Node[] hashTable3 = new Node[1009]  ;
        SeparateChaining test = new SeparateChaining();

        int[] datas = new int[1000000];
        int[] datas2 = new int[100000];
        int[] datas3 = new int[10000];

        if (counter == 0){
            System.out.printf("INSERT 10 000 , 100 000 a 1 000 000 prvkov \n");

            System.out.printf("INSERT 10 000 \n");
            long startTime3 = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {
                String value = test.createDataString(10);
                int key = value.hashCode();
                datas3[i] = key;
                hashTable = test.insert(hashTable,value,key);
            }
            long endTime3 = System.currentTimeMillis();
            System.out.println("Kód vykonaný za " + (endTime3 - startTime3) + " Milisekund "+ (endTime3 - startTime3) / 1000 + " sekúnd. \n");

            System.out.printf("INSERT 100 000 \n");
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {
                String value = test.createDataString(10);
                int key = value.hashCode();
                datas2[i] = key;
                hashTable2 = test.insert(hashTable2,value,key);
            }
            long endTime2 = System.currentTimeMillis();
            System.out.println("Kód vykonaný za " + (endTime2 - startTime2) + " Milisekund "+ (endTime2 - startTime2) / 1000 + " sekúnd. \n");

            System.out.printf("INSERT 1 000 000 \n");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {
                String value = test.createDataString(10);
                int key = value.hashCode();
                datas[i] = key;
                hashTable3 = test.insert(hashTable3,value,key);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Kód vykonaný za " + (endTime - startTime) + " Milisekund "+ (endTime - startTime) / 1000 + " sekúnd. \n");
        }
        counter++;
        if (counter == 1){
            Node foundedObject;
            System.out.printf("Search 10 000 , 100 000 a 1 000 000 prvkov \n");

            System.out.printf("Search 10 000 \n");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {
                int key = test.createDataInt();
                foundedObject = test.searchData(hashTable,key);
                //if (foundedObject != null){
                //    System.out.printf("Hladany key je : " + key + "  ");
                //    System.out.printf("Najdeny Objekt ma key : " + foundedObject.key + "\n");
                //}

            }
            long endTime = System.currentTimeMillis();
            System.out.println("Kód vykonaný za " + (endTime - startTime) + " Milisekund "+ (endTime - startTime) / 1000 + " sekúnd. \n");

            System.out.printf("Search 100 000 \n");
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {
                int key = test.createDataInt();
                foundedObject = test.searchData(hashTable2,key);
                //if (foundedObject != null){
                //    System.out.printf("Hladany key je : " + key + "  ");
                //    System.out.printf("Najdeny Objekt ma key : " + foundedObject.key + "\n");
                //}

            }
            long endTime2 = System.currentTimeMillis();
            System.out.println("Kód vykonaný za " + (endTime2 - startTime2) + " Milisekund "+ (endTime2 - startTime2) / 1000 + " sekúnd. \n");

            System.out.printf("Search 1 000 000 \n");
            long startTime3 = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {
                int key = test.createDataInt();
                foundedObject = test.searchData(hashTable3,key);
                //if (foundedObject != null){
                //    System.out.printf("Hladany key je : " + key + "  ");
                //    System.out.printf("Najdeny Objekt ma key : " + foundedObject.key + "\n");
                //}

            }
            long endTime3 = System.currentTimeMillis();
            System.out.println("Kód vykonaný za " + (endTime3 - startTime3) + " Milisekund "+ (endTime3 - startTime3) / 1000 + " sekúnd. \n");
        }
        counter++;
        if(counter == 2){
            Node[] deleteTable;
            int deleteCounter = 0;
            int deleteCounter2 = 0;
            int deleteCounter3 = 0;
            System.out.printf("Delete 10 000 , 100 000 a 1 000 000 prvkov \n");

            System.out.printf("Delete 10 000 \n");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {
                String value = test.createDataString(10);
                int key = value.hashCode();
                deleteTable = test.deleteData(hashTable,datas3[i]);
                if (deleteTable != null){
                    hashTable = deleteTable;
                    deleteCounter++;
                }

            }
            long endTime = System.currentTimeMillis();
            System.out.println("Kód vykonaný za " + (endTime - startTime) + " Milisekund "+ (endTime - startTime) / 1000 + " sekúnd. Vymazal som : " + deleteCounter + "\n");

            System.out.printf("Delete 100 000 \n");
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {
                String value = test.createDataString(10);
                int key = value.hashCode();
                deleteTable = test.deleteData(hashTable2,datas2[i]);
                if (deleteTable != null){
                    hashTable2 = deleteTable;
                    deleteCounter2++;
                }

            }
            long endTime2 = System.currentTimeMillis();
            System.out.println("Kód vykonaný za " + (endTime2 - startTime2) + " Milisekund "+ (endTime2 - startTime2) / 1000 + " sekúnd. Vymazal som : " + deleteCounter2 + "\n");

            System.out.printf("Delete 1 000 000 \n");
            long startTime3 = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {
                String value = test.createDataString(10);
                int key = value.hashCode();
                deleteTable = test.deleteData(hashTable3,datas[i]);
                if (deleteTable != null){
                    hashTable3 = deleteTable;
                    deleteCounter3++;
                }

            }
            long endTime3 = System.currentTimeMillis();
            System.out.println("Kód vykonaný za " + (endTime3 - startTime3) + " Milisekund "+ (endTime3 - startTime3) / 1000 + " sekúnd. Vymazal som : " + deleteCounter3 + "\n");
        }

    }
}
