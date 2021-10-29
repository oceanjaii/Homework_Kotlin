package com.example.homework3_kotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var edName: EditText? = null
    private var tvText: TextView? = null
    private var tvName: TextView? = null
    private var tvWinner: TextView? = null
    private var tvMmora: TextView? = null
    private var tvCmora: TextView? = null
    private var btnScissor: RadioButton? = null
    private var btnStone: RadioButton? = null
    private var btnPaper: RadioButton? = null
    private var btnMora: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edName = findViewById(R.id.edName)
        tvText = findViewById(R.id.tvText)
        tvName = findViewById(R.id.tvName)
        tvWinner = findViewById(R.id.tvWinner)
        tvMmora = findViewById(R.id.tvMmora)
        tvCmora = findViewById(R.id.tvCmora)
        btnScissor = findViewById(R.id.btnScissor)
        btnStone = findViewById(R.id.btnStone)
        btnPaper = findViewById(R.id.btnPaper)
        btnMora = findViewById(R.id.btnMora)
        btnMora?.setOnClickListener(View.OnClickListener {
            if (edName?.length()!! < 1) tvText?.setText("請輸入玩家姓名") else {
                tvName?.setText(String.format("name\n%s", edName?.getText().toString()))
                if (btnScissor?.isChecked() == true) tvMmora?.setText("我方出拳\n剪刀") else if (btnStone?.isChecked() == true) tvMmora?.setText(
                    "我方出拳\n石頭"
                ) else tvMmora?.setText("我方出拳\n布")
                val computer = (Math.random() * 3).toInt()
                if (computer == 0) tvCmora?.setText("電腦出拳\n剪刀") else if (computer == 1) tvCmora?.setText(
                    "我方出拳\n石頭"
                ) else tvCmora?.setText("我方出拳\n布")
                if (btnScissor?.isChecked() == true && computer == 2 || btnStone?.isChecked() == true && computer == 0 || btnPaper?.isChecked() == true && computer == 1) {
                    tvWinner?.setText(
                        """
                            勝利者
                            ${edName?.getText()}
                            """.trimIndent()
                    )
                    tvText?.setText("恭喜你獲勝!!!")
                } else if (btnScissor?.isChecked() == true && computer == 1 || btnStone?.isChecked() == true && computer == 2 || btnPaper?.isChecked() == true && computer == 0) {
                    tvWinner?.setText("勝利者\n電腦")
                    tvText?.setText("可惜，電腦獲勝了!")
                } else {
                    tvWinner?.setText("勝利者\n平手")
                    tvText?.setText("平局，請再試一次")
                }
            }
        })
    }
}