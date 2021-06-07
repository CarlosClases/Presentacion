package interface_;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InterfaceMultiRoomChat extends JFrame {

	private JPanel contentPane;
	//private JTextField messagePlace;
	//private JTextField textField;
	//private JTextField textField_1;
	private ArrayList<JPanel> roomsArrayList= new ArrayList <JPanel>();
	//private JTextField textField_2;
	private logic.ClientLogic client;
	ActionListener listen;
	public InterfaceMultiRoomChat(logic.ClientLogic client) {
		this.setClient(client);
	}
	public logic.ClientLogic getClient() {
		return this.client;
	}
	public void setClient(logic.ClientLogic client) {
		this.client=client;
	};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceMultiRoomChat frame = new InterfaceMultiRoomChat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void createNewChatTab(JTabbedPane placeToInsertTab, String nameOfTheTab) {
		JPanel newTab = new JPanel();
		newTab.setToolTipText("");
		placeToInsertTab.addTab(nameOfTheTab, null, newTab, null);
		
		JTextPane chatTextPlace = new JTextPane();
		chatTextPlace.setEditable(false);
		chatTextPlace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chatTextPlace.setText("Pito");
		
		JTextPane clientConnected = new JTextPane();
		clientConnected.setEditable(false);
		clientConnected.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientConnected.setText("BBBBBBBBBB");
		JTextField messagePlace = new JTextField();
		messagePlace.setColumns(10);
		messagePlace.setText("AAAAAAAAAAAAAA");
		
		JButton sendButton = new JButton("Send");
		GroupLayout gl_rooms = new GroupLayout(newTab);
		createLayout(gl_rooms, messagePlace, chatTextPlace, sendButton, clientConnected);
		newTab.setLayout(gl_rooms);
		roomsArrayList.add(newTab);
		int index = roomsArrayList.indexOf(newTab);
		JTextPane AAAAA = (JTextPane) newTab.getComponent(3);
		System.out.println(AAAAA.getText());
		////0= message place
		////1=Chat 
		////2=Send Button
		////3=Connected users
	}
	private void createLayout(GroupLayout gl_rooms , JTextField messagePlace, JTextPane chatTextPlace,
			JButton sendButton, JTextPane clientConnected) {
		gl_rooms.setHorizontalGroup(
				gl_rooms.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_rooms.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_rooms.createParallelGroup(Alignment.LEADING)
							.addComponent(messagePlace, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
							.addComponent(chatTextPlace, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_rooms.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(sendButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(clientConnected, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
						.addGap(1))
			);
			gl_rooms.setVerticalGroup(
				gl_rooms.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_rooms.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_rooms.createParallelGroup(Alignment.LEADING)
							.addComponent(clientConnected, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
							.addComponent(chatTextPlace, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
						.addGap(19)
						.addGroup(gl_rooms.createParallelGroup(Alignment.LEADING)
							.addComponent(messagePlace, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(sendButton))
						.addContainerGap())
			);
	}

	/**
	 * Create the frame.
	 */
	public InterfaceMultiRoomChat() {
		setTitle("Chateito Wapo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_3873949461500");

		
//////////////////////////////////////////////////Room selection Interface boi///////////////////////////////////
		JPanel rooms = new JPanel();
		tabbedPane.addTab("Room Select", null, rooms, null);
		
		JButton btn_Sport = new JButton("");
		btn_Sport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewChatTab(tabbedPane, "Deportes");
			}
		});
		btn_Sport.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_Sport.setIcon(new ImageIcon(InterfaceMultiRoomChat.class.getResource("/Iconos/Deportes.png")));
		btn_Sport.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btn_Anime = new JButton("");
		btn_Anime.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_Anime.setIcon(new ImageIcon(InterfaceMultiRoomChat.class.getResource("/Iconos/Animes.png")));
		btn_Anime.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btn_Juegos = new JButton("");
		btn_Juegos.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_Juegos.setIcon(new ImageIcon(InterfaceMultiRoomChat.class.getResource("/Iconos/Juegos.png")));
		btn_Juegos.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_Juegos.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btn_Series = new JButton("");
		btn_Series.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_Series.setIcon(new ImageIcon(InterfaceMultiRoomChat.class.getResource("/Iconos/Series.png")));
		btn_Series.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btn_Computing = new JButton("");
		btn_Computing.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_Computing.setIcon(new ImageIcon(InterfaceMultiRoomChat.class.getResource("/Iconos/Informatica.png")));
		btn_Computing.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btn_Wepon = new JButton("");
		btn_Wepon.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_Wepon.setIcon(new ImageIcon(InterfaceMultiRoomChat.class.getResource("/Iconos/revolver.png")));
		btn_Wepon.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lbl_Title = new JLabel("CHOSE A ROOM");
		lbl_Title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title.setForeground(new Color(102, 205, 170));
		lbl_Title.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		
		Canvas Line1 = new Canvas();
		Line1.setBackground(new Color(102, 205, 170));
		
		Canvas Line2 = new Canvas();
		Line2.setBackground(new Color(102, 205, 170));
		GroupLayout gl_rooms = new GroupLayout(rooms);
		gl_rooms.setHorizontalGroup(
			gl_rooms.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rooms.createSequentialGroup()
					.addGroup(gl_rooms.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_rooms.createSequentialGroup()
							.addGap(151)
							.addComponent(btn_Sport, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(btn_Anime, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(btn_Juegos, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(gl_rooms.createSequentialGroup()
							.addGap(151)
							.addComponent(btn_Series, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(btn_Computing, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(btn_Wepon, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(gl_rooms.createSequentialGroup()
							.addGap(241)
							.addComponent(Line1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_rooms.createSequentialGroup()
							.addGap(201)
							.addComponent(Line2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_rooms.createSequentialGroup()
							.addGap(248)
							.addComponent(lbl_Title, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
							.addGap(85)))
					.addGap(179))
		);
		gl_rooms.setVerticalGroup(
			gl_rooms.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rooms.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_rooms.createParallelGroup(Alignment.TRAILING)
						.addComponent(Line1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_Title, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addGap(16)
					.addComponent(Line2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addGroup(gl_rooms.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_Sport, GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE)
						.addComponent(btn_Anime, GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE)
						.addComponent(btn_Juegos, GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE))
					.addGap(30)
					.addGroup(gl_rooms.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_Series, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Computing, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Wepon, GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE))
					.addGap(90))
		);
		rooms.setLayout(gl_rooms);
		createNewChatTab(tabbedPane, "Pito++");
		createNewChatTab(tabbedPane, "Pitote12++");
		
		
	}
}