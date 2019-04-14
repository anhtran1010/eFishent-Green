import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

import org.bson.Document;
import org.jfree.ui.RefineryUtilities;

import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.Image;
import javax.swing.JTextArea;
public class EFishGreen extends JFrame implements ActionListener{

	private JTextArea textArea;
	private JFrame frame;
	private File file;
	private LinkedHashMap<String, String[]> data;
	private DbController2 db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EFishGreen window = new EFishGreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EFishGreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		db = new DbController2();
		data = new LinkedHashMap<String, String[]>();
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 555);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnWaterLevel = new JButton("Water Level");
		btnWaterLevel.setLocation(frame.getWidth()/4*3,frame.getHeight()/16*5);
		springLayout.putConstraint(SpringLayout.EAST, btnWaterLevel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnWaterLevel);
		btnWaterLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.isEmpty()) {
					System.out.println("Please import data first");
					textArea.setText("Please import data first");
				}
				else {
				graphBase waterLvlGraph = new graphBase("Water Level over time", "water level", data, 0, "Water Level");
				waterLvlGraph.pack();
				RefineryUtilities.centerFrameOnScreen(waterLvlGraph);
				waterLvlGraph.setVisible(true);
				waterLvlGraph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		JButton btnWateTemperature = new JButton("Water Temp");
		springLayout.putConstraint(SpringLayout.WEST, btnWateTemperature, 514, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnWaterLevel, 0, SpringLayout.WEST, btnWateTemperature);
		springLayout.putConstraint(SpringLayout.SOUTH, btnWaterLevel, -6, SpringLayout.NORTH, btnWateTemperature);
		btnWateTemperature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.isEmpty()) {
					System.out.println("Please import data first");
					textArea.setText("Please import data first");
				}
				else {
				graphBase waterTempGraph = new graphBase("Water Temperature over time", "water Temperature", data, 1, "Temperature");
				waterTempGraph.pack();
				RefineryUtilities.centerFrameOnScreen(waterTempGraph);
				waterTempGraph.setVisible(true);
				waterTempGraph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		frame.getContentPane().add(btnWateTemperature);
		
		JButton btnPhLevel = new JButton(" pH Level");
		springLayout.putConstraint(SpringLayout.WEST, btnPhLevel, 512, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnWateTemperature, -6, SpringLayout.NORTH, btnPhLevel);
		btnPhLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.isEmpty()) {
					System.out.println("Please import data first");
					textArea.setText("Please import data first");
				}
				else {
				graphBase pHGraph = new graphBase("pH Level over time", "pH Level", data, 2, "pH Level");
				pHGraph.pack();
				RefineryUtilities.centerFrameOnScreen(pHGraph);
				pHGraph.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(btnPhLevel);
		
		JButton btnNitrateLevel = new JButton("Nitrate Level");
		springLayout.putConstraint(SpringLayout.WEST, btnNitrateLevel, 512, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnPhLevel, -6, SpringLayout.NORTH, btnNitrateLevel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNitrateLevel, -216, SpringLayout.SOUTH, frame.getContentPane());
		btnNitrateLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.isEmpty()) {
					System.out.println("Please import data first");
					textArea.setText("Please import data first");
				}
				else {
				graphBase nitrateGraph = new graphBase("Nitrate Level over time", "Nitrate Level", data, 3, "Nitrate Level");
				nitrateGraph.pack();
				RefineryUtilities.centerFrameOnScreen(nitrateGraph);
				nitrateGraph.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(btnNitrateLevel);
		
		JButton btnOxygenLevel = new JButton("Oxygen Level");
		springLayout.putConstraint(SpringLayout.NORTH, btnOxygenLevel, 6, SpringLayout.SOUTH, btnNitrateLevel);
		springLayout.putConstraint(SpringLayout.WEST, btnOxygenLevel, 512, SpringLayout.WEST, frame.getContentPane());
		btnOxygenLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.isEmpty()) {
					System.out.println("Please import data first");
					textArea.setText("Please import data first");
				}
				else {
				graphBase oxygenGraph = new graphBase("Oxygen Level over time", "Oxygen Level", data, 4, "Oxygen");
				oxygenGraph.pack();
				RefineryUtilities.centerFrameOnScreen(oxygenGraph);
				oxygenGraph.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(btnOxygenLevel);
		
		JButton btnAmmonia = new JButton("Ammonia");
		springLayout.putConstraint(SpringLayout.NORTH, btnAmmonia, 6, SpringLayout.SOUTH, btnOxygenLevel);
		springLayout.putConstraint(SpringLayout.EAST, btnAmmonia, 0, SpringLayout.EAST, btnPhLevel);
		btnAmmonia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.isEmpty()) {
					System.out.println("Please import data first");
					textArea.setText("Please import data first");
				}
				else {
				graphBase ammoniaGraph = new graphBase("Ammonia Level over time", "Ammonia Level", data, 5, "Ammonia");
				ammoniaGraph.pack();
				RefineryUtilities.centerFrameOnScreen(ammoniaGraph);
				ammoniaGraph.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(btnAmmonia);
		
		JButton btnLightIntensity = new JButton("Light Intensity");
		springLayout.putConstraint(SpringLayout.NORTH, btnLightIntensity, 6, SpringLayout.SOUTH, btnAmmonia);
		springLayout.putConstraint(SpringLayout.WEST, btnLightIntensity, 0, SpringLayout.WEST, btnWaterLevel);
		btnLightIntensity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.isEmpty()) {
					System.out.println("Please import data first");
					textArea.setText("Please import data first");
				}
				else {
				graphBase lightIntensityGraph = new graphBase("Light Intensity Control", "Light Intensity", data, 6, "Intensity");
				lightIntensityGraph.pack();
				RefineryUtilities.centerFrameOnScreen(lightIntensityGraph);
				lightIntensityGraph.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(btnLightIntensity);
		
		JButton btnAirTemp = new JButton("Air/Humidity");
		springLayout.putConstraint(SpringLayout.NORTH, btnAirTemp, 6, SpringLayout.SOUTH, btnLightIntensity);
		springLayout.putConstraint(SpringLayout.WEST, btnAirTemp, 512, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAirTemp, -83, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnAirTemp, -10, SpringLayout.EAST, frame.getContentPane());
		btnAirTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.isEmpty()) {
					System.out.println("Please import data first");
					textArea.setText("Please import data first");
				}
				else {
				graphBase airTempGraph = new graphBase("Air Temperature/Humidity Level Over Time", "Air Temperature/Humidity Level", data, 7, "Air Temp/Humidity");
				airTempGraph.pack();
				RefineryUtilities.centerFrameOnScreen(airTempGraph);
				airTempGraph.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(btnAirTemp);
		
		JButton btnImportData = new JButton("Import Data");
		frame.getContentPane().add(btnImportData);
		btnImportData.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	JFileChooser c = new JFileChooser();
	            // Demonstrate "Open" dialog:
	            int rVal = c.showOpenDialog(EFishGreen.this);
	            if (rVal == JFileChooser.APPROVE_OPTION) {
	              file = c.getSelectedFile();
	              parseFile parser = new parseFile(data, file);
	              Set<String> keys = data.keySet();
	              for(String key : keys) {
	            	  db.insert(key, data.get(key));
	              }
	            }
	        }
	    } );
		
		JButton btnGenerateData = new JButton("Generate Data");
		springLayout.putConstraint(SpringLayout.WEST, btnGenerateData, 363, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnGenerateData, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnImportData, 0, SpringLayout.NORTH, btnGenerateData);
		springLayout.putConstraint(SpringLayout.EAST, btnImportData, -53, SpringLayout.WEST, btnGenerateData);
		frame.getContentPane().add(btnGenerateData);
		btnGenerateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create a graph in the textField below using the LinkedHashmap data
				ArrayList<ControlVariable> list = new ArrayList<ControlVariable>();
				String d = "";
				for(String k : data.keySet()) {
					String[] array = data.get(k);
					double waterLvl = Double.parseDouble(array[0]);
					double waterTemp = Double.parseDouble(array[1]);
					double ph = Double.parseDouble(array[2]);
					double nitrate = Double.parseDouble(array[3]);
					double oxygen = Double.parseDouble(array[4]);
					double ammonia = Double.parseDouble(array[5]);
					double light = Double.parseDouble(array[6]);
					double air = Double.parseDouble(array[7]);
					list.add(new ControlVariable(waterLvl, waterTemp, ph,  nitrate,  oxygen,  ammonia,  light,  air));
					d = k;
			    }
				if(data.isEmpty()) {
					System.out.println("Please import data first");
					textArea.setText("Please import data first");
				}
				else {
					// Insert data into text field
					ControlVariable c = list.get(list.size()-1);
					textArea.append("==================== DATA LIST ====================" + '\n'+ '\n');
					textArea.append("DATE: " + d +  '\n'+ '\n');
					textArea.append("WATER-LEVEL: " + Double.toString(c.getWaterLevel()) + '\n'+ '\n');
					textArea.append("WATER-TEMP: " + Double.toString(c.getWaterTemp()) + '\n'+ '\n');
					textArea.append("PH: " +  Double.toString(c.getPH()) + '\n'+ '\n');
					textArea.append("NITRATE: " + Double.toString(c.getNitrate()) + '\n'+ '\n');
					textArea.append("OXYGEN: " + Double.toString(c.getOxygen()) +'\n'+ '\n');
					textArea.append("AMMONIA: " +Double.toString(c.getAmmonia()) + '\n'+ '\n');
					textArea.append("LIGHT-INTENSITY: " + Double.toString(c.getLight()) +'\n'+ '\n');
					textArea.append("AIR-TEMP: " + Double.toString(c.getAirTemp()) +'\n');
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 97, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 617, SpringLayout.WEST, frame.getContentPane());
		Image img = new ImageIcon(this.getClass().getResource("/EFishGreenLogo1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 26, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 24, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
		
		textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 36, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 24, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, 195, SpringLayout.SOUTH, btnPhLevel);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 492, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textArea);

		JButton btnPreviousData = new JButton("Previous Data");
		springLayout.putConstraint(SpringLayout.WEST, btnPreviousData, 42, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnPreviousData, -10, SpringLayout.SOUTH, frame.getContentPane());
		btnPreviousData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane dialog = new JOptionPane();
				String fileName = "./"+JOptionPane.showInputDialog("what do you want to name your data file?");
				@SuppressWarnings("unchecked")
				Iterator<Document> data = db.get();
				while(data.hasNext()) {
					try(FileWriter fw = new FileWriter(fileName, true);
				            BufferedWriter bw = new BufferedWriter(fw);
				            PrintWriter out = new PrintWriter(bw))
				    {
				            out.println(data.next());
				    } catch (IOException e1) {
				            System.out.println("Error writing to file.");
				    }
				}	
			}
		});
		frame.getContentPane().add(btnPreviousData);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}