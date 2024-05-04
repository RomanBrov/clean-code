package org.robotdreams.patterns.lesson13.theory;

import java.util.Date;
import java.util.UUID;

public class DtoDemo {
    public void start() {
    }

    public void createOrder(customerDiscount user) {

    }

    public orderDto getOrder(long id) {
        return null;
    }
}

// image
// zoomZ, zoomY, alignZoom
// XAML

// <input text="@model.userName"/>
// <input text="@model.password"/>
// <checkbox text="save password" value="@model.savePwd"/>
// <button submit />
// input.text ---> (suspend notifications)  --> model.userName --> (resume notifications)
// model.userName -> input.text

class customer {
    long id;
    String firstName;
    String lastName;
    UUID identifier;
    Date created;
    Date lastLogIn;
    int discount;
}

class customerCreateModel {
    long id;
    String firstName;
    String lastName;
    UUID identifier;
    int discount;
}

class customerReadModel{
    long id;
    String name;
    int discount;
}

class customerDiscount {
    long id;
    UUID identifier;
    int discount;
}

class order {
    long id;
    long user_id;
    int count;
    double price;
}

class orderAsValue {
    long id; // 64 bit: 12345678 & ABCDE = 12345678ABCDE
    long user_id;
    int count;
    double price;

    @Override
    public boolean equals(Object obj) {
        orderAsValue second = (orderAsValue) obj;

        // option #1
//        return  second.id == this.id &&
//                second.user_id == this.user_id &&
//                second.count == this.count &&
//                second.price == this.price;

        // option #2
        int hashCode1 = Long.hashCode(second.id) + Long.hashCode(second.user_id) +
                Integer.hashCode(second.count) + Double.hashCode(second.price);
        int hashCode2 = Long.hashCode(this.id) + Long.hashCode(this.user_id) +
                Integer.hashCode(this.count) + Double.hashCode(this.price);
        return hashCode1 == hashCode2;
    }
}

class orderDto {
    long id;
    long user_id;
    int count;
    double price;
    String firstName;
    String lastName;
    double sum;
    boolean isDelivered;
    boolean isDeclined;
}

class orderModel {
    public void decline() {
    }

    public void checkDelivery() {
    }
}