package Array;

public class LengthLongestConsecutiveOnes {
    public static int solve(String A) {

        int n=A.length();
        int onesCount=0;
        int len=0;
        int ans=0;
        for(int j=0;j<n;j++) {
            if (A.charAt(j) == '1') {
                onesCount++;
            }
        }
        if(onesCount==n){
            return onesCount;
        }
        for(int i=0;i<n;i++){
            int left=0;
            int right=0;
            if(A.charAt(i)=='0'){
                for(int j=i-1;j>=0;j--){
                    if(A.charAt(j)=='1'){
                        left++;
                    }
                    else break;
                }

                for(int j=i+1;j<n;j++){
                    if(A.charAt(j)=='1'){
                        right++;
                    }
                    else break;
                }
            }
            if (onesCount>left+right){
                len=left+right+1;

            }
            else{
                len=left+right;
            }
            ans=Math.max(len,ans);
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String...k){

        String bin="1111111111111";
        solve(bin);

    }
}
