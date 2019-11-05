
package com.osiris.farmers.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.osiris.farmers.R;
import com.osiris.farmers.model.SampleNameData;
import com.osiris.farmers.view.adapter.BillOflandSelectAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.List;

import me.jessyan.autosize.utils.LogUtils;

/**
 * Created by zhukaifeng on 2018/04/08.
 */


public class BillOflandingDialog extends Dialog {

    public BillOflandingDialog(Context context) {
        super(context);
    }

    public BillOflandingDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private Context context;
        private String desc;
        private String title;
	    private List<SampleNameData.CommodityBean> dataList = new ArrayList<>();

	    private OnClickListener negativeButtonClickListener;
        private DialogClickListener submitButtonClickListener;
        private BillOflandSelectAdapter billOflandSelectAdapter;

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

	    public Builder setDataBillList(List<SampleNameData.CommodityBean> dataList) {
		    this.dataList = dataList;
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


        public BillOflandingDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final BillOflandingDialog dialog = new BillOflandingDialog(context, R.style.MyDialog);
            View layout = inflater.inflate(R.layout.dialog_billoflanding, null);
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

            RadioGroup rg_company_option_type_title = layout.findViewById(R.id.rg_company_option_type_title);
            rg_company_option_type_title.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {

                    }
                }
            });

	        RecyclerView rv_data = layout.findViewById(R.id.rv_data);
	      //  billOflandSelectAdapter = new BillOflandSelectAdapter(dataList);
	        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
	        rv_data.setLayoutManager(gridLayoutManager);
	        rv_data.setAdapter(billOflandSelectAdapter);
	        billOflandSelectAdapter.notifyDataSetChanged();
	        billOflandSelectAdapter.setOnItemClick(new MyItemClickListener() {
		        @Override
		        public void onItemClick(View view, int position) {
		        	LogUtils.d("zkf click :" + position);
//			        for (SampleNameData.CommodityBean commodityBean:dataList){
//			        	for (int i=0;i<dataList.size();i++){
//			        		if (i==position){
//						        LogUtils.d("zkf iii");
//			        			commodityBean.setSelect(true);
//					        }else {
//						        LogUtils.d("zkf 222");
//						        commodityBean.setSelect(false);
//					        }
//				        }
//				        billOflandSelectAdapter.notifyDataSetChanged();
//			        }
		        }
	        });

            dialog.setContentView(layout);
            dialog.setCanceledOnTouchOutside(true);
            return dialog;
        }
    }
}

