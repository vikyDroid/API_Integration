package com.vikydroid.mylib.oldIntel.cloning;

public class Employee implements Cloneable {
    int id;
    float f;
    String name;
    Address address;
    MyImmutable myImmutable;
    StringBuilder builder;

    //Copy Constructor
    public Employee(Employee e) {
        this.id = e.id;
        this.name = e.name;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Employee(int id, String name, Address address, MyImmutable myImmutable) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.myImmutable = myImmutable;
    }

    public Employee(int id, String name, Address address, MyImmutable myImmutable, StringBuilder builder) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.myImmutable = myImmutable;
        this.builder = builder;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee e = (Employee) super.clone();
        e.address = (Address) address.clone();
        e.myImmutable = (MyImmutable) myImmutable.clone();
//        e.name= (String) name.clone();
//        e.builder = builder.clone();
        return e;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", myImmutable=" + myImmutable +
                ", builder=" + builder +
                '}';
    }
}
