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

import java.util.List;

import thud.english_assistant.R;
import thud.english_assistant.Topic;
import thud.english_assistant.databinding.CustomGridCellBinding;
import thud.english_assistant.databinding.FragmentGalleryBinding;
import thud.english_assistant.databinding.FragmentHomeBinding;
import thud.english_assistant.xuly.Topic_List_Adapter;

public class HomeFragment extends Fragment{

    private Topic_List_Adapter topics;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        recyclerView.setAdapter(topics);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}