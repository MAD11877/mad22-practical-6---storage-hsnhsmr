package sg.edu.np.mad.wk6practical;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView Name;
    TextView Description;
    View Viewitem;
    ImageView Image;


    public UserViewHolder(View item){
        super(item);
        Viewitem = item;
        Name = item.findViewById(R.id.name);
        Description = item.findViewById(R.id.description);
        Image = item.findViewById(R.id.imageView2);
    }
}
