package persons;

import model.Person;

import java.io.*;

public class PersonReader {

    private static final String FILE_PATH = "src/main/resources/person.txt";

    public PersonReader() throws FileNotFoundException{
        create1();
       //  create2();
    }

    private void create() throws FileNotFoundException {
        DataInputStream stream = new DataInputStream(new FileInputStream(FILE_PATH));
        Person person = read(stream);
        System.out.println(person);
    }


    private void create1() throws FileNotFoundException {
        DataInputStream stream = new DataInputStream(new FileInputStream(FILE_PATH));
        Person p = reads(stream);
        System.out.println(p);
    }
    private void create2()throws FileNotFoundException{
        RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_PATH, "rw");
        Person person = read(randomAccessFile);
        System.out.println(person);

    }



    private Person reads(final DataInputStream stream) {
        StringBuilder val = new StringBuilder();
        StringBuilder num = new StringBuilder();
        try {
            while (stream.available() > 0) {
                String str = Character.toString((char) stream.read());

                if(!str.matches("[^a-zA-Z]")){
                    val.append(str);
                }
                else if(str.matches("[^a-zA-Z,]")){
                    num.append(str);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Person(val.toString(),  Integer.parseInt(num.toString().strip()));
    }

    //TODO Does not work only returns numbers
    private <T extends DataInput & Closeable> Person read(final T source)
    {
        try(T inputStream = source)
        {
            //UTF for name and READINT for age
          return new Person(inputStream.readUTF(), inputStream.readInt());
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
