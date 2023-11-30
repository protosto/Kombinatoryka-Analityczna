package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Plot {
    private final String name;
    private final XYSeriesCollection dataset = new XYSeriesCollection();

    public Plot(String name) {
        this.name = name;
    }

    public void add(Map<Integer, Integer> results, String name) {
        XYSeries series = new XYSeries(name);
        results.forEach(series::add);
        dataset.addSeries(series);
    }

    public void addDouble(Map<Integer, Double> results, String name) {
        XYSeries series = new XYSeries(name);
        results.forEach(series::add);
        dataset.addSeries(series);
    }

    public void makeAndSave() throws IOException {
        JFreeChart chart = make();
        ChartUtils.saveChartAsPNG(new File(name + ".png"), chart, 800, 600);
    }

    private JFreeChart make() {
        return ChartFactory.createXYLineChart(
                name, "n", "%", dataset,
                PlotOrientation.VERTICAL, true, false, false
        );
    }

    public void display() {
        ;
        ChartFrame frame = new ChartFrame(name, make());
        frame.pack();
        frame.setVisible(true);
    }

}