package fr.polytech.com.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import fr.polytech.com.models.Level;

public class LevelPage extends JDialog{
	private boolean saveFlag=false;
	private boolean deleteFlag=false;
	
	public LevelPage(Level level) {  
        super();  
        initFrame(level);  
    }
	
	private void initFrame(Level level) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setVisible(true);
        setResizable(false); 
        setTitle("Cr¨¦er un ¨¦tage");  
        setSize(400, 300);
        setLocationRelativeTo(null);
        setModal(true);
        setLayout(null);
        
        JLabel nameLabel=new JLabel("Nom:");
        nameLabel.setBounds(50,20,300,20);
        add(nameLabel);
        
        JTextArea nameJTA=new JTextArea();
        nameJTA.setBounds(50,50,300,20);
        add(nameJTA);
        
        JLabel backgroundLabel=new JLabel("Image de font:");
        backgroundLabel.setBounds(50,90,300,20);
        add(backgroundLabel);
        
        JTextArea backgroundJTA=new JTextArea();
        backgroundJTA.setBounds(50,120,300,20);
        add(backgroundJTA);
        
        JButton saveBtn=new JButton("Sauvegarder");
        saveBtn.setBounds(60,180,120,40);
        add(saveBtn);
        
        if(level.getName()!=null&&level.getBackground()!=null){
        	nameJTA.setText(level.getName());
        	backgroundJTA.setText(level.getBackground());
        }
        
        saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(backgroundJTA.getText().isEmpty()||nameJTA.getText().isEmpty())
				{
					int ret = JOptionPane.showConfirmDialog(null, "Nom et image ne peuvent pas ¨ºtre vides!","Attention",JOptionPane.DEFAULT_OPTION);
				}
				else {
					level.setName(nameJTA.getText());
					level.setBackground(backgroundJTA.getText());
					System.out.println(level);
					saveFlag=true;
				}
			}
		});
        
       
        
	}

	public boolean isSaveFlag() {
		return saveFlag;
	}

	public void setSaveFlag(boolean saveFlag) {
		this.saveFlag = saveFlag;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


}
