package ca.massageinhome.massagein;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class MyBookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   My Bookings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView bookingsRecyclerView = findViewById(R.id.recycler_my_bookings);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        bookingsRecyclerView.setLayoutManager(layoutManager);

        BookingAdapter adapter = new BookingAdapter(this);
        bookingsRecyclerView.setAdapter(adapter);
    }
}
