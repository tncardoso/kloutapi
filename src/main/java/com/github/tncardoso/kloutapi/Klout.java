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

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;

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

    /*
     * Score methods
     */

    /**
     * Get Klout score for given users.
     * 
     * @param users
     *            List containing users screen names.
     */
    public List<KloutScorePair> klout(List<String> users)
        throws KloutException
    {
        try
        {
            /* Fetch Json response */
            JSONArray usersJson = new JSONArray(users);
            Map<String, String> post = new HashMap<String, String>();
            post.put("users", usersJson.toString());
            String response = fetcher.open(baseUrl + "/klout.json?key=" + key, post);

            /* Parse json response */
            return KloutParser.klout(response);
        }
        catch (IOException e)
        {
            throw new KloutException(e.getMessage());
        }
        catch (JSONException e)
        {
            throw new KloutException(e.getMessage());
        }
    }

    /**
     * Shortcut for retrieving one user's klout score.
     * 
     * @param user
     *            to retrieve klout score.
     * @return retrieved klout score.
     * @throws KloutException
     */
    public KloutScorePair klout(String user) throws KloutException
    {
        LinkedList<String> userlist = new LinkedList<String>();
        userlist.add(user);
        List<KloutScorePair> ret = klout(userlist);
        return ret.get(0);
    }

    /*
     * User methods
     */

    public List<KloutUser> show(List<String> users)
        throws KloutException
    {
        try
        {
            /* Fetch Json response */
            JSONArray usersJson = new JSONArray(users);
            Map<String, String> post = new HashMap<String, String>();
            post.put("users", usersJson.toString());
            String response = fetcher.open(baseUrl + "/users/show.json?key=" + key, post);

            /* Parse json response */
            return KloutParser.show(response);
        }
        catch (IOException e)
        {
            throw new KloutException(e.getMessage());
        }
        catch (JSONException e)
        {
            throw new KloutException(e.getMessage());
        }
    }

}
