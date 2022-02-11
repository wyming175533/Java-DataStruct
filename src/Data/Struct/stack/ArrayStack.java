package Data.Struct.stack;

public class ArrayStack {
    /**
     * 这是一个栈项目
     * 栈顶默认初始值为-1
     */
    private int top=-1;
    private int[] stack;
    private int maxStack;

    public ArrayStack (int maxStack){
        this.maxStack=maxStack;
        stack=new int[maxStack];
    }
    /**
     * 判断栈空栈满
     */
    public boolean isFull(){
        return this.top == this.maxStack - 1;
    }
    public boolean isEmpty(){
        return this.top==-1;
    }

    public void push(int element){
        if(isFull())
            throw new RuntimeException("栈满，终止入栈");
        stack[++top]=element;
    }

    public int pop(){
        if(isEmpty())
            throw new RuntimeException("空栈");
        return stack[top--];
    }
    public void view(){
        if(isEmpty())
            throw new RuntimeException("空栈");
        for(int i=0;i>maxStack;i++)
            System.out.println("第"+i+"个元素的值为"+stack[i]);
    }

    /**
     * 栈中存在的个数
     * @return
     */
    public int length(){
        return top+1;
    }

    /**
    *   获取栈的容量
    */
    public int maxlength(){
        return this.maxStack;
    }
public boolean isOper(char v){
 return v=='+'||v=='*'||v=='/'||v=='-';
}
public int peek(){
        return stack[top];
}
public int priority(int oper){
        if(oper=='+'||oper=='-')
            return 0;
        else if(oper=='/'||oper=='*')
            return 1;
        else return -1;
}
public int calculate(int num1,int num2,int oper){
        int result = 0;
        switch(oper){
            case '+':
                result=num1+num2;break;
            case '-':
                result=num2-num1;break;
            case'*':
                result=num1*num2;break;
            case'/':
                result=num2-num1;break;
            default:break;

        }
        return result;
}
}
