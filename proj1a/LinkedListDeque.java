public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, sentinel, sentinel);
        size = 0;
    }

    public void addFirst(T item) {
        if (size == 0) {
            sentinel = new Node(null, sentinel, sentinel);
            sentinel.next = new Node(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            Node temp = new Node(item, sentinel, sentinel.next);
            sentinel.next.prev = temp;
            sentinel.next = temp;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (size == 0) {
            sentinel = new Node(null, sentinel, sentinel);
            sentinel.next = new Node(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            Node temp = new Node(item, sentinel.prev, sentinel);
            sentinel.prev.next = temp;
            sentinel.prev = temp;
        }
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr.next != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println(ptr.item);
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            Node temp = sentinel.next;
            sentinel.prev = null;
            sentinel.next = null;
            size -= 1;
            return temp.item;
        } else {
            size -= 1;
            Node temp = sentinel.next;
            sentinel.next = temp.next;
            temp.next.prev = sentinel;
            return temp.item;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            Node temp = sentinel.prev;
            sentinel.next = null;
            sentinel.prev = null;
            size -= 1;
            return temp.item;
        } else {
            size -= 1;
            Node temp = sentinel.prev;
            sentinel.prev = temp.prev;
            temp.prev.next = sentinel;
            return temp.item;
        }
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        } else {
            int position = 0;
            Node ptr = sentinel.next;
            while (position != index) {
                ptr = ptr.next;
                position++;
            }
            return ptr.item;
        }
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Node p) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursiveHelper(--index, p.next);
        }
    }

    private class Node {
        T item;
        Node prev;
        Node next;

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }


    }

}
