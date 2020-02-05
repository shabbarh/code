public class LinkedListDeque<Boom>{
    private class Node{
        Boom item;
        Node prev;
        Node next;
        public Node(Boom x, Node p, Node n){
            item = x;
            prev =p;
            next =n;
        }
    }
    private Node fsentinal;
    private Node bsentinal;
    private int size;
    public LinkedListDeque(){
        fsentinal=new Node(null,null,null);
        bsentinal=new Node(null,fsentinal,null);
        fsentinal.next=bsentinal;
        size=0;
    }
    public void addFirst(Boom x){
        fsentinal.next=new Node(x,fsentinal,fsentinal.next);
        fsentinal.next.next.prev=fsentinal.next;
        size+=1;
    }
    public void addLast(Boom x){
        bsentinal.prev=new Node(x,bsentinal.prev,bsentinal);
        bsentinal.prev.prev.next=bsentinal.prev;
        size+=1;
    }
    public boolean isEmpty(){
        if(size>0)
            return false;
        else
            return true;
    }
    public int size(){
        return size;
    }
    public Boom get(int i) {
        if (size - 1 >= i) {
            Node p = fsentinal.next;
            while (i != 0) {
                p = p.next;
                i--;
            }
            return p.item;
        } else
            return null;
    }
    public Boom removeFirst () {
        if (size > 0) {
            Boom x = fsentinal.next.item;
            fsentinal.next = fsentinal.next.next;
            fsentinal.next.prev = fsentinal;
            size = -1;
            return x;
        } else
            return null;
    }
    public Boom removeLast () {
       if (size > 0) {
           Boom x = bsentinal.prev.item;
           bsentinal.prev = bsentinal.prev.prev;
           bsentinal.prev.next = bsentinal;
           size -= 1;
           return x;
       }
       else
           return null;
    }
    public void printDeque() {
        if (size > 0) {
            Node p = fsentinal.next;
            System.out.print(p.item);
            p = p.next;
            while (p.next != null) {
                System.out.print(" " + p.item);
                p = p.next;
            }
        }
        else
            return;
    }
}