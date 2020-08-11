package erasures;

public class UncompilableException extends Exception{

    public UncompilableException(){
     uncompile();
    }

    private void uncompile(){
        try {
            throw new UncompilableException();
        }catch (UncompilableException e){
            e.printStackTrace();
        }
    }
}
