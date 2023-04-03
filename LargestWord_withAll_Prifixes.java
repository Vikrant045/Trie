public class LargestWord_withAll_Prifixes {
    
    static class Node{
        Node children[]=new Node[26];
        boolean endOfword =false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String st){
        Node curr = root;
        for(int i=0;i<st.length();i++){
            int idx = st.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            curr = curr.children[idx];

        }
        curr.endOfword = true;
    }
    public static String ans ="";
    public static void largestWord(Node root,StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].endOfword==true){
               char ch = (char)(i+'a');
               temp.append(ch);

               if(temp.length()>ans.length()){
                ans= temp.toString();
               }
               largestWord(root.children[i], temp);
               temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String []args){
String words[]={"a","banana","app","apple","ap","appl","apply"};
for(int i=0;i<words.length;i++){
    insert(words[i]);
}
largestWord(root, new StringBuilder(""));
System.out.println(ans);
    }
}
