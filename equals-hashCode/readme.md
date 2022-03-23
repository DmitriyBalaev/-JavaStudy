# HashCode и Equals
## HashCode
 HaschCode - это числовое представление обьекта. Некоторые колекции используют 
хеширование для эффективного доступа к обьектам. 

### Контракт hashCode():

- Всякий раз, когда он вызывается для одного и того же обьекта
более одно раза во время выполнения приложения, функция hashCode() 
должна постоянно возвращать одно и то же значение, при уловии что ни какая информаци
используемая для сравнения равенства обьека не изменяется.
- Если два обьекта равны в соответствии с методами equals(Object) 
вызов метода для каждого из двух обьектов должен вернуть одно и тоже значение.
- Если два обьекта не равны в соответствии с методо equals(Object),
то метод hashCode() не обязательно должен выдввать разные значения
-----
Если не правильно реализовать hashCode() например

    @Override
    public int hashCode(){
        return 1;
    }

Эта реализация сводит к нулю всею функциональность, так как обьеты будут храниться
в одном и том же сегменте. Поиск в хеш-таблице будет производиться линейно.

-----
Однако ни один алгоритм не может гарантировать уникальность хеш-кода.
Из-за чего возникают колизии.
* [Различные методы обработки колизий](https://courses.cs.washington.edu/courses/cse373/18au/files/slides/lecture13.pdf)

После Java 8 были внесены усовершенствования в HashMap. Если размер корзины
превышает определенный порог, связанный список заменяется древовидной картой.
Это позволяет достич поиска O(logn) вместо O(n).
* [Обработка частых коллизий HashMap с помощью сбалансированных деревьев](https://openjdk.java.net/jeps/180)
-----
#### Реализации hashCode()

 - При помощи библиотеки Lombok

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.22</version>
            <scope>provided</scope>
        </dependency>

    Достаточно указать аннтотацию `@EqualsAndHashCode`
    
        @EqualsAndHashCode 
        public class Player{
            //конструкторы и методы
        }

 - При помощи Apache Commons Lang HashCodeBuilder
   
        <dependency>
            <groupId>commons-lang</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.12.0</version>
        <dependency>
 
    Реализовать так

        public class Player{
            public int hashCode(){
                return new HashCodeBuilder(17, 37)
                        .append(firstName)
                        .append(lastName)
                        .append(pozition)
                        .toHashCode();
            }
        }

----

----

## Equals()

Метод который работает в паре с hashCode() 

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(firstName, player.firstName) &&
                Objects.equals(lastName, player.lastName) &&
                Objects.equals(position, player.position);
      }

----
## Резюме

- Всегда переопределять hashCode(), если мы переопределяем equals().
- Переопределить  equals() и hashCode()  для объектов-значений.
-Контракт hashCode() и Equals():
  - Значение hashCode может меняться в том случае, если измениться
  значения в методе equals().
  - Обьекты которые равны, должны возвращать один и тот же хеш-код.
  - Не равные обьекты, могут возвращать один и тот же хеш-код.