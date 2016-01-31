package com.blossom.workrecd;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.blossom.workrecd.Dao.UserInfoBean;
import com.blossom.workrecd.JianzhiFragment.JianzhiActivity;
import com.blossom.workrecd.Liugetu.JifenActivity;
import com.blossom.workrecd.Liugetu.MyhuatiActivity;
import com.blossom.workrecd.Liugetu.MytikuActivity;
import com.blossom.workrecd.Liugetu.Qianbao.QianbaoActivity;
import com.blossom.workrecd.Liugetu.ShengyaActivity;
import com.blossom.workrecd.Liugetu.ShoucangActivity;
import com.blossom.workrecd.Login.LoginActivity;
import com.blossom.workrecd.Setting.SettingActivity;
import com.blossom.workrecd.Utils.CommonUtils;
import com.blossom.workrecd.Utils.FileUtil;
import com.blossom.workrecd.Utils.ToastHelper;
import com.blossom.workrecd.View.CoverSelelctPopupWindow;
import com.blossom.workrecd.View.GridViewForScrollView;
import com.blossom.workrecd.View.RoundedImageView;
import com.blossom.workrecd.View.TitleView;
import com.blossom.workrecd.ziliao.WrenzhengActivity;
import com.blossom.workrecd.ziliao.ZiliaoActivity;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment implements  android.view.View.OnClickListener {

    private View myPartent;
    private FragmentActivity mactivity;
    @ViewInject(R.id.title)
    private TitleView mtitleview;
    @ViewInject(R.id.pname)
    private TextView name;
    @ViewInject(R.id.xinyong)
    private TextView credit;
    @ViewInject(R.id.jifen)
    private TextView integration;
    @ViewInject(R.id.piv)
    private RoundedImageView imgCover;
    @ViewInject(R.id.myinfogridview)
    private GridViewForScrollView myInFoGridView;
    private List<Map<String, Object>> data_list;

    private CoverSelelctPopupWindow coverSelelctPopupWindow;

    public static final int ACTIVITY_ALBUM_REQUESTCODE = 2000;

    public static final int ACTIVITY_CAMERA_REQUESTCODE = 2001;

    public static final int ACTIVITY_MODIFY_PHOTO_REQUESTCODE = 2002;

    private int[] icon_pic = {
            R.mipmap.person_gv_01,
            R.mipmap.person_gv_02,
            R.mipmap.person_gv_03,
            R.mipmap.person_gv_04,
            R.mipmap.person_gv_05,
            R.mipmap.person_gv_06};
    private String[] icon_name = {"生涯", "钱包", "积分", "收藏", "题库", "话题"};

    private SharedPreferences sharedPreferences;
    private String UserCode;
    private   BitmapUtils bitmapUtils;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, null);
        ViewUtils.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mactivity = getActivity();
        myPartent = getView();
        initview();
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        SimpleAdapter simpleAdapter = new SimpleAdapter(myPartent.getContext(), data_list, R.layout.person_gridview, new String[]{"image", "text"}, new int[]{R.id.mygridview_pic, R.id.mygridview_txt});
        myInFoGridView.setAdapter(simpleAdapter);
    }

    private void initview() {

        mtitleview.setTitle("个人中心");
        mtitleview.setLeftImageButton(new TitleView.OnLeftImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                ((MainActivity) getActivity()).setTab(0);
            }
        });
        mtitleview.setRightImageButton(new TitleView.OnRightImageButtonClickLister() {
            @Override
            public void onClick(View button) {
                Intent msgintent = new Intent(myPartent.getContext(), MsgActivity.class);
                startActivity(msgintent);
            }
        });
        sharedPreferences = mactivity.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String entity = sharedPreferences.getString("entity","");
        if (!entity.isEmpty()){
            Gson gson = new Gson();
            UserInfoBean userInfoBean = gson.fromJson(entity, UserInfoBean.class);
            UserCode = userInfoBean.getUserCode();
            name.setText(userInfoBean.getUserName());
            credit.setText(String.valueOf(userInfoBean.getUserCredit()));
           integration.setText(String.valueOf(userInfoBean.getUserIntegration()));
            String imgurl = CommonUrl.BASE+userInfoBean.getUserPhoto();
            System.out.println("imgurl---->" + imgurl);
            if (!imgurl.equals(CommonUrl.BASE+"null")) {
                bitmapUtils = new BitmapUtils(myPartent.getContext());
                bitmapUtils.display(imgCover, imgurl);
            }
        }


    }

    public List<Map<String, Object>> getData() {
        for (int i = 0; i < icon_pic.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon_pic[i]);
            map.put("text", icon_name[i]);
            data_list.add(map);
        }
        return data_list;
    }

    @OnClick({R.id.piv,R.id.myinfo,R.id.gorenzheng, R.id.baoming, R.id.luyong, R.id.wancheng, R.id.daipingjia, R.id.jibenziliao, R.id.zhanneixiaoxi, R.id.about, R.id.seting})
    public void myClick(View v) {
        switch (v.getId()) {
            case R.id.piv:
                coverSelelctPopupWindow = new CoverSelelctPopupWindow(mactivity, itemsOnClick);
                coverSelelctPopupWindow.showAtLocation(myPartent.findViewById(R.id.pname), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
            case R.id.myinfo:
                Intent login = new Intent(myPartent.getContext(), LoginActivity.class);
                startActivity(login);
                break;
            case R.id.gorenzheng:
                Intent rz = new Intent(myPartent.getContext(), WrenzhengActivity.class);
                startActivity(rz);
                break;
            case R.id.baoming:
                Intent bm = new Intent(myPartent.getContext(), JianzhiActivity.class);
                bm.putExtra("flag", "0");
                startActivity(bm);
                break;
            case R.id.luyong:
                Intent ly = new Intent(myPartent.getContext(), JianzhiActivity.class);
                ly.putExtra("flag", "1");
                startActivity(ly);
                break;
            case R.id.wancheng:
                Intent wc = new Intent(myPartent.getContext(), JianzhiActivity.class);
                wc.putExtra("flag", "2");
                startActivity(wc);
                break;
            case R.id.daipingjia:
                Intent pj = new Intent(myPartent.getContext(), JianzhiActivity.class);
                pj.putExtra("flag", "3");
                startActivity(pj);
                break;
            case R.id.jibenziliao:
                Intent jbzl = new Intent(myPartent.getContext(), ZiliaoActivity.class);
                startActivity(jbzl);
                break;
            case R.id.zhanneixiaoxi:
                Intent znxx = new Intent(myPartent.getContext(), TongzhiActivity.class);
                startActivity(znxx);
                break;
            case R.id.about:
                Intent about = new Intent(myPartent.getContext(), AboutActivity.class);
                startActivity(about);
                break;
            case R.id.seting:
                Intent set = new Intent(myPartent.getContext(), SettingActivity.class);
                startActivity(set);
                break;

        }
    }

    @OnItemClick(R.id.myinfogridview)
    public void myItemClick(AdapterView<?> parent, View v, int position, long id) {
        switch (position) {
            case 0:
                Intent shengya = new Intent(myPartent.getContext(), ShengyaActivity.class);
                startActivity(shengya);
                break;
            case 1:
                Intent qianbao = new Intent(myPartent.getContext(), QianbaoActivity.class);
                startActivity(qianbao);
                break;
            case 2:
                Intent jifen = new Intent(myPartent.getContext(), JifenActivity.class);
                startActivity(jifen);
                break;
            case 3:
                Intent shoucang = new Intent(myPartent.getContext(), ShoucangActivity.class);
                startActivity(shoucang);
                break;
            case 4:
                Intent tiku = new Intent(myPartent.getContext(), MytikuActivity.class);
                startActivity(tiku);
                break;
            case 5:
                Intent huati = new Intent(myPartent.getContext(), MyhuatiActivity.class);
                startActivity(huati);
                break;
        }

    }
    // 为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            coverSelelctPopupWindow.dismiss();
            if (CommonUtils.isFastDoubleClick()) {
                return;
            }
            switch (v.getId()) {
                case R.id.btn_album:
                    Intent i = new Intent(Intent.ACTION_PICK, null);// 调用android的图库
                    i.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    startActivityForResult(i, ACTIVITY_ALBUM_REQUESTCODE);
                    break;

                case R.id.btn_photo_graph:
                    if (CommonUtils.isExistCamera(myPartent.getContext())) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 调用android自带的照相机
                        Uri imageUri = Uri.fromFile(FileUtil.getHeadPhotoFileRaw());
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                        intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                        startActivityForResult(intent, ACTIVITY_CAMERA_REQUESTCODE);
                    } else {
                        Toast.makeText(myPartent.getContext(),
                                getResources().getString(R.string.user_no_camera),
                                Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("in result--------->");
        switch (requestCode) {
            case ACTIVITY_ALBUM_REQUESTCODE:
                if (resultCode == Activity.RESULT_OK) {
                    if(data.getData() == null){
                       ToastHelper.show(myPartent.getContext(), getString(R.string.pic_not_valid));
                        return;
                    }
                    System.out.println("go cut--------->"+data.getData());
                    CommonUtils.cutPhoto(mactivity, data.getData(), true);
                }
                break;
            case ACTIVITY_CAMERA_REQUESTCODE:
                if (resultCode == Activity.RESULT_OK) {
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmapOptions.inSampleSize = 2;
                    int degree = FileUtil.readPictureDegree(FileUtil.getHeadPhotoDir() + FileUtil.HEADPHOTO_NAME_RAW);
                    Bitmap cameraBitmap = BitmapFactory.decodeFile(FileUtil.getHeadPhotoDir() + FileUtil.HEADPHOTO_NAME_RAW, bitmapOptions);
                    cameraBitmap = FileUtil.rotaingImageView(degree, cameraBitmap);
                    FileUtil.saveCutBitmapForCache(myPartent.getContext(),cameraBitmap);
                    CommonUtils.cutPhoto(mactivity, Uri.fromFile(FileUtil.getHeadPhotoFileRaw()), true);
                }
                break;
            case ACTIVITY_MODIFY_PHOTO_REQUESTCODE:
//                Bundle bundle = data.getExtras();
//                if (bundle != null) {
//                    Bitmap bitmap = bundle.getParcelable("data");
//                    if (bitmap == null) {
//                        return;
//                    }
//                    headImg.setImageBitmap(bitmap);
//                }
                System.out.println("in modify--------->");
                String coverPath = FileUtil.getHeadPhotoDir()  + FileUtil.HEADPHOTO_NAME_TEMP;
                Bitmap bitmap = BitmapFactory.decodeFile(coverPath);
                imgCover.setImageBitmap(bitmap);
                System.out.println("imgpath--------->"+coverPath);
                //接下来是完成上传功能
               /* HttpUtil.uploadCover(this, UrlContainer.UP_LIVE_COVER + "?uid="
                        + LoginUtils.getInstance(this), coverPath, this);*/
                //成功之后删除临时图片
               // FileUtil.deleteTempAndRaw();

                break;

        }
    }
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null)
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onClick(View v) {

    }
}
