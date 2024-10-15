// Java program to solve water 
// supply problem using BFS
import java.util.*;

class GFG{

// Function to perform BFS
static int bfsUtil(int v[], boolean vis[], 
				Vector<Integer> adj[], 
				int src)
{
	
	// Mark current source visited
	vis[src] = true;
	
	// Queue for BFS
	Queue<Integer> q = new LinkedList<>(); 
	
	// Push src to queue
	q.add(src); 
	
	int count = 0;
	while (!q.isEmpty())
	{
		int p = q.peek();
		
		for(int i = 0; i < adj[p].size(); i++)
		{
			
			// When the adjacent city not 
			// visited and not blocked, push
			// city in the queue.
			if (!vis[adj[p].get(i)] &&
				v[adj[p].get(i)] == 0)
			{
				count++;
				vis[adj[p].get(i)] = true;
				q.add(adj[p].get(i));
			}
			
			// When the adjacent city is not visited 
			// but blocked so the blocked city is
			// not pushed in queue
			else if (!vis[adj[p].get(i)] && 
						v[adj[p].get(i)] == 1)
			{
				count++;
			}
		}
		q.remove();
	}
	return count + 1;
}

// Utility function to perform BFS
static int bfs(int N, int v[],
		Vector<Integer> adj[])
{
	boolean []vis = new boolean[N + 1];
	int max = 1, res;
	
	// Marking visited array false
	for(int i = 1; i <= N; i++)
		vis[i] = false;
		
	// Check for each and every city
	for(int i = 1; i <= N; i++)
	{
		
		// Checks that city is not blocked
		// and not visited.
		if (v[i] == 0 && !vis[i])
		{
			res = bfsUtil(v, vis, adj, i);
			if (res > max)
			{
				max = res;
			}
		}
	}
	return max;
}

// Driver Code
public static void main(String[] args)
{
	
	// Denotes the number of cities
	int N = 4; 
	
	@SuppressWarnings("unchecked")
	Vector<Integer> []adj = new Vector[N + 1];
	for (int i = 0; i < adj.length; i++)
		adj[i] = new Vector<Integer>();
		
	int []v = new int[N + 1];

	// Adjacency list denoting road
	// between city u and v
	adj[1].add(2);
	adj[2].add(1);
	adj[2].add(3);
	adj[3].add(2);
	adj[3].add(4);
	adj[4].add(3);

	// Array for storing whether ith
	// city is blocked or not
	v[1] = 0;
	v[2] = 1;
	v[3] = 1;
	v[4] = 0;
	
	System.out.print(bfs(N, v, adj));
}
}

// This code is contributed by Princi Singh
