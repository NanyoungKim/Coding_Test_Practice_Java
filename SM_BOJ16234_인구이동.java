import java.util.*;
//05:44

class Pair16234{
	Integer r, c;
	public Pair16234(Integer _r, Integer _c) {
		this.r = _r;
		this.c = _c;
	}
	public int getRow() {
		return this.r;
	}
	public int getCol() {
		return this.c;
	}
	
}
public class SM_BOJ16234_인구이동 {

	static int N, L, R, answer;
	static int[][] map, visited; 
	static int[] dr,dc;

	static boolean chk(int a, int b) {
		int sub = Math.abs(a-b);
		if(L <= sub && sub <=R) return true;
		else return false;
	}
	
	static boolean BFS(int r, int c) {
		
		Queue<Pair16234> que = new LinkedList<Pair16234>();
		ArrayList<Pair16234> vec = new ArrayList<Pair16234>();
		int sum = 0;
		
		Pair16234 p = new Pair16234(r,c);
		que.add(p);
		vec.add(p);
		sum = map[r][c];
		
		while(!que.isEmpty()) {
			Pair16234 pair = que.poll();
			int cr = pair.getRow();
			int cc = pair.getCol();
			
			visited[cr][cc] = 1;
			
			for(int i = 0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(nr<1 || nr>N || nc<1 || nc>N || visited[nr][nc]==1) continue;
				
				if(chk(map[cr][cc], map[nr][nc])) {
					visited[nr][nc] = 1;
					Pair16234 p_next = new Pair16234(nr,nc);
					que.add(p_next);
					vec.add(p_next);
					sum += map[nr][nc];
				}
			}
		}
		
		if(vec.size()==1) {
			visited[vec.get(0).getRow()][vec.get(0).getCol()] = 0;
			return false;
		}
		else {
			
			int avg = sum / vec.size();
			for(int i = 0; i<vec.size(); i++) {
				int row = vec.get(i).getRow();
				int col = vec.get(i).getCol();
				map[row][col] = avg;
			}
			return true;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		dr = new int[4];
		dc = new int[4];
		dr[0] = -1; dr[1] = 0; dr[2] = 1; dr[3] = 0;
		dc[0] = 0; dc[1] = 1; dc[2] = 0; dc[3] = -1;
		
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[51][51];
		visited = new int[51][51];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				map[i][j] = sc.nextInt();
				visited[i][j] = 0;
			}
		}
		
		answer = 0;

		int cnt = 0;	
		while(true) {
			
			if(cnt==N*N) break;
			cnt = 0;
			
			boolean flag = false;
			
			for(int r = 1; r<=N; r++) {
				for(int c = 1; c<=N; c++) {
					visited[r][c] = 0;
				}
			}
			
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {

					if(visited[i][j]==0) {
						boolean res = BFS(i,j);
						if(res) {
							flag = true;
						}					
						else cnt++;
					}
				}

			}
			
			if(flag) answer++;
			
		}
		System.out.println(answer);
	}

}
