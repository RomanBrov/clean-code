package org.robotdreams.patterns.lesson5.theory;

interface DogBuilder {
    // void reset(); // not a best practice

    void setName(String name);

    void setAge(int years);

    void setWeight(int weightKgs);

    void setHeight(int heightCms);

    void setColor(int color);

    Dog getResult();
}
