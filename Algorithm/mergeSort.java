/*
使用BufferedReader+InputStreamReader，先转为字符流，再转为缓存字符流
看22行
readLine读一行文字
由于输入的字符串是按空格隔开的，trim()函数去掉String字符串的首尾空格，
split()函数是根据参数如",", "-", " "等, 分割String字符串, 返回一个String的数组(String[])
24行
再将String类型转为int型，虽然麻烦，但是快
*/

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args){
        try{
        // Scanner sc = new Scanner(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim().split(" ")[0]);
        // int n = sc.nextInt();
        
        int[] q =new int[n];
        String[] s = br.readLine().trim().split(" ");
        for(int i=0;i<n;i++){
            q[i] = Integer.parseInt(s[i]);
            // q[i] = sc.nextInt();
        }
        System.out.print(mergeSort(q,0,n-1));
        }
        catch(Exception e) {
            e.getStackTrace();
            System.out.print(" 123");
        }
    }
    public static long mergeSort(int[] q, int l,int r){
        if(l>=r) return 0;
        int x = l + r >>1;
        int i = l, j=x+1, k=0;
        long count=mergeSort(q,l,x) + mergeSort(q,x+1,r);
        int[] temp = new int[r-l+1];
        while(i<=x&&j<=r){
            if(q[i]<=q[j]) temp[k++] = q[i++];
            else {
                temp[k++] = q[j++];
                count+=x-i+1;
            }
        }
        while(i<=x) temp[k++] = q[i++];
        while(j<=r) temp[k++] = q[j++];
        
        for(i = l,k = 0;i <= r ;i++,k++){
            q[i] = temp[k];
        }
        return count;
    }
}
