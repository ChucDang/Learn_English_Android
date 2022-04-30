package thud.english_assistant.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import thud.english_assistant.R;
import thud.english_assistant.xuly.Word.Word;
import thud.english_assistant.xuly.Word.Word_List_Adapter;
public class WordListFragment extends Fragment {
    Word_List_Adapter words;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_words, container, false);
        List<Word> words = new ArrayList<>();
        words.add(new Word("Book","Go","Đi chơi","Verb"));

        RecyclerView rvItem = view.findViewById(R.id.WordRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        rvItem.setLayoutManager(layoutManager);
        rvItem.setHasFixedSize(true);
        try{

            rvItem.setAdapter(new Word_List_Adapter(view.getContext(), words));
            return view;
        }catch(Exception e){
            Log.i("Thông Báo",e.toString());
        }
        return view;
    }
}