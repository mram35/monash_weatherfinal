package ObserverPattern;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TemperatureGraph extends ApplicationFrame {

    static ArrayList<String> temp;

    public TemperatureGraph(String applicationTitle , String chartTitle ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Time","Temperature",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset( ) {


        int count = (AccumulatedTemperature.getTemperature()).size();


        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        List<String> templist = AccumulatedTemperature.getTemperature();
        List<String> timelist = AccumulatedTemperature.getTime();




        for (int i = 0; i < count; i++) {

            dataset.addValue(Double.parseDouble(templist.get(i)), "temperature",timelist.get(i));
        }
        return dataset;
    }

    public static void main( String[ ] args ) {
        TemperatureGraph chart = new TemperatureGraph(
                "Temperature Monitor" ,
                "Temperature Monitor");

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }


}