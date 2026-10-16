// Problem Statement: Find the validity of an input string s that only contains the letters '(', ')' and '*'.
// A string entered is legitimate if
// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

// Example 1:

// Input : s = (*))
// Output : true
// Explanation : The * can be replaced by an opening '(' bracket. The string after replacing the * mark is "(())" and is a valid string.

// Example 2:

// Input : s = *(()
// Output : false
// Explanation : The * replaced with any bracket does not form a valid string.