public class Main{
    public static class BO {
        public int v;
        public BO(int v) {
            this.v = v; // 인자로 받는 정수를 v 로 할당 
        }
    }
    public static void main(String[] args) {
        BO a = new BO(1); 
        BO b = new BO(2);
        BO c = new BO(3);
        BO[] arr = {a, b, c}; //BO 객체를 담는 배열 
        BO t = arr[0]; //t = a 
        arr[0] = arr[2]; // {c,b,c}
        arr[2] = t;// {c,b,a}
        arr[1].v = arr[0].v; // b.v = c.v = 3 재할당 
        System.out.println(a.v + "a" + b.v + "b" + c.v);
    } // 1a3b3 출력 
}
 
Colored
