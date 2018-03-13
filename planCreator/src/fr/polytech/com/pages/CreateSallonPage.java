package fr.polytech.com.pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.jdesktop.swingx.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import fr.polytech.com.models.Company;
import fr.polytech.com.models.Data;
import fr.polytech.com.models.Stand;

public class CreateSallonPage extends JFrame{
	
	public CreateSallonPage(Data data) {  
        super();  
        initFrame(data);  
    }
	
	private void initFrame(Data data) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setVisible(true);
        setResizable(false); 
        setTitle("Cr¨¦er un sallon");  
        setSize(500, 580);
        setLocationRelativeTo(null);
        
        setLayout(null);
        
        JLabel idLabel=new JLabel("ID unique (nom de sallon et sans espace et caract¨¨s sp¨¦ciaux):");
        idLabel.setBounds(50,20,400,20);
        add(idLabel);
        
        JTextArea idSallonJTA=new JTextArea();
        idSallonJTA.setBounds(50,50,300,20);
        add(idSallonJTA);
        
        JLabel nameLabel=new JLabel("Nom:");
        nameLabel.setBounds(50,90,300,20);
        add(nameLabel);
        
        JTextArea nameJTA=new JTextArea();
        nameJTA.setBounds(50,120,300,20);
        add(nameJTA);
        
        JLabel startLabel=new JLabel("D¨¦but");
        startLabel.setBounds(50,160,300,20);
        add(startLabel); 
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
        

        JXDatePicker startDatePicker=new JXDatePicker();
        startDatePicker.setFormats(formatter);
        startDatePicker.setDate(null);
        startDatePicker.setBounds(50,190,300,20);
        add(startDatePicker);
        
        JLabel endLabel=new JLabel("Fin");
        endLabel.setBounds(50,230,300,20);
        add(endLabel); 
        
         
        JXDatePicker endDatePicker=new JXDatePicker();
        endDatePicker.setFormats(formatter);
        endDatePicker.setDate(null);
        endDatePicker.setBounds(50,250,300,20);
        add(endDatePicker);
           
        JLabel iconLabel=new JLabel("Icone(URL)");
        iconLabel.setBounds(50,290,300,20);
        add(iconLabel);
        
        JTextArea iconJTA=new JTextArea();
        iconJTA.setBounds(50,320,300,20);
        add(iconJTA);
        
        JLabel descriptionLabel=new JLabel("Courte description");
        descriptionLabel.setBounds(50,360,300,20);
        add(descriptionLabel);
        
        JTextArea descriptionJTA=new JTextArea();
        descriptionJTA.setBounds(50,390,300,50);
        add(descriptionJTA);
        
        JButton saveBtn=new JButton("Sauvegarder");
        saveBtn.setBounds(130,480,140,40);
        add(saveBtn);
        saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(idSallonJTA.getText().isEmpty()||nameJTA.getText().isEmpty())
				{
					int ret = JOptionPane.showConfirmDialog(null, "Nom et ID ne peuvent pas ¨ºtre vides","Attention",JOptionPane.DEFAULT_OPTION);
				}
				else {
					data.setId(idSallonJTA.getText());
					data.setName(nameJTA.getText());
					data.setIcon(iconJTA.getText());
					data.setComments(descriptionJTA.getText());
					data.setStart(dataFomate(startDatePicker.getEditor().getText()));
					data.setEnd(dataFomate(endDatePicker.getEditor().getText()));
					System.out.println(data);
					int ret=JOptionPane.showConfirmDialog(null, "Voulez-vous rejoindre la liste des entreprises(au format de fichier csv)","Attention",
							JOptionPane.YES_NO_OPTION);
					if(ret==JOptionPane.YES_OPTION) {
						LoadCsvFilePage loadCsvFilePage=new LoadCsvFilePage(data);
						dispose();
					}else {
						LoadPlanPage loadPlanPage=new LoadPlanPage(data);
						dispose();
					}
				}
			}
		});
	}
	
	private String dataFomate(String str) {
		str=str.replace(" ", "T");
		return str;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Data data=new Data();
					CreateSallonPage sallonPage=new CreateSallonPage(data);
					System.out.println(data);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
