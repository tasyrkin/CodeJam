package gcj2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SpaceEmergency {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer t = Integer.parseInt(br.readLine());
		int init = t;
		while (t-- > 0) {
			String[]parts = br.readLine().split("\\s+");
			int parCnt = 0;
			int L = Integer.parseInt(parts[parCnt++]);
			long t0 = Long.parseLong(parts[parCnt++]);
			int N = Integer.parseInt(parts[parCnt++]);
			int C = Integer.parseInt(parts[parCnt++]);
			int[]a = new int[C];
			int sum = 0;
			for(int i = 0; i < a.length; i++){
				a[i] = Integer.parseInt(parts[parCnt+i]);
				sum += a[i];
			}
			double dp[][] = new double[N+1][L+2];
			for(int i = 1; i < dp.length; i++){
				Arrays.fill(dp[i], Long.MAX_VALUE);
			}
			for(int i = 1; i <= N; i++){
				for(int j = 0; j <= L; j++){
					double time0 = dp[i-1][j];
					int idx = i%C-1;
					if(idx<0)idx = C-1; 
					long dist = a[idx];
					double time1 = 2*dist;
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+time1);
					if (time0 <= t0 && time1+time0>t0){
						double dist1 = (double)((double)t0-time0)/2;
						double time2 = (dist-dist1);
						dp[i][j+1] = Math.min(dp[i][j+1], dp[i-1][j]+t0-time0+time2);
					} 
					if(time0 >= t0){
						dp[i][j+1] = Math.min(dp[i][j+1], dp[i-1][j]+dist);
					}
				}
			}
			double max = Long.MAX_VALUE;
			for(int j = 0; j <= L; j++){
				if(dp[N][j]<max)max = dp[N][j]; 
			}
			System.out.println("Case #"+(init-t)+": " + (long)(max==Long.MAX_VALUE?0:max));
		}
	}

}
