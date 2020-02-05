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
            enlarge();
        items[nextFirst]=x;
        setNextFirst(true);
        size=size+1;
    }
    private void setNextFirst(boolean add){
        if(add){
            if(nextFirst==0)
                nextFirst=items.length-1;
            else
                nextFirst=nextFirst-1;
        }
        else{
            if(nextFirst==items.length-1)
                nextFirst=0;
            else
                nextFirst=nextFirst+1;
        }
    }
    private void setNextLast(boolean add){
        if(add){
            if(nextLast==items.length-1)
                nextLast=0;
            else
                nextLast=nextLast+1;
        }
        else{
            if(nextLast==0)
                nextLast=items.length-1;
            else
                nextLast=nextLast-1;
        }
    }
    private int getFirstIndex(){
        if(nextFirst==items.length-1)
            return 0;
        else
            return nextFirst+1;
    }
    private int getLastIndex(){
        if(nextLast==0)
            return items.length;
        else
            return nextLast-1;
    }
    private void enlarge(){
        T a[]=(T[])new Object[size*2];
        int firstindex=getFirstIndex();
        int startindex=a.length/4; //start index of new array
        if(firstindex==0)
            System.arraycopy(items,0,a,startindex,size);
        else{
            int initialcopy = items.length-firstindex; System.arraycopy(items,firstindex,a,startindex,initialcopy);
            System.arraycopy(items,0,a,startindex+initialcopy,items.length-initialcopy);
        }
        nextFirst=startindex-1;
        nextLast=startindex+items.length;
        items=a;
    }
    private void shrink(){
        if(items.length==8)
            return;
        T a[] =(T[]) new Object[items.length/2];
        int firstindex=getFirstIndex();
        int startindex=a.length/4;
        if(firstindex==0)
            System.arraycopy(items,0,a,startindex,size);
        else{
            int initialcopy=items.length-firstindex;
            System.arraycopy(items,firstindex,a,startindex,initialcopy);
            System.arraycopy(items,0,a,startindex+initialcopy,size-initialcopy);
        }
        nextFirst=startindex-1;
        nextLast=startindex+size;
        items=a;
    }
    public void addLast(T x){
        if(size==items.length)
            enlarge();
        items[nextLast]=x;
        setNextLast(true);
        size=size+1;
    }
    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        if(size>0){
            int firstindex=getFirstIndex();
            int iterator=firstindex+1;
            int tempsize=size-1;
            System.out.print(items[firstindex]);
            while(tempsize>0 && iterator<items.length -1 ){
                System.out.print(" "+items [iterator]);
                iterator=iterator+1;
                tempsize=tempsize-1;
            }
            iterator=0;
            while(tempsize>0){
                System.out.print(" "+items[iterator]);
                iterator=iterator+1;
                tempsize=tempsize-1;
            }
        }
    }
    public T removeFirst(){
        if(size/items.length<0.25)
            shrink();
        if(size>0){
            int index=getFirstIndex();
            T res=items[index];
            items[index]=null;
            setNextFirst(false);
            size=size-1;
            return res;
        }
        else
            return null;
    }
    public T removeLast(){
        if(size/items.length<0.25)
            shrink();
        if(size>0){
            int index=getFirstIndex();
            T res=items[index];
            items[index]=null;
            setNextLast(false);
            size=size-1;
          return res;
        }
        else
          return null;
    }
    public T get(int i){
        if(i>size-1)
            return null;
        else{
            int  index=getFirstIndex()+i;
            return items[index%(items.length)];
        }
    }
}