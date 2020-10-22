package our.company.windows;

import java.io.Serializable;

public class Person implements Serializable {

    String secondName;
    String firstName;
    String middleName;
    int age;
    String phoneNumber;

    public Person(String secondName, String firstName, String middleName, int age, String phoneNumber) {

        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }


}
