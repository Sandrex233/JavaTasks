import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Task N6
public class MyDataStructure {
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public MyDataStructure() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean remove (int val) {
        if(!map.containsKey(val)) return false;

        int indexToRemove = map.get(val);

        int lastElement = list.get(list.size() - 1);

        list.set(indexToRemove, lastElement);
        map.put(lastElement, indexToRemove);

        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }
}
