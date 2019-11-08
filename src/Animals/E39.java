package Animals;

public class E39 extends Car{

    public E39(){
        super.name = "E39";
    }

    @Override
    void MiljöDö(){
        System.out.println("dö miljö");
    }

    void sväng(){
        System.out.println("skrrt");
    }

    void kö(){
        System.out.println("skrt skrt vroom");
    }
}
