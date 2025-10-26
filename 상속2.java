public class Main {
    public static void main(String[] args) {
        new Child(); 
        // 자식의 생성자를 호출하면 묵시적으로 부모의 생성자를 먼저 호출 
        System.out.println(Parent.total); // 54 출력 
    }
}
 
 
class Parent {
    static int total = 0; // 최종적으로 정적변수 total 에는 54가 저장됨 
    int v = 1;
 
    public Parent() { // 실행 첫번째 
        total += (++v); // 정적 변수 total = 0 + 2 = 2 
        show();    // 오버라이딩 된 자식의 show() 호출 
    }
 
    public void show() {
        total += total;
    }
}
 
 
class Child extends Parent {
    int v = 10;
 
    public Child() { // 부모 생성자가 끝나고 자식 생성자 실행 
        v += 2;  // v = 12
        total += v++; // total = total + 12 -> 6+12 = 18 정적 변수이므로 저장됨 
        show(); // 오버라이딩 된 자식의 메서드 호출 
    }
 
    @Override
    public void show() {
        total += total * 2; //total = 2+ (2*2)= 6 정적 변수이므로 저장
    } //total = 18+ (18*2)= 18+36 = 54
}
