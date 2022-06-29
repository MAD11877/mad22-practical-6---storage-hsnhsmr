package sg.edu.np.mad.wk6practical;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter
        extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> data;
    Context c;
    public UserAdapter(Context c, ArrayList<User> data){
        this.c = c;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        /*User content = data.get(position);
        if (content.name.charAt(content.name.length() - 1) == '7')
        {
            return 0;
        }
        else
            return 1; */
        return position;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item  = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.user_layout, parent, false);

        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User content = data.get(position);
        //User u = new User();
        //DBHandler db = new DBHandler(c);
        holder.Name.setText(content.name);
        holder.Description.setText(content.description);
        holder.Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(c, ListActivity.class);
                in.putExtra("name", content.name);
                in.putExtra("desc", content.description);
                c.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
