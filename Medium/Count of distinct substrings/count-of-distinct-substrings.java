//{ Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}
// } Driver Code Ends


/*You are required to complete this method */
class GfG{
    static class Node {
        Node children[] = new Node[26];
        boolean eow ;
        
        public Node(){
            for(Node i: children){
                i=null;
            }
            eow = false;
        }
    }
    
    public static void insert(Node root,String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            curr = curr.children[idx];
        } 
        curr.eow = true;
    }
    
    public static int countprefix(Node root ){
        if(root==null){
            return 0;
        }
        
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countprefix(root.children[i]);
            }
        }
        return count+1;
    }


   public static int countDistinctSubstring(String st)
   {
       //your code here
       Node root = new Node();
       for(int i=0;i<st.length();i++){
           String s = st.substring(i);
           insert(root,s);
       }
       return countprefix(root);
   }
}