import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        BinaryTree prvyStrom = new BinaryTree();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100 ; i++) {
            int int_random = rand.nextInt(100);
            prvyStrom.insert(int_random);
            System.out.printf("---------------------" + i + "----------------- \n");
        }
        long end = System.currentTimeMillis();
        System.out.printf("Trvalo to : " + (end - start) + " Milisekund = " + (end - start)/1000 + " Sekund \n" );

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100 ; i++) {
            int int_random = rand.nextInt(100);
            Node foundedNode = prvyStrom.searchRec(prvyStrom.root, int_random);
            if(foundedNode != null)System.out.printf("Nasiel som a mal v sebe = " + foundedNode.data + "\n");
            else System.out.printf("Nenasiel som \n");
        }
        long end2 = System.currentTimeMillis();
        System.out.printf("Trvalo to : " + (end2 - start2) + " Milisekund = " + (end2 - start2)/1000 + " Sekund \n" );



        long start3 = System.currentTimeMillis();
        for (int i = 0; i < 100 ; i++) {
            int int_random = rand.nextInt(100);
            prvyStrom.root = prvyStrom.deleteNode(prvyStrom.root, int_random);
            System.out.printf("Vymazalo sa ");
        }
        long end3 = System.currentTimeMillis();
        System.out.printf("Trvalo to : " + (end3 - start3) + " Milisekund = " + (end3 - start3)/1000 + " Sekund \n" );


        Tests.main(null);
    }


}

/*
Insert: Funkcia na vloženie nového prvku do stromu. Nový prvok sa vkladá tak, že sa prechádza stromom a hľadá sa prázdne miesto na vloženie. Ak je hodnota vkladaného prvku menšia ako hodnota súčasného uzla, prvok sa vloží do ľavého potomka. V opačnom prípade sa prvok vloží do pravého potomka.

Search: Funkcia na vyhľadávanie prvku v strome. Prechádza sa stromom a hľadá sa prvok s hodnotou rovnou hľadanému prvku.

Delete: Funkcia na odstránenie prvku zo stromu. Pri odstraňovaní prvku sa najprv hľadá v strome a potom sa odstráni. Pričom ako return sa vracia už vymazany strom ( jeho koren)

 */