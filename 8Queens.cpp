#include <iostream>
#include <cmath>
using namespace std;
bool test_function(int q[], int c) {
    for (int i = 0; i < c; i++) {
        if ((q[i] == q[c]) || (c - i == abs(q[c] - q[i]))) {
            return false; 
        }
    }
    return true; 
}
void  Solution_Printer(int q[]){
    static int solution_counter = 1; 
    cout << "This is solution number " << solution_counter++ << endl;
    for(int i = 0; i < 8; i++){
        cout << q[i] << endl;
    }
    cout << endl; 
}
int main(){
    int q[8] = {0}; 
    int c = 0;
    q[0] = 0; 
    int solution_count = 0; 
    // i was runing into the issue of the program printing too many solutions so i declared a varible in the main program to stop when the solutions reach 92.

    while(c >= 0){
        while(q[c] < 8){ 
            q[c]++;
            if(q[c] == 8){ // If no spots were found for the queens it will backtrack
                c--; // 
            }
            else if(test_function(q, c)){ // If the queen can be placed in the current position
                if(c == 7){ // if all the queens are in a valid position it will print the solution
                    Solution_Printer(q);
                    solution_count++; 
                    if(solution_count >= 92){ // once 92 solutions are found it will end the program
                        return 0;
                    }
                }
                else{
                    c++; 
                    q[c] = -1; 
                }
            }
        }
        if(c >= 0){
            q[c] = -1; 
            c--; 
        }
    }
    return 0;
}