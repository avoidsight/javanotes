package io;

import java.io.Serializable;

public class Person implements Serializable{
    //普通单例对象
    private int id;
    private String name;
    private static Person person;
    private Person(int ida,String namea){
        this.id = ida;
        this.name = namea;
    }
    public static synchronized Person getInstance(int idb,String nameb){
        if(person == null){
            person = new Person(idb, nameb);
        }
        return person;
    }

    @Override
    public String toString(){
        return this.id+" : "+this.name;
    }
}