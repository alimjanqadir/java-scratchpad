package scratchpad;

import javax.swing.*;
import java.awt.*;

public final class BoxLayoutPractice {
	public static void main(String[] args) {
		var boxLayoutPractice = new BoxLayoutPractice();
		boxLayoutPractice.render();
	
	}

	void render(){
		var frame = new JFrame("BoxLayout Practice");
		var contentPane = frame.getContentPane();

		var verticalPanel = new JPanel();
		var horizontalPanel = new JPanel();

		verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
		horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.X_AXIS));

		verticalPanel.add(new JLabel("First"));
		verticalPanel.add(new JLabel("Second"));
		verticalPanel.add(new JLabel("Third"));
		verticalPanel.add(new JLabel("Forth"));

		contentPane.add(verticalPanel, BorderLayout.CENTER);

		horizontalPanel.add(new JButton("OK"));
		horizontalPanel.add(new JButton("Set"));
		horizontalPanel.add(new JButton("Cancel"));
				
		contentPane.add(horizontalPanel, BorderLayout.SOUTH);

		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
