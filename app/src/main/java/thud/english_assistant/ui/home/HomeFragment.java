package thud.english_assistant.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import thud.english_assistant.MainActivity;
import thud.english_assistant.R;
import thud.english_assistant.xuly.Topic.Topic;
import thud.english_assistant.xuly.Topic.Topic_List_Adapter;

public class HomeFragment extends Fragment{
    private RecyclerView rvItems;
    private Topic_List_Adapter topics;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic(0,"Book","ic_book"));
        topics.add(new Topic(1,"Food","ic_food"));
        topics.add(new Topic(2,"Transport","ic_transport"));
        topics.add(new Topic(3,"People","ic_people"));
        topics.add(new Topic(4,"Job","ic_job"));
        topics.add(new Topic(5,"Signal","ic_signal"));
        topics.add(new Topic(6,"Building","ic_building"));
        rvItems =view.findViewById(R.id.TopicRecyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 2);
        rvItems.setLayoutManager(layoutManager);
        rvItems.setHasFixedSize(true);
        rvItems.setAdapter(new Topic_List_Adapter(view.getContext(), topics));
        rvItems.addOnItemTouchListener(
                new RecyclerTopicClickListener(getContext(), rvItems ,new RecyclerTopicClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        WordListFragment fragment1 = new WordListFragment();
                        FragmentManager fragmentManager = getParentFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, fragment1);
                        fragmentTransaction.setReorderingAllowed(true).commit();
                        }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}