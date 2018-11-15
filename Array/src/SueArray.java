public class SueArray<E> {
    private E[] data;
    private int size;

    //constructor:using parameter capacity to construct SueArray
    public SueArray (int capacity) {
        data = (E[])new Object[capacity];
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



    //add an element e at any position Index of the array
    public void addIndex(int index,E e){

        if(index <0 || index>=data.length){
            throw new IllegalArgumentException("AddIndex failed. Require index >= 0 and index <= size");
        }

        if(size == data.length)
            resize(2 * data.length);

        for(int i = size; i>index; i--){
            data[i]=data[i-1];
        }

        data[index]=e;
        size++;
    }

    //add an element e at the end of the array
    public void addLast(E e){
        if(size == data.length)
            throw new IllegalArgumentException("AddLastFailed. Arrayisfull.");

        data[size] = e;
        size++;
    }

    //add an element e at the beginning of the array
    public void addFirst(E e){
        addIndex(0,e);
    }

    //the the element of the input index
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is  illegal.");
        return data[index];
    }

    //modify the element by given index and value
    void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is  illegal.");
        data[index] = e;
    }

    //check if e exists in this array
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            //equals(): compare values
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //check if e exists in this array, and return its index
    //if e does not exist, return -1
    public int find(E e){
        for(int i = 0; i < size; i++){
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //remove value in given index
    //return its element
    public E removeIndex(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is  illegal.");
        E ret = data[index];

        for(int i = index + 1; i < size; i++){
            data[i - 1] = data[ i ];
        }

        size --;
        data[size] = null; // loitering objects != memory leak

        if(size == data.length / 4 && data.length != 0)
            resize(data.length / 2);

        return ret;
    }

    //remove the first element in the array, return its value
    public E removeFirst(){
        return removeIndex(0);
    }

    //remove the last element in the array, return its value
    public E removeLast(){
        return removeIndex(size - 1);
    }

    //remove the first element e from the array
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            removeIndex(index);
        }

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


    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
