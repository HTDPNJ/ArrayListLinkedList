//用来表示一个节点
class Node{
    Node previouse;
    Object obj;
    Node next;

    public Node()
    {
    }

    public Node(Node previouse, Object obj, Node next)
    {
        this.previouse = previouse;
        this.obj = obj;
        this.next = next;
    }

    public Node getPreviouse()
    {
        return previouse;
    }

    public void setPreviouse(Node previouse)
    {
        this.previouse = previouse;
    }

    public Object getObj()
    {
        return obj;
    }

    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}