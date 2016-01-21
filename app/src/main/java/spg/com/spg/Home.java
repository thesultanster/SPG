package spg.com.spg;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Home extends NavigationDrawerFramework {

    TabLayout tabLayout;
    TextView fadeTitle;
    TextView fadeBody;
    LinearLayout ciscoCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getToolbar().setTitle("HOME");

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("MY SPG"));
        tabLayout.addTab(tabLayout.newTab().setText("MY STAYS"));

        fadeTitle = (TextView) findViewById(R.id.fadeTitle);
        fadeBody = (TextView) findViewById(R.id.fadeBody);
        ciscoCard = (LinearLayout) findViewById(R.id.ciscoCard);

        ciscoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SPGWifiActivity.class);
                startActivity(intent);
            }
        });



        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
        fadeIn.setDuration(1200);
        fadeIn.setFillAfter(true);
        fadeIn.setStartOffset(800);

        fadeTitle.setAnimation(fadeIn);
        fadeBody.setAnimation(fadeIn);


    }
}
