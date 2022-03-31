import java.util.*;
import java.util.stream.Collectors;


public class MainApp {
    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>(Arrays.asList(
                new Player(59, "John", 20),
                new Player(67, "Roger", 22),
                new Player(45, "Steven", 24)));


        footballTeam.stream()
                        .sorted(Comparator.comparing(Player::getRanking).reversed())
                .collect(Collectors.toList());


        System.out.println("Before sorting: " + footballTeam);
        //Сортируем при интерефейса Comparable
        Collections.sort(footballTeam);
        System.out.println("After sorting with implementation Comparable: " + footballTeam);

        //Реализовали свой Comparator
        PlayerRankedComparator rankComparator = new PlayerRankedComparator();
        PlayerAgeComparator ageComparator = new PlayerAgeComparator();

        footballTeam.sort(ageComparator);
        System.out.println("After sorting with your Comparator(Age): " + footballTeam);
        footballTeam.sort(rankComparator);
        System.out.println("After sorting with your Comparator(Rank): " + footballTeam);

        //Comparator при момощи лямбда-выражений
        Comparator<Player> byRank = Comparator.comparingInt(Player::getRanking);
        Comparator<Player> byAge = Comparator.comparingInt(Player::getAge);

    }
}
