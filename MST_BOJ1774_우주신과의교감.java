import java.util.*;

class Pair1774{		//해당 노드의 좌표 정보 
	Integer x, y;
	public Pair1774(Integer _x, Integer _y) {
		this.x = _x; 
		this.y = _y;
	}
	public Integer getX() {
		return this.x;
	}
	public Integer getY() {
		return this.y;
	}
}

class Edge1774{		// 통로의 길이와 통로에 연결된 우주신이 몇번째 우주신인지 
	Double dis;
	Integer v1,v2;
	public Edge1774(Double _dis, Integer _v1, Integer _v2) {
		this.dis = _dis;
		this.v1 = _v1;
		this.v2 = _v2;
	}
	public double getDis() {
		return this.dis;
	}
	public Integer getV1() {
		return this.v1;
	}
	public Integer getV2() {
		return this.v2;
	}
}
class Cmp1774 implements Comparator<Edge1774>{
	@Override
	public int compare(Edge1774 e1, Edge1774 e2) {
		if(e1.getDis() < e2. getDis()) return -1;
		else if(e1.getDis() > e2. getDis()) return 1;
		else return 0;
	}
}

public class MST_BOJ1774_우주신과의교감 {
	static Scanner sc = new Scanner(System.in);
	static int N, M;
	static Pair1774[] info = new Pair1774[1001];
	static int[] parent = new int[1001];
	static int[] visited = new int[1001];
	static ArrayList<Edge1774> edgeList = new ArrayList<Edge1774>();
	static double ans;
	static ArrayList<Integer> tmpList = new ArrayList<Integer>();

	//두 점 사이의 거리 리턴. 
	static public double getDistance(int v1, int v2) {
		int x1 = info[v1].getX();
		int y1 = info[v1].getY();
		int x2 = info[v2].getX();
		int y2 = info[v2].getY();

		double res = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
		return res;
	}
	
	
	static public int getParent(int x) {
		if(x==parent[x]) return x;
		else return getParent(parent[x]);
	}
	

	//N개 중 2개의 노드 픽 
	public static void pickDFS(int toPick, int start) {
		if(toPick==0) {
			int v1 = tmpList.get(0);
			int v2 = tmpList.get(1);
			double distance = getDistance(v1, v2);
			edgeList.add(new Edge1774(distance, v1, v2));
			return;
		}
		
		for(int i = start; i<=N; i++) {
			if(visited[i]==0) {
				visited[i] = 1;
				tmpList.add(i);
				pickDFS(toPick-1, i);
				tmpList.remove(tmpList.size()-1);
				visited[i] = 0;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		N = sc.nextInt();
		M = sc.nextInt();
		ans = 0;
		
		for(int i = 1; i<=N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			info[i] = new Pair1774(x,y);
			parent[i] = i;
		}
		
		//이미 연결된 통로 표시 
		for(int i = 0; i<M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			if(v1>v2) {
				int tmp = v1;
				v1 = v2;
				v2 = tmp;
			}
			int p1 = getParent(v1);
			int p2 = getParent(v2);
			if(p1!=p2) {
				parent[p2] = p1;
			}
		}
		
		pickDFS(2, 1);	// 2개를 골라서 edgeList에 간선(거리) 정보 저장 
		
		edgeList.sort(new Cmp1774());

		for(int i = 0; i<edgeList.size(); i++) {
			int v1 = edgeList.get(i).getV1();
			int v2 = edgeList.get(i).getV2();
			int p1 = getParent(v1);
			int p2 = getParent( v2);
			if(p1 != p2) {
				parent[p2] = p1;
				ans += getDistance(v1, v2);
			}
		}
		
		System.out.printf("%.2f",ans);
	}
}
