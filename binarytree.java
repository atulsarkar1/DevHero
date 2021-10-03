// "static void main" must be defined in a public class.


class Node{
    Node left;
    Node right;
    int data;
    public Node(int data){
        this.data = data;
    }
}
public class BinaryTree {
    
    public void printInOrder(Node root){
    Stack<Node> stack = new Stack();   
    Node node = root;
        while(true){
            if(node !=null){
                stack.push(node);
                node = node.left;
            }else{
                if(stack.isEmpty()) break; //if node is null and stack empty break out of loop
                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }
    
    public Node addNode(int data, Node head){
        Node tempHead = head; 
        Node newNode = new Node(data);
        if(head ==null){
            head = newNode;
            return head;
        }
        Node prev =null;
        while(head !=null){
            prev =head;
            if(head.data < data){
                head = head.right;
            }else {
                head = head.left;
            }
        }
        if(prev.data < data){
            prev.right = newNode;
        }else {
            prev.left = newNode;
        }
        return tempHead;
    }
    
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(11, head);
        head = bt.addNode(16, head);
        head = bt.addNode(2, head);
        head = bt.addNode(-1, head);
        bt.printInOrder(head);
    }
}