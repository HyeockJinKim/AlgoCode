import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] d = new int[t+1];
        String[] p = new String[t+1];
        String[] input;
        for (int i = 1; i <= t; ++i) {
            input = br.readLine().split(" ");
            d[i] = Integer.parseInt(input[0]);
            p[i] = input[1];
        }
        for (int i = 1; i <= t; ++i) {
            int index = p[i].length();
            int[] damage = new int[index+1];
            int currentDamage = 1, curIndex=0, result = 0;
            for (int j = 0; j < index; ++j) {
                if (p[i].charAt(j) == 'C'){
                    currentDamage *= 2;
                    curIndex++;
                } else {
                    result += currentDamage;
                    damage[curIndex]++;
                }
            }
            int count = 0;
            while (result > d[i]) {
                if (curIndex < 1) {
                    count = -1;
                    break;
                }
                if (damage[curIndex] > 0) {
                    damage[curIndex]--;
                    damage[curIndex-1]++;
                    result -= currentDamage/2;
                    count++;
                } else {
                    curIndex--;
                    currentDamage /= 2;
                }
            }
            if (count == -1) {
                System.out.println("Case #"+i+": IMPOSSIBLE");
            } else {
                System.out.println("Case #"+i+": "+count);
            }
        }
    }
}
