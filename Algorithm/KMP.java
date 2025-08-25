/*传统的暴力算法在i=5匹配失败时，会让探险家i回溯到i=2，助手j回溯到0，重新开始匹配，浪费了大量时间。

而KMP算法通过ne秘籍，只让助手j回溯，而探险家i永远勇往直前，从不后退！这就是它效率高的核心原因，将时间复杂度从O(n*m)降到了O(n+m)。*/
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wt = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = 100010;int M = 1000010;
        int n = Integer.parseInt(bf.readLine());
        String P = bf.readLine();
        char[] p = new char[N];
        for(int i=1;i<=n;i++) p[i] = P.charAt(i-1);
        int m = Integer.parseInt(bf.readLine());
        String S = bf.readLine();
        char[] s = new char[M];
        for(int i=1;i<=m;i++) s[i] = S.charAt(i-1);
        // 计算ne
        int[] ne = new int[N];
        for(int i = 2,j=0;i<=n;i++){
            while(j>0&&p[i]!=p[j+1])j = ne[j];
            if(p[i] == p[j+1]) j++;
            ne[i] = j;
        }
        for(int i = 1,j=0;i<=m;i++){
            while(j>0&&s[i]!=p[j+1]) j = ne[j];
            if(s[i] == p[j+1]) j++;
            if(j==n){
                wt.print(i-n+" ");
                j = ne[j];
            }
        }
        wt.flush();
    }
}
