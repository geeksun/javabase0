package com.geeksun.awt.event;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * @author ��־ǿ
 * @annotation: ���� Scrollbar��ScrollPane�Ĵ�С,�������ڵ�����ǩ�е�����Ĵ�С��
 * @create at 2009-4-6
 */
public class AdjustmentEvent1 extends Frame implements AdjustmentListener {
	Scrollbar sb;		//AdjustmentEvent ���¼�Դ Scrollbar
	Label label;		//�Թ���ֵ��С���Ϸ����仯�ı�ǩ
	
	public AdjustmentEvent1(String title){
		super(title);
		label = new Label("Thinking in Java", label.CENTER);		//��ǩ����
		
		//ˮƽ��������value=10,visibleAmount=1,minimum=1,maximum=300
		sb = new Scrollbar(Scrollbar.HORIZONTAL, 10, 1, 1, 300);
		
		add(label, "Center");
		add(sb, "South");
		
		sb.addAdjustmentListener(this);		//�� sb ע�� AdjustmentListener �¼���������
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e) {	//�����¼�
		//�����ʺ��ڱ�ǩ���������
		//�����С����������ֵ��sb.getValue())
		Font font = new Font("TimesRoman", 1, sb.getValue());
		
		//�ı��ǩ����
		label.setFont(font);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjustmentEvent1 ae = new AdjustmentEvent1("��������¼�");
		ae.setSize(300, 300);
		ae.setVisible(true);
	}

}
