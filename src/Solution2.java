import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] result = new int[t+1];
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(br.readLine());
            int[] v0 = new int[(n+1)/2];
            int[] v1 = new int[(n+1)/2];
            String[] temp = (br.readLine()+" 1000000000").split(" ");
            for (int j = 0; j < n; j += 2) {
                v0[j/2] = Integer.parseInt(temp[j]);
                v1[j/2] = Integer.parseInt(temp[j+1]);
            }

            Arrays.sort(v0);
            Arrays.sort(v1);

            int comp = v0[0];
            result[i] = -1;
            for (int j = 0; j < v1.length; ++j) {
                if (v1[j] < v0[j]) {
                    result[i] = 2 * j;
                    break;
                } else if (comp > v0[j]) {
                    result[i] = 2 * j -1;
                    break;
                }
                comp = v1[j];
            }
        }

        for (int i = 1; i <= t; ++i) {
            if (result[i] == -1) {
                System.out.println("Case #"+i+": OK");
            } else {
                System.out.println("Case #"+i+": "+result[i]);
            }
        }

    }
}