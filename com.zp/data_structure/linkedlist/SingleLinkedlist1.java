package linkedlist;

public class SingleLinkedlist1{

    public int size = 0;

    public Node head;

    SingleLinkedlist1(){
        head = null;
        size = 0;
    }

    private class Node{
        public Object data;

         public Node next;

        public Node(Object data){
            this.data = data;
        }
    }

    public void addHead(Object obj){
        Node newNode = new Node(obj);
        if(size == 0){
             head = newNode;
             size++;
             return ;
        }
        newNode.next = head;
        head = newNode;
        size++;
        return;
    }
    public void deleteHead() throws NullPointerException{
        if(size == 0){
            throw new NullPointerException();
        }
        head = head.next;
        size--;
    }
    public Node find(Object obj){
        Node current = head;
        int tmpSize = size;
        while(tmpSize != 0){
            if(current.data.equals(obj)){
                return current;
            }
            current = current.next;
            tmpSize--;
        }
        return null;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean delete(Object obj){
        if(size == 0)
            return false;
        Node node = new Node(obj);
        Node current = head;
        Node previous = null;
        int tmpSize = size;
        while(!current.data.equals(obj)){
            if(current.next == null){
                return false;
            }
            previous = current;
            current = current.next;
        }
        if(current == head){
            head = head.next;
        }else{
            previous.next = current.next;
        }
        size--;
        return true;
        
    }
    public void display(){
        if(size == 0){
            System.out.println("[]");
            return;
        }
        if(size == 1){
            System.out.println("["+head.data+"]");
            return;
        }
        Node current = head;
        int tmpSize = size;
        while(tmpSize > 0){
            if(current == head){
                System.out.print("["+current.data+"->");
            }else if(current.next == null){
                System.out.println(current.data+"]");
            }else{
                System.out.print(current.data+"->");
            }
            current = current.next;
            tmpSize--;
        }
    }
    
}