public class ArrayDeque<T>{
    private T items[];
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size=0;
        nextFirst=4;
        nextLast=5;
    }
    public void addFirst(T x){
        if(size==items.length)
            resize(size*2);
        items[nextFirst]=x;
        nextFirst=Math.floorMod(--nextFirst,items.length);
        size=size+1;
    }
    private void resize(int capacity){
        if(capacity>=8) {
            T[] a = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++)
                a[i] = get(i);
            nextFirst = capacity - 1;
            nextLast = size;
            items = a;
        }
    }
    public void addLast(T x){
        if(size==items.length)
            resize(size*2);
        items[nextLast]=x;
        nextLast=Math.floorMod(++nextLast,items.length);
        size=size+1;
    }
    public boolean isEmpty(){return size==0;}
    public int size(){return size;}
    public void printDeque() {
        if (!isEmpty()) {
            int n = size - 1;
            int i = Math.floorMod(nextFirst + 1, items.length);
            System.out.print(items[i]);
            i = Math.floorMod(i + 1, items.length);
            while (n > 0) {
                System.out.println(" " + items[i]);
                i = Math.floorMod(i + 1, items.length);
                n = n - 1;
            }
        }
    }
    public T removeFirst(){
        if(((float)size/items.length)<0.25)
            resize(items.length/2);
        if(!isEmpty()){
            T res=items[Math.floorMod(++nextFirst,items.length)];
            nextFirst=Math.floorMod(nextFirst,items.length);
            items[nextFirst]=null;
            size=size-1;
            return res;
        }
        else
            return null;
    }
    public T removeLast(){
        if(((float)size/items.length)<0.25)
            resize(items.length/2);
        if(!isEmpty()){
            T res=items[Math.floorMod(--nextLast,items.length)];
            nextLast=Math.floorMod(nextLast,items.length);
            items[nextLast]=null;
            size=size-1;
          return res;
        }
        else
          return null;
    }
    public T get(int i){
        if(i>size-1||i<0)
            return null;
        else
            return items[Math.floorMod(nextFirst+1+i,items.length)];
    }
}