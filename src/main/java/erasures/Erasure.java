package erasures;

import java.util.List;

// Drops metadata into the descriptor
public class Erasure<T, B extends Comparable<B>>
{

    public void unbounded(T param){
    }

    public void lists(List<String> param, List<List<T>> param2)
    {

        String s = param.get(0);
    }

    public void bounded(B param){

    }
}
