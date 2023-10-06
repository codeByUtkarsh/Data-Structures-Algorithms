//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
        // add your code here
        if (odd == null || odd.next == null || odd.next.next == null) {
            return;
        }

        // Extract alternative nodes starting from second node
        Node even = odd.next;
        Node evenStart = even;
        Node oddStart = odd;
        while (odd != null && even != null && odd.next != null) {
            odd.next = odd.next.next;
            if (even.next != null) {
                even.next = even.next.next;
            }
            odd = odd.next;
            even = even.next;
        }

        // Reverse the extracted list
        Node prev = null;
        Node current = evenStart;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        evenStart = prev;

        // Append the extracted list at the end of the original list
        odd = oddStart;
        while (odd.next != null) {
            odd = odd.next;
        }
        odd.next = evenStart;
    }
}
