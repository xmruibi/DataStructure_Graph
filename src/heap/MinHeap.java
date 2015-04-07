package heap;

import java.util.NoSuchElementException;
import java.util.Random;

public class MinHeap {

	private int[] arr;
	private int size;
	private int curPtr;

	public MinHeap(int size) {
		this.arr = new int[size];
		this.size = 0;
		this.curPtr = 0;
	}

	private void add(int num) {
		if (curPtr == (arr.length - 1))
			arr[curPtr] = num; // remove the last (largest one)
		else
			arr[++curPtr] = num;
		swim(curPtr);
	}

	private int popMin() {
		if (curPtr == 0)
			throw new NoSuchElementException(" No Element");
		int pop = arr[1];
		arr[1] = arr[curPtr--];
		sink(1);
		return pop;
	}

	private void sink(int idx) {

		while (idx * 2 < curPtr) {
			int child = idx * 2;
			if (child < curPtr && (arr[child] > arr[idx]))
				child++;
			if(arr[child] > arr[idx])
				return;
			int tmp = arr[idx];
			arr[idx] = arr[child];
			arr[child] = tmp;
			idx = child;
		}
	}

	private void swim(int idx) {
		while (idx / 2 > 0) {
			int parent = idx / 2;
			if (arr[parent] <= arr[idx])
				return;
			int tmp = arr[idx];
			arr[idx] = arr[parent];
			arr[parent] = tmp;
			idx = parent;

		}
	}

	public static void main(String[] args) {
		MinHeap minheap = new MinHeap(6);
		Random r = new Random();
		int n = 10;
		while (n > 0) {
			minheap.add(r.nextInt(100));
			n--;
		}
		while (n <= 5) {
			System.out.println(minheap.popMin());
			n++;
		}

	}
}
