package com.example.rentacarapptestphase;

import android.graphics.Bitmap;

public class Car {
    int id;
    String carId;
    String model;
    String capacity;
    String colour;
    String ownerId;
    String status;
    private String imageName;
    private Bitmap image;

    public Car() {
    }

    public Car(int id, String carId, String model, String capacity, String colour, String ownerId, String status)
    {
        this.id = id;
        this.carId = carId;
        this.model = model;
        this.capacity = capacity;
        this.colour = colour;
        this.ownerId = ownerId;
        this.status = status;
    }

    public Car(int id, String carId, String model, String capacity, String colour, String ownerId, String status, String imageName, Bitmap image)
    {
        this.id = id;
        this.carId = carId;
        this.model = model;
        this.capacity = capacity;
        this.colour = colour;
        this.ownerId = ownerId;
        this.status = status;
        this.imageName = imageName;
        this.image = image;
    }

    public Car(String carId, String model, String capacity, String colour, String ownerId, String status, String imageName, Bitmap image) {
        this.carId = carId;
        this.model = model;
        this.capacity = capacity;
        this.colour = colour;
        this.ownerId = ownerId;
        this.status = status;
        this.imageName = imageName;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}