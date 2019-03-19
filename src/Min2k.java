import java.util.Arrays;
import java.util.Scanner;

public class Min2k
{
    /*n件物品中，选出2k件，使得从小到大的两个平方和的总和最小
    * 如1，3，4，5，6，选出4个
    * 3，4，5，6
    * （4-3）*（4-3）+（6-5）*（6-5）*/
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();
            int k=scan.nextInt();
            int []data=new int[n+1];
            for(int i=1;i<n+1;i++){
                data[i]=scan.nextInt();
            }
            System.out.println(get(n,k,data));
        }

    }
    public static int get(int n,int k,int []data){
        Arrays.sort(data);
        int [][]dp=new int[k+1][n+1];
        for(int i=0;i<n+1;i++)
            dp[0][i]=0;

        for(int i=1;i<=k;i++)
            for(int j=2*i;j<=n;j++){
                if(j>2*i)
                    dp[i][j]=dp[i][j-1];
                else
                    dp[i][j]=Integer.MAX_VALUE;

                if(dp[i][j]>(dp[i-1][j-2]+(data[j]-data[j-1])*(data[j]-data[j-1])))
                    dp[i][j]=dp[i-1][j-2]+(data[j]-data[j-1])*(data[j]-data[j-1]);
        }
        return dp[k][n];
    }
}
