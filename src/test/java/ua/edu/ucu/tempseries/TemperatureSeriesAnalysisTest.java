package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {
    @Test(expected = InputMismatchException.class)
    public void testMinimumValue() {
        double[] temperatureSeries = {-273.1};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }
    @Test
    public void testDeviationWithOneElement() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.deviation();
    }
    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 14.0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testMinWithOneElement() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.min();
    }
    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testMaxWithOneElement() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.min();
    }
    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testClosestToZeroWithOneElement() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToZero();
    }
    @Test
    public void testClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testClosestToValueWithOneElement() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(100.0);
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToValue(100.0);
    }
    @Test
    public void testClosestToValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(4.0);
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testFindTempsGreaterThanWithOneElementWithEmptyResult() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1.0);
        assertEquals(expResult, actualResult.length, 0.00001);
    }
    @Test
    public void testFindTempsGreaterThanWithOneElement() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-2.0);
        assertEquals(expResult, actualResult[0], 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThanWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(100.0);
    }
    @Test
    public void testFindTempsGreaterThanWithEmptyResult() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(100.0);
        assertEquals(expResult, actualResult.length, 0.00001);
    }
    @Test
    public void testFindTempsGreaterThan() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3.0, 1.0, 5.0, 0.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(0.0);
        for (int i = 0; i < actualResult.length; i ++) {
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }
    @Test
    public void testFindTempsLessThanWithOneElementWithEmptyResult() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;
        double[] actualResult = seriesAnalysis.findTempsLessThen(-2.0);
        assertEquals(expResult, actualResult.length, 0.00001);
    }
    @Test
    public void testFindTempsLessThanWithOneElement() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double[] actualResult = seriesAnalysis.findTempsLessThen(0.0);
        assertEquals(expResult, actualResult[0], 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThanWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] actualResult = seriesAnalysis.findTempsLessThen(100.0);
    }
    @Test
    public void testFindTempsLessThanWithEmptyResult() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;
        double[] actualResult = seriesAnalysis.findTempsLessThen(-100.0);
        assertEquals(expResult, actualResult.length, 0.00001);
    }
    @Test
    public void testFindTempsLessThan() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-5.0, -1.0, -5.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(0.0);
        for (int i = 0; i < actualResult.length; i ++) {
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTempSummaryStatisticsEmpty() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.summaryStatistics();
    }
    @Test
    public void testTempSummaryStatisticsWithOneElement() {
        double[] temperatureSeries = {1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics seriesSummary = seriesAnalysis.summaryStatistics();
        String actualResult = seriesSummary.toString();
        String expResult = "TempSummaryStatistics{avgTemp=1.0, devTemp=0.0, minTemp=1.0, maxTemp=1.0}";
        assertEquals(expResult, actualResult);
    }
    @Test
    public void testTempSummaryStatistics() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics seriesSummary = seriesAnalysis.summaryStatistics();
        String actualResult = seriesSummary.toString();
        String expResult = "TempSummaryStatistics{avgTemp=-0.2857142857142857, devTemp=12.204081632653061, minTemp=-5.0, maxTemp=5.0}";
        assertEquals(expResult, actualResult);
    }
    @Test
    public void testAddTempsWithOneElement() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] newTemps = {2.0};
        seriesAnalysis.addTemps(newTemps);
        double [] expResult = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0, 0.0, 2.0};
        double [] actualResult = seriesAnalysis.getTemperatureSeries();
        for (int i = 0; i < actualResult.length; i ++) {
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }
    @Test
    public void testAddTempsEmptyAdded() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] newTemps = {};
        seriesAnalysis.addTemps(newTemps);
        double [] expResult = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0, 0.0};
        double [] actualResult = seriesAnalysis.getTemperatureSeries();
        for (int i = 0; i < actualResult.length; i ++) {
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }
    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {2.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] newTemps = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0, 0.0};
        seriesAnalysis.addTemps(newTemps);
        double [] expResult = {2.0, 3.0, 3.0, -5.0, 1.0, 5.0, -1.0, -5.0, 0.0};
        double [] actualResult = seriesAnalysis.getTemperatureSeries();
        for (int i = 0; i < actualResult.length; i ++) {
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }
    @Test(expected = InputMismatchException.class)
    public void testAddTempsMinimumValue() {
        double[] temperatureSeries = {2.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] newTemps = {3.0, -5.0, 1.0, 5.0, -1.0, -5.0, 0.0, -273.01};
        seriesAnalysis.addTemps(newTemps);
    }
    @Test
    public void testAddTempsEmpty() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        double[] newTemps = {-2.0, 3.0, 4.0};
        seriesAnalysis.addTemps(newTemps);
        double [] expResult = {-2.0, 3.0, 4.0};
        double [] actualResult = seriesAnalysis.getTemperatureSeries();
        for (int i = 0; i < actualResult.length; i ++) {
            assertEquals(expResult[i], actualResult[i], 0.00001);
        }
    }
}
