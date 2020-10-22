package our.company.windows;

import java.io.*;
import java.util.ArrayList;

public class OperationOnData {

    public void saveInfo(ArrayList<Person> person){
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("person.dat"))){
            obj.writeObject(person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> readInfo(){
        ArrayList<Person> persons = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
            persons = (ArrayList<Person>)ois.readObject();
            return persons;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    public String checkIntType(String value){
        try{
            int result = Integer.parseInt(value.trim());
            return value;
        } catch (Exception ex){
            System.out.println(ex);
        }
        return "Введены некорректные данные";
    }
}
