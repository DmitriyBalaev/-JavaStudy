# Comparable и Comparator

----
----

## Comparable

Для определения стратегии сортировки можно использовать интерфейс Comparable<T> 
достаточно имплиментировать этот интерфейс, указать тип и переопределить метод compareTo().

    public class Player implements Comparable<Player>{
        private String name;
        //constructor and other mothods
        
        @Override
        public int compareTo(Player otherPlayer){
            return name.compare(otherPlayer.getName)

Порядок сортировки определяется значением метода `compareTo()`. 
Возвращает значение -1, если значение первого игрока больше второго,
0 если равны и 1 если значение меньше второго игрока.

Можно создать различные компараторы исходя по какому принципу мы сортируем.

    public class PlayerAgeComparator implements Comparator<Player> {
        @Override
        public int compare(Player o1, Player o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }

И его использовать при сортировке 
    
    List<Player> players = new ArrayList<>();
    //...
    PlayerAgeComparator = new PlayerAgeComparator();

    Collections.sort(players, playerAgeComparator);
    //or
    //players.sort(playerAgeComparator);

-----

## Comparator

Интерфейс Comparator тоже ипользуется для сортировки, у него есть приемущества
над Comparable

- Если нет возможности изменить иходный код класса, на помощь на приходит Comparator.
  - Мы можем определить несколько разным стратегий сортировки, что невозможно при использовании Comparable.


    Comparator<Player> playerComparatorByName = Comparator.comparing(Player::getName); 
          Arrays.sort(Players, playerComparatorByName);
        
    //Stream API
     List<Employee> playerSortedByName = players.stream()
                .sorted(Comparator.comparing(Player::getName))
                .toList();


### Comparator.reversed и Comparator.reverseOrder()

Методы используется что бы поменять сортировку в порядке убывания

    //Comparator.reversed
     List<Employee> playerSortedByName = players.stream()
                .sorted(Comparator.comparing(Player::getName).reversed())
                .toList();

    //Comparator.reverseOrder()
     List<Employee> playerSortedByName = players.stream()
                .sorted(Comparator.comparing(Player::getName), Comparator.reverseOrder())
                .toList();
Comparator.reverseOrder() выдает исключение NullPointerException  при сравнении с нулевым значением.

### Comparator.thenComparing

Если значения по которому мы сортируем одинаковы, то мы можем добавить еще варианты сортировки 
применимые к одинаковым элементам.

     List<Employee> playerSortedByName = players.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))                
                .toList();








    
        

        

