package com.osiris.farmers.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.CheckProject;
import com.osiris.farmers.model.SampleNameData;
import com.osiris.farmers.model.TypeSampleTitle;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.utils.ZXingUtils;
import com.osiris.farmers.view.adapter.BillOflandProjectSelectAdapter;
import com.osiris.farmers.view.adapter.BillOflandSelectAdapter;
import com.osiris.farmers.view.adapter.BillOflandTypeSelectAdapter;
import com.osiris.farmers.view.adapter.GridImageAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.widget.FullyGridLayoutManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class AddSampleActivity extends BaseActivity {


	@BindView(R.id.rv_data)
	RecyclerView rv_data;
	@BindView(R.id.iv_close)
	ImageView iv_close;
	@BindView(R.id.edt_price)
	EditText edt_price;
	@BindView(R.id.edt_count)
	EditText edt_count;
	@BindView(R.id.rv_type)
	RecyclerView rv_type;
	@BindView(R.id.recycler)
	RecyclerView recyclerView;
	@BindView(R.id.rv_project)
	RecyclerView rv_project;
	@BindView(R.id.tv_type_name)
	TextView tv_type_name;
	@BindView(R.id.linear_content)
	LinearLayout linear_content;
	@BindView(R.id.relative_content)
	RelativeLayout relative_content;
	@BindView(R.id.iv_bmp)
	ImageView iv_bmp;
	@BindView(R.id.linear_name)
	LinearLayout linear_name;
	@BindView(R.id.linear_project)
	LinearLayout linear_project;
	@BindView(R.id.relative_count)
	RelativeLayout relative_count;
	@BindView(R.id.relative_price)
	RelativeLayout relative_price;

	private Handler mHandler = new Handler();
	private List<String> picUploadList = new ArrayList<>();

	@OnClick({R.id.iv_close, R.id.tv_count_ok,R.id.tv_price_ok})
	void onClick(View v) {
		switch (v.getId()) {
			case R.id.iv_close:
				finish();
				break;
			case R.id.tv_count_ok:
				for (final LocalMedia localMedia : selectList) {
					mHandler.post(new Runnable() {
						@Override
						public void run() {
							uploadPic(localMedia.getCompressPath());
						}
					});
				}


				break;
			case R.id.tv_price_ok:
				for (final LocalMedia localMedia : selectList) {
					mHandler.post(new Runnable() {
						@Override
						public void run() {
							uploadPic(localMedia.getCompressPath());
						}
					});
				}


				break;
		}
	}


	private static final int MSG_UPLOAD_COMPLETE = 1022;
	private Handler mHadler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
				case MSG_UPLOAD_COMPLETE:
					uploadTakeSample();
					break;
			}
		}
	};


	private BillOflandProjectSelectAdapter billOflandProjectSelectAdapter;
	private BillOflandSelectAdapter billOflandSelectAdapter;
	private List<SampleNameData.CommodityBean> dataList = new ArrayList<>();
	private BillOflandTypeSelectAdapter typeSelectAdapter;
	private GridImageAdapter adapter;
	private List<LocalMedia> selectList = new ArrayList<>();

	private List<CheckProject.JcxmBean> checkProjectList = new ArrayList<>();
	private List<SampleNameData.CommodityBean> showDataList = new ArrayList<>();
	private List<TypeSampleTitle> commodityNameList = new ArrayList<>();

	private int boothglid = -1;
	private String descriptionid;
	private int jcxmid = -1;
	private int commodityid = -1;

	@Override
	public int getLayoutResId() {
		return R.layout.activity_add_sample;
	}


	@Override
	public void init() {


		dataList = getIntent().getParcelableArrayListExtra("data_list");
		boothglid = getIntent().getIntExtra("boothglid", 0);
		LogUtils.d("zkf boothglid:" + boothglid);

		showDataList.addAll(dataList);

		for (SampleNameData.CommodityBean commodityBean : dataList) {
			commodityNameList.add(new TypeSampleTitle(commodityBean.getBeifen(), false));
		}
		Set<TypeSampleTitle> ts = new HashSet<TypeSampleTitle>(commodityNameList);
		commodityNameList.clear();
		commodityNameList.addAll(ts);

		if (showDataList.size() > 0) {
			showDataList.clear();
		}
		for (SampleNameData.CommodityBean commodityBean : dataList) {
			if (commodityBean.getBeifen().equals(commodityNameList.get(0).getName())) {
				showDataList.add(commodityBean);
			}
		}

		typeSelectAdapter = new BillOflandTypeSelectAdapter(commodityNameList);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		rv_type.setLayoutManager(linearLayoutManager);
		rv_type.setAdapter(typeSelectAdapter);
		typeSelectAdapter.notifyDataSetChanged();
		typeSelectAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {

				LogUtils.d("zkf position:" + position);
				List<TypeSampleTitle> tempList = new ArrayList<>();
				tempList.addAll(commodityNameList);
				for (int i = 0; i < commodityNameList.size(); i++) {
					if (i == position) {
						LogUtils.d("zkf i :" + i);
						commodityNameList.get(i).setSelect(true);
					} else {
						LogUtils.d("zkf ii :" + i);
						commodityNameList.get(i).setSelect(false);
					}
				}
				typeSelectAdapter.notifyDataSetChanged();

				tv_type_name.setText(commodityNameList.get(position).getName());
				if (showDataList.size() > 0) {
					showDataList.clear();
				}
				for (SampleNameData.CommodityBean commodityBean : dataList) {
					if (commodityBean.getBeifen().equals(commodityNameList.get(position).getName())) {
						showDataList.add(commodityBean);
					}
				}
				billOflandSelectAdapter.notifyDataSetChanged();

				descriptionid = commodityNameList.get(position).getName();

			}
		});
		tv_type_name.setText(commodityNameList.get(0).getName());


		billOflandSelectAdapter = new BillOflandSelectAdapter(showDataList);
		GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
		rv_data.setLayoutManager(gridLayoutManager);
		rv_data.setAdapter(billOflandSelectAdapter);
		billOflandSelectAdapter.notifyDataSetChanged();
		billOflandSelectAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				for (int i = 0; i < showDataList.size(); i++) {
					if (i == position) {
						showDataList.get(i).setSelect(true);
					} else {
						showDataList.get(i).setSelect(false);
					}
				}
				commodityid = showDataList.get(position).getId();
				billOflandSelectAdapter.notifyDataSetChanged();

				getCheckProject(showDataList.get(position).getId());

			}
		});

		FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
		recyclerView.setLayoutManager(manager);
		adapter = new GridImageAdapter(this, onAddPicClickListener);
		adapter.setList(selectList);
		adapter.setSelectMax(2);
		recyclerView.setAdapter(adapter);


		billOflandProjectSelectAdapter = new BillOflandProjectSelectAdapter(checkProjectList);
		GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this, 3);
		rv_project.setLayoutManager(gridLayoutManager1);
		rv_project.setAdapter(billOflandProjectSelectAdapter);
		billOflandProjectSelectAdapter.notifyDataSetChanged();
		billOflandProjectSelectAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				for (int i = 0; i < checkProjectList.size(); i++) {
					if (i == position) {
						checkProjectList.get(i).setSelect(true);
					} else {
						checkProjectList.get(i).setSelect(false);
					}
				}
				billOflandProjectSelectAdapter.notifyDataSetChanged();

				jcxmid = checkProjectList.get(position).getId();

			}
		});
		getCheckProject(showDataList.get(0).getId());


	}

	private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
		@Override
		public void onAddPicClick() {
			PictureSelector.create(AddSampleActivity.this)
					.openGallery(PictureMimeType.ofImage())
					.theme(R.style.picture_default_style)
					.maxSelectNum(100)
					.minSelectNum(1)
					.imageSpanCount(4)
					.selectionMode(PictureConfig.MULTIPLE)
					.previewImage(true)
					.previewVideo(true)
					.enablePreviewAudio(false)
					.isCamera(true)
					.isZoomAnim(true)
					.enableCrop(false)
					.compress(true)
					.synOrAsy(true)
					.glideOverride(160, 160)
					.isGif(true)
					.openClickSound(false)
					.selectionMedia(selectList)
					.minimumCompressSize(100)
					.forResult(PictureConfig.CHOOSE_REQUEST);
		}

	};

	private void getCheckProject(int id) {

		String url = ApiParams.API_HOST + "/app/xzjcxm.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", String.valueOf(id));

		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				String temp = successResult.substring(1, successResult.length() - 1);
				LogUtils.d("zkf successResult:" + successResult);
				if (!TextUtils.isEmpty(successResult)) {
					if (checkProjectList.size()>0)checkProjectList.clear();
					CheckProject tempData = JsonUtils.fromJson(temp, CheckProject.class);
					checkProjectList.addAll(tempData.getJcxm());
					billOflandProjectSelectAdapter.notifyDataSetChanged();

				}


			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
				case PictureConfig.CHOOSE_REQUEST:
					// 图片选择结果回调
					selectList = PictureSelector.obtainMultipleResult(data);
					// 例如 LocalMedia 里面返回三种path
					// 1.media.getPath(); 为原图path
					// 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
					// 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
					// 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
					for (LocalMedia media : selectList) {
						Log.i("图片-----》", media.getPath());
					}
					adapter.setList(selectList);
					adapter.notifyDataSetChanged();
					break;
			}
		}
	}


	private void uploadPic(String path) {

		String url = ApiParams.API_HOST + "/app/picUpload.action";//database

		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("database", "data:image/png;base64," + "data:image/png;base64" + imageToBase64(path));
		NetRequest.requestBase64(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				//String temp = successResult.substring(1, successResult.length() - 1);

				LogUtils.d("zkf temp:" + successResult);
				if (successResult.contains("png")) {
					LogUtils.d("zkf upload success");
					picUploadList.add(successResult);
					if (picUploadList.size() == selectList.size()) {
						mHadler.sendEmptyMessage(MSG_UPLOAD_COMPLETE);
					}
				}

			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});


	}


	public static String imageToBase64(String path) {
		if (TextUtils.isEmpty(path)) {
			return null;
		}
		InputStream is = null;
		byte[] data = null;
		String result = null;
		try {
			is = new FileInputStream(path);
			//创建一个字符流大小的数组。
			data = new byte[is.available()];
			//写入数组
			is.read(data);
			//用默认的编码格式进行编码
			result = Base64.encodeToString(data, Base64.NO_WRAP);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return result;
	}


	private void uploadTakeSample() {


		//	boothglid;//boothglid
		//descriptionid
		//jcxmid
		//userid
		//GlobalParams.id;

		String url = ApiParams.API_HOST + "/app/cysjxz.action";///app/cysjxz.action
		//String url = ApiParams.API_HOST + "/app/cysjxz.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("marketid", String.valueOf(GlobalParams.currentMarketId));
		LogUtils.d("zkf marketid:" + GlobalParams.currentMarketId);
		if (boothglid>0){
			paramMap.put("boothglid", String.valueOf(boothglid));
		}else {
			Toast.makeText(this, "请选择摊位号", Toast.LENGTH_SHORT).show();
			return;
		}
		LogUtils.d("zkf boothglid:" + boothglid);
		paramMap.put("descriptionid", String.valueOf(descriptionid));
		LogUtils.d("zkf descriptionid:" + descriptionid);
		paramMap.put("commodityid",String.valueOf(commodityid));
		LogUtils.d("zkf commodityid:" + commodityid);

		if (jcxmid > 0) {
			paramMap.put("jcxmid", String.valueOf(jcxmid));
			LogUtils.d("zkf jcxmid:" + jcxmid);

		} else {
			Toast.makeText(this, "请选择检测项目", Toast.LENGTH_SHORT).show();
			return;
		}
		paramMap.put("userid", String.valueOf(GlobalParams.id));
		LogUtils.d("zkf userid:" + String.valueOf(GlobalParams.id));
		if (picUploadList.size() == 2) {
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(picUploadList.get(0) + ",").append(picUploadList.get(1));
			paramMap.put("duotu", stringBuffer.toString());
			LogUtils.d("zkf duotu:" + stringBuffer.toString());
//			paramMap.put("tupian2", picUploadList.get(1));
//			LogUtils.d("zkf tupian1:" + picUploadList.get(0));
//			LogUtils.d("zkf tupian2:" + picUploadList.get(1));

		} else {
			Toast.makeText(this, "请上传2张图片", Toast.LENGTH_SHORT).show();
			return;
		}
		if (!TextUtils.isEmpty(edt_count.getText().toString())) {
			paramMap.put("cysum", edt_count.getText().toString());
			LogUtils.d("zkf cysum:" + edt_count.getText().toString());

		} else {
			Toast.makeText(this, "请输入数量", Toast.LENGTH_SHORT).show();
			return;
		}

		if (!TextUtils.isEmpty(edt_price.getText().toString())) {
			paramMap.put("money", edt_price.getText().toString());
			LogUtils.d("zkf money:" + edt_price.getText().toString());

		} else {
			Toast.makeText(this, "请输入价格", Toast.LENGTH_SHORT).show();
			return;
		}

		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				//String temp = successResult.substring(1, successResult.length() - 1);

				LogUtils.d("zkf temp:" + successResult);
				if (!successResult.equals("0")){
					Toast.makeText(AddSampleActivity.this,"采集成功",Toast.LENGTH_SHORT).show();
					picUploadList.clear();
					Bitmap bitmap = ZXingUtils.createQRImage(successResult, 400,  400);
					rv_type.setVisibility(View.GONE);
					rv_project.setVisibility(View.GONE);
					recyclerView.setVisibility(View.GONE);
					linear_name.setVisibility(View.GONE);
					linear_project.setVisibility(View.GONE);
					rv_data.setVisibility(View.GONE);
					relative_count.setVisibility(View.GONE);
					relative_price.setVisibility(View.GONE);

					relative_content.setVisibility(View.VISIBLE);
					iv_bmp.setImageBitmap(bitmap);

					//finish();
				}else {
					Toast.makeText(AddSampleActivity.this,"采集失败，请重新尝试",Toast.LENGTH_SHORT).show();
				}

			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});


	}



	private void getCaiysj(String path) {

		String url = ApiParams.API_HOST + "getCaiysj";//database

		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("database", "data:image/png;base64," + "data:image/png;base64" + imageToBase64(path));
		NetRequest.requestBase64(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				//String temp = successResult.substring(1, successResult.length() - 1);

				LogUtils.d("zkf temp:" + successResult);
				if (successResult.contains("png")) {
					LogUtils.d("zkf upload success");
					picUploadList.add(successResult);
					if (picUploadList.size() == selectList.size()) {
						mHadler.sendEmptyMessage(MSG_UPLOAD_COMPLETE);
					}
				}

			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});


	}



}
