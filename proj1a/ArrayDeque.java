public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        first = 0;
        last = 1;
    }


    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = get(i);
        }
        first = capacity - 1;
        last = size;
        items = a;
    }


    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[Math.floorMod(first, items.length)] = item;
        first = Math.floorMod(--first, items.length);
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[Math.floorMod(last, items.length)] = item;
        last = Math.floorMod(++last, items.length);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int pos = 0;
        int i = first + 1;
        while (pos < size - 1) {
            System.out.print(items[Math.floorMod(i++, items.length)] + " ");
            pos += 1;
        }
        System.out.println(items[Math.floorMod(i, items.length)]);
    }

    public T removeFirst() {
        if (((float) size / items.length) <= 0.25) {
            resize(items.length / 2);
        }

        if (isEmpty()) {
            return null;
        } else {
            size -= 1;
            T item = items[Math.floorMod(++first, items.length)];
            first = Math.floorMod(first, items.length);
            items[first] = null;
            return item;
        }
    }

    public T removeLast() {
        if (((float) size / items.length) <= 0.25) {
            resize(items.length / 2);
        }
        if (isEmpty()) {
            return null;
        } else {
            size -= 1;
            T item = items[Math.floorMod(--last, items.length)];
            last = Math.floorMod(last, items.length);
            items[last] = null;
            return item;
        }
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return items[Math.floorMod(first + 1 + index, items.length)];
    }
}

