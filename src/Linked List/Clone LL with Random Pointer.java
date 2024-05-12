/*
class Node {
    int data;
    Node next, arb;

    Node(int d) 
    { 
        data = d;
        next = arb = null; 
        
    }
}*/

class Clone {
    //Function to clone a linked list with next and random pointer.
    
    //Normal Cloning without Random Pointers
    Node normalClone(Node head){
        Node cloneHead = new Node(head.data);
        Node cloneTail = cloneHead;
        Node temp = head.next;
        while(temp!=null){
            cloneTail.next = new Node(temp.data);
            cloneTail = cloneTail.next;
            temp = temp.next;
        }
        return cloneHead;
    }
    
    //Approach 1 with Map
    //TC : O(N)
    //SC : O(N)
    Node copyListApproach1(Node head) {
        // your code here
        
        if(head==null || head.next==null){
            return head;
        }
        
        Node cloneHead = normalClone(head);
        Map<Node,Node> map = new HashMap<>();
        Node curr1 = head;
        Node curr2 = cloneHead;
        while(curr1 != null){
            map.put(curr1,curr2);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        curr1 = head;
        curr2 = cloneHead;
        while(curr1!=null){
            curr2.arb = map.get(curr1.arb);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return cloneHead;
    }
    
    
    //Approach 2
    //TC : O(N)
    //SC : O(1)
    Node copyList(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        
        Node cloneHead = normalClone(head);
        
        //Modifying links
        Node original = head;
        Node clone = cloneHead;
        while(original!=null && clone!=null){
            Node originalNext = original.next;
            original.next = clone;
            original = originalNext;
            
            Node cloneNext = clone.next;
            clone.next = original;
            clone = cloneNext;
        }
        
        
        //Adding Random pointer of Clone list
        Node curr = head;
        while(curr!=null){
            if(curr.next!=null){
                curr.next.arb = curr.arb!=null?curr.arb.next:curr.arb;
                curr = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }
        
        //Reverting the Links
        original = head;
        clone = cloneHead;
        while(original!=null && clone!=null){
            original.next = clone.next;
            original = original.next;
            
            if(original!=null){
                clone.next = original.next;
                clone = clone.next;
            }
        }
        return cloneHead;
    }
}
