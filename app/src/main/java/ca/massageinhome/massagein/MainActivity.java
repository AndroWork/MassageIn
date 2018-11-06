package ca.massageinhome.massagein;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    private float lastOffset;
    float offset;
    ArrayList<CardView> mViews;
    private boolean scalingEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("   Massage In Home");

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Inflating Navigation Header in Navigation Menu....
        View view = navigationView.inflateHeaderView(R.layout.nav_header_main);
        CircleImageView userImage = findViewById(R.id.nav_user_image);
        TextView userName = findViewById(R.id.nav_user_name);
        TextView userEmail = findViewById(R.id.nav_user_email);






        models = new ArrayList<>();

        String sweedishDetails = "In Sweden this massage is also called classic massage. " +
                "It is a classic treatment that is based on western standards. " +
                "Five techniques used in this type of massage are; stroking and gliding, kneading, rubbing, tapping or pounding, and vibrating. " +
                "These are the things that come to mind when you think about Swedish classic massage.";

        String deeptissueDetails = "If you have persisting pain and muscle aches, it is the right time to contact us for deep tissue massage. " +
                "Our expert therapists will use deliberate and slow pressure to reach deep layers of tissues and muscles. " +
                "This massage is good for chronic aches and pain in areas such as neck, upper back, leg muscle tightness, lower back pain, and sore shoulders.";

        String sportsDetails = "This is what you need if you are part of a sports. " +
                "This massage helps your tissue and prepare body and mind for better performance when you are in the field. " +
                "This improves endurance and flexibility, which prevents injury and muscle soreness. " +
                "It is a best for those who are regularly involved in sports.";

        String prenatalDetails = "A massage for pregnant women! It takes away the strain from your tired muscles and joints. " +
                "It can also help improve blood circulation and reduce any swelling that you have been having lately. " +
                "This therapy is based on individual needs which ensures best treatment.";


        models.add(new Model(R.drawable.sweedish,"Sweedish",sweedishDetails));
        models.add(new Model(R.drawable.deeptissue,"Deeptissue",deeptissueDetails));
        models.add(new Model(R.drawable.sports,"Sports",sportsDetails));
        models.add(new Model(R.drawable.prenatal,"Prenatal",prenatalDetails));

        mViews = new ArrayList<>();
        mViews.add(null);
        mViews.add(null);
        mViews.add(null);
        mViews.add(null);

        adapter = new Adapter(models,this,mViews);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        //viewPager.setClipToPadding(false);
        //viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPadding(20,0,20,0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int realCurrentPosition;
                int nextPosition;
                float baseElevation = adapter.getBaseElevation();
                float realOffset;
                boolean goingLeft = lastOffset > positionOffset;

                // If we're going backwards, onPageScrolled receives the last position
                // instead of the current one

                if(goingLeft){
                    realCurrentPosition = position + 1;
                    nextPosition = position;
                    realOffset = 1-positionOffset;
                }else{
                    nextPosition = position + 1;
                    realCurrentPosition = position;
                    realOffset = positionOffset;
                }

                offset = realOffset;

                // Avoid crash on scroll
                if(nextPosition > adapter.getCount() - 1 || realCurrentPosition > adapter.getCount()-1){
                    return;
                }

                CardView currentCard = mViews.get(realCurrentPosition);

                // This might be null if a fragment is being used
                // and views weren't created yet

                if(currentCard != null){
                    if(scalingEnabled){
                        currentCard.setScaleX((float)(1+0.1*(1-realOffset)));
                        currentCard.setScaleY((float)(1+0.1*(1-realOffset)));
                    }
                    //  currentCard.setCardElevation((baseElevation + baseElevation *(slideAdapter.MAX_ELEVATION_FACTOR-1)* (1-realOffset)));
                }

                CardView nextCard = mViews.get(nextPosition);

                // We might be scrolling fast enough so that the next (or previous) card
                //was already destroyed or a fragmentmight not have been created yet
                if(nextCard != null){
                    if(scalingEnabled){
                        nextCard.setScaleX((float)(1+0.1*(realOffset)));
                        nextCard.setScaleY((float)(1+0.1*(realOffset)));
                    }
                }

                lastOffset = positionOffset;
            }

            @Override
            public void onPageSelected(int position) {

                Log.d("hello",String.valueOf(position));
                /*if(position == models.size()-1) {
                    viewPager.setCurrentItem(0);

                }*/
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
