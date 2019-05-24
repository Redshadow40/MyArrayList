package com.practice.aria;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MyArrayList<String> test = new MyArrayList<>();

        for (int i = 0; i < 10241; i++){
            test.add("Test");
            //System.out.println(test.size());
        }
        
        System.out.println(test.size());
        System.out.println(test.actualSize());

        
    }
}
class MyArrayList<T> {
    private Object[] myArray;
    private int arraySize = 0;

    public MyArrayList() {
        this.myArray = new Object[10];
        this.arraySize = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= this.arraySize){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return (T)this.myArray[index];
        }
    }

    public void add(T item) {
        if (this.arraySize == this.myArray.length) {
            increaseListSize();
        }
        this.myArray[arraySize++] = item;
    }

    public int size() {
        return this.arraySize;
    }

    public int actualSize() {
        return this.myArray.length;
    }

    public void increaseListSize() {
        System.out.println("resizing");
        Object[] tmp = new Object[this.myArray.length * 2];
        for (int i = 0; i < this.myArray.length; i++) {
            tmp[i] = this.myArray[i];
        }
        this.myArray = tmp;
    }
}