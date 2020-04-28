package com.parking;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class carJFrame extends JFrame {
	
   
	private static final long serialVersionUID = 1L;


    // 变量声明 - 不进行修改//GEN-BEGIN:variables
	
    private JButton jbtnEnterStop;
    
    private JButton jbtnLeftArea;
    
    private JButton jbtnLeftStop;
    
    private JButton jbtnLookUpArea;
    
    private JButton jbtnLookupPosition;
   	
    private WorkFram mainFram;
    
    private int chooseArea;
    
    // 变量声明结束//GEN-END:variables
    
    /** Creates new form carJFrame */
    
    public carJFrame(WorkFram frm) {
        initComponents();
        mainFram = frm;
    }
    
    
    private void initComponents() {
    	
        jbtnEnterStop = new JButton();
        jbtnLookUpArea = new JButton();
        jbtnLookupPosition = new JButton();
        jbtnLeftArea = new JButton();
        jbtnLeftStop = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        setTitle("\u505c\u8f66\u573a\u64cd\u4f5c");
        
        jbtnEnterStop.setText("\u8fdb\u5165\u505c\u8f66\u573a");
        
        jbtnEnterStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnEnterStopActionPerformed(evt);
            }
        });

        jbtnLookUpArea.setText("\u5bfb\u627e\u505c\u8f66\u533a");
        
        jbtnLookUpArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLookUpAreaActionPerformed(evt);
            }
        });

        jbtnLookupPosition.setText("\u5bfb\u627e\u505c\u8f66\u4f4d");
        
        jbtnLookupPosition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLookupPositionActionPerformed(evt);
            }
        });

        jbtnLeftArea.setText("\u79bb\u5f00\u505c\u8f66\u533a");
        
        jbtnLeftArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLeftAreaActionPerformed(evt);
            }
        });

        jbtnLeftStop.setText("\u79bb\u5f00\u505c\u8f66\u573a");
        
        jbtnLeftStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLeftStopActionPerformed(evt);
            }
        });
        
        jbtnEnterStop.setEnabled(true);
        jbtnLookUpArea.setEnabled(false);
        jbtnLookupPosition.setEnabled(false);
        jbtnLeftArea.setEnabled(false);
        jbtnLeftStop.setEnabled(false);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnLeftStop)
                    .addComponent(jbtnLeftArea)
                    .addComponent(jbtnLookupPosition)
                    .addComponent(jbtnLookUpArea)
                    .addComponent(jbtnEnterStop))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jbtnEnterStop)
                .addGap(20, 20, 20)
                .addComponent(jbtnLookUpArea)
                .addGap(22, 22, 22)
                .addComponent(jbtnLookupPosition)
                .addGap(24, 24, 24)
                .addComponent(jbtnLeftArea)
                .addGap(19, 19, 19)
                .addComponent(jbtnLeftStop)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        
        pack();
        
    }

    private void jbtnLeftStopActionPerformed(ActionEvent evt) {
    	
    	JOptionPane.showMessageDialog(null, "停车卡收回，再见!");
   	
    	this.setVisible(false);
		this.removeNotify();
		
    }

    private void jbtnLeftAreaActionPerformed(ActionEvent evt) {

    	int confirm = JOptionPane.showConfirmDialog(null, "确定要离开 " + chooseArea + " 号停车区?", "离开停车区", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {								
			mainFram.m_apare[chooseArea - 1]++;
//			mainFram.setInfor(mainFram.getStopStatus());
			jbtnLeftArea.setEnabled(false);
			jbtnLookUpArea.setEnabled(true);
			jbtnLeftStop.setEnabled(true);
		} else if (confirm == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "您已放弃了离开该车区!");
			jbtnLookUpArea.setEnabled(true);
		} 
    	   	
    }

    private void jbtnLookupPositionActionPerformed(ActionEvent evt) {

    	int confirm = JOptionPane.showConfirmDialog(null, "您已经选择了" + chooseArea + " 号停车区, " + "确定要进入该停车区?", "进行停车区寻找车位", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {								
			mainFram.m_apare[chooseArea - 1]--;
			jbtnLookUpArea.setEnabled(false);
			jbtnLookupPosition.setEnabled(false);
			jbtnLeftArea.setEnabled(true);
			jbtnLeftStop.setEnabled(false);
		} else if (confirm == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "您已放弃了进入该车区!");
			jbtnLookUpArea.setEnabled(true);
			jbtnLookupPosition.setEnabled(false);
		} 
    	
    }

    private void jbtnLookUpAreaActionPerformed(ActionEvent evt) {

    	
    	ImageIcon icon = new ImageIcon("test.gif");
		int[] freeArea = getFreeArea();
		Object[] freeAreas = new Object[freeArea.length];
		for (int i = 0; i < freeArea.length; i++) {
			freeAreas[i] = freeArea[i];
		}
		
		Integer choose = (Integer)JOptionPane.showInputDialog(null, "当前停车场状况: \n" + mainFram.getStopStatus() + "\n请选择一个空闲车区：", "当前可先空闲车区: ", JOptionPane.PLAIN_MESSAGE, icon, freeAreas, (Integer)freeAreas[0]);
		
		if (choose != null) {			
			JOptionPane.showMessageDialog(null, "您选择了进入" + choose.intValue() + "车区");
			chooseArea = choose.intValue();
			jbtnLookUpArea.setEnabled(false);
			jbtnLookupPosition.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "您没有选择车区!");
		}   	
    	
    }

    private void jbtnEnterStopActionPerformed(ActionEvent evt) {

    	
    	boolean isFull = true;
    	for (int i = 0; i < mainFram.m_areaCount; i++) {
    		if (mainFram.m_apare[i] > 0) {
    			isFull = false;
    		} 		
    	}
    	
    	if (isFull) {
    		JOptionPane.showMessageDialog(null, "当前车场无空闲车区，请稍后再试!");
    	} else {
    		jbtnEnterStop.setEnabled(false);
            jbtnLookUpArea.setEnabled(true);
            jbtnLookupPosition.setEnabled(false);
            jbtnLeftArea.setEnabled(false);
            jbtnLeftStop.setEnabled(false);
            JOptionPane.showMessageDialog(null, "成功领取停车卡，请进去车场寻找停车区位!");
    	}
   	
    }
    
    private void formWindowClosing(WindowEvent evt) {
    	
    	int confirm = JOptionPane.showConfirmDialog(null, "确定退出?", "退出停车区", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			if (chooseArea > 0) {
				mainFram.m_apare[chooseArea - 1]--;				
			}
			this.setVisible(false);
			this.removeNotify();
		} else {
			this.setVisible(true);
		}
    }
    
    public int[] getFreeArea() {
    	int count = 0;
    	for (int i = 0; i < mainFram.m_areaCount; i++) {
    		if (mainFram.m_apare[i] > 0) {
    			count++;
    		} 		
    	}
    	
    	int[] freeArea = new int[count];
    	
    	for (int i = 0, j = 0; i < mainFram.m_areaCount; i++) {
    		if (mainFram.m_apare[i] > 0) {
    			freeArea[j++] = i + 1;
    		} 		
    	}
    	   	
    	return freeArea;
    }
       
}
