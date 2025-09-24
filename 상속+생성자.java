class Parent {
    public Parent() { // 2. Parent 의 생성자가 먼저 호출 됨 
    
        this(3); // 3. Parent 클래스의 정수를 매개변수로 받는 메서드를 호출 하여 3을 전달 
        
        System.out.print("A"); // 5.this(3) 메서드 호출이 끝나서 A 출력 
    }

    public Parent(int x) { // 4. 호출되어 B 를 출력 
        System.out.print("B");
    }

    public void fn1() {
        System.out.print("C");
    }

    public void fn2() {
        System.out.print("D"); // 7. 호출되어 D 출력 
    }
}

class Child extends Parent {
    public Child() { // 11. 호출되어 E 출력 
        System.out.print("E");
    }

    public Child(int x) { // 9. 호출 
        this(); //10. Child 의 매개변수가 없는 생성자 호출  
        System.out.print("F"); // 12. this() 함수가 종료되어 F 출력 
    }

    public void fn1() {
        System.out.print("G"); // 13. G 출력 
    }

    public void fn2() {
        System.out.print("H");
    }
}

public class Soojebi {
    public static void main(String[] args) {
        Parent a = new Parent(); // 1. Parent 의 인스턴스를 a 에 저장 
        // 여기까지 BA 출력 
        a.fn2(); // 6. Parent의 fn2() 함수 호출 
        // 여기까지 BAD 
        new Child(5).fn1(); 
        //8. new Child(5) 생성자 호출 -> 자바의 상속 규칙 때문에, 자식 클래스의 생성자가 호출될 때는 
        // 무조건 부모 클래스의 생성자가 가장 먼저 호출 
        // BA 출력 
        // new Child(5)-> Child 의 정수를 매개변수로 받는 생성자 호출
        // new Child(5) 까지하면 현재까지 출력은 BADBAEF 
        // 마지막으로 Child 의 fn1 가 호출 됨 
        // 최종 출력값은 BADBAEFG 
         
    }
}
