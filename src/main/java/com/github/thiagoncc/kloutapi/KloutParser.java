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

import java.util.List;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class containing methods used for parsing klout responses.
 */
public class KloutParser
{
    /**
     * Parse klout json response.
     * 
     * @param json
     *            content of the klout response
     * @return list containing users and respective klout scores
     * @throws JSONException
     * @throws KloutException
     */
    public static List<KloutUser> klout(String json)
        throws JSONException,
            KloutException
    {
        JSONObject respJson = new JSONObject(json);

        int status = respJson.getInt("status");
        if (status != 200) { throw new KloutException("Status error: " + status); }

        List<KloutUser> ret = new Vector<KloutUser>();
        JSONArray usersScore = respJson.getJSONArray("users");
        for (int i = 0; i < usersScore.length(); i++)
        {
            JSONObject cUser = usersScore.getJSONObject(i);
            KloutUser ku = new KloutUser();
            ku.setTwitterScreenName(cUser.getString("twitter_screen_name"));
            ku.setKscore(cUser.getDouble("kscore"));
            ret.add(ku);
        }
        return ret;
    }

    /**
     * Parse user show response and return klout user objects.
     * 
     * @param json
     *            content to be parsed
     * @return list containing klout users
     * @throws JSONException
     * @throws KloutException
     */
    public static List<KloutUser> show(String json)
        throws JSONException,
            KloutException
    {
        JSONObject respJson = new JSONObject(json);

        int status = respJson.getInt("status");
        if (status != 200) { throw new KloutException("Status error: " + status); }

        List<KloutUser> ret = new Vector<KloutUser>();
        JSONArray usersScore = respJson.getJSONArray("users");
        for (int i = 0; i < usersScore.length(); i++)
        {
            JSONObject cUser = usersScore.getJSONObject(i);
            KloutUser ku = new KloutUser();
            ku.setTwitterId(cUser.getString("twitter_id"));
            ku.setTwitterScreenName(cUser.getString("twitter_screen_name"));
            JSONObject score = cUser.getJSONObject("score");
            ku.setKscore(score.getDouble("kscore"));
            ku.setSlope(score.getDouble("slope"));
            ku.setDescription(score.getString("description"));
            ku.setKclassId(score.getInt("kclass_id"));
            ku.setKclass(score.getString("kclass"));
            ku.setKclassDescription(score.getString("kclass_description"));
            ku.setKscoreDescription(score.getString("kscore_description"));
            ku.setNetworkScore(score.getDouble("network_score"));
            ku.setAmplificationScore(score.getDouble("amplification_score"));
            ku.setTrueReach(score.getInt("true_reach"));
            ku.setDelta1day(score.getDouble("delta_1day"));
            ku.setDelta5day(score.getDouble("delta_5day"));
            ret.add(ku);
        }
        return ret;
    }
}
