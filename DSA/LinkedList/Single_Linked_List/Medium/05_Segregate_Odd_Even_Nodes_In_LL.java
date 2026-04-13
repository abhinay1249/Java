// Problem Statement: Given the head of a singly linked list. Group all the nodes with odd indices followed by all the nodes with even indices and return the reordered list. 
// Consider the 1st node to have index 1 and so on. 
// The relative order of the elements inside the odd and even group must remain the same as the given input.

// Examples

// Input: 1 → 2 → 3 → 4 → 5 → 6 → Null
// Output: 2 → 4 → 6 → 1 → 3 → 5 → Null
// Explanation : Odd Nodes in LinkedList are 1,3,5 and Even Nodes in LinkedList are 2,4,6
// In Modified LinkedList all even Nodes comes before all Odd Nodes. So Modified LinkedList looks like 2→4→6→1→3→5→Null. Order of even and odd Nodes is 
// maintained in modified LinkedList.

// Input: 1 → 3 →5 → Null
// Output: 1 → 3 → 5 → Null
// Explanation: As there are no Even Nodes in LinkedList, The Modified LinkedList is same as Original LinkedList.