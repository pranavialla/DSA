package BinarySearch;

class SingleElementInSortedArray{
    int getElement(int[] array){
        int n= array.length;
        int l =0;
        int r = array.length-1;
        while(l<r){
            int m = l+(r-l)/2;
            if(m%2 != 0 ){
                if(array[m]==array[m-1]){
                    l=m+1;
                }
                else{
                    r = m;
                }
            }
            else{
                if(m!=array.length-1 && array[m]==array[m+1]){
                    l=m+1;
                }
                else{
                    r=m;
                }
            }
        }
        return l;
    }
}