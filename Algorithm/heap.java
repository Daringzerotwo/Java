import java.io.*;
public class Main{
    static int N = 100010;
    static int[] h = new int[N];
    static int[] ph = new int[N];
    static int[] hp = new int[N];
    static int idx = 0;
    static int size = 0;
    public static void swap(int[] n,int t,int u){
        int temp = n[t];
        n[t] = n[u];
        n[u] = temp;
    }
    public static void swapMapping(int t, int u){
        int k1 = hp[t];
        int k2 = hp[u];
        swap(ph,k1,k2);
        swap(hp,t,u);
        swap(h,t,u);
    }
    public static void down(int u){
        int t = u;
        if(2*u<=size&&h[2*u]<h[t])t=2*u;
        if(2*u+1<=size&&h[2*u+1]<h[t])t=2*u+1;
        if(t!=u){
            // ph映射中t和u对应的 那么问题来了，t和u坐标对应第几个插入的数，用hp再存
            swapMapping(t,u);
            down(t);
        }
    }
    public static void up(int u){
        int t = u;
        if(u/2>0&&h[u/2]>h[u])t = u/2;
        if(u!=t){
            swapMapping(t,u);
            up(t);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wt = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(bf.readLine());
        while(n-->0){
            String[] str = bf.readLine().split(" ");
            if(str[0].equals("I")){
                int x = Integer.parseInt(str[1]);
                size++;idx++;
                h[size] = x;
                ph[idx] = size;
                hp[size] = idx;
                up(size);
            }else if(str[0].equals("PM")){
                wt.println(h[1]);
            }else if(str[0].equals("DM")){
                swapMapping(1,size);
                size--;
                down(1);
            }else if(str[0].equals("D")){
                int k = Integer.parseInt(str[1]);
                // 第k个插入的数对应堆中的下标是ph[k]
                int pos = ph[k]; // !!!下一步交换完pk[k]会改变
                swapMapping(pos,size);
                size--;
                down(pos);
                up(pos);
            }else{
                int k = Integer.parseInt(str[1]);
                int x = Integer.parseInt(str[2]);
                h[ph[k]] = x;
                down(ph[k]);
                up(ph[k]);
            }
        }
        wt.flush();
    }
}
