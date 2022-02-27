class Solution
{
    int countNodes(Node head){
        Node curr = head;
        int count=1;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }
    
    Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node curr = head;
        Node prev=null,next=null;
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr =next;
        }
        return prev;
    }
    
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        //Your code here
        int c = countNodes(head);
        int mid = c/2;
        int count =0;
        boolean flag = true;
        Node midNode = head;
        while(count!=mid){
            midNode = midNode.next;
            count++;
        }
        
        Node revHead = reverse(midNode);
        while(revHead!=null){
            if(revHead.data!=head.data){
                flag=false;
                break;
            }
            revHead = revHead.next;
            head = head.next;
        }
        return flag;
        
    }    
}