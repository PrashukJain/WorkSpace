package assignment;

public class JumpToTheFlag {
public static void main(String[] args) {
//	int height=8,jump=3;
	System.out.println(jump(622650074,984943659));
}
public static long jump(int flagHeight,int bigJump) {
	if(bigJump>flagHeight)
		return flagHeight;
	Long[] dp=new Long[flagHeight+1];
	      dp[flagHeight] = (long) 0;
	      for (int i = flagHeight-1; i >= 0; i--) {
	                long min =  dp[i + 1];
	      if(i+bigJump<dp.length)
	    	  min=Math.min(min, dp[i + bigJump]);

	            if(min != Long.MAX_VALUE){
	               dp[i] = min + 1;
	            }
	         
	      }
	      
	     return dp[0];
}
}
