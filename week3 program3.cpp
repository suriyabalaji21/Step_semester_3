
#include <iostream>
using namespace std;

int main() {
    int n, original, reverse = 0;

    cin >> n;
    original = n;

    while (n > 0) {
        reverse = reverse * 10 + n % 10;
        n = n / 10;
    }

    if (original == reverse)
        cout << "Palindrome";
    else
        cout << "Not Palindrome";

    return 0;
}