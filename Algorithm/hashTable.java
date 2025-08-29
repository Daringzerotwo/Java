// 拉链法
import java.util.Scanner;
public class Main{
    static int N = 100003;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx = 0;
    public static void insert(int x){
        int p = (x%N+N)%N;
        e[idx] = x;
        ne[idx] = h[p];
        h[p] = idx++;
    }
    public static boolean query(int x){
        int p = (x%N+N)%N;
        for(int i = h[p];i!=-1;i=ne[i]){
            if(e[i]==x)return true;
        }
        return false;
    }
    public static void main(String[] args){
        for(int i = 0;i<N;i++){
            h[i] = -1;
        }
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-->0){
            String s = scan.next();
            int x = scan.nextInt();
            if(s.equals("I")){
                insert(x);
            }
            else{
                if(query(x)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}

// 开放寻址法
import java.util.Scanner;
public class Main{
    static int N = 200003;
    static int[] h = new int[N];
    static int idx = 0;
    static int nulls = 0x3f3f3f3f;
    // 插入时返回可插入的坐标，查询时返回查询到的坐标
    public static int query(int x){
        int p = (x%N+N)%N;
        while(h[p]!=nulls&&h[p]!=x){
            p++;
            if(p==N)p=0;
        }
        return p;
    }
    public static void main(String[] args){
        for(int i = 0;i<N;i++){
            h[i] = nulls;
        }
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-->0){
            String s = scan.next();
            int x = scan.nextInt();
            int p = query(x);
            if(s.equals("I")){
                h[p] = x;
            }
            else{
                if(h[p]!=nulls) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
