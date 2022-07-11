import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat weekFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    JLabel weekLabel;
    String time;
    String day;
    String date;
    String week;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Lame Clock");
        this.setLayout(new FlowLayout());
        this.setSize(330,240);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        weekFormat = new SimpleDateFormat("ww");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("IrisUPC",Font.PLAIN,120));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.RED);
        timeLabel.setOpaque(true); // to see the background

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Arial",Font.PLAIN,30));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial",Font.PLAIN,30));

        weekLabel = new JLabel();
        weekLabel.setFont(new Font("Arial",Font.PLAIN,30));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.add(weekLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            week = weekFormat.format(Calendar.getInstance().getTime());
            weekLabel.setText("Tydzień: " + week);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
