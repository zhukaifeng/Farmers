package com.osiris.farmers.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.luck.picture.lib.tools.ToastManage;
import com.osiris.farmers.R;
import com.osiris.farmers.marketcheck.MarketCheckActivity;

public class AddCustomerDialog extends Dialog {
    public AddCustomerDialog(Context context) {
        super(context);
    }

    public AddCustomerDialog(Context context, int themeResId) {
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


        public AddCustomerDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final AddCustomerDialog dialog = new AddCustomerDialog(context, R.style.MyDialog);
            View layout = inflater.inflate(R.layout.dialog_add_customer, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            (layout.findViewById(R.id.btn_close))
                    .setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

            EditText cusNoEt = layout.findViewById(R.id.cus_no);
            EditText cusNameEt = layout.findViewById(R.id.cus_name);
            EditText cusTypeEt = layout.findViewById(R.id.cus_type);
            EditText cusLinkEt = layout.findViewById(R.id.cus_link);
            EditText cusPhoneEt = layout.findViewById(R.id.cus_phone);
            EditText cusLicenseEt = layout.findViewById(R.id.cus_license);
            EditText cusAddrEt = layout.findViewById(R.id.cus_address);

            layout.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String cusNo = cusNoEt.getText().toString();
                    String cusName = cusNameEt.getText().toString();
                    String cusType = cusTypeEt.getText().toString();
                    String cusLink = cusLinkEt.getText().toString();
                    String cusPhone = cusPhoneEt.getText().toString();
                    String cusLicense = cusLicenseEt.getText().toString();
                    String cusAddr = cusAddrEt.getText().toString();
                    if (TextUtils.isEmpty(cusNo)){
                        Toast.makeText(context,"客户编号不能为空",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(cusName)){
                        Toast.makeText(context,"客户姓名不能为空",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(cusType)){
                        Toast.makeText(context,"客户类型不能为空",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(cusPhone)){
                        Toast.makeText(context,"客户电话不能为空",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(cusAddr)){
                        Toast.makeText(context,"客户地址不能为空",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(cusLicense)){
                        Toast.makeText(context,"营业执照不能为空",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(cusNo)){
                        Toast.makeText(context,"客户编号不能为空",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (onSaveClickListener != null) {
                        onSaveClickListener.onSaveClick(cusNo, cusName, cusType, cusLink, cusPhone, cusAddr, cusLicense);
                    }
                    dialog.dismiss();
                }
            });


            dialog.setContentView(layout);
            dialog.setCanceledOnTouchOutside(true);
            return dialog;
        }

        public interface OnSaveClickListener {
            void onSaveClick(String cusNo, String cusName, String cusType, String cusLink, String cusPhone, String cusAddr, String cusLicense);
        }
    }
}
