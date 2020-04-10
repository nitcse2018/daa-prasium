/*
 Rod Cutting Maximization problem
 using Dynamic Programming
 */
#include <iostream>
#include <string>
using namespace std;

int rodCut(int price[], int n)      // finds maximum profit
{
	int T[n + 1]; 	// T[i] stores maximum profit achieved from rod of length i
	for (int i = 0; i <= n; i++) 	// initialize maximum profit to 0
		T[i] = 0;
	for (int i = 1; i <= n; i++)  // consider rod of length i
	{
		for (int j = 1; j <= i; j++)      		// divide the length i into two rods of length j & i-j each and take maximum
			T[i] = max(T[i], price[j - 1] + T[i - j]);
	}
	return T[n];        // T[n] stores maximum profit achieved from rod of length n

}

int main()
{
	int price [] = { 2, 6, 9, 10, 11, 18, 18, 21 }; // prices for length 1 to n,here n=8
	int rodlength = 6; // rod length
	cout << "Profit is " << rodCut(price, rodlength);
	return 0;
}
