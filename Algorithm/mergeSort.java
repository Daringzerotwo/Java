import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        
        int[] q =new int[n];
        for(int i=0;i<n;i++){
            q[i] = sc.nextInt();
        }
        System.out.print(mergeSort(q,0,n-1));
        // for(int i=0;i<n;i++){
        //     System.out.print(q[i]);
        // }
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
