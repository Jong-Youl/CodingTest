import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, comparator);
        
        answer = files;
        
        return answer;
    }
    
    public Comparator<String> comparator = (o1, o2) -> {
		int result = 0;
		int h1_idx = getHeader(o1);
		int h2_idx = getHeader(o2);

		String head1 = o1.substring(0, h1_idx).toLowerCase();
		String head2 = o2.substring(0, h2_idx).toLowerCase();

		result = head1.compareTo(head2);

		// 둘이 같으면 다음 부분 비교
		if (result == 0){
			String str1 = o1.substring(h1_idx);
			String str2 = o2.substring(h2_idx);

			int num1 = getNumber(str1);
			int num2 = getNumber(str2);

			result = Integer.compare(num1, num2);

		}

		return result;
    };
    
    public int getNumber(String str) {

		StringBuilder num = new StringBuilder();

		for(int i = 0; i < str.length(); i++){
			if( str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9 ) {
				num.append(str.charAt(i));
			}
			else break;
		}

		return Integer.parseInt(num.toString());
	}

	public int getHeader(String str) {
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			//숫자가 아니면
			if (str.charAt(i) - '0' < 0 || str.charAt(i) - '0' > 9) {
				cnt++;
			} else break;
		}
		return cnt;
	}
}