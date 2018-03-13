package fr.polytech.com.tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CircleJButton extends JButton{
	public CircleJButton() {
	    super();
	// ��Щ�����Ѱ�ť��չΪһ��Բ������һ����Բ��
	    Dimension size = getPreferredSize();
	    size.width = size.height = Math.max(size.width, 
	      size.height);
	    setPreferredSize(size);

	//�������ʹJButton�������������������ǻ�һ��Բ�ı�����
	    setContentAreaFilled(false);
	  }
	// ��Բ�ı����ͱ�ǩ
	  protected void paintComponent(Graphics g) {
	    if (getModel().isArmed()) {
	// �����ѡһ����������ɫ��ΪԲ�ΰ�ť�������
	     // g.setColor(Color.lightGray);
	    } else {
	      g.setColor(getBackground());
	    }
	    g.fillOval(0, 0, getSize().width-1, 
	      getSize().height-1);
	//������ûửһ����ǩ�ͽ�����Ρ�
	    super.paintComponent(g);
	  }
	  
	  public void setSize(int radius) {
		  Dimension size=getPreferredSize();
		  size.width=size.height=radius;
		  setPreferredSize(size);
		  
	  }
	// �ü򵥵Ļ�����ť�ı߽硣
	  protected void paintBorder(Graphics g) {
	    g.setColor(getForeground());
	    g.drawOval(0, 0, getSize().width-1, 
	      getSize().height-1);
	  }

	// ������¼�
	  Shape shape;
	  public boolean contains(int x, int y) {
	// �����ť�ı��С������һ���µ���״����
	    if (shape == null || 
	      !shape.getBounds().equals(getBounds())) {
	      shape = new Ellipse2D.Float(0, 0, 
	        getWidth(), getHeight());
	    }
	    return shape.contains(x, y);
	  }
	// ���Գ���
	  public static void main(String[] args) {
	// ����һ������Jackpot����ǩ�İ�ť��    
	    JButton button = new CircleJButton();
	// ����һ���������ʾ�����ť��
	    JFrame frame = new JFrame();
	    frame.setLocationRelativeTo(null);
	    frame.getContentPane().add(button);
	    frame.getContentPane().setLayout(new FlowLayout());
	    frame.setSize(150, 150);
	    frame.setVisible(true);
	  }
}
