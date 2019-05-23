
package com.osiris.farmers.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.osiris.farmers.R;

/**
 * Created by zhukaifeng on 2018/04/08.
 */


public class RegistDialog extends Dialog {

    public RegistDialog(Context context) {
        super(context);
    }

    public RegistDialog(Context context, int theme) {
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


        public RegistDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final RegistDialog dialog = new RegistDialog(context, R.style.MyDialog);
            View layout = inflater.inflate(R.layout.dialog_login_regist, null);
            dialog.addContentView(layout, new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            final TextView tv_remind = (TextView) layout.findViewById(R.id.tv_konw);
            if (submitButtonClickListener != null) {
                ((TextView) layout.findViewById(R.id.tv_konw))
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

