#include <iostream>
using namespace std;

int main() {
    int n, original, sum = 0, d;
    cin >> n;
    original = n;

    while (n > 0) {
        d = n % 10;
        sum += d * d * d;
        n /= 10;
    }

    if (sum == original)
        cout << "Armstrong number";
    else
        cout << "Not Armstrong number";

    return 0;
}