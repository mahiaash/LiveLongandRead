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

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

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
        loadingPic();
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
          holder.picture = (ImageView) convertView.findViewById(R.id.bookPic);
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

        int failed = pcontext.getResources().getIdentifier("@drawable/failed",null,pcontext.getPackageName());
        ImageLoader imageLoader = ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(failed)
                .showImageOnFail(failed)
                .showImageOnLoading(failed).build();
        imageLoader.displayImage(image,holder.picture,options);
        holder.title.setText(title);
        holder.author.setText(author);
        holder.isbn.setText(isbn);
        return convertView;
    }


    public void loadingPic(){
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                pcontext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}


