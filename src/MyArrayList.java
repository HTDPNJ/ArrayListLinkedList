import java.util.ArrayList;
/*自己实现一个ArrayList*/
public class MyArrayList
{
    private Object[] elementData;
    private int size;

    public MyArrayList()
    {
    }
    public MyArrayList(int initialCapacity)
    {
        if(initialCapacity<0){
            try{
                throw new Exception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        elementData=new Object[initialCapacity];
    }

    public void add(Object obj){
        ensureCapacity();
        elementData[size++]=obj;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }
    public void remove(int index){
        rangeCheck(index);
        int numMoved=size-index-1;
        if(numMoved>0)
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        elementData[--size]=null;
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
    public boolean remove(Object obj){
        for(int i=0;i<size;i++){
            if(obj.equals(get(i))){
                remove(i);
                return true;
            }
        }
        return false;
    }
    public Object set(int index,Object obj){
        rangeCheck(index);
        Object oldValue =elementData[index];
        elementData[index]=obj;
        return oldValue;
    }
    public void add(int index,Object obj){

        rangeCheck(index);
        ensureCapacity();
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index]=obj;
        size++;
    }
    private void ensureCapacity(){
        if(size>=elementData.length){
            Object[] newArray=new Object[size*2+1];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData=newArray;
        }
    }
    public static void main(String[] args)
    {
        MyArrayList list=new MyArrayList(3);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list.getSize());
        System.out.println(list.isEmpty());
    }
}
