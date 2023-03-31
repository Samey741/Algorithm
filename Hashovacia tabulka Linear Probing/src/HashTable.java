import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class HashTable {
    static public int actualArraySize;
    static public int indexToBeDeleted;

    public Map<String, Integer>[]insert(int x,Map<String, Integer>[] mapArray){
        int actualArraySize = mapArray.length;
        int indexToBeDeleted;
        int oldArraySize = 0;
        this.actualArraySize = mapArray.length;

            String value = createDataString(10); // vytvorim si random string s 10 znakmi
            int key = value.hashCode(); // vytvorim si z neho int cez hashcode
            int newIndex;
            int index = createHash(key,actualArraySize); // ziskam na zaklade key

            if(mapArray[index].isEmpty() ){
                mapArray[index].put(value, key); // ak je index prazdny pridaj
            }
            else  {
                newIndex = findPlace(mapArray, index,oldArraySize); // inak hladam dalsie miesto
                if(newIndex != -1 )  mapArray[newIndex].put(value, key);
                else { // nenasli sme od indexu až po koniec ziadne volne miesto tak sme vytvorili nove miesto
                    int startPosition = findPlaceFromStart(mapArray, index,oldArraySize);
                    if( startPosition != -1 ){
                        mapArray[startPosition].put(value, key);
                    }

                }
            }
            if(x >= (actualArraySize * 0.5)){ // ak je mapa naplnena do polky
                oldArraySize = actualArraySize;
                Map<String, Integer>[] newMapArray = new HashMap[2 * actualArraySize]; // vytvorenie noveho pola 2x tak velkeho
                actualArraySize = newMapArray.length;
                System.out.printf("Zvačsil som miesto \n");
                newMapArray = inicialize(newMapArray); // vytvoril som a inicializoval novu mapu 2x tak velku
                for (int j = 0; j < oldArraySize; j++) {

                    if ( !mapArray[j].isEmpty()) { // indexoval
                        Map<String, Integer> map = mapArray[j];
                        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                            newIndex = createHash(entry.getValue(),actualArraySize);
                            if(newMapArray[newIndex].isEmpty()){
                                newMapArray[newIndex].put(value, key);
                            }
                            else {
                                newIndex = findPlace(newMapArray, newIndex,actualArraySize);
                                if(newIndex != -1 ) newMapArray[newIndex].put(value, key);
                                else {
                                    newIndex = findPlaceFromStart(newMapArray, newIndex,oldArraySize);
                                    if( newIndex != -1 ){
                                        newMapArray[newIndex].put(value, key);
                                    }
                                }
                            }

                        }
                    }
                }

                // System.arraycopy(mapArray, 0, newMapArray, 0, oldArraySize); // odkial , od akeho indexu , kam , na aky index , pokial zo stareho pola
                mapArray = newMapArray; // prestavenie ukazovatela stareho pola na nove
            }
        return mapArray;
    }

      Map<String, Integer>[]inicialize(Map<String, Integer>[] newMapArray){
        for (int i = 0; i < newMapArray.length ; i++) {
            newMapArray[i] = new HashMap<String, Integer>(); // vytvorim si pole s Hashmapou na kazdom indexe pola
        }
        return newMapArray;
    }


     int findPlaceFromStart( Map<String, Integer>[] mapArray, int i,int oldArraySize){
        for (int j = oldArraySize; j < i; j++) {
            if(mapArray[j].isEmpty()){
                return j;
            }
        }
        return -1;
    }
     int findPlace( Map<String, Integer>[] mapArray, int i,int oldArraySize){
        // kukam od indexu alebo ak je index mensi ako velkost starej mapy čo už je zaaplnena tak kukam od jej konca
        // v novej mape po jej koniec
        if(i <= oldArraySize){
            for (int j = oldArraySize; j < actualArraySize ; j++) {
                if(mapArray[j].isEmpty()){
                    return j;
                }
            }
        }
        else {
            for (int j = i; j < actualArraySize ; j++) {
                if(mapArray[j].isEmpty()){
                    return j;
                }
            }
        }


        return -1;

    }

     int createHash(int value, int arraySize){
        int tableIndex = (value % arraySize);
        return Math.abs(tableIndex);
    }


     String createDataString(int length) {

        Random random = new Random();
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(AB.charAt(random.nextInt(AB.length())));
        }
        return stringBuilder.toString();


    }

     boolean searchTillEnd( Map<String, Integer>[] mapArray, int i,int value) {
        for (int j = i; j < mapArray.length ; j++) { // hlada do konca na každej pozícii
            Map<String, Integer> map = mapArray[j];
            if (map.size() != 0) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue().equals(value)) {
                        //System.out.printf("Nasiel som ho na indexe : " + j + "bolo tam nazaj" + entry.getValue() + "hladal som :" + value + "\n"  );
                        return true;
                    }
                }
            }
            else return false; // ukončenie lebo som hladal medzi takými čo maju hodnoty a ak narazím na prazdy index a nenasiel som prvok do toho momentu tak už by nemal byt dalej ale na tom indexe čo mal byt prazdny
        }
        return false;
    }

     boolean searchFromStart(Map<String, Integer>[] mapArray, int i,int value) {
        for (int j = 0; j < i; j++) { // hlada od začiatku do indexu kde ho povodne nenaslo

            Map<String, Integer> map = mapArray[j];
            if (map.size() != 0) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue().equals(value)) {
                        //System.out.printf("Nasiel som ho na indexe : " + j + "bolo tam nazaj" + entry.getValue() + "hladal som :" + value + "\n"  );
                        return true;
                    }
                }
            }
            else return false; // ukončenie lebo som hladal medzi takými čo maju hodnoty a ak narazím na prazdy index a nenasiel som prvok do toho momentu tak už by nemal byt dalej ale na tom indexe čo mal byt prazdny

        }
        return false;
    }

     boolean searchMap(Map<String, Integer>[] mapArray,int value,int index){

        boolean result = false;
        Map<String, Integer> map = mapArray[index];
        if (map.size() != 0) { // pokial je index prazdy ale prvok by mal byt na indexe neni v tabulke
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                //System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                if (entry.getValue() != null && entry.getValue().equals(value)) { // dostatie hodnoty v map čo je nas idex z mapArray
                    indexToBeDeleted = index;
                    return true;
                }
                else {
                    result = searchTillEnd(mapArray, index, value);
                    if(result) {
                        indexToBeDeleted = index;
                        return result;
                    }
                    if (!result) {
                        result = searchFromStart(mapArray, index, value);
                        if(result) {
                            indexToBeDeleted = index;
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }

     Map[] deleteData(Map<String, Integer>[] mapArray){

        String value = createDataString(10); // vytvorim si random string s 10 znakmi
        int key = value.hashCode(); // vytvorim si z neho int cez hashcode
        int index = createHash(key,mapArray.length); // ziskam na zaklade key

        if(searchMap(mapArray,key,index)) mapArray[indexToBeDeleted].remove(value);
        return mapArray;
    }

}
