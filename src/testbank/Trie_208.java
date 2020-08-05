package testbank;

public class Trie_208 {

    public class TreeNode{

        char value;

        boolean isEnd;

        TreeNode[] next;

        TreeNode(char c) {
            this.isEnd = false;
            this.value = c;
            // 这里如果字符不是位于a-z之间
            this.next = new TreeNode[26];
        }
    }

    public TreeNode root;

    public Trie_208() {
        root = new TreeNode('*');
    }

    public void insert(String word) {
        TreeNode temp=root;

        for (int i = 0; i <word.length() ; i++) {
            char c =word.charAt(i);
            if (temp.next[c - 'a'] == null) {
                temp.next[c - 'a'] = new TreeNode(c);
            }
            temp = temp.next[c-'a'];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode temp = root;
        for (int i = 0; i <word.length() ; i++) {
            char c = word.charAt(i);
            if (temp.next[c - 'a'] == null) {
                return false;
            }
            temp = temp.next[c-'a'];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode temp = root;
        for (int i = 0; i <prefix.length() ; i++) {
            char c = prefix.charAt(i);
            if (temp.next[c - 'a'] == null) {
                return false;
            }
            temp = temp.next[c-'a'];
        }
        return true;
    }
}
