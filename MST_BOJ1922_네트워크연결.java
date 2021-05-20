import java.util.*;


class Pair1922{
	Integer cost, v1, v2;
	public Pair1922(Integer _cost, Integer _v1, Integer _v2) {
		this.cost = _cost;
		this.v1 = _v1;
		this.v2 = _v2;
	}
	public Integer getCost() {
		return this.cost;
	}
	public Integer getv1() {
		return this.v1;
	}
	public Integer getv2() {
		return this.v2;
	}
}

class Cmp1922 implements Comparator<Pair1922>{
	@Override
	public int compare(Pair1922 p1, Pair1922 p2) {
		if(p1.getCost() < p2.getCost()) return -1;
		else if(p1.getCost() > p2.getCost()) return 1;
		else return 0;
	}
}


public class MST_BOJ1922_네트워크연결 {

	static int[] parent = new int[1001];
	static int getParent(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = getParent(parent[x]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Pair1922> listInfo = new ArrayList<Pair1922>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int ans = 0;
		
		for(int i = 0; i<=N; i++) {
			parent[i] = i;
		}

		for(int i = 0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			
			listInfo.add(new Pair1922(cost, a, b));	
		}
		
		if(listInfo.size()==1 && listInfo.get(0).getv1()==listInfo.get(0).getv2()) {
			ans = listInfo.get(0).getCost();
		}
		
		else {
			listInfo.sort(new Cmp1922());
			
			for(int i = 0; i<listInfo.size(); i++) {
				int v1 = listInfo.get(i).getv1();
				int v2 =  listInfo.get(i).getv2();
				int p1 = getParent(v1);
				int p2 = getParent(v2);
				System.out.println(p1 + " " + p2);
				if(p1==p2) continue;
				else {
					parent[p2] = p1;
					int e = listInfo.get(i).getCost();
					ans += e;
				}	
			}
		}
		
		System.out.println(ans);
		
		
	}
}
