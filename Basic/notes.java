// #include <bits/stdc++.h>
// using namespace std;

// class Node{
// public:
//     int data;
//     Node* next;

//     Node(int d){
//         data = d;
//         next = NULL;
//     }

//     void deleteAtHead(Node* &head){
//         if(head == NULL) return;   // safety
//         Node* temp = head;
//         head = head->next;
//         delete temp;
//     }

//     // FIXED: delete last node, not reverse list
//     void deleteAtTail(Node* &head){
//         if(head == NULL) return;

//         if(head->next == NULL){
//             delete head;
//             head = NULL;
//             return;
//         }

//         Node* temp = head;
//         while(temp->next->next != NULL){
//             temp = temp->next;
//         }

//         delete temp->next;
//         temp->next = NULL;
//     }

//     void deleteNode(Node* &head, int val){
//         Node* temp = head;
//         Node* prev = NULL;

//         while(temp!=NULL){
//             if(temp->data==val){
//                 if(prev==NULL){
//                     head = temp->next;
//                 }else{
//                     prev->next = temp->next;
//                 }
//                 delete temp;
//                 return;
//             }
//             prev = temp;
//             temp = temp->next;
//         }
//         cout << "Node not found" << endl;
//     }
// };

// int main(){
//     int n;
//     cin >> n;

//     Node *head = NULL;
//     Node *tail = NULL;

//     for(int i = 1; i <= n; i++){
//         Node* newNode = new Node(i);
//         if (!head) {
//             head = tail = newNode;
//         } else {
//             tail->next = newNode;
//             tail = newNode;
//         }
//     }

//     int val;
//     cin >> val;

//     head->deleteAtHead(head);
//     head->deleteAtTail(head);
//     head->deleteNode(head, val);

//     Node* temp = head;  // don't destroy head while printing
//     while(temp!=NULL){
//         cout << temp->data;
//         if(temp->next!=NULL){
//             cout << " -> ";
//         }
//         temp=temp->next;
//     }
//     cout << endl;

//     return 0;
// }







📘 Linked List Deletion – Complete Notes
✅ Question (What is the problem?)

Write a program to:

Create a singly linked list of n nodes

Delete the head node

Delete the tail node

Delete a node by given value

Print the final linked list

Example:

Input:
n = 5
delete value = 3

Initial list:
1 -> 2 -> 3 -> 4 -> 5

Final output:
2 -> 4

✅ Introduction

A singly linked list is a dynamic data structure where:

each node stores data

each node points to the next node

last node points to NULL

Structure:

[data | next]


Memory view:

[1] -> [2] -> [3] -> [4] -> [5] -> NULL


Unlike arrays:

✔ dynamic size
✔ efficient insertion/deletion
❌ no index access
❌ no backward pointer

So operations depend on pointer traversal.

✅ Core Operations in This Program

We perform three deletion operations:

Delete at head → O(1)

Delete at tail → O(n)

Delete by value → O(n)

✅ 1. Delete at Head
Idea

Remove first node and move head forward.

Algorithm
temp = head
head = head->next
delete temp

Diagram

Before:

head
 ↓
[1] -> [2] -> [3] -> [4] -> [5]


After:

head
 ↓
[2] -> [3] -> [4] -> [5]


Node [1] deleted.

Complexity
O(1)


Fastest operation in linked list.

❌ Mistake You Made Earlier

You accidentally wrote reverse linked list logic while trying to delete tail:

temp->next = prev


This flips arrows and reverses list.

Reverse result:

5 -> 4 -> 3 -> 2 -> 1


No node was deleted.

Important lesson:

👉 Reverse ≠ Delete

✅ 2. Delete at Tail (Correct Logic)
Goal

Remove the last node safely.

Idea

Go to the second-last node, then detach tail.

Algorithm
while(temp->next->next != NULL)
    temp = temp->next

delete temp->next
temp->next = NULL

Diagram

Before:

[2] -> [3] -> [4] -> [5] -> NULL
                ↑ temp


After:

[2] -> [3] -> [4] -> NULL


Node [5] deleted.

Complexity
O(n)


Traversal required.

This is optimal for singly linked list.

✅ 3. Delete Node by Value

Example: delete 3

Before:

[2] -> [3] -> [4]


Find previous node:

prev → [2]
temp → [3]


Reconnect:

[2] -----> [4]


Delete node:

delete [3]


After:

[2] -> [4]

Algorithm rule
prev->next = temp->next
delete temp

Complexity
O(n)


Search required.

🔥 Final Execution Flow

Initial:

1 -> 2 -> 3 -> 4 -> 5


After delete head:

2 -> 3 -> 4 -> 5


After delete tail:

2 -> 3 -> 4


After delete 3:

2 -> 4


Final output:

2 -> 4

🧠 Important Things to Remember (Exam Points)
⭐ Rule 1

Always follow:

store → reconnect → delete


Never delete before reconnecting pointers.

⭐ Rule 2

Never traverse using head directly.

❌ Wrong:

head = head->next


This destroys list.

✅ Correct:

Node* temp = head

⭐ Rule 3

Singly linked list has:

❌ no backward pointer
❌ no index access

So tail operations require traversal.

⭐ Rule 4

Delete tail = find second last node

temp->next->next == NULL


This is key condition.

📌 Complexity Summary
Operation	Time
Delete head	O(1)
Delete tail	O(n)
Delete value	O(n)
🧾 Final Mental Model

Think of linked list like train coaches:

[1] -> [2] -> [3] -> [4] -> [5]


Deleting tail:

👉 go to coach before last
👉 detach last coach
👉 free memory