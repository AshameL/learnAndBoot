package com.example.noWeb.designPattern.d1Delegate;

class RealPrinter {
    void print() {
        System.out.println("printer something");
    }
}

class Printer {
    RealPrinter p = new RealPrinter();

    void print() {
        p.print();
    }
}

public class SimpleExample {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();
    }
}
