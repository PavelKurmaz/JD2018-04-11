package by.it.gavrilchik.jd01_08;

public class Runner {
    public static void main(String[] args) {
        Var var=new Scalar("123.456");
        Scalar scalar=new Scalar(7.777);
        Object o=new Scalar(scalar);


        System.out.println(var.toString());
        System.out.println(o.toString());
        System.out.println(scalar.toString());

    }
}
