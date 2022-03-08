package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        Person p = Person.getInstance(1, "zhapeng");
        System.out.println(p.toString());
        FileOutputStream fos = new FileOutputStream("person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        oos.flush();
        oos.close();
    }
}