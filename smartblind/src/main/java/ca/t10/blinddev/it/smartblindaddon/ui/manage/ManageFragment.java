package ca.t10.blinddev.it.smartblindaddon.ui.manage;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import ca.t10.blinddev.it.smartblindaddon.R;

public class ManageFragment extends Fragment {
    View root;
    private ManageViewModel mViewModel;
    Button delete,add,submit;
    Spinner selectblind;
    EditText loc,bkey,height;

    public static ManageFragment newInstance() {
        return new ManageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_manage, container, false);
        delete = root.findViewById(R.id.manage_delete_btn);
        add = root.findViewById(R.id.manage_add_btn);
        submit = root.findViewById(R.id.manage_submit_btn);
        selectblind = root.findViewById(R.id.manage_delete_select);
        loc = root.findViewById(R.id.manage_add_loc);
        bkey = root.findViewById(R.id.manage_add_bkey);
        height = root.findViewById(R.id.manage_add_height);

        applySettings();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ManageViewModel.class);
        // TODO: Use the ViewModel
    }
    public void applySettings(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("saved", Context.MODE_PRIVATE);

        boolean d = sharedPreferences.getBoolean("dark",false);
        boolean n = sharedPreferences.getBoolean("note",false);
        String t = sharedPreferences.getString("size","");

        if(d){enableDarkMode();}
        if(n){//function for notification
        }

        if (t.equals("large")){setTextSize(20);}
        if (t.equals("medium")){setTextSize(17);}
        if (t.equals("small")){setTextSize(13);}
    }
    public void setTextSize(int size){
        delete.setTextSize(size);
        add.setTextSize(size);
        submit.setTextSize(size);
        //TODO
        //add code for spinner when implemented
    }
    private void enableDarkMode() {
        root.setBackgroundColor(getResources().getColor(R.color.dark_grey));
        loc.setHintTextColor(getResources().getColor(R.color.white));
        bkey.setHintTextColor(getResources().getColor(R.color.white));
        height.setHintTextColor(getResources().getColor(R.color.white));
    }

}