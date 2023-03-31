import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        SplayTree tree = new SplayTree();

       /* tree.insert(2);
        tree.insert(44);
        tree.insert(1);
        tree.insert(3);
        tree.insert(22);
        tree.insert(7);




        tree.searchNode(2);
        tree.searchNode(3);
        tree.searchNode(22);
        System.out.printf("kkoko");
        tree.deleteNode(3);
        tree.deleteNode(2);
        tree.deleteNode(44);
        System.out.printf("kkoko");*/

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100 ; i++) {

            int randomIndex = random.nextInt(100);
            tree.insert(randomIndex);
        }
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime) / 1000;  // čas v sekundách
        System.out.println("Kód vykonaný za " + (endTime - startTime) + " Milisekund "+ duration + " sekúnd. \n");

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100 ; i++) {
            int randomIndex = random.nextInt(100);
            tree.searchNode(randomIndex);
        }
        long endTime2 = System.currentTimeMillis();
        long duration2 = (endTime2 - startTime2) / 1000;  // čas v sekundách
        System.out.println("Kód vykonaný za " + (endTime2 - startTime2) + " Milisekund "+ duration2 + " sekúnd. \n");


        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < 100 ; i++) {
            int randomIndex = random.nextInt(100);
            tree.deleteNode(randomIndex);
        }
        long endTime3 = System.currentTimeMillis();
        long duration3 = (endTime3 - startTime3) / 1000;  // čas v sekundách
        System.out.println("Kód vykonaný za " + (endTime3 - startTime3) + " Milisekund "+ duration3 + " sekúnd. \n");

        Tests.main(null);

    }
}