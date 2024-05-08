package org.robotdreams.patterns.lesson2.homework2;

public class Homework {
    public static void main(String[] args) {
        System.out.println("Starting Homework 02");

        new Task01SafeDelete(10, 20).execute(42);
        new Executor(20).execute(11);
        new Task03Extract(20).execute(11);
        new Task04Inline(20).execute(11);
    }
}

/* TODO: Task 01: apply SafeDelete refactorings to not used code parts */
class Task01SafeDelete {
    private final int usedInput;
    private final int unusedInput;

    public Task01SafeDelete(int usedInput, int unusedInput){

        this.usedInput = usedInput;
        this.unusedInput = unusedInput;

        print("initialized", usedInput, 1);
    }
    public void execute(int i) { print("executed", i, 2);}

    private void print(String operation, int usedParam, int unusedParam) {
        System.out.println("SafeDeleteExample " + operation + " with " + usedParam);
    }
}

/* TODO: Task 02: apply Rename refactorings as specified in comments */
class Executor {
    private final int initialConfig;

    public Executor(int initialInput) {
        this.initialConfig = initialInput;
        System.out.println("Executor initialized with " + initialInput);
    }

    public void execute(int param) {
        System.out.println("Executor executed with " + param);
    }
}

/* TODO: Task 03: apply extract refactorings as specified in comments */
class Task03Extract {
    private final int first;
    private static final int THE_ANSWER_TO_THE_ULTIMATE_QUESTION = 42;

    public Task03Extract(int first){
        this.first = first;
    }

    public void execute(int second) {
        add(first, second);
        add(THE_ANSWER_TO_THE_ULTIMATE_QUESTION, second);
        subtract(first, second);
        subtract(THE_ANSWER_TO_THE_ULTIMATE_QUESTION, second);
        multiply(first, second);
        divide(first, second);
    }

    private void add(int a, int b) {
        print("add", a, b, a + b);
    }

    private void subtract(int a, int b) {
        print("subtract", a, b, a - b);
    }

    private void multiply(int a, int b) {
        print("multiply", a, b, a * b);
    }

    private void divide(int a, int b) {
        print("divide", a, b, a / b);
    }

    private void print(String name, int a, int b, int result) {
        System.out.println(String.join("",name,"(",Integer.toString(a),",",Integer.toString(b),")=",Integer.toString(result)));
    }
}

/* TODO: Task 04: apply inline refactorings as specified in comments */
class Task04Inline {
    public Task04Inline(int first){
        System.out.println("Task04Inline initialized with " + first);
        execute(first);
    }

    public void execute(int second) {
        System.out.println("Task04Inline executed with " + second);
    }
}
