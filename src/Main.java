import engine.Constants;
import engine.entities.Item;
import engine.utilities.Loader;

public class Main {

    public static void main(String[] args) {
        Loader.loadEntities();
        for(Item i : Constants.ITEM_LIST){
            System.out.println(i);
        }
    }
}
