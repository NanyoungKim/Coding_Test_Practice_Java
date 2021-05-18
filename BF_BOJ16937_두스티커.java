import java.util.*;

class Pair16937{
	Integer h, w;
	public Pair16937(Integer _h, Integer _w) {
		this.h = _h;
		this.w = _w;
	}
	public Integer getHeight() {
		return this.h;
	}
	public Integer getWidth() {
		return this.w;
	}
}

public class BF_BOJ16937_두스티커 {
	
	static int H, W, N;
	static int[] visited = new int[100];
	static ArrayList<Pair16937> pairList = new ArrayList<Pair16937>();
	static ArrayList<Pair16937> tmpList = new ArrayList<Pair16937>();
	static int maxi = 0;
	
	static boolean chkHeight(int h1, int w1, int h2, int w2) {		//위 아래로 붙였을 때 
		if(h1+h2 > H || Math.max(w1, w2) > W) return false;
		else return true;
	}
	static boolean chkWidth(int h1, int w1, int h2, int w2) {		//양옆으로 붙였을 때 
		if(Math.max(h1, h2) > H || w1 + w2 > W) return false;
		else return true;
	}
	
	static boolean chkHW(int h1, int w1, int h2, int w2) {
		if(chkHeight(h1,w1,h2,w2)==true || chkWidth(h1,w1,h2,w2)==true) return true;
		else return false;
	}
	
	
	static void DFS(int toPick, int start) {
		
		if(toPick==0) {
			int h1 = tmpList.get(0).getHeight();
			int w1 = tmpList.get(0).getWidth();
			
			int h2 = tmpList.get(1).getHeight();
			int w2 = tmpList.get(1).getWidth();
			
			//1번 그대로, 2번 그대로 
			boolean chk = false;
			if(chkHW(h1,w1,h2,w2) == true) {	
				int area = h1*w1 + h2*w2;
				if(maxi<area) maxi = area;
				chk = true;
			}
			else {
				for(int i = 0; i<3; i++) {
					int a,b,c,d;
					if(i==0) {				//1번 회전, 2번 그대로
						a = w1; b = h1;
						c = h2; d = w2;
					}
					else if(i==1) {			//1번 그대로, 2번 회전
						a = h1; b = w1;
						c = w2; d = h2;
					}
					else {					//1번 회전, 2번 회전 
						a = w1; b = h1;
						c = w2; d = h2;
					}
					if(chkHW(a,b,c,d)==true) {
						chk = true;
						int area = h1*w1 + h2*w2;
						if(maxi<area) maxi = area;
						return;
					}
				}
			}
			
			return;
		}
		
		for(int i = start; i<pairList.size(); i++) {
			
			if(visited[i]==0) {
				visited[i] = 1;
				tmpList.add(pairList.get(i));
				DFS(toPick-1, i);
				tmpList.remove(tmpList.size()-1);
				visited[i] = 0;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		N = sc.nextInt();
		for(int i = 0; i<N; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			pairList.add(new Pair16937(h,w));
		}
		
		DFS(2,0);
		
		System.out.print(maxi);
	}
}
