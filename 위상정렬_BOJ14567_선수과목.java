import java.util.*;


class Pair{

	Integer first, second;
	public Pair(Integer f, Integer s) {
		this.first= f;
		this.second = s;
	}
	public Integer getFirst() {
		return this.first;
	}
	public Integer getSecond() {
		return  this.second;
	}
	
};

class Comp implements Comparator<Pair>{     //선수과목 기준으로 오름차순 정렬
	@Override
	public int compare(Pair p1, Pair p2) {
		if(p1.getFirst() < p2.getFirst()) return -1;
		else if(p1.getFirst() > p2.getFirst()) return 1;
		else return 0;
		
	}
}

public class 위상정렬_BOJ14567_선수과목 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Pair> list = new ArrayList<Pair>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		for(int i = 0; i<M; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			list.add(new Pair(first,second));
		}
		
		list.sort(new Comp());
		
		
		int[] cntArr = new int[N+1];
		for(int i = 1; i<=N; i++) {
			cntArr[i] = 1;                    //모든 과목은 최소 1학기 이수 필수
		}
		
		for(int i = 0; i<list.size(); i++) {
			
			int f = list.get(i).getFirst();
			int s = list.get(i).getSecond();
			
			int edgeCnt = cntArr[f] + 1;
			if(edgeCnt > cntArr[s]) {             //이 때만 갱신 해야함. 
				cntArr[s] = edgeCnt;
			}
		}
		
		for(int i = 1; i<=N; i++) {
			System.out.print(cntArr[i] + " ");
		}
		
		
	}
}
