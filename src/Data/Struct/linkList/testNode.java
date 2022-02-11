package Data.Struct.linkList;

public class testNode {
    public static void main(String[] args) {
        /**
         * 在linkNode中，addorder（）代码部分
         * 在id相同时候调用了update（）方法
         * 对于单链表节点少的情况下可以这样，实现了代码复用
         * 对于节点多的情况会增加时间复杂度（进行了两次遍历！！）
         */
        goodsNode head=new goodsNode();
        linkNode linknode=new linkNode(head);
        goodsNode good1=new goodsNode(1,100,"apple");
        goodsNode good2=new goodsNode(2,90,"banana");
        goodsNode good3=new goodsNode(2,900,"bananas");
        goodsNode good4=new goodsNode(5,80,"egg");
        goodsNode good5=new goodsNode(4,88,"rice");
        goodsNode good6=new goodsNode(6,88,"noddle");

        linknode.add(good1);
        linknode.add(good2);
        linknode.addorder(good3);
        linknode.add(good4);
        linknode.addorder(good5);
        linknode.del(1);
       // linknode.upData(2,good6);
        linknode.sout();

    }
}
