package gcj2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DancingWithTheGooglers {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer t = Integer.parseInt(br.readLine());
		int init = t;
		while (t-- > 0) {
			String input = br.readLine();
			String[]parts = input.split("\\s+");
			int cnt = 0;
			int N = Integer.parseInt(parts[cnt++]);
			int S = Integer.parseInt(parts[cnt++]);
			int p = Integer.parseInt(parts[cnt++]);
			int[][]dp = new int[N+1][N+1];
			int surprizes = 0;
			for(int i = 0; i < parts.length-cnt; i++){
				int score = Integer.parseInt(parts[cnt+i]);
				Set<String> set = new HashSet<String>();
				int fisrt = score/3;
				boolean currSurprizes = false;
				for(int fVal = fisrt-2; fVal <= fisrt+2; fVal++){
					int sec = score/3;
					for(int sVal = sec-2; sVal <= sec+2; sVal++){
						int thVal = score-sVal-fVal;
						int minVal = Math.min(Math.min(fVal,sVal), thVal);
						int maxVal = Math.max(Math.max(fVal,sVal), thVal);
//						if(maxVal-minVal>2||minVal<0||maxVal<0||minVal>10||maxVal>10)continue;
						List<Integer> l = new ArrayList<Integer>();
						l.add(fVal);
						l.add(sVal);
						l.add(thVal);
						Collections.sort(l);
						String s = l.get(0)+","+l.get(1)+","+l.get(2);
						if(set.contains(s))continue;
						set.add(s);
						for(int j = 0; j <= surprizes; j++){
							dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j]);
						}							
						if(!(maxVal-minVal>2||minVal<0||maxVal<0||minVal>10||maxVal>10)){
							if(maxVal-minVal==2&&p<=maxVal){
								for(int j = 0; j <= surprizes; j++){
									dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+1);
								}							
								currSurprizes = true;
							} else if(maxVal-minVal<2&&p<=maxVal){
								for(int j = 0; j <= surprizes; j++){
									dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+1);
								}
							}
						}
					}
				}
				if(currSurprizes)
					surprizes++;
			}
			int max = 0;
			for(int i = 0; i <= S; i++){
				if(dp[N][i]>max)max = dp[N][i];
			}
			System.out.println("Case #"+(init-t)+": " + max);
		}
	}
}
