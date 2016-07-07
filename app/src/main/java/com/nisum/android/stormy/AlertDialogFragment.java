package com.nisum.android.stormy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by gaspar on 07-07-16.
 */
public class AlertDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Ooops!")
                .setMessage("Please try again")
                .setPositiveButton("OK",null);
        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }
}
