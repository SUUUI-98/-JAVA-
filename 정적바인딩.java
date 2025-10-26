public class Main{
 
    public static class Parent {
 
        public int x(int i) { return i + 2; }
        public static String id() { return "P";}
        // ref.id() 는 부모와 자식 둘다 정적메서드로 선언
    }
 
    public static class Child extends Parent {
        
        public int x(int i) { return i + 3; } // 오버라이딩 된 메서드 
        public String x(String s) { return s + "R"; }
        public static String id() { return "C"; } 
        
    }
 
    public static void main(String[] args) {
 
        Parent ref = new Child(); // 업캐스팅 
        System.out.println(ref.x(2) + ref.id());
        // ref.x(2) 는 오버라이딩 된 자식의 메서드를 호출하여 5를 리턴 
        // 객체의 인스턴스(실제객체)는 자식이지만 , 참조되는 타입은 부모이기에 정적 메서드인 id 는 부모의 것을 호출하여 P 리턴 
    }// 정적 바인딩 : 정적 메서드는 객체의 실제 인스턴스와 무관하게 참조 변수의 선언된 타입(Parent)에 따라 호출될 메서드가 결정
    
}// 5P 출력 
