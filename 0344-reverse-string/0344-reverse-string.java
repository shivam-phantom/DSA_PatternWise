class Solution {
    public void reverseString(char[] s) {
        // int l = 0;
        // int r = s.length-1;
        // while(l<r){
        //     char temp = s[l];
        //     s[l]=s[r];
        //     s[r]=temp;
        //     l++;
        //     r--;
        // }
        rev(s,0);
    }
    public void rev(char[] s, int i){
        int n = s.length;
        if(i>=n/2)
            return;
        rev(s,i+1);
        System.out.println(s[i]);
        char tmp = s[n-1-i];
        s[n-1-i] = s[i];
        s[i] = tmp;
    }
}