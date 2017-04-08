package gcj2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class GettingTheDigits {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {

            System.out.println(caseNumber);

            final char[] chars = scanner.next().toCharArray();

            String[] numbs = new String[]{"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                Integer count = map.get(chars[i]);
                if(count == null)count = 0;
                map.put(chars[i], ++count);
            }

            ArrayList<Integer> result = new ArrayList<>();
            while(!map.isEmpty()){


                for (int i = 0; i < numbs.length; i++) {
                    char[] numbChars = numbs[i].toCharArray();
                    final LinkedList<Character> idx = new LinkedList<>();
                    for (int j = 0; j < numbChars.length; j++) {
                        Integer val = map.get(numbChars[j]);
                        if(val != null && val != 0) {
                            idx.add(numbChars[j]);
                            map.put(numbChars[j], val - 1);
                            if(map.get(numbChars[j]) == 0){
                                map.remove(numbChars[j]);
                            }
                        }
                    }
                    if(idx.size() == numbs[i].length()){
                        result.add(i);
                    } else {
                        for(Character ch : idx){
                            Integer val = map.get(ch);
                            if(val == null)val = 0;
                            map.put(ch, val + 1);
                        }
                    }
                }
            }

            Integer[] resArr = result.toArray(new Integer[0]);
            Arrays.sort(resArr);

            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < resArr.length; i++) {
                sb.append(resArr[i]);
            }

            System.out.println(String.format("Case #%d: %s", caseNumber, sb.toString()));
        }

    }
}
