
package com.osiris.farmers.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.osiris.farmers.R;

/**
 * Created by zhukaifeng on 2018/04/08.
 */


public class ChooseRulesDialog extends Dialog {

    public ChooseRulesDialog(Context context) {
        super(context);
    }

    public ChooseRulesDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private Context context;
        private String desc;
        private String title;

        private OnClickListener negativeButtonClickListener;
        private DialogClickListener submitButtonClickListener;

        public Builder(Context context) {
            this.context = context;
        }


        /**
         * Set the Dialog title from resource
         *
         * @param title
         * @return
         */

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }


        public Builder setContent(String desc) {
            this.desc = desc;
            return this;
        }


        /**
         * Set the positive button resource and it's listener
         *
         * @param positiveButtonText
         * @return
         */
        public Builder setPositiveButton(int positiveButtonText,
                                         DialogClickListener listener) {
            this.submitButtonClickListener = listener;
            return this;
        }


        public Builder setPositiveButton(DialogClickListener listener) {
            this.submitButtonClickListener = listener;
            return this;
        }


        public Builder setNegativeButton(OnClickListener listener) {
            this.negativeButtonClickListener = listener;
            return this;
        }


        public ChooseRulesDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final ChooseRulesDialog dialog = new ChooseRulesDialog(context, R.style.MyDialog);
            View layout = inflater.inflate(R.layout.dialog_rules, null);
            dialog.addContentView(layout, new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            if (submitButtonClickListener != null) {
                ((ImageView) layout.findViewById(R.id.iv_close))
                        .setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                submitButtonClickListener.onClick(
                                        dialog);
                            }
                        });
            }




            dialog.setContentView(layout);
            dialog.setCanceledOnTouchOutside(true);
            return dialog;
        }
    }
}

