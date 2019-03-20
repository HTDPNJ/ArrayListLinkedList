import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList
{
   private Node first;
   private Node last;
   private int size;
   public void add(Object obj){
       Node n=new Node();
       if(first==null){
           n.setPreviouse(null);
           n.setObj(obj);
           n.setNext(null);
           first=n;
           last=n;
       }else{
           n.setPreviouse(last);
           n.setObj(obj);
           n.setNext(null);
           last.setNext(n);
           last=n;
       }
       size++;
   }
   public int getSize(){
       return size;
   }
   public Object get(int index){
       rangeCheck(index);
       Node temp=node(index);
       return temp.obj;
   }
    private void rangeCheck(int index){
        if(index<0||index>=size){
            try{
                throw new Exception();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public Node node(int index){
        Node temp=null;
        if(first!=null){
            temp=first;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
        }
        return temp;
    }
    public void remove(int index){
        rangeCheck(index);
        Node temp=node(index);
        Node up=temp.previouse;
        Node down=temp.next;
        up.next=down;
        down.next=up;
        size--;
    }
    public void add(int index,Object obj){
       Node temp=node(index);
       Node newNode=new Node();
       newNode.obj=obj;
       if(temp!=null){
           Node up= temp.previouse;
           up.next=newNode;
           newNode.previouse=up;
           newNode.next=temp;
           temp.previouse=newNode;
       }
    }

    public static void main(String[] args)
    {
        MyLinkedList list=new MyLinkedList();
        list.add("aaa");
        list.add("bbb");
        System.out.println(list.getSize());
    }
}

