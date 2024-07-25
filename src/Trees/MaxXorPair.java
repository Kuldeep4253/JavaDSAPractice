package Trees;

import java.util.HashMap;

class Tries {
    int data;
    Tries[] children = new Tries[2];

    Tries() {
        children[0] = null;
        children[1] = null;
    }
}

public class MaxXorPair {
    Tries root;

    public int[] solve(int[] A) {
        int[] pxorSum=new int[A.length+1];
        root = new Tries();
        int l = A.length;
        pxorSum[0]=0;
        int ans=0;
        int ind=1;
        for (int i = 0; i < l; i++) {
                int temp=pxorSum[ind-1]^A[i];
                pxorSum[ind]=temp;
                if(temp>ans){
                    ans=temp;
                }
                ind++;
            }
        for (int i = 0; i < pxorSum.length; i++) {
           insert(pxorSum[i]);
        }
        int[] pair=new int[2];
        pair[0]=Integer.MAX_VALUE;
        pair[1]=Integer.MAX_VALUE;
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(pxorSum[0],0);
        for(int i=1;i<pxorSum.length;i++){
            int temp=ans^pxorSum[i];
            if(hs.containsKey(temp)){
                int t=hs.get(temp);
                if(pair[0]>t+1) {
                    pair[0] = t + 1;
                    pair[1] = i;
                }
                if(t+1==i){
                    pair[0] = t + 1;
                    pair[1] = i;
                }
                hs.put(pxorSum[i],i);
            }
            else{
                hs.put(pxorSum[i],i);
            }
        }
        return pair;
    }

    public void insert(int num) {
        Tries temp = root;
        for (int i = 31; i >= 0; i--) {
            int b = (num >> i) & 1;
            if (temp.children[b] == null) {
                temp.children[b] = new Tries();
            }
            temp = temp.children[b];
        }
        temp.data = num;
    }


    public int[] maxXORPair(int[] pxorSum) {
        int xorsum=0;
        int[] rslt=new int[2];
        int overallXorSum=0;
        for(int i=0;i<pxorSum.length;i++){
            for(int j=i;j<pxorSum.length;j++){
                if(i==0){
                    xorsum=pxorSum[j];
                }
                else {
                    xorsum=pxorSum[j]^pxorSum[i-1];
                }
                if(xorsum>overallXorSum){
                    overallXorSum=xorsum;
                    rslt[0]=i;
                    rslt[1]=j;
                }
            }
        }
        return rslt;
    }

    public int search(int num) {
        Tries temp = root;
        for (int i = 31; i >= 0; i--) {
            int b = (num >> i) & 1;
            int t = 1 - b;
            if (temp.children[t] == null) {
                temp = temp.children[b];
            } else {
                temp = temp.children[t];
            }
        }
        return temp.data ^ num;
    }
    public int searchDiffLogic(int[] num,Tries root) {
        int overallmax = 0;
        for (int i = 0; i < num.length; i++) {
            int no = num[i];
            int xorsum = 0;
            Tries curr = root;
            for (int j = 31; j >= 0; j--) {
                // This if condition will work when bit is 1
                if (checkBit(no, j) == true) {
                    // For maximum xor sum we find the different bit like 0
                    if (curr.children[0] != null) {
                        xorsum = xorsum | (1 << j);
                        curr = curr.children[0];
                    }
                    // When different bit is not present then we move forward bcz same bit xor opr give 0
                    else {
                        curr = curr.children[0];
                    }
                }
                // This if condition will work when bit is 0
                else {
                    // For maximum xor sum we find the different bit like 1
                    if (curr.children[1] != null) {
                        xorsum = xorsum | (1 << j);
                        curr = curr.children[1];
                    }
                    // When different bit is not present then we move forward bcz same bit xor opr give 1
                    else {
                        curr = curr.children[1];
                    }
                }

            }
            if (xorsum > overallmax) {
                overallmax = xorsum;
            }
        }
        return overallmax;
    }
    public boolean checkBit(int a,int b){
        int c=a & (1 << b);
        if(c!=0){
            return true;
        }
        return false;
    }
    public static void main(String...k){

        MaxXorPair mp=new MaxXorPair();
        mp.root = new Tries();
        int[] t={15,25,23};
        for(int i=0;i<t.length;i++){
            mp.insert(t[0]);
        }
        System.out.println(mp.searchDiffLogic(t,mp.root));
    }
}
