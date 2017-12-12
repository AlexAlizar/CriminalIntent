package alizarchik.alex.criminalintent.Dialogs;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import alizarchik.alex.criminalintent.Utils.PictureUtils;
import alizarchik.alex.criminalintent.R;

/**
 * Created by aoalizarchik.
 */

public class PhotoFragment extends DialogFragment {

    private static final String ARG_PATH = "path";

    public static PhotoFragment newInstance(String path) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PATH, path);

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String path = (String) getArguments().getSerializable(ARG_PATH);

        @SuppressLint("InflateParams") View v = LayoutInflater.from(getActivity()).inflate(R.layout.photo_view, null);

        ImageView imageView = v.findViewById(R.id.photo_dialog);
        Bitmap bitmap = PictureUtils.getScaledBitmap(path, getActivity());
        imageView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
//                .setTitle(R.string.)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        getActivity().finish();
                    }
                })
                .create();
    }
}
