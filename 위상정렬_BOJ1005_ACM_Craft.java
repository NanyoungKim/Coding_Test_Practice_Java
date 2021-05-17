import java.util.*;
//12:37
public class 위상정렬_BOJ1005_ACM_Craft {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t<T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] timeArr = new int[N+1];
			int[] indegree = new int[N+1];
			
			ArrayList<Integer>[] outdegree = new ArrayList[N+1];
			for(int i = 1; i<=N; i++) {
				outdegree[i] = new ArrayList<Integer>();
			}
			
			for(int i = 1; i<=N; i++) {
				timeArr[i] = sc.nextInt();		//각 도시를 건설하는데에 필요한 시간 
			}
			
			for(int i = 0; i<K; i++) {
				int curV = sc.nextInt();
				int nextV = sc.nextInt();
				
				outdegree[curV].add(nextV);			//현재 노드와 연결된 노드 정보 
				indegree[nextV] += 1;				//들어오는 엣지 수 카운팅 
				
			}
			
			int W = sc.nextInt();
			int[] timeSum = new int[N+1];
			
			Queue<Integer> que = new LinkedList<Integer>();
			for(int i = 1; i<=N; i++) {
				if(indegree[i]==0) {				//들어오는 엣지가 없는 노드가 시작 점  -> 초기에 큐에 넣고 시작 
					que.add(i);
					timeSum[i] = timeArr[i];			//초기값 설정 
				}
			}
		
			while(!que.isEmpty()) {
				int now = que.poll();		//없으면 null 리턴하는 함수 
				
				if(now==W) break;
				
				for(int i = 0; i<outdegree[now].size(); i++) {			//해당 노드랑 연결된 노드 모두 검사 
					int next = outdegree[now].get(i);
					
					if(timeSum[next] < timeSum[now] + timeArr[next]) {	//최대 시간으로 갱신 
						timeSum[next] = timeSum[now] + timeArr[next];
					}
					indegree[next] -= 1;
					if(indegree[next] == 0) que.add(next);				//더 이상 들어오는 엣지 없으면 큐에 넣기 
					
				}
			
			}
			System.out.println(timeSum[W]);
			
			
		}
	}
}
