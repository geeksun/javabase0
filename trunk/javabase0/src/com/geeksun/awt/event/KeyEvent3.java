package com.geeksun.awt.event;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author ��־ǿ
 * @annotation: ��Ϸ�����ļ��̴����������������ң��ϣ��£���"man"��ť���ƶ������ǣ���ʧȥ�˽��㣬
 * 				KeyEvent�Ͳ��ᷢ����KeyEvent�¼�ֻ��ӵ�н��������Ϸ�����
 * @create at 2009-4-6
 */
public class KeyEvent3 extends Frame {

	Button man;
	public KeyEvent3(String title){
		super(title);
		setLayout(null);
		this.setSize(200, 200);
		
		man = new Button("man");	//����KeyEvent�¼��İ�ť
		man.setBounds(100, 100, 40, 20);	//�趨��ťλ�����С
		man.setBackground(Color.BLUE);		//�趨��ť�ı���ɫΪ��ɫ
		man.setForeground(Color.WHITE);		//����ť��ǰ��ɫ��Ϊ��ɫ
		
		this.add(man);						//������Ӱ�ť
		man.addKeyListener(new KeyHandler());	//ע������¼���������
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyEvent3 ke = new KeyEvent3("���� Key �¼�");
		ke.setVisible(true);
	}

	class KeyHandler extends KeyAdapter{	//��������¼�����
		public void keyPressed(KeyEvent e){	//���¼�ʱ������
			String direction = e.getKeyText(e.getKeyCode());	//���� keyText
			int x = man.getX();		//man��x����
			int y = man.getY();		//man��y����
			
			//���� keyText ��ֵ���任����
			if(direction.equals("Right")) 	x += 10;
			else if(direction.equals("Left"))	x -= 10;
			else if(direction.equals("Down"))	y += 10;
			else if(direction.equals("Up"))	y -= 10;
			
			man.setLocation(x, y);		//�趨��ť��λ��
		}
	}
}
