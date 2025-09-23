
class Soojebi {
    static private Soojebi instance = null; 
    // main 에서 s1 선언 후 정적 변수는 더 이상 null 이 아니게 됨 
    private int count = 0;

    static public Soojebi get() {
        if (instance == null) { // 정적 변수인 instance 가 null이면 
            instance = new Soojebi();// Soojebi 생성자 
        }
        return instance; // 그게 아니면 기본 instance 객체 리턴 
    }

    public void count() {
        count++; // 증가 
    }

    public int getCount() {
        return count;
    }
}

class Soojebi2 {
    public static void main(String[] args) {
        Soojebi s1 = Soojebi.get(); // 여기서 Soojebi 인스턴스 생성 
        s1.count(); //count= 1

        Soojebi s2 = Soojebi.get(); // 인스턴스가 null 이 아니므로 s1 에서 생성된 인스턴스 반환 
        s2.count(); // 인스턴스의 변수 중 저장된 count 에서  ++ 
        //count= 2

        Soojebi s3 = Soojebi.get();// 인스턴스가 null 이 아니므로 s1 에서 생성된 인스턴스 반환 
        s3.count(); // 즉 s1 , s2 ,s3 은 동시에 객체 Soojebi(s1) 를 가리킴
        //count 변수는 정적 변수는 아니지만, 객체에 속한 인스턴스 변수이므로 어떤 참조 변수를 통해 count() 메서드를 호출하더라도 같은 변수에 접근하게 되어 값이 누적되는 것
        // count = 3

        System.out.println(s1.getCount());  //3 출력 
    }
}
