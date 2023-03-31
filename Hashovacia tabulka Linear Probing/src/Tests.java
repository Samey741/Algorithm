import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class Tests {

    static HashTable test = new HashTable();
    public static Map<String, Integer>[] mapArray = new HashMap[1009]; // pole map Arrayov kde 1 idex ma miesto pre string a int

    static HashTable test2 = new HashTable();
    public static Map<String, Integer>[] mapArray2 = new HashMap[1009]; // pole map Arrayov kde 1 idex ma miesto pre string a int

    static HashTable test3 = new HashTable();
    public static Map<String, Integer>[] mapArray3 = new HashMap[1009]; // pole map Arrayov kde 1 idex ma miesto pre string a int


    public static void main(String args[]){
        int counter = 0;

        if(counter == 0) {
            for (int i = 0; i < mapArray.length; i++) {
                mapArray[i] = new HashMap<String, Integer>(); // vytvorim si pole s Hashmapou na kazdom indexe pola
            }
            System.out.printf("Insert 10 000 prvkov\n");
            long startTime3 = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                mapArray = test.insert(i, mapArray);
            }
            long endTime3 = System.currentTimeMillis();
            System.out.println("Kód Insert vykonaný za " + (endTime3 - startTime3) + " Miliseknund a " + (endTime3 - startTime3) / 1000 + " sekúnd \n");

            System.out.printf("Insert 100 000 prvkov\n");
            for (int i = 0; i < mapArray2.length; i++) {
                mapArray2[i] = new HashMap<String, Integer>(); // vytvorim si pole s Hashmapou na kazdom indexe pola
            }
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                mapArray2 = test2.insert(i,mapArray2);
            }
            long endTime2 = System.currentTimeMillis();
            System.out.println("Kód Insert vykonaný za " + (endTime2 - startTime2) + " Miliseknund a " + (endTime2 - startTime2) / 1000 + " sekúnd \n");

            System.out.printf("Insert 1 000 000 prvkov\n");
            for (int i = 0; i < mapArray3.length; i++) {
                mapArray3[i] = new HashMap<String, Integer>(); // vytvorim si pole s Hashmapou na kazdom indexe pola
            }
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                mapArray3 = test3.insert(i,mapArray3);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Kód Insert vykonaný za " + (endTime - startTime) + " Miliseknund a " + (endTime - startTime) / 1000 + " sekúnd \n");

        }
        counter++;
        if (counter == 1){

            System.out.printf("Search Random 10 000 prvkov");
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {
                String value = test.createDataString(10);
                int key = value.hashCode();
                int index = test.createHash(key,mapArray.length);
                boolean result = test.searchMap(mapArray,key,index);
            }
            long endTime2 = System.currentTimeMillis();
            System.out.println("Kód Search vykonaný za " + (endTime2 - startTime2) + " Miliseknund a " + (endTime2 - startTime2) / 1000 + " sekúnd \n");

            System.out.printf("Search Random 100 000 prvkov");
            long startTime3 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {
                String value = test.createDataString(10);
                int key = value.hashCode();
                int index = test.createHash(key,mapArray2.length);
                boolean result = test.searchMap(mapArray2,key,index);
            }
            long endTime3 = System.currentTimeMillis();
            System.out.println("Kód Search vykonaný za " + (endTime3 - startTime3) + " Miliseknund a " + (endTime3 - startTime3) / 1000 + " sekúnd \n");

            System.out.printf("Search Random 1 000 000 prvkov");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {
                String value = test.createDataString(10);
                int key = value.hashCode();
                int index = test.createHash(key,mapArray3.length);
                boolean result = test.searchMap(mapArray3,key,index);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Kód Search vykonaný za " + (endTime - startTime) + " Miliseknund a " + (endTime - startTime) / 1000 + " sekúnd \n");

        }
        counter++;

        if(counter == 2){

            System.out.printf("Delete Random 10 000 prvkov");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000 ; i++) {
                //value = createDataInt();
                mapArray = test.deleteData(mapArray);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Kód DELETE vykonaný za " + (endTime - startTime) + " Miliseknund a " + (endTime - startTime) / 1000 + " sekúnd \n");


            System.out.printf("Delete Random 100 000 prvkov");
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 100000 ; i++) {
                //value = createDataInt();
                mapArray2 = test.deleteData(mapArray2);
            }
            long endTime2 = System.currentTimeMillis();
            System.out.println("Kód DELETE vykonaný za " + (endTime2 - startTime2) + " Miliseknund a " + (endTime2 - startTime2) / 1000 + " sekúnd \n");

            System.out.printf("Delete Random 1 000 000 prvkov");
            long startTime3 = System.currentTimeMillis();
            for (int i = 0; i < 1000000 ; i++) {
                //value = createDataInt();
                mapArray3 = test.deleteData(mapArray3);
            }
            long endTime3 = System.currentTimeMillis();
            System.out.println("Kód DELETE vykonaný za " + (endTime3 - startTime3) + " Miliseknund a " + (endTime3 - startTime3) / 1000 + " sekúnd \n");


        }

    }

}
