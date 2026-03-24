public class MinCostPath{
    public static void main(String[] args) {
        int cost[][]={{1,2,3},{4,8,2},{1,5,3}};
        int res=findmincost(cost,cost.length,cost[0].length);
        System.out.println(res);
    }
    private static int findmincost(int cost[][],int m,int n){
        int dp[][]=new int[m][n];
        dp[0][0]=cost[0][0];
        for(int i=1;i<m;i++) dp[0][i]=dp[0][i-1]+cost[0][i];
        for(int i=1;i<n;i++) dp[i][0]=dp[i-1][0]+cost[i][0];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+cost[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}