package no.phasfjo.intersectiontype;

import java.io.*;

public class IntersectionType {

    public IntersectionType() throws Exception {
        run();
    }
    private void run() throws Exception{
        Runnable helloWorld = (Runnable & Serializable)() ->
        {
            System.out.println("Hello World");
        };
        helloWorld.run(); //First hello world

        File file = File.createTempFile("runnable", "tmp");
        file.deleteOnExit();
        writeTofFile(file, helloWorld);

        final Runnable runnable = (Runnable) readFromFile(file);
        runnable.run(); // second hello world
    }

    private void writeTofFile(final File file, Object object) throws IOException{
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(object);
        }
    }

    private Object readFromFile(final File file) throws Exception {
       try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
           return objectInputStream.readObject();
       }
    }

}
