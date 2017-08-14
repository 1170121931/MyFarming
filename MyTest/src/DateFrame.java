import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DateFrame extends JFrame {
        // 时间格式
        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        private LabelPanel lp = null;

        public DateFrame() {

                // 设置显示窗口的参数
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                // 居中显示
                setLocationRelativeTo(null);
                // 窗口大小
                setSize(400, 450);
                // 窗口不可改变大小
                setResizable(false);
                // 添加时间的JPanel
                // getContentPane().add(new TimePanel());
                lp = new LabelPanel();
                getContentPane().add(new TimePanel());

                // 显示
                setVisible(true);

                // 设置时间变化的任务
                Timer timer = new Timer();
                timer.schedule(new ShowTime(), new Date(), 1000);

        }

        class ShowTime extends TimerTask {
                public void run() {
                        // 刷新
                        lp.label.setText(sdf.format(new Date()));
                        repaint();
                }
        }

        class TimePanel extends JPanel {
                public void paint(Graphics g) {
                        super.paint(g);
                        // 显示时间
                        g.drawString(sdf.format(new Date()), 10, 10);
                }
        }

        class LabelPanel extends JPanel {
                JLabel label = new JLabel();

                public LabelPanel() {
                        add(label);
                }
        }

        public static void main(String[] args) {
                new DateFrame();
        }

}