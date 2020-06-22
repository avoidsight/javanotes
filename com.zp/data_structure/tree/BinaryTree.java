import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTree<T>{
    public List nodeList = null;

    public BinaryTree(){
        nodeList = new ArrayList<Node>();
    }
    //使用链表初始化二叉树
    public BinaryTree(List<Node> nodeList){
        for (int i = 0,size =nodeList.size()/2 ; i < size; i++) {
            Node node = nodeList.get(i);
            node.left = nodeList.get(2*i+1);
            if((2*i+2)<=nodeList.size()){
                node.right = nodeList.get(2*i+2);
            }
        }
    }

    public static class Node<T>{
        T data;
        Node left;
        Node right;

        Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preOrderTravers(Node node){
        if(node ==null) return; 
        System.out.println(node.data);
        preOrderTravers(node.left);
        preOrderTravers(node.right);
    }

    public void insertLeft(Node node,T data){
        if(node == null) return;
        if(node.left == null){
            node.left = new Node(data);
        }else{
            Node newNode = new Node(data);
            newNode.left = node.left;
            node.left = newNode;
        }
    }

    
    public static void main(String[] args) {
        int intArray[] = {1,2,3,4,5,6,7,8,9};
        List<Integer> list = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        List<Node> nodeList = new ArrayList<Node>();
        for (Integer i : list) {
            Node node = new Node(i);
            nodeList.add(node);
            
        }

        System.out.println(list.toString()+"^_^");

        BinaryTree binaryTree = new BinaryTree<>(nodeList);
        preOrderTravers(nodeList.get(0));
    }

}