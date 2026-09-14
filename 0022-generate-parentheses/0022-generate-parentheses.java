class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res= new ArrayList<>();
        backtrack(new StringBuilder(),0,0,n);
        return res;
    }
    public void backtrack(StringBuilder sb, int openCount,int closeCount,int n){
        if(sb.length() == 2*n){
            res.add(sb.toString());
            return;
        }
        if(openCount<n){
            sb.append('(');
            backtrack(sb,openCount+1,closeCount,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closeCount<openCount){
            sb.append(')');
            backtrack(sb,openCount,closeCount+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}