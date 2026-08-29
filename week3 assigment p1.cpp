#include <iostream>
using namespace std;

void checkVotingEligibility(int age) {
    if (age >= 18) {
        cout << "Eligible to vote\n";
    } else {
        cout << "Not eligible to vote\n";
    }
}