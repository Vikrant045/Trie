public class UniqueSubStrings {
    static class Node{
        Node arr[]= new Node[26];
        boolean endofword =false;
        public Node(){
        for(int i=0;i<26;i++){
arr[i]= null;
        }
    }
    }
    public static Node root = new Node();
    public static void insert(String word){
         Node curr = root;
         for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.arr[idx]==null){
                curr.arr[idx]=new Node();
            }
            curr  = curr.arr[idx];
         }
         curr.endofword= true;
    }
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count =0;
        for(int i=0;i<26;i++){
         if(root.arr[i]!=null){
         count+= countNodes(root.arr[i]);
}
        }
        return count+1;
    }
    public static void main(String args[]){
        String st ="ababa";
        for(int i=0;i<st.length();i++){
       String suffix = st.substring( i);
            insert(suffix);
        }
System.out.println(countNodes(root));
    }
}
