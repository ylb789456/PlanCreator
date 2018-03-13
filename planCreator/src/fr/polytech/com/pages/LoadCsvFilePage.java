package fr.polytech.com.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import com.csvreader.CsvReader;

import fr.polytech.com.models.Company;
import fr.polytech.com.models.Data;

public class LoadCsvFilePage extends JFrame{
	private List<Company> finalCompanies;
	
	public LoadCsvFilePage(Data data) {
		initialize(data);
	}
	
	private void initialize(Data data) {
		setTitle("Choose a CSV file");
		setVisible(true);
		setSize(450,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JButton openBtn = new JButton("Load Fichier");
		openBtn.setBounds(152, 96, 118, 35);
		setLayout(null);
		add(openBtn);
		openBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                jfc.setCurrentDirectory(new File("."));
                jfc.setAcceptAllFileFilterUsed(false);
                final String[][] fileENames = {{".csv", "Fichier CSV"},
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
	                    try {
	                    	data.setCompanies(Csv2List(file.getAbsolutePath()));
	                    	setVisible(false);
	                    	LoadPlanPage loadPlanPage=new LoadPlanPage(data);
	                    	System.out.println(data.toString());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                }
                }
                dispose();
			}
		});
		
	}
	
	private ArrayList<Company> Csv2List(String filePath) throws Exception{
		List<Company> tempList=new ArrayList<Company>();
		DataInputStream in = new DataInputStream(new FileInputStream(new File(filePath)));
	    BufferedReader br= new BufferedReader(new InputStreamReader(in,"UTF-8"));
		CsvReader r = new CsvReader(br);
		
		r.readHeaders();
        //逐条读取记录，直至读完
		int id=0;
        while (r.readRecord()) {
            //读取一条记录
            //System.out.println(r.getRawRecord());
            //按列名读取这条记录的值
            Company company=new Company(id++, r.get("Name"), r.get("Description"), r.get("Icon"));
            tempList.add(company);
        }
		return (ArrayList<Company>) tempList;
	}
}
