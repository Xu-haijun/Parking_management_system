package com.parking;

/*
 * carThread.java
 *
 * Created on 2008年9月2日, 下午9:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 * 
 * @author cheng
 */
public class carThread extends Thread {

	private WorkFram frm;
	
	/** Creates a new instance of carThread */
	public carThread(WorkFram frm) {
		this.frm = frm;
	}
	
	public void run() {
		new carJFrame(frm).setVisible(true);
	}
	
}
