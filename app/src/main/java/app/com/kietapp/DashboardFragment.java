package app.com.kietapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class DashboardFragment extends Fragment implements View.OnClickListener {

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard,container,false);
        Button attendanceBtn = view.findViewById(R.id.attendanceBtn);
        Button timetableBtn = view.findViewById(R.id.timetableBtn);
        Button marksBtn = view.findViewById(R.id.marksBtn);
        Button feedbackBtn = view.findViewById(R.id.feedbackBtn);


        attendanceBtn.setOnClickListener(this);
        timetableBtn.setOnClickListener(this);
        marksBtn.setOnClickListener(this);
        feedbackBtn.setOnClickListener(this);

        return view;
    }

    public void replaceFragment(Fragment someFragment) {
        assert getFragmentManager() != null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        Fragment fragment;
        switch (view.getId()) {
            case R.id.attendanceBtn:
                fragment = new AttendanceFragment();
                replaceFragment(fragment);
                break;

            case R.id.timetableBtn:
                fragment = new TimetableFragment();
                replaceFragment(fragment);
                break;

            case R.id.marksBtn:
                fragment = new MarksFragment();
                replaceFragment(fragment);
                break;

            case R.id.feedbackBtn:
                fragment = new FeedbackFragment();
                replaceFragment(fragment);
                break;
        }
    }
}