package com.vikydroid.mylib.oldIntel.cloning;

public class TestCloningInObjects {
    public static void main(String[] args) {
        Employee e1 = new Employee(10, "Viv", new Address("Delhi", "India"),
                new MyImmutable(new StringBuilder("myImmutableData")), new StringBuilder("MyStringBuilder"));
        Employee e2 = null;
        try {
            e2 = (Employee) e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(e1);
        System.out.println(e2);
        System.out.println("is obj Same: " + (e1.hashCode() == e2.hashCode()));

        System.out.println("is int Same: " + (e1.id == e2.id));

        System.out.println("is builder Same: " + (e1.builder.hashCode() == e2.builder.hashCode()));
        e1.builder = new StringBuilder("changed data");
        System.out.println("is builder Same: " + (e1.builder.hashCode() == e2.builder.hashCode()));

        System.out.println("is name Same: " + (e1.name.hashCode() == e2.name.hashCode()));
        e1.name = "fsafsf";
        System.out.println("is name Same: " + (e1.name.hashCode() == e2.name.hashCode()));

        System.out.println("is address Same: " + (e1.address.hashCode() == e2.address.hashCode()));
        System.out.println("is myImmutable Same: " + (e1.myImmutable.hashCode() == e2.myImmutable.hashCode()));

        System.out.println("is myImmutable.getBuilder() Same: " + (e1.myImmutable.getBuilder().hashCode() == e2.myImmutable.getBuilder().hashCode()));
        e1.myImmutable.setBuilder(new StringBuilder("asdsdasda"));
        System.out.println("is myImmutable.getBuilder() Same: " + (e1.myImmutable.getBuilder().hashCode() == e2.myImmutable.getBuilder().hashCode()));
    }
}
