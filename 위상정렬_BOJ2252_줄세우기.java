import java.util.*;

public class 위상정렬_BOJ2252_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] inDegree = new int[32001];
		
		ArrayList<Integer>[] outDegree = new ArrayList[32001];
		for(int i = 1; i<=N; i++) {
			outDegree[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<M ; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			inDegree[second] +=1;
			outDegree[first].add(second);
		}
		
		
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 1; i<=N; i++) {
			if(inDegree[i]==0) que.add(i);
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		while(!que.isEmpty()) {
			
			int now = que.poll();
			ans.add(now);
			
			for(int i = 0; i<outDegree[now].size(); i++) {
				
				int next = outDegree[now].get(i);
				inDegree[next] -= 1;
				if(inDegree[next] == 0) que.add(next);

			}
		}
		
		for(int i = 0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		
	}
}
