package Basics;

/**
 * Ashesh Vidyut (Drift King) *
 */
class CLNode{
    private int data;
    private CLNode next=this;
    public CLNode(int d,CLNode nx){
        this.data=d;
        this.next=nx;
    }
    public void setNext(CLNode nx){
        this.next=nx;
    }
    public CLNode getNext(){
        return this.next;
    }
}
public class CircularLinkedList {
    CLNode head;
    public void addLast(int d){
        if(head==null){
            head=new CLNode(d,head);
            return;
        }
        CLNode cn=new CLNode(d,head);
        CLNode tmp=head;
        while(tmp.getNext()!=head){
            tmp=tmp.getNext();
        }
        tmp.setNext(cn);
    }
    public void addFront(int d){

    }
}
