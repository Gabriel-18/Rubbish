package Lambda.demo3;

import java.util.Arrays;

public class Demo03Arrays {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("11",11),
                new Person("2",2),
                new Person("3",3),
                new Person("4",4)
        };
        //Arrays.sort(arr, new Comparator<Person>() {
        //    @Override
        //    public int compare(Person o1, Person o2) {
        //        return o1.getAge() - o2.getAge();
        //    }
        //});

        Arrays.sort(arr,(Person o1,Person o2)->{
            return o1.getAge() - o2.getAge();
        });
        Arrays.sort(arr,( o1, o2)-> o1.getAge() - o2.getAge());
        Arrays.sort(arr,( o1, o2)-> o1.getAge() - o2.getAge());
        for (Person person : arr) {
            System.out.println(person);
        }
    }
}
