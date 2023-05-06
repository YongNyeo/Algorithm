class Solution {
    public String solution(int n, int t, int m, int p) {
        String sb ="";
        String k ;
        String result ="";
        
        int w=0;
        while(true){
            if (sb.length()>=t*m) break;
            k = Integer.toString(w,n);
            sb+=k;
            w+=1;
        }
        char[]q = sb.toCharArray();
        for (int i=p-1;i<q.length;i+=m){
            if (result.length()==t){
                break;
            }
            result += Character.toUpperCase(q[i]);
        }
        
        return result;
    }
}