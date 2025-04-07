/*
1.20分钟思考
2.看题解提性能
3.github保存
*/

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int[] q = new int[n];
        for(int i=0;i<n;i++){
            q[i]=sc.nextInt();
        }
        quickSort(q,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(q[i]+" ");
        }
    }
    public static void quickSort(int[] q, int l, int r){
        if(l>=r) return ;
        int x = q[l + r >> 1],i = l - 1 , j = r + 1;
        while(i<j){
            /*误解1：这里不能取=，相同必须多个步骤交换，因为可能跳过x，需要Debug*/
            // while(q[++i]<=x && i<j);
            // while(q[--j]>=x && i<j);
            // if(q[i]>q[j]&&i<j)
            while( q[++i] < x );
            while( q[--j] > x) ;
            if(i < j)
            {int temp = q[i];
            q[i]=q[j];
            q[j]=temp;}
        }
        /*误解2：明天debug看看*/
        // quickSort(q,l,j-1);
        // quickSort(q,i,r);
         quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}
