class TrieNode{
    TrieNode[] child;
    boolean isleaf;
    int c;
    TrieNode(){
        child = new TrieNode[26];
        isleaf = false;
    }
}
class Trie {
    TrieNode root;
    Trie(){
        root=new TrieNode();
    }
    void insert(String word){
        TrieNode curr = root;
        for(char ch:word.toCharArray()){
            if(curr.child[ch-'a']==null){
                curr.child[ch-'a']=new TrieNode();
            }
            curr.child[ch-'a'].c++;
            curr=curr.child[ch-'a'];
        }
        curr.isleaf=true;
    }
    boolean search(String word){
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            if(curr.child[ch-'a']==null){
                return false;
            }
            curr=curr.child[ch-'a'];
        }
        return curr.isleaf;
    }
    boolean isPrefix(String prefix){
        TrieNode curr=root;
        for(char ch:prefix.toCharArray()){
            if(curr.child[ch-'a']==null){
                return false;
            }
            curr=curr.child[ch-'a'];
        }
        return true;
    }
    int countWordsStartingWith(String prefix){
        TrieNode curr=root;
        for(char ch:prefix.toCharArray()){
            if(curr.child[ch-'a']==null){
                return 0;
            }
            curr=curr.child[ch-'a'];
        }
        return curr.c;
    }
    int searchCount(String word){
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            if(curr.child[ch-'a']==null){
                return 0;
            }
            curr=curr.child[ch-'a'];
        }
        return curr.c;
    }
}
public class Main{
    public static void main(String[] args) {
        Trie t=new Trie();
        t.insert("apple");
        t.insert("apple");
        t.insert("app");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.isPrefix("ap"));
        System.out.println(t.searchCount("apple"));
        System.out.println(t.countWordsStartingWith("app"));
    }
}

