package com.londonappbrewery.destini;

/**
 * Created by HOME on 06-08-2017.
 */

public class storyLine {
    private int mStoryId;
    public storyLine(int storyResourceId){
    mStoryId=storyResourceId;
    }
    public int getStoryId(){
        return mStoryId;
    }
    public void setStoryId(int storyId){
        mStoryId=storyId;
    }
}

