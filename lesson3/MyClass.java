package lesson3;

import lesson3.IMyClass;

public class MyClass<T> implements IMyClass<T> {
    private T something;

    public T getSomething() {
        return this.something;
    }

    public MyClass(T s) {
        this.something = s;
    }

    public void saySomething() {
        System.out.println(String.format("something = %s", this.getSomething()));
    }
}
