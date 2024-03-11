package com.example.transformers_tabyldieva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.airbnb.lottie.LottieAnimationView;

import com.example.transformers_tabyldieva.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TextView name_1, name_2;
    TextView tv_energy1, tv_energy2, tv_lasers1, tv_lasers2, who_will_win;
    Button btnStart, btnFight, btnGameOver;
    LottieAnimationView lotty_robot1, lotty_robot2, lotty_flame;
    LinearLayout imagesRobotsLayout;

    Random rn1 = new Random();

    int ener1 = rn1.nextInt(7001 + 1);
    Random ls1 = new Random();

    int las1 = ls1.nextInt(601 + 1);
    Random rn2 = new Random();

    int ener2 = rn2.nextInt(6001 + 1);
    Random ls2 = new Random();

    int las2 = ls2.nextInt(501 + 1);

    TransformerRed robot1 = new TransformerRed ( "Lora", ener1, las1, "It's my planet!");
    TransformerYellow robot2 = new TransformerYellow("Evange", ener2, las2, "YES! I WON!");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        name_1 = binding.name1;
        name_2 = binding.name2;
        tv_energy1 = binding.tvEnergy1;
        tv_energy2 = binding.tvEnergy2;
        tv_lasers1 = binding.tvLasers1;
        tv_lasers2 = binding.tvLasers2;
        who_will_win = binding.whoWillWin;
        btnStart = binding.btnStart;
        btnFight = binding.btnFight;
        btnGameOver = binding.btnGameOver;
        lotty_robot1 = binding.lottyDrive1;
        lotty_robot2 = binding.lottyDrive2;
        lotty_flame = binding.lottyFlame;
        imagesRobotsLayout = binding.imagesRobotsLayout;

        lotty_flame.setAnimation(R.raw.fire);
        lotty_robot1.setAnimation(R.raw.redrobot);
        lotty_robot2.setAnimation(R.raw.yellowrobot);
        btnGameOver.setVisibility(View.INVISIBLE);

        initializeViews();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.name1.setText(robot1.getName());
                binding.name2.setText(robot2.getName());

                binding.tvEnergy1.setText(String.valueOf(robot1.getEnergy()));
                binding.tvLasers1.setText(String.valueOf(robot1.getNum_lasers()));

                binding.tvEnergy2.setText(String.valueOf(robot2.getEnergy()));
                binding.tvLasers2.setText(String.valueOf(robot2.getNum_lasers()));

                binding.btnFight.setVisibility(View.VISIBLE);
                binding.btnGameOver.setVisibility(View.INVISIBLE);

            }

            });

        btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnStart.setVisibility(View.INVISIBLE);
                binding.imagesRobotsLayout.setVisibility(View.INVISIBLE);
                binding.lottyDrive1.setVisibility(View.VISIBLE);
                binding.lottyDrive2.setVisibility(View.VISIBLE);
                binding.lottyFlame.setVisibility(View.VISIBLE);

                if ((robot1.energy <= 0) || (robot2.energy <= 0)) {
                    binding.btnFight.setVisibility(View.INVISIBLE);
                    binding.btnGameOver.setVisibility(View.VISIBLE);

                    if (robot1.energy <= 0) {
                        String wordsRobot2 = robot2.printSelf();
                        who_will_win.setVisibility(View.VISIBLE);
                        who_will_win.setText(wordsRobot2);
                    } else {
                        String wordsRobot1 = robot1.printSelf();
                        who_will_win.setVisibility(View.VISIBLE);
                        who_will_win.setText(wordsRobot1);
                    }
                } else {
                    binding.imagesRobotsLayout.setVisibility(View.INVISIBLE);
                    binding.lottyDrive1.setVisibility(View.VISIBLE);
                    binding.lottyDrive2.setVisibility(View.VISIBLE);
                    binding.lottyFlame.setVisibility(View.VISIBLE);

                    int m = Integer.parseInt(tv_lasers1.getText().toString());
                    robot1.minusEnergy(m);
                    tv_energy1.setText(String.valueOf(robot1.getEnergy()));

                    int n = Integer.parseInt(tv_lasers2.getText().toString());
                    robot2.minusEnergy(n);
                    tv_energy2.setText(String.valueOf(robot2.getEnergy()));
                }
            }
        });

        btnGameOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
                // Сброс игры
            }
        });
    }

    private void resetGame() {

        ener1 = rn1.nextInt(7001 + 1);
        las1 = ls1.nextInt(601 + 1);
        ener2 = rn2.nextInt(6001 + 1);
        las2 = ls2.nextInt(501 + 1);
        robot1 = new TransformerRed("Wall-E", ener1, las1, "I won! It's my planet!");
        robot2 = new TransformerYellow("Eva", ener2, las2, "I WON!");


        name_1.setText(robot1.getName());
        name_2.setText(robot2.getName());
        tv_energy1.setText(String.valueOf(robot1.getEnergy()));
        tv_lasers1.setText(String.valueOf(robot1.getNum_lasers()));
        tv_energy2.setText(String.valueOf(robot2.getEnergy()));
        tv_lasers2.setText(String.valueOf(robot2.getNum_lasers()));
        who_will_win.setText("Who will win?");

        btnGameOver.setVisibility(View.INVISIBLE);
    }

    private void initializeViews() {
    }


}

