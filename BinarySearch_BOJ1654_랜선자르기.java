import java.util.*;

public class BinarySearch_BOJ1654_랜선자르기 {

	public static long func(ArrayList<Integer> li, long mid) {
		
		long ans = 0;
		
		for(int i = 0; i<li.size(); i++) {
			ans += li.get(i) / mid;			
		}
		return ans;
	}
	

	
	public static void main (String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		int K = sc.nextInt();
		int N = sc.nextInt();
		
		
		for(int i = 0; i<K; i++) {
			int num; 
			num = sc.nextInt();
			list.add(num);
		}
		
		list.sort(null);
				
		
		long first = 1; 
		long last = list.get(K-1);

		while(first<=last) {
			
			long  mid = (first + last) / 2;
			
			long cnt = func(list, mid);
			
			if(cnt<N) last = mid-1;
			else first = mid+1;
		
			
		}
		
		System.out.println(last);
		
		sc.close();
	}
	
}
