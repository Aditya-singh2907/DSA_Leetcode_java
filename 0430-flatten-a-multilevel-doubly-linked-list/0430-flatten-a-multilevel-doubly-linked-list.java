/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        while(temp!=null){
            if(temp.child==null) temp = temp.next;
            else{
                Node flat =flatten(temp.child);
                Node t = flat;
                while(t.next!=null){
                    t = t.next;
                }
                Node after = temp.next;
                temp.next = flat;
                flat.prev = temp;
                t.next = after;
                if(after!=null) t.next.prev = t;
                temp.child = null;
                temp = after;
            }
        }
        return head;
        
    }
}