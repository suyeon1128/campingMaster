package com.example.campingmaster.fragment;
import com.example.campingmaster.adapter.ChatAdapter;
import com.example.campingmaster.model.ChatMessage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campingmaster.databinding.FragmentChatBinding;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    FragmentChatBinding myBinding;
    private RecyclerView recyclerView;
    private ChatAdapter adapter;
    private List<ChatMessage> messages;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myBinding = FragmentChatBinding.inflate(inflater);
        return myBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = myBinding.chatRecyclerView;
        messages = new ArrayList<>();
        adapter = new ChatAdapter(messages);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        ImageButton sendButton = myBinding.chatSendButton;
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputText = myBinding.chatInputText;
                String message = inputText.getText().toString().trim();
                if (!message.isEmpty()) {
                    // 새 메시지 생성
                    String sender = "나"; // 또는 실제 사용자의 이름
                    ChatMessage chatMessage = new ChatMessage(message, sender, null); // 시간은 null로 설정
                    // RecyclerView에 메시지 추가
                    adapter.addMessage(chatMessage);
                    // 입력창 비우기
                    inputText.setText("");
                    // RecyclerView를 가장 최근 메시지로 스크롤
                    recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                }
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        myBinding = null;
    }
}

