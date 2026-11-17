class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray();
        int i=0;
        int j=str.length-1;
        // while(i<j){
        //     while(i<j && !Character.isLetterOrDigit(s.charAt(i)))
        //         i++;
        //     while(i<j && !Character.isLetterOrDigit(s.charAt(j)))
        //         j--;
        //     if(Character.toLowerCase(str[i]) != Character.toLowerCase(str[j]))
        //         return false;
        //     i++;
        //     j--;
        // }
        // return true;
        return check(str,i,j);
    }
    boolean check(char[] ch,int low,int high){
        if(low>=high)
            return true;
        while(low<high && !Character.isLetterOrDigit(ch[low]))
            low++;
        while(low<high && !Character.isLetterOrDigit(ch[high]))
            high--;
        // System.out.println(ch[low]+" - "+ch[high]);
        if(Character.toLowerCase(ch[low]) != Character.toLowerCase(ch[high]))
            return false;
        return check(ch,low+1,high-1);
    }
}