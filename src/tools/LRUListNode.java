package tools;

public class LRUListNode {

    public int key;
    public int value;
    public LRUListNode previous;
    public LRUListNode rear;

    public LRUListNode() {

    }
    public LRUListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}
