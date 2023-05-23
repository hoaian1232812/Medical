package com.example.medical;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.medical.databinding.FragmentHomeBinding;

public class Home extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        /*
        use case 2 Đăng ký lịch khám mới
        1. Người dùng chọn chức năng đăng ký khám bệnh
         */
        LinearLayout layout = root.findViewById(R.id.dkkb);
        layout.setOnClickListener(v ->{
            Intent intent = new Intent(root.getContext(),FunctionChoose.class);
            startActivity(intent);
        });
        // use case xem lịch sử khám bệnh
        LinearLayout layout2 = root.findViewById(R.id.lskb);
        layout2.setOnClickListener(v ->{
            Intent intent = new Intent(root.getContext(),History.class);
            startActivity(intent);
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}