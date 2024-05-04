package org.robotdreams.patterns.lesson10.theory.moderqueries06;

import org.robotdreams.patterns.lesson10.theory.apimodels.SocialNetworkPostApi;
import org.robotdreams.patterns.lesson10.theory.auxiliary.SocialNetworkPostService;

public class FindPostsQueryHandler implements IQueryHandler<FindPostsQuery, SocialNetworkPostApi[]> {
    private final SocialNetworkPostService socialNetworkPostService;

    public FindPostsQueryHandler(SocialNetworkPostService socialNetworkPostService) {
        this.socialNetworkPostService = socialNetworkPostService;
    }

    @Override
    public SocialNetworkPostApi[] handle(FindPostsQuery query) {
        return socialNetworkPostService.find(query.getSearchText(), query.getLimit());
    }
}
