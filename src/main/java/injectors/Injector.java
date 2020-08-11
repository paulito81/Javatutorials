package injectors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

// dependency injection framework
public class Injector {
    private Map<Class<?>, Object> objectGraph = new HashMap<>();

    //Save this specific value/class associated with the value
    public Injector with(Object value){
        objectGraph.put(value.getClass(), value);
        return this;
    }
    public Object newInstance(final String className){
        return null;
    }
    public <T> T newInstance(final Class<T> type){
        return (T) objectGraph.computeIfAbsent(type, this::instantiate);
    }

    private <T> Object instantiate(Class<T> type) {

        try{
            Constructor<?>[] constructors = type.getConstructors();
            if(constructors.length != 1){
                throw new IllegalArgumentException(type + " must only have 1 constructor");
            }

            Constructor<?> constructor = constructors[0];
            Object[] args = Stream.of(constructor.getParameterTypes())
                    .map(param -> (Object) newInstance(param))
                    .toArray();

            return constructor.newInstance(args);
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }

    }
}
