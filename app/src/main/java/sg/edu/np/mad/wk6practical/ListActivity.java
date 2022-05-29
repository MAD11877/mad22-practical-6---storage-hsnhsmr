package sg.edu.np.mad.wk6practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        TextView name = findViewById(R.id.name);
        TextView desc = findViewById(R.id.description);
        Intent intent = getIntent();
        String n = intent.getStringExtra("name");
        name.setText(n);
        String d = intent.getStringExtra("desc");
        desc.setText(d);


        User u = new User();
        Button b = findViewById(R.id.button);
        if (u.followed == true)
            b.setText("Unfollow");
        else
            b.setText("Follow");
        TextView id = findViewById(R.id.id);
        id.setText(id.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.button) {
                    if (u.followed == false) {
                        //content.followed = true;
                        //db.updateUser(u);
                        b.setText("Unfollow");
                        //Toast.makeText(c, "followed", Toast.LENGTH_LONG).show();
                    } else {
                        //content.followed = false;
                        b.setText("Follow");
                        //db.updateUser(u);
                        //Toast.makeText(c, "unfollowed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}