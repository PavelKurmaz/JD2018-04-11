package by.it.lanevich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar v1=new Scalar(3.1415);
        AbstractVar v2=new Vector("{1.0,2.0,4.0}");
        AbstractVar v3=new Matrix("{{1.0,2.0},{3.0,4.0}}");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

    }
}
