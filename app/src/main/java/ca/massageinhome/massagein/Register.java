package ca.massageinhome.massagein;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import de.hdodenhof.circleimageview.CircleImageView;

public class Register extends AppCompatActivity {

    private ProgressDialog loadingBar;
    final static int GalleryPic=1;
    CircleImageView circleImageView;
    ImageButton addPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loadingBar =new ProgressDialog(this);

        circleImageView = findViewById(R.id.circleImage);
        addPhoto = findViewById(R.id.add_photo);

        //This click will redirect to Gallery where you can find Images only...
        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,GalleryPic); //User will pick the Picture...
            }
        });
    }

    //This method onActivityResult checks whether the image is right.....
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        //this checks the checked imaged,so there should be no null image...
        if(requestCode== GalleryPic && resultCode == RESULT_OK && data != null) {
            Uri ImageUri = data.getData();             //here we getting the image.....in ImageUri

            //When the user Select the image he will be redirected to the Image Cropping Activity...
            CropImage.activity(ImageUri)
                    .setAspectRatio(1,1)
                    .setCropShape(CropImageView.CropShape.OVAL)
                    .start(this);
        }
        //THIS CHECKS WHETHER WE SELECT THE CROP OPTION...
        if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE)
        {
            //HERE WE GETTING CROPPED IMAGE...
            CropImage.ActivityResult result= CropImage.getActivityResult(data);

            if(resultCode == RESULT_OK) //IF CROPPING SUCCESSFULL...
            {
                loadingBar.setTitle("Saving Information");
                loadingBar.setMessage("Please wait until we update your Profile Image");
                loadingBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                loadingBar.show();
                loadingBar.setCanceledOnTouchOutside(true);

                //THIS OBJECTS CONTAINS THE CROPPED IMAGE....
                Uri resultUri =result.getUri();
                Picasso.get().load(resultUri).into(circleImageView);
                addPhoto.setVisibility(View.GONE);
                loadingBar.dismiss();
            }

            else{
                //IF THE IMAGE IS UNABLE TO CROP...
                Toast.makeText(Register.this, "Error Occurred : Image can't be Cropped,Try Again." , Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();
            }

        }
        //else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE)
    }
}
