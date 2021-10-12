
public class JumpToTheFlag {
public static void main(String[] args) {
//	int height=8,jump=3;
	System.out.println(jump(8,3));
}
public static int  jump(int flagHeight,int bigJump) {
	Integer[] dp=new Integer[flagHeight+1];
	      dp[flagHeight] = 0;
	      for (int i = flagHeight - 1; i >= 0; i--) {
	            int min = Integer.MAX_VALUE;
	            for (int j = 1; j <= bigJump && i + j < dp.length; j++) {
	               if(dp[i + j] != null){
	                  min = Math.min(min, dp[i + j]);
	               }
	            }

	            if(min != Integer.MAX_VALUE){
	               dp[i] = min + 1;
	            }
	         
	      }

	     return dp[0];
}
}
