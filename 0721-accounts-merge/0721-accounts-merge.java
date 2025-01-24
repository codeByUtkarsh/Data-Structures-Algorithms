class DisJointSet{
     List<Integer> par = new ArrayList<>();
     List<Integer> size = new ArrayList<>();

     public DisJointSet(int n){
        for(int i=0;i<n;i++){
            par.add(i);
            size.add(1);
        }
     }

     //find ultimate parent
     public int findUPar(int node){
        if(node == par.get(node)) return node;
        int ulp  = findUPar(par.get(node));
        par.set(node,ulp);
        return ulp;
     }

     //union by size;
     public void unionBySize(int u , int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            par.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }else{
            par.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
     }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisJointSet ds = new DisJointSet(n);
        HashMap<String,Integer> mapMails = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mapMails.containsKey(mail)){
                    mapMails.put(mail,i);
                }else{
                    ds.unionBySize(i,mapMails.get(mail));
                }
            }
        }

        List<String>[] mergedMail = new ArrayList[n];
        for(int i=0;i<n;i++) {
            mergedMail[i] = new ArrayList<>();
        }

        for(Map.Entry<String,Integer> it: mapMails.entrySet()){
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedMail[i].size()==0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:mergedMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}