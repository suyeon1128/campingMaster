package com.example.campingmaster;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campingmaster.R;
import com.example.campingmaster.StartActivity;

public class NicknameActivity extends AppCompatActivity {

    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_nickname);

        // 버튼 초기화
        nextButton = findViewById(R.id.button_next);

        // 다음 버튼 클릭 이벤트 처리
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent를 사용하여 fragment_start로 이동
                Intent intent = new Intent(NicknameActivity.this, FragmentStart.class);
                startActivity(intent);
            }
        });
    }
}
