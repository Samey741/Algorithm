import java.util.Random;

public class Tests {

    public static void main(String[] args){
        int counter = 0;
        Random rand = new Random();
        BinaryTree prvyStrom = new BinaryTree();
        BinaryTree druhyStrom = new BinaryTree();
        BinaryTree tretiStrom = new BinaryTree();
        if(counter == 0) {
            System.out.printf("Idem Testovat insert do AVL STROMU pre 10 000 , 100 000 , 1 000 000 prvkov \n");


            System.out.printf("Insert 10 000 prvkov");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {
                int int_random = rand.nextInt(10000);
                prvyStrom.insert(int_random);
            }
            long end = System.currentTimeMillis();
            System.out.printf("Trvalo to : " + (end - start) + " Milisekund = " + (end - start)/1000 + " Sekund \n" );


            System.out.printf("Insert 100 000 prvkov");
            long start2 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {
                int int_random = rand.nextInt(100000);
                druhyStrom.insert(int_random);
            }
            long end2 = System.currentTimeMillis();
            System.out.printf("Trvalo to : " + (end2 - start2) + " Milisekund = " + (end2 - start2)/1000 + " Sekund \n" );


            System.out.printf("Insert 1 000 000 prvkov");
            long start3 = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {
                int int_random = rand.nextInt(1000000);
                tretiStrom.insert(int_random);
            }
            long end3 = System.currentTimeMillis();
            System.out.printf("Trvalo to : " + (end3 - start3) + " Milisekund = " + (end3 - start3)/1000 + " Sekund \n" );


        }
        counter++;
        if(counter == 1){
            System.out.printf("Idem Testovat Search AVL STROMU pre 10 000 , 100 000 , 1 000 000 prvkov \n");


            System.out.printf("Search 10 000 prvkov");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {
                int int_random = rand.nextInt(10000);
                Node foundedNode = prvyStrom.searchRec(prvyStrom.root, int_random);
                //if(foundedNode != null) System.out.printf("Nasiel som a mal v sebe = " + foundedNode.data + "\n");
                //else System.out.printf("Nenasiel som, prvok v strome neexistoval \n");
            }
            long end = System.currentTimeMillis();
            System.out.printf("Trvalo to : " + (end - start) + " Milisekund = " + (end - start)/1000 + " Sekund \n" );


            System.out.printf("Search 100 000 prvkov");
            long start2 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {
                int int_random = rand.nextInt(100000);
                Node foundedNode = druhyStrom.searchRec(druhyStrom.root, int_random);
                //if(foundedNode != null) System.out.printf("Nasiel som a mal v sebe = " + foundedNode.data + "\n");
                //else System.out.printf("Nenasiel som, prvok v strome neexistoval \n");
            }
            long end2 = System.currentTimeMillis();
            System.out.printf("Trvalo to : " + (end2 - start2) + " Milisekund = " + (end2 - start2)/1000 + " Sekund \n" );

            System.out.printf("Search 1 000 000 prvkov");
            long start3 = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {
                int int_random = rand.nextInt(1000000);
                Node foundedNode = tretiStrom.searchRec(tretiStrom.root, int_random);
                //if(foundedNode != null) System.out.printf("Nasiel som a mal v sebe = " + foundedNode.data + "\n");
                //else System.out.printf("Nenasiel som, prvok v strome neexistoval \n");
            }
            long end3 = System.currentTimeMillis();
            System.out.printf("Trvalo to : " + (end3 - start3) + " Milisekund = " + (end3 - start3)/1000 + " Sekund \n" );
        }

        counter++;
        if (counter == 2){
            System.out.printf("Idem Testovat Delete AVL STROMU pre 10 000 , 100 000 , 1 000 000 prvkov \n");


            System.out.printf("Detele 10 000 prvkov");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {
                int int_random = rand.nextInt(10000);
                prvyStrom.root = prvyStrom.deleteNode(prvyStrom.root, int_random);
                //System.out.printf("Vymazalo sa ");
            }
            long end = System.currentTimeMillis();
            System.out.printf("Trvalo to : " + (end - start) + " Milisekund = " + (end - start)/1000 + " Sekund \n" );

            System.out.printf("Detele 100 000 prvkov");
            long start2 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {
                int int_random = rand.nextInt(100000);
                druhyStrom.root = druhyStrom.deleteNode(druhyStrom.root, int_random);
               // System.out.printf("Vymazalo sa ");
            }
            long end2 = System.currentTimeMillis();
            System.out.printf("Trvalo to : " + (end2 - start2) + " Milisekund = " + (end2 - start2)/1000 + " Sekund \n" );

            System.out.printf("Detele 1 000 000 prvkov");
            long start3 = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {
                int int_random = rand.nextInt(1000000);
                tretiStrom.root = tretiStrom.deleteNode(tretiStrom.root, int_random);
                //System.out.printf("Vymazalo sa ");
            }
            long end3 = System.currentTimeMillis();
            System.out.printf("Trvalo to : " + (end3 - start3) + " Milisekund = " + (end3 - start3)/1000 + " Sekund \n" );

        }


    }
}
