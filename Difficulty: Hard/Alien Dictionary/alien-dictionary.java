//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            int k = Integer.parseInt(sc.nextLine());
            int n = words.length;
            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, k);
            if (order.length() == 0) {
                System.out.println("false");
                System.out.println("~");
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                System.out.println("~");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2) {
                        return Integer.compare(a.length(), b.length());
                    }

                    return Integer.compare(index1, index2);
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String findOrder(String[] dict, int k) {
        // Write your code here
        String ans = "";
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[k];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        char c = 'a';
        for(int i=0;i<dict.length-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int min = Math.min(s1.length(),s2.length());
            for(char j=0;j<min;j++){
                if(s1.charAt(j) != (s2.charAt(j))){
                    adj.get(s1.charAt(j)-c).add(s2.charAt(j)-c);
                    break;
                }
            }
        }
        for(int i=0;i<k;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i=0;i<k;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(topo.size()!=k){
            return "";
        }
        for(int it:topo){
            ans = ans + (char) (it+(int)c) ;
        }
        return ans;
    }
}