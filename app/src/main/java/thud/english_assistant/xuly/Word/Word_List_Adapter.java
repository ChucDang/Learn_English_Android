package thud.english_assistant.xuly.Word;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.List;

import thud.english_assistant.R;

public class Word_List_Adapter extends RecyclerView.Adapter<Word_List_Adapter.ViewHolder> {
    private List<Word> wordsByTopic;
    private WordRepository wordRepository;
    private Context context;

    public Word_List_Adapter(Context context, List<Word> words) {
        this.context = context;
        wordRepository = new WordRepository(context);
        try{
            wordRepository.insertListWord(words);
        }catch (Exception e){
            Log.i("Thông Báo", "Lỗi");
        }

    }

    public List<Word> getWords() {
        wordsByTopic= wordRepository.ListAllWord();
        return wordsByTopic;
    }

    @NonNull
    @Override
    public Word_List_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_cell_word, parent, false);

        return new Word_List_Adapter.ViewHolder(view);
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
    public void onBindViewHolder(@NonNull Word_List_Adapter.ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.getWord().setText(wordsByTopic.get(position).getName());
        holder.getMeant().setText(wordsByTopic.get(position).getMeant());
        holder.getType().setText(wordsByTopic.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return wordRepository.ListAllWord().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView word;
        private final TextView meant;
        private final TextView type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.txt_word);
            meant=itemView.findViewById(R.id.txt_meant);
            type=itemView.findViewById(R.id.txt_type);
        }

        public TextView getWord() {
            return word;
        }

        public TextView getMeant() {
            return meant;
        }

        public TextView getType() {
            return type;
        }
    }
}
