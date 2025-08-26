import java.util.Scanner;
public class Main{
    static int[] P = new int[100010];
    public static int find(int x){
        if(P[x]!=x) P[x] = find(P[x]); // 路径压缩
        return P[x];
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for(int i=0;i<n;i++){
            P[i] = i;
        }
        int a,b;
        while(m-->0){
            String str = scan.next();
            a = scan.nextInt();
            b = scan.nextInt();
            if(str.equals("M")) {
                P[find(a)] = find(b);
            }
            else {
                if(find(a)==find(b))System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
