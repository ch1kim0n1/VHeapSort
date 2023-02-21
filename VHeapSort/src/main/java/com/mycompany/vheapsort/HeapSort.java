package com.mycompany.vheapsort;
import java.util.ArrayList;
import static java.lang.System.*;

public class HeapSort {
	private ArrayList<Integer> list;

	public HeapSort() {
		list = new ArrayList<>();
	}

	private void swapUp(int index) {
		int parentIndex = (index - 1) / 2;

		if (index > 0 && list.get(index) > list.get(parentIndex)) {
			swap(index, parentIndex);
			swapUp(parentIndex);
		}
	}

	private void swapDown(int index) {
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;

		if (leftChildIndex >= list.size()) {
			return;
		}

		int maxIndex = leftChildIndex;
		if (rightChildIndex < list.size() && list.get(rightChildIndex) > list.get(leftChildIndex)) {
			maxIndex = rightChildIndex;
		}

		if (list.get(index) < list.get(maxIndex)) {
			swap(index, maxIndex);
			swapDown(maxIndex);
		}
	}

	public void heapSort(int[] nums) {
		list.clear();

		// Add the values from the array to the heap
		for (int num : nums) {
			list.add(num);
			swapUp(list.size() - 1);
		}

		// Sort the list to a separate structure
		ArrayList<Integer> sortedList = new ArrayList<>();
		while (!list.isEmpty()) {
			sortedList.add(list.get(0));
			list.set(0, list.get(list.size() - 1));
			list.remove(list.size() - 1);
			swapDown(0);
		}

		// Reassign the sorted structure to <list>
		list = sortedList;
	}

	private void swap(int first, int last) {
		int temp = list.get(first);
		list.set(first, list.get(last));
		list.set(last, temp);
	}

	public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        for (int i = list.size() - 1; i >= 0; i--)
        {
            sb.append(list.get(i));
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
