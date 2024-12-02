class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        int tn = txt.length(), pn = pat.length();
        int lps[] = new int[pn];
        fill(pat,lps,pn);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i=0, j=0;
        
        while(j<tn){
            if(pat.charAt(i)==txt.charAt(j)){
                i++;
                j++;
            }else{
                if(i==0)    j++;
                else    i=lps[i-1];
            }
            
            if(i==pn){
                ans.add(j-pn);
                i=lps[i-1];
            }
        }
        return ans;
    }
    void fill(String s,int a[],int n){
        int i=0, j=1;
        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                a[j]=i;
                j++;
            }else{
                if(i==0)    j++;
                else    i=a[i-1];
            }
        }
    }
}