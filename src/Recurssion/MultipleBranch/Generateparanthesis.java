class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> allCombinations = new ArrayList();
        StringBuilder cur = new StringBuilder();
        recur( 0 ,  0,  n,  cur,  allCombinations); 
        return allCombinations;

        
    }

    public void recur(int curOpen, int curClosed, int n, StringBuilder cur, List<String> allCombinations){
        if(2*n==curOpen+curClosed){
            allCombinations.add(cur.toString());
            return;
        }
        if(curOpen<n) {
            curOpen +=1; 
            cur.append( "(");
            recur( curOpen ,  curClosed,  n,  cur,  allCombinations); 
            curOpen -=1; 
            cur.deleteCharAt(cur.length()-1);
            }
        if(curOpen>curClosed){
            curClosed +=1;
            cur.append( ")");
            recur( curOpen,  curClosed ,  n,  cur,  allCombinations);
            curClosed -=1;
            cur.deleteCharAt(cur.length()-1);
        }

        return  ; 

    }
}