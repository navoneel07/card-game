import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import cardgame.models.*;
/**
 * The view class which includes all the GUI functionality of the game. 
 * @author neel
 * @version 1.0
 */

public class View{

	JFrame frame;
	
	JMenuBar mb = new JMenuBar();
	
	JMenu control = new JMenu("Control");
	JMenu help = new JMenu("Help");
	
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem instruction = new JMenuItem("Instructions");
	
	JLabel labelImage1 = new JLabel(new ImageIcon("Images/card_back.gif"));
	JLabel labelImage2 = new JLabel(new ImageIcon("Images/card_back.gif"));
	JLabel labelImage3 = new JLabel(new ImageIcon("Images/card_back.gif"));
	JLabel labelImage4 = new JLabel(new ImageIcon("Images/card_back.gif"));
	JLabel labelImage5 = new JLabel(new ImageIcon("Images/card_back.gif"));
	JLabel labelImage6 = new JLabel(new ImageIcon("Images/card_back.gif"));
	
	JButton rpButton1 = new JButton("Replace Card 1");
	JButton rpButton2 = new JButton("Replace Card 2");
	JButton rpButton3 = new JButton("Replace Card 3");
	JButton startButton = new JButton("Start");
	JButton resButton = new JButton("Result");
	
	JLabel labelBet = new JLabel("Bet:$");
	JLabel labelCurrMoney = new JLabel();
	JLabel labelCurrBet = new JLabel("Please place your bet!");
	
	JTextField betField = new JTextField(10);
	
	JPanel mainPanel = new JPanel();
	JPanel dealerPanel = new JPanel();
	JPanel playerPanel = new JPanel();
	JPanel replacePanel = new JPanel();
	JPanel betPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	
	Deck deck = new Deck();
	Human human = new Human(deck);
	Dealer dealer = new Dealer(deck);
	
	int TimesReplaced;
	
	/**
	 * Function to initialize all the GUI components the first time the game is launched.
	 * Initializes new instances of a deck, a human player and a computer player.
	 * Also initializes a variable that keeps track of number of times a card is replaced.
	 */
	public void init() {
		control.add(exit);
		help.add(instruction);
		
		mb.add(control);
		mb.add(help);
		
		dealerPanel.add(labelImage1);
		dealerPanel.add(labelImage2);
		dealerPanel.add(labelImage3);
		
		playerPanel.add(labelImage4);
		playerPanel.add(labelImage5);
		playerPanel.add(labelImage6);
		
		replacePanel.add(rpButton1);
		replacePanel.add(rpButton2);
		replacePanel.add(rpButton3);
		
		betPanel.add(labelBet);
		betPanel.add(betField);
		betPanel.add(startButton);
		betPanel.add(resButton);

		infoPanel.add(labelCurrBet);
		infoPanel.add(labelCurrMoney);
		
		rpButton1.setEnabled(false);
		rpButton2.setEnabled(false);
		rpButton3.setEnabled(false);
		resButton.setEnabled(false);
		
		mainPanel.setLayout(new GridLayout(5,1));
		mainPanel.add(dealerPanel);
		mainPanel.add(playerPanel);
		mainPanel.add(replacePanel);
		mainPanel.add(betPanel);
		mainPanel.add(infoPanel);
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		instruction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = "Rules to determine who has better cards:\n" + 
						"J, Q, K are regarded as special cards.\n" + 
						"Rule 1: The one with more special cards wins.\n" + 
						"Rule 2: If both have the same number of special cards, add the face values of the other\n" + 
						"card(s) and take the remainder after dividing the sum by 10. The one with a bigger\n" + 
						"remainder wins. (Note: Ace = 1).\n" + 
						"Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.";
				JFrame DialogFrame = new JFrame("Message");
				JOptionPane.showMessageDialog(DialogFrame, msg);
			}
		});
		
		startButton.addActionListener(new StartListener());
		resButton.addActionListener(new ResListener());
		rpButton1.addActionListener(new ReplaceOneListener());
		rpButton2.addActionListener(new ReplaceTwoListener());
		rpButton3.addActionListener(new ReplaceThreeListener());
		
		dealerPanel.setBackground(new Color(52,152,219));
		playerPanel.setBackground(new Color(52,152,219));
		replacePanel.setBackground(new Color(52,152,219));
				
		labelCurrMoney.setText("Amount of money you have: $"+human.getBank());
		
		frame = new JFrame();
		frame.setJMenuBar(mb);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.setTitle("A Card Game");
		frame.setSize(600,700);
		frame.setVisible(true);
		
		TimesReplaced=0;
	}
	
	/**
	 * Function to reset the GUI every time a new round is successfully launched.
	 * Resets the Deck, Human and Dealer.
	 * Also resets the Times Replaced variable.
	 */
	public void repaint() {
		labelImage1.setIcon(new ImageIcon("Images/card_back.gif"));
		labelImage2.setIcon(new ImageIcon("Images/card_back.gif"));
		labelImage3.setIcon(new ImageIcon("Images/card_back.gif"));
		labelImage4.setIcon(new ImageIcon("Images/card_back.gif"));
		labelImage5.setIcon(new ImageIcon("Images/card_back.gif"));
		labelImage6.setIcon(new ImageIcon("Images/card_back.gif"));
		
		labelCurrBet.setText("Please place your bet!");
		
		startButton.setEnabled(true);
		
		rpButton1.setEnabled(false);
		rpButton2.setEnabled(false);
		rpButton3.setEnabled(false);
		resButton.setEnabled(false);
		
		TimesReplaced = 0;
		
		this.deck = new Deck();
		this.human = new Human(deck);
		this.dealer = new Dealer(deck);
		
	}
	
	class ReplaceOneListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			labelImage4.setIcon(new ImageIcon("Images/card_"+human.replaceCard(0,deck)+".gif"));
			rpButton1.setEnabled(false);
			TimesReplaced+=1;
			
			if(TimesReplaced>=2) {
				rpButton2.setEnabled(false);
				rpButton3.setEnabled(false);
			}
		}
		
	}
	
	class ReplaceTwoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			labelImage5.setIcon(new ImageIcon("Images/card_"+human.replaceCard(1,deck)+".gif"));
			rpButton2.setEnabled(false);
			TimesReplaced+=1;
			if(TimesReplaced>=2) {
				rpButton1.setEnabled(false);
				rpButton3.setEnabled(false);
			}
		}
		
	}
	
	class ReplaceThreeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			labelImage6.setIcon(new ImageIcon("Images/card_"+human.replaceCard(2,deck)+".gif"));
			rpButton3.setEnabled(false);
			TimesReplaced+=1;
			if(TimesReplaced>=2) {
				rpButton1.setEnabled(false);
				rpButton2.setEnabled(false);
			}
		}
		
	}
	
	class StartListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				try {
					String bet = betField.getText();
					Integer intBet = Integer.parseInt(bet);
					if(intBet<=0) {
						throw new IllegalArgumentException();
					}
					if(intBet>human.getBank()) {
						throw new Exception();
					}
				} catch(NumberFormatException n){
					JFrame DialogFrame = new JFrame("Message");
					JOptionPane.showMessageDialog(DialogFrame, "WARNING: The bet you place must be a positive integer!");
					return;
				} catch(IllegalArgumentException i) {
					JFrame DialogFrame = new JFrame("Message");
					JOptionPane.showMessageDialog(DialogFrame, "WARNING: The bet you place must be a positive integer!");
					return;
				} catch(Exception b) {
					JFrame DialogFrame = new JFrame("Message");
					JOptionPane.showMessageDialog(DialogFrame, "WARNING: The bet you place cannot be more than how much you have!");
					return;
				}
				
			labelCurrBet.setText("Your current bet is: $"+betField.getText());
			human.setBet(Integer.parseInt(betField.getText()));
			labelImage4.setIcon(new ImageIcon("Images/card_"+human.getHand().getHandArr().get(0).toString()+".gif"));
			labelImage5.setIcon(new ImageIcon("Images/card_"+human.getHand().getHandArr().get(1).toString()+".gif"));
			labelImage6.setIcon(new ImageIcon("Images/card_"+human.getHand().getHandArr().get(2).toString()+".gif"));
			
			rpButton1.setEnabled(true);
			rpButton2.setEnabled(true);
			rpButton3.setEnabled(true);
			resButton.setEnabled(true);
			
			startButton.setEnabled(false);
		}
		
	}
	
	class ResListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			labelImage1.setIcon(new ImageIcon("Images/card_"+dealer.getHand().getHandArr().get(0).toString()+".gif"));
			labelImage2.setIcon(new ImageIcon("Images/card_"+dealer.getHand().getHandArr().get(1).toString()+".gif"));
			labelImage3.setIcon(new ImageIcon("Images/card_"+dealer.getHand().getHandArr().get(2).toString()+".gif"));
			
			if(human.getHand().HandComp(dealer.getHand())) {
				human.updateBankOnWin();
				JFrame DialogFrame = new JFrame("Message");
				JOptionPane.showMessageDialog(DialogFrame, "Congratulations! You win this round!");
				labelCurrMoney.setText("Amount of money you have: $"+human.getBank());
				repaint();
			}
			else if(!human.getHand().HandComp(dealer.getHand())) {
				human.updateBankOnLoss();
				JFrame DialogFrame = new JFrame("Message");
				JOptionPane.showMessageDialog(DialogFrame, "Sorry! The dealer wins this round!");
				labelCurrMoney.setText("Amount of money you have: $"+human.getBank());				
				
				if(human.getBank()<=0) {
					JFrame ExitDialogFrame = new JFrame("Message");
					labelCurrBet.setText("Game over! You have no more money!");
					labelCurrMoney.setText("");
					JOptionPane.showMessageDialog(ExitDialogFrame, "Game over!\nYou have no more money!\nPlease start a new game.");
					resButton.setEnabled(false);
					rpButton1.setEnabled(false);
					rpButton2.setEnabled(false);
					rpButton3.setEnabled(false);
					return;
				}
				
				repaint();
			}
		}
		
	}
			
}


