import java.util.Comparator;

public class PlayerRankedComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(o1.getRanking(), o2.getRanking());
    }
}
