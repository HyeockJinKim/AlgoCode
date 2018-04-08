import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final double ROOT2 = Math.sqrt(2);
        final double ROOTPow = (ROOT2*ROOT2+1);
        final double PI_DIV_4 = Math.PI/4;
        final double PI_DIV_4_COS = Math.cos(PI_DIV_4) * 0.5;
        final double PI_DIC_4_SIN = Math.sin(PI_DIV_4) * 0.5;
        final double theta =  Math.asin(1/ROOTPow);
        final double MAX = Math.sqrt(ROOTPow);

        int t = Integer.parseInt(br.readLine());
        double[] a = new double[t+1];

        for (int i = 1; i <= t; ++i) {
            a[i] = Double.valueOf(br.readLine());
        }

        for (int i = 1; i <= t; ++i) {
            double[] x = new double[3];
            double[] y = new double[3];
            double[] z = new double[3];
            if (a[i] > ROOT2) {
                double radian = Math.asin(a[i]/MAX) + theta;
                double cosVal = Math.cos(radian) * 0.5;
                double sinVal = Math.sin(radian) * 0.5;
                System.out.println(radian);
                x[0] = PI_DIV_4_COS;
                x[1] = PI_DIC_4_SIN;

                y[0] = -x[1];
                y[1] = x[0] * cosVal;
                y[2] = sinVal;

                z[1] = sinVal;
                z[2] = cosVal;

            } else {
                z[2] = 0.5;
                double radian = Math.acos(a[i]/ROOT2) - (Math.PI/4);

                double cosVal = Math.cos(radian) * 0.5;
                double sinVal = Math.sin(radian) * 0.5;
                x[0] = cosVal;
                x[1] = sinVal;
                y[0] = -x[1];
                y[1] = x[0];
            }
            System.out.println("Case #"+i+":");
            System.out.println(String.format("%.7f %.7f %.7f", x[0], x[1], x[2]));
            System.out.println(String.format("%.7f %.7f %.7f", y[0], y[1], y[2]));
            System.out.println(String.format("%.7f %.7f %.7f", z[0], z[1], z[2]));
        }
    }
}
