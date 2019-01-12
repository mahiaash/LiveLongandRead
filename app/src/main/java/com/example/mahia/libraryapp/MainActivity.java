package com.example.mahia.libraryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list);
        Book americanGods = new Book("American Gods","Neil Gaiman","0380789035","drawable://" + R.drawable.american_gods);
        Book strangeAndNorrel = new Book("Johnathan Strange and Mr.Norrell","Susanna Clarke","1582344167","drawable://" + R.drawable.johnathan_strange_and_mr_norrel);
        Book norse = new Book("Norse Mythology","Neil Gaiman","0393356183","drawable://" + R.drawable.norse_mythology);

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(americanGods);
        bookList.add(strangeAndNorrel);
        bookList.add(norse);
    }
}
