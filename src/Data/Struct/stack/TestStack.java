package Data.Struct.stack;

public class TestStack {
    public static void main(String[] args) {
        String s="hhh";
        System.out.println(huiwen(s));
    }

    public static boolean huiwen(String val){
        ArrayStack arrayStack=new ArrayStack(10);

        for(int i=0;i<val.length();i++){
            arrayStack.push(val.charAt(i));
        }

        String newval ="";
        for(int i=0;i<val.length();i++){
            char pop=(char)arrayStack.pop();
            newval+=pop;
        }

        return val.equals(newval);
    }
}
