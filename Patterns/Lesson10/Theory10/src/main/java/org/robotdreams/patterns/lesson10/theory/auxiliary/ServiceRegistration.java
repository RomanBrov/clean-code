package org.robotdreams.patterns.lesson10.theory.auxiliary;

import org.dozer.DozerBeanMapper;
import org.robotdreams.patterns.lesson10.theory.apimodels.*;
import org.robotdreams.patterns.lesson10.theory.models.*;
import org.robotdreams.patterns.lesson10.theory.moderncommand05.*;
import org.robotdreams.patterns.lesson10.theory.moderqueries06.*;
import org.springframework.context.annotation.*;

@Configuration
public class ServiceRegistration {

    @Bean
    public ReadOnlyRepository<SocialNetworkPostApi, SocialNetworkPostModel> readOnlyRepository() {
        return new ReadOnlyRepository<>(
                mapper(),
                SocialNetworkPostApi.class,
                SocialNetworkPostModel.class
        );
    }

    @Bean
    public WriteRepository<SocialNetworkPostApi, SocialNetworkPostModel> writeRepository() {
        return new WriteRepository<>(mapper(), SocialNetworkPostModel.class);
    }

    @Bean
    public DozerBeanMapper mapper(){
        return new DozerBeanMapper();
    }

    @Bean
    public SocialNetworkPostService socialNetworkPostService() {
        return new SocialNetworkPostService(readOnlyRepository(), writeRepository());
    }

    @Bean
    public ImageService imageService() {
        return new ImageService();
    }

    @Bean
    public ICommandHandler<CreateSocialNetworkPostCommand> createSocialNetworkPostCommandHandler() {
        return new CreateSocialNetworkPostCommandHandler(socialNetworkPostService(), imageService());
    }

    @Bean
    public IQueryHandler<FindPostsQuery, SocialNetworkPostApi[]> findPostsQueryHandler() {
        return new FindPostsQueryHandler(socialNetworkPostService());
    }

}

