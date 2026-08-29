#include<iostream>
using namespace std;
int main(){
    int n;
    bool isprime = true;
    cin>>n;
    for(int i =2;i<n;i++){
        if(n%i ==0){
           isPrime =false;
           break;

            }
        }
        if(isPrime)
           cout<<"Prime";
        else
           cout<<"Not Prime";
        return 0;
    }l
