package main;

import dao.SachDAO;
import model.Sach;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DemoEtl {
    public static void main(String[] args) throws SQLException {
        long t1 = System.currentTimeMillis();
        //Extract data from "Sach" table in "nhasach" database
        List<Sach> listBook = SachDAO.getInstance().selectAll();
        System.out.println("Number of records extracted: "+ listBook.size());

        //Filter all books with price greater than or equal to 50000
        Queue<Sach> queue = new LinkedList<>();
        listBook.stream()
                .filter(s -> s.getGiaBan()>=50000)
                .forEach(queue::add);
        System.out.println("Number of records after processing: "+queue.size());

        //Load processed data into "Book" table in "bookstore" database
        int result = SachDAO.loadTable(queue, queue.size());
        long t2 = System.currentTimeMillis();
        double t = (double) (t2 -t1)/1000;
        System.out.println("Number of records loaded: "+ result);
        System.out.println("Time to ETL: "+t+ "s");
    }
}
