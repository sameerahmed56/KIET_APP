
package app.com.kietapp;

        import android.os.Bundle;

        import androidx.fragment.app.Fragment;

        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Spinner;
        import android.widget.Toast;

        import java.util.Objects;

public class MarksFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_marks, container, false);
        final String[] users = new String[]{ " ","CT-1","CT-2","PUE-1A","PUE-1B","PUE-2A","PUE-2B"};

        Spinner dropdown = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (users[i] == " "){
                    Log.d("marks","nothing");
                }
                else {
                    Toast.makeText(getActivity(), users[i] + " Selected", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("c","d");
            }
        });
        return  view;
    }
    public MarksFragment() {
        // Required empty public constructor
    }


}
