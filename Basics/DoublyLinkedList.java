package Basics;

/**
 * Ashesh Vidyut (Drift King) *
 */
class Node{
    private int data;
    private Node next;
    private Node prev;
    public Node(int d,Node n,Node p){
        this.data=d;this.next=n;this.prev=p;
    }
    public void setData(int d){
        this.data=d;
    }
    public int getData(){
        return this.data;
    }
    public void setNext(Node n){
        this.next=n;
    }
    public void setPrev(Node p){
        this.prev=p;
    }
    public Node getNext(){
        return this.next;
    }
    public Node getPrev(){
        return this.prev;
    }
}
public class DoublyLinkedList {
    Node head;
    public void addLast(int d){
        if(head == null){
            head = new Node(d, null, null);
            return;
        }
        Node temp=head;
        while(temp.getNext()!=null){
            temp = temp.getNext();
        }
        Node newn = new Node(d, null, null);
        temp.setNext(newn);
        newn.setPrev(temp);
    }
    public void addAfter(int d, int ins){
        Node temp=head;
        while(temp.getData()!=d){
            temp = temp.getNext();
        }
        Node nen = new Node(d, null, null);
        nen.setNext(temp.getNext());
        temp.setNext(nen);
        nen.setPrev(temp);
        temp.getNext().setPrev(nen);
    }
    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.getData());
            temp=temp.getNext();
        }
    }
}
