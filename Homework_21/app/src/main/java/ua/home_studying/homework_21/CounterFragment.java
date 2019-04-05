package ua.home_studying.homework_21;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {

    private TextView counterTextView;
    private final static String COUNTER_STATE = "counter";
    private int counter = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_counter, container, false);
        counterTextView = fragmentView.findViewById(R.id.text_view_counter);
        count();
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null){
            counterTextView.setText(savedInstanceState.getString(COUNTER_STATE));
        } else counterTextView.setText(counter);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(COUNTER_STATE, counterTextView.getText().toString());
    }

    private void count(){
        while (true){
            counter++;
        }
    }


}
