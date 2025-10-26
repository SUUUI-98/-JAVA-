public class Main {
 
    static interface F {
        int apply(int x) throws Exception; 
        //정수를 인자로 받고 예외를 발생 시킬 수 있는 추상화된 메서드 
    }
 
    public static int run(F f) {
        try {
            return f.apply(3); // 첫번째 호출 -> 인자를 3으로 전달 
            // 두번째 호출 이미 예외를 발생 시켰기 때문에 예외없이 인자에 있는 3을 리턴 
        } catch (Exception e) {
            return 7; // 예외가 발생 하여 7 리턴 
        }
    }
 
    public static void main(String[] args) {
 
        F f = (x) -> {
            if (x > 2) { // 인자로 받은 정수가 2보다 크면 예외를 발생 시킴 
                throw new Exception();
            }
            return x * 2;
        };
 
        System.out.print(run(f) + run((int n) -> n + 9));
    } // run(f) = 7 , run((int n) -> n + 9)) = 3+ 9 = 12 
    // 19 출력 
 
}
