class Solution {
    class Row implements Comparable<Row>{
        int soldier ;
        int idx;

        public Row(int s, int i){
            this.soldier =s;
            this.idx = i;
        }

        @Override
        public int compareTo(Row r2){
            if(this.soldier == r2.soldier){
                return this.idx - r2.idx;
            }else{
                return this.soldier - r2.soldier;
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0;i<mat.length;i++){
            int c =0;
            for(int j=0;j<mat[0].length;j++){
                c += mat[i][j] == 1 ?1 :0;
            }
            pq.add( new Row(c,i));

        }
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.remove().idx;
        }
        return ans;
    }
}