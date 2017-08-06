package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button ansTop;
    Button ansBottom;
    int mIndexStory;
    int mIndexTop;
    int mIndexBottom;
    int mStory;
    int mTop;
    int mBottom;

    private storyLine[] mStoryLine=new storyLine[]{
            new storyLine(R.string.T1_Story),
            new storyLine(R.string.T2_Story),
            new storyLine(R.string.T3_Story),
            new storyLine(R.string.T4_End),
            new storyLine(R.string.T5_End),
            new storyLine(R.string.T6_End)
    };
    private AnswerTop[] mAnswerTop = new AnswerTop[]{
            new AnswerTop(R.string.T1_Ans1),
            new AnswerTop(R.string.T2_Ans1),
            new AnswerTop(R.string.T3_Ans1)
    };
    private AnswerBottom[] mAnswerBottom=new AnswerBottom[]{
            new AnswerBottom(R.string.T1_Ans2),
            new AnswerBottom(R.string.T2_Ans2),
            new AnswerBottom(R.string.T3_Ans2)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = (TextView)findViewById(R.id.storyTextView);
        ansTop= (Button)findViewById(R.id.buttonTop);
        ansBottom = (Button)findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        ansTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStoryTop();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        ansBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStoryBottom();
            }
        });

    }
    private void updateStoryTop(){
        if(mIndexStory==0)
            {mIndexStory = (mIndexStory + 2) % mStoryLine.length;
            mIndexTop = (mIndexTop + 2) % mAnswerTop.length;
            mIndexBottom = (mIndexBottom + 2) % mAnswerBottom.length;
            }
        else {
            if (mIndexStory==1){
                mIndexStory = (mIndexStory+1)%mStoryLine.length;
                mIndexTop = (mIndexTop+1)%mAnswerTop.length;
                mIndexBottom = (mIndexBottom+1)%mAnswerBottom.length;
            }
            else{
                if(mIndexStory==2){
                    mIndexStory = (mIndexStory+3)%mStoryLine.length;

                }

            }

        }
        mStory=mStoryLine[mIndexStory].getStoryId();
        storyTextView.setText(mStory);
        mTop=mAnswerTop[mIndexTop].getAnswerTop();
        ansTop.setText(mTop);
        mBottom=mAnswerBottom[mIndexBottom].getAnswerBottom();
        ansBottom.setText(mBottom);
    }
    private void updateStoryBottom(){
        if(mIndexStory==0){
            mIndexStory=(mIndexStory+1)%mStoryLine.length;
            mIndexTop=(mIndexTop+1)%mAnswerTop.length;
            mIndexBottom=(mIndexBottom+1)%mAnswerBottom.length;
        }
        else{
            if(mIndexStory==1){
                mIndexStory=(mIndexStory+2)%mStoryLine.length;
            }
            else{
                if(mIndexStory==2){
                    mIndexStory=(mIndexStory+2)%mStoryLine.length;
                }
            }
        }
        mStory=mStoryLine[mIndexStory].getStoryId();
        storyTextView.setText(mStory);
        mTop=mAnswerTop[mIndexTop].getAnswerTop();
        ansTop.setText(mTop);
        mBottom=mAnswerBottom[mIndexBottom].getAnswerBottom();
        ansBottom.setText(mBottom);

    }
}
