import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.example.mac.tabsapp.R;


/**
 * Created by mac on 12‏/12‏/2016.
 */

public class ImageHolder {

    public static void downloadImage(Context c, String imageUrl, ImageView img) {
        if (imageUrl.length() > 0) {
               /* Transformation transformation = RoundedTransformationBuilder()
                        .borderColor(Color.BLACK)
                        .borderWidthDp(3)
                        .cornerRadiusDp(30)
                        .oval(false)
                        .build();*/

            // PicassoClient.with(c).load(imageUrl).resize(300,300).transform(new RoundedTransform()).placeholder(R.drawable.placeholder).into(img);
            Picasso.with(c).load(imageUrl).resize(150, 150).placeholder(R.drawable.common_full_open_on_phone).into(img);

        } else {
            Picasso.with(c).load(R.drawable.common_full_open_on_phone).into(img);
        }
    }
}

