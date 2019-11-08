package Animals;

public class Main{
    public static void main(String[] args) {
        Car[] cars = {new E39(), new Impreza()};
        for(Car car : cars){
            System.out.println();
            car.kö();
            car.MiljöDö();
            car.sväng();
            car.hej();
        }

    }
}
