package storage;




import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileStudent implements IReadWriteFileStudent {
    public static final String PATHNAME = "student.txt";

    @Override
    public List<Student> readFile() {
        File fileStudent = new File(PATHNAME);
        if (!fileStudent.exists()) {
            return getDefaultStudents();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileStudent))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
            return getDefaultStudents();
        }
    }

    @Override
    public void writeFile(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATHNAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    public List<Student> getDefaultStudents() {
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student("01","Quan",19,"Male","Bac Ninh",7));
        writeFile(listStudent);
        return new ArrayList<>();
    }
}

