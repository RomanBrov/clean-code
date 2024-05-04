package org.robotdreams.patterns.lesson10.theory.moderqueries06;

import org.robotdreams.patterns.lesson10.theory.apimodels.SocialNetworkPostApi;

public class FindPostsQuery implements IQuery<SocialNetworkPostApi[]> {
    private final String searchText;
    private final int limit;

    public FindPostsQuery(String searchText, int limit) {
        this.searchText = searchText;
        this.limit = limit;
    }

    public String getSearchText() {
        return searchText;
    }

    public int getLimit() {
        return limit;
    }
}
