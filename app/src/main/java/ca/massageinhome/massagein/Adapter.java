package ca.massageinhome.massagein;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;
    private CardView cardView;
    private List<CardView> mViews;
    private float baseElevation;
    int MAX_ELEVATION_FACTOR = 8;

    public Adapter(List<Model> models, Context context,List<CardView> mViews)
    {
        this.models = models;
        this.context = context;
        this.mViews = mViews;
    }
    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
    public float getBaseElevation(){
        return baseElevation;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.all_events_layout,container,false);

        TextView title,details;
        ImageView image;
        Button book;

        image = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        details = view.findViewById(R.id.details);
        book = view.findViewById(R.id.book);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(context,"Hello "+String.valueOf(position),Toast.LENGTH_LONG);
                toast.show();
                context.startActivity(new Intent(context,BookingActivity.class));
            }
        });

        image.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        details.setText(models.get(position).getDetails());

        cardView = view.findViewById(R.id.custom_card_view);

        if(baseElevation == 0){
            baseElevation = cardView.getCardElevation();
        }
        cardView.setMaxCardElevation(baseElevation * MAX_ELEVATION_FACTOR);

        mViews.add(position,cardView);
        container.addView(view , 0);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
