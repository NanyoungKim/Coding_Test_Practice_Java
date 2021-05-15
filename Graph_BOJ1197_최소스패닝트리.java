import java.util.*;

class Pair{
	Integer first, second, edge;
	
	public Pair(Integer f, Integer s, Integer e) {
		this.first = f;
		this.second = s;
		this.edge = e;
	}
	public Integer getFirst() {
		return first;
	}
	public Integer getSecond() {
		return second;
	}
	public Integer getEdge() {
		return edge;
	}
}

class Cmp implements Comparator<Pair>{
	@Override
	public int compare(Pair p1, Pair p2) {
		if(p1.getEdge() < p2.getEdge()) return -1;
		else if(p1.getEdge() > p2.getEdge()) return 1;
		else return 0;
	}
}


public class Graph_BOJ1197_최소스패닝트리 {

	static int[] parent = new int[100001];
	

	public static int findParent(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = findParent(parent[x]);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Pair> list = new ArrayList<Pair>();
		int[] visited = new int[10001];
		

		int V = sc.nextInt();
		int E = sc.nextInt();
		
		for(int i = 0; i<V; i++) parent[i] = i;
		
		for(int i = 0; i<E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int e = sc.nextInt();
			Pair p = new Pair(v1,v2,e);
			list.add(p);
		}
		
		//첫번째 정렬 방법 
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if(p1.getEdge() < p2.getEdge()) return -1;
				else if(p1.getEdge() > p2.getEdge()) return 1;
				else return 0;
				
			}
		});
		
		//두번째 정렬 방법 
		list.sort(new Cmp());
		
		//세번째 정렬 방법
		Collections.sort(list, new Cmp());
		
		
		

		int sum = 0;

		for(int i = 0; i<list.size(); i++) {
			int v1 = list.get(i).getFirst();
			int v2 = list.get(i).getSecond();
			
	
			//v1부모 = v2부모 -> 이미 연결되어 있는 경우임 -> 스킵
			//부모가 서로 다르면 연결
			int p1 = findParent(v1);
			int p2 = findParent(v2);
			
			if(p1==p2) continue;
			else {
				parent[p2] = p1;
				int e = list.get(i).getEdge();
				sum += e;
			}
		}
		
		System.out.println(sum);
		sc.close();
	}

}


