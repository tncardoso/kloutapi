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

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KloutParserTest
{
    /**
     * Simple test case for klout json parser.
     * 
     * @throws KloutException
     * @throws JSONException
     */
    @Test
    public void klout_simpleParse()
        throws JSONException,
            KloutException
    {
        String json = "{\"status\":200,\"users\":[{\"twitter_screen_name\":\"lfmendes\",\"kscore\":39.77},{\"twitter_screen_name\":\"tncardoso\",\"kscore\":94}]}";
        List<KloutUser> ret = KloutParser.klout(json);

        Assert.assertEquals(ret.get(0).getTwitterScreenName(), "lfmendes");
        Assert.assertEquals(ret.get(0).getKscore(), 39.77, 0.0000001);
        Assert.assertEquals(ret.get(1).getTwitterScreenName(), "tncardoso");
        Assert.assertEquals(ret.get(1).getKscore(), 94, 0.0000001);
    }

    /**
     * Test if different status is throwing exception.
     * 
     * @throws KloutException
     * @throws JSONException
     */
    @Test(expectedExceptions=KloutException.class)
    public void klout_wrongStatus()
        throws JSONException,
            KloutException
    {
        String json = "{\"status\":201,\"users\":[{\"twitter_screen_name\":\"lfmendes\",\"kscore\":39.77},{\"twitter_screen_name\":\"tncardoso\",\"kscore\":94}]}";
        KloutParser.klout(json);
    }
    
    /**
     * Test if show response is being correctly parsed.
     */
    @Test
    public void show_simpleParse()
        throws JSONException,
            KloutException
    {
        String json = "{\"status\":200,\"users\":[{\"twitter_id\":\"25360825\",\"twitter_screen_name\":\"lfmendes\",\"score\":{\"kscore\":39.77,\"slope\":0,\"description\":\"desc\",\"kclass_id\":4,\"kclass\":\"Explorer\",\"kclass_description\":\"kclass_desc\",\"kscore_description\":\"kscore_desc\",\"network_score\":47.89,\"amplification_score\":22.75,\"true_reach\":54,\"delta_1day\":-0,\"delta_5day\":-0.1}}]}";
        List<KloutUser> ret = KloutParser.show(json);

        Assert.assertEquals(ret.get(0).getTwitterId(), "25360825");
        Assert.assertEquals(ret.get(0).getTwitterScreenName(), "lfmendes");
        Assert.assertEquals(ret.get(0).getKscore(), 39.77, 0.0000001);
        Assert.assertEquals(ret.get(0).getSlope(), 0.0, 0.0000001);
        Assert.assertEquals(ret.get(0).getDescription(), "desc");
        Assert.assertEquals(ret.get(0).getKclassId(), new Integer(4));
        Assert.assertEquals(ret.get(0).getKclass(), "Explorer");
        Assert.assertEquals(ret.get(0).getKclassDescription(), "kclass_desc");
        Assert.assertEquals(ret.get(0).getKscoreDescription(), "kscore_desc");        
        Assert.assertEquals(ret.get(0).getNetworkScore(), 47.89, 0.0000001);
        Assert.assertEquals(ret.get(0).getAmplificationScore(), 22.75, 0.0000001);
        Assert.assertEquals(ret.get(0).getTrueReach(), new Integer(54));
        Assert.assertEquals(ret.get(0).getDelta1day(), -0.0, 0.0000001);
        Assert.assertEquals(ret.get(0).getDelta5day(), -0.1, 0.0000001);
    }


}
