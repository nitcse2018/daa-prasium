/* Egyptian Fraction problem
   Using Greedy Algorithm
*/
#include <iostream>
using namespace std;

void EgyptianFrac(int , int );

int main()
{
	int num,den;  // num stands for numerator part and den for denominator part
	cout<<"Enter numerator and denominator respectively of the form (n/m) : ";
	cin>>num>>den;
	cout << "Egyptian Fraction Representation of "<< num << "/" << den << " is\n = ";
	EgyptianFrac(num, den);
	return 0;
}

void EgyptianFrac(int n,int d)
{
	// If either numerator or denominator is 0
	if (d == 0 || n == 0)
		return;
	// If numerator divides denominator, then simple division
	// makes the fraction in 1/n form
	if (d%n == 0)
	{
		cout << "1/" << d/n;
		return;
	}
	if (n%d == 0)// If denominator divides numerator, then the given number is not fraction
	{
		cout << n/d;
		return;
	}
	if (n > d)  // numerator is greater than denominator
	{
		cout << n/d << " + ";
		EgyptianFrac(n%d, d);
		return;
	}
	// We reach here dr > nr and dr%nr is non-zero
	// Find ceiling of dr/nr and print it as first fraction
	int c = d/n + 1;
	cout << "1/" << c << " + ";
	EgyptianFrac(n*c-d, d*c); 	// Recursion for the rest part

}
