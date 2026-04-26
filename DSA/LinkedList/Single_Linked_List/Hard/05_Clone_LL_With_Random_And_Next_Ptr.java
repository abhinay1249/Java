// Problem Statement: Given a linked list where every node in the linked list contains two pointers:

// ‘next’ which points to the next node in the list.
// ‘random’ which points to a random node in the list or ‘null’.
// Create a ‘deep copy’ of the given linked list and return it.

// Example 1:

// Input: [[1, -1], [2, 0], [3, 4], [4, 1], [5, 2]]
// Output: 1 2 3 4 5, true
// Explanation: All the nodes in the new list have same corresponding values as original nodes.
// All the random pointers point to their corresponding nodes in the new list.
// 'true' represents that the nodes and references were created new.

// Example 2: 
// Input: [[5, -1], [3, -1], [2, 1], [1, 1]]
// Output: 5 3 2 1, true
// Explanation: All the nodes in the new list have same corresponding values as original nodes.
// All the random pointers point to their corresponding nodes in the new list.
// 'true' represents that the nodes and references were created new.
// [[5, -1], [3, -1], [2, -1], [1, -1]] will be incorrect, although it has the same values.