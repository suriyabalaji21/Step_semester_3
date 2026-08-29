#include <iostream>
using namespace std;

int main() {
    int number1, number2;

    cout << "Enter two numbers: ";
    cin >> number1 >> number2;

    while (number2 != 0) {
        int remainder = number1 % number2;
        number1 = number2;
        number2 = remainder;
    }

    cout << "GCD = " << number1;

    return 0;
}