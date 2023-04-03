public class WordBreak_Problem {
    
    static class Node{
        Node children []= new Node[26];
        boolean endOfword  = false;

        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root = new Node(); 
    public static void insert(String word){ // insert
        Node curr = root;
      for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            curr= curr.children[idx];
     }
     curr.endOfword= true;

    }
    public static boolean search(String word){ // search
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                          return false;
            }
            curr= curr.children[idx];
        }
        return curr.endOfword ==true;
    }
    public static boolean wordBreak(String st){  // wordbreak

        if(st.length()==0){
            return true;
        }
        for(int i=1;i<=st.length();i++){

        if( search(st.substring(0, i))&& wordBreak(st.substring(i))){
            return true;
        }
        }
        return false;
    }

    public static void main(String args[]){

        String arr[]={"i","like","sam","samsung","mobile","ice"};

        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        String st ="ilikesamsungpd";
        System.out.println(wordBreak(st));

    }
}
