package ca.massageinhome.massagein;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Piyush on 2/20/2018.
 */

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyViewHolder>{
    public static ArrayList<Model> data = new ArrayList<>();
    LayoutInflater inflater;
    Context context;

    public BookingAdapter(Context context){
        //data.add(new HelperResource("Vaibhav Verma","Mechanic","Roorkee"));
      //  data.add( new HelperResource("Piyush Bhatt","Electrician","Roorkee"));
        inflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public BookingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.my_bookings_row, parent, false);
        BookingAdapter.MyViewHolder holder = new BookingAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BookingAdapter.MyViewHolder holder, int position) {
        holder.massageTypeText.setText(data.get(position).getMassageType());
        holder.durationText.setText(data.get(position).getDuration());
        holder.therapistText.setText(data.get(position).getTherapist());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView massageTypeText;
        TextView durationText;
        TextView therapistText;


        public MyViewHolder(View itemView) {
            super(itemView);
          massageTypeText = itemView.findViewById(R.id.massage_type_id);
          durationText= itemView.findViewById(R.id.duration_id);
            therapistText = itemView.findViewById(R.id.therapist_id);
          }
     }
}

