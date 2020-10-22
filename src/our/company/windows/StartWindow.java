package our.company.windows;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StartWindow extends JFrame {
    OperationOnData operationOnData = new OperationOnData();
    ArrayList<Person> persons;
    public StartWindow() {
        persons = operationOnData.readInfo();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 600);
        setTitle("First Swing window");

        setLayout(new GridLayout(6, 2));

        add(new JLabel("Фамилия"));
        TextField secondNameTF = new TextField();
        add(secondNameTF);

        add(new JLabel("Имя"));
        TextField firstNameTF = new TextField();
        add(firstNameTF);

        add(new JLabel("Отчество"));
        TextField middleNameTF = new TextField();
        add(middleNameTF);

        add(new JLabel("Возраст"));
        TextField ageTF = new TextField();
        add(ageTF);
        ageTF.addActionListener(e -> {
            String text = operationOnData.checkIntType(ageTF.getText());
            ageTF.setText(text);
        });

        add(new JLabel("Номер телефона"));
        TextField phoneNumberTF = new TextField();
        add(phoneNumberTF);

        JButton saveBtn = new JButton("Сохранить");
        add(saveBtn);
        saveBtn.addActionListener(e -> {
            Person person = new Person(secondNameTF.getText(),
                    firstNameTF.getText(),
                    middleNameTF.getText(),
                    Integer.valueOf(ageTF.getText()),
                    phoneNumberTF.getText());
            persons.add(person);
            operationOnData.saveInfo(persons);
        });

        JButton exitBtn = new JButton("Выход");
        add(exitBtn);
        exitBtn.addActionListener(e -> System.exit(-1));

//        JMenuBar jbar = new JMenuBar();
//        JMenu menu = new JMenu("Доп");
//        JMenuItem table = new JMenuItem("Открыть таблицу");
//        menu.add(table);
//        table.addActionListener(e -> {
//            GuideWindow gd = new GuideWindow();
//        });
//        jbar.add(menu);
//        add(jbar);

        setVisible(true);
    }
}
