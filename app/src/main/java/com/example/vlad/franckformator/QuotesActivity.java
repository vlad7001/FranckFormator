package com.example.vlad.franckformator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuotesActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.listView);

        List<String> items = initData();

        int randomValue = random(items.size()-1);
        textView.setText(items.get(randomValue));
    }

    int random (int value){ //0.....value
        Random random = new Random();
        return random.nextInt(value);

    }

//     [0],   [1],    [2]
//    ["s1"],["s2"],["s3"]
//
//    arraysize = 3;
//    index = random(arraysize-1) 0,1,2
//    quote = array.get(index)
//

    private List<String> initData(){
        List<String> list = new ArrayList<String>();

        list.add("If you must play,\n" +
                "decide upon\n" +
                "three things at the start:\n" +
                "the rules of the game,\n" +
                "the stakes,\n" +
                "and the quitting time.\n" +
                "Chinese Proverb");
        list.add("Luck is what happens\n" +
                "when preparation\n" +
                "meets opportunity.\n" +
                "Seneca");
        list.add("Quit while you’re ahead.\n" +
                "All the best gamblers do.\n" +
                "Baltasar Gracián y Morales");
        list.add("By gaming we lose both\n" +
                "our time and treasure:\n" +
                "two things most precious\n" +
                "to the life of man.\n" +
                "Owen Feltham");
        list.add("If you would be wealthy,\n" +
                "think of saving as well as getting.\n" +
                "Benjamin Franklin");
        list.add("I’m a great believer in luck,\n" +
                "and I find the harder I work\n" +
                "the more I have of it.\n" +
                "Thomas Jefferson");
        list.add("The only sure thing about luck is\n" +
                "that it will change.\n" +
                "Bret Harte");
        list.add("True luck consists\n" +
                "not in holding the best\n" +
                "of the cards at the table;\n" +
                "luckiest is\n" +
                "he who knows\n" +
                "just when to rise and go home.\n" +
                "John Milton Hay");
        list.add("The gambling known as business\n" +
                "looks with austere disfavor\n" +
                "upon the business\n" +
                "known as gambling.\n" +
                "Ambrose Bierce\n" +
                "\n" +
                "(1842 – 1914, American journalist, writer,\n" +
                "fabulist, and satirist)");
        list.add("When I was young,\n" +
                "people called me a gambler.\n" +
                "As the scale of my operations increased\n" +
                "I became known as a speculator.\n" +
                "Now I am called a banker.\n" +
                "But I have been doing\n" +
                "the same thing all the time.\n" +
                "Sir Ernest Cassel");
        list.add("You and I come by road or rail, but economists travel on infrastructure. Margaret Thatcher");
        list.add("A budget tells us what we can't afford, but it doesn't keep us from buying it. William Feather");
        list.add("Wealth consists not in having great possessions, but in having few wants. Epictetus");
        list.add("Finance is not merely about making money. It's about achieving our deep goals and protecting the fruits of our labor. It's about stewardship and, therefore, about achieving the good society. Robert J. Shiller");
        list.add("Under capitalism, man exploits man. Under communism, it's just the opposite. John Kenneth Galbraith");
        list.add("In this world nothing can be said to be certain, except death and taxes. Benjamin Franklin");
        list.add("I will tell you the secret to getting rich on Wall Street. You try to be greedy when others are fearful. And you try to be fearful when others are greedy. --Warren Buffett");
        list.add("I never attempt to make money on the stock market. I buy on the assumption that they could close the market the next day and not reopen it for ten years. --Warren Buffett");
        list.add("Formal education will make you a living; self-education will make you a fortune. --Jim Rohn");
        list.add("It is not the man who has too little, but the man who craves more, that is poor. --Seneca\n");
        list.add("Happiness is not in the mere possession of money; it lies in the joy of achievement, in the thrill of creative effort. --Franklin D. Roosevelt");
        list.add("The best thing money can buy is financial freedom. - VLAD DEBOY");

        return list;

    }



    /**
     * We have only one text view on screen
     * In code we initialize our list of quotes and put them into Java Collection - ArrayList<>String>
     * Also we use random(int size) function for getting random value from 0 to list of quotes size.
     * Then we get list item with random index value, and  call function textView.setText() with "random quote"
     *
     *
     * */
}
