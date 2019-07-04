package com.example.accounting_app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.accounting_app.R;
import com.example.accounting_app.function.type_or_format_conversion;
import com.example.accounting_app.listener.listener_fragment_make_bill_pay;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

import java.util.Date;

/**
 * @Creator cetwag yuebanquan
 * @Version V2.0.0
 * @Time 2019.6.29
 * @Description 记一笔中的支出碎片
 */
public class fragment_make_bill_pay extends Fragment {

    listener_fragment_make_bill_pay listener;
    public RadioButton rdb_select_time_pay;
    public TimePickerView pvTime;//时间选择器
    type_or_format_conversion t;//功能类对象
    public RadioGroup rdg_1, rdg_2, rdg_3;
    public RadioButton rdb_food, rdb_travel, rdb_shop, rdb_traffic, rdb_communication,
            rdb_hospital, rdb_house, rdb_child, rdb_teach, rdb_play, rdb_pet, rdb_life;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_make_bill_pay, container, false);

        //屏幕适配
        ScreenAdapterTools.getInstance().loadView(view);

        return view;
    }

    /**
     * @parameter
     * @description 根据生命周期相关，控件初始化的封装函数以及其他该碎片的相关封装函数需要放在该方法中
     * @Time 2019/6/29 9:36
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //控件初始化
        init();

        //初始化时间选择器
        initTimePick();

        //监听类函数功能
        listener.listener_Fragment_make_bill_pay();
    }

    /**
     * @parameter
     * @description 初始化控件
     * @Time 2019/6/29 11:23
     */
    void init() {
        rdb_select_time_pay = getView().findViewById(R.id.rdb_select_time_pay);
        listener = new listener_fragment_make_bill_pay(this);
        t = new type_or_format_conversion();
        rdg_1 = getView().findViewById(R.id.rdg_one_pay);
        rdg_2 = getView().findViewById(R.id.rdg_two_pay);
        rdg_3 = getView().findViewById(R.id.rdg_three_pay);
        rdb_food = getView().findViewById(R.id.rdb_food);
        rdb_travel = getView().findViewById(R.id.rdb_travel);
        rdb_shop = getView().findViewById(R.id.rdb_shop);
        rdb_traffic = getView().findViewById(R.id.rdb_traffic);
        rdb_communication = getView().findViewById(R.id.rdb_communication);
        rdb_hospital = getView().findViewById(R.id.rdb_hospital);
        rdb_house = getView().findViewById(R.id.rdb_house);
        rdb_child = getView().findViewById(R.id.rdb_child);
        rdb_teach = getView().findViewById(R.id.rdb_teach);
        rdb_play = getView().findViewById(R.id.rdb_play);
        rdb_pet = getView().findViewById(R.id.rdb_pet);
        rdb_life = getView().findViewById(R.id.rdb_life);
    }

    /**
     * @parameter
     * @description 初始化时间选择器
     * @Time 2019/6/29 11:10
     */
    void initTimePick() {
        pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                rdb_select_time_pay.setText(t.getTimeYMD(date));
            }
        }).build();
    }
}