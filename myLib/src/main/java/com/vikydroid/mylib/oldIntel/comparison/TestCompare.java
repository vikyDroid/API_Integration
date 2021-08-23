package com.vikydroid.mylib.oldIntel.comparison;

import com.vikydroid.mylib.oldIntel.cloning.Address;
import com.vikydroid.mylib.oldIntel.cloning.Employee;
import com.vikydroid.mylib.oldIntel.cloning.MyImmutable;

import java.util.*;

public class TestCompare {
    public static void main(String[] args) {
        List<Person> list = new LinkedList<>();
        list.add(new Person("vivek", 26, 5.6));
        list.add(new Person("rahul", 27, 4.5));
        list.add(new Person("alex", 21, 5.7));
        list.add(new Person("praveen", 25, 5.5));
        list.add(new Person("keshav", 22, 5.9));

        System.out.println(Arrays.toString(new List[]{list}));
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        Collections.sort(list);
//        Arrays.sort(new List[]{list});
        System.out.println(Arrays.toString(new List[]{list}));

        ArrayList<Employee> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(new Employee(10, "Viv", new Address("Delhi", "India"),
                    new MyImmutable(new StringBuilder("myImmutableData")), new StringBuilder("MyStringBuilder")));
        }

        list1.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return 0;
            }
        });

    }
}
