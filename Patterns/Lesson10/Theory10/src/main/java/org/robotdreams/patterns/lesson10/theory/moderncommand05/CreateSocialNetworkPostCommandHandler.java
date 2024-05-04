package org.robotdreams.patterns.lesson10.theory.moderncommand05;

import org.robotdreams.patterns.lesson10.theory.apimodels.SocialNetworkPostApi;
import org.robotdreams.patterns.lesson10.theory.auxiliary.*;

public class CreateSocialNetworkPostCommandHandler implements ICommandHandler<CreateSocialNetworkPostCommand> {
    private final SocialNetworkPostService postService;
    private final ImageService imageService;

    public CreateSocialNetworkPostCommandHandler(SocialNetworkPostService postService, ImageService imageService) {
        this.postService = postService;
        this.imageService = imageService;
    }

    @Override
    public void handle(CreateSocialNetworkPostCommand command) {

        if (imageService.validate(command.getImageUrl())) {
            var post = new SocialNetworkPostApi();
            post.setAuthorId(command.getAuthorId());
            post.setText(command.getPostText());
            post.setImageUri(command.getImageUrl());
            postService.create(post);
        }
    }
}
