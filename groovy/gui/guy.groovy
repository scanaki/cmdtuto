/* @file: guy.groovy
 * @author: Thierry JEAN-LOUIS
 * @date: 02.11.2017
 * @desc: First groovy test with Docker
 */

//import java.awt.EventQueue;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

 /* __class_guy__ */
public class guy extends JFrame {
    private void createLayout(JComponent... arg) {
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }

	private void initUI() {
		JButton quitButton = new JButton("Quit");
		createLayout(quitButton);
		setTitle("First Window");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void affiche() {
		//EventQueue.invokeLater(() -> {
			this.setVisible(true);
		//});
	}

 	public void init() {
		initUI();
		affiche();
		println("\033[32mGUI started properly.\033[0m");
	}
 }
 /* __class_guy__ */

