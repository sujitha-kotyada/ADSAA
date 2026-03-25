import java.util.*;
public class Knapsack{
	static int n =4;
	static int w = 16;
	static int[] weight = {2,5,10,5};
	static int[] profit = {40,30,50,10};
	static int maxProfit=0;
	static void knapsack(int i,int currentw,int currentp){
		if(currentw<=w&& currentp>maxProfit){
			maxProfit = currentp;
		}
		if(i<n){
			knapsack(i+1,currentw+weight[i],currentp+profit[i]);
			knapsack(i+1,currentw,currentp);
		}
	}
	public static void main(String args[]){
		knapsack(0,0,0);
		System.out.println("maximum profit="+maxProfit);
	}
}					
