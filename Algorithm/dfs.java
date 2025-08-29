import java.util.Scanner;
public class Main{
    static int n;
    static int N = 10;
    static int[] a = new int[N];
    static boolean[] b = new boolean[N];
    public static void dfs(int u){
        if(u==n){
            for(int i = 0;i<n;i++){
                System.out.print(a[i]+" ");    
            }
            System.out.println();
            return;
        }
        for(int i = 1;i<=n;i++){
            if(!b[i]){
                b[i] = true;
                a[u] = i;
                dfs(u+1);
                b[i] = false;
            }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        dfs(0);
    }
}
