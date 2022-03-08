package data_structure.stack;

/**
 * @author menmenz
 * @version 1.0
 * @date 2022/2/24 3:20 PM
 */
public class MinHeap {
    private int[] heap;

    public MinHeap(int[] heap){
        this.heap = heap;
        buildHeap();
    }

    public void buildHeap() {
        for(int i = heap.length/2 - 1; i >= 0; i--) {
            int smallest = i;
            if (left(i)< heap.length && heap[left(i)] < heap[smallest])
                smallest = left(i);
            if (right(i) < heap.length && heap[right(i)] < heap[smallest])
                smallest = right(i);
            if (smallest == i) break;
            swap(smallest, i);
            heapify(smallest);
        }
    }

    public void heapify(int k) {}

    public int left(int k) {
        return k<<1 + 1;
    }

    public int right(int k) {
        return (k + 1) << 1;
    }

    public void swap(int i, int j) {

    }

    public int getRoot() {
        return 0;
    }

    public void setRoot(int v) {}
}
