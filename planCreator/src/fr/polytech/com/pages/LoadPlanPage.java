package fr.polytech.com.pages;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileFilter;

import fr.polytech.com.models.Company;
import fr.polytech.com.models.Data;
import fr.polytech.com.models.Level;

public class LoadPlanPage extends JFrame{

	//private List<Company> companiesList;

	/**
	 * Create the application.
	 */
	public LoadPlanPage(Data data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Data data) {
		setTitle("Plan Creator");
		setSize(450,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		JButton btnOpen = new JButton("Load Plan");
		btnOpen.setBounds(152, 96, 118, 35);
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                jfc.setCurrentDirectory(new File("."));
                jfc.setAcceptAllFileFilterUsed(false);
                final String[][] fileENames = {{".jpg", "Fichier JPG"},
                };

                for (final String[] fileEName : fileENames) {
                    jfc.setFileFilter(new FileFilter() {

                        public boolean accept(File file) {

                            if (file.getName().endsWith(fileEName[0]) || file.isDirectory()) {

                                return true;
                            }
                            return false;
                        }

                        public String getDescription() {
                            return fileEName[1];
                        }
                    });
                }
                jfc.showDialog(null, "OK");
                
                File file = jfc.getSelectedFile();
                if (null != file) {
                	if (file.isFile()) {
	                    System.out.println("Ficher:" + file.getAbsolutePath());
	                    if(data.getLevels()==null) {
	                    	ArrayList<Level> levelsList=new ArrayList<Level>();
		                    data.setLevels(levelsList);
	                    }
	                    PlanDesignerPage planDesignerPage=new PlanDesignerPage(file.getAbsolutePath(),data);
	                    dispose();
	                }
	                //System.out.println(jfc.getSelectedFile().getName());
                } 
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnOpen);
		
	}

}
