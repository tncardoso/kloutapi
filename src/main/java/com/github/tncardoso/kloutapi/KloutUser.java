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

package com.github.tncardoso.kloutapi;

public class KloutUser
{
    /** User's id in twitter */
    private String twitter_id = null;
    /** User's screen name */
    private String twitter_screen_name = null;
    /** User's klout score */
    private Double kscore = null;
    /** Kscore slope */
    private Double slope = null;
    /** User description */
    private String description = null;
    /** klout class id */
    private Integer kclass_id = null;
    /** klout class name */
    private String kclass = null;
    /** klout class description */
    private String kclass_description = null;
    /** klout score description */
    private String kscore_description = null;
    /** user's network score */
    private Double network_score = null;
    /** user's amplification score */
    private Double amplification_score = null;
    /** user's true reach value */
    private Integer true_reach = null;
    /** klout delta in one day */
    private Double delta_1day = null;
    /** klout variation in 5 days */
    private Double delta_5day = null;

    /**
     * Construct new klout user.
     */
    public KloutUser()
    {
    }

    /**
     * String representation of given user.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (twitter_screen_name == null)
            sb.append("null");
        else
            sb.append(this.twitter_screen_name);
        sb.append(" ");
        if (kscore == null)
            sb.append("null");
        else
            sb.append(this.kscore);
        return sb.toString();
    }

    /* Getters and Setters */

    public void setTwitterId(String twitter_id)
    {
        this.twitter_id = twitter_id;
    }

    public String getTwitterId()
    {
        return this.twitter_id;
    }

    public void setTwitterScreenName(String twitter_screen_name)
    {
        this.twitter_screen_name = twitter_screen_name;
    }

    public String getTwitterScreenName()
    {
        return this.twitter_screen_name;
    }
    
    public void setKscore(double kscore)
    {
        this.kscore = kscore;
    }
    
    public Double getKscore()
    {
        return kscore;
    }

    public void setSlope(double slope)
    {
        this.slope = slope;
    }

    public Double getSlope()
    {
        return this.slope;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setKclassId(int kclass_id)
    {
        this.kclass_id = kclass_id;
    }

    public Integer getKclassId()
    {
        return this.kclass_id;
    }

    public void setKclass(String kclass)
    {
        this.kclass = kclass;
    }

    public String getKclass()
    {
        return this.kclass;
    }

    public void setKclassDescription(String kclass_description)
    {
        this.kclass_description = kclass_description;
    }

    public String getKclassDescription()
    {
        return this.kclass_description;
    }

    public void setKscoreDescription(String kscore_description)
    {
        this.kscore_description = kscore_description;
    }

    public String getKscoreDescription()
    {
        return this.kscore_description;
    }

    public void setNetworkScore(double network_score)
    {
        this.network_score = network_score;
    }

    public Double getNetworkScore()
    {
        return this.network_score;
    }

    public void setAmplificationScore(double amplification_score)
    {
        this.amplification_score = amplification_score;
    }

    public Double getAmplificationScore()
    {
        return this.amplification_score;
    }

    public void setTrueReach(int true_reach)
    {
        this.true_reach = true_reach;
    }

    public Integer getTrueReach()
    {
        return this.true_reach;
    }

    public void setDelta1day(double delta_1day)
    {
        this.delta_1day = delta_1day;
    }

    public Double getDelta1day()
    {
        return this.delta_1day;
    }

    public void setDelta5day(double delta_5day)
    {
        this.delta_5day = delta_5day;
    }

    public Double getDelta5day()
    {
        return this.delta_5day;
    }
}
