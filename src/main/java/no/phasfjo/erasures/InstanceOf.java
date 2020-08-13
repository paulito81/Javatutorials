package no.phasfjo.erasures;

public class InstanceOf<T> {

    public boolean equals(Object o){
        if( o instanceof InstanceOf){
            return true;
        }
        return false;
    }
}
