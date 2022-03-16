package CollectStreamElementToList;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingStringElementsIntoList {
    public static void main(String[] args) {
        /*
            В 1 и 2 вариантах мы накапливаем Stream в List через интерейс Collector. Это приводит к дополнительному
        выделение и  копированию, поскольку мы не работаем напрямую с потоком.
        В 3 варианте мы получаем список непосредственно из потока, что предотвращает дополнитьное выделение
        и копирование. 3 вариан предпочтительнее если вы используете Java 16+.

        Collectors.toList() собирает элементы Stream в ArrayList.(java.util.ArrayList)
        Collectors.toUnmodifiedList() собирает элементы Stream в неизменяемый список (java.util.ImmutableCollections.ListN)
        Stream.toList() собирает элементы в неизменяемый список (java.util.ImmutableCollections.ListN).
        Это означает, что мы можем выполнять такие операции, как добавление и сортировка элементов Collectors.toList(),
        но не элементы Collectors.toUnmodifiableList() и Stream.toList().

            Collector.toUnmodifiableList и Collector.toList генерирует исключение NullPointerException, когда мы собираем
        поток содержащий нелевые элементы, а Stream.toList не генерирует исключение NullPointerException.

        Поэтому при переносе кода с Java8 на Java10 или Java16 стоит обратить внимание на это.
         */
        //1) beginning Java 8
        List<String> result = Stream.of(Locale.getISOCountries()).collect(Collectors.toList());
        //2) beginning Java 10
        List<String> result2 = Stream.of(Locale.getISOCountries()).collect(Collectors.toUnmodifiableList());
        //3) beginning Java 16
        List<String> result3 = Stream.of(Locale.getISOCountries()).toList();
    }
}
