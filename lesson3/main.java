package lesson3;

import java.util.function.Predicate;
import java.util.function.Function;
import lesson3.IMyClass;
// Домашнее задание №3:
// 1. Добавить в классовую модель из домашнего задания 1 (или написать новую модель)
// примеры использования дженерик-классов (обобщенных типов) и дженерик-интерфейсов.
// 2. Написать функциональный интерфейс с методом, который принимает число и возвращает булево значение. Написать реализацию такого интерфейса в виде лямбда-выражения, 
// которое возвращает true если переданное число делится без остатка на 13.
// 3. Написать функциональный интерфейс с методом, который принимает три дробных числа: a, b, c и
// возвращает тоже дробное число. Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает дискриминант. Кто забыл, D = b^2 — 4ac.

class One<T> {
    private T obj;
  
    public void setObj(T value) {
       obj = value;
    }
    public T getObj() { 
      return this.obj;
    }
}

class Two<T1, T2>{
    private T1 obj_count;
    private T2 obj_thing;

    public void setObjects(T1 value1, T2 value2){
        obj_count = value1;
        obj_thing = value2;
    }

    public T1 getCount(){
        return obj_count;
    }

    public T2 getThing(){
        return obj_thing;
    }
}

class lesson3
{
    public static void main(String[] args)
    {
        {
            System.out.println("Zadanie 1");
            Thing thing1 = new Thing();
            thing1.setNameThing("hats"); 
            Count count_thing1 = new Count();
            count_thing1.setCount(4);

            One<Thing> boxWithThings1 = new One<Thing>();
            boxWithThings1.setObj(thing1);
            Two<Count, Thing> countThingsInBox1 = new Two<Count, Thing>();
            countThingsInBox1.setObjects(count_thing1, thing1);

            System.out.println("In box1: " + countThingsInBox1.getCount().getCount() + " " + countThingsInBox1.getThing().getNameThing());


            Thing thing2 = new Thing();
            thing2.setNameThing("cats"); 
            Count count_thing2 = new Count();
            count_thing2.setCount(3);

            One<Thing> boxWithThings2 = new One<Thing>();
            boxWithThings2.setObj(thing2);
            Two<Count, Thing> countThingsInBox2 = new Two<Count, Thing>();
            countThingsInBox2.setObjects(count_thing2, thing2);

            System.out.println("In box2: " + countThingsInBox2.getCount().getCount() + " " + countThingsInBox2.getThing().getNameThing());


            Predicate<Thing> equal_things = x -> x.getNameThing() == "cats";
            System.out.println("Test1: " + equal_things.test(thing1));
            System.out.println("Test2: " + equal_things.test(thing2));

            Function<Count, Integer> function = x -> x.getCount() * 10;
            System.out.println(function.apply(count_thing1) + function.apply(count_thing2));
            System.out.println();

            IMyClass<String> my1 = new MyClass<String>("Foo");
            my1.saySomething();
            IMyClass<Integer> my2 = new MyClass<Integer>(13);
            my2.saySomething();
            
        }
        {
            System.out.println("Zadanie 2");
            Predicate<Integer> res = x -> x % 13 == 0;
            System.out.println("test1:" + res.test(13));
            System.out.println("test2:" + res.test(15));
            System.out.println();
        }
        {
            System.out.println("Zadanie 3");
            Discriminant discriminant = (a, b, c) -> b * b - 4 * a * c;
            System.out.println("discriminant = " + discriminant.apply(1.0, 2.0, 3.0));
            System.out.println();
        }
    }
}