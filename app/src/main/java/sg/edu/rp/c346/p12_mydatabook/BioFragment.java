package sg.edu.rp.c346.p12_mydatabook;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class BioFragment extends Fragment {

    Button btnBio;
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.biofragment, container, false);

        btnBio = view.findViewById(R.id.btnFragBio);
        tv = view.findViewById(R.id.textView);

        SharedPreferences pref1 = getActivity().getPreferences(Context.MODE_PRIVATE);
        if(pref1.contains("bio")){
            String bio = pref1.getString("bio", "empty");
            tv.setText(bio);
        }

        btnBio.setOnClickListener((v)->{
            AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

            LayoutInflater inflate = this.getLayoutInflater();
            View dialogView = inflate.inflate(R.layout.alert_label_editor, null);
            alert.setView(dialogView);
            EditText editText = (EditText) dialogView.findViewById(R.id.label_field);
            editText.setText(tv.getText());

            alert.setPositiveButton("Ok", (dialog, id) -> {
                // User clicked OK button
                tv.setText(editText.getText());

                SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor edt = pref.edit();
                edt.putString("bio", editText.getText().toString());
                edt.commit();
            });
            alert.setNegativeButton("Cancel", (dialog, id) -> {
                // User cancelled the dialog
            });

            alert.setTitle("Edit Bio");

            AlertDialog dialog = alert.create();
            dialog.show();

        });

        return view;
    }


}
