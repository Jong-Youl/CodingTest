import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 스위치 개수 //9
		int[] arr = new int[N];// 스위치 배열 생성

		for (int i = 0; i < N; i++) {// 스위치 배열 값 대입
			arr[i] = sc.nextInt();
		}

		int std = sc.nextInt();// 학생 수

		for (int i = 0; i < std; i++) {
			int gender = sc.nextInt();// 학생 성별
			int num = sc.nextInt();// 스위치 번호 // 3

			if (gender == 1) {// 남자일 때
					for (int j = 1; j <= (N / num); j++) {// 전체 (스위치수/받은수) -> 배수개수만큼 반복
						if (arr[(j * num) - 1] == 0) {// 0이면 1로 1이면 0으로
							arr[(j * num) - 1] = 1;
						} else {
							arr[(j * num) - 1] = 0;
						}
					}
				} 
			if (gender == 2) {// 여자일 때
				//제자리 변환
				if (arr[num - 1] == 0) {
					arr[num - 1] = 1;
				} else {
					arr[num - 1] = 0;
				}
				for (int j = 1; j <= (N / 2); j++) {// 스위치 수 나누기 2해서 그것만큼 양쪽으로 대칭이라고 생각
					// 인덱스 오류 방지 해줘야함
					if (num + j - 1 < N  && num - j - 1 >= 0) {// 범위안
						if (arr[num + j - 1] != arr[num - j - 1]) {// 대칭확인 아니면 끝
							break;
						} else if (arr[num + j - 1] == arr[num - j - 1]) {// 대칭이면 바꿔주기
							if (arr[num + j - 1] == 1) {
								arr[num + j - 1] = 0;
							} else {
								arr[num + j - 1] = 1;
							}
							if (arr[num - j - 1] == 1) {
								arr[num - j - 1] = 0;
							} else {
								arr[num - j - 1] = 1;
							}
						}
					}
					else {
						break;
					}
				}
			}

		}
		for(int i = 0; i<N; i++) {
			System.out.print(arr[i] + " ");
			if ((i+1) % 20 == 0)
				System.out.println();
		}
	}
}