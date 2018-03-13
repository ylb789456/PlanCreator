package fr.polytech.com.pages;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import com.csvreader.CsvReader;

import fr.polytech.com.models.Address;
import fr.polytech.com.models.Company;
import fr.polytech.com.models.Data;
import fr.polytech.com.models.Level;
import fr.polytech.com.models.Stand;
import fr.polytech.com.tools.CircleJButton;
import fr.polytech.com.tools.DnDAdapter;
import net.sf.json.JSONObject;
import fr.polytech.com.models.Pos;
import fr.polytech.com.models.Shape;
import fr.polytech.com.models.Size;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;


public class PlanDesignerPage extends JFrame{
	

	/**
	 * 鼠标的状态
	 */
	public static int mouseStatus=0;
	private static int locaX=0;
	private static int locaY=0;
	private static int count=-1;
	
	/**
	 * 构造方法的辅助字符串
	 */
	private int mouseLocaX=0;
	private int mouseLocaY=0;
	private static int length=0;
	/**
	 * 什么都没有点击
	 */
	public static final int NO=0;
	
	/**
	 * 
	 */
	public static final int RECTANGLE_STAND=1;
	public static final int CIRCLE_STAND=2;
	private ImageIcon imageIcon;
	private Dimension frameSize; 
	private Level level;
	private List<Company> companiesList;
	private ArrayList<Stand> standsList;
	
	public PlanDesignerPage(Data data) {
		
	}
	
	public PlanDesignerPage(String imagePath,Data data) {
		try {
			launch(imagePath,data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PlanDesignerPage(String imagePath, JSONObject data) {
		// TODO Auto-generated constructor stub
		try {
			launch(imagePath,data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void launch(String imagePath,JSONObject data) {
		
	}

	private void launch(String imagePath,Data data) throws Exception
	{
		level=new Level();
		standsList=new ArrayList<Stand>();
		companiesList=data.getCompanies();
		imageIcon = new ImageIcon(imagePath);
		setIconImage(imageIcon.getImage());
	    frameSize = new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight());
	    addImageByRepaint();
	    setBounds(locaX, locaY, imageIcon.getIconWidth(), imageIcon.getIconHeight());
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		MouseWork mouseWork=new MouseWork();
		addMouseListener(mouseWork);
		addMouseMotionListener(mouseWork);
		setTitle("Plan Designer");
		setLocationRelativeTo(null);
		JButton rectangleStandBtn=new JButton();
		rectangleStandBtn.setText("Stand rectangle");
		rectangleStandBtn.setSize(600,150);
		rectangleStandBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				mouseStatus=RECTANGLE_STAND;
			}
		});
		JButton circleStandBtn=new JButton();
		circleStandBtn.setText("Stand rond");
		circleStandBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				mouseStatus=CIRCLE_STAND;
			}
		});
		JButton saveBtn=new JButton("Sauvegarder");
		saveBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				LevelPage levelPage=new LevelPage(level);
				//Similar with beacon configurator
				level.setSize(new Size(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
				if(standsList.size()!=0)
					level.setStands(standsList);
				data.getLevels().add(level);
				Address address=new Address();
				data.setAddress(address);
				System.out.println(data);
				JSONObject json = JSONObject.fromObject(data);
				System.out.println(json.toString());
				
			}
		});
		setLayout(new FlowLayout());
		add(rectangleStandBtn);
		add(circleStandBtn);
		add(saveBtn);
		setVisible(true);		
	}
	
	
	
	class ImagePanel extends JPanel {
        Dimension d;
        Image image;

        public ImagePanel(Dimension d, Image image) {
            super();
            this.d = d;
            this.image = image;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, d.width, d.height, this);
            repaint();
        }
    }
	
	
	
	
	public void addImageByRepaint() {
        ImagePanel imagePanel = new ImagePanel(frameSize, imageIcon.getImage());
        setContentPane(imagePanel);
        setVisible(true);
    }
	
	private class MouseWork extends MouseAdapter
	{
		public synchronized void mouseClicked(MouseEvent e) 
		{
			DnDAdapter dnd=new DnDAdapter();
			switch (mouseStatus)
			{
			case RECTANGLE_STAND:
				JButton btnR = new JButton();
				btnR.setBackground(Color.GRAY);
				Stand standR=new Stand();
				btnR.setBounds(mouseLocaX,mouseLocaY,70,30);
				add(btnR);
				btnR.addMouseMotionListener(dnd);
				btnR.addMouseListener(new MouseListener(){
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount() == 1) { 
							ButtonActionBody(standR,btnR);
						}
						
					}
					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				ButtonActionBody(standR,btnR);
				standsList.add(standR);
				mouseStatus=NO;
				break;
			case CIRCLE_STAND:
				JButton btnC = new CircleJButton();
				btnC.setBackground(Color.GRAY);
				Stand standC=new Stand();
				btnC.setBounds(mouseLocaX,mouseLocaY,30,30);
				add(btnC);
				btnC.addMouseMotionListener(dnd);
				btnC.addMouseListener(new MouseListener(){
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount() == 1) { 
							ButtonActionBody(standC,btnC);
						}
						
					}
					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
					}
				});
				ButtonActionBody(standC,btnC);
				standsList.add(standC);
				mouseStatus=NO;
				break;
			}
		}
		public void mouseMoved(MouseEvent e) 
		{
			mouseLocaX=get(e.getX());
			mouseLocaY=get(e.getY());
		}
		private int get(int x) 
		{
			return x;
		}
	}
	
	private void ButtonActionBody(Stand stand,JButton btn) {
		StandBtnPage standBtnObject = new StandBtnPage(PlanDesignerPage.this,companiesList,stand);
		standBtnObject.setVisible(true);
		//standR.setPositionAndSize(btnR);
		if(standBtnObject.isDeleteFlag()) {
			remove(btn);
			standsList.remove(stand);
		}else {
			stand.setShape(btn);
			System.out.println(stand.toString());
		}
	}
	

	
}
