package org.robotdreams.patterns.lesson2.homework2;

public class Homework {

    public static void main(String[] args) {
        System.out.println("Starting Homework 02");

        new Task01SafeDelete(10, 20).execute(42);
        new Task02Rename(20).call(11);
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

    // private void printTest(int usedParam, int unusedParam) {
    //     System.out.println("SafeDeleteExample received 0");
    // }
}

/* TODO: Task 02: apply Rename refactorings as specified in comments */
class Task02Rename { // rename class name also considering the name in string

    private final int usedInput;

    public Task02Rename(int input){
            this.usedInput = input; // rename field to match parameter name

            System.out.println("Task02Rename initialized with " + input);
        }

        // rename method from "call" to "execute"
        public void call(int i) { // rename parameter "i" to "param"
            System.out.println("Task02Rename executed with " + i);
        }
}

/* TODO: Task 03: apply extract refactorings as specified in comments */
class Task03Extract {

    private final int first;

    public Task03Extract(int first){
        this.first = first;
    }
    public void execute(int second) {
        print("add",
                first,
                second,
                /* Extract to method named add */
                first + second
        );
        print("add",
                42, /* introduce constant named THE_ANSWER_TO_THE_ULTIMATE_QUESTION */
                second,
                /* Extract to method named add */
                42 + second
        );

        print("subtract",
                first,
                second,
                /* Extract to method named subtract */
                first - second
        );

        print("subtract",
                42, /* this should automatically be refactored by the "introduce constant" change */
                second,
                /* Extract to method named subtract */
                42 - second
        );

        print("multiply",
                first,
                second,
                /* Extract to method named multiply */
                first * second
        );
        print("divide",
                first,
                second,
                /* Extract to method named divide */
                first / second
        );
    }

    private void print(String name, int a, int b, int result) {
        System.out.println(String.join("",name,"(",Integer.toString(a),",",Integer.toString(b),")=",Integer.toString(result)));
    }
}

/* TODO: Task 04: apply inline refactorings as specified in comments */
class Task04Inline {

    // inline field
    private final int first;

    public Task04Inline(int first){
        this.first = first;

        print("initialized", first);
    }
    public void execute(int second) {
        print("executed", second);
    }

    // inline method "print"
    private void print(String operation, int param) {
        System.out.println("Task04Inline " + operation + " with " + param);
    }
}
