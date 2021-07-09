package linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        SingleLinkedlist1 linkedlist = new SingleLinkedlist1();
        linkedlist.addHead("D");
        linkedlist.addHead("C");
        linkedlist.addHead("B");
        linkedlist.addHead("A");
        linkedlist.display();
        System.out.println(linkedlist.find("C"));
        linkedlist.deleteHead();
        linkedlist.display();
        linkedlist.delete("C");
        linkedlist.display();
        while (!linkedlist.isEmpty()) {
            linkedlist.deleteHead();
        }
        linkedlist.display();
    }
}