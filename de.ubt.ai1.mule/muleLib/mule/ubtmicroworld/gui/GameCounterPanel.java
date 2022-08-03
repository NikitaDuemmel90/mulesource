package mule.ubtmicroworld.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;

import mule.ubtmicroworld.UBTMicroworld.Agent;
import mule.ubtmicroworld.UBTMicroworld.MoveDirection;
import mule.ubtmicroworld.data.IGameState;
import mule.ubtmicroworld.gui.Texture.TEXTURE_ID;

/**
 * This class represents the GameCounterPanel.
 * @author Marco Jantos
 * 
 */
public class GameCounterPanel extends JPanel implements PanelEventListener, GuiEventEmmitter, ActionListener, ItemListener, ChangeListener{

	private static final long serialVersionUID = 1L;

	private IGameState gameState;
	
	private int lastTileRequestX = 0;
	private int lastTileRequestY = 0;
	private boolean tileRequestActive = false;

	private String winCondition = " WinCond.: ";
	
	private Color colorLabels = new Color(229, 229, 229);
	
	private JLabel labelWinCond;
	private JLabel labelWinCondition;
	private JLabel labelState;
	private JLabel labelTerrainType;
	
	private JButton buttonStatistics;
	
	private JTextArea textAreaDescription;
	private JScrollPane scrollPaneDescription;
	
	private JTable tablePlayers;
	private JScrollPane scrollPanePlayers;
	private String[] columnNames;
	private Object[][] data;
	private DefaultTableModel model;
	
	private JTable tableReplay;
	private JScrollPane scrollPaneReplay;
	private String[] columnNamesReplay;
	private Object[][] dataReplay;
	private DefaultTableModel modelReplay;
	
	private JComboBox boxAgents;
	private JSlider slider;
	private JButton buttonStepForward;
	private JButton buttonStepBack;
	
	private JLabel labelImage;
	
	private GameMode gameMode = GameMode.GAME_IN_ACTION;
	
	private Vector<Agent> agents;
	
	private Agent agentForReplay;
	private int agentForReplaySteps = 0;
	
	
	
	final int tileSize = 64;
	
	protected List<GuiEventListener> listeners = new Vector<GuiEventListener>();

	boolean test = false;
	
	public GameCounterPanel(IGameState gameState) {

		this.gameState = gameState;
		
		Dimension dimension = new Dimension(305, 750);
		
		this.setPreferredSize(dimension);
		this.setSize(dimension);
		this.setMinimumSize(dimension);
		this.setMaximumSize(dimension);
		
		
		Font font = new Font("SanfSerif", Font.BOLD, 13);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		this.setLayout(gridBagLayout);
		
		GridBagConstraints ccc = new GridBagConstraints();
		ccc.fill = GridBagConstraints.BOTH;
		
		ccc.gridwidth = GridBagConstraints.REMAINDER;
		ccc.weightx = 3;
		
		labelWinCond = new JLabel(winCondition);
		labelWinCond.setBackground(colorLabels);
		labelWinCond.setFont(font);
		labelWinCond.setOpaque(true);
		
		String labelAdd = gameState.getWinConditionName();
		labelWinCondition = new JLabel(labelAdd);
		labelWinCondition.setBackground(colorLabels);
		labelWinCondition.setFont(font);
		labelWinCondition.setOpaque(true);


		ccc.gridx = 0;
		ccc.gridy = 0;
		ccc.ipady = 10;
		ccc.insets = new Insets(2, 2, 2, 2);
		ccc.anchor = GridBagConstraints.PAGE_START;
		ccc.gridwidth = 3;
		this.add(labelWinCondition, ccc);
		
		String stateRequest = "Game Running.";
		if(gameState.isGameFinished()) {
			stateRequest = "Game Completed.";
		}
		else if(gameState.isGameOver()) {
			stateRequest = "Game Over.";
		}
		
		labelState = new JLabel("State: " + stateRequest);
		labelState.setBackground(colorLabels);
		labelState.setFont(font);
		labelState.setOpaque(true);
		ccc.gridx = 0;
		ccc.gridy = 1;
		ccc.gridwidth = 3;
		this.add(labelState, ccc);
		
		String tileRequest = "";
		if(tileRequestActive) {
			String tileName = gameState.getMatchfield().getTile(lastTileRequestX, lastTileRequestY).getTerrainType().toString();
			
			tileRequest += (" " + tileName + "  at  x: " + lastTileRequestX + "  y: " + lastTileRequestY);
		}
		else {
			tileRequest += " Click on tile";
		}
		labelTerrainType = new JLabel("");
		labelTerrainType.setText(tileRequest);
		labelTerrainType.setBackground(colorLabels);
		labelTerrainType.setFont(font);
		labelTerrainType.setOpaque(true);
		
		ccc.gridx = 0;
		ccc.gridy = 2;
		ccc.gridwidth = 3;
		this.add(labelTerrainType, ccc);
		
		
		ccc.gridx = 0;
		ccc.gridy = 3;
		ccc.fill = GridBagConstraints.BOTH;
		ccc.weighty = 4;

		String descriptionAdd = gameState.getWinConditionDescription();
		textAreaDescription = new JTextArea("Description:\n\n" + descriptionAdd);
		textAreaDescription.setEditable(false);
		textAreaDescription.setLineWrap(true);
		scrollPaneDescription = new JScrollPane(textAreaDescription);
		scrollPaneDescription.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneDescription.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ccc.gridwidth = 3;
		this.add(scrollPaneDescription, ccc);
		
		ccc.weighty = 9;
		ccc.gridx = 0;
		ccc.gridy = 4;
		
		createTable();
		tablePlayers.setPreferredScrollableViewportSize(tablePlayers.getPreferredSize());
        tablePlayers.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablePlayers.setRowHeight(tileSize); 
        Font fontTable = new Font("SanfSerif", Font.BOLD, 35);
        tablePlayers.setFont(fontTable);
        scrollPanePlayers = new JScrollPane(tablePlayers);
		scrollPanePlayers.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPanePlayers.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ccc.gridwidth = 3;
		this.add(scrollPanePlayers, ccc);
		
		agents = new Vector<Agent>();
		for(Agent agent : gameState.getAgentList()) {
			agents.add(agent);
		}
		
		
		boxAgents = new JComboBox(agents);
		//ccc.weighty = 1;
		ccc.fill = GridBagConstraints.BOTH;
		ccc.gridx = 0;
		ccc.gridy = 5;
		boxAgents.setEnabled(false);
		boxAgents.setVisible(false);
		ccc.gridwidth = 3;
		ccc.weighty = 0.1;
		this.add(boxAgents, ccc);
		
		boxAgents.addItemListener(this);

		
		ccc.weighty = 0.1;
		ccc.gridx = 0;
		ccc.gridy = 6;
		
		createTableReplay();
		tableReplay.setPreferredScrollableViewportSize(tableReplay.getPreferredSize());
		tableReplay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableReplay.setRowHeight(tileSize); 
        Font fontTableReplay = new Font("SanfSerif", Font.BOLD, 35);
        tableReplay.setFont(fontTable);
		ccc.gridwidth = 3;	
		tableReplay.setVisible(false);
		
		tableReplay.getTableHeader().setVisible(false);
		this.add(tableReplay.getTableHeader(), ccc);
		
		ccc.weighty = 0.2;
		ccc.gridx = 0;
		ccc.gridy = 7;
		ccc.gridwidth = 3;
		this.add(tableReplay, ccc);
		
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setEnabled(false);
		slider.setVisible(false);
		slider.addChangeListener(this);
		ccc.weighty = 0.3;
		ccc.fill = GridBagConstraints.BOTH;
		ccc.gridx = 0;
		ccc.gridy = 8;
		ccc.gridwidth = 3;
		ccc.weighty = 0.1;
		this.add(slider, ccc);
		
		
		buttonStepBack = new JButton();
		buttonStepBack.setFont(font);
		buttonStepBack.setText("<<");
		buttonStepBack.addActionListener(this);
		buttonStepBack.setEnabled(false);
		buttonStepBack.setVisible(false);
		buttonStepBack.setFocusPainted(false);
		ccc.fill = GridBagConstraints.BOTH;
		ccc.weightx = 0.5;
		ccc.gridx = 0;
		ccc.gridy = 9;
		ccc.gridwidth = 1;
		ccc.weighty = 0.1;
		this.add(buttonStepBack, ccc);
		
		
		buttonStepForward = new JButton();
		buttonStepForward.setFont(font);
		buttonStepForward.setText(">>");
		buttonStepForward.addActionListener(this);
		buttonStepForward.setEnabled(false);
		buttonStepForward.setVisible(false);
		buttonStepForward.setFocusPainted(false);
		ccc.fill = GridBagConstraints.BOTH;
		ccc.weightx = 0.5;
		ccc.gridx = 2;
		ccc.gridy = 9;
		ccc.gridwidth = 1;
		ccc.weighty = 0.1;
		this.add(buttonStepForward, ccc);

		
		buttonStatistics = new JButton();
		buttonStatistics.setFont(font);
		buttonStatistics.setText("Replay");
		buttonStatistics.addActionListener(this);
		buttonStatistics.setEnabled(false);
		buttonStatistics.setFocusPainted(false);
		ccc.fill = GridBagConstraints.BOTH;
		ccc.gridx = 0;
		ccc.gridy = 10;
		ccc.anchor = GridBagConstraints.PAGE_END;
		ccc.gridwidth = 3;
		ccc.weighty = 0.1;
		this.add(buttonStatistics, ccc);
			
		
	}
	
	private void createTableReplay(){
		
		columnNamesReplay = new String[]{"Agent", "Move", "Inputs"};
		dataReplay = new Object[1][3];
		
		modelReplay = new DefaultTableModel(dataReplay, columnNamesReplay)
        {
			public Class<?> getColumnClass(int column) {
				if (column==0)
					return ImageIcon.class;
				if (column==1)
					return ImageIcon.class;
				if (column==2)
					return Integer.class;
				return Object.class;
			}
        };
        
        
        tableReplay = new JTable(modelReplay) {
        	public boolean isCellEditable(int x, int y) {
                return false;
            }
        	
        	public boolean isCellSelected(int x, int y) {
                return false;
            }
        	
        	public boolean isColumnSelected(int x) {
        		return false;
        	}
        	
        	
        	
        };
        
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tableReplay.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
	}
	
	private void updateTableReplay() {	
		
		int counter = 0;
		TEXTURE_ID tId;
		BufferedImage image;
		BufferedImage imageNew;
		Icon iconcon;
		
		//Fix for agentForReplay == null
		if(agentForReplay == null) {
			return;
		}

		tId = Texture.agentIdToTextureId(agentForReplay.getID());
		image = Texture.getImage(tId);
		imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
		imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
		iconcon = new ImageIcon(imageNew);
		tableReplay.getModel().setValueAt(iconcon, counter, 0);
		
		if(agentForReplaySteps != 0) {
			tId = Texture.moveDirectionToTextureId(agentForReplay.getMoveDirectionList().get(agentForReplaySteps - 1));
		}
		else {
			tId = Texture.moveDirectionToTextureId(MoveDirection.NONE);
		}
		
		
		image = Texture.getImage(tId);
		imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
		imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
		iconcon = new ImageIcon(imageNew);
		tableReplay.getModel().setValueAt(iconcon, counter, 1);
		
		

		tableReplay.getModel().setValueAt(agentForReplaySteps, counter, 2);			    
	}
	

	
	private void createTable() {
		List<Agent> agents = gameState.getAgentList();
		int numberAgents = agents.size();
		
		columnNames = new String[]{"Agent", "Move",  "Steps", "Invalid", "Inputs", "Objects"};
		data = new Object[numberAgents][6];
		
		int counter = 0;
		TEXTURE_ID tId;
		BufferedImage image;
		BufferedImage imageNew;
		Icon iconcon;
		for(Agent agent : agents) {
			
			tId = Texture.agentIdToTextureId(agent.getID());
			image = Texture.getImage(tId);
			imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
			imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
			iconcon = new ImageIcon(imageNew);
			
			data[counter][0] = iconcon;
			
			tId = Texture.moveDirectionToTextureId(agent.getLastMoveDirection());
			image = Texture.getImage(tId);
			imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
			imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
			iconcon = new ImageIcon(imageNew);
			
			data[counter][1] = iconcon;
			
			Integer stepsMade = agent.getStepsMade();
			
			data[counter][2] = stepsMade;
			data[counter][3] = agent.getNumberInvalidInputs();
			data[counter][4] = agent.getNumberInputs();
			data[counter][5] = agent.getCollectedObjects().size();
			
			
			counter++;
		}
		
		model = new DefaultTableModel(data, columnNames)
        {
			/*
			 * Returning the Class of each column will allow different
			 * renderers to be used based on Class
			 *
			public Class getColumnClass(int column)
           	{
				return getValueAt(0, column).getClass();
           	}	*/
			
			public Class<?> getColumnClass(int column) {
				if (column==0)
					return ImageIcon.class;
				if (column==1)
					return ImageIcon.class;
				if (column==2)
					return Integer.class;
				if (column==3)
					return Integer.class;
				if (column==4)
					return Integer.class;
				if (column==5)
					return Integer.class;
				return Object.class;
			}
        };
        
        tablePlayers = new JTable(model) {
        	public boolean isCellEditable(int x, int y) {
                return false;
            }
        	
        	public boolean isCellSelected(int x, int y) {
                return false;
            }
        	
        	public boolean isColumnSelected(int x) {
        		return false;
        	}
        	
        };
        
        
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tablePlayers.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        tablePlayers.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        tablePlayers.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        tablePlayers.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
	}
	
	private void updateTable() {
		
		List<Agent> agents = gameState.getAgentList();
		
		int counter = 0;
		TEXTURE_ID tId;
		BufferedImage image;
		BufferedImage imageNew;
		Icon iconcon;
		for(Agent agent : agents) {
			
			tId = Texture.agentIdToTextureId(agent.getID());
			image = Texture.getImage(tId);
			imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
			imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
			iconcon = new ImageIcon(imageNew);
			tablePlayers.getModel().setValueAt(iconcon, counter, 0);
			
			tId = Texture.moveDirectionToTextureId(agent.getLastMoveDirection());
			image = Texture.getImage(tId);
			imageNew = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
			imageNew.getGraphics().drawImage(image, 0, 0, tileSize, tileSize, null);
			iconcon = new ImageIcon(imageNew);
			
			Integer stepsMade = agent.getStepsMade();
			
			
			tablePlayers.getModel().setValueAt(iconcon, counter, 1);
			tablePlayers.getModel().setValueAt(stepsMade, counter, 2);
			tablePlayers.getModel().setValueAt(agent.getNumberInvalidInputs(), counter, 3);
			tablePlayers.getModel().setValueAt(agent.getNumberInputs(), counter, 4);	
			tablePlayers.getModel().setValueAt(agent.getCollectedObjects().size(), counter, 5);			
			
			counter++;
		}
        
	}
	
	private void updateView() {
		
		String tileRequest = "";
		if(tileRequestActive) {
			String tileName = gameState.getMatchfield().getTile(lastTileRequestX, lastTileRequestY).getTerrainType().toString();
			
			tileRequest += (tileName + "  at  x: " + lastTileRequestX + "  y: " + lastTileRequestY);
		
		}
		else {
			tileRequest += "Click on tile";
		}
		
		labelTerrainType.setText(tileRequest);
	
		String stateRequest = "Game Running.";
		if(gameState.isGameFinished()) {
			stateRequest = "Game Completed.";
		}
		else if(gameState.isGameOver()) {
			stateRequest = "Game Over.";
		}
		
		labelState.setText("State: " + stateRequest);
		
		
		if(gameState.isGameFinished()) {
			buttonStatistics.setEnabled(true);
		}
		
		if(gameState.isGameOver()) {
			buttonStatistics.setEnabled(true);
		}
	}
	
	public void updateReplay() {
		
		int stepsCounter = slider.getValue();
		
		if(stepsCounter == slider.getMinimum()) {
			buttonStepBack.setEnabled(false);
		}
		else {
			if(!buttonStepBack.isEnabled()) {
				buttonStepBack.setEnabled(true);
			}
		}
		
		if(stepsCounter == slider.getMaximum()) {
			buttonStepForward.setEnabled(false);
		}
		else {
			if(!buttonStepForward.isEnabled()) {
				buttonStepForward.setEnabled(true);
			}
		}
		
		updateTableReplay();
		
	}
	
	public void initReply() {
		
		int steps = ((Agent) boxAgents.getSelectedItem()).getNumberInputs();
		
		int majorTick = Math.floorDiv(steps , 5);
		
		slider.setMinimum(0);
		slider.setMaximum(steps);
		slider.setValue(0);
		slider.setMajorTickSpacing(majorTick);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		
	}
	
	/**
	 * This method starts the animations
	 */
	public void runAnnimation() {
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						updateView();
						updateTable();
						if(gameMode == GameMode.GAME_REPLAY) {
							updateReplay();
						}
						
						
						Thread.sleep(30);
						revalidate();
						repaint();
						
					} catch (InterruptedException e) {
					}
				}
			}
		}).start();
		
	}
	
	/**
	 * This method tells all registered listeners about an event.
	 * 
	 * @param event   the guiEvent, that should be published
	 */
	private void tellAllListeners(GuiEvent event) {
		listeners.forEach(l -> l.handle(event));
	}
	
	@Override
	public void registerListener(GuiEventListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(GuiEventListener listener) {
		this.listeners.remove(listener);
	}


	@Override
	public void handle(PanelEvent event) {
		switch (event.getType()) {
		case TILE_REQUEST_ANSWER:			
			
			int tileX = event.getFirstAttributeInteger(PanelEventEnumKey.TILE_POS_X);
			int tileY = event.getFirstAttributeInteger(PanelEventEnumKey.TILE_POS_Y);			
			
			if(!gameState.getMatchfield().isTile(tileX, tileY)) {
				tileRequestActive = false;
				return;
			}
			
			if(tileRequestActive) {
				if(lastTileRequestX == tileX && lastTileRequestY == tileY) {
					tileRequestActive = false;
				}
				else {
					lastTileRequestX = tileX;
					lastTileRequestY = tileY;
					tileRequestActive = true;
				}
			}			
			else {
				lastTileRequestX = tileX;
				lastTileRequestY = tileY;
				tileRequestActive = true;
			}
			
			break;
		default:
			break;
		
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == this.buttonStatistics) {
			if(gameState.isGameFinished() || gameState.isGameOver()) {
				
				if(gameMode == GameMode.GAME_IN_ACTION) {
					
					if(boxAgents.getItemCount() == 0) {
						System.out.println("---------------Info-Message-----------------");
						System.out.println("Kein Replay ohne Agenten möglich.");
						System.out.println("Stattdessen wird BasicMap geladen.");
						System.out.println("--------------------------------------------");	
						return;
					}
					
					gameMode = GameMode.GAME_REPLAY;
					boxAgents.setEnabled(true);
					boxAgents.setVisible(true);
					
					slider.setEnabled(true);
					slider.setVisible(true);
					
					buttonStepBack.setEnabled(true);
					buttonStepBack.setVisible(true);
					
					buttonStepForward.setEnabled(true);
					buttonStepForward.setVisible(true);
					
					scrollPaneDescription.setVisible(false);
					
					tableReplay.setVisible(true);
					tableReplay.getTableHeader().setVisible(true);
					
					buttonStatistics.setText("Replay stop");
					
					initReply();
					
					GuiEvent guiEvent = new GuiEvent(GuiEventType.START_REPLAY);
					int id = ((Agent) boxAgents.getSelectedItem()).getID();
					int steps = slider.getValue();
					guiEvent.addAtribute(GuiEventEnumKey.AGENT_ID, id);
					guiEvent.addAtribute(GuiEventEnumKey.STEPS, steps);
					
					tellAllListeners(guiEvent);
				}
				else {
					gameMode = GameMode.GAME_IN_ACTION;
					boxAgents.setEnabled(false);
					boxAgents.setVisible(false);
					
					slider.setEnabled(false);
					slider.setVisible(false);
					
					buttonStepBack.setEnabled(false);
					buttonStepBack.setVisible(false);
					
					buttonStepForward.setEnabled(false);
					buttonStepForward.setVisible(false);
					
					scrollPaneDescription.setVisible(true);
					tableReplay.setVisible(false);
					tableReplay.getTableHeader().setVisible(false);
					
					buttonStatistics.setText("Replay");
					
					GuiEvent guiEvent = new GuiEvent(GuiEventType.STOP_REPLAY);
					tellAllListeners(guiEvent);
				}
				
			}
		}
		else if(event.getSource() == this.buttonStepBack) {
			int minValue = slider.getMinimum();
			int value = slider.getValue();
			
			if(value > minValue) {
				slider.setValue(value - 1);
			}
		}
		else if(event.getSource() == this.buttonStepForward) {
			int maxValue = slider.getMaximum();
			int value = slider.getValue();
			
			if(value < maxValue) {
				slider.setValue(value + 1);
			}
		}
	}



	@Override
	public void itemStateChanged(ItemEvent event) {
		
		
		if (event.getStateChange() == ItemEvent.SELECTED) {
			Object item = event.getItem();
			
			initReply();
			
			GuiEvent guiEvent = new GuiEvent(GuiEventType.START_REPLAY);
			int id = ((Agent) boxAgents.getSelectedItem()).getID();
			int steps = slider.getValue();
			guiEvent.addAtribute(GuiEventEnumKey.AGENT_ID, id);
			guiEvent.addAtribute(GuiEventEnumKey.STEPS, steps);
			
			agentForReplay = gameState.getAgentList().get(id);
			agentForReplaySteps = steps;
			
			tellAllListeners(guiEvent);
	    }	
	}


	@Override
	public void stateChanged(ChangeEvent event) {
		
		JSlider source = (JSlider)event.getSource();
        	int steps = source.getValue();

        	GuiEvent guiEvent = new GuiEvent(GuiEventType.START_REPLAY);
			int id = ((Agent) boxAgents.getSelectedItem()).getID();
			guiEvent.addAtribute(GuiEventEnumKey.AGENT_ID, id);
			guiEvent.addAtribute(GuiEventEnumKey.STEPS, steps);
			
			agentForReplay = gameState.getAgentList().get(id);
			agentForReplaySteps = steps;
			
			tellAllListeners(guiEvent); 
	}

}