//implementing Travelling sales Person problem
import java.util.*;
public class TSPB{
	static int N;
	static int final_res=Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] cost;
	static void tsp(int curpos,int count,int curcost){
		//Base case
		if(count==N && cost[curpos][0]>0){
			int total=curcost+cost[curpos][0];
			final_res=Math.min(final_res,total);
			return;
		}
		for(int i=0;i<N;i++){
			if(!visited[i] && cost[curpos][i]>0){
				int newcost=curcost+cost[curpos][i];
				//Bounding condition
				if(newcost<final_res){
					visited[i]=true;
					tsp(i,count+1,newcost);
					visited[i]=false;
				}
			}
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of cities:");
		N=sc.nextInt();
		cost=new int[N][N];
		visited=new boolean[N];
		System.out.println("Enter cost");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				cost[i][j]=sc.nextInt();
			}
		}
		visited[0]=true;
		tsp(0,1,0);
		System.out.println("Mininmum cost "+final_res);
	}
}
