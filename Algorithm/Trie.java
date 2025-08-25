/* 
0表示根节点和空节点，定义cnt【i】存储以当前节点i结尾的个数、trie【】【26】存储字符串，
插入：从根节点0遍历tried[0][a]是否有值，有则赋值给p继续遍历trie[p][a],没有则在此插入idx当前索引。
查询：没值输出0，有值继续遍历直到遍历完，cnt有值输出值，没值输出0；
*/
import java.io.*;
public class Main{
    static int N = 100010; // 总长不超过100000
    static int[][] trie = new int[N][26];
    static int[] cnt = new int[N];
    static int idx = 0;
    public static void insert(char[] str){
        int a;
        int p = 0;
        for(int i =0;i<str.length;i++){
            a = str[i] - 'a';
            if(trie[p][a]==0){
                trie[p][a] = ++idx;
            }
            p = trie[p][a];
        }
        cnt[p]++;
    }
    public static int query(char[] str){
        int a;
        int p = 0;
        for(int i =0;i<str.length;i++){
            a = str[i] -'a';
            if(trie[p][a]!=0){
                p = trie[p][a];
            }
            else return 0;
        }
        if(cnt[p]!=0)return cnt[p];
        else return 0;
    }
    public static void main(String[] args) throws IOException{
        //第一行包含整数 N，表示操作数。接下来 N行，每行包含一个操作指令，指令为 I x 或 Q x 中的一种。
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wt = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(bf.readLine());
        while(n-->0){
            String[] str = bf.readLine().split(" ");
            String op = str[0];
            String s = str[1];
            if(op.equals("I")) insert(s.toCharArray());
            else if(op.equals("Q")) wt.println(query(s.toCharArray()));
        }
        wt.flush();
    }
}
