package com.example.myfragment1.ui.video;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.myfragment1.R;
import com.example.myfragment1.videoa1;
import com.example.myfragment1.videoa2;
import com.example.myfragment1.videoa3;

public class VideoFragment extends Fragment {
    private ListView list_video;
    private VideoViewModel mViewModel;

    int[] videotitle={R.mipmap.videotitle1,R.mipmap.videotitle2,R.mipmap.videotitle3};

    public static VideoFragment newInstance() {
        return new VideoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.video_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VideoViewModel.class);
        // TODO: Use the ViewModel
        initView();
        initHandler()
;    }
Intent it=new Intent();
    private void initHandler() {
        list_video.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                       it.setClass(getActivity(),videoa1.class);
                       startActivity(it);
                        break;
                    case 1:
                        it.setClass(getActivity(), videoa2.class);
                        startActivity(it);
                        break;
                    case 2:
                        it.setClass(getActivity(), videoa3.class);
                        startActivity(it);
                        break;
                }
            }
        });
    }

    private void initView() {
        View  view= getView();
        list_video=view.findViewById(R.id.list_video);
        MyAdapter myAdapter=new MyAdapter(getActivity());
        list_video.setAdapter(myAdapter);


    }
    class  MyAdapter extends BaseAdapter{
            private LayoutInflater inflater;

        public MyAdapter(Context c) {
            inflater=LayoutInflater.from(c);
        }


        @Override
        public int getCount() {
            return videotitle.length;
        }

        @Override
        public Object getItem(int position) {
            return videotitle[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                convertView=inflater.inflate(R.layout.video_layout,null);
            ImageView videoimg=convertView.findViewById(R.id.img_trailer);
            videoimg.setImageResource(videotitle[position]);

            return convertView;
        }
    }

}
