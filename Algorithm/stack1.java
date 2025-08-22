import java.util.*;
public class Main{
    public static void eval(Stack<Integer> num,Stack<Character> op){
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        if(c=='+')
            num.push(a+b);
        else if(c=='-')
            num.push(a-b);
        else if(c=='*')
            num.push(a*b);
        else if(c=='/')
            num.push(a/b);
    }
    public static void main(String[] args){
        Map<Character,Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        // 核心逻辑：遇到数字入栈，遇到操作符与栈中比较，若优先级高则入栈，优先级低或相等则先计算栈中结果再入栈
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int i= 0;
        while(i<str.length()){
            char c = str.charAt(i);
            if(c =='('){
                op.push(c);
            }
            // 遇到右括号退栈，直到退出左括号，优先计算括号间操作符，结果入数字栈
            else if(c == ')'){
                while(op.peek()!='('){
                    eval(num,op);
                }
                op.pop();
            }
            else if(Character.isDigit(c)){
                int n = 0;
                int j = i;
                while(j<str.length()&&Character.isDigit(str.charAt(j))){
                    n = n*10 + str.charAt(j) - '0';
                    j++;
                }
                num.push(n);
                i = j-1;
            }
            else {
                //java的map结构中未定义的为null
                //用while:如果用if,遇到“10-2*3-4”结果会等于8
                while(!op.empty()&&op.peek()!='('&&map.get(c)<=map.get(op.peek())){
                    eval(num,op);
                }
                op.push(c);
            }
            i++;
        }
        while(!op.empty()){
            eval(num,op);
        }
        System.out.print(num.peek());
    }
}

// import java.util.*;
// public class Main{
//     public static void main(String[] args){
//         Scanner scan = new Scanner(System.in);
//         //以字符串形式输入表达式
//         String s = scan.next();
//         //map来添加运算符号进去，定义优先级
//         Map<Character,Integer> map = new HashMap<>();
//         map.put('+',1);
//         map.put('-',1);
//         map.put('*',2);
//         map.put('/',2);

//         Stack<Character> op = new Stack<>();//存运算符号
//         Stack<Integer> num = new Stack<>();//存数字

//         for(int i = 0 ; i < s.length(); i ++ ){
//             char c = s.charAt(i);
//             //判断c字符是不是数字
//             if(Character.isDigit(c)){
//                 int x = 0,j = i;
//                 //数字可能会是多位数，
//                 while(j < s.length() && Character.isDigit(s.charAt(j))){
//                     x = x * 10 + s.charAt(j) - '0';
//                     j++;
//                 }
//                 num.push(x);//将数字x存入数字栈栈顶
//                 i = j - 1;//重新赋值i
//             }else if(c == '('){
//                 op.push(c); // 将左括号存入字符栈栈顶
//             }else if(c == ')'){
//                 //如果栈顶不等于左括号，一直计算下去；
//                 while(op.peek() != '('){
//                     eval(op,num);
//                 }
//                 op.pop(); // 将左括号弹出栈顶
//             }else { //如果是正常字符
//                 while(!op.empty() && op.peek() != '(' && map.get(op.peek()) >= map.get(c)){
//                     eval(op,num);
//                 }
//                 op.push(c);
//             }
//         }
//         while(!op.empty()) eval(op,num);
//         System.out.println(num.peek());
//     }
//     public static void eval(Stack<Character> op,Stack<Integer> num){
//         int b = num.pop();
//         int a = num.pop();

//         char c = op.pop();
//         if(c == '+'){
//           num.push(a+b);
//         }else if(c == '-'){
//             num.push(a-b);
//         }else if(c == '*'){
//             num.push(a*b);
//         }else {
//             num.push(a/b);
//         }
//     }
// }
