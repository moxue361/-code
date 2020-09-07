package aopDemo;

public class Target {
    public void hello(String str) {
        System.out.println("hello: "+ str);
    }
    public void hello(int i) {
        System.out.println("hello: "+ i);
    }
    
}