#include <iostream>
using namespace std;

void sumOfNaturalNumbers(int n) {
    int sum = 0;
    int counter = 1;
    while (counter <= n) {
        sum += counter;
        counter++;
    }
    cout << "Sum of numbers from 1 to " << n << " = " << sum << "\n";
}