package org.robotdreams.patterns.lesson10.theory.auxiliary;

import com.flextrade.jfixture.JFixture;
import org.robotdreams.patterns.lesson10.theory.apimodels.SocialNetworkPostApi;
import org.robotdreams.patterns.lesson10.theory.models.SocialNetworkPostModel;

import java.util.Map;

public class SocialNetworkPostService {
    private final ReadOnlyRepository<SocialNetworkPostApi, SocialNetworkPostModel> readRepository;
    private final WriteRepository<SocialNetworkPostApi, SocialNetworkPostModel> writeRepository;

    public SocialNetworkPostService(ReadOnlyRepository<SocialNetworkPostApi, SocialNetworkPostModel> readRepository,
                                    WriteRepository<SocialNetworkPostApi, SocialNetworkPostModel> writeRepository) {
        this.readRepository = readRepository;
        this.writeRepository = writeRepository;
    }

    public void create(SocialNetworkPostApi post) {
        System.out.println("Creating New Post by user '" + post.getAuthorId() + "' with text '" + post.getText() + "'");

        JFixture jFixture = new JFixture();
        jFixture
                .customise()
                .propertyOf(SocialNetworkPostApi.class, "authorId", post.getAuthorId())
                .propertyOf(SocialNetworkPostApi.class, "text", post.getText())
                .propertyOf(SocialNetworkPostApi.class, "imageUri", post.getImageUri());
        SocialNetworkPostApi item = jFixture.
                create(SocialNetworkPostApi.class);
        writeRepository.create(item);
    }

    public SocialNetworkPostApi[] find(String searchText, int limit) {
        return readRepository.findBy(Map.of("text", searchText), limit);
    }
}
