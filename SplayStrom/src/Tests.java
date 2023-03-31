import java.util.Random;

public class Tests {

    public static void main(String[] args){
        int counter = 0;
        SplayTree tree1 = new SplayTree();
        SplayTree tree2 = new SplayTree();
        SplayTree tree3 = new SplayTree();
        Random random = new Random();

        if(counter == 0){
            System.out.printf("Testujem Insert do Splay Stromu 10 000 , 100 000 , 1 000 000 prvkov \n ");

            System.out.printf(" Insert 10 000  prvkov \n ");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {
                int randomIndex = random.nextInt(10000);
                tree1.insert(randomIndex);
            }
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime) / 1000;  // čas v sekundách
            System.out.println("Kód vykonaný za " + (endTime - startTime) + " Milisekund "+ duration + " sekúnd. \n");

            System.out.printf(" Insert 100 000  prvkov \n ");
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {

                int randomIndex = random.nextInt(100000);
                tree2.insert(randomIndex);
            }
            long endTime2 = System.currentTimeMillis();
            long duration2 = (endTime2 - startTime2) / 1000;  // čas v sekundách
            System.out.println("Kód vykonaný za " + (endTime2 - startTime2) + " Milisekund "+ duration2 + " sekúnd. \n");

            System.out.printf(" Insert 1 000 000  prvkov \n ");
            long startTime3 = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {

                int randomIndex = random.nextInt(1000000);
                tree3.insert(randomIndex);
            }
            long endTime3 = System.currentTimeMillis();
            long duration3 = (endTime3 - startTime3) / 1000;  // čas v sekundách
            System.out.println("Kód vykonaný za " + (endTime3 - startTime3) + " Milisekund "+ duration3 + " sekúnd. \n");
        }
        counter++;

        if (counter == 1){
            System.out.printf("Testujem Search do Splay Stromu 10 000 , 100 000 , 1 000 000 prvkov \n ");

            System.out.printf(" Search 10 000 prvkov \n ");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {

                int randomIndex = random.nextInt(10000);
                tree1.searchNode(randomIndex);
            }
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime) / 1000;  // čas v sekundách
            System.out.println("Kód vykonaný za " + (endTime - startTime) + " Milisekund "+ duration + " sekúnd. \n");

            System.out.printf(" Search 100 000 prvkov \n ");
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {

                int randomIndex = random.nextInt(10000);
                tree2.searchNode(randomIndex);
            }
            long endTime2 = System.currentTimeMillis();
            long duration2 = (endTime2 - startTime2) / 1000;  // čas v sekundách
            System.out.println("Kód vykonaný za " + (endTime2 - startTime2) + " Milisekund "+ duration2 + " sekúnd. \n");

            System.out.printf(" Search 1 000 000 prvkov \n ");
            long startTime3 = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {

                int randomIndex = random.nextInt(10000);
                tree3.searchNode(randomIndex);
            }
            long endTime3 = System.currentTimeMillis();
            long duration3 = (endTime3 - startTime3) / 1000;  // čas v sekundách
            System.out.println("Kód vykonaný za " + (endTime3 - startTime3) + " Milisekund "+ duration3 + " sekúnd. \n");
        }
        counter++;
        if(counter == 2){
            System.out.printf("Testujem Delete do Splay Stromu 10 000 , 100 000 , 1 000 000 prvkov \n ");

            System.out.printf(" Delete 10 000 prvkov \n ");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {
                int randomIndex = random.nextInt(10000);
                tree1.deleteNode(randomIndex);
            }
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime) / 1000;  // čas v sekundách
            System.out.println("Kód vykonaný za " + (endTime - startTime) + " Milisekund "+ duration + " sekúnd. \n");

            System.out.printf(" Delete 100 000 prvkov \n ");
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {
                int randomIndex = random.nextInt(100000);
                tree2.deleteNode(randomIndex);
            }
            long endTime2 = System.currentTimeMillis();
            long duration2 = (endTime2 - startTime2) / 1000;  // čas v sekundách
            System.out.println("Kód vykonaný za " + (endTime2 - startTime2) + " Milisekund "+ duration2 + " sekúnd. \n");

            System.out.printf(" Delete 1 000 000 prvkov \n ");
            long startTime3 = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {
                int randomIndex = random.nextInt(1000000);
                tree3.deleteNode(randomIndex);
            }
            long endTime3 = System.currentTimeMillis();
            long duration3 = (endTime3 - startTime3) / 1000;  // čas v sekundách
            System.out.println("Kód vykonaný za " + (endTime3 - startTime3) + " Milisekund "+ duration3 + " sekúnd. \n");
        }




    }
}
