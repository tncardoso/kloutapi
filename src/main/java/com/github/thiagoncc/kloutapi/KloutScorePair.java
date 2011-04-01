/*
 * 
 * Copyright 2011 Thiago Cardoso
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.thiagoncc.kloutapi;

/**
 * Represents one klout score pair containing user name and klout
 * score. 
 */
public class KloutScorePair
{
    /** Twitter screen name of user */
    private String twitter_screen_name;
    /** Klout score */
    private double kscore;

    /**
     * Class constructor. Every information should be present for the
     * score pair construction.
     */
    public KloutScorePair (String twitter_screen_name, double kscore)
    {
        this.twitter_screen_name = twitter_screen_name;
        this.kscore = kscore;
    }

    /**
     * String representation of given score pair.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (twitter_screen_name == null) sb.append("null");
        else sb.append(this.twitter_screen_name);
        sb.append(" ");
        sb.append(this.kscore);
        return sb.toString();
    }
    
    public String getTwitterScreenName()
    {
        return twitter_screen_name;
    }
    
    public double getKscore()
    {
        return kscore;
    }
}
