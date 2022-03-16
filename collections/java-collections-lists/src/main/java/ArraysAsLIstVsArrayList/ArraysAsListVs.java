package ArraysAsLIstVsArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArraysAsListVs {
    public static void main(String[] args) {
        /*
          1)  Используя метод Arrays.asList() мы преобразовываем массив в щбьект List. Это список является оболочкой,
         которая делает массив доступным ввиде списка. Ни какие данные не копируются и не создаются. Добавление и
         удаление запрещеноБ попытки приведут к java.lang.UnsupportedOperationException. Однако мы можем изменять
         отдельные элементы. Но надо обратить внимание на точно измениться исходный массив.
         */
        String[] stringArray = new String[] {"A", "B", "C", "D"};
        List<String> stringList = Arrays.asList(stringArray);
        //заменим элемент
        stringList.set(0, "E");
        //Видно что исходный массив тоже изменился
        System.out.println("StringArray: " + Arrays.toString(stringArray)+ "\nStringList: " + stringList);
        //Добавление и удаление элементов вызовет исключение java.lang.UnsupportedOperationException.
        //stringList.add("F");

        /*
            2) Мы можем использовать ArrayList<>(Arrays.asList(array)) этот вариант создаст независимую копию,
         это означает что наш иходный массив не измениться и нам будут доступна возмножность добавление и удаление
         элементов.
         */
        String[] stringArray2 = new String[]{"A", "B", "C", "D"};
        List<String> stringList2 = new ArrayList<>(Arrays.asList(stringArray2));
        //заменим элемент
        stringList2.set(0, "E");
        //теперь нам доступна возможность добавлять и удалять обьекты
        stringList2.add("F");
        //видно что исходный массив остался нетронутым
        System.out.println("StringArray: " + Arrays.toString(stringArray2)+ "\nStringList: " + stringList2);
    }
}
