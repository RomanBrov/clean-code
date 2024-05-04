package org.robotdreams.patterns.lesson5.theory;

public class DogBuilderImpl implements DogBuilder {
    private String name;
    private int age;
    private int weightKgs;
    private int heightCms;
    private int color;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(int years) {
        this.age = years;
    }

    @Override
    public void setWeight(int weightKgs) {
        this.weightKgs = weightKgs;
    }

    @Override
    public void setHeight(int heightCms) {
        this.heightCms = heightCms;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public Dog getResult() {
        return new Dog(this.name, this.weightKgs, this.heightCms, this.age, this.color);
    }
}
