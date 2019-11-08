package Animals;

public class Impreza extends Car {

    public Impreza(){
        super.name = "Impreza";
    }

    @Override
    void MiljöDö() {
        System.out.println("sot");
    }

    @Override
    void sväng() {
        System.out.println("snabb jävla sväng");
    }

    @Override
    void kö() {
        System.out.println("vrun vrun vrun vrun skrrt borta i fjärran");
    }
}
