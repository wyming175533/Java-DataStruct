package Data.Struct.linkList;

public class linkNode {
   public goodsNode head;

    /**
     * head是头节点，除了next可以添加为其余值都是系统默认赋值
     * @param head
     */
    public linkNode(goodsNode head) {
        this.head = head;
    }

    /**
     * node是测试方法中传入的值
     * @param node
     *
     * add和addorder的不同是插入是否有序（不考虑原来状态）
     */
    public void add(goodsNode node){
        goodsNode tmp=head;
        while(true){
            if(tmp.next==null)
                break;
            tmp=tmp.next;
        }
        tmp.next=node;
    }

    public  void del(int id){
        goodsNode tmp=head;
        goodsNode p=null;
        while(true){
            if(tmp.next==null)
                break;
            if(tmp.next.id==id)
                break;
            tmp=tmp.next;
        }
        if(tmp.next!=null) {
            p = tmp.next;
            tmp.next=p.next;
        }
        else
            System.out.println("未找到该商品");
    }

    public void addorder(goodsNode node){
        goodsNode tmp=head;
        while(true){
            if(tmp.next==null)
                break;
            if(tmp.next.id>node.id)
                break;
            else if(tmp.next.id==node.id){
                upData(node.id,node);
                return;
            }
            tmp=tmp.next;
        }
        node.next=tmp.next;
        tmp.next=node;
    }
    public void upData(int id,goodsNode node){
        goodsNode tmp=head;
        while(true){
            if(tmp.next==null)
                break;
            if(tmp.next.id==id)
            break;
            tmp=tmp.next;
        }
        if(tmp.next!=null){
            tmp.next.id=node.id;
            tmp.next.name=node.name;
            tmp.next.value=node.value;
        }
        else
            System.out.println("没有找到该商品");
    }
    public  void sout(){
        goodsNode tmp=head;
        while(true){
            if(tmp.next!=null){
                System.out.println("商品id："+tmp.next.id+"商品名称："+tmp.next.name+"商品金额："+tmp.next.value);
            }
            else
                break;
            tmp=tmp.next;


        }
    }

}
