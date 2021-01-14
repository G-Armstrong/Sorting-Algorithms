 import java.util.ArrayList;

public class Sort {
	public static int[] iterations = new int[6];
	/**
	 * Generic selection sort
	 * @param <E> Generic type
	 * @param list of type E
	 */
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) { 
		int minIndex; 
		for (int i=0; i<list.size()-1; i++) {
			iterations[0]++;
			E min = list.get(i);      
			minIndex = i;     
			for (int j=i; j<list.size(); j++){
				iterations[0]++;
				if (list.get(j).compareTo(min) < 0){          
					min = list.get(j);          
					minIndex = j;       
				}     
			}     
			swap(list, i, minIndex);
		}     
	}
	/**
	 * Generic swap method to automate rebalancing of heap
	 * @param <E> generic type
	 * @param list containing the heap
	 * @param i to be swapped with j
	 * @param j to be swapped with i
	 */
	public static <E> void swap(ArrayList<E> list, int i, int j ) {
		E temp = list.get(i);     
		list.set(i,list.get(j));       
		list.set(j,temp);
	}
	/**
	 * Generic Insertion Sort
	 * @param <E> generic type
	 * @param list to be sorted
	 */
	public static <E extends Comparable<E>>void insertionSort(ArrayList<E> list) { 
		for (int i=1; i<list.size(); i++) {  
			iterations[1]++;
			//Insert element i in the sorted sub-list 
			E currentVal = list.get(i);
			int j = i; 
			while (j > 0 && currentVal.compareTo(list.get(j -1)) < 0)   { 
				iterations[1]++;
				// Shift element (j-1) into element (j) 
				list.set(j, list.get(j-1)); 
				j--; 
			} 
			// Insert currentVal at position i  
			list.set(j, currentVal); 
		}
	}
	
	/**
	 * Generic Bubble Sort
	 * @param <E> generic type
	 * @param list to be sorted
	 */
	public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {  
		boolean sorted = false;  
		for (int k=1;k < list.size() && !sorted; k++) {    
			sorted = true;    
			iterations[2]++;
			for (int i=0; i<list.size()-k; i++) {  
				iterations[2]++;
				if (list.get(i).compareTo(list.get(i+1)) > 0) {         
					// swap 
					swap(list,i,i+1);
					sorted = false;      
				}    
			} 
		}
	}
	
	/**
	 * Generic Merge Sort
	 * @param <E>generic type
	 * @param list to be sorted
	 */
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		iterations[3]++;
		if (list.size() > 1) { // base case 
			ArrayList<E> firstHalf = new ArrayList<E>(list.size()/2); 
			ArrayList<E> secondHalf = new ArrayList<E>(list.size() - list.size()/2); 
			firstHalf = subList(list,0,list.size()/2);
			secondHalf = subList(list,list.size()/2,list.size());
//			System.arraycopy(list, 0, firstHalf, 0, list.size()/2); 
//			System.arraycopy(list,  list.size()/2,secondHalf, 0,list.size()-list.size()/2);
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list);  
		}
	}
	
	public static <E> ArrayList<E> subList(ArrayList<E> list, int start, int end){
		ArrayList<E> output = new ArrayList<>();
		for(int i=start;i<end;i++) {
			output.add(list.get(i));
		}
		return output;
		
	}
	
	/**
	 * Generic
	 * @param <E> generic type
	 * @param list1 merge component 1
	 * @param list2 merge component 2
	 * @param list final list
	 */
	public static <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2,ArrayList<E> list) {
		int list1Index = 0;
		int list2Index = 0;
		int listIndex = 0;
		while( list1Index < list1.size() && list2Index < list2.size()) {
			iterations[3]++;
			if (list1.get(list1Index).compareTo(list2.get(list2Index)) < 0)
				list.set(listIndex++,list1.get(list1Index++));
			else
				list.set(listIndex++,list2.get(list2Index++));
		}
		while(list1Index < list1.size()) {
			list.set(listIndex++, list1.get(list1Index++));
			iterations[3]++;
		}
			
		while(list2Index < list2.size()) {
			list.set(listIndex++, list2.get(list2Index++));
			iterations[3]++;
		}
			
	}
	
	/**
	 * Generic Quick Sort with 1 para
	 * @param <E> generic type
	 * @param list final list
	 */
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
		quickSort(list, 0, list.size()-1);
	}
	/**
	 * Recursive, Generic Quick Sort with 3 params
	 * @param <E> generic type
	 * @param list to be sorted
	 * @param first index close to pivot
	 * @param last index
	 */
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list,int first, int last) {
		iterations[4]++;
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex-1);
			quickSort(list, pivotIndex+1, last);
		}
	}
	/**
	 * Helper method for quickSort to return pivot index
	 * @param <E> generic method
	 * @param list to be sorted
	 * @param first index for the pivot
	 * @param last index for the pivot
	 * @return pivot index for continued sorting
	 */
	public static <E extends Comparable<E>> int partition(ArrayList<E> list,int first, int last){ 
		E pivot; 
		int index, pivotIndex; 
		pivot = list.get(first);// pivot is the first element 
		pivotIndex = first; 
		for (index = first + 1;index <= last; index++) {  
			iterations[4]++;
			if (list.get(index).compareTo(pivot) < 0){      
				pivotIndex++;
				swap(list, pivotIndex, index);   
			}
		}
		swap(list, first, pivotIndex); 
		return pivotIndex;
	}
	
	/**
	 * Generic Heap Sort
	 * @param <E>generic type
	 * @param list final list
	 */
	public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
		Heap<E> heap = new Heap<>(list);//add()
		for (int i=list.size()-1; i>=0; i--) {
			iterations[5]++;
			list.set(i,heap.remove()); 
		}
	}
	
}
	
	
		
	

		
