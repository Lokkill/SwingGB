package our.company.windows;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GuideWindow extends JFrame {
    OperationOnData op = new OperationOnData();
    public GuideWindow(){
        setBounds(350,350,500,500);
        setLayout(new BorderLayout());
        setTitle("Список сохраненных пользователей");

        String[] columnsName = {"ID", "Фамилия", "Имя", "Отчество", "Возраст", "Номер телефона"};
        ArrayList<Person> persons = op.readInfo();
        String[][] listPerson = new String[persons.size()][columnsName.length];
        int i = 0;
        for (Person person : persons){
            listPerson[i][0] = person.secondName;
            listPerson[i][1] = person.firstName;
            listPerson[i][2] = person.middleName;
            listPerson[i][3] = String.valueOf(person.age);
            listPerson[i][4] = person.phoneNumber;
            i++;
        }

        JTable table = new JTable(listPerson, columnsName);
        table.setPreferredScrollableViewportSize(new Dimension(500,500));
        table.setFillsViewportHeight(true);
        add(table);

        setVisible(true);
    }
}
