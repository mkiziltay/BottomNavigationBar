package com.fragment.bottomdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    private final int  ID_Home = 1;
    private final int   ID_Message = 2;
    private final int  ID_Notification = 3;
    private final int  ID_Account = 4;

    TextView selected_page;
    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selected_page = findViewById(R.id.selPage);
        bottomNavigation = findViewById(R.id.bottomNav);
// add navigation item resources
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Home,R.drawable.home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Message,R.drawable.message_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Notification,R.drawable.notify_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Account,R.drawable.account_24));

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
   // Toast message : when clicked.
                Toast.makeText(getApplicationContext(),"clicked item : "+item.getId(),Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                String name;
                switch (item.getId()){

                    case ID_Home: name="Home";
                    break;

                    case ID_Message: name="Message";
                    break;

                    case ID_Notification: name="Notification";
                    break;

                    case ID_Account: name="Account";
                    break;

                    default: name="";
                }
  //set TextView with source name.
                selected_page.setText(name+" page is selected");
            }
        });
        
   // set default page when start
        bottomNavigation.show(ID_Account,true);
  // will show 4 to top of ID_Notification Icon
        bottomNavigation.setCount(ID_Notification,"4");

    }
}
