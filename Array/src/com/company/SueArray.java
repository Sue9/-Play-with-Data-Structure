package com.company;

public class SueArray {
    private int[] data;
    private int size;

    //constructor:using parameter capacity to construct SueArray
    public SueArray (int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //constructor with no argument
    public SueArray(){
        this(10);
    }

    //get the number of elements
    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    //check if the array data is empty
    public boolean isEmpty(){
        return size == 0;
    }

    //add an element e at the end of the array
    public void addLast(int e){
        if(size == data.length)
            throw new IllegalArgumentException("AddLastFailed. Arrayisfull.");

        data[size] = e;
        size++;
    }

    //add an element e at the beginning of the array
    public void addFirst(int e){
        addIndex(0,e);
    }

    //add an element e at any position Index of the array
    public void addIndex(int index,int e){
        if(size == data.length)
            throw new IllegalArgumentException("AddIndexFailed. Array is full.");


        if(index <0 || index>=data.length){
            throw new IllegalArgumentException("AddIndex failed. Require index >= 0 and index <= size");
        }

        for(int i = size; i>index; i--){
            data[i]=data[i-1];
        }

        data[index]=e;
        size++;
    }

    //the the element of the input index
    int get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is  illegal.");
        return data[index];
    }

    //modify the element by given index and value
    void set(int index, int e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is  illegal.");
        data[index] = e;
    }

    //check if e exists in this array
    public boolean contains(int e){
        for(int i = 0; i < size; i++){
            if (data[i] == e)
                return true;
        }
        return false;
    }

    //check if e exists in this array, and return its index
    //if e does not exist, return -1
    public int find(int e){
        
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i++)
        {
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");

        }
        res.append(']');
        return res.toString();
    }

}
