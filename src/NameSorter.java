import java.util.Comparator;

public class NameSorter implements Comparator<DefaultMember> {
    @Override
    public int compare(DefaultMember o1, DefaultMember o2) {
        return o2.getName().compareToIgnoreCase(o1.getName());
    }
}
