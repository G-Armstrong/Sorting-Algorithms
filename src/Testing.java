import java.util.ArrayList;
import java.util.Random;

public class Testing {
	public static final int SIZE = 10000;
	public static void main(String[] args) {
		ArrayList<Integer> randomList = new ArrayList<>();
		ArrayList<Integer> sortedList = new ArrayList<>();
		ArrayList<Integer> reversedList = new ArrayList<>();
		int[][] output = new int[3][6];
		
		Random r = new Random();
		for (int i=0; i<SIZE; i++) {
			int num = r.nextInt(SIZE) + 1;
			randomList.add(num); 
		}
		
		sortedList = (ArrayList<Integer>) randomList.clone();
		java.util.Collections.sort(sortedList);
		
		reversedList = (ArrayList<Integer>) sortedList.clone();
		java.util.Collections.reverse(reversedList);
	//	------------------------------------------------------------------------
		Sort.selectionSort(randomList);
		java.util.Collections.shuffle(randomList);
		Sort.insertionSort(randomList);
		java.util.Collections.shuffle(randomList);
		Sort.bubbleSort(randomList);
		java.util.Collections.shuffle(randomList);
		Sort.mergeSort(randomList);
		java.util.Collections.shuffle(randomList);
		Sort.quickSort(randomList);
		java.util.Collections.shuffle(randomList);
		Sort.heapSort(randomList);
		for(int i=0;i<6;i++) {
			output[0][i] = Sort.iterations[i];
			Sort.iterations[i] = 0;
		}
		Sort.selectionSort(sortedList);
		Sort.insertionSort(sortedList);
		Sort.bubbleSort(sortedList);
		Sort.mergeSort(sortedList);
		Sort.quickSort(sortedList);
		Sort.heapSort(sortedList);
		for(int i=0;i<6;i++) {
			output[1][i] = Sort.iterations[i];
			Sort.iterations[i] = 0;
		}
		System.out.println(reversedList);
		Sort.selectionSort(reversedList);
		System.out.println(reversedList);
		java.util.Collections.reverse(reversedList);
		Sort.insertionSort(reversedList);
		java.util.Collections.reverse(reversedList);
		Sort.bubbleSort(reversedList);
		java.util.Collections.reverse(reversedList);
		Sort.mergeSort(reversedList);
		java.util.Collections.reverse(reversedList);
		Sort.quickSort(reversedList);
		java.util.Collections.reverse(reversedList);
		Sort.heapSort(reversedList);
		for(int i=0;i<6;i++) {
			output[2][i] = Sort.iterations[i];
		}
		
		
		
		
		String[] algorithms = {"Selection Sort", "Insertion Sort", "Bubble Sort", 
				"Merge Sort", "Quick Sort", "Heap Sort"};
		System.out.println("Comparing Sorting Algorithms for data sets with 10000 integers " + "\n");
		System.out.printf("%-30s\t%-20s\t%-20s\t%-20s\n", "Sorting Algorithm", "Random List", "Sorted List", "ReversedList");
		for (int i=0; i<Sort.iterations.length; i++) {
			System.out.printf("%-30s\t%-20s\t%-20s\t%-20s\n", algorithms[i], output[0][i],output[1][i], output[2][i]);	
		}
		
	
	}
	/**
	 * Discussion: 
	 * 1) The performance of each sorting algorithm on the different data sets
	 * 
	 * 	Selection sort has the same poor performance on each data set. This demonstrates the quadratic growth of selection sort as it compares and appends min items to the
	 * new list with 2 for loops. 
	 * 
	 * Insertion sort performs best on sorted list but worst on reversed list. If the list is presorted, the algo will just append all elements but the first (which 
	 * is inserted at 0 to begin with) to the new list with 9999 iterations. If the list is reversed or randomized, the algo's quadratic time complexity will take millions of iterations 
	 * to insert list elements at the proper location in the new list. 
	 * 
	 * Bubble sort best on the sorted list because the list is presorted. randomized and reversed lists have to be iterated through millions of times to compare elements to one another
	 * to make sure the smallest comes first in a pair
	 * 
	 * Merge sort performs constantly on all 3 data sets. This is because the deep copied, partial lists it creates can be sorted and recombined in the same manner regardless of the oringal
	 * data.
	 * 
	 * Quick sort performs best on the random list and poorly on reversed and sorted lists. Sorting the list in ascending or descending order beforehand thereby applying a structure onto it takes a long time for the algo to make sublists
	 * around the pivot where as in the random list there is no predetermined sturcture for the data. 
	 * 
	 * Heap sort performs well on all three data sets with low iterations in all categories. The elements are inserted into a heap and properties of the heap are maintained the same way throughout
	 * all data sets. It operates atlog linear time complexity O(n log n), which is much more time efficient than quadratic.
	 * 
	 * 2) Compare the performance of the sorting algorithms to each other.
	 * 
	 * Merge sort has the lowest iterations in all categories and wins. Selection sort has the highest number of iterations in all categories and is the slowest. Insertion sort beats all other algos with the lowest overall iterations in this 
	 * category. Heap sort is the second best. Merge sort, quick sort, and heap sort are operating at log linear time complexity
	// O(n log n), which is much more time efficient than the quadratic O(n^2) time complexity of Selection Sort, Insertion Sort, and Bubble Sort. Quick sort has the ability to peform as well as the other linear algos as long as the data is randomized. 
	 */

}
