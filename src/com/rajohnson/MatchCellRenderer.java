package com.rajohnson;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.rajohnson.Match;

@SuppressWarnings("serial")
public class MatchCellRenderer<E> extends JPanel implements ListCellRenderer<E> {

	private static HashMap<String, String> _champIcons;
	
	static {
        _champIcons = new HashMap<String,String>();
        _champIcons.put(  "none", "nope.png" ); // represents a catch-all champion for stats
        _champIcons.put(  "Annie", "res/Annie.png");
        _champIcons.put(  "Olaf", "res/Olaf.png" );
        _champIcons.put(  "Galio", "res/Galio.png");
        _champIcons.put(  "Twisted Fate", "res/TwistedFate.png");
        _champIcons.put(  "Xin Zhao", "res/XinZhao.png");
        _champIcons.put(  "Urgot", "res/Urgot.png");
        _champIcons.put(  "LeBlanc", "res/LeBlanc.png");
        _champIcons.put(  "Vladimir", "res/Vladimir.png");
        _champIcons.put(  "Fiddlesticks", "res/FiddleSticks.png");
        _champIcons.put( "Kayle", "res/Kayle.png");
        _champIcons.put( "Master Yi", "res/MasterYi.png");
        _champIcons.put( "Alistar", "res/Alistar.png");
        _champIcons.put( "Ryze", "res/Ryze.png");
        _champIcons.put( "Sion", "res/Sion.png");
        _champIcons.put( "Sivir", "res/Sivir.png");
        _champIcons.put( "Soraka", "res/Soraka.png");
        _champIcons.put( "Teemo", "res/Teemo.png");
        _champIcons.put( "Tristana", "res/Tristana.png");
        _champIcons.put( "Warwick", "res/Warwick.png");
        _champIcons.put( "Nunu", "res/Nunu.png");
        _champIcons.put( "Miss Fortune", "res/MissFortune.png");
        _champIcons.put( "Ashe", "res/Ashe.png");
        _champIcons.put( "Tryndamere", "res/Tryndamere.png");
        _champIcons.put( "Jax", "res/Jax.png");
        _champIcons.put( "Morgana", "res/Morgana.png");
        _champIcons.put( "Zilean", "res/Zilean.png");
        _champIcons.put( "Singed", "res/Singed.png");
        _champIcons.put( "Evelynn", "res/Evelynn.png");
        _champIcons.put( "Twitch", "res/Twitch.png");
        _champIcons.put( "Karthus", "res/Karthus.png");
        _champIcons.put( "Cho'Gath", "res/Chogath.png");
        _champIcons.put( "Amumu", "res/Amumu.png");
        _champIcons.put( "Rammus", "res/Rammus.png");
        _champIcons.put( "Anivia", "res/Anivia.png");
        _champIcons.put( "Shaco", "res/Shaco.png");
        _champIcons.put( "Dr. Mundo", "res/DrMundo.png");
        _champIcons.put( "Sona", "res/Sona.png");
        _champIcons.put( "Kassadin", "res/Kassadin.png");
        _champIcons.put( "Irelia", "res/Irelia.png");
        _champIcons.put( "Janna", "res/Janna.png");
        _champIcons.put( "Gangplank", "res/Gangplank.png");
        _champIcons.put( "Corki", "res/Corki.png");
        _champIcons.put( "Karma", "res/Karma.png");
        _champIcons.put( "Taric", "res/Taric.png");
        _champIcons.put( "Veigar", "res/Veigar.png");
        _champIcons.put( "Trundle", "res/Trundle.png");
        _champIcons.put( "Swain", "res/Swain.png");
        _champIcons.put( "Caitlyn", "res/Caitlyn.png");
        _champIcons.put( "Blitzcrank", "res/Blitzcrank.png");
        _champIcons.put( "Malphite", "res/Malphite.png");
        _champIcons.put( "Katarina", "res/Katarina.png");
        _champIcons.put( "Nocturne", "res/Nocturne.png");
        _champIcons.put( "Maokai", "res/Maokai.png");
        _champIcons.put( "Renekton", "res/Renekton.png");
        _champIcons.put( "Jarvan IV", "res/JarvanIV.png");
        _champIcons.put( "Orianna", "res/Orianna.png");
        _champIcons.put( "Wukong", "res/MonkeyKing.png");
        _champIcons.put( "Brand", "res/Brand.png");
        _champIcons.put( "Lee Sin", "res/LeeSin.png");
        _champIcons.put( "Vayne", "res/Vayne.png");
        _champIcons.put( "Rumble", "res/Rumble.png");
        _champIcons.put( "Cassiopeia", "res/Cassiopeia.png");
        _champIcons.put( "Skarner", "res/Skarner.png");
        _champIcons.put( "Heimerdinger", "res/Heimerdinger.png");
        _champIcons.put( "Nasus", "res/Nasus.png");
        _champIcons.put( "Nidalee", "res/Nidalee.png");
        _champIcons.put( "Udyr", "res/Udyr.png");
        _champIcons.put( "Poppy", "res/Poppy.png");
        _champIcons.put( "Gragas", "res/Gragas.png");
        _champIcons.put( "Pantheon", "res/Pantheon.png");
        _champIcons.put( "Ezreal", "res/Ezreal.png");
        _champIcons.put( "Mordekaiser", "res/Mordekaiser.png");
        _champIcons.put( "Yorick", "res/Yorick.png");
        _champIcons.put( "Akali", "res/Akali.png");
        _champIcons.put( "Kennen", "res/Kennen.png");
        _champIcons.put( "Garen", "res/Garen.png");
        _champIcons.put( "Leona", "res/Leona.png");
        _champIcons.put( "Malzahar", "res/Malzahar.png");
        _champIcons.put( "Talon", "res/Talon.png");
        _champIcons.put( "Riven", "res/Riven.png");
        _champIcons.put( "Kog'Maw", "res/KogMaw.png");
        _champIcons.put( "Shen", "res/Shen.png");
        _champIcons.put( "Lux", "res/Lux.png");
        _champIcons.put("Xerath", "res/Xerath.png");
        _champIcons.put("Shyvana", "res/Shyvana.png");
        _champIcons.put("Ahri", "res/Ahri.png");
        _champIcons.put("Graves", "res/Graves.png");
        _champIcons.put("Fizz", "res/Fizz.png");
        _champIcons.put("Volibear", "res/Volibear.png");
        _champIcons.put("Varus", "res/Varus.png");
        _champIcons.put("Nautilus", "res/Nautilus.png");
        _champIcons.put("Viktor", "res/Viktor.png");
        _champIcons.put("Sejuani", "res/Sejuani.png");
        _champIcons.put("Fiora", "res/Fiora.png");
        _champIcons.put("Ziggs", "res/Ziggs.png");
        _champIcons.put("Lulu", "res/Lulu.png");
        _champIcons.put("Draven", "res/Draven.png");
        _champIcons.put("Hecarim", "res/Hecarim.png");
        _champIcons.put("Darius", "res/Darius.png");
        _champIcons.put("Jayce", "res/Jayce.png");
        _champIcons.put("Zyra", "res/Zyra.png");
        _champIcons.put("Diana", "res/Diana.png");
        _champIcons.put("Rengar", "res/Rengar.png");
        _champIcons.put("Syndra", "res/Syndra.png");
        _champIcons.put("Kha'Zix", "res/Khazix.png");
        _champIcons.put( "Elise", "res/Elise.png");
        _champIcons.put("Zed", "res/Zed.png");
        _champIcons.put("Nami", "res/Nami.png");
        _champIcons.put("Vi", "res/Vi.png");
        _champIcons.put("Thresh", "res/Thresh.png");
        _champIcons.put("Quinn", "res/Quinn.png");
        _champIcons.put("Zac", "res/Zac.png");
        _champIcons.put("Lissandra", "res/Lissandra.png");
        _champIcons.put("Aatrox", "res/Aatrox.png");
        _champIcons.put("Lucian", "res/Lucian.png");
        _champIcons.put("Jinx", "res/Jinx.png");
    }
	
	private JLabel champLabel;
	private JPanel infoPanel;
	private JLabel killsLabel, deathsLabel, assistsLabel, CSLabel;
	private JLabel killCount, deathCount, assistCount, CSCount;
	private JLabel matchmakingQueueLabel;
	private JPanel killPanel, deathPanel, assistPanel, CSPanel;
	
	public MatchCellRenderer() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		champLabel = new JLabel();
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.weightx = 0;
		constraint.weighty = 0;
		constraint.gridwidth = 1;
		constraint.anchor = GridBagConstraints.WEST;
		constraint.fill = GridBagConstraints.BOTH;
		add(champLabel, constraint);
		//Override paintComponent so the panel is a gradient
		infoPanel = new JPanel();
		
		//infoPanel.setBackground(new Color(22,54,103));
		infoPanel.setLayout(new GridBagLayout());
		infoPanel.setOpaque(false);
		GridBagConstraints c = new GridBagConstraints();
		
		Font serifFontBold = new Font(Font.SERIF, Font.BOLD, 14);
		Font serifFont = new Font(Font.SERIF, Font.PLAIN, 14);
		
		killPanel = new JPanel();
		killPanel.setOpaque(false);
		killPanel.setLayout(new GridLayout(1,2));
		killCount = new JLabel();
		killCount.setFont(serifFont);
		killsLabel = new JLabel("Kills: ");
		killsLabel.setForeground(new Color(78,112,143));
		killsLabel.setFont(serifFontBold);
		killPanel.add(killsLabel);
		killPanel.add(killCount);
		
		deathPanel = new JPanel();
		deathPanel.setOpaque(false);
		deathPanel.setLayout(new GridLayout(1,2));
		deathCount = new JLabel();
		deathCount.setFont(serifFont);
		deathsLabel = new JLabel("Deaths: ");
		deathsLabel.setForeground(new Color(78,112,143));
		deathsLabel.setFont(serifFontBold);
		deathPanel.add(deathsLabel);
		deathPanel.add(deathCount);
		
		assistPanel = new JPanel();
		assistPanel.setOpaque(false);
		assistPanel.setLayout(new GridLayout(1,2));
		assistCount = new JLabel();
		assistCount.setFont(serifFont);
		assistsLabel = new JLabel("Assists: ");
		assistsLabel.setForeground(new Color(78,112,143));
		assistsLabel.setFont(serifFontBold);
		assistsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		assistPanel.add(assistsLabel);
		assistPanel.add(assistCount);
		
		CSPanel = new JPanel();
		CSPanel.setOpaque(false);
		CSPanel.setLayout(new GridLayout(1,2));
		CSLabel = new JLabel("Minions Killed: ");
		CSLabel.setFont(serifFontBold);
		CSLabel.setForeground(new Color(78,112,143));
		CSCount = new JLabel();
		CSCount.setFont(serifFont);
		CSPanel.add(CSLabel);
		CSPanel.add(CSCount);
		
		matchmakingQueueLabel = new JLabel();
		matchmakingQueueLabel.setFont(serifFontBold);
		matchmakingQueueLabel.setPreferredSize(new Dimension(243,19));
		
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		infoPanel.add(matchmakingQueueLabel, c);
		
		c.gridy = 1;
		infoPanel.add(killPanel,c);
		
		c.gridy = 2;
		infoPanel.add(deathPanel,c);
		
		c.gridy = 3;
		infoPanel.add(assistPanel,c);
		
		c.gridx = 1;
		c.gridy = 1;
		infoPanel.add(CSPanel,c);
		
		constraint.gridx = 1;
		constraint.gridy = 0;
		constraint.weightx = 1;
		constraint.weighty = 1;
		constraint.gridwidth = 3;
		constraint.ipadx = 30;
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.fill = GridBagConstraints.VERTICAL;
		add(infoPanel, constraint);
		
		
		
	}

	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = new Color(241,234,212);
        Color color2 = new Color(222,204,155);
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(
            0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
	
	@Override
	public Component getListCellRendererComponent(JList<? extends E> arg0,
			E arg1, int arg2, boolean arg3, boolean arg4) {
		if(arg1 instanceof Match)
		{
				Match matchSelected = (Match)arg1;
				String champIconPath = _champIcons.get(matchSelected.getChampionPlayed());
		
				ImageIcon champIcon = new ImageIcon(champIconPath, matchSelected.getChampionPlayed());
				champLabel.setIcon(champIcon);
				Border iconOutline;
				if(matchSelected.getWin() == 1)
				{
					iconOutline = BorderFactory.createLineBorder(Color.GREEN);
					champLabel.setBorder(iconOutline);
				}
				else if(matchSelected.getWin() == 0)
				{
					iconOutline = BorderFactory.createLineBorder(Color.RED);
					champLabel.setBorder(iconOutline);
				}
				infoPanel.setOpaque(false);
		
				killCount.setText(Integer.toString(matchSelected.getNumKills()));
				deathCount.setText(Integer.toString(matchSelected.getNumDeaths()));
				assistCount.setText(Integer.toString(matchSelected.getNumAssists()));
				CSCount.setText(Integer.toString(matchSelected.getMinionsKilled()));
				matchmakingQueueLabel.setText(fromInternalToReadableMMQueueName(matchSelected.getMatchmakingQueue()));
				
		}
		
		
		
		return this;
	}
	
	/**
	 * Takes the string representation of a matchmaking queue enumeration and returns a human-friendly version. 
	 * @param internalQueueName
	 * @return
	 */
	private String fromInternalToReadableMMQueueName(String internalQueueName)
	{
		String externalQueueName = "";
		
		if(internalQueueName.equals("ARAM_UNRANKED_5x5"))
		{
			externalQueueName = "Howling Abyss";
		}
		else if(internalQueueName.equals("ODIN_UNRANKED"))
		{
			externalQueueName = "Dominion";
		}
		else if(internalQueueName.equals("BOT"))
		{
			externalQueueName = "Summoner's Rift (Bot)";
		}
		else if(internalQueueName.equals("NORMAL"))
		{
			externalQueueName = "Summoner's Rift (Normal)";
		}
		else if(internalQueueName.equals("RANKED_SOLO_5x5"))
		{
			externalQueueName = "Summoner's Rift (Ranked Solo Queue)";
		}
		else if(internalQueueName.equals("RANKED_TEAM_3x3"))
		{
			externalQueueName = "Twisted Treeline (Ranked Team Queue)";
		}
		else if(internalQueueName.equals("RANKED_TEAM_5x5"))
		{
			externalQueueName = "Summoner's Rift (Ranked Team Queue)";
		}
		else if(internalQueueName.equals("NORMAL_3x3"))
		{
			externalQueueName = "Twisted Treeline (Normal)";
		}
		else if(internalQueueName.equals("BOT_3x3"))
		{
			externalQueueName = "Twisted Treeline (Bot)";
		}
		else
		{
			externalQueueName = "Gametype Not Found";
		}
		return externalQueueName;
	}
	
	public static Map<String, String> getChampionIconMap()
	{
		return Collections.unmodifiableMap(_champIcons);
	}
	
	public static String getChampIconByName(String champName)
	{
		return _champIcons.get(champName);
	}

}