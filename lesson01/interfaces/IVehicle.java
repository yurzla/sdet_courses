package lesson01.interfaces;

public interface IVehicle {
    // гос номер авто
    String getStateNumber();
    void setStateNumber(String value);

    // информация о хозяине авто
    String getOwner();
    void setOwner(String value);

    // производитель авто
    String getManufacturer();
    void setManufacturer(String value);
}