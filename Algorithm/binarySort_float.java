/*
为什么结果保留6位小数，需要控制条件r-l<=1e-8？
因为结果误差可能会影响第8位，即使特殊情况（第八位原为4现为5）四舍五入后也才影响第7位，影响不到第6位，所以第6位是真实值。
*/

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(in.readLine());
        double l = -100 , r = 100;
        while(r-l>1e-8){
            double mid =(l+r)/2;
            if(mid*mid*mid>=n) r = mid;
            else l = mid;
        }
        System.out.printf("%.6f",r);
    }    
}
