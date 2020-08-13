package no.phasfjo.erasures;

public class UncompilableException extends Exception{

    public UncompilableException(){
         unCompile();
    }

    private void unCompile(){
        try {
            System.out.println("Oh no its crashing ....");
            throw new UncompilableException();

        }catch (UncompilableException e){
            e.printStackTrace();
        }
    }
}
