

public class MyArrayList <T>{
    private int size;
    private Object[] elements;

    public MyArrayList() {
        elements = new Object[10];
    }
    public T get(int index){
        if (index > size){
            throw new IndexOutOfBoundsException("Index is not correct. Array out of bounds");
        }else {
            return (T) elements[index];
        }
    }
    public void add(T element){
        if (size < elements.length){
            elements[size] = element;
            size++;
        }else {
           Object [] newArr = new Object[size + 10];
           elements = copy(elements, newArr);
            elements[size] = element;
            size++;
        }
    }
    private Object[] copy(Object[] in, Object[] to){
        for (int i = 0; i < in.length; i++) {
            in[i] = to[i];
        }
        return to;
    }
    public void remove(int index){
        if (size < index){
            throw new IndexOutOfBoundsException("Index is not correct.");
        }else {
            elements[index] = null;
            size--;
        }
    }
    public int size(){
        return size;
    }
}
