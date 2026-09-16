import java.util.*;

// Definition for singly-linked list.
class AddtNode {
    int val;
    AddtNode next;
    AddtNode() {}
    AddtNode(int val) { this.val = val; }
    AddtNode(int val, AddtNode next) { 
     this.val = val; 
     this.next = next; 
    }
}

class AddtwoNumbersSolution {
    public AddtNode addTwoNumbers(AddtNode l1, AddtNode l2) {
       //Initialize a dummy node as a new node
        AddtNode dummy = new AddtNode(); 
        AddtNode temp = dummy; 
        int carry = 0;
        //Iterate till the end of both the lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
             //Repeat the same process for l2 as l1
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            //Carry gets added to sum in the node (carry=sum/10)
            sum += carry;
            carry = sum / 10;

            AddtNode node = new AddtNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;
    }
};
public class Add2numbers {
    static AddtNode createList(int[] arr) {
        AddtNode head = new AddtNode(arr[0]);
        AddtNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new AddtNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    static void printList(AddtNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] num1 = {2, 4, 3}; // represents 342
        int[] num2 = {5, 6, 4}; // represents 465
        AddtNode l1 = createList(num1);
        AddtNode l2 = createList(num2);

        AddtwoNumbersSolution sol = new AddtwoNumbersSolution();
        AddtNode result = sol.addTwoNumbers(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8
    }
}

