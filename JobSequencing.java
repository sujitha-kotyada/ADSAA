// Job Sequencing with Deadlines
import java.util.*;
class Job{
    String id;
    int deadline;
    int profit;
    Job(String id,int deadline,int profit){
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
public class JobSequencing{
    public static void JobSequencing(Job[] jobs){
           Arrays.sort(jobs,(a,b) -> b.profit-a.profit);
           int maxDeadline=0;
           for(Job job : jobs){
              if(job.deadline > maxDeadline)
                   maxDeadline=job.deadline;
           }
           boolean[] slot=new boolean[maxDeadline];
           String[] result=new String[maxDeadline];
           int totalProfit=0;
           for(Job job: jobs){
              for(int j = Math.min(maxDeadline,job.deadline)-1;j>=0;j--){
                  if(!slot[j]){
                  	slot[j]=true;
                  	result[j]=job.id;
                  	totalProfit+=job.profit;
                  	break;
                  }
              }
           }
           System.out.println("Job Sequence: ");
           for(String r: result){
               if(r!=null)
                   System.out.print(r+"	");			
           }
           System.out.println("\n Total Profit: "+totalProfit);
    }
    public static void main(String[] args){
          Job[] jobs={
                 new Job("J1",2,100),
                 new Job("J2",1,19),
                 new Job("J3",2,27),
                 new Job("J4",1,25),
                 new Job("J5",3,15),
         };
         JobSequencing(jobs);
    }
}
