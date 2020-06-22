package singleton;

import java.io.Serializable;

public class Person implements Serializable{
    private int id;
    private String name;
    private static Person person;
    private Person(int ida,String namea){
        this.id = ida;
        this.name = namea;
    }
    public static Person getInstance(int idb,String nameb){
        //判断单例是否实例化,防止大量的线程由于同步进入等待,这步的作用主要是提高性能
        if(person == null){
            
            //在没有实例化单例对象后,线程再进入同步方法,确保对象只能同时被一个线程实例化
            synchronized(Person.class){
                if(person == null){
                    return new Person(idb, nameb);
                }
            }
        }
        return person;
    }

    @Override
    public String toString(){
        return this.id+" : "+this.name;
    }
}