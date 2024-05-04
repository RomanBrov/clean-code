package org.robotdreams.patterns.lesson10.theory.moderqueries06;

import com.google.gson.GsonBuilder;
import org.robotdreams.patterns.lesson10.theory.apimodels.SocialNetworkPostApi;
import org.robotdreams.patterns.lesson10.theory.auxiliary.ServiceRegistration;
import org.robotdreams.patterns.lesson10.theory.moderncommand05.ModernCommands;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ModernQueries {
    public void start() {
        System.out.println("Starting " + ModernCommands.class.getSimpleName());

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ServiceRegistration.class);

        var queryHandler = appContext.getBean(FindPostsQueryHandler.class);
        FindPostsQuery query = new FindPostsQuery("Life without war", 10);
        SocialNetworkPostApi[] foundItems = queryHandler.handle(query);
        System.out.println("Received items:");
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(foundItems));

        System.out.println();
    }
}

