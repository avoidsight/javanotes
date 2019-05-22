import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputStreamTest{
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        Person person;
        FileInputStream fis = new FileInputStream("person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        person = (Person)ois.readObject();
        System.out.println(person.toString()+'\3');
        ois.close();
    }
}