package Array;

class RemoveElementsSum {
        public static int solve(int[] A, int B) {

            int psum[]=new int[A.length];
            int countArrSum=A[0];
            int windowSize=A.length-B;
            int maxSum = Integer.MIN_VALUE;
            int ws = 0; // window start
            int we = windowSize - 1; // window end
            psum[0]=A[0];
            for(int i=1;i<A.length;i++){
                psum[i]=psum[i-1]+A[i];
                countArrSum=countArrSum+A[i];

            }
            if(B==A.length){
                return countArrSum;
            }


            while(we < A.length) {
                int unpickedElementsSum = getSumInRange(psum, ws, we);
                int currSum = countArrSum - unpickedElementsSum;
                maxSum = Math.max(maxSum, currSum);
                ws++;
                we++;
            }
            System.out.println(countArrSum);
            return maxSum;
        }

    public static int getSumInRange(int[] pf, int start, int end) {
        if(start == 0) {
            return pf[end];
        }
        return pf[end] - pf[start - 1];
    }
        public static void main(String...k){
            int A[]={5, -2, 3 , 1, 2};
            System.out.println(solve(A,3));

        }
    }
