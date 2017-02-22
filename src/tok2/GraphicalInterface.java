package tok2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by icamer on 23.11.16.
 */
public class GraphicalInterface {
    private JPanel panel1;
    private JTextArea textArea1;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JButton button1;


    public GraphicalInterface() {
        spinner1.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {


            }
        });
        spinner2.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

            }
        });
        spinner3.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

            }
        });
        spinner1.setValue(1);
        spinner2.setValue(1);
        spinner3.setValue(0);
        button1.addActionListener(getActionListener());
        Font font = new Font("Ubuntu Mono", 20, 20);

        textArea1.setFont(font);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Date date = dateFromSpinners();

                    if (date.getDay() > 30 || date.getMonth() > 13) {
                        throw new WrongDateRuntimeException("dat o/o 31/13");
                    } else if (date.getDay() > 6 && date.getMonth() == 13 && (date.getYear() % 4 == 0 && date.getYear() % 400 != 0)) {
                        System.out.println(date.getDay());
                        throw new WrongDateRuntimeException("dat o/o 6/13");
                    }
//                    if (date.getDay() > 5 && date.getMonth() == 13 && !(date.getDay() > 6 && date.getMonth() == 13 && (date.getYear() % 4 == 0 && date.getYear() % 400 != 0))){
//                        throw new WrongDateRuntimeException("dat o/o 5/13");
//                    }

                    int amountOfDays = date.count();
                    int dayOfWeek = (amountOfDays % 10) + 1;
                    String nameOfDayOfWeek = "";
                    switch (dayOfWeek) {
                        case 1:
                            nameOfDayOfWeek = "A";
                            break;
                        case 2:
                            nameOfDayOfWeek = "B";
                            break;
                        case 3:
                            nameOfDayOfWeek = "C";
                            break;
                        case 4:
                            nameOfDayOfWeek = "D";
                            break;
                        case 5:
                            nameOfDayOfWeek = "E";
                            break;
                        case 6:
                            nameOfDayOfWeek = "F";
                            break;
                        case 7:
                            nameOfDayOfWeek = "G";
                            break;
                        case 8:
                            nameOfDayOfWeek = "H";
                            break;
                        case 9:
                            nameOfDayOfWeek = "I";
                            break;
                        case 10:
                            nameOfDayOfWeek = "J";
                            break;
                    }

                    textArea1.setText(nameOfDayOfWeek);

                    System.out.println(amountOfDays);
                } catch (WrongDateRuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    private ActionListener getActionListener() {
        return actionEvent -> {
            dateFromSpinners();
        };
    }

    Date dateFromSpinners() {
        int a, b, c;
        a = (Integer) spinner1.getValue();
        b = (Integer) spinner2.getValue();
        c = (Integer) spinner3.getValue();

        return new Date(a, b, c);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DieRPGo: Kalkulator Czasu");
        frame.setContentPane(new GraphicalInterface().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
