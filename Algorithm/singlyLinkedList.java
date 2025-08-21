/*
1.此处idx索引从0开始，因此指针ne[k]表示的是第k+1个节点指向的节点索引！！！
2.ne[k]表示第k个插入的节点指向的节点索引。
3.为什么使用静态变量和方法，因为免去创造类的实例（new Main），可以直接调用类中定义的静态函数，共享内存。
*/
import java.util.Scanner;
public class Main{
    static int[] e = new int[100010];
    static int[] ne = new int[100010];
    static int idx,head; // 定义当前索引inx和头节点指针
    public static void init(){
        idx = 0; // 表示数组索引从0开始
        head = -1; // 表示当前链表为空
    }
    public static void add_head(int x){
        e[idx] = x;
        ne[idx] = head; // x ——> -1
        head = idx++; // 若中途删完 重建头节点可通过head找到新链表开始位置
    }
    // 在第k个后面插入x
    public static void add(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k]; // 新插入节点指向 第k个节点指向的节点索引
        ne[k] = idx++; // 第k个节点指向 新插入节点的索引
    }
    // 删除第k个后面的数
    public static void del(int k){
        ne[k] = ne[ne[k]]; // 第k个节点指向 第k个节点指向节点 的下一个节点索引
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        
        init();
        while(m-- > 0){
            // java中没有输入一个字符，用字符串转字符
            String s = scan.next();
            char op = s.charAt(0);
            
            if(op == 'H'){
                int x = scan.nextInt();
                add_head(x);
            }else if(op == 'D'){
                int k = scan.nextInt();
                if(k==0) head = ne[head];
                else del(k-1);
            }else{
                int k = scan.nextInt();
                int x = scan.nextInt();
                add(k-1,x);
            }
        }
        for(int i=head;i != -1;i=ne[i]){
            System.out.print(e[i]+" ");
        }
    }
}

