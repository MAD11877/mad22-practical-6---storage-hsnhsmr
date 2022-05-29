package sg.edu.np.mad.wk6practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*SharedPreferences pref = getSharedPreferences("p03", MODE_PRIVATE);
        String text = pref.getString("KEY", "Not found");

        TextView txt = findViewById(R.id.textView);
        txt.setText(text);

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("KEY", "Hello P03");
        editor.apply(); */
        User u = new User();
        ArrayList<User> data = new ArrayList<>();
        DBHandler db = new DBHandler(this);
        for (int i=0; i<20; i++){

            Random r = new Random();
            int randomNo = r.nextInt(10000000+1000000 + 1) - 10000000;
            int randomNo2 = r.nextInt(10000000+1000000 + 1) - 10000000;

            u.name = "Name" + randomNo;
            u.description = "Description" + randomNo2;
            u.id =  i + 1;
            u.followed = r.nextBoolean();
            //data.add(u);
            db.insertUser(u);
        }
        data = db.getUsers();

        /*
        User u = new User();
        Random r = new Random();
        int randomNo = r.nextInt(10000000+1000000 + 1) - 10000000;
        int randomNo2 = r.nextInt(10000000+1000000 + 1) - 10000000;

        u.name = "Name" + randomNo;
        u.description = "Description" + randomNo2;
        u.id = 1;
        u.followed = true;
        db.insertUser(u); */


        RecyclerView rv = findViewById(R.id.RecyclerView);
        UserAdapter adapter = new UserAdapter(MainActivity.this, data);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);



    }
}