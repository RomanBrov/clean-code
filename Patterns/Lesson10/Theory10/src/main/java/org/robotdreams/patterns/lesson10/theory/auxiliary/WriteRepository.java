package org.robotdreams.patterns.lesson10.theory.auxiliary;

import com.google.gson.GsonBuilder;
import org.dozer.DozerBeanMapper;

public class WriteRepository<TApi, TModel> {
    private final DozerBeanMapper mapper;
    private final Class<TModel> modelType;

    public WriteRepository(DozerBeanMapper mapper, Class<TModel> modelType) {
        this.mapper = mapper;
        this.modelType = modelType;
    }

    public void create(TApi entity) {
        TModel item = mapper.map(entity, modelType);

        System.out.println("Item of type " + item.getClass() + " created:");
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(item));
    }
}
