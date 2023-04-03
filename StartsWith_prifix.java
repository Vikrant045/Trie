public class StartsWith_prifix {
    
    static class Node{
        Node children[]= new Node[26];
        boolean endOdword = false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]= null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
          Node curr = root;
          for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            curr = curr.children[idx];
          }
          curr.endOdword= true;
    }
    public static boolean search(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr= curr.children[idx];
        }
        return true;
    }
    public static void main(String args[]){
String words[]={"apple","app","mango","man","woman"};

for(int i=0;i<words.length;i++){
    insert(words[i]);
}
       System.out.println(search("wol"));
    }
}
