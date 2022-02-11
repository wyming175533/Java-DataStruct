package Data.Struct.linkList.cicrile;

public class cicrleLink {
    /**
     * first 头节点
     * helper 尾节点
     * 注意这两个的初始化再使用add方法时候同时创建
     * 否则值为null
     */
    public boyNode first=null;
    public boyNode helper=null;
    //增
    public void add(int num){
        if(num>0){
            for (int i = 1; i <= num; i++) {
                boyNode boy=new boyNode(i);
                if(i==1)
                {
                    first=boy;
                    helper=first;
                    first.next=first;
                }
                else{
                    helper.next=boy;
                    helper=boy;
                    helper.next=first;
                }
            }
        }
    }

    /**
     * 删除方法不完善，没有完全考虑删除节点后num，helper的变化，不利于后面方法，尽量不删除
     * @param id
     */
    public void del(int id){
        boyNode tmp=first;
        while(true){
            if(tmp.next.getId()==id&&id>1){
                boyNode p=tmp.next;
                tmp.next=p.next;
                if(tmp.next==first)
                    helper=tmp;
                return;
            }
            if(tmp.next==helper)
            {
                System.out.println("没有找到这个男孩");
                return;
            }
            tmp=tmp.next;
        }
    }
    public  void sout(){
        boyNode tmp=first;
        while(true){
            if(first!=null){
                System.out.println("这个小孩的id是"+tmp.getId());
            }
                tmp=tmp.next;
              if(tmp==first)
                break;
        }
    }

    /**
     * 约瑟夫问题
     * @param startNo
     * 开始编号
     * @param countNum
     * 计数值/经过第几个节点后的被删除
     * @param nums
     * boy总数
     */
    public  void countyBoy(int startNo,int countNum,int nums){
        boyNode F=first;
        boyNode H=helper;
        if(startNo>nums||startNo<1||countNum>nums||countNum<1)
        {
            new RuntimeException("输入参数不合法");
        }
        for (int i = 1; i < startNo; i++) {
            F=F.next;
            H=H.next;
        }
        while(true){
            if(F==H)
                break;
        for (int i = 1; i <countNum ; i++) {
          F=F.next;
          H=H.next;
        }
        System.out.println("被淘汰的小孩是"+F.getId());
        H.next=F.next;
        F=H.next;
        }

        System.out.println("最后剩下的小孩是"+F.getId());


    }
}
