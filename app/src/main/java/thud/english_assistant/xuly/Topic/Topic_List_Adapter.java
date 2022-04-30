package thud.english_assistant.xuly.Topic;
import android.content.Context;
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

public class Topic_List_Adapter extends RecyclerView.Adapter<Topic_List_Adapter.ViewHolder> {
    private List<Topic> topics;
    private TopicRepository topicRepository;
    private Context context;
    public Topic_List_Adapter(Context context, List<Topic> topics) {
        this.topics = topics;
        this.context = context;
        topicRepository = new TopicRepository(context);
        topicRepository.insertListTopic(topics);
        topics=topicRepository.ListAllTopic();
    }

    public List<Topic> getTopics() {
        return topics;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_cell_topic, parent, false);

        return new ViewHolder(view);
    }
    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.getTextView().setText(topicRepository.ListAllTopic().get(position).getName_topic());
        holder.getImageView().setImageResource(getResId(topicRepository.ListAllTopic().get(position).getImg(),R.mipmap.class));

    }

    @Override
    public int getItemCount() {
        return topicRepository.ListAllTopic().size();
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
