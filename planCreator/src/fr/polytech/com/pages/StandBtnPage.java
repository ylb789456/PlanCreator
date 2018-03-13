package fr.polytech.com.pages;

import java.awt.BorderLayout;  
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;  
import java.awt.EventQueue;  
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.FocusEvent;  
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.BorderFactory;  
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;  
import javax.swing.JScrollPane;  
import javax.swing.JTextField;  
import javax.swing.SwingConstants;

import fr.polytech.com.models.Company;
import fr.polytech.com.models.Stand;  
  
public class StandBtnPage extends JDialog {  
  
    private static final long serialVersionUID = 1L;  
    private JPanel jPanel;  
    private JComboBox<String> companiesCombo;
    private boolean deleteFlag=false;
    
    public StandBtnPage(Frame frame,List<Company> companyList,Stand stand) {  
        super(frame,true);  
        initFrame(companyList,stand);  
    }  
      
      //add position and size of button to init.
    public void initFrame(List<Company> companyList,Stand stand) {
    	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  
        //setVisible(true);
        Point mousePoint=MouseInfo.getPointerInfo().getLocation();
        setLocation(mousePoint.x+100,mousePoint.y);  
        setResizable(false); 
        setTitle("Créer un stand");  
        setSize(350, 230);
          
        
        
        
        if(companyList!=null) {
        	companiesCombo=new JComboBox<String>();
            companiesCombo.setEditable(false);
            for(Company company:companyList) {
            	companiesCombo.addItem(company.getId()+"."+company.getName());
            }
            if(stand.getShape()!=null) {//modify
            	Company tmpCompany=companyList.get(stand.getIdCompany());
            	companiesCombo.setSelectedItem(tmpCompany.getId()+"."+tmpCompany.getName());
            }
            jPanel = new JPanel();
            jPanel.setBorder((BorderFactory.createTitledBorder("Choisir une entreprise")));
            add(jPanel, BorderLayout.CENTER);
            jPanel.add(companiesCombo); 
        }
        
          
        JPanel panel = new JPanel();  
        JButton saveButton = new JButton("Sauvegarder");  
       
        
        saveButton.addActionListener(new ActionListener() {  
              
            @Override  
            public void actionPerformed(ActionEvent e) {  
				try {
					if(companiesCombo!=null) {
						stand.setIdCompany(companiesCombo.getSelectedIndex());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                dispose();
            }  
        });  
        JButton deleteBtn=new JButton("Supprimer");
        deleteBtn.addActionListener(new ActionListener() {  
            
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	int ret = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de le supprimer?","Attention",JOptionPane.YES_NO_OPTION);
				if(ret==JOptionPane.YES_OPTION) {
					setDeleteFlag(true);
					setVisible(false);
				}else {
					
				}
            }  
        });
        
        panel.add(saveButton);
        panel.add(deleteBtn);
        add(panel, BorderLayout.SOUTH);  
        JPanel panelN = new JPanel();  
        add(panelN, BorderLayout.NORTH);  
        JPanel panelW = new JPanel();  
        add(panelW, BorderLayout.WEST);  
        JPanel panelE = new JPanel();  
        add(panelE, BorderLayout.EAST);  
          
        // 给JPanel追加垂直滚动条  
        //addScroll();  
    }  
      
      
    public void addScroll() {  
        Container scrollPanel = getContentPane();  
        JScrollPane jScrollPane = new JScrollPane(jPanel);    
        scrollPanel.setPreferredSize(new Dimension(400, 280));  
        scrollPanel.add(jScrollPane);  
        scrollPanel.setVisible(true);  
    }

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}  
}  
