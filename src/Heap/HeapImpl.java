package Heap;


public class HeapImpl {
    public static void upHeapify(int[] arr,int index){
        int parent=(index-1)/2;   // Find the parent of index
        while(index!=0){            // when index is 0 means no need to run heapfy function
            if(arr[index]<arr[parent]){   // If parent element is higher that its children then we need to swap both the elements
                int temp=arr[index];
                arr[index]=arr[parent];
                arr[parent]=temp;
            }
            index=parent;
            parent=(index-1)/2;
        }

    }
    public static int[] buildHeap(int[] A) {
        int res[]=new int[A.length];
        for(int i=0;i<A.length;i++){
            res[i]=A[i];
            upHeapify(res,i);
        }
        return res;
    }

    public static void main(String...k){
        int[] a= {5, 13, -2, 11, 27, 31, 0, 19};
        int[] res=buildHeap(a);
        for (Integer t:res) {
            System.out.println(t);

        }
    }

}
