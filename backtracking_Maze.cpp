/* This is backtracking based problem
  An extension of Rat in a Maze problem
  The robot can move in all 4 directions, North,East,South and West
  Robot can move only into the open cells
*/
#include <iostream>
#include <cstring>
using namespace std;
#define N 4                  // Defines the size of the Maze, N x N maze

// checks if cell (x, y) is valid or not
bool isValidCell(int x, int y)
{
	if (x < 0 || y < 0 || x >= N || y >= N)
		return false;

	return true;
}

void countPaths(int maze[N][N], int x, int y, int visited[N][N], int& count)
{
	// if destination (bottom-rightmost cell) is found,increment the path count
	if (x == N - 1 && y == N - 1)
	{
		count++;
		return;
	}

	// mark current cell as visited
	visited[x][y] = 1;

	// if current cell is a valid and open cell,
	if (isValidCell(x, y) && maze[x][y])
	{
		if (x + 1 < N && !visited[x + 1][y])             	// move down (x, y) --> (x + 1, y)
			countPaths(maze, x + 1, y, visited, count);

		if (x - 1 >= 0 && !visited[x - 1][y])           	// move up (x, y) --> (x - 1, y)
			countPaths(maze, x - 1, y, visited, count);

		if (y + 1 < N && !visited[x][y + 1])                // move right (x, y) --> (x, y + 1)
			countPaths(maze, x, y + 1, visited, count);

		if (y - 1 >= 0 && !visited[x][y - 1])               // move left (x, y) --> (x, y - 1)
			countPaths(maze, x, y - 1, visited, count);
	}

	visited[x][y] = 0;	// backtrack from current cell and remove it from current path
}

int main()
{
	int maze[N][N] =
	{
		{ 1, 1, 1, 1 },
		{ 1, 1, 0, 1 },
		{ 0, 1, 0, 1 },
		{ 1, 1, 1, 1 }
	};
    int count = 0;   // variable to keep track of number of unique paths from source to destination
	int visited[N][N]; // 2D matrix to keep track of cells involved in current path
	memset(visited, 0, sizeof visited);
	// start from source cell (0,0)
	countPaths(maze, 0, 0, visited, count);
	cout << "Total number of unique paths are " << count;
	return 0;
}
