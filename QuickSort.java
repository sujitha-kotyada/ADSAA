//Quick Sort Program for sorting the given elemts
class QuickSort{
	static int[] a;
	static int partition(int low,int high){
		int pivot=a[low];
		int i=low+1;
		int j=high;
		while(i<=j){
			while(i<=high && a[i]<=pivot)
				i++;
			while(a[j]>pivot)
				j--;
			if(i<j){
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		a[low]=a[j];
		a[j]=pivot;
		return j;
	}
	static void quickSort(int low,int high){
		if(low<high){
			int j=partition(low,high);
			quickSort(low,j-1);
			quickSort(j+1,high);
		}
	}
	public static void main(String[] args){
		a=new int[] {1,3,2,8,6,4,9};
		System.out.println("Before Sorting:");
		for(int x:a)
			System.out.print(x + " ");
		quickSort(0,a.length-1);
		System.out.println("\nAter Sorting:");
		for(int x:a)
			System.out.print(x + " ");
	}
}
		
			
			
