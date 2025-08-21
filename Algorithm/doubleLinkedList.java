// /*
// 由于第k个插入的数并不是链表第k个数，而是按照时间顺序插入的第k个数，
// 因此idx表示时间顺序插入的索引，对应e、ne、pre三数组模拟双链表节点
// */
// import java.util.Scanner;
// public class Main{
//     static int idx = 0;
//     static int Lhead = -1;
//     static int Rhead = -1;
//     static int[] e = new int[100010];
//     static int[] ne = new int[100010];
//     static int[] pre = new int[100010];
//     // 在链表的最左端插入数x
//     public static void add_Lhead(int x){
//         e[idx] = x;
//         ne[idx] = Lhead;
//         pre[idx] = -1;
//         Lhead = idx;
//         idx++;
//     }
//     // 在链表的最右端插入数x
//     public static void add_Rhead(int x){
//         e[idx] = x;
//         ne[idx] = -1;
//         pre[idx] = Rhead;
//         Rhead = idx;
//         idx++;
//     }
//     // 在第k个插入的数左侧插入一个数x
//     public static void addl(int k, int x){
//         e[idx] = x;
//         ne[idx] = k;
//         pre[idx] = pre[k];
//         ne[pre[k]] = idx;
//         pre[k] = idx;
//         idx++;
//     }
//     // 在第k个插入的数右侧插入一个数x
//     public static void addr(int k, int x){
//         e[idx] = x;
//         ne[idx] = ne[k];
//         pre[idx] = k;
//         pre[ne[k]] = idx;
//         ne[k] = idx;
//         idx ++;
//     }
//     // 将第 k 个插入的数删除
//     public static void del(int k){
//         if(k==Lhead){
//             pre[ne[k]] = -1;
//             Lhead = ne[k];
//             ne[k] = -1;
//         }
//         if(k == Rhead){
//             ne[pre[k]] = -1;
//             Rhead = pre[k];
//             pre[k] = -1;
//         }
//         else {
//             ne[pre[k]] = ne[k];
//             pre[ne[k]] = pre[k];
//         }
//     }
//     public static void main(String[] args){
//         System.out.println("程序开始执行");
//         int M;
//         Scanner scan = new Scanner(System.in);
//         M = scan.nextInt();
//         while(M-->0){
//             String str = scan.next();
//             // char c = str.charAt(0);
//             /*
//             L x，表示在链表的最左端插入数 
//             R x，表示在链表的最右端插入数 x
//             D k，表示将第k个插入的数删除。
//             IL k x，表示在第k个插入的数左侧插入一个数。
//             IR k x，表示在第k个插入的数右侧插入一个数。
//             */
//             if(str.equals("L")){
//                 int x = scan.nextInt(); System.out.println(x+" L");
//                 add_Lhead(x);
//             }else if(str.equals("R")){
//                 int x = scan.nextInt(); System.out.println(x+" R");
//                 add_Rhead(x);
//             }else if(str.equals("D")){
//                 int k = scan.nextInt(); System.out.println(k+" D");
//                 del(k);
//             }else if(str.equals("IL")){
//                 int k = scan.nextInt(); 
//                 int x = scan.nextInt();
//                 addl(k-1,x); System.out.println(k+" "+ x+" IL");
//             }else{
//                 int k = scan.nextInt();
//                 int x = scan.nextInt();
//                 addr(k-1,x); System.out.println(k+" "+ x+" IR");
//             }
//         }
//         for(int i = Lhead;i!=-1;i=ne[i]){
//             System.out.print(e[i]+" ");
//         }
//     }
// }


/*
Java确实提供了现成的链表实现：

java
import java.util.LinkedList;
// 或者
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
🎯 算法题中不用现成LinkedList的原因
1. 操作粒度控制
java
// 题目要求的具体操作
IL k x  // 在第k个插入的数左侧插入x
IR k x  // 在第k个插入的数右侧插入x
D k     // 删除第k个插入的数

// 用LinkedList需要这样：
list.add(k, x);        // 但这是按位置索引，不是按插入顺序
// 无法直接实现"第k个插入的数"这个概念
2. 性能考虑
java
// LinkedList的add(index, element)是O(n)操作
// 而数组模拟的链表操作是O(1)
LinkedList<Integer> list = new LinkedList<>();
list.add(k, x);  // 需要遍历找到第k个位置 → O(n)

// 数组模拟：
insert(k, x);  // 直接操作指针 → O(1)
3. 面试官的期望
java
// 面试官想考察的是：
√ 对指针操作的理解
√ 对底层数据结构的掌握  
√ 边界条件的处理能力
√ 空间复杂度的优化

// 而不是：
× 对API的熟悉程度
× 调用现成库函数
*/


import java.util.Scanner;

public class Main {
    static int idx = 0;
    static int head = -1;
    static int tail = -1;
    static int[] e = new int[100010];
    static int[] l = new int[100010]; // left pointer
    static int[] r = new int[100010]; // right pointer
    
    // 初始化链表，创建两个哨兵节点（0和1）
    public static void init() {
        // 0 是左哨兵，1 是右哨兵
        r[0] = 1;
        l[1] = 0;
        idx = 2; // 从2开始存储实际数据
    }
    
    // 在k节点的右边插入x
    public static void insert(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }
    
    // 删除第k个节点
    public static void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        
        init();
        
        while (M-- > 0) {
            String op = scan.next();
            
            if (op.equals("L")) {
                int x = scan.nextInt();
                insert(0, x); // 在最左边插入（在左哨兵右边插入）
            } else if (op.equals("R")) {
                int x = scan.nextInt();
                insert(l[1], x); // 在最右边插入（在右哨兵左边节点的右边插入）
            } else if (op.equals("D")) {
                int k = scan.nextInt();
                remove(k + 1); // 第k个插入的节点索引是k+1（因为从2开始）
            } else if (op.equals("IL")) {
                int k = scan.nextInt();
                int x = scan.nextInt();
                insert(l[k + 1], x); // 在第k个节点左边插入 = 在k的前驱节点右边插入
            } else if (op.equals("IR")) {
                int k = scan.nextInt();
                int x = scan.nextInt();
                insert(k + 1, x); // 在第k个节点右边插入
            }
        }
        
        // 输出链表（从左哨兵的右边开始，到右哨兵结束）
        for (int i = r[0]; i != 1; i = r[i]) {
            System.out.print(e[i] + " ");
        }
        
        scan.close();
    }
}
