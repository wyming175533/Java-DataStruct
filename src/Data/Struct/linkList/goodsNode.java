package Data.Struct.linkList;

public class goodsNode {
    //普通单链表节点
     public int id;
     public int value;
     public String name;
     public goodsNode next=null;

    public goodsNode() {
    }

    public goodsNode(int id, int value, String name) {
        this.id = id;
        this.value = value;
        this.name = name;
    }
}
