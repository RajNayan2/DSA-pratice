import java.util.Stack;
public class InfixTOPostfix {
    public static void main(String[]args){
        String str="9-(5+3)*4/6";
        Stack<String> val=new Stack<>();
        Stack<Character> op=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int ascill=(int)ch;
            if(ascill>=48 && ascill<=57){
                String s=""+ch;
                val.push(s);
            }else if(op.size()==0||op.peek()=='('||ch=='('){
                op.push(ch);
            }else if (ch == ')') {
                while (op.peek() != '(') {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1 + v2+o;
                    val.push(t);
                }
                op.pop();
            }else{
                if(ch=='+'||ch=='-'){
                    String v2=val.pop();
                String v1=val.pop();
                char o=op.pop();
                String t=v1+v2+o;
                val.push(t);
                op.push(ch);
              }if(ch=='*'||ch=='/'){
                if(op.peek()=='*'||op.peek()=='/'){
                    String v2=val.pop();
                    String v1=val.pop();
                    char o=op.pop();
                    String t=v1+v2+o;
                    val.push(t);
                    op.push(ch);
                }else op.push(ch);
            }

        }
        }
    while(val.size()>1){
        String v2=val.pop();
        String v1=val.pop();
        char o=op.pop();
        String t=v1+v2+o;
        val.push(t);
    }
    System.out.println(val.peek());
}
}
