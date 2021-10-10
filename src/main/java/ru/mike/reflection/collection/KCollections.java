package ru.mike.reflection.collection;

import ru.mike.reflection.collection.type.handler.CollectionType;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class KCollections {

    public static Collection getCollectionInstanceByType(Type type) throws RuntimeException {
        if (isCollection((Class<?>) type)) {
            return CollectionType.getCollectionType().getNewCollectionInstance(type);
        }

        throw new RuntimeException(String.format("Can't find comparable collection for inject for type:%s. " +
                "It's not a collection", type.getTypeName())
        );
    }

    public static boolean isCollection(Class<?> clazz) {
        return Collection.class.isAssignableFrom(clazz);
    }

    public static boolean isList(Class<?> clazz) {
        return List.class.equals(clazz);
    }

    public static boolean isSet(Class<?> clazz) {
        return Set.class.equals(clazz);
    }
}
