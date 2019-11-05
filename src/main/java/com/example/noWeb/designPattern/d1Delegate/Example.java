package com.example.noWeb.designPattern.d1Delegate;

interface I {
    void f();

    void g();
}

class A implements I {

    @Override
    public void f() {
        System.out.println("A: doing f()");
    }

    @Override
    public void g() {
        System.out.println("A: doing g()");
    }
}

class B implements I {

    @Override
    public void f() {
        System.out.println("B: doing f()");
    }

    @Override
    public void g() {
        System.out.println("B: doing g()");
    }
}

class C implements I {

    // 代理
    I i = new A();

    @Override
    public void f() {
        i.f();
    }

    @Override
    public void g() {
        i.g();
    }

    public void toA() {
        i = new A();
    }

    public void toB() {
        i = new B();
    }
}

public class Example {
    public static void main(String[] args) {
        C c = new C();
        c.f();     // output: A: doing f()
        c.g();     // output: A: doing g()
        c.toB();
        c.f();     // output: B: doing f()
        c.g();     // output: B: doing g()
    }
}
