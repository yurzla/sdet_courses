package lesson01;
import java.util.ArrayList;

import lesson01.classes.Vehicle;
import lesson01.enums.CarClass;
import lesson01.enums.TruckTrailer;
import lesson01.interfaces.IVehicle;

class Runme {
    public static void main(String[] args)
    {
        ArrayList<IVehicle> vehicles = new ArrayList<IVehicle>();
        vehicles.add(Vehicle.CreateCar("а123бв73rus", "Федя", "Опель", 5, CarClass.B));
        vehicles.add(Vehicle.CreateCar("в321бa73rus", "Вася", "Неопель", 5, CarClass.B));
        vehicles.add(Vehicle.CreateTruck("я111юэ73rus", "Петя@Ko", "Мамаз", TruckTrailer.TRAILER, 5000));

        System.out.println("[");
        for (IVehicle v: vehicles)
            System.out.println(String.format("{%s}", v.toString()));
        System.out.println("]");
        System.out.println("Всего машин: " + Vehicle.getTotalVehiclesNumber());
    }
}
