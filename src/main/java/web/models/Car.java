package web.models;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private long id;
    private String Manufacturer;
    private int wheelsCount;


    public Car(long id, String manufacturer, int wheelsCount) {
        this.id = id;
        Manufacturer = manufacturer;
        this.wheelsCount = wheelsCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }


    public static List<Car> mockList() {
        List<Car> list = new ArrayList<>(5);
        list.add(new Car(1, "Камаз", 6));
        list.add(new Car(2, "УАЗ", 4));
        list.add(new Car(3, "КРАЗ", 5));
        list.add(new Car(4, "Белаз", 4));
        list.add(new Car(5, "Вундер Вафл", 18));

        return list;
    }
}
