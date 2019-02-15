// Lab10
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Этап 1:Обработка встроенных типов исключений");
        method1();
        System.out.println("\nЭтап 2:Обработка исключений с их описанием");
        method2();
        System.out.println("\nЭтап 3:Обработка нескольких разнотипных исключений");
        try{
            Scanner scan=new Scanner(System.in);
            int i = scan.nextInt();
            method3(i);}
        catch(InputMismatchException e){
            Log.console("Перехвачено исключение: "+e+
                    "\nПерезапустите программу и повторите попытку"); };
        System.out.println("\nЭтап 4:Обработка собственных исключений");
        method4();
    }

    public static void method1(){
        int i=7,u=8;
        try{
            int g=1/(i/u);
            Log.console("Деление на ноль не перехвачено");
        }
        catch(ArithmeticException e){
            Log.console("Перехвачено исключение");
        }
    }
    public static void method2(){
        int i =7;
        int y [] =new int[5] ;
        try{
            Log.console(Integer.toString(y[i]));
            Log.console("Выход за пределы массива не перехвачен");
        }
        catch(ArrayIndexOutOfBoundsException e){
            Log.console("Перехвачено исключение: "+e);
        }
    }
    public static void method3(int i){
        try{
            switch(i){
                case 1:throw new ArithmeticException();
                case 2:throw new ArrayIndexOutOfBoundsException();
                case 3:throw new UnsupportedOperationException();
                default:Random c =new Random();
                        switch(c.nextInt(3)){
                            case 0:throw new IllegalArgumentException();
                            case 1:throw new IllegalStateException();
                            case 2:throw new NullPointerException();}
            }}
        catch(ArithmeticException e){
            Log.console("Перехвачено исключение: "+e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            Log.console("Перехвачено исключение: "+e);
        }
        catch(UnsupportedOperationException e){
            Log.console("Перехвачено исключение: "+e);
        }
        catch(NullPointerException e){
            Log.console("Перехвачено исключение: "+e);
        }
        catch(IllegalStateException e){
            Log.console("Перехвачено исключение: "+e);
        }
        catch(IllegalArgumentException e){
            Log.console("Перехвачено исключение: "+e);
        }
    }
    public static void method4(){
        try{
            ExceptionDemo.compute(1);
            ExceptionDemo.compute(20);
        }
        catch(MyException e){ System.out.println("Обработка собственного исключения: "+e);}
    }

}
class MyException extends Exception {
    private int i;
    MyException(int a){i=a;}
    public String toString(){return "MyException type[ "+i+" ]";}
}
class ExceptionDemo {
            static void compute ( int a) throws MyException{
                System.out.println( "Bызвaн метод compute[ " + a + " ]");
                if( a > 10 )
                    throw new MyException(a) ;
                    System.out.println("Hopмaльнoe завершение");}}