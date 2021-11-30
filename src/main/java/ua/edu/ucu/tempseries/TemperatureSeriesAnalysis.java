package ua.edu.ucu.tempseries;

import lombok.Getter;

import java.util.Arrays;
import java.util.InputMismatchException;

@Getter
public class TemperatureSeriesAnalysis {
    private static final int MIN_VALUE = -273;
    private static final int MAX_VALUE = 100000;
    private int numberOfTemps = 0;
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[]{};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double temp: temperatureSeries) {
            if (temp < MIN_VALUE) {
                throw new
                        InputMismatchException("The temperature exceeds minimum value!");
            }
        }
        this.temperatureSeries =
                Arrays.copyOf(temperatureSeries, temperatureSeries.length);
        this.numberOfTemps = temperatureSeries.length;
    }

    public double average() {
        double result = 0;
        if (numberOfTemps == 0) {
            throw new
                    IllegalArgumentException("Series of temperature is empty!");
        } else {
            for (int i = 0; i < numberOfTemps; i++) {
                result += temperatureSeries[i];
            }
        }
        return result / numberOfTemps;
    }

    public double deviation() {
        double averageValue = average();
        double result = 0;
        for (int i = 0; i < numberOfTemps; i++) {
            result += (temperatureSeries[i] - averageValue)
                    *(temperatureSeries[i] - averageValue);
        }
        return result/numberOfTemps;
    }

    public double min() {
        return findTempClosestToValue(MIN_VALUE);
    }

    public double max() {
        return findTempClosestToValue(MAX_VALUE);
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        double closest;
        if (numberOfTemps == 0) {
            throw new
                    IllegalArgumentException
                    ("Series of temperature is empty!");
        } else {
            closest = temperatureSeries[0];
            for (int i = 1; i < numberOfTemps; i++) {
                if (Math.abs(temperatureSeries[i] - tempValue)
                        < Math.abs(closest - tempValue)) {
                    closest = temperatureSeries[i];
                } else if (Math.abs(temperatureSeries[i] - tempValue)
                        == Math.abs(closest - tempValue)) {
                    if (temperatureSeries[i] > tempValue) {
                        closest = temperatureSeries[i];
                    }
                }
            }
        }
        return closest;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (numberOfTemps == 0) {
            throw new
                    IllegalArgumentException("Series of temperature is empty!");
        } else {
            double[] result = {};
            int pointer = 0;
            for (int i = 0; i < numberOfTemps; i++) {
                if (temperatureSeries[i] < tempValue) {
                    if (result.length == 0) {
                        result = Arrays.copyOf(result, 1);
                    } else if (result.length == pointer) {
                        result = Arrays.copyOf(result, 2 * result.length);
                    }
                    result[pointer] = temperatureSeries[i];
                    pointer++;
                }
            }
            result = Arrays.copyOf(result, pointer);
            return result;
        }
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (temperatureSeries.length == 0) {
            throw new
                    IllegalArgumentException("Series of temperature is empty!");
        } else {
            double[] result = {};
            int pointer = 0;
            for (int i = 0; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] >= tempValue) {
                    if (result.length == 0) {
                        result = Arrays.copyOf(result, 1);
                    } else if (result.length == pointer) {
                        result = Arrays.copyOf(result, 2 * result.length);
                    }
                    result[pointer] = temperatureSeries[i];
                    pointer++;
                }
            }
            result = Arrays.copyOf(result, pointer);
            return result;
        }
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        for (double temp: temps) {
            if (temp < MIN_VALUE) {
                throw new
                        InputMismatchException
                        ("The temperature exceeds minimum value!");
            }
            if (numberOfTemps == 0) {
                temperatureSeries = Arrays.copyOf(temperatureSeries, 1);
            }
            else if (temperatureSeries.length == numberOfTemps) {
                temperatureSeries =
                        Arrays.copyOf(temperatureSeries,
                                2*temperatureSeries.length);
            }
            temperatureSeries[numberOfTemps] = temp;
            this.numberOfTemps += 1;
        }
        temperatureSeries = Arrays.copyOf(temperatureSeries, numberOfTemps);
        return numberOfTemps;
    }
}
