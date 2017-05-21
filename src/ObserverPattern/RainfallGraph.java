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

public class RainfallGraph extends ApplicationFrame {


    public RainfallGraph(String applicationTitle , String chartTitle ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Time","Rainfall",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset( ) {


        int count = (AccumulatedTemperature.getRainfall()).size();


        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        List<String> rainlist = AccumulatedTemperature.getRainfall();
        List<String> timelist = AccumulatedTemperature.getTime();




        for (int i = 0; i < count; i++) {

            dataset.addValue(Double.parseDouble(rainlist.get(i)), "rainfall",timelist.get(i));
        }
        return dataset;
    }

    public static void main( String[ ] args ) {
        RainfallGraph chart = new RainfallGraph(
                "Rainfall Monitor" ,
                "Rainfall Monitor");

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }


}