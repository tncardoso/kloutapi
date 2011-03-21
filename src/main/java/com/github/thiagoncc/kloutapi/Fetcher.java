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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

/**
 * HTTP communication handler.
 */
public class Fetcher
{    
    /**
     * Class constructor.
     */
    public Fetcher()
    {
    }
    
    /**
     * Http Post to given URL.
     * @param url Url to be fetched.
     * @param post Vars to be posted.
     * @return Retrieved page content.
     * @throws IOException 
     */
    public String open(String url, Map<String,String> post) throws IOException
    {
        StringBuilder data = new StringBuilder();
        
        /* Build POST string */
        boolean first = true;
        for (Entry<String, String> entry : post.entrySet())
        {
            if (first)
            {
                first = false;
            }
            else
            {
                data.append("&");
            }
            
            data.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        System.out.println("Data: " + data.toString());
        
        StringBuilder out = new StringBuilder();
        URL neturl = new URL(url);
        URLConnection conn = neturl.openConnection();
        
        /* Connection parameters */
        conn.setDoOutput(true);
        
        /* Write POST data */
        OutputStreamWriter postWriter = new OutputStreamWriter(conn.getOutputStream());
        postWriter.write(data.toString());
        postWriter.flush();
        postWriter.close();

        /* Read response */
        BufferedReader response = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = response.readLine()) != null) {
            out.append(line);
        }
        response.close();
        
        return out.toString();
    }
}
