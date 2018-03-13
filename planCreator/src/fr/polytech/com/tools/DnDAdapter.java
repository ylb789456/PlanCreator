package fr.polytech.com.tools;

import java.awt.Cursor;  
import java.awt.Point;  
import java.awt.Rectangle;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
  
import javax.swing.JButton;  
import javax.swing.JComponent;  
import javax.swing.JFrame;  
import javax.swing.JList;  
import javax.swing.JPanel;  
import javax.swing.JTable;  
import javax.swing.JTree;  
public class DnDAdapter extends MouseAdapter  
{  
    //ÿ���������Ϣ���ڽ������ʱ��á�  
    private JComponent jcom;  
    private Point jcomOriginPoint;//����������ڵ�����  
    private int jcomWidth,jcomHeight;  
    //�붨λ�����������Ϣ  
    private int a=10;//�������ش�С  
    private    Point pointMoved;//�ƶ�ʱ������������  
    private CurType curCuror;//  
    private enum  CurType {LeftTop,LeftBottom,RightTop,RightBottom,Top,Bottom,Left,Right,Center}  
    //��������ж�  
    private  CurType getCurType(MouseEvent e)  
    {  
        Point p=e.getPoint();//getPoint��������ڵ�����  
        //���Ͻ� 0<x<a,0<y<a  
        if((p.x>=0 && p.x<=a)&&(p.y>=0&&p.y<=a))  
            return CurType.LeftTop;  
        //���½� w-a<x<w  h-a<y<h  
        else if((p.x>=jcomWidth-a&&p.x<=jcomWidth)&&(p.y>=jcomHeight-a&&p.y<=jcomHeight))  
            return CurType.RightBottom;  
        //���Ͻ�w-a<x<w,0<y<a  
        else if((p.x>=jcomWidth-a&&p.x<=jcomWidth)&&(p.y>=0&&p.y<=a))  
            return CurType.RightTop;  
        //���½�0<x<a,h-a<y<h  
        else if((p.x>=0&&p.x<=a)&&(p.y>=jcomHeight-a&&p.y<=jcomHeight))  
            return CurType.LeftBottom;  
        //��ֱ��w-a<x<w && a<y<h-a �ұ�  
        else if( p.x>=jcomWidth-a && p.x<=jcomWidth && p.y>=a && p.y<=jcomHeight-a)  
            return CurType.Right;  
        //��ֱ��0<x<a,a<y<h-a ���  
        else if(p.x>=0 && p.x<=a && p.y>=a && p.y<=jcomHeight-a)  
            return CurType.Left;  
        //ˮƽ a<x<w-a && 0<y<a  �ϱ�  
        else if((p.x>=a&&p.x<=jcomWidth-a) &&p.y>=0&&p.y<=a)  
            return CurType.Top;  
        //ˮƽ a<x<w-a &&h-a<y<h  �±�  
        else if((p.x>=a&&p.x<=jcomWidth-a) &&p.y>=jcomHeight-a&&p.y<=jcomHeight)  
            return CurType.Bottom;  
        //�м�  
        else  
            //jcom.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));//û���������һֱ������״  
            return CurType.Center;  
          
    }  
    private void setCurType(MouseEvent e)  
    {  
        switch(getCurType(e))  
        {  
        case LeftTop:  
            jcom.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));  
            curCuror=CurType.LeftTop;  
            break;  
        case LeftBottom:  
            jcom.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));  
            curCuror=CurType.LeftBottom;  
            break;  
        case RightTop:  
            jcom.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));  
            curCuror=CurType.RightTop;  
            break;  
        case RightBottom:  
            jcom.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));  
            curCuror=CurType.RightBottom;  
            break;  
        case Top:  
            jcom.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));  
            curCuror=CurType.Top;  
            break;  
        case Bottom:  
            jcom.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));  
            curCuror=CurType.Bottom;  
            break;  
        case Left:  
            jcom.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));  
            curCuror=CurType.Left;  
            break;  
        case Right:  
            jcom.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));  
            curCuror=CurType.Right;  
            break;  
        default:  
            jcom.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));  
            curCuror=CurType.Center;  
            break;              
        }  
    }  
    private void setPosition(MouseEvent e)  
    {  
        Point pointNow=e.getLocationOnScreen();  
        int incX=pointNow.x-pointMoved.x;//��������������һ���ƶ��ĵ㡣  
        int incY=pointNow.y-pointMoved.y;  
        ///  
        //System.out.print("PointNow:("+pointNow.x+","+pointNow.y+")\t");  
        //System.out.println("PointMoved:("+pointMoved.x+","+pointMoved.y+")\t");  
        Rectangle rect=new Rectangle();  
        switch(curCuror)  
        {  
        case LeftTop:  
            rect.x=jcomOriginPoint.x+incX;  
            rect.y=jcomOriginPoint.y+incY;  
            rect.width=jcomWidth-incX;  
            rect.height=jcomHeight-incY;  
            break;  
        case LeftBottom:  
            rect.x=jcomOriginPoint.x+incX;  
            rect.y=jcomOriginPoint.y;  
            rect.width=jcomWidth-incX;  
            rect.height=jcomHeight+incY;  
            break;  
        case RightTop:  
            rect.x=jcomOriginPoint.x;  
            rect.y=jcomOriginPoint.y+incY;  
            rect.width=jcomWidth+incX;  
            rect.height=jcomHeight-incY;  
            break;  
        case RightBottom:  
            rect.x=jcomOriginPoint.x;  
            rect.y=jcomOriginPoint.y;  
            rect.width=jcomWidth+incX;  
            rect.height=jcomHeight+incY;  
            break;  
            ////////////////////////////////////////////  
        case Top:  
            rect.x=jcomOriginPoint.x;  
            rect.y=jcomOriginPoint.y+incY;  
            rect.width=jcomWidth;  
            rect.height=jcomHeight-incY;  
            break;  
        case Bottom:  
            rect.x=jcomOriginPoint.x;  
            rect.y=jcomOriginPoint.y;  
            rect.width=jcomWidth;  
            rect.height=jcomHeight+incY;  
            break;  
        case Left:  
            rect.x=jcomOriginPoint.x+incX;  
            rect.y=jcomOriginPoint.y;  
            rect.width=jcomWidth-incX;  
            rect.height=jcomHeight;  
            break;  
        case Right://������  
            rect.x=jcomOriginPoint.x;  
            rect.y=jcomOriginPoint.y;  
            rect.width=jcomWidth+incX;  
            rect.height=jcom.getHeight();  
            break;  
            ///////////////////////////////////////////////  
        case Center://�ƶ�  
            rect.x=jcomOriginPoint.x+incX;  
            rect.y=jcomOriginPoint.y+incY;  
            rect.width=jcom.getWidth();//��ֹ���ָֻ�ԭ��С���⡣  
            rect.height=jcom.getHeight();  
            break;      
        default:  
            break;              
        }  
        jcom.setBounds(rect);  
    }  
    @Override  
    public void mouseMoved(MouseEvent e)   
    {  
        pointMoved=e.getLocationOnScreen();  
        jcom=(JComponent)e.getSource();//��ֹ�����ؼ�����һ��  
        jcomOriginPoint=jcom.getLocation();//��ȡ����ڸ����ڵ�λ��  
        jcomWidth=jcom.getWidth();  
        jcomHeight=jcom.getHeight();  
//        System.out.print("Old--------------------");  
//        System.out.print("Position:("+jcomOriginPoint.x+","+jcomOriginPoint.y+")\t");  
//        System.out.println(" Width:"+jcomWidth+"  Height:"+jcomHeight);  
        ///////////////////////////////////////////  
        setCurType(e);  
        //super.mouseMoved(e);  
    }  
    public void mouseDragged(MouseEvent e)   
    {  
        //������ƶ����һ�������  
        setPosition(e);  
        super.mouseDragged(e);  
    } 
    
    public static void main(String[] args)   
    {  
        JFrame frm=new JFrame();  
        JPanel panel=new JPanel(null);  
        frm.setSize(600    , 600);  
        frm.setLocation(100, 100);  
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        panel.setSize(600, 600);  
        /////////////////////////////////////////  
        JButton btn=new JButton("Button");  
        btn.setSize(100, 100);  
        btn.setLocation(100, 100);  
        DnDAdapter dnd=new DnDAdapter();  
        btn.addMouseMotionListener(dnd);
        JButton btn2=new JButton("Button");  
        btn2.setSize(100, 100);  
        btn2.setLocation(300, 100);  
        btn2.addMouseMotionListener(dnd);
        //btn.addMouseListener(dnd);  
        //btn.removeMouseMotionListener(l);  
        panel.add(btn);
        panel.add(btn2);
        frm.add(panel);      
        frm.setVisible(true);  
          
    }  
}  
