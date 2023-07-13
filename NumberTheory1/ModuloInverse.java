import java.util.Scanner;

public class Code{

    static int extendedGCD(int a , int b , Int x , Int y){
        if(b == 0){
            x.val = 1;
            y.val = 0;
            return a;
        }

        Int x1 = new Int();
        Int y1 = new Int();
        int g = extendedGCD(b, a % b, x1, y1);

        x.val = y1.val;
        y.val = x1.val - (a/b) * y1.val;

        return g;
    }
    public static void main(String[] args) {
        int t , a , m;
        Scanner scanner = new Scanner(System.in);

        t = scanner.nextInt();

        while(t-- > 0){
            a = scanner.nextInt();
            m = scanner.nextInt();

            int g;
            Int x = new Int();
            Int y = new Int();

            g = extendedGCD(a , m , x , y);

            if(g == 1){
                x.val = ((x.val % m) + m) % m;
                System.out.println("Modulo Inverse = " + x.val);
                System.out.println("(a * inverse) % m = " + (a * x.val) % m);
            }else{
                System.out.println("Modulo inverse does not exist");
            }

        }
    }
}

class Int{
    int val;
}
