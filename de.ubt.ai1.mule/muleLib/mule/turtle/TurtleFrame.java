package mule.turtle;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class TurtleFrame extends JFrame {
	
	static String name = "Turtle Graphics";
	public TurtleFrame(int width, int height){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.getContentPane().setSize(new Dimension(width, height));
		
		  
		  
		this.setBounds(d.width/2 - width/2, d.height/2 - height/2, width, height);
		
		String key = "F10";
		KeyStroke f10 = KeyStroke.getKeyStroke( key );
		this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(f10, key);
		this.getRootPane().getActionMap().put(key, new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    }
		});

		
		setTitle(name);
		this.pack();
		setVisible(true);
	}
}
