// Lab10
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("���� 1:��������� ���������� ����� ����������");
        method1();
        System.out.println("\n���� 2:��������� ���������� � �� ���������");
        method2();
        System.out.println("\n���� 3:��������� ���������� ����������� ����������");
        try{
            Scanner scan=new Scanner(System.in);
            int i = scan.nextInt();
            method3(i);}
        catch(InputMismatchException e){
            Log.console("����������� ����������: "+e+
                    "\n������������� ��������� � ��������� �������"); };
        System.out.println("\n���� 4:��������� ����������� ����������");
        method4();
    }

    public static void method1(){
        int i=7,u=8;
        try{
            int g=1/(i/u);
            Log.console("������� �� ���� �� �����������");
        }
        catch(ArithmeticException e){
            Log.console("����������� ����������");
        }
    }
    public static void method2(){
        int i =7;
        int y [] =new int[5] ;
        try{
            Log.console(Integer.toString(y[i]));
            Log.console("����� �� ������� ������� �� ����������");
        }
        catch(ArrayIndexOutOfBoundsException e){
            Log.console("����������� ����������: "+e);
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
            Log.console("����������� ����������: "+e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            Log.console("����������� ����������: "+e);
        }
        catch(UnsupportedOperationException e){
            Log.console("����������� ����������: "+e);
        }
        catch(NullPointerException e){
            Log.console("����������� ����������: "+e);
        }
        catch(IllegalStateException e){
            Log.console("����������� ����������: "+e);
        }
        catch(IllegalArgumentException e){
            Log.console("����������� ����������: "+e);
        }
    }
    public static void method4(){
        try{
            ExceptionDemo.compute(1);
            ExceptionDemo.compute(20);
        }
        catch(MyException e){ System.out.println("��������� ������������ ����������: "+e);}
    }

}
class MyException extends Exception {
    private int i;
    MyException(int a){i=a;}
    public String toString(){return "MyException type[ "+i+" ]";}
}
class ExceptionDemo {
            static void compute ( int a) throws MyException{
                System.out.println( "B���a� ����� compute[ " + a + " ]");
                if( a > 10 )
                    throw new MyException(a) ;
                    System.out.println("Hop�a���oe ����������");}}