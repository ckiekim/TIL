package ck.dept;

import java.util.List;

public class DeptTest {

    public static void main(String[] args) {
        DeptDao dao = new DeptDao();
        List<Dept> list = dao.getDepts();
        list.forEach(d -> System.out.println(d));
    }

}
