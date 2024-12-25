package collection.compare.comparator;

import collection.compare.MyUser;

import java.util.Comparator;

public class IdComparator implements Comparator<MyUser> {
    @Override
    public int compare(MyUser a, MyUser b) {
        return a.getId().compareTo(b.getId());
    }
}