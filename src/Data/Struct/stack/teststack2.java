package Data.Struct.stack;

public class teststack2 {
    public static void main(String[] args) {
        String s="4*3-3*3-2";
        System.out.println(result(s));

    }
    /**
     * 1.需要遍历字符串，获取每一个字符
     * 2.判断当前字符是一个运算符还是一个数字
     * 3.把数字存放在数字栈中，把运算符放在运算符栈
     * 4.运算符栈：  如果是一个空栈，那么直接运算符入栈，如果运算符栈中已经了其他运算符
     * 就需要先对比运算符优先级，新进来的运算符如果小于等于原栈中运算符，那么需要把原运算符弹栈
     * ，数字栈中数字进行弹栈，进行运算，运算后的结果重新放入数字栈中，新运算符入栈。
     * 如果新运算符优先级大于原符号栈中运算符，那么新的符号直接入栈
     */
    public static int result(String s){
        ArrayStack dataStack=new ArrayStack(10);
        ArrayStack symbolStack=new ArrayStack(10);
        int result=0;
        String values="";
        for(int i=0;i<s.length();i++){
            if(dataStack.isOper(s.charAt(i))){
                if(symbolStack.isEmpty()){
                    symbolStack.push(s.charAt(i));
                }
                else if(symbolStack.priority(s.charAt(i))>symbolStack.priority(symbolStack.peek()))
                {
                    symbolStack.push(s.charAt(i));
                }
                else{
                    int num1=dataStack.pop();
                    int num2=dataStack.pop();
                    int oper=symbolStack.pop();
                    int res=dataStack.calculate(num1,num2,oper);
                    dataStack.push(res);
                    symbolStack.push(s.charAt(i));
                }
            }
            else{
                values+=s.charAt(i);
                if(i==s.length()-1)
                    dataStack.push(Integer.parseInt(values));
                else if(symbolStack.isOper(s.charAt(i+1))){
                    dataStack.push(Integer.parseInt(values));
                    values="";
                }
                else;

            }

        }
        while(true){
            if(symbolStack.isEmpty())
                break;
            int num1=dataStack.pop();
            int num2=dataStack.pop();
            int oper=symbolStack.pop();
            result=dataStack.calculate(num1,num2,oper);
            dataStack.push(result);
        }
        return result;
    }
}
