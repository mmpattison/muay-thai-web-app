package com.techelevator.model;

public class WeightClass {
    private final String weightClassName;

    private final double minimumWeight;
    private final double maximumWeight;

    public WeightClass(String weightClassName, double minimumWeight, double maximumWeight) {
        this.weightClassName = weightClassName;
        this.minimumWeight = minimumWeight;
        this.maximumWeight = maximumWeight;
    }

    public String getWeightClassName() {
        return weightClassName;
    }

    public double getMinimumWeight() {
        return minimumWeight;
    }

    public double getMaximumWeight() {
        return maximumWeight;
    }


    @Override
    public String toString() {
        return "WeightClass{" +
                "weightClassName='" + weightClassName + '\'' +
                ", minimumWeight=" + minimumWeight +
                ", maximumWeight=" + maximumWeight +
                '}';
    }
}
