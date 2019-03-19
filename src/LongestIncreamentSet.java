import java.util.Scanner;

public class LongestIncreamentSet
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();
            int []data=new int[n];
            for(int i=0;i<n;i++)
                data[i]=scan.nextInt();


            System.out.println(get(data));
        }
    }
    public static int get(int []data){
        int n=data.length;
        int []dp=new int[n];
        for(int i=0;i<n;i++){
            int tem=1;
            for(int j=0;j<i;j++){
                if(data[j]>=data[i]){  /////这里求出的是最常递减子序列，求最长递增子序列只需把>=换成<=
                    tem=Math.max(tem,dp[j]+1);
                }
            }
            dp[i]=tem;
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
