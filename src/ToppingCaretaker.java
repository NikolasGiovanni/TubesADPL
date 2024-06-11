import java.util.ArrayList;
import java.util.List;

public class ToppingCaretaker {
    private final List<ToppingMemento> mementoList = new ArrayList<>();

    public void add(ToppingMemento state) {
        mementoList.add(state);
    }

    public ToppingMemento get(int index) {
        return mementoList.get(index);
    }

    public void removeLast() {
        if (!mementoList.isEmpty()) {
            mementoList.remove(mementoList.size() - 1);
        }
    }

    public int size() {
        return mementoList.size();
    }
}
