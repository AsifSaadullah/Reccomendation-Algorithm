#include <iostream>
#include <cmath>
using namespace std;
bool test_function(int q[], int c) { // same tester function as the 1d array version
    for (int i = 0; i < c; i++) {
        if ((q[i] == q[c]) || (c - i == abs(q[c] - q[i]))) {
            return false; 
        }
    }
    return true; 
}
int n_queens(int n) {
   // Dynamically declare an array of size n and initialize the first element to 0.
    int* q = new int[n];

    int sum = 0, c = 0;     
    q[c] = 0;                 
    c++;                      

    while (c > -1) { //if column reaches -1 that means all solutions have been found and it will end the loop
        if (c == n) {  // if all columns equals the queens then that means a solution have been found 
            sum++;     
            c--;       // backtrack to find another solution
        }
        else 
            q[c] = -1; // otherwise we start at row -1 at the next row
        while (c >= 0 && c < n) {  // while our column number is between 0 and n(number of queens)
            q[c]++; 
            if (q[c] == n) // if q[c] equals n that means no spot was found for the queen and backtracking has to happen to find a spot
                c--;  
            else {   
                if (test_function(q,c) == true) { // test if placing a queen in that row at column is ok 
                    c++; // if it passes all the tests then it will go to the next column 
                    break;
                }
            }
        }
    }

    delete []q; // This will delete the array 
    return sum; // returns all the solutions once they have been found
}
int main() {
   int queens;
   cout << "Enter a positive integer: ";
   cin >> queens;

   while(queens <= 0){ // just incase the user decides to put a invalid input it will loop until a valid input is entered
    cout << "Invalid Input, Try Again: ";
    cin >> queens;
   }

   for (int i = 1; i <= queens; ++i){
    cout << "There are " << n_queens(i) << " solutions to the " << i << " queens problem.\n";
   }
   return 0;
}