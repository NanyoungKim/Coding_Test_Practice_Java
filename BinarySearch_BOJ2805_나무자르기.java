import java.util.*;
public class BinarySearch_BOJ2805_나무자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Integer> listTree = new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			int treeHeight = sc.nextInt();
			listTree.add(treeHeight);
		}
		listTree.sort(null);
		
		long first = 0;
		long last = 2000000000;
		long midHeight=0;
		while(first<=last) {
			
			midHeight = (first+last)/2;
			
			long sumTree = 0;
			for(int i = 0; i<N; i++) {
				long cut = listTree.get(i) - midHeight;
				if(cut<=0) continue;
				sumTree += cut; 
				
			}
			
			if(sumTree>=M) {		//M보다 더 많이 잘랐으면 
				//더 최소한으로 자를 수 있나 즉, 기준 높이 더 높일 수 있 계속 검사 진행 
				first = midHeight+1;
			}
			else last = midHeight -1;	//원하는 M 만큼 못 잘랐으면 
			
		}
		
		System.out.print(last);
	}
}
