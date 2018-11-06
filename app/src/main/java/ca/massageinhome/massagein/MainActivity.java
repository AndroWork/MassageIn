package ca.massageinhome.massagein;

import android.app.Activity;
import android.app.Dialog;
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
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Dialog dialog;
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



        CardView sweedish = findViewById(R.id.sweedish);
        CardView deeptissue = findViewById(R.id.deeptissue);
        CardView sports = findViewById(R.id.sports);
        CardView prenatal = findViewById(R.id.prenatal);



          sweedish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descp = "In Sweden this massage is also called classic massage. It is a classic treatment that is based on western standards. Five techniques used in this type of massage are; stroking and gliding, kneading, rubbing, tapping or pounding, and vibrating. These are the things that come to mind when you think about Swedish classic massage.";
                showDialog(MainActivity.this,"Sweedish",R.drawable.sweedish,descp);
            }
        });


        deeptissue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descp = "If you have persisting pain and muscle aches, it is the right time to contact us for deep tissue massage. Our expert therapists will use deliberate and slow pressure to reach deep layers of tissues and muscles. This massage is good for chronic aches and pain in areas such as neck, upper back, leg muscle tightness, lower back pain, and sore shoulders.";
                showDialog(MainActivity.this,"Deep Tissue",R.drawable.deeptissue,descp);
            }
        });


        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descp = "This is what you need if you are part of a sports. This massage helps your tissue and prepare body and mind for better performance when you are in the field. This improves endurance and flexibility, which prevents injury and muscle soreness. It is a best for those who are regularly involved in sports.";
                showDialog(MainActivity.this,"Sports",R.drawable.sports,descp);
            }
        });


        prenatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descp = "A massage for pregnant women! It takes away the strain from your tired muscles and joints. It can also help improve blood circulation and reduce any swelling that you have been having lately. This therapy is based on individual needs which ensures best treatment.";
                showDialog(MainActivity.this,"Prenatal",R.drawable.prenatal,descp);
            }
        });




    }

    public void showDialog(Activity activity,String text_data,int image_data,String details_data){
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_layout);


        TextView text = dialog.findViewById(R.id.text_data);
        ImageView image = dialog.findViewById(R.id.image_data);
        TextView details = dialog.findViewById(R.id.details_data);

        text.setText(text_data);
        image.setImageResource(image_data);
        details.setText(details_data);

        ImageView cancelDialog = dialog.findViewById(R.id.cancel_dialog);
        cancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        /*Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });*/

        dialog.show();

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
