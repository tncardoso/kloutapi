/*
 
   Copyright 2011 Thiago Cardoso                                                                                

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and 
   limitations under the License.

 */

package com.github.thiagoncc.kloutapi;

public class KloutUser
{
    /** User's screen name */
    private String screenName = null;
    /** User's klout score */
    private double score = 0.0;

    /**
     * Construct new klout user.
     * 
     * @param screenName
     *            Screen name of given user.
     * @param score
     *            Score of given user.
     */
    public KloutUser(String screenName, double score)
    {
        this.screenName = screenName;
        this.score = score;
    }

    /**
     * Get user's screen name.
     * 
     * @return Screen name.
     */
    public String getScreenName()
    {
        return this.screenName;
    }

    /**
     * Get current user's klout score.
     * 
     * @return Klout Score.
     */
    public double getKloutScore()
    {
        return score;
    }

    /**
     * String representation of given user.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.screenName);
        sb.append(" ");
        sb.append(this.score);
        return sb.toString();
    }
}
