// Problem Statement: Given the head of a singly linked list containing integers, shift the elements of the linked list to the right by k places and return the head of the modified list. 
// Do not change the values of the nodes, only change the links between nodes.

// Examples

// Input : head -> 1 -> 2 -> 3 -> 4 -> 5, k = 2
// Output : head -> 4 -> 5 -> 1 -> 2 -> 3
// Explanation :List after 1 shift to right: head -> 5 -> 1 -> 2 -> 3 -> 4.
// List after 2 shift to right: head -> 4 -> 5 -> 1 -> 2 -> 3.

// Input : head -> 1 -> 2 -> 3 -> 4 -> 5, k = 4
// Output :head -> 2 -> 3 -> 4 -> 5 -> 1
// Explanation :List after 1 shift to right: head -> 5 -> 1 -> 2 -> 3 -> 4.
// List after 2 shift to right: head -> 4 -> 5 -> 1 -> 2 -> 3.
// List after 3 shift to right: head -> 3 -> 4 -> 5 -> 1 -> 2.
// List after 4 shift to right: head -> 2 -> 3 -> 4 -> 5 -> 1. 