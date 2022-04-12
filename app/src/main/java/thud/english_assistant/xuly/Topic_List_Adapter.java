package thud.english_assistant.xuly;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.List;

import thud.english_assistant.R;
import thud.english_assistant.Topic;

public class Topic_List_Adapter extends RecyclerView.Adapter<Topic_List_Adapter.ViewHolder> {
    private List<Topic> topics;
    private Context context;
    public Topic_List_Adapter(Context context, List<Topic> topics) {
        this.topics = topics;
        this.context = context;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_grid_cell, parent, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.getTextView().setText(topics.get(position).getName_topic());
        Field resId;
        try {
             resId = R.mipmap.class.getDeclaredField(topics.get(position).getImg());
            holder.getImageView().setImageResource(resId.hashCode());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Log.i("Lỗi ảnh","Không tải được ảnh");
        }

    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imageView);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

    }
}
