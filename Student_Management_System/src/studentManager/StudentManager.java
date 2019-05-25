package studentManager;

import dao.studentDao;
import org.junit.Test;

import java.io.IOException;

public class StudentManager {
    private studentDao studentDao = new studentDao();

    public void showAllStudents() {

    }

    public void addStudent() throws  IOException {
        studentDao.add();
    }
    @Test
    public void test() throws IOException {
     addStudent();
    }

    public static void main(String[] args) throws IOException {
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent();
    }
}
