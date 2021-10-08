package scratchpad;

import java.awt.FlowLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JButton;

public final class FlowLayoutPractice {
	public static void main(String[] args) {
		var flowLayoutPractice = new FlowLayoutPractice();
		flowLayoutPractice.render();
	}

	void render() {
		var frame = new JFrame("Flow Layout Practice");
		var contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JButton("Button a"));
		contentPane.add(new JButton("Button b"));
		contentPane.add(new JButton("Button c"));
		contentPane.add(new JButton("Button d"));
		contentPane.add(new JButton("Button e"));
		contentPane.add(new JButton("Button f"));
		contentPane.add(new JButton("Button g"));

		frame.setVisible(true);
		frame.setSize(200, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
