package com.example.math;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.math.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final Problem problem = new Problem();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        generateProblem();
        MyClickListener listener = new MyClickListener();
        binding.next.setOnClickListener(listener);
        binding.solution1.setOnClickListener(listener);
        binding.solution2.setOnClickListener(listener);
        binding.solution3.setOnClickListener(listener);

    }
    private void generateProblem(){
        binding.problem.setText(problem.getProblem());
        binding.solution1.setBackgroundColor(R.color.grey);
        binding.solution2.setBackgroundColor(R.color.grey);
        binding.solution3.setBackgroundColor(R.color.grey);
        int position =problem.getRandom(1,4);
        switch(position) {
            case 1:
            binding.solution1.setText(String.valueOf(problem.getResult()));
            binding.solution2.setText(String.valueOf(problem.getNoiseResult()));
            binding.solution3.setText(String.valueOf(problem.getNoiseResult()));
            break;
            case 2:
                binding.solution1.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution2.setText(String.valueOf(problem.getResult()));
                binding.solution3.setText(String.valueOf(problem.getNoiseResult()));
                break;
            case 3:
                binding.solution1.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution2.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution3.setText(String.valueOf(problem.getResult()));
                break;
        }
    }
    class MyClickListener implements View.OnClickListener{
        public int v;
        public int f;

        @Override
        public void onClick(View view) {

            switch(view.getId()){
                case R.id.next:
                    generateProblem();
                    break;
                case R.id.solution1:
                case R.id.solution2:
                case R.id.solution3:
                    String text = ((TextView)view).getText().toString();
                    if(text.equals(String.valueOf(problem.getResult()))){
                        v++;
                        f++;
                        problem.getScore(v,f);
                        view.setBackgroundColor(getColor(R.color.correct));
                        binding.score.setText(String.valueOf(problem.getScore(v,f)));
                    }
                    else{
                        f++;
                        problem.getScore(v,f);
                        view.setBackgroundColor(getColor(R.color.wrong));
                        binding.score.setText(String.valueOf(problem.getScore(v,f)));

                    }
                    break;
            }

        }
    }


}