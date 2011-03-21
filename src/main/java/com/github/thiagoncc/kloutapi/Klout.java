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

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Klout
{
    /** Klout's base url */
    private final String baseUrl = "http://api.klout.com/1";

    /**
     * Needed key for API usage. For registering a new key go to:
     * http://developer.klout.com/
     */
    private String key = null;

    /**
     * Http connections administrator.
     */
    private Fetcher fetcher = null;

    /**
     * Class constructor.
     * 
     * @param key
     *            Klout API private key.
     */
    public Klout(String key)
    {
        this.key = key;
        this.fetcher = new Fetcher();
    }

    /**
     * Get Klout score for given users.
     * 
     * @param users
     *            List containing users screen names.
     */
    public List<KloutUser> klout(List<String> users)
        throws KloutException
    {
        try
        {
            /* Fetch Json response */
            JSONArray usersJson = new JSONArray(users);
            Map<String, String> post = new HashMap<String, String>();
            post.put("users", usersJson.toString());
            String response = fetcher.open(baseUrl + "/klout.json?key=" + key, post);
            System.out.println(response);

            /* Unmarshal json response */
            JSONObject respJson = new JSONObject(response);

            int status = respJson.getInt("status");
            if (status != 200) { throw new KloutException("Status error: " + status); }

            List<KloutUser> ret = new Vector<KloutUser>();
            JSONArray usersScore = respJson.getJSONArray("users");
            for (int i = 0; i < usersScore.length(); i++)
            {
                JSONObject cUser = usersScore.getJSONObject(i);
                KloutUser ku = new KloutUser(cUser.getString("twitter_screen_name"),
                                               cUser.getDouble("kscore"));
                ret.add(ku);
            }
            
            return ret;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new KloutException(e.getMessage());
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            throw new KloutException(e.getMessage());
        }
    }
}
