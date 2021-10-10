package ru.mike.reflection.collection.type.handler;

import ru.mike.reflection.KReflections;
import ru.mike.reflection.collection.KCollections;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListHandler implements ICollectionHandler {
    @Override
    public boolean isAssignableFromCollection(Type type) {
        return List.class.isAssignableFrom((Class<?>) type);
    }

    @Override
    public <T extends Collection> T getNewCollectionInstance(Type type) {
        if (KCollections.isList((Class<?>) type)) {
            return (T) new ArrayList();
        } else {
            return KReflections.newInstance((Class<?>) type);
        }
    }
}
