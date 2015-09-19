package Basics;

/**
 *
 */
class SLNode{
    private int data;
    private SLNode next;
    public SLNode(int val,SLNode n){
        this.data = val;
        this.next = n;
    }
    public int getData(){
        return this.data;
    }
    public void setData(int d){
        this.data = d;
    }
    public void setNext(SLNode nx){
        this.next = nx;
    }
    public SLNode getNext(){
        return this.next;
    }
}
public class SinglyLinkedList {
    SLNode head = null;
    public void addFront(int data){
        SLNode newn = new SLNode(data,null);
        newn.setNext(head.getNext());
        head = newn;
    }
    public void add(int data){
        if(head == null){
            head = new SLNode(data,null);
            return;
        }
        SLNode temp = head;
        while(temp.getNext() !=  null){
            temp = temp.getNext();
        }
        temp.setNext(new SLNode(data,null));
    }
    public void addAfter(int data,int ins){
        SLNode temp = head;
        while(temp.getData() !=  data){
            temp = temp.getNext();
        }
        SLNode newn = new SLNode(ins,temp.getNext());
        temp.setNext(newn);
    }
    public void printList(){
        SLNode temp = head;
        while(temp !=  null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    public void delete(int d){
        SLNode temp = head;
        SLNode prev = head;
        if(head.getData() == d){
            head = head.getNext();
            return;
        }
        while(temp.getData() !=  d){
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(temp.getNext());
    }
    public void deleteEnd(){
        SLNode temp = head;
        SLNode prev = head;
        while(temp.getNext() !=  null){
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(null);
    }
    public void clear(){
        head = null;
    }
    public void reverse(){
        SLNode tmp = null;
        while(head.getNext() !=  null){
            SLNode fw = head.getNext();
            head.setNext(tmp);
            tmp = head;
            head = fw;
        }
        head.setNext(tmp);
    }
    public static void main(String[] args) {
        SinglyLinkedList sl  =  new SinglyLinkedList();
        sl.add(007);
        sl.add(17);
        sl.addAfter(7, 19);
        sl.deleteEnd();
//        sl.printList();
        sl.clear();
        sl.add(2);
        sl.add(12);
        sl.add(22);
        sl.add(32);
        System.out.println("Added");
        sl.printList();
        sl.reverse();
        System.out.println("Reverse");
        sl.printList();
        System.out.println("Adding 1");
        sl.add(1);
        System.out.println("Check Reverse");
        sl.reverse();
        sl.printList();
    }
}