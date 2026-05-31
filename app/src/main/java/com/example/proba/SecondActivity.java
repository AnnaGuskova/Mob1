package com.example.proba;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Находим элементы на втором экране
        TextView messageView = findViewById(R.id.messageTextView);
        Button backBtn = findViewById(R.id.backButton);

        // Получаем данные, переданные с первого экрана
        String email = getIntent().getStringExtra("user_email");
        String password = getIntent().getStringExtra("user_password");

        // Получаем эталонные значения из resources
        String correctEmail = getString(R.string.default_email);      // "admin@admin.ru"
        String correctPassword = getString(R.string.default_password); // "123"

        // Проверяем введенные данные
        if (correctEmail.equals(email) && correctPassword.equals(password)) {
            // Если данные верны - выводим приветствие
            String welcome = String.format(getString(R.string.welcome_message), email);
            messageView.setText(welcome);
        } else {
            // Если данные неверны - выводим сообщение об ошибке
            messageView.setText(R.string.auth_error);
        }

        // Обработчик кнопки "Назад"
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Закрываем текущий экран, возвращаемся на предыдущий
            }
        });
    }
}