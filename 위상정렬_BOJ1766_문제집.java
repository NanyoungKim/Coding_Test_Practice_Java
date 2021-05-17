import java.util.*;

class Pair1766 {
	Integer first, second;
	
	public Pair1766(Integer f, Integer s) {
		this.first = f;
		this.second = s;
	}
	public Integer getFirst() {
		return this.first;
	}
	public Integer getSecond() {
		return this.second;
	}

}

class Cmp1766 implements Comparator<Pair1766>{
	@Override
	public int compare(Pair1766 p1, Pair1766 p2) {
		if(p1.getFirst() < p2.getFirst()) return -1;
		else if(p1.getFirst() > p2.getFirst()) return 1;
		else {
			if(p1.getSecond() < p2.getSecond()) return -1;
			else if(p1.getSecond() > p2.getSecond()) return 1;
			else return 0;
		}
	}
}
public class 위상정렬_BOJ1766_문제집 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Pair1766> pairList = new ArrayList<Pair1766>();
		ArrayList<Integer> ansList = new ArrayList<Integer>();
		
		
		for(int i = 0; i<M; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			pairList.add(new Pair1766(first,second));
		}
		pairList.sort(new Cmp1766());

		int[] inDegree = new int[32001];
		ArrayList<Integer>[] outDegree = new ArrayList[32001];
		for(int i = 1; i<=N; i++) {
			outDegree[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<pairList.size(); i++) {
			int cur = pairList.get(i).getFirst();
			int next = pairList.get(i).getSecond();
			
			inDegree[next] += 1;
			outDegree[cur].add(next);
			
		}
		
		PriorityQueue<Integer> pQue = new PriorityQueue<>();		//우선순위 낮은 숫자 순 
		
		for(int i = 1; i<=N; i++) {
			if(inDegree[i]==0) pQue.add(i);
		}
		
		
		
		while(!pQue.isEmpty()) {
			int now = pQue.poll();
			ansList.add(now);
			
			for(int i = 0; i<outDegree[now].size(); i++) {
				int next = outDegree[now].get(i);
				
				inDegree[next] -= 1;
				if(inDegree[next] == 0) {
					pQue.add(next);
				}
			}
			
			
		}
		for(int i=0; i<ansList.size(); i++) {
			System.out.print(ansList.get(i) + " ");
			
		}
		
		
	}
}
