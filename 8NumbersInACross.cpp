#include <iostream>
using namespace std;
bool checker(int q[], int c) {
    // This is the checker function to make sure that the placement of the number is ok.
    for (int i = 0; i < c; i++) {
        if (q[i] == q[c]) 
        //if the number at the spefiic colunm is the same to any other column before it, it will return false. Otherwise it will return true
            return false;
    }
    return true; 
    //if there are no conflits found within the number placement is will return true.
}
void print(int q[]) { 
    //if a solution is found it will pass through this function to print it.
    static int sol = 1; 
    // i used a static varible here to count and print the number of solutions and it will stay the same even if the function is called at different times
    cout << "This is solution number: " << sol++ << endl; 
    cout << " " << q[1] << q[4] << endl; 
    cout << q[0] << q[2] << q[5] << q[7] << endl; 
    cout << " " << q[3] << q[6] << endl; 
    cout << endl; 
}
int main() {
    int q[8] = {0}; 
    int c = 0; 
    int solutions = 0;

    // Loop to find all solutions
    while (solutions < 4) { 
        //This will keep looping till all the solutions are found. Just so no unnessary and random solutions get printed.
        if (c == 8) { 
            //if all the numbers are placed it will print the solution and go to backtrack after it prints.
            print(q); 
            solutions++; 
            c--; // Backtrack
        }
        else { // If not all numbers are placed
            q[c]++; // Move to the next number in the current column
            if (q[c] == 9) { // If the number exceeds 8 it will reset the number to 0;
                q[c] = 0; 
                c--; // Backtrack 
            }
            else { // If the number is within range (1 to 8)
                if (checker(q, c)){ // check if the placement of the number is valid by passing it through the function
                    c++; // Move to the next column
                }
            }
        }
    }
    return 0;
}