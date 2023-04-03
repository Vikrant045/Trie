public class InsertANDSearch_inTrie{

    static class Node{
        Node children[]= new Node[26];
        boolean endOfword = false;

         Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
         }
    }
    public static Node root = new Node();

    public static void insert(String word){  // insert
         Node currNode =root;
         for(int i=0;i<word.length();i++){
           int idx =word.charAt(i)-'a';
            if(currNode.children[idx]==null){
          currNode.children[idx]= new Node();
            }
            currNode = currNode.children[idx];
         }
         currNode.endOfword = true;
    }

    public static boolean search(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
          curr=  curr.children[idx];
        }
        return curr.endOfword == true;
    }

    public static void main(String args[]){
String words[]={"thee","a","any","there","their"};
for(int i=0;i<words.length;i++){
    insert(words[i]);
}
System.out.println(search("theeu"));
    }
}