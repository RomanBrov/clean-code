package org.robotdreams.patterns.lesson10.theory.auxiliary;

import com.flextrade.jfixture.JFixture;
import org.dozer.DozerBeanMapper;

import java.util.*;
import java.util.stream.*;


public class ReadOnlyRepository<TApi, TModel> {
    private final DozerBeanMapper mapper;
    private final Class<TApi> apiType;
    private final Class<TModel> modelType;

    public ReadOnlyRepository(DozerBeanMapper mapper, Class<TApi> apiType, Class<TModel> modelType) {
        this.mapper = mapper;
        this.apiType = apiType;
        this.modelType = modelType;
    }

    public TApi[] findBy(Map<String, Object> parameters, int limit) {
        System.out.printf("Getting %d items of type %s%n", limit, apiType.getName());
        TApi[] results = IntStream.range(0, limit)
                .mapToObj(i ->
                                mapper.map(
                        // simulating reading real data from some source
                        new JFixture().create(modelType),
                                        apiType
                )
                )
                .toArray(size -> (TApi[]) java.lang.reflect.Array.newInstance(apiType, size));

        return results;
    }
}
