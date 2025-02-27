import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import javax.swing.*;
public class Stopwatch implements ActionListener{
    JFrame frame = new JFrame("Stopwatch");
    JButton startButton = new JButton("START");
    JButton stopButton = new JButton("STOP");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int time = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d",seconds);
    String minutes_string = String.format("%02d",minutes);
    String hours_string = String.format("%02d",hours);
    Timer timer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                time += 1000;
                hours = time/3600000;
                minutes = (time/60000) % 60;
                seconds = (time/1000) % 60;
                seconds_string = String.format("%02d",seconds);
                minutes_string = String.format("%02d",minutes);
                hours_string = String.format("%02d",hours);
                timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
            }
    });

    Stopwatch(){


        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setForeground(Color.BLACK);

        startButton.setBounds(100,200,100,50);
        startButton.setFocusable(false);
        startButton.setFont(new Font("Verdana",Font.PLAIN,20));
        startButton.setBackground(new Color(52, 199, 89)); // #34C759
        startButton.setForeground(Color.BLACK);
        startButton.addActionListener(this);

        resetButton.setBounds(150,250,100,50);
        resetButton.setFocusable(false);
        resetButton.setFont(new Font("Verdana",Font.PLAIN,20));
        resetButton.setBackground(new Color(255, 165, 0)); // #4CAF50
        resetButton.setForeground(Color.BLACK);
        resetButton.addActionListener(this);

        stopButton.setBounds(200,200,100,50);
        stopButton.setFocusable(false);
        stopButton.setFont(new Font("Verdana",Font.PLAIN,20));
        stopButton.setBackground(new Color(255, 59, 48)); // #FF3B30
        stopButton.setForeground(Color.BLACK);
        stopButton.addActionListener(this);


        JLabel backgroundImage = new JLabel(new ImageIcon("WhatsApp Image 2025-02-27 at 23.30.37_4d337d78.jpg"));
        backgroundImage.setBounds(0, 0, 420, 420);
        frame.add(backgroundImage);
        frame.setContentPane(backgroundImage);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("WhatsApp Image 2025-02-27 at 23.30.37_4d337d78.jpg"));
        frame.add(startButton);
        frame.add(stopButton);
        frame.add(resetButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()==startButton){
                if (started == false){
                    started = true;
                    start();
                }
            }
            if (e.getSource()==resetButton){
                started = false;
                reset();
            }
            if (e.getSource() == stopButton){
                timer.stop();
            }
    }
    void start(){
            timer.start();
    }
    void stop(){
            timer.stop();
    }
    void reset(){
        timer.stop();
        time = 0;
        hours = 0;
        minutes = 0;
        seconds = 0;
        seconds_string = String.format("%02d",seconds);
        minutes_string = String.format("%02d",minutes);
        hours_string = String.format("%02d",hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }
}
