package lab5;



import  java.util.Scanner;
abstract  class  Vehicles  {
    abstract  void  wheel(String  name);
}
interface  MoneyFare  {
    void    charge(String  name);
}
class  Bus  extends  Vehicles  implements  MoneyFare  {
    void  wheel(String  name)  {
        System.out.println("The bus 347 has 6 wheels.");

    }
    public  void  charge(String  name)  {
        System.out.println("The bus 347 2 yuan per people");
    }
}
class  Taxi  extends  Vehicles  implements  MoneyFare{
    void  wheel(String  name)  {
        System.out.println("The taxi Yellow has 4 wheels.");
    }
    public    void  charge(String  name)  {
        System.out.println("The taxi Yellow 2 yuan per km");

    }
}
class  Car  implements  MoneyFare{
    public  void  charge(String  name)  {
        System.out.println("The car BMW is free if it is yours");

    }
}
public  class  P4T3  {
    public  static  void  main(String  args[])  {

        Bus    bus  =  new  Bus();
        Taxi  taxi  =  new  Taxi();
        Car  car  =  new  Car();

        String  busname,taxiname,carname;
        Scanner  s  =  new  Scanner(System.in);

        System.out.println("Please  input  the  bus  line:  ");
        busname  =  s.nextLine();
        System.out.println("Please  input  the  taxi  name:  ");
        taxiname  =  s.nextLine();
        System.out.println("Please  input  the  car  brand:  ");
        carname  =  s.nextLine();
        bus.wheel(busname);
        bus.charge(busname);
        taxi.wheel(taxiname);
        taxi.charge(taxiname);
        car.charge(carname);
    }
}