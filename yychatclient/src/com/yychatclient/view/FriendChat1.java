package com.yychatclient.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.*;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;

//import Jieping.ScreenCapture;

import com.yychat.model.Message;
import com.yychatclient.controller.ClientConnect;


public class FriendChat1 extends JFrame implements ActionListener{//���̳�

	//Center����
	JScrollPane jsp;
	JTextArea jta;
	
	//South����
	JPanel jp;
	JTextField jtf;
	JButton jb1;
	JButton jb2;
	
	String sender;
	String receiver;
	
	public FriendChat1(String sender,String receiver){
		this.sender=sender;
		this.receiver=receiver;
		
		jta = new JTextArea();//�ı�����
		jta.setEditable(false);
		jta.setForeground(Color.red);
		jsp = new JScrollPane(jta);
		this.add(jsp,"Center");
		
		jp=new JPanel();
		jtf=new JTextField(15);
		jtf.setForeground(Color.red);
		jb1=new JButton("����");
		//jb2=new JButton("����");
		jb1.addActionListener(this);
		//jb2.addActionListener(this);
		jp.add(jtf);
		jp.add(jb1);
		//jp.add(jb2);
		this.add(jp,"South");
		
		this.setSize(350,240);
		this.setTitle(sender+"���ں�"+receiver+"����");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);//������ʾ����
		this.setVisible(true);		
	}
	
	public static void main(String[] args) {
		FriendChat1 friendChat=new FriendChat1("1","2");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {//�¼���������
		if(arg0.getSource()==jb1){
			jta.append(jtf.getText()+"\r\n");
			
			//�����������������Ϣ
			Message mess=new Message();
			mess.setSender(sender);
			mess.setReceiver(receiver);
			mess.setContent(jtf.getText());
			mess.setMessageType(Message.message_Common);
			ObjectOutputStream oos;
			try {
				Socket s=(Socket)ClientConnect.hmSocket.get(sender);
				oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(mess);
				
				//�ܲ�����������������˷�������������Ϣ��
			/*	ObjectInputStream ois = new ObjectInputStream(ClientConnect.s.getInputStream());
				mess=(Message)ois.readObject();//����������Ϣ
				String showMessage=mess.getSender()+"��"+mess.getReceiver()+"˵��"+mess.getContent();
				System.out.println(showMessage);
				jta.append(showMessage+"\r\n");*/
				
			} catch (IOException  e) {				
				e.printStackTrace();
			}			
		}
	}
		/*public void actionPerformed1(ActionEvent e) {
		if(e.getSource()==jb2){
			ScreenCapture capture=new ScreenCapture();	
		}*/
	
	public void appendJta(String showMessage){
		jta.append(showMessage+"\r\n");		
	}
}