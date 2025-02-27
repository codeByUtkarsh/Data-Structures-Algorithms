class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int k = list.size();
            if(operations[i].equals("+")){
                list.add(list.get(k-1)+list.get(k-2));
            }else if(operations[i].equals("D")){
                list.add(list.get(k-1)+list.get(k-1));
            }else if(operations[i].equals("C")){
                list.remove(list.get(k-1));
            }else{
                list.add(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        for(Integer it:list){
            sum+=it;
        }
        return sum;
    }
}