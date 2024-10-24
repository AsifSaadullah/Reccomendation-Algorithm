#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> t[3]; // An array of vectors to represent the 3 towers
    int rings; //variable for the rings
    int from = 0;
    int to;
    int candidate = 1;
    int move = 0;

    cout << "Please enter the number of rings to move: ";
    cin >> rings;
    cout << endl;

    while(rings <= 0){ 
        //while the input is invalid the user will be asked to keep entering till valid input is given
        cout << "Invalid Input, Try again: ";
        cin >> rings;
        cout << endl;
    }
   
    // The initial value of 'to' depends on whether n is odd or even
    if(rings % 2 == 1){
        to = 1; //if odd the rings will move to the left
    }
    else{
        to = 2; // if even the rings will move to the right
    }

    // Initialize the towers
    for(int i = rings + 1; i >= 1; i--)
        t[0].push_back(i);
    t[1].push_back(rings+1);
    t[2].push_back(rings+1);
    
    while (t[1].size() < rings + 1) { 
        //This will loop till all the rings are moved to the second tower
        
        cout << "Move #" << ++move << ": Transfer ring " << candidate << 
        " from tower " << char(from + 'A') << " to tower " << char(to + 'A') << "\n";

        //Move the ring from the "from tower" to the "to tower" 
        t[to].push_back(candidate);
        t[from].pop_back();

        // from = the tower with the smallest ring that has not just been moved
        if(t[(to+1)%3].back() > t[(to+2)%3].back()) 
            from = (to+2)%3;
        else
            from = (to+1)%3;

        // candidate = the ring on top of the t[from] tower
        candidate = t[from].back();

        // if the number of rings is odd
        if (rings % 2 == 1){
            if(candidate > t[(from+1)%3].back())
                to = ((from+2)%3);
            else
                to = ((from+1)%3);
        }

        
        // if the number of rings is even
        else{
            if(candidate > t[(from+2)%3].back())
                to = ((from+1)%3);
            else
                to = ((from+2)%3);
        }
    }
    return 0;
}