// Problem Statement: Given the head of a singly linked list containing integers, reverse the nodes of the list in groups of k and return the head of the modified list. 
// If the number of nodes is not a multiple of k, then the remaining nodes at the end should be kept as is and not reversed.
// Do not change the values of the nodes, only change the links between nodes.

// Examples

// Input : 1 -> 2 -> 3 -> 4 -> 5, k = 2
// Output :2 -> 1 -> 4 -> 3 -> 5
// Explanation :The groups 1 -> 2 and 3 -> 4 were reversed as 2 -> 1 and 4 -> 3.

// Input : 1 -> 2 -> 3 -> 4 -> 5, k = 3
// Output : 3 -> 2 -> 1 -> 4 -> 5
// Explanation :The groups 1 -> 2 -> 3 were reversed as 3 -> 2 -> 1.
// Note that 4 -> 5 was not reversed.