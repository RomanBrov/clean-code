package org.robotdreams.patterns.lesson15.theory;

import akka.actor.typed.ActorSystem;

import java.io.IOException;
public class AkkaDemo {
    public void start() {
        // actor-system
        final ActorSystem<GreeterMain.SayHello> greeterMain = ActorSystem.create(GreeterMain.create(), "helloakka");

        // main-send-messages
        greeterMain.tell(new GreeterMain.SayHello("Students"));
        greeterMain.tell(new GreeterMain.SayHello("Teacher"));

        // 0. my friend
        // document.insert(row: 35, column: 11, "hello", "Sasha", 19-41-01, #1)
        // document.delete(row: 35, column: 11, shift: 10, "Nikolay", 19-41-01, #2)
        // document.insert(row: 35, column: 20, "Sasha", 19-41-05)
        // 1. Hello my friend
        // 2. Error -> reload
        // 3. Hello my friend Sasha

        // 0. my friend
        // 1-2. iend

        try {
            System.out.println(">>> Press ENTER to exit <<<");
            System.in.read();
        } catch (IOException ignored) {
        } finally {
            greeterMain.terminate();
        }
    }
}
