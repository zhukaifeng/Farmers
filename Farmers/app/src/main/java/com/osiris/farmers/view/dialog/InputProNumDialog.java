package com.osiris.farmers.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.osiris.farmers.R;

public class InputProNumDialog extends Dialog {
    public InputProNumDialog(Context context) {
        super(context);
    }

    public InputProNumDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {

        private Context context;
        private OnSaveClickListener onSaveClickListener;

        public Builder(Context context) {
            this.context = context;
        }


        /**
         * Set the positive button resource and it's listener
         *
         * @return
         */
        public Builder setOnSaveClickListener(OnSaveClickListener listener) {
            this.onSaveClickListener = listener;
            return this;
        }


        public InputProNumDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final InputProNumDialog dialog = new InputProNumDialog(context, R.style.MyDialog);
            View layout = inflater.inflate(R.layout.dialog_input_prodnum, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            EditText prodNumEt = layout.findViewById(R.id.prod_num);
            EditText prodPriceEt = layout.findViewById(R.id.prod_price);

            layout.findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String prodNum = prodNumEt.getText().toString();
                    String prodPrice = prodPriceEt.getText().toString();
                    if (TextUtils.isEmpty(prodNum)) {
                        Toast.makeText(context, "商品数量不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(prodPrice)) {
                        Toast.makeText(context, "商品单价不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    try {
                        double priceVal = Double.parseDouble(prodPrice);
                        int prodNumVal = Integer.parseInt(prodNum);
                        if (onSaveClickListener != null) {
                            onSaveClickListener.onSaveClick(prodNumVal, priceVal);
                        }
                    } catch (Exception e) {

                    }
                    dialog.dismiss();
                }
            });


            dialog.setContentView(layout);
            dialog.setCanceledOnTouchOutside(true);
            return dialog;
        }

        public interface OnSaveClickListener {
            void onSaveClick(int prodNum, double prodPrice);
        }
    }
}
