package org.robotdreams.patterns.lesson10.theory.moderncommand05;

import com.flextrade.jfixture.JFixture;
import org.robotdreams.patterns.lesson10.theory.auxiliary.ServiceRegistration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ModernCommands {


    private static final int THE_ANSWER_TO_THE_ULTIMATE_QUESTION = 42;

    public void start() {

        System.out.println("Starting " + ModernCommands.class.getSimpleName());

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ServiceRegistration.class);

        // simulate random data
        var jFixture = new JFixture();

        jFixture
                .customise()
                .propertyOf(CreateSocialNetworkPostCommand.class, "authorId", THE_ANSWER_TO_THE_ULTIMATE_QUESTION)
                .propertyOf(CreateSocialNetworkPostCommand.class, "postText", "Hello From Modern World!");
        CreateSocialNetworkPostCommand command = jFixture.create(CreateSocialNetworkPostCommand.class);

        var commandHandler = appContext.getBean(CreateSocialNetworkPostCommandHandler.class);
        commandHandler.handle(command);


        System.out.println();
    }
}

