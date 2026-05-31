// Указание пакета (путь к файлу)
package com.example.proba;

// Импорт необходимых классов
import android.content.Intent;      // Для перехода между экранами
import android.os.Bundle;           // Для сохранения состояния
import android.view.View;           // Для обработки нажатий
import android.widget.Button;       // Для работы с кнопкой
import android.widget.EditText;     // Для работы с полями ввода
import androidx.appcompat.app.AppCompatActivity; // Базовый класс Activity

public class MainActivity extends AppCompatActivity {

    // Метод onCreate вызывается при создании экрана
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Подключаем XML-разметку

        // Находим элементы на экране по их ID
        EditText emailInput = findViewById(R.id.emailEditText);
        EditText passwordInput = findViewById(R.id.passwordEditText);
        Button loginBtn = findViewById(R.id.loginButton);

        // Устанавливаем обработчик нажатия кнопки "Войти"
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем текст из полей ввода и удаляем лишние пробелы
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                // Создаем Intent для перехода на SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Передаем данные в SecondActivity
                intent.putExtra("user_email", email);
                intent.putExtra("user_password", password);

                // Запускаем новый экран
                startActivity(intent);
            }
        });
    }
}