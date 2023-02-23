package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;

public class View extends JFrame implements ActionListener {
	public static int count = 0;
	JPanel startScreen;
	JPanel Players;
	JButton play;
	JButton firstP1Leader;
	JButton firstP2Champion;
	JButton firstP3Champion;

	JButton secondP1Leader;
	JButton secondP2Champion;
	JButton secondP3Champion;

	ImageIcon backgroundImage;
	JLabel imageLabel;
	JPanel ChampPanel;
	JFrame ChampionSelect;
	JButton[] ChampionSelectB = new JButton[15];

	JButton chooseCharacter;
	JFrame AbilityPopUp;

	ImageIcon backgroundImage2;
	JLabel imageLabel2;

	TextField x;
	JFrame insertNames;

	JButton Play;

	JFrame boardWindow;

	String name1;
	JLabel labelN1;
	String name2;
	JLabel labelN2;

	Player p1;
	Player p2;
	Game game;
	Object[][] board;

	JPanel nameF;
	JPanel nameS;

	JPanel gameBoard;
	JButton l1;

	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;

	JButton moveUp;
	JButton moveDown;
	JButton moveLeft;
	JButton moveRight;

	JButton attackUp;
	JButton attackDown;
	JButton attackRight;
	JButton attackLeft;

	JButton Ability1;
	JButton Ability2;
	JButton Ability3;
	JButton EndTurn;

	JButton emptyButton;
	JButton emptyButton1;

	JButton T1;
	Champion c;

	Cover cover;
	String type;

	JButton FleaderAbility;
	JButton SleaderAbility;

	String s;
	String s1;
	String s2;
	String s3;
	String s4;
	String s5;

	String temporary1;
	String temporary2;
	String temporary3;

	String[] targetAmount = { "0", "1", "2", "3", "4" };
	String[] directions = { "up", "down", "left", "right" };
	 TextField infoText;
	 

	 
	public View() {

		play = new JButton();
		play.setBounds(250, 350, 290, 30);
		play.addActionListener(this);
		play.setText("Playyy");
		this.add(play);
		ImageIcon playbutton = new ImageIcon(getClass().getResource("playbutton.jpg"));
		play.setIcon(playbutton);

		backgroundImage = new ImageIcon(getClass().getResource("game 2.jpg"));
		imageLabel = new JLabel(backgroundImage);
		imageLabel.setSize(1730, 930);

		this.add(imageLabel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Marvel Game");
		this.setSize(1730, 930);
		this.setVisible(true);
	}

	public void newWindow() {

		insertNames = new JFrame();
		insertNames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insertNames.setSize(1730, 930);
		insertNames.setLayout(null);

		name1 = JOptionPane.showInputDialog("Enter 1st Player Name");
		labelN1 = new JLabel(name1 + ":");
		labelN1.setBounds(100, 100, 1000, 60); // bounds mot5lefa
		labelN1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		labelN1.setForeground(Color.white);
		
		p1 = new Player(name1);
		
		name2 = JOptionPane.showInputDialog("Enter 2nd Player Name");
		labelN2 = new JLabel(name2 + ":");
		labelN2.setBounds(100, 500, 1000, 60);
		labelN2.setFont(new Font("Times New Roman", Font.BOLD, 32));
		labelN2.setForeground(Color.white);
		p2 = new Player(name2);
		// msh 3arfin n7ot el players gowa first player w second Player

		firstP1Leader = new JButton("Choose your Leader");
		firstP1Leader.setBounds(240, 110, 300, 50);
		firstP1Leader.setBackground(Color.decode("#602ca3"));
		firstP1Leader.setForeground(Color.white);
		firstP1Leader.addActionListener(this);

		firstP2Champion = new JButton("Choose Second Champion");
		firstP2Champion.setBounds(700, 110, 300, 50);
		firstP2Champion.setBackground(Color.decode("#602ca3"));
		firstP2Champion.setForeground(Color.white);
		firstP2Champion.addActionListener(this);

		firstP3Champion = new JButton("Choose Third Champion");
		firstP3Champion.setBounds(1200, 110, 300, 50);
		firstP3Champion.setBackground(Color.decode("#602ca3"));
		firstP3Champion.setForeground(Color.white);
		firstP3Champion.addActionListener(this);

		secondP1Leader = new JButton("Choose your Leader");
		secondP1Leader.setBounds(240, 510, 300, 50);
		secondP1Leader.setBackground(Color.decode("#602ca3"));
		secondP1Leader.setForeground(Color.white);
		secondP1Leader.addActionListener(this);

		secondP2Champion = new JButton("Choose Second Champion");
		secondP2Champion.setBounds(700, 510, 300, 50);
		secondP2Champion.setBackground(Color.decode("#602ca3"));
		secondP2Champion.setForeground(Color.white);
		secondP2Champion.addActionListener(this);

		secondP3Champion = new JButton("Choose Third Champion");
		secondP3Champion.setBounds(1200, 510, 300, 50);
		secondP3Champion.setBackground(Color.decode("#602ca3"));
		secondP3Champion.setForeground(Color.white);
		secondP3Champion.addActionListener(this);

		insertNames.add(firstP1Leader);
		insertNames.add(firstP2Champion);
		insertNames.add(firstP3Champion);

		insertNames.add(secondP1Leader);
		insertNames.add(secondP2Champion);
		insertNames.add(secondP3Champion);

		Play = new JButton("Let The War Begin!");
		Play.setBounds(700, 710, 300, 50);
		Play.setBackground(Color.decode("#2b2b8f"));
		Play.setForeground(Color.white);
		play.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Play.addActionListener(this);
		Play.setEnabled(false);
		insertNames.add(Play);

		insertNames.add(labelN1);
		insertNames.add(labelN2);
		backgroundImage2 = new ImageIcon(getClass().getResource("galaxy.jpg"));
		imageLabel2 = new JLabel(backgroundImage2);
		imageLabel2.setSize(1730, 930);
		imageLabel2.setBounds(0, 0, 1730, 930);
		insertNames.add(imageLabel2);

		insertNames.setVisible(true);

	}

	public void ChampionSelect() throws IOException {

		ChampionSelect = new JFrame();
		ChampionSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChampionSelect.setResizable(false);
		ChampionSelect.setTitle("Select your champions");
		ChampionSelect.setSize(1730, 930);
		ChampionSelect.setLayout(new GridLayout(5, 3));

		ArrayList<Champion> champs = Game.getAvailableChampions();

		for (int i = 0; i < champs.size(); i++) {
			Champion c = champs.get(i);
			ChampionSelectB[i] = new JButton(c.getName());
			ChampionSelect.add(ChampionSelectB[i]);
			ChampionSelectB[i].addActionListener(this);
			//ChampionSelectB[i].getName();

			if (c instanceof Hero) {
				type = "a Hero";
			} else if (c instanceof AntiHero) {
				type = "an AntiHero";
			} else if (c instanceof Villain) {
				type = "a Villain";
			}

			String tmp = "<html> Name: " + c.getName() + "<br> Mana: " + c.getMana() + "<br> AttackDamage: "
					+ c.getAttackDamage() + "<br> Current HP: " + c.getCurrentHP() + "<br> Speed: " + c.getSpeed()
					+ "<br> AttackRange: " + c.getAttackRange() + "<br> ActionPoints: " + c.getCurrentActionPoints()
					+ "<br> <html> Abilities: " + "<br>" + c.getAbilities().get(0).getName() + "<br>"
					+ c.getAbilities().get(1).getName() + "<br>" + c.getAbilities().get(2).getName()
					+ "<br> <html> the Champion is " + type;

//			"<br> Effect Name: " + c.getAppliedEffects().get(0).getName()
//			+ "<br> <html> Effect Duration: " + c.getAppliedEffects().get(0).getDuration();

			ChampionSelectB[i].setToolTipText(tmp);
		}
		ImageIcon captainAmerica = new ImageIcon(getClass().getResource("CaptainAmerica.jpg"));
		ChampionSelectB[0].setIcon(captainAmerica);

		ImageIcon deadPool = new ImageIcon(getClass().getResource("deadPool.jpg"));
		ChampionSelectB[1].setIcon(deadPool);

		ImageIcon DrStrange = new ImageIcon(getClass().getResource("DrStrange.jpg"));
		ChampionSelectB[2].setIcon(DrStrange);

		ImageIcon Electro = new ImageIcon(getClass().getResource("Electro.jpg"));
		ChampionSelectB[3].setIcon(Electro);

		ImageIcon GhostRider = new ImageIcon(getClass().getResource("GhostRider.jpg"));
		ChampionSelectB[4].setIcon(GhostRider);

		ImageIcon Hela = new ImageIcon(getClass().getResource("Hela.jpg"));
		ChampionSelectB[5].setIcon(Hela);

		ImageIcon Hulk = new ImageIcon(getClass().getResource("Hulk.jpg"));
		ChampionSelectB[6].setIcon(Hulk);

		ImageIcon IceMan = new ImageIcon(getClass().getResource("iceMan.jpg"));
		ChampionSelectB[7].setIcon(IceMan);

		ImageIcon IronMan = new ImageIcon(getClass().getResource("ironMan.jpg"));
		ChampionSelectB[8].setIcon(IronMan);

		ImageIcon Loki = new ImageIcon(getClass().getResource("Loki.jpg"));
		ChampionSelectB[9].setIcon(Loki);

		ImageIcon Quicksilver = new ImageIcon(getClass().getResource("Quicksilver.jpg"));
		ChampionSelectB[10].setIcon(Quicksilver);

		ImageIcon spiderMan = new ImageIcon(getClass().getResource("spider man.jpg"));
		ChampionSelectB[11].setIcon(spiderMan);

		ImageIcon thor = new ImageIcon(getClass().getResource("thor.jpg"));
		ChampionSelectB[12].setIcon(thor);

		ImageIcon venom = new ImageIcon(getClass().getResource("venom.jpg"));
		ChampionSelectB[13].setIcon(venom);

		ImageIcon yellowJacket = new ImageIcon(getClass().getResource("yellow jacket.jpg"));
		ChampionSelectB[14].setIcon(yellowJacket);

		ChampionSelect.setVisible(true);
	}

	public void boardWindow() {
		boardWindow = new JFrame();
		boardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardWindow.setResizable(false);
		boardWindow.setTitle("Play");
		boardWindow.setSize(1730, 930);

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();

		panel1.setBackground(Color.decode("#44188c"));
		panel2.setBackground(Color.decode("#44188c"));
		panel3.setBackground(Color.decode("#44188c"));
		panel4.setBackground(Color.decode("#44188c"));
		panel5.setBackground(Color.decode("#1580a1"));

		// --------- FIRST PLAYER PANEL --------- //

		panel4.setLayout(new GridLayout(5, 1));
		JLabel firstPName = new JLabel(p1.getName() + ": ", SwingConstants.CENTER);
		firstPName.setBorder(BorderFactory.createLineBorder(Color.black));
		firstPName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel4.add(firstPName);
	
		JLabel Fchampion1 = new JLabel();
		String tmpF1 = "<html> Name: " + p1.getTeam().get(0).getName() + "(LEADER)" + "<br> Mana: "
				+ p1.getTeam().get(0).getMana() + "<br> AttackDamage: " + p1.getTeam().get(0).getAttackDamage()
				+ "<br> Current HP: " + p1.getTeam().get(0).getCurrentHP() + "<br> Speed: "
				+ p1.getTeam().get(0).getSpeed() + "<br> AttackRange: " + p1.getTeam().get(0).getAttackRange()
				+ "<br> ActionPoints: " + p1.getTeam().get(0).getCurrentActionPoints() + "<br> Ability 1: "
				+ p1.getTeam().get(0).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p1.getTeam().get(0).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p1.getTeam().get(0).getAbilities().get(2).getName();

		for (int i = 0; i < p1.getTeam().get(0).getAppliedEffects().size(); i++) {
			s = "<html> Effect's Name: " + p1.getTeam().get(0).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p1.getTeam().get(0).getAppliedEffects().get(i).getDuration();
		}
		if (p1.getTeam().get(0).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(0).getAbilities().get(0)).getHealAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(0).getAbilities().get(0)).getDamageAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(0).getAbilities().get(0)).getEffect());
		}
		
		if (p1.getTeam().get(0).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(0).getAbilities().get(1)).getHealAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(0).getAbilities().get(1)).getDamageAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(0).getAbilities().get(1)).getEffect());
		}
		
		if (p1.getTeam().get(0).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(0).getAbilities().get(2)).getHealAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(0).getAbilities().get(2)).getDamageAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(0).getAbilities().get(2)).getEffect());
		}
		
		String atmpF1 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(0).getAbilities().get(0).getName()
		 		+ "<br> AreaOfEffect: " + p1.getTeam().get(0).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(0).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(0).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(0).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(0).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(0).getAbilities().get(0).getCurrentCooldown();
		String atmpF2 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(0).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(0).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(0).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(0).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(0).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(0).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(0).getAbilities().get(1).getCurrentCooldown();
		String atmpF3 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(0).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(0).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(0).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(0).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(0).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(0).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(0).getAbilities().get(2).getCurrentCooldown();

		Fchampion1.setText(tmpF1);
		Fchampion1.setBorder(BorderFactory.createLineBorder(Color.black));
		Fchampion1.setToolTipText(atmpF1 + temporary1 + atmpF2 + temporary2 + atmpF3 + temporary3 + s);
		Fchampion1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		panel4.add(Fchampion1);

		String tmpF2 = "<html> Name: " + p1.getTeam().get(1).getName() + "<br> Mana: " + p1.getTeam().get(1).getMana()
				+ "<br> AttackDamage: " + p1.getTeam().get(1).getAttackDamage() + "<br> Current HP: "
				+ p1.getTeam().get(1).getCurrentHP() + "<br> Speed: " + p1.getTeam().get(1).getSpeed()
				+ "<br> AttackRange: " + p1.getTeam().get(1).getAttackRange() + "<br> ActionPoints: "
				+ p1.getTeam().get(1).getCurrentActionPoints() + "<br> Ability 1: "
				+ p1.getTeam().get(1).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p1.getTeam().get(1).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p1.getTeam().get(1).getAbilities().get(2).getName();
		for (int i = 0; i < p1.getTeam().get(1).getAppliedEffects().size(); i++) {
			s1 = "<html> Effect's Name: " + p1.getTeam().get(1).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p1.getTeam().get(1).getAppliedEffects().get(i).getDuration();
		}
		if (p1.getTeam().get(1).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(1).getAbilities().get(0)).getHealAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(1).getAbilities().get(0)).getDamageAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(1).getAbilities().get(0)).getEffect());
		}
		if (p1.getTeam().get(1).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(1).getAbilities().get(1)).getHealAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(1).getAbilities().get(1)).getDamageAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(1).getAbilities().get(1)).getEffect());
		}
		if (p1.getTeam().get(1).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(1).getAbilities().get(2)).getHealAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(1).getAbilities().get(2)).getDamageAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(1).getAbilities().get(2)).getEffect());
		}
		String atmpF4 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(1).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(1).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(1).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(1).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(1).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(1).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(1).getAbilities().get(0).getCurrentCooldown();
		String atmpF5 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(1).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(1).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(1).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(1).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(1).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(1).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(1).getAbilities().get(1).getCurrentCooldown();
		String atmpF6 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(1).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(1).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(1).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(1).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(1).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(1).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(1).getAbilities().get(2).getCurrentCooldown();

		FleaderAbility = new JButton("Use Leader Ability");
		FleaderAbility.setFont(new Font("Times New Roman", Font.BOLD, 16));
		FleaderAbility.setToolTipText("it has not been used yet");
		FleaderAbility.setBackground(Color.decode("#44188c"));
		FleaderAbility.setForeground(Color.red);
		FleaderAbility.addActionListener(this);
		panel4.add(FleaderAbility);

		JLabel Fchampion2 = new JLabel();
		Fchampion2.setText(tmpF2 + s1);
		Fchampion2.setToolTipText(atmpF4 + temporary1 + atmpF5 + temporary2 + atmpF6 + temporary3);
		Fchampion2.setBorder(BorderFactory.createLineBorder(Color.black));
		Fchampion2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		panel4.add(Fchampion2);
		JLabel Fchampion3 = new JLabel();

		String tmpF3 = "<html> Name: " + p1.getTeam().get(2).getName() + "<br> Mana: " + p1.getTeam().get(2).getMana()
				+ "<br> AttackDamage: " + p1.getTeam().get(2).getAttackDamage() + "<br> Current HP: "
				+ p1.getTeam().get(2).getCurrentHP() + "<br> Speed: " + p1.getTeam().get(2).getSpeed()
				+ "<br> AttackRange: " + p1.getTeam().get(2).getAttackRange() + "<br> ActionPoints: "
				+ p1.getTeam().get(2).getCurrentActionPoints() + "<br> Ability 1: "
				+ p1.getTeam().get(2).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p1.getTeam().get(2).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p1.getTeam().get(2).getAbilities().get(2).getName();
		for (int i = 0; i < p1.getTeam().get(2).getAppliedEffects().size(); i++) {
			s2 = "<html> Effect's Name: " + p1.getTeam().get(2).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p1.getTeam().get(2).getAppliedEffects().get(i).getDuration();
		}
		if (p1.getTeam().get(2).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(2).getAbilities().get(0)).getHealAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(2).getAbilities().get(0)).getDamageAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(2).getAbilities().get(0)).getEffect());
		}
		if (p1.getTeam().get(2).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(2).getAbilities().get(1)).getHealAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(2).getAbilities().get(1)).getDamageAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(2).getAbilities().get(1)).getEffect());
		}
		if (p1.getTeam().get(2).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(2).getAbilities().get(2)).getHealAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(2).getAbilities().get(2)).getDamageAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(2).getAbilities().get(2)).getEffect());
		}
		String atmpF7 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(2).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(2).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(2).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(2).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(2).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(2).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(2).getAbilities().get(0).getCurrentCooldown();
		String atmpF8 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(2).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(2).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(2).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(2).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(2).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(2).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(2).getAbilities().get(1).getCurrentCooldown();
		String atmpF9 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(2).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(2).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(2).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(2).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(2).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(2).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(2).getAbilities().get(2).getCurrentCooldown();

		Fchampion3.setText(tmpF3);
		Fchampion3.setToolTipText(atmpF7 + temporary1 + atmpF8 + temporary2 + atmpF9 + temporary3 + s2);
		Fchampion3.setBorder(BorderFactory.createLineBorder(Color.black));
		Fchampion3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		firstPName.setForeground(Color.white);
		Fchampion1.setForeground(Color.white);
		Fchampion2.setForeground(Color.white);
		Fchampion3.setForeground(Color.white);
		panel4.add(Fchampion3);

		panel1.setPreferredSize(new Dimension(100, 100));
		panel2.setPreferredSize(new Dimension(100, 100));
		panel3.setPreferredSize(new Dimension(200, 100));
		panel4.setPreferredSize(new Dimension(200, 100));
		panel5.setPreferredSize(new Dimension(100, 100));

		// --------- SECOND PLAYER PANEL --------- //

		panel3.setLayout(new GridLayout(5, 1));
		JLabel secondPName = new JLabel(p2.getName() + ": ", SwingConstants.CENTER);
		secondPName.setBorder(BorderFactory.createLineBorder(Color.black));
		secondPName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel3.add(secondPName);
		String tmp1 = "<html> Name: " + p2.getTeam().get(0).getName() + "(LEADER)" + "<br> Mana: "
				+ p2.getTeam().get(0).getMana() + "<br> AttackDamage: " + p2.getTeam().get(0).getAttackDamage()
				+ "<br> Current HP: " + p2.getTeam().get(0).getCurrentHP() + "<br> Speed: "
				+ p2.getTeam().get(0).getSpeed() + "<br> AttackRange: " + p2.getTeam().get(0).getAttackRange()
				+ "<br> ActionPoints: " + p2.getTeam().get(0).getCurrentActionPoints() + "<br> Ability 1: "
				+ p2.getTeam().get(0).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p2.getTeam().get(0).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p2.getTeam().get(0).getAbilities().get(2).getName(); // LESA MAKHELSETSH
		for (int i = 0; i < p2.getTeam().get(0).getAppliedEffects().size(); i++) {
			s3 = "<html> Effect's Name: " + p2.getTeam().get(0).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p2.getTeam().get(0).getAppliedEffects().get(i).getDuration();
		}
		if (p2.getTeam().get(0).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(0).getAbilities().get(0)).getHealAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(0).getAbilities().get(0)).getDamageAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(0).getAbilities().get(0)).getEffect());
		}
		if (p2.getTeam().get(0).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(0).getAbilities().get(1)).getHealAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(0).getAbilities().get(1)).getDamageAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(0).getAbilities().get(1)).getEffect());
		}
		if (p2.getTeam().get(0).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(0).getAbilities().get(2)).getHealAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(0).getAbilities().get(2)).getDamageAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(0).getAbilities().get(2)).getEffect());
		}
		String atmpS1 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(0).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(0).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(0).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(0).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(0).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(0).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(0).getAbilities().get(0).getCurrentCooldown();
		String atmpS2 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(0).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(0).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(0).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(0).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(0).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(0).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(0).getAbilities().get(1).getCurrentCooldown();
		String atmpS3 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(0).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(0).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(0).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(0).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(0).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(0).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(0).getAbilities().get(2).getCurrentCooldown();

		JLabel Schampion1 = new JLabel();
		Schampion1.setText(tmp1 );
		Schampion1.setToolTipText(atmpS1 + temporary1 + atmpS2 + temporary2 + atmpS3 + temporary3 + s3);
		Schampion1.setBorder(BorderFactory.createLineBorder(Color.black));
		Schampion1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		panel3.add(Schampion1);
		String tmp2 = "<html> Name: " + p2.getTeam().get(1).getName() + "<br> Mana: " + p2.getTeam().get(1).getMana()
				+ "<br> AttackDamage: " + p2.getTeam().get(1).getAttackDamage() + "<br> Current HP: "
				+ p2.getTeam().get(1).getCurrentHP() + "<br> Speed: " + p2.getTeam().get(1).getSpeed()
				+ "<br> AttackRange: " + p2.getTeam().get(1).getAttackRange() + "<br> ActionPoints: "
				+ p2.getTeam().get(1).getCurrentActionPoints() + "<br> Ability 1: "
				+ p2.getTeam().get(1).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p2.getTeam().get(1).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p2.getTeam().get(1).getAbilities().get(2).getName();
		for (int i = 0; i < p2.getTeam().get(1).getAppliedEffects().size(); i++) {
			s4 = "<html> Effect's Name: " + p2.getTeam().get(1).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p2.getTeam().get(1).getAppliedEffects().get(i).getDuration();
		}
		if (p2.getTeam().get(1).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(1).getAbilities().get(0)).getHealAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(1).getAbilities().get(0)).getDamageAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(1).getAbilities().get(0)).getEffect());
		}
		if (p2.getTeam().get(1).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(1).getAbilities().get(1)).getHealAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(1).getAbilities().get(1)).getDamageAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(1).getAbilities().get(1)).getEffect());
		}
		if (p2.getTeam().get(1).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(1).getAbilities().get(2)).getHealAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(1).getAbilities().get(2)).getDamageAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(1).getAbilities().get(2)).getEffect());
		}
		String atmpS4 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(1).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(1).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(1).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(1).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(1).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(1).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(1).getAbilities().get(0).getCurrentCooldown();
		String atmpS5 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(1).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(1).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(1).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(1).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(1).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(1).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(1).getAbilities().get(1).getCurrentCooldown();
		String atmpS6 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(1).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(1).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(1).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(1).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(1).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(1).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(1).getAbilities().get(2).getCurrentCooldown();

		SleaderAbility = new JButton("Use Leader Ability");
		SleaderAbility.setFont(new Font("Times New Roman", Font.BOLD, 16));
		SleaderAbility.setToolTipText("it has not been used yet");
		SleaderAbility.setBackground(Color.decode("#44188c"));
		SleaderAbility.setForeground(Color.red);
		SleaderAbility.addActionListener(this);
		panel3.add(SleaderAbility);

		JLabel Schampion2 = new JLabel();
		Schampion2.setText(tmp2);
		Schampion2.setToolTipText(atmpS4 + temporary1 + atmpS5 + temporary2 + atmpS6 + temporary3 + s4);
		Schampion2.setBorder(BorderFactory.createLineBorder(Color.black));
		Schampion2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		panel3.add(Schampion2);
		String tmp3 = "<html> Name: " + p2.getTeam().get(2).getName() + "<br> Mana: " + p2.getTeam().get(2).getMana()
				+ "<br> AttackDamage: " + p2.getTeam().get(2).getAttackDamage() + "<br> Current HP: "
				+ p2.getTeam().get(2).getCurrentHP() + "<br> Speed: " + p2.getTeam().get(2).getSpeed()
				+ "<br> AttackRange: " + p2.getTeam().get(2).getAttackRange() + "<br> ActionPoints: "
				+ p2.getTeam().get(2).getCurrentActionPoints() + "<br> Ability 1: "
				+ p2.getTeam().get(2).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p2.getTeam().get(2).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p2.getTeam().get(2).getAbilities().get(2).getName();
		for (int i = 0; i < p2.getTeam().get(2).getAppliedEffects().size(); i++) {
			s5 = "<html> Effect's Name: " + p2.getTeam().get(2).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p2.getTeam().get(2).getAppliedEffects().get(i).getDuration();
		}
		if (p2.getTeam().get(2).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(2).getAbilities().get(0)).getHealAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(2).getAbilities().get(0)).getDamageAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(2).getAbilities().get(0)).getEffect());
		}
		if (p2.getTeam().get(2).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(2).getAbilities().get(1)).getHealAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(2).getAbilities().get(1)).getDamageAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(2).getAbilities().get(1)).getEffect());
		}
		if (p2.getTeam().get(2).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(2).getAbilities().get(2)).getHealAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(2).getAbilities().get(2)).getDamageAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(2).getAbilities().get(2)).getEffect());
		}
		String atmpS7 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(2).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(2).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(2).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(2).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(2).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(2).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(2).getAbilities().get(0).getCurrentCooldown();
		String atmpS8 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(2).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(2).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(2).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(2).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(2).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(2).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(2).getAbilities().get(1).getCurrentCooldown();
		String atmpS9 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(2).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(2).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(2).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(2).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(2).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(2).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(2).getAbilities().get(2).getCurrentCooldown();
		JLabel Schampion3 = new JLabel();
		Schampion3.setText(tmp3 );
		Schampion3.setToolTipText(atmpS7 + temporary1 + atmpS8 + temporary2 + atmpS9 + temporary3 + s5);
		Schampion3.setBorder(BorderFactory.createLineBorder(Color.black));
		Schampion3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		secondPName.setForeground(Color.white);
		Schampion1.setForeground(Color.white);
		Schampion2.setForeground(Color.white);
		Schampion3.setForeground(Color.white);
		
		panel3.add(Schampion3);

		// --------- BOARD PANEL --------- //

		panel5.setLayout(new GridLayout(5, 5));
		board = game.getBoard();
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j < 5; j++) {
				JLabel cell;
				if (board[i][j] instanceof Champion) {
					cell = new JLabel(((Champion) board[i][j]).getName());
					cell.setForeground(Color.white);
					cell.setBackground(Color.decode("#1580a1"));
					panel5.add(cell);
				} else if (board[i][j] instanceof Cover) {
					cell = new JLabel("e7zar matab");
					cell.setForeground(Color.lightGray);
					panel5.add(cell);
					
					String tmp = "currentHP: " + ((Cover) board[i][j]).getCurrentHP();
					cell.setToolTipText(tmp);
				}
				else {
					cell = new JLabel();
					panel5.add(cell);
				}
				cell.setBorder(BorderFactory.createLineBorder(Color.black));

				panel5.add(cell);
			}
		}

		// --------- MOVE PANEL --------- //

		panel2.setLayout(new GridLayout(1, 10));
		
		moveUp = new JButton("Move Up");
		moveUp.setBackground(Color.decode("#18438c"));
		moveUp.setForeground(Color.white);
		moveUp.addActionListener(this);
		panel2.add(moveUp);
		
		moveDown = new JButton("Move Down");
		moveDown.setBackground(Color.decode("#18438c"));
		moveDown.setForeground(Color.white);
		moveDown.addActionListener(this);
		panel2.add(moveDown);
		
		moveLeft = new JButton("Move Left");
		moveLeft.setBackground(Color.decode("#18438c"));
		moveLeft.setForeground(Color.white);
		moveLeft.addActionListener(this);
		panel2.add(moveLeft);
		
		moveRight = new JButton("Move Right");
		moveRight.setBackground(Color.decode("#18438c"));
		moveRight.setForeground(Color.white);
		moveRight.addActionListener(this);
		panel2.add(moveRight);

		attackUp = new JButton("Attack Up");
		attackUp.setBackground(Color.decode("#18438c"));
		attackUp.setForeground(Color.white);
		attackUp.addActionListener(this);
		panel2.add(attackUp);
		
		attackDown = new JButton("Attack Down");
		attackDown.setBackground(Color.decode("#18438c"));
		attackDown.setForeground(Color.white);
		attackDown.addActionListener(this);
		panel2.add(attackDown);
		
		attackLeft = new JButton("Attack Left");
		attackLeft.setBackground(Color.decode("#18438c"));
		attackLeft.setForeground(Color.white);
		attackLeft.addActionListener(this);
		panel2.add(attackLeft);
		
		attackRight = new JButton("Attack Right");
		attackRight.setBackground(Color.decode("#18438c"));
		attackRight.setForeground(Color.white);
		attackRight.addActionListener(this);
		panel2.add(attackRight);

		// --------- ABILITY & PRIORITY QUEUE PANEL --------- //

		panel1.setLayout(new GridLayout(2, 6));

		Ability1 = new JButton("Ability 1: " + game.getCurrentChampion().getAbilities().get(0).getName());
		Ability1.setBackground(Color.decode("#18438c"));
		Ability1.setForeground(Color.white);
		Ability1.addActionListener(this);
		panel1.add(Ability1);
		Ability2 = new JButton("Ability 2: " + game.getCurrentChampion().getAbilities().get(1).getName());
		Ability2.setBackground(Color.decode("#18438c"));
		Ability2.setForeground(Color.white);		
		Ability2.addActionListener(this);
		panel1.add(Ability2);
		Ability3 = new JButton("Ability 3: " + game.getCurrentChampion().getAbilities().get(2).getName());
		Ability3.setBackground(Color.decode("#18438c"));
		Ability3.setForeground(Color.white);
		Ability3.addActionListener(this);
		panel1.add(Ability3);
		EndTurn = new JButton("End Turn");
		EndTurn.setBackground(Color.decode("#18438c"));
		EndTurn.setForeground(Color.red);
		EndTurn.addActionListener(this);
		panel1.add(EndTurn);

		Comparable[] e = game.getTurnOrder().getElements();
		for (int i = game.getTurnOrder().size() - 1; i >= 0; i--) {
			c = ((Champion) game.getTurnOrder().getElements()[i]);
			T1 = new JButton(c.getName());
			T1.setBackground(Color.decode("#18438c"));
			T1.setForeground(Color.white);
			panel1.add(T1);
		}

		boardWindow.add(panel1, BorderLayout.NORTH);
		boardWindow.add(panel2, BorderLayout.SOUTH);
		boardWindow.add(panel3, BorderLayout.EAST);
		boardWindow.add(panel4, BorderLayout.WEST);
		boardWindow.add(panel5, BorderLayout.CENTER);
		boardWindow.setVisible(true);
		revalidate();
		repaint();
	}

	public void removeChampion() {
		panel1.removeAll();

		panel1.setLayout(new GridLayout(2, 6));
		
		Ability1 = new JButton("Ability 1: " + game.getCurrentChampion().getAbilities().get(0).getName());
		Ability1.setBackground(Color.decode("#18438c"));
		Ability1.setForeground(Color.white);		
		Ability1.addActionListener(this);
		panel1.add(Ability1);

		Ability2 = new JButton("Ability 2: " + game.getCurrentChampion().getAbilities().get(1).getName());
		Ability2.setBackground(Color.decode("#18438c"));
		Ability2.setForeground(Color.white);		
		Ability2.addActionListener(this);
		panel1.add(Ability2);

		Ability3 = new JButton("Ability 3: " + game.getCurrentChampion().getAbilities().get(2).getName());
		Ability3.setBackground(Color.decode("#18438c"));
		Ability3.setForeground(Color.white);		
		Ability3.addActionListener(this);
		panel1.add(Ability3);

		EndTurn = new JButton("End Turn");
		EndTurn.setBackground(Color.decode("#18438c"));
		EndTurn.setForeground(Color.red);		
		EndTurn.addActionListener(this);
		panel1.add(EndTurn);

		Comparable[] e = game.getTurnOrder().getElements();
		
		for (int i = game.getTurnOrder().size() - 1; i >= 0; i--) {
			c = ((Champion) game.getTurnOrder().getElements()[i]);
			T1 = new JButton(c.getName());
			T1.setBackground(Color.decode("#18438c"));
			T1.setForeground(Color.white);
			panel1.add(T1);

		}
		
		
		boardWindow.revalidate();
		boardWindow.repaint();
		
	}
	
	public void rePopulate() {
		panel5.removeAll();
		board = game.getBoard();
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j < 5; j++) {
				JLabel cell;
				if (board[i][j] instanceof Champion) {
					cell = new JLabel(((Champion) board[i][j]).getName());
					cell.setForeground(Color.white);
					cell.setBackground(Color.decode("#1580a1"));

					panel5.add(cell);

				} else if (board[i][j] instanceof Cover) {
					cell = new JLabel("e7zar matab");
					cell.setForeground(Color.lightGray);
					panel5.add(cell);
					String tmp = "currentHP: " + ((Cover) board[i][j]).getCurrentHP();
					cell.setToolTipText(tmp);

				} else {
					cell = new JLabel();
					panel5.add(cell);

				}
				cell.setBorder(BorderFactory.createLineBorder(Color.black));
			}
		}
		boardWindow.revalidate();
		boardWindow.repaint();
	}

	public void panel4Refresh() {
		panel4.removeAll();
		JLabel firstPName = new JLabel(p1.getName() + ": ", SwingConstants.CENTER);
		firstPName.setBorder(BorderFactory.createLineBorder(Color.black));
		firstPName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel4.add(firstPName);
		JLabel Fchampion1 = new JLabel();
		String tmpF1 = "<html> Name: " + p1.getTeam().get(0).getName() + "(LEADER)" + "<br> Mana: "
				+ p1.getTeam().get(0).getMana() + "<br> AttackDamage: " + p1.getTeam().get(0).getAttackDamage()
				+ "<br> Current HP: " + p1.getTeam().get(0).getCurrentHP() + "<br> Speed: "
				+ p1.getTeam().get(0).getSpeed() + "<br> AttackRange: " + p1.getTeam().get(0).getAttackRange()
				+ "<br> ActionPoints: " + p1.getTeam().get(0).getCurrentActionPoints() + "<br> Ability 1: "
				+ p1.getTeam().get(0).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p1.getTeam().get(0).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p1.getTeam().get(0).getAbilities().get(2).getName();
		for (int i = 0; i < p1.getTeam().get(0).getAppliedEffects().size(); i++) {
			s = "<html> Effect's Name: " + p1.getTeam().get(0).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p1.getTeam().get(0).getAppliedEffects().get(i).getDuration();
		}
		if (p1.getTeam().get(0).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(0).getAbilities().get(0)).getHealAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(0).getAbilities().get(0)).getDamageAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(0).getAbilities().get(0)).getEffect());
		}
		if (p1.getTeam().get(0).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(0).getAbilities().get(1)).getHealAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(0).getAbilities().get(1)).getDamageAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(0).getAbilities().get(1)).getEffect());
		}
		if (p1.getTeam().get(0).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(0).getAbilities().get(2)).getHealAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(0).getAbilities().get(2)).getDamageAmount());
		} else if (p1.getTeam().get(0).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(0).getAbilities().get(2)).getEffect().getName());
		}
		String atmpF1 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(0).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(0).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(0).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(0).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(0).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(0).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(0).getAbilities().get(0).getCurrentCooldown();
		String atmpF2 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(0).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(0).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(0).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(0).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(0).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(0).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(0).getAbilities().get(1).getCurrentCooldown();
		String atmpF3 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(0).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(0).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(0).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(0).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(0).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(0).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(0).getAbilities().get(2).getCurrentCooldown();

		Fchampion1.setText(tmpF1 );
		Fchampion1.setToolTipText(atmpF1 + temporary1 + atmpF2 + temporary2 + atmpF3 + temporary3 + s);
		Fchampion1.setBorder(BorderFactory.createLineBorder(Color.black));
		Fchampion1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		panel4.add(Fchampion1);

		FleaderAbility = new JButton("Use Leader Ability");
		FleaderAbility.setFont(new Font("Times New Roman", Font.BOLD, 16));
		FleaderAbility.setToolTipText("it has not been used yet");
		FleaderAbility.setBackground(Color.decode("#44188c"));
		FleaderAbility.setForeground(Color.red);
		FleaderAbility.addActionListener(this);
		panel4.add(FleaderAbility);

		String tmpF2 = "<html> Name: " + p1.getTeam().get(1).getName() + "<br> Mana: " + p1.getTeam().get(1).getMana()
				+ "<br> AttackDamage: " + p1.getTeam().get(1).getAttackDamage() + "<br> Current HP: "
				+ p1.getTeam().get(1).getCurrentHP() + "<br> Speed: " + p1.getTeam().get(1).getSpeed()
				+ "<br> AttackRange: " + p1.getTeam().get(1).getAttackRange() + "<br> ActionPoints: "
				+ p1.getTeam().get(1).getCurrentActionPoints() + "<br> Ability 1: "
				+ p1.getTeam().get(1).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p1.getTeam().get(1).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p1.getTeam().get(1).getAbilities().get(2).getName();

		for (int i = 0; i < p1.getTeam().get(1).getAppliedEffects().size(); i++) {
			s1 = "<html> Effect's Name: " + p1.getTeam().get(1).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p1.getTeam().get(1).getAppliedEffects().get(i).getDuration();
		}
		if (p1.getTeam().get(1).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(1).getAbilities().get(0)).getHealAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(1).getAbilities().get(0)).getDamageAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(1).getAbilities().get(0)).getEffect().getName());
		}
		if (p1.getTeam().get(1).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(1).getAbilities().get(1)).getHealAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(1).getAbilities().get(1)).getDamageAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(1).getAbilities().get(1)).getEffect().getName());
		}
		if (p1.getTeam().get(1).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(1).getAbilities().get(2)).getHealAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(1).getAbilities().get(2)).getDamageAmount());
		} else if (p1.getTeam().get(1).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(1).getAbilities().get(2)).getEffect().getName());
		}
		String atmpF4 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(1).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(1).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(1).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(1).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(1).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(1).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(1).getAbilities().get(0).getCurrentCooldown();
		String atmpF5 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(1).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(1).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(1).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(1).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(1).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(1).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(1).getAbilities().get(1).getCurrentCooldown();
		String atmpF6 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(1).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(1).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(1).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(1).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(1).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(1).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(1).getAbilities().get(2).getCurrentCooldown();
		JLabel Fchampion2 = new JLabel();
		Fchampion2.setText(tmpF2 );
		Fchampion2.setToolTipText(atmpF4 + temporary1 + atmpF5 + temporary2 + atmpF6 + temporary3 + s1);
		Fchampion2.setBorder(BorderFactory.createLineBorder(Color.black));
		Fchampion2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		panel4.add(Fchampion2);
		JLabel Fchampion3 = new JLabel();
		String tmpF3 = "<html> Name: " + p1.getTeam().get(2).getName() + "<br> Mana: " + p1.getTeam().get(2).getMana()
				+ "<br> AttackDamage: " + p1.getTeam().get(2).getAttackDamage() + "<br> Current HP: "
				+ p1.getTeam().get(2).getCurrentHP() + "<br> Speed: " + p1.getTeam().get(2).getSpeed()
				+ "<br> AttackRange: " + p1.getTeam().get(2).getAttackRange() + "<br> ActionPoints: "
				+ p1.getTeam().get(2).getCurrentActionPoints() + "<br> Ability 1: "
				+ p1.getTeam().get(2).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p1.getTeam().get(2).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p1.getTeam().get(2).getAbilities().get(2).getName();

		for (int i = 0; i < p1.getTeam().get(2).getAppliedEffects().size(); i++) {
			s2 = "<html> Effect's Name: " + p1.getTeam().get(2).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p1.getTeam().get(2).getAppliedEffects().get(i).getDuration();
		}
		if (p1.getTeam().get(2).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(2).getAbilities().get(0)).getHealAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(2).getAbilities().get(0)).getDamageAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(2).getAbilities().get(0)).getEffect());
		}
		if (p1.getTeam().get(2).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(2).getAbilities().get(1)).getHealAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(2).getAbilities().get(1)).getDamageAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(2).getAbilities().get(1)).getEffect().getName());
		}
		if (p1.getTeam().get(2).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p1.getTeam().get(2).getAbilities().get(2)).getHealAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p1.getTeam().get(2).getAbilities().get(2)).getDamageAmount());
		} else if (p1.getTeam().get(2).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p1.getTeam().get(2).getAbilities().get(2)).getEffect().getName());
		}
		String atmpF7 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(2).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(2).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(2).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(2).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(2).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(2).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(2).getAbilities().get(0).getCurrentCooldown();
		String atmpF8 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(2).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(2).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(2).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(2).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(2).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(2).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(2).getAbilities().get(1).getCurrentCooldown();
		String atmpF9 = "<html> Ability's Info: " + "<br> Name: " + p1.getTeam().get(2).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p1.getTeam().get(2).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p1.getTeam().get(2).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p1.getTeam().get(2).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p1.getTeam().get(2).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p1.getTeam().get(2).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p1.getTeam().get(2).getAbilities().get(2).getCurrentCooldown();

		Fchampion3.setText(tmpF3 );
		Fchampion3.setToolTipText(atmpF7 + temporary1 + atmpF8 + temporary2 + atmpF9 + temporary3 + s2);
		Fchampion3.setBorder(BorderFactory.createLineBorder(Color.black));
		Fchampion3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		firstPName.setForeground(Color.white);
		Fchampion1.setForeground(Color.white);
		Fchampion2.setForeground(Color.white);
		Fchampion3.setForeground(Color.white);
		panel4.add(Fchampion3);

		checkWinner();
		boardWindow.revalidate();
		boardWindow.repaint();
	}

	public void panel3Refresh() {
		panel3.removeAll();
		JLabel secondPName = new JLabel(p2.getName() + ": ", SwingConstants.CENTER);
		secondPName.setBorder(BorderFactory.createLineBorder(Color.black));
		secondPName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel3.add(secondPName);
		String tmp1 = "<html> Name: " + p2.getTeam().get(0).getName() + "(LEADER)" + "<br> Mana: "
				+ p2.getTeam().get(0).getMana() + "<br> AttackDamage: " + p2.getTeam().get(0).getAttackDamage()
				+ "<br> Current HP: " + p2.getTeam().get(0).getCurrentHP() + "<br> Speed: "
				+ p2.getTeam().get(0).getSpeed() + "<br> AttackRange: " + p2.getTeam().get(0).getAttackRange()
				+ "<br> ActionPoints: " + p2.getTeam().get(0).getCurrentActionPoints() + "<br> Ability 1: "
				+ p2.getTeam().get(0).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p2.getTeam().get(0).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p2.getTeam().get(0).getAbilities().get(2).getName();
		for (int i = 0; i < p2.getTeam().get(0).getAppliedEffects().size(); i++) {
			s3 = "<html> Effect's Name: " + p2.getTeam().get(0).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p2.getTeam().get(0).getAppliedEffects().get(i).getDuration();
		}
		if (p2.getTeam().get(0).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(0).getAbilities().get(0)).getHealAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(0).getAbilities().get(0)).getDamageAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(0).getAbilities().get(0)).getEffect()).getName();
		}
		if (p2.getTeam().get(0).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(0).getAbilities().get(1)).getHealAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(0).getAbilities().get(1)).getDamageAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(0).getAbilities().get(1)).getEffect().getName());
		}
		if (p2.getTeam().get(0).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(0).getAbilities().get(2)).getHealAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(0).getAbilities().get(2)).getDamageAmount());
		} else if (p2.getTeam().get(0).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(0).getAbilities().get(2)).getEffect().getName());
		}
		String atmpS1 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(0).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(0).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(0).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(0).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(0).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(0).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(0).getAbilities().get(0).getCurrentCooldown();
		String atmpS2 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(0).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(0).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(0).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(0).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(0).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(0).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(0).getAbilities().get(1).getCurrentCooldown();
		String atmpS3 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(0).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(0).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(0).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(0).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(0).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(0).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(0).getAbilities().get(2).getCurrentCooldown();

		JLabel Schampion1 = new JLabel();
		Schampion1.setText(tmp1);
		Schampion1.setToolTipText(atmpS1 + temporary1 + atmpS2 + temporary2 + atmpS3 + temporary3 + s3);
		Schampion1.setBorder(BorderFactory.createLineBorder(Color.black));
		Schampion1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		panel3.add(Schampion1);

		SleaderAbility = new JButton("Use Leader Ability");
		SleaderAbility.setFont(new Font("Times New Roman", Font.BOLD, 16));
		SleaderAbility.setToolTipText("it has not been used yet");
		SleaderAbility.setBackground(Color.decode("#44188c"));
		SleaderAbility.setForeground(Color.red);
		SleaderAbility.addActionListener(this);
		panel3.add(SleaderAbility);

		String tmp2 = "<html> Name: " + p2.getTeam().get(1).getName() +
				"<br> Mana: " + p2.getTeam().get(1).getMana() + "<br> AttackDamage: "
				+ p2.getTeam().get(1).getAttackDamage() + "<br> Current HP: " + p2.getTeam().get(1).getCurrentHP()
				+ "<br> Speed: " + p2.getTeam().get(1).getSpeed() + "<br> AttackRange: "
				+ p2.getTeam().get(1).getAttackRange() + "<br> ActionPoints: "
				+ p2.getTeam().get(1).getCurrentActionPoints() + "<br> Ability 1: "
				+ p2.getTeam().get(1).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p2.getTeam().get(1).getAbilities().get(1).getName() + "<br> Ability 3: "
				+ p2.getTeam().get(1).getAbilities().get(2).getName();
		for (int i = 0; i < p2.getTeam().get(1).getAppliedEffects().size(); i++) {
			s4 = "<html> Effect's Name: " + p2.getTeam().get(1).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p2.getTeam().get(1).getAppliedEffects().get(i).getDuration();
		}
		if (p2.getTeam().get(1).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(1).getAbilities().get(0)).getHealAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(1).getAbilities().get(0)).getDamageAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(1).getAbilities().get(0)).getEffect());
		}
		if (p2.getTeam().get(1).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(1).getAbilities().get(1)).getHealAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(1).getAbilities().get(1)).getDamageAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(1).getAbilities().get(1)).getEffect());
		}
		if (p2.getTeam().get(1).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(1).getAbilities().get(2)).getHealAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(1).getAbilities().get(2)).getDamageAmount());
		} else if (p2.getTeam().get(1).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(1).getAbilities().get(2)).getEffect());
		}
		String atmpS4 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(1).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(1).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(1).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(1).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(1).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(1).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(1).getAbilities().get(0).getCurrentCooldown();
		String atmpS5 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(1).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(1).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(1).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(1).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(1).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(1).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(1).getAbilities().get(1).getCurrentCooldown();
		String atmpS6 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(1).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(1).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(1).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(1).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(1).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(1).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(1).getAbilities().get(2).getCurrentCooldown();
		JLabel Schampion2 = new JLabel();
		Schampion2.setText(tmp2 );
		Schampion2.setToolTipText(atmpS4 + temporary1 + atmpS5 + temporary2 + atmpS6 + temporary3 + s4);
		Schampion2.setBorder(BorderFactory.createLineBorder(Color.black));
		Schampion2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		panel3.add(Schampion2);

 		String tmp3 = "<html> Name: " + p2.getTeam().get(2).getName() +
				"<br> Mana: " + p2.getTeam().get(2).getMana() + "<br> AttackDamage: " + p2.getTeam().get(2).getAttackDamage() + "<br> Current HP: "
				+ p2.getTeam().get(2).getCurrentHP() + "<br> Speed: " + p2.getTeam().get(2).getSpeed()
				+ "<br> AttackRange: " + p2.getTeam().get(2).getAttackRange() + "<br> ActionPoints: "
				+ p2.getTeam().get(2).getCurrentActionPoints() + "<br> Ability 1: "
				+ p2.getTeam().get(2).getAbilities().get(0).getName() + "<br> Ability 2: "
				+ p2.getTeam().get(2).getAbilities().get(1).getName() + "<br> <html> Ability 3: "
				+ p2.getTeam().get(2).getAbilities().get(2).getName();
		for (int i = 0; i < p2.getTeam().get(2).getAppliedEffects().size(); i++) {
			s5 = "<html> Effect's Name: " + p2.getTeam().get(2).getAppliedEffects().get(i).getName()
					+ "<br> <html> Effect's Duration: " + p2.getTeam().get(2).getAppliedEffects().get(i).getDuration();
		}
		if (p2.getTeam().get(2).getAbilities().get(0) instanceof HealingAbility) {
			temporary1 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(2).getAbilities().get(0)).getHealAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(0) instanceof DamagingAbility) {
			temporary1 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(2).getAbilities().get(0)).getDamageAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(0) instanceof CrowdControlAbility) {
			temporary1 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(2).getAbilities().get(0)).getEffect());
		}
		if (p2.getTeam().get(2).getAbilities().get(1) instanceof HealingAbility) {
			temporary2 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(2).getAbilities().get(1)).getHealAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(1) instanceof DamagingAbility) {
			temporary2 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(2).getAbilities().get(1)).getDamageAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(1) instanceof CrowdControlAbility) {
			temporary2 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(2).getAbilities().get(1)).getEffect());
		}
		if (p2.getTeam().get(2).getAbilities().get(2) instanceof HealingAbility) {
			temporary3 = "<html> <br> HealAmount: "
					+ (((HealingAbility) p2.getTeam().get(2).getAbilities().get(2)).getHealAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(2) instanceof DamagingAbility) {
			temporary3 = "<html> <br> Damage Amount: "
					+ (((DamagingAbility) p2.getTeam().get(2).getAbilities().get(2)).getDamageAmount());
		} else if (p2.getTeam().get(2).getAbilities().get(2) instanceof CrowdControlAbility) {
			temporary3 = "<html> <br> Crowd Control: "
					+ (((CrowdControlAbility) p2.getTeam().get(2).getAbilities().get(2)).getEffect());
		}
		String atmpS7 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(2).getAbilities().get(0).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(2).getAbilities().get(0).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(2).getAbilities().get(0).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(2).getAbilities().get(0).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(2).getAbilities().get(0).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(2).getAbilities().get(0).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(2).getAbilities().get(0).getCurrentCooldown();
		String atmpS8 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(2).getAbilities().get(1).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(2).getAbilities().get(1).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(2).getAbilities().get(1).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(2).getAbilities().get(1).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(2).getAbilities().get(1).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(2).getAbilities().get(1).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(2).getAbilities().get(1).getCurrentCooldown();
		String atmpS9 = "<html> Ability's Info: " + "<br> Name: " + p2.getTeam().get(2).getAbilities().get(2).getName()
				+ "<br> AreaOfEffect: " + p2.getTeam().get(2).getAbilities().get(2).getCastArea() + "<br> CastRange: "
				+ p2.getTeam().get(2).getAbilities().get(2).getCastRange() + "<br> Mana Cost: "
				+ p2.getTeam().get(2).getAbilities().get(2).getManaCost() + "<br> Required action points: "
				+ p2.getTeam().get(2).getAbilities().get(2).getRequiredActionPoints() + "<br> Base CoolDown: "
				+ p2.getTeam().get(2).getAbilities().get(2).getBaseCooldown() + "<br> Current CooldDown: "
				+ p2.getTeam().get(2).getAbilities().get(2).getCurrentCooldown();
		JLabel Schampion3 = new JLabel();
		Schampion3.setText(tmp3 );
		Schampion3.setToolTipText(atmpS7 + temporary1 + atmpS8 + temporary2 + atmpS9 + temporary3 + s5);
		Schampion3.setBorder(BorderFactory.createLineBorder(Color.black));
		Schampion3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		secondPName.setForeground(Color.white);
		Schampion1.setForeground(Color.white);
		Schampion2.setForeground(Color.white);
		Schampion3.setForeground(Color.white);
		
		panel3.add(Schampion3);

		checkWinner();
		boardWindow.revalidate();
		boardWindow.repaint();
	}

	public void checkWinner() {
		if (game.checkGameOver() != null) {
			
			JOptionPane.showMessageDialog(null," "+ game.checkGameOver().getName() + "Has Won", "Winnerrr!!", JOptionPane.DEFAULT_OPTION);
			boardWindow.dispose();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
//		((JButton) e.getSource()).setEnabled(false);

		if (e.getSource() == play) {
			dispose();
			newWindow();
		}
		if (e.getSource() == firstP1Leader) {
			try {
				Game.loadAbilities("Abilities.csv");
				Game.loadChampions("Champions.csv");
				ChampionSelect();
				ChampionSelect.setVisible(true);
			} catch (IOException e1) {
			}
			firstP1Leader.setEnabled(false);

		}
		if (e.getSource() == firstP2Champion) {
			try {
				Game.loadAbilities("Abilities.csv");
				Game.loadChampions("Champions.csv");
				ChampionSelect.setVisible(true);
			} catch (IOException e1) {
			}
			firstP2Champion.setEnabled(false);
		}
		if (e.getSource() == firstP3Champion) {
			try {
				Game.loadAbilities("Abilities.csv");
				Game.loadChampions("Champions.csv");
				ChampionSelect.setVisible(true);
			} catch (IOException e1) {
			}
			firstP3Champion.setEnabled(false);
		}
		if (e.getSource() == secondP1Leader) {
			try {
				Game.loadAbilities("Abilities.csv");
				Game.loadChampions("Champions.csv");
				ChampionSelect.setVisible(true);
			} catch (IOException e1) {
			}
			secondP1Leader.setEnabled(false);
		}
		if (e.getSource() == secondP2Champion) {
			try {
				Game.loadAbilities("Abilities.csv");
				Game.loadChampions("Champions.csv");
				ChampionSelect.setVisible(true);
			} catch (IOException e1) {
			}
			secondP2Champion.setEnabled(false);
		}
		if (e.getSource() == secondP3Champion) {
			try {
				Game.loadAbilities("Abilities.csv");
				Game.loadChampions("Champions.csv");
				ChampionSelect.setVisible(true);
			} catch (IOException e1) {
			}
			secondP3Champion.setEnabled(false);
			Play.setEnabled(true);
		}

		for (int i = 0; i < 15; i++) {
			if (e.getSource() == ChampionSelectB[i]) {
				ChampionSelectB[i].setEnabled(false);
				ChampionSelect.setVisible(false);
				if (count < 3) {
					if (p1.getTeam().size() == 0) {
						p1.setLeader(Game.getAvailableChampions().get(i));
					}
					p1.getTeam().add(Game.getAvailableChampions().get(i));
				} else {
					if (p2.getTeam().size() == 0) {
						p2.setLeader(Game.getAvailableChampions().get(i));
					}
					p2.getTeam().add(Game.getAvailableChampions().get(i));
				}
				count++;
			}
		}

		if (e.getSource() == Play) {
			insertNames.dispose();
			game = new Game(p1, p2);
			boardWindow();

		}
		if (e.getSource() == EndTurn) {
			game.endTurn();
			
			checkWinner();
			panel3Refresh();
			panel4Refresh();
			removeChampion();
		}

		if (e.getSource() == moveUp) {
			try {
				game.move(Direction.UP);
				rePopulate();
				panel3Refresh();
				panel4Refresh();
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(null, "7aseb yasta, eskozmi", "Move Error", JOptionPane.ERROR_MESSAGE);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == moveDown) {
			try { 
				game.move(Direction.DOWN);
				rePopulate();
				panel3Refresh();
				panel4Refresh();

			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(null, "7aseb yasta, eskozmi", "Move Error", JOptionPane.ERROR_MESSAGE);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == moveLeft) {
			try {
				game.move(Direction.LEFT);
				rePopulate();
				panel3Refresh();
				panel4Refresh();
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(null, "7aseb yasta, eskozmi", "Move Error", JOptionPane.ERROR_MESSAGE);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == moveRight) {
			try {
				game.move(Direction.RIGHT);
				rePopulate();
				panel3Refresh();
				panel4Refresh();

			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(null, "7aseb yasta, eskozmi", "Move Error", JOptionPane.ERROR_MESSAGE);

			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		if (e.getSource() == attackUp) {
			try {
				game.attack(Direction.UP);
				rePopulate(); // =-==========f kolo
				panel3Refresh();
				panel4Refresh();
				checkWinner();
				removeChampion();
			} catch (ChampionDisarmedException e1) {
				JOptionPane.showMessageDialog(null, "sab sela7o", "Champion Disarmed Error", JOptionPane.ERROR_MESSAGE);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(null, "da sahbak yala", "Invalid Target Error",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		if (e.getSource() == attackDown) {
			try {
				game.attack(Direction.DOWN);
				rePopulate();
				panel3Refresh();
				panel4Refresh();
				checkWinner();
				removeChampion();

			} catch (ChampionDisarmedException e1) {
				JOptionPane.showMessageDialog(null, "sab sela7o", "Champion Disarmed Error", JOptionPane.ERROR_MESSAGE);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(null, "da sahbak yala", "Invalid Target Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == attackRight) {
			try {
				game.attack(Direction.RIGHT);
				rePopulate();
				panel3Refresh();
				panel4Refresh();
				checkWinner();
				removeChampion();

			} catch (ChampionDisarmedException e1) {
				JOptionPane.showMessageDialog(null, "sab sela7o", "Champion Disarmed Error", JOptionPane.ERROR_MESSAGE);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(null, "da sahbak yala", "Invalid Target Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == attackLeft) {
			try {
				game.attack(Direction.LEFT);
				rePopulate();
				panel3Refresh();
				panel4Refresh();
				checkWinner();
				removeChampion();

			} catch (ChampionDisarmedException e1) {
				JOptionPane.showMessageDialog(null, "sab sela7o", "Champion Disarmed Error", JOptionPane.ERROR_MESSAGE);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(null, "da sahbak yala", "Invalid Target Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource() == FleaderAbility) {
			try {
				game.useLeaderAbility();
				FleaderAbility.setToolTipText("USEDDD");
				FleaderAbility.setEnabled(false);
				checkWinner();
				removeChampion();

			} catch (LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(null, "You can only use your leader ability once", "ALready Used Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (LeaderNotCurrentException e1) {
				JOptionPane.showMessageDialog(null, "The current champion is not your leader", "Not Leader Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == SleaderAbility) {

			try {
				game.useLeaderAbility();
				SleaderAbility.setToolTipText("USEDDD");
				SleaderAbility.setEnabled(false);
				checkWinner();
				removeChampion();

			} catch (LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(null, "You can only use your leader ability once", "ALready Used Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (LeaderNotCurrentException e1) {
				JOptionPane.showMessageDialog(null, "The current champion is not your leader", "Not Leader Error",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		if (e.getSource() == Ability1) {
			
			Ability firstA = game.getCurrentChampion().getAbilities().get(0);
		
			if (firstA.getCastArea() == AreaOfEffect.SELFTARGET || firstA.getCastArea() == AreaOfEffect.TEAMTARGET
					|| firstA.getCastArea() == AreaOfEffect.SURROUND) {
				try {
					game.castAbility(firstA);
					rePopulate();
					panel3Refresh();
					panel4Refresh();
					removeChampion();
					checkWinner();
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (CloneNotSupportedException e1) {

				}

			} else if (firstA.getCastArea() == AreaOfEffect.SINGLETARGET) {
				int x = JOptionPane.showOptionDialog(null, "Choose x-loc (how far)", "Cast Ability1",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, targetAmount, 1);
				
				int y = JOptionPane.showOptionDialog(null, "Choose y-loc (how far)", "Cast Ability1",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, targetAmount, 1);

				try {
					game.castAbility(firstA, x, y);
					rePopulate();
					panel3Refresh();
					panel4Refresh();
					removeChampion();
					checkWinner();
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(null, "da sahbak yala", "Invalid Target Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (CloneNotSupportedException e1) {

				}
			} else if (firstA.getCastArea() == AreaOfEffect.DIRECTIONAL) {
				int d = JOptionPane.showOptionDialog(null, "cast ability direction", "Cast Ability1",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, directions, 1);
				if (d == 0) {
					try {
						game.castAbility(firstA, Direction.UP);
						rePopulate();
						panel3Refresh();
						panel4Refresh();
						removeChampion();
						checkWinner();
					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {

					}
				} else if (d == 1) {
					try {
						game.castAbility(firstA, Direction.DOWN);
						rePopulate();
						panel3Refresh();
						panel4Refresh();
						removeChampion();
						checkWinner();
					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {

					}
				} else if (d == 2) {
					try {
						game.castAbility(firstA, Direction.LEFT);
						rePopulate();
						panel3Refresh();
						panel4Refresh();
						removeChampion();
						checkWinner();
					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {

					}

				} else if (d == 3) {
					try {
						game.castAbility(firstA, Direction.RIGHT);
						rePopulate();
						panel3Refresh();
						panel4Refresh();
						removeChampion();
						checkWinner();
					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {

					}
				}
			}
		}
			if (e.getSource() == Ability2) {
				System.out.println(123456789);
				Ability secondA = game.getCurrentChampion().getAbilities().get(1);
				if (secondA.getCastArea() == AreaOfEffect.SELFTARGET || secondA.getCastArea() == AreaOfEffect.TEAMTARGET
						|| secondA.getCastArea() == AreaOfEffect.SURROUND) {
					try {
						game.castAbility(secondA);
						rePopulate();
						panel3Refresh();
						panel4Refresh();
						removeChampion();
						checkWinner();

					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {

					}

				} else if (secondA.getCastArea() == AreaOfEffect.SINGLETARGET) {
					int x = JOptionPane.showOptionDialog(null, "Choose x-loc (how far)", "Cast Ability1",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, targetAmount, 1);
					
					int y = JOptionPane.showOptionDialog(null, "Choose y-loc (how far)", "Cast Ability1",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, targetAmount, 1);

					try {
						game.castAbility(secondA, x, y);
						rePopulate();
						panel3Refresh();
						panel4Refresh();
						removeChampion();
						checkWinner();
					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null, "da sahbak yala", "Invalid Target Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {

					}
				} else if (secondA.getCastArea() == AreaOfEffect.DIRECTIONAL) {
					int d = JOptionPane.showOptionDialog(null, "cast ability direction", "Cast Ability1",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, directions, 1);
					if (d == 0) {
						try {
							game.castAbility(secondA, Direction.UP);
							rePopulate();
							panel3Refresh();
							panel4Refresh();
							removeChampion();
							checkWinner();
						} catch (AbilityUseException e1) {
							JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NotEnoughResourcesException e1) {
							JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (CloneNotSupportedException e1) {

						}
					} else if (d == 1) {
						try {
							game.castAbility(secondA, Direction.DOWN);
							rePopulate();
							panel3Refresh();
							panel4Refresh();
							removeChampion();
							checkWinner();
						} catch (AbilityUseException e1) {
							JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NotEnoughResourcesException e1) {
							JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (CloneNotSupportedException e1) {

						}
					} else if (d == 2) {
						try {
							game.castAbility(secondA, Direction.LEFT);
							rePopulate();
							panel3Refresh();
							panel4Refresh();
							removeChampion();
							checkWinner();
						} catch (AbilityUseException e1) {
							JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NotEnoughResourcesException e1) {
							JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (CloneNotSupportedException e1) {

						}

					} else if (d == 3) {
						try {
							game.castAbility(secondA, Direction.RIGHT);
							rePopulate();
							panel3Refresh();
							panel4Refresh();
							removeChampion();
							checkWinner();
						} catch (AbilityUseException e1) {
							JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NotEnoughResourcesException e1) {
							JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (CloneNotSupportedException e1) {

						}
					}
				}
			}
			if (e.getSource() == Ability3) {
				Ability thirdA = game.getCurrentChampion().getAbilities().get(2);
				if (thirdA.getCastArea() == AreaOfEffect.SELFTARGET || thirdA.getCastArea() == AreaOfEffect.TEAMTARGET
						|| thirdA.getCastArea() == AreaOfEffect.SURROUND) {
					try {
						game.castAbility(thirdA);
						rePopulate();
						panel3Refresh();
						panel4Refresh();
						removeChampion();
						checkWinner();
					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {

					}

				} else if (thirdA.getCastArea() == AreaOfEffect.SINGLETARGET) {
					int x = JOptionPane.showOptionDialog(null, "Choose x-loc (how far)", "Cast Ability1",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, targetAmount, 1);
					int y = JOptionPane.showOptionDialog(null, "Choose y-loc (how far)", "Cast Ability1",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, targetAmount, 1);

					try {
						game.castAbility(thirdA, x, y);
						rePopulate();
						panel3Refresh();
						panel4Refresh();
						removeChampion();
						checkWinner();
					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null, "da sahbak yala", "Invalid Target Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {

					}
				} else if (thirdA.getCastArea() == AreaOfEffect.DIRECTIONAL) {
					int d = JOptionPane.showOptionDialog(null, "cast ability direction", "Cast Ability1",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, directions, 1);
					if (d == 0) {
						try {
							game.castAbility(thirdA, Direction.UP);
							rePopulate();
							panel3Refresh();
							panel4Refresh();
							removeChampion();
							checkWinner();
						} catch (AbilityUseException e1) {
							JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NotEnoughResourcesException e1) {
							JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (CloneNotSupportedException e1) {

						}
					} else if (d == 1) {
						try {
							game.castAbility(thirdA, Direction.DOWN);
							rePopulate();
							panel3Refresh();
							panel4Refresh();
							removeChampion();
							checkWinner();
						} catch (AbilityUseException e1) {
							JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NotEnoughResourcesException e1) {
							JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (CloneNotSupportedException e1) {

						}
					} else if (d == 2) {
						try {
							game.castAbility(thirdA, Direction.LEFT);
							rePopulate();
							panel3Refresh();
							panel4Refresh();
							removeChampion();
							checkWinner();
						} catch (AbilityUseException e1) {
							JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NotEnoughResourcesException e1) {
							JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (CloneNotSupportedException e1) {

						}

					} else if (d == 3) {
						try {
							game.castAbility(thirdA, Direction.RIGHT);
							rePopulate();
							panel3Refresh();
							panel4Refresh();
							removeChampion();
							checkWinner();
						} catch (AbilityUseException e1) {
							JOptionPane.showMessageDialog(null, "kfaia est5dam l7d keda", "Ability Use Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NotEnoughResourcesException e1) {
							JOptionPane.showMessageDialog(null, "You are mentally drained", "Resource Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (CloneNotSupportedException e1) {

						}
					}
				}

			}

	}
}
