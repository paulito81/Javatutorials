package refeiables;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reifiable {

    public Reifiable(){
        parametervalue();
        wildcards();
        typeparameters();
        parameterized();
    }

    private void parameterized(){
        final ParameterizedType arrayListOfStrings = (ParameterizedType) StringList.class.getGenericSuperclass();
        System.out.println(Arrays.toString(arrayListOfStrings.getActualTypeArguments()));
    }

    public static class StringList extends ArrayList<String>{
    }

    private void parametervalue(){
        System.out.println(int.class);
        System.out.println(String.class);
        System.out.println(Boolean.class);
    }
    private void wildcards(){
        List<?> wildcards = new ArrayList<>();
        System.out.println(wildcards.getClass());
        List raw = new ArrayList();
        System.out.println(raw.getClass());
        System.out.println(raw.getClass() == wildcards.getClass());
        System.out.println(int[].class);
        System.out.println(List[].class);
    }
    private void typeparameters() {
        List<String> strings = new ArrayList<>();
        Class<?> arrayList = strings.getClass();
        final TypeVariable<? extends  Class<?>> [] typeParameters =
                arrayList.getTypeParameters();
        System.out.println(Arrays.toString(typeParameters));
    }


    private void typeparametersjava8(){
        List<String> strings = new ArrayList<>();
        Class<?> arrayList = strings.getClass();
        System.out.println(arrayList.toGenericString());
    }
}
