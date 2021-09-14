package decorator.decorators;

import java.io.*;

public class FileDataSource implements DataSource{
    private String fileName;

    public FileDataSource(String name) {
        fileName = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(fileName);
        try (OutputStream fos =  new FileOutputStream(file)){
            fos.write(data.getBytes(), 0, data.length());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(fileName);
        try (FileReader reader = new FileReader(fileName)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }
}
