package ru.mike.reflection.collection.type.handler;

import ru.mike.reflection.KReflections;
import ru.mike.reflection.collection.KCollections;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SetHandler implements ICollectionHandler {
    @Override
    public boolean isAssignableFromCollection(Type type) {
        return Set.class.isAssignableFrom((Class<?>) type);
    }

    @Override
    public <T extends Collection> T getNewCollectionInstance(Type type) {
        if (KCollections.isSet((Class<?>) type)) {
            return (T) new HashSet<>();
        } else {
            return KReflections.newInstance((Class<?>) type);
        }
    }
}
