import org.jfree.chart.ChartPanel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class graphBase extends ApplicationFrame {

   public graphBase( String applicationTitle , String chartTitle, LinkedHashMap<String, String[]> data, int index, String value ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Dates",value,
         createDataset(data, index, value),
         PlotOrientation.VERTICAL,
         true,true,false);
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset(LinkedHashMap<String, String[]> data, int index, String value ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      Set<String> keys = data.keySet();
      String date = "";
      int intDate = 0;
      for(String key:keys) {
    	  date = key.substring(3,5);
    	  break;
      }
      for(String key:keys) {
    	  dataset.addValue(Double.parseDouble(data.get(key)[index]), value, date);
    	  intDate = Integer.parseInt(date)+1;
    	  date =intDate+"";
    	  //System.out.print(key);
    	  //System.out.println(key.substring(0, 5));
      }
      return dataset;
   }

}
