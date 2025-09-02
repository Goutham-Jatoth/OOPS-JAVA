public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int a=10,b=0;
            int result = a/b;
            System.out.println("Result : "+result);
        } catch(ArithmeticException e) {
            System.out.println("Error Occured ! Denominator Cannot be Zero");
            System.out.println("Cannot Divide");
        }
    }
}