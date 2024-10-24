#include <iostream>
using namespace std;

bool tester_function(int q[], int man) {

     int mp[3][3] = {{ 0, 2, 1 }, // Man 0 likes women 0 the most and 1 the least
                     { 0, 2, 1 }, // Man 1 likes women 0 the most and 1 the least
                     { 1, 2, 0 }}; // Man 2 likes women 1 the most and 0 the least 
                     
     int wp[3][3] = {{ 2, 1, 0 }, // Women 0 likes man 2 the most and 0 the least
                     { 0, 1, 2 }, // Woman 1 likes man 0 the most and 2 the least
                     { 2, 0, 1 }}; // Woman 2 likes man 2 the most and 1 the least

    		//Test 1
            for(int i = 0; i < man; i++){ //The purpose of this test is to check if the man and woman would are already togther are unstable
    			if( q[i] == q[man]){
                    //this is to check if the current women is already been married to the other men.
                    return false;
                }
            }

            //Test 2
            for(int i = 0; i < man; i++){ 
                // this test is to check if the current man prefer the new woman rather than the current woman or if the current woman wants the new man more than her current man
                // if both these conditions are true than it will return false.
                 if( mp[man][q[i]] < mp[man][q[man]] && wp[q[i]][man] < wp[q[i]][i] ){ 
                 return false; 
                 }
            }

            //Test 3
            for(int i = 0; i < man; i++){ 
                if( wp[q[man]][i] < wp[q[man]][man] && mp[man][q[man]] < mp[i][q[i]] ){ 
                    //if the new man prefers the current woman to his parter or if the current woman prefers the new man to her partner this will make the marraige unstable
                    return false;
                }
            }
            return true; // if all the conditions are false return true.
}
 
void print(int q[]) {
    //print function if all the tests are proven true.
    static int solution_counter = 1;
    cout << "This is solution number " << solution_counter++ << ":\nMan\tWoman\n"; 
    for (int i = 0; i < 3; ++i)
        cout << i << "   " << q[i] << endl;
    cout << endl;
}

int main(){
    int man = 0; //current man 
	int q[3] = {}; 
    q[man] = 0;  
 
 	while(man != -1){ //if the backtrack goes before 0, that is going to mean we are out of solutions.
 		man++; 
 		if(man > 2){
 			print(q); //if the solution is found then we print 
 			man--; //Backtrack
		 }
		 
		 else{
		 	q[man] = -1;
		 }
         while(man >= 0){
            q[man]++; //move to the next women
            if(q[man] > 2){ 
                man--; //Backtrack
            }
            else if(tester_function(q,man) ){ //call the okay function, if it is okay then we break and start from the beginning of the loop	
            break;
            }
         }
    }
    return 0;
}