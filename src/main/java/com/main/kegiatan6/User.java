package com.main.kegiatan6;

import com.main.kegiatan6.admin.Book;
import com.main.kegiatan6.student.Student;

import java.util.ArrayList;

public class User {

    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<ArrayList<String>> borrowBooks = new ArrayList<>();

    public static String loginStudent;
}