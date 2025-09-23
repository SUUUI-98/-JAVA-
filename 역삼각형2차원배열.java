public class Soojebi {

    public static void main(String[] args) {
        // 1) 3x3 정수형 2차원 배열 생성
        int[][] arr = new int[3][3];

        // 2) 배열을 0으로 초기화
        init(arr);

        //배열 역삼각형 모양으로 숫자 채우기
        hourGlass(arr);
        // 출력 함수 
        arrayPrint(arr);
    }

    public static void init(int arr[][]) {
        // arr.length -> 행의 수 (여기서는 3)
        for (int i = 0; i < arr.length; i++) {
            // arr[0].length -> 열의 수 (여기서는 3)
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = 0; // 각 칸을 0으로 설정
            }
        }
    }

    /*
     * - v: 채워 넣을 숫자(1부터 시작)
     * - 바깥 루프 i: 각 행(row)을 의미
     * - 안쪽 루프 j: i부터 시작해서 오른쪽 끝까지 채움 -> 윗삼각(대각선 포함)이 채워짐
     *
     * 채워지는 순서(예시, 최종 결과):
     * arr =
     * [ [1, 2, 3],
     *   [0, 4, 5],
     *   [0, 0, 6] ]
     *
     * 이유: 각 행에서 j를 i부터 시작하면
     *   i=0 -> j=0,1,2  (행0의 모든 열)
     *   i=1 -> j=1,2    (행1의 대각선부터 우측)
     *   i=2 -> j=2      (행2의 대각선)
     */
    public static void hourGlass(int arr[][]) {
        int v = 0; // 값을 0으로 초기화. ++v를 사용해서 1부터 채움.
        for (int i = 0; i < arr.length; i++) {           // 각 행(row)
            for (int j = i; j < arr[0].length; j++) {    // 각 행에서 열을 i부터 시작
                // ++v: 먼저 v를 1 증가시키고 증가된 값을 사용.
                arr[i][j] = ++v;
                // arr[0][0] = 1, 다음 => arr[0][1] = 2, ...
            }
        }
    }

    /**
     * - 0이면 공백(" ")을 출력해서 비어 보이게 함
     * - 숫자면 그대로 출력 
     *  이렇게 하면 자릿수 정렬(칸 맞춤)이 더 보기 좋아짐.
     */
    public static void arrayPrint(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {          // 각 행 출력
            for (int j = 0; j < arr[0].length; j++) {   // 각 열 출력
                if (arr[i][j] == 0) {
                    // 0이면 공백 한 칸 출력 (원래 코드 동작 유지)
                    System.out.print(" ");
                } else {
                    // 0이 아니면 숫자 출력
                    System.out.print(arr[i][j]);
                }
            }
            // 한 행 출력이 끝나면 줄바꿈
            System.out.println("");
        }
    }
}
//hourGlass 에서 채워진 대로 
//역삼각형 모양의 숫자판이 출력됨 
// 1 2 3 
//   4 5
//     6 
