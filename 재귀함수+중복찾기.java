class Soojebi {
    public static String fn(String str, int index, boolean[] seen) {
        // 재귀 호출 종료 조건: index가 0보다 작아지면 빈 문자열 반환
        if (index < 0) {
            return "";
        }

        // 현재 index의 문자(char)를 가져옴
        char c = str.charAt(index);

        // 재귀 호출: index를 1씩 줄여가며 이전 문자열을 처리
        // 예: fn("abacabcd", 7) -> fn("abacabc", 6) -> ...
        String result = fn(str, index - 1, seen);

        // 현재 문자 'c'가 seen 배열에 기록되지 않았다면 (처음 등장한 문자라면)
        if (!seen[c]) {
            // 해당 문자를 seen 배열에 "봤다"고 표시
            seen[c] = true;
            // 현재 문자를 재귀 호출 결과(result)의 앞에 붙여 반환
            // 이렇게 하면 중복 없는 문자열이 역순으로 생성됨
            return c + result;
        }

        // 현재 문자 'c'가 이미 seen 배열에 기록되어 있다면 (중복 문자라면)
        // 현재 문자는 무시하고, 재귀 호출 결과(result)만 그대로 반환
        return result;
    }

    public static void main(String[] args) {
        // 입력 문자열
        String str = "abacabcd";
        // 문자열의 길이
        int length = str.length();
        // 아스키 문자(0~255)의 출현 여부를 기록할 boolean 배열 초기화
        boolean[] seen = new boolean[256];

        // fn 함수를 호출하여 결과를 출력
        // str의 마지막 인덱스(7)부터 탐색 시작
        System.out.print(fn(str, length - 1, seen));
    }
}
