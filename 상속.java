class Soojebi {
    public static void main(String[] args) {
        Parent c = new Child(); 
        //업캐스팅 시 오버라이딩 메서드일 경우 
        //자식의 메서드가 호출됨 
        c.paint(); // 현재까지 BDCD
        c.draw(); // Child의 draw 호출 -> "D" 출력 
        // BDCDD 출력 
    }
}

class Parent {
    public void paint() {
        System.out.print("A");
        draw();
    }

    public void draw() {
        System.out.print("B"); // "B" 출력 
        draw(); //두번째 호출 Child 의 draw()->  "D" 출력
    }
}

class Child extends Parent {
    public void paint() { // 호추출
        super.draw(); // 부모의 draw() 함수 호출 
        System.out.print("C"); // 현재까지 "BDC" 
        this.draw(); // 자기 자신의 draw() 호출 -> "D" 출력 
    } // 현재까지 BDCD

    public void draw() {
        System.out.print("D");
    }
}
