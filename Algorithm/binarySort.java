/*
给定一个按照升序排列的长度为 n
 的整数数组，以及 q
 个查询。

对于每个查询，返回一个元素 k
 的起始位置和终止位置（位置从 0
 开始计数）。

如果数组中不存在该元素，则返回 -1 -1。
模板：
int l = -1, r = n;
while(l+1!=r){
    int mid = l + r >>1;
    if(a[mid]>=k) r = mid ;
    else l = mid;
}
*/



import java.io.*;
import java.util.*;

public class Main {
    static final int N = 100010;
    static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = in.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int q = Integer.parseInt(s1[1]);
        String[] s2 = in.readLine().split(" ");
        for(int i = 0; i < n; i ++) a[i] = Integer.parseInt(s2[i]);

        while(q -- > 0) {
            int k = Integer.parseInt(in.readLine());
            int l = -1, r = n;
            while(l+1!=r){
                int mid = l + r >>1;
                if(a[mid]>=k) r = mid ;
                else l = mid;
            }
            if(a[r]!=k) System.out.println("-1 -1");
            else {
                System.out.print(r+" ");
                l = -1;r = n;
                while(l+1!=r){
                    int mid = l + r>>1;
                    if(a[mid]<=k) l = mid;
                    else r = mid;
                }
                System.out.println(l);
            }
        }
    }
}
