package com.example.mahia.libraryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class BookListAdapter extends ArrayAdapter<Book>{
    private Context pcontext;
    int presource;
    private int lastPosition = -1;

    static class ViewHolder {
        TextView title;
        TextView author;
        TextView isbn;
        ImageView picture;

    }

    public BookListAdapter(Context context, int resource, ArrayList<Book> objects) {
        super(context, resource, objects);
        pcontext = context;
        presource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      String title = getItem(position).getBookname();
      String author = getItem(position).getAuthor();
      String isbn = getItem(position).getNumber();
      String image = getItem(position).getPicture();

      Book book = new Book(title,author,isbn,image);
        final View result;

        ViewHolder holder;
        holder = new ViewHolder();
      if (convertView == null){
          LayoutInflater inflater = LayoutInflater.from(pcontext);
          convertView = inflater.inflate(presource,parent,false);
          TextView titleView = convertView.findViewById(R.id.title);
          TextView authorView = convertView.findViewById(R.id.author);
          TextView isbnView = convertView.findViewById(R.id.ibsn);

          titleView.setText(title);
          authorView.setText(author);
          isbnView.setText(isbn);

          result = convertView;
          holder.picture = (ImageView) convertView.findViewById(R.id.bookPic);
          holder.title = (TextView) convertView.findViewById(R.id.title);
          holder.author = (TextView) convertView.findViewById(R.id.author);
          holder.isbn = (TextView) convertView.findViewById(R.id.ibsn);
          convertView.setTag(holder);
      }
      else{
          holder = (ViewHolder) convertView.getTag();
          result = convertView;
      }
        Animation animation = AnimationUtils.loadAnimation(pcontext,
                (position > lastPosition) ? R.anim.loading_down_anim : R.anim.loading_up_anim);
        result.startAnimation(animation);
        lastPosition = position;


        holder.title.setText(title);
        holder.author.setText(author);
        holder.isbn.setText(isbn);
        return convertView;
    }
}
