package thud.english_assistant.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import thud.english_assistant.R;
import thud.english_assistant.Topic;
import thud.english_assistant.databinding.CustomGridCellBinding;
import thud.english_assistant.databinding.FragmentGalleryBinding;
import thud.english_assistant.databinding.FragmentHomeBinding;
import thud.english_assistant.xuly.Topic_List_Adapter;

public class HomeFragment extends Fragment{
    private RecyclerView rvItems;
    private Topic_List_Adapter topics;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic(0,"Dang Van Chuc","ic_avatar"));
        topics.add(new Topic(1,"Dương Thị Lan","ic_food"));
        topics.add(new Topic(2,"Châu Gia Cường","ic_building"));
        rvItems =view.findViewById(R.id.RecyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 3);
        rvItems.setLayoutManager(layoutManager);
        rvItems.setHasFixedSize(true);
        rvItems.setAdapter(new Topic_List_Adapter(view.getContext(), topics));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}