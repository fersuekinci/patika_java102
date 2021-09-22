import java.util.Arrays;

public class MyList <T> {

    private T[] list;
    private int size = 0;
    private int capacity = 10;

    public MyList() {
        this.list = (T[]) new Object[10];
    }

    public MyList(int capacity) {
       this.list = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void add(T data) {
        if(this.size==getCapacity()) {
            this.capacity *= 2;
            this.list = Arrays.copyOf(this.list,this.capacity);
        }
        this.list[this.size++] = data;
    }

    public T get(int index) {
        if(index<0 || index>this.size) {
            return null;
        }
        else {
            return this.list[index];
        }
    }

    public void remove(int index) {
        if(index<0 || index>this.size) {
            System.out.println("null");
        }
        else {
            for(int i=index; i<this.size; i++) {
                this.list[i] = this.list[i+1];
            }
            this.size--;
        }
    }

    public void set(int index, T data) {
        if(index<0 || index>this.size) {
            System.out.println("null");
        }
        else {
            list[index] = data;
        }
    }

    public String toString(){
        String str = "[";
        for(int i=0; i<this.size; i++) {
            str += list[i];
            if(i != this.size-1) {
                str += (" , ");
            }
        }
        str += "]";
        return str;
    }

    public int indexOf(T data) {
        for(int i=0; i<this.size; i++) {
            if(this.list[i] == data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for(int i=this.size; i>0; i--) {
            if(this.list[i] == data){
                return this.size-i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if(this.size == 0){
            return true;
        }
        else
            return false;
    }

    public T[] toArray() {
        Object array = Arrays.copyOf(this.list,this.size);
        return (T[]) array;
    }

    public void clear() {
        this.size=0;
    }

    public MyList<T> subList(int start, int finish) {
        int size = finish - start +1;
        MyList<T> sublist = new MyList<>(size);

        for(int i = start; i<finish; i++) {
            sublist.add(list[i]);
        }
        return sublist;
    }

    public boolean contains(T data) {
        for(Object o : this.list) {
            if(o == data){
                return true;
            }
        }
        return false;
    }
}
