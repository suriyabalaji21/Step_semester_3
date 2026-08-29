#include <iostream>
using namespace std;

void classifyNumber(int number) {
    if (number > 0) {
        cout << "Positive\n";
    } else if (number < 0) {
        cout << "Negative\n";
    } else {
        cout << "Zero\n";
    }
}