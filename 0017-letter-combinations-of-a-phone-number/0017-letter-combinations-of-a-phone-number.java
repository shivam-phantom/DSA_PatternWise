class Solution {
    List<String> result = new ArrayList<>();
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void backTrack(StringBuilder cur, int idx,String digits){

        if(idx == digits.length()){
            result.add(cur.toString());
            return;
        }

        // Identify current digit and its letters
        int digit = digits.charAt(idx) - '0';
        String letters = map[digit];

        for(char c : letters.toCharArray()){
            cur.append(c);
            backTrack(cur,idx+1,digits);
            cur.deleteCharAt(cur.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0)
            return result;
        backTrack(new StringBuilder(),0,digits);
        return result;
    }
}