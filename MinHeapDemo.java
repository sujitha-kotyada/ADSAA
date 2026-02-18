/ Java Program that implements MinHeap using Arrays
import java.util.Scanner;

class MinHeap {
	private int[] a;
    	private int size;
    	private int capacity;

    	public MinHeap(int capacity) {
        		this.capacity = capacity;
        		a = new int[capacity + 1];   // 1-based indexing
        		size = 0;
    	}

    	public void insert(int item) {
        		if (size == capacity) {
            			System.out.println("Heap is full");
            			return;
       	 	}

        		int i = ++size;
        		while (i > 1 && item < a[i / 2]) {
            			a[i] = a[i / 2];
            			i = i / 2;
        		}
        		a[i] = item;
    	}

        	public int deleteMin() {
        		if (size == 0) {
            			System.out.println("Heap is empty");
            			return -1;
        		}

        		int min = a[1];
        		a[1] = a[size];
        		size--;
        		adjust(1);
        		return min;
    	}

    	// DOWNHEAP procedure
    	void adjust(int i) {
        		int j = 2 * i;
        		int item = a[i];

        		while (j <= size) {
            			if ((j < size) && (a[j] > a[j + 1]))
                			j++;   // select smaller child

            			if (item <= a[j]) break;

            			a[j / 2] = a[j];
            			j = 2 * j;
        		}
        		a[j / 2] = item;
    	}

    	public int findMin() {
        		if (size == 0)
            			return -1;
        		else
            			return a[1];
    	}

    	// Display heap elements (level order)
    	public void display() {
        		for (int i = 1; i <= size; i++) {
            			System.out.print(a[i] + " ");
        		}
        		System.out.println();
    	}
}

public class MinHeapDemo {
    	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

	        	System.out.print("Enter capacity of heap: ");
        		int capacity = sc.nextInt();

		MinHeap h = new MinHeap(capacity);

        		while (true) {
            			System.out.println("\n--- MIN HEAP MENU ---");
         			System.out.println("1. Insert");
            			System.out.println("2. Delete Min");
            			System.out.println("3. Find Min");
            			System.out.println("4. Display Heap");
            			System.out.println("5. Exit");
            			System.out.print("Enter your choice: ");

            			int choice = sc.nextInt();

           	 		switch (choice) {
                				case 1:
                    				System.out.print("Enter element to insert: ");
                   				int item = sc.nextInt();
                    				h.insert(item);
                    				break;
                				case 2:
                    				int deleted = h.deleteMin();
                    				if (deleted != -1) {
                        					System.out.println("Deleted Min: " + deleted);
                    				}
                    				break;
                				case 3:
                    				if (h.findMin() == -1) {
                        					System.out.println("Heap is empty");
                    				} else {
                        					System.out.println("Minimum element: " + h.findMin());
                    				}
                    				break;

                				case 4:
                    				System.out.print("Heap elements (Level Order): ");
                    				h.display();
                    				break;
                				case 5:
                    				System.out.println("Exiting program.");
                    				sc.close();
                    				System.exit(0);
                				default:
                    				System.out.println("Invalid choice!");
            			}
        		}
    	}
}
